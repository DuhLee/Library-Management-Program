package lmp.admin.menu.checkin_out;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import lmp.admin.AdminFrame;
import lmp.admin.dao.BookDao;
import lmp.admin.dao.CheckOutDao;
import lmp.admin.menu.book.BookMgmt;
import lmp.admin.vo.BookVO;
import lmp.admin.vo.CheckOutVO;

public class CheckIn_Out_Frame extends JFrame{

	JFrame frame = this;
	
	JPanel checkPanel;
	JLabel checkedOutLabel;
	JTable checkedOutTable, checkOutTable;
	JScrollPane checkedOutPane, checkOutPane;
	JButton checkInButton, searchbutton, checkOutButton;
	JLabel checkInLabel;
	JComboBox keyword;
	JTextField searchField;
	
	
	//	table.getValueAt(table.getSelectedRow(), 0)
	// 위 코드로 회원번호 뽑아서 DB에서 해당 회원번호에 맞는 정보 가져와서 출력 아래 배열에 저장
	String[] checkedOutCategory = {"대출번호", "도서 등록번호", "도서명", "저자", "대출 일자", "반납 예정일"};
	
	String[] category = {"등록번호", "도서명", "저자", "출판사", "ISBN", "편권수", "복권수", "도서 등록일", "가격", "위치", "비고"};
	
	String[] keywordList = {"등록번호", "도서명", "저자", "출판사", "ISBN", "위치"};
	
	DefaultTableModel checkOutModel = new DefaultTableModel(category, 7) {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	
	DefaultTableModel checkedOutModel = new DefaultTableModel(checkedOutCategory, 3) {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	CheckOutDao checkOutDao = new CheckOutDao();
	BookDao bookDao = new BookDao();
	
	// 해당 회원의 대여 내역
	ArrayList<CheckOutVO> checkedOutList = new ArrayList<>();
	// 전체 회원의 대여 내역
	ArrayList<CheckOutVO> checkedOutRecord = new ArrayList<>();
	ArrayList<BookVO> bookList = new ArrayList<>();
	
	public CheckIn_Out_Frame(String memberNum) {
		setTitle("회원 대출 관리");
		
		checkOutTable = AdminFrame.getTable(checkOutModel);
		checkOutPane = new JScrollPane(checkOutTable);
		checkOutPane.setBounds(0, 300, 986, 184);
		

		checkPanel = new JPanel();
		checkPanel.setLayout(null);
		
		checkedOutLabel = new JLabel("대출 목록");
		checkedOutLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 20));
		checkedOutLabel.setHorizontalAlignment(JLabel.CENTER);
		checkedOutLabel.setBounds(440, 10, 100, 50);
		checkedOutLabel.setForeground(Color.WHITE);
		
		
		getCheckedOutList(memberNum);
		
		
		checkedOutTable = AdminFrame.getTable(checkedOutModel);
		checkedOutPane = new JScrollPane(checkedOutTable);
		checkedOutPane.setBounds(0, 70, 986, 98);
		
		
		checkInButton = AdminFrame.getButton("반납");
		checkInButton.setBounds(850, 168, 100, 30);
		checkInButton.setForeground(Color.WHITE);
		checkInButton.setBackground(Color.LIGHT_GRAY);
		checkInButton.setFocusPainted(false);
		checkInButton.setContentAreaFilled(false);
		checkInButton.setFont(new Font("한컴 말랑말랑 Regular",Font.BOLD, 15));
		checkInButton.setVerticalTextPosition(JButton.CENTER);
		checkInButton.setHorizontalTextPosition(JButton.RIGHT);
		checkInButton.addMouseListener(new MouseAdapter() {
			// 버튼에 마우스 올리면 배경색 변경
			@Override
			public void mouseEntered(MouseEvent e) {
				// setFocusPainted(true);
				checkInButton.setContentAreaFilled(true);
			}

			// 버튼에서 마우스 떼면 배경색 투명
			@Override
			public void mouseExited(MouseEvent e) {
				// setFocusPainted(false);
				checkInButton.setContentAreaFilled(false);
			}
		});
		
		
		
		// 반납 버튼을 누르면 DB에 존재하는 해당 등록번호의 도서 정보 업데이트
		checkInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 선택한 항목이 없거나 선택한 항목이 빈 행이면 안내문구 출력
				if (checkedOutTable.getSelectedRow() != -1 &&
					checkedOutTable.getValueAt(checkedOutTable.getSelectedRow(), 0) != null) {
					
					// 반납 버튼 누른 후 한 번 확인
					int num = JOptionPane.showConfirmDialog(frame,
															"반납하시겠습니까?",
															"반납 확인",
															JOptionPane.YES_NO_OPTION);
					switch (num) {
						case 0 :
							try {
								checkOutDao.update(checkedOutList.get(checkedOutTable.getSelectedRow()));
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(
									frame, String.format(
											"대출번호 : %s\n\t반납 완료",
											checkedOutTable.getValueAt(checkedOutTable.getSelectedRow(), 0)));
							BookMgmt.tableValidate();
							break;
						case 1 :
							JOptionPane.showMessageDialog(frame, "취소되었습니다.");
							return;
					}
					
					getCheckedOutList(memberNum);
					// 대여 목록 테이블 초기화 (초기화 과정 없이 위쪽의 도서를 반납처리 하면 리스트의 길이가 줄어들어 아래쪽 도서가 남아있는 오류 발생)
					checkedOutModel.setRowCount(0);
					checkedOutModel.setRowCount(3);
					
					int rowCount = 0;
					for (CheckOutVO checkedList : checkedOutList) {
						for (int i = 0; i < checkedOutCategory.length; ++i) {
							checkedOutModel.setValueAt(checkedList.getList()[i], rowCount, i);
						}
						++rowCount;
					}
					checkedOutTable.setModel(checkedOutModel);
					checkedOutPane.validate();
					
				} else {
					JOptionPane.showMessageDialog(frame, "반납할 도서를 선택해주세요.");
				}
			}
		});
		
		
		checkInLabel = new JLabel("대출 희망 도서 검색");
		checkInLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 20));
		checkInLabel.setHorizontalAlignment(JLabel.CENTER);
		checkInLabel.setBounds(390, 200, 200, 50);
		checkInLabel.setForeground(Color.WHITE);
		
		
		keyword = new JComboBox(keywordList);
		keyword.setFont(new Font(null, Font.PLAIN, 12));
		keyword.setBounds(280, 250, 100, 30);
		
		searchbutton = AdminFrame.getButton("검색");
		searchbutton.setBounds(720, 250, 100, 30);
		searchbutton.setForeground(Color.WHITE);
		searchbutton.setBackground(Color.LIGHT_GRAY);
		searchbutton.setFocusPainted(false);
		searchbutton.setContentAreaFilled(false);
		searchbutton.setFont(new Font("한컴 말랑말랑 Regular",Font.BOLD, 15));
		searchbutton.setVerticalTextPosition(JButton.CENTER);
		searchbutton.setHorizontalTextPosition(JButton.RIGHT);
		searchbutton.addMouseListener(new MouseAdapter() {
			// 버튼에 마우스 올리면 배경색 변경
			@Override
			public void mouseEntered(MouseEvent e) {
				// setFocusPainted(true);
				searchbutton.setContentAreaFilled(true);
			}

			// 버튼에서 마우스 떼면 배경색 투명
			@Override
			public void mouseExited(MouseEvent e) {
				// setFocusPainted(false);
				searchbutton.setContentAreaFilled(false);
			}
		});
		
//		try {
//			BufferedImage buffer = ImageIO.read(new File("src/lmp/admin/menuButtonImages/searchButtonIcon.png"));
//			Image image = buffer.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//			searchbutton.setIcon(new ImageIcon(image));
//		} catch (IOException e2) {
//			e2.printStackTrace();
//		}
		
		
		// 텍스트 필드에서 엔터 누르면 버튼 클릭되도록 액션 추가 (검색 버튼 눌러도 되고 텍스트 필드에서 엔터 눌러도 검색됨)
		searchField = new JTextField();
		searchField.setText("검색어를 입력하세요");
		searchField.setBorder(null);
		searchField.setForeground(Color.LIGHT_GRAY);
		searchField.setBounds(400, 250, 300, 30);
		searchField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchField.setText("");
			}
		});
		// 텍스트 필드에서 엔터 누르면 버튼 클릭되도록 액션 추가 (검색 버튼 눌러도 되고 텍스트 필드에서 엔터 눌러도 검색됨)
		searchField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchbutton.doClick();
			}
		});		
		
		
		
		searchbutton = AdminFrame.getButton("검색");
		searchbutton.setBounds(720, 250, 100, 30);
		searchbutton.setForeground(Color.WHITE);
		searchbutton.setBackground(Color.LIGHT_GRAY);
		searchbutton.setFocusPainted(false);
		searchbutton.setContentAreaFilled(false);
		searchbutton.setFont(new Font("한컴 말랑말랑 Regular",Font.BOLD, 15));
		searchbutton.setVerticalTextPosition(JButton.CENTER);
		searchbutton.setHorizontalTextPosition(JButton.RIGHT);
		searchbutton.addMouseListener(new MouseAdapter() {
			// 버튼에 마우스 올리면 배경색 변경
			@Override
			public void mouseEntered(MouseEvent e) {
				// setFocusPainted(true);
				searchbutton.setContentAreaFilled(true);
			}

			// 버튼에서 마우스 떼면 배경색 투명
			@Override
			public void mouseExited(MouseEvent e) {
				// setFocusPainted(false);
				searchbutton.setContentAreaFilled(false);
			}
		});
		
		
		
		checkOutButton = AdminFrame.getButton("대출");
		checkOutButton.setForeground(Color.WHITE);
		checkOutButton.setBackground(Color.LIGHT_GRAY);
		checkOutButton.setFocusPainted(false);
		checkOutButton.setContentAreaFilled(false);
		checkOutButton.setFont(new Font("한컴 말랑말랑 Regular",Font.BOLD, 15));
		checkOutButton.setVerticalTextPosition(JButton.CENTER);
		checkOutButton.setHorizontalTextPosition(JButton.RIGHT);
		checkOutButton.setBounds(850, 490, 100, 30);
		
		checkOutButton.addMouseListener(new MouseAdapter() {
			// 버튼에 마우스 올리면 배경색 변경
			@Override
			public void mouseEntered(MouseEvent e) {
				// setFocusPainted(true);
				checkOutButton.setContentAreaFilled(true);
			}

			// 버튼에서 마우스 떼면 배경색 투명
			@Override
			public void mouseExited(MouseEvent e) {
				// setFocusPainted(false);
				checkOutButton.setContentAreaFilled(false);
			}
		});
		
		// 버튼을 누르면 VO에 들어있는 현재 회원의 정보, 해당 도서의 정보 업데이트
		
		searchbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				int index = 0;
//				for (int i = 0; i < category.length; ++i) {
//					if (category[i].equals(keyword.getSelectedItem())) {
//						index = i;
//					}
//				}
				
				// DB에서 도서 정보 테이블 컬럼, 도서 정보 가져와서 category, contents에 넣어야 함
//				String[][] valid = new String[50][category.length];
//				int index2 = 0;
//				for (int i = 0; i < contents.length; ++i) {
//					if (contents[i][index].contains(searchField.getText())) {
//						valid[index2++] = contents[i];
//					}
//				}
//				model.setRowCount(valid.length);
//				
//				for (int i = 0; i < valid.length; ++i) {
//					for (int j = 0; j < category.length; ++j) {
//						model.setValueAt(valid[i][j], i, j);
//					}
//				}
				
				
				try {
					bookList.clear();
					bookList.addAll(bookDao.get(keyword.getSelectedIndex() + 1, searchField.getText()));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				checkOutModel.setColumnIdentifiers(category);
				checkOutModel.setRowCount(bookList.size());
				
				int num = 0;
				for (BookVO list : bookList) {
					for (int i = 0; i < list.getList().length; ++i) {
						checkOutModel.setValueAt(list.getList()[i], num, i);
					}
					++num;
				}
				checkOutTable.setModel(checkOutModel);
				checkPanel.validate();
				
				checkOutButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						// 선택된 행이 없거나 정보가 없는 행 선택 후 대출버튼 누르면 안내문구 출력
						if (checkOutTable.getSelectedRow() == -1 || checkOutModel.getValueAt(checkOutTable.getSelectedRow(), 0) == null) {
							JOptionPane.showMessageDialog(null, "대출할 도서를 선택해주세요.");
							return;
						}
						// 연체 중인 도서 있으면 안내문구 띄우고 대출 안되게 설정
						// 회원의 대여 목록을 확인하며 반납 예정일이 지났다면 안내문구 출력
						for (CheckOutVO list : checkedOutList) {
							// 반납 예정일이 오늘보다 먼저인가?
							if (LocalDate.parse((list.getExpectReturnDate()),
									DateTimeFormatter.ofPattern("yy/MM/dd")).compareTo(LocalDate.now()) < 0) {
								JOptionPane.showMessageDialog(frame, "연체 중인 도서가 존재합니다.");
								return;
							}
						}
						
						// 이미 대출된 도서 대출 안되게 거르기
						try {
							// 선택된 도서의 대여 기록 뽑아오기
							checkedOutRecord = checkOutDao.get(bookList.get(checkOutTable.getSelectedRow()).getId());
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
						// 선택된 도서의 대여 기록을 확인하며 반납일이 없는 (미반납 상태인) 대여 기록이 있다면 안내문구 출력
						for (CheckOutVO list : checkedOutRecord) {
							if (list.getCheckInDate() == null) {
								JOptionPane.showMessageDialog(frame, "대여 중인 도서입니다.");
								return;
							}
						}
						
						// 대출내역 정보가 3건 이상이면 풀대출 안내문구 출력
						if (checkedOutList.size() == 3) {
							JOptionPane.showMessageDialog(frame, "대출 불가능 (풀대출)");
							return;
						}
						
						if (checkOutTable.getValueAt(checkOutTable.getSelectedRow(), 0) != null) {
							try {
								checkOutDao.add(bookList.get(checkOutTable.getSelectedRow()),
										memberNum);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							getCheckedOutList(memberNum);
							JOptionPane.showMessageDialog(frame, String.format("등록번호 : %s\n\t대출 완료",
									checkOutTable.getValueAt(checkOutTable.getSelectedRow(), 0)));
							BookMgmt.tableValidate();
						} else {
							JOptionPane.showMessageDialog(frame, "대출할 도서를 선택해주세요.");							
						}
						// 대출 버튼 클릭시 해당 도서가 대출 목록의 빈 행에 들어가도록 빈 행 찾는 코드
						int emptyRow = 0;
						for (int i = 0; i < checkedOutTable.getRowCount(); ++i) {
							if (checkedOutTable.getValueAt(i, 0) == null) {
								emptyRow = i;
								break;
							}
						}
//							for (int i = 0; i < category.length; ++i) {
//								checkedOutTable.setValueAt(checkOutTable.getValueAt(checkOutTable.getSelectedRow(), i), emptyRow, i);
//								checkPanel.validate();
//							}
						
					}
				});
			}
		});
		
		checkPanel.add(checkedOutLabel);
		checkPanel.add(checkedOutPane);
		checkPanel.add(checkInButton);
		checkPanel.add(checkInLabel);
		checkPanel.add(keyword);
		checkPanel.add(searchField);
		checkPanel.add(searchbutton);
		checkPanel.add(checkOutButton);
		checkPanel.add(checkOutPane);
		checkPanel.setBackground(Color.GRAY);
		

		add(checkPanel);
		setBounds(500, 200, 1000, 600);
		setResizable(false);
		setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	public void getCheckedOutList(String memberNum) {
		try {
			checkedOutList.clear();
			checkedOutList.addAll(checkOutDao.get(3, memberNum));
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
		
		int num = 0;
		if (checkedOutList.size() > 0) {
			for (CheckOutVO list : checkedOutList) {
				for (int i = 0; i < list.getList().length; ++i) {
					checkedOutModel.setValueAt(list.getList()[i], num, i);
				}
				++num;
			}
		}
	}
	
	public void bookSearchTableValidate() {
		try {
			bookList.clear();
			bookList.addAll(bookDao.get(keyword.getSelectedIndex() + 1, searchField.getText()));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		checkOutModel.setColumnIdentifiers(category);
		checkOutModel.setRowCount(bookList.size());
		
		int num = 0;
		for (BookVO list : bookList) {
			for (int i = 0; i < list.getList().length; ++i) {
				checkOutModel.setValueAt(list.getList()[i], num, i);
			}
			++num;
		}
		checkOutTable.setModel(checkOutModel);
		checkPanel.validate();
	}
	
}
