package lmp.admin.menu.book;

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

import lmp.db.dao.BookDao;
import lmp.db.vo.BookVO;

public class BookMgmt extends JFrame {

	// 패널의 열 수는 검색된 정보 수에 따라 다르게 설정 가능
	static String[] category = { "등록번호","제목", "저자", "출판사", "ISBN","위치" };
	static String[] bookColumn = {"등록번호","제목", "저자", "출판사", "ISBN", "편권수", "복권수" , "등록일", "가격","위치","비고"};
//	static String[][] contents = {
//			{ "노인과 바다", "어니스트 헤밍웨이", "타임주니어", "9788928637843", "1", "1", "2017/01/20", "12000", "토평아동실", " " },
//			{ "노인과 바다", "어니스트 헤밍웨이", "빈빈책방", "9791196278045", "1", "1", "2018/01/22", "11000", "토평아동실", " " },
//			{ "노인과 바다 : 어니스트 헤밍웨이 소설", "어니스트 헤밍웨이", "문학동네", "9788954609012", "1", "1", "2012/01/20", "8000", "토평종합자료실",
//					" " },
//			{ "어린왕자", "생텍쥐페리", "한국몬테소리", "8983112565", "1", "1", "2002/01/25", "10840", "토평보존서고", " " },
//			{ "어린왕자", "앙투안 드 생텍쥐페리", "노마드", "9791186288139", "1", "1", "2015/01/25", "12000", "토평종합자료실", " " },
//			{ "죄와 벌. 1", "표도르 도스토옙스키", "문학동네", "9788954671774", "1", "1", "2020/01/10", "13500", "토평종합자료실", " " },
//			{ "죄와 벌. 2", "표도르 도스토옙스키", "문학동네", "9788954671781", "1", "1", "2020/01/10", "13500", "토평종합자료실", " " },
//			{ "죄와 벌", "도스토예프스키", "지경사", "9788931911534", "1", "1", "2021/01/12", "5500", "토평아동실", " " },
//			{ "템테이션", "더글라스 케네디", "밝은세상", "9788984371170", "1", "1", "2012/01/02", "13500", "토평종합자료실", " " },
//			{ "상실의 시대", "무라카미 하루키", "문학사상사", "8970123695", "1", "1", "2000/01/20", "7800", "토평보존서고", " " },
//			{ "상실의 시대 : 무라카미 하루키 장편소설", "무라카미 하루키 ", "문학사상사", "9788970123691", "1", "1", "2009/01/02", "15000",
//					"토평종합자료실", " " }, };

	static DefaultTableModel model = new DefaultTableModel(bookColumn, 30) {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	
	static BookDao bookDao = new BookDao();
	static ArrayList<BookVO> bookVO;
	// 도서현황 검색 창 초기화면 테이블
	JTable table = new JTable(model);
	
	public static JButton getButton(String text) {
		return new JButton() {
			{
				setText(text);
				setBackground(Color.PINK);
				setBorderPainted(false);
				setFocusPainted(false);
				setContentAreaFilled(false);
				setFont(new Font(null, Font.BOLD, 18));
				setVerticalTextPosition(JButton.CENTER);
				setHorizontalTextPosition(JButton.RIGHT);
				setForeground(Color.WHITE);
				addMouseListener(new MouseAdapter() {
					// 버튼에 마우스 올리면 배경색 변경
					@Override
					public void mouseEntered(MouseEvent e) {
						// setFocusPainted(true);
						setContentAreaFilled(true);
					}

					// 버튼에서 마우스 떼면 배경색 투명
					@Override
					public void mouseExited(MouseEvent e) {
						// setFocusPainted(false);
						setContentAreaFilled(false);
					}
				});
			}
		};
	}

	public static void main(String[] args) throws IOException {

		// 전체 프로그램의 메인 프레임 선언(분홍색 JFrame)
		BookMgmt bookMgmtframe = new BookMgmt();
		bookMgmtframe.setTitle("Library - Mangement - Program");
		// bookMgmtframe.setBackground(new Color(42,64,61));
		bookMgmtframe.getContentPane().setBackground(new Color(42, 64, 61));
		bookMgmtframe.setLayout(null);

		// (도서관리 탭 클릭시 열리는) 검색결과 출력되는 패널 선언
		JPanel bookMgmt = new JPanel();
		bookMgmt.setBounds(17, 200, 1150, 550);
		bookMgmt.setBackground(new Color(87, 119, 119));
		bookMgmt.setLayout(null);

		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 156, 1152, 395);
		scroll.setBackground(new Color(87, 119, 119));
		bookMgmt.add(scroll);

		// 도서검색 라벨 선언
		JLabel label = new JLabel("도서검색");
		label.setBounds(540, 20, 200, 50);
		label.setFont(new Font(null, Font.BOLD, 22));
		label.setForeground(Color.WHITE);

		// 도서검색 콤보박스 선언
		JComboBox cb = new JComboBox(category);
		cb.setBounds(230, 80, 110, 30);
		cb.setFont(new Font(null, Font.BOLD, 15));

		// 도서검색 텍스트필드 선언
		JTextField textF = new JTextField(" 검색어를 입력하세요.");
		textF.setBounds(390, 80, 400, 30);

		// 텍스트필드 옆 검색 버튼 선언
		JButton button = new JButton("검색");
		button.setBounds(840, 80, 100, 30);
		button.setFont(new Font(null, Font.BOLD, 18));
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*
				int index = 0;
				for (int i = 0; i < category.length; ++i) {
					if (category[i].equals(cb.getSelectedItem())) {
						index = i;
					}
				}

				// DB에서 도서 정보 테이블 컬럼, 도서 정보 가져와서 category, contents에 넣어야 함
				String[][] valid = new String[50][category.length];
				
				
				int index2 = 0;
				for (int i = 0; i < contents.length; ++i) {
					if (contents[i][index].contains(textF.getText())) {
						valid[index2++] = contents[i];
					}
				}
				model.setRowCount(valid.length);

				for (int i = 0; i < valid.length; ++i) {
					for (int j = 0; j < category.length; ++j) {
						model.setValueAt(valid[i][j], i, j);
					}
				}
				table.setModel(model);

				bookMgmt.add(scroll);
				bookMgmt.validate();
				textF.setText("");
				*/
				
				try {
					bookVO = new ArrayList<>();
					
		               bookVO.clear();
		               bookVO.addAll(bookDao.get(cb.getSelectedIndex() + 1, textF.getText()));
		            } catch (SQLException e1) {
		               e1.printStackTrace();
		            }
		            
		            model.setRowCount(bookVO.size());
		            model.setColumnIdentifiers(bookColumn);
		            
		            int resetRow = 0;
		            for (BookVO book : bookVO) {
		               for (int i = 0; i < book.getList().length; ++i) {
		                  
		                  model.setValueAt(book.getList()[i], resetRow, i);
		               }
		               ++resetRow;
		            }
		            table.setModel(model);
		            scroll.validate();
		            bookMgmt.validate();
		            bookMgmtframe.validate();				
			}
		});

		textF.addMouseListener(new MouseAdapter() { // 검색 텍스트필드 안에 마우스 클릭 시 안내문구 삭제
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (textF.getText().equals(" 검색어를 입력하세요.")) {					
					textF.setText("");
				}				
			}
		});

		textF.addActionListener(new ActionListener() { // 검색버튼 클릭 시 작동기능
			@Override
			public void actionPerformed(ActionEvent e) {
				button.doClick();
			}
		});

		// 도서등록 버튼 선언
		BufferedImage bfi_registration = ImageIO
				.read(new File("src\\lmp\\admin\\menu\\book\\images\\bookregisterIconImage.png"));
		Image image_registration = bfi_registration.getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING);

		JButton registration = getButton(" 등록");
		registration.setIcon(new ImageIcon(image_registration));
		registration.setBounds(1020, 10, 120, 40);
		registration.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(bookMgmtframe, "도서등록 화면으로 이동합니다.");
				// new BookRegistration("화면등록");
				new BookRegistration("화면등록");
			}
		});
		bookMgmt.add(registration);

		// 내용삭제 버튼 선언
		BufferedImage bfi_delete = ImageIO
				.read(new File("src\\lmp\\admin\\menu\\book\\images\\bookdeleteIconImage.png"));
		Image image_delete = bfi_delete.getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING);

		JButton delete = getButton(" 삭제");
		delete.setIcon(new ImageIcon(image_delete));
		delete.setBounds(1020, 60, 120, 40);
		// delete.setFont(new Font(null, Font.BOLD, 18));
		// delete.setText(" 삭제");
		// delete.setVerticalTextPosition(JButton.CENTER);
		// delete.setHorizontalTextPosition(JButton.RIGHT);
		// delete.setForeground(Color.WHITE);
		// delete.setBackground(Color.RED);
		// delete.setBorderPainted(false);
		// delete.setFocusPainted(false);
		// delete.setContentAreaFilled(false);
		// delete.setForeground(Color.WHITE);
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					int num = JOptionPane.showConfirmDialog(bookMgmtframe, "선택한 도서정보\n정말로 삭제하시겠습니까?", "선택도서 삭제", JOptionPane.YES_NO_OPTION);
					// Yes -> 0 No -> 1 을 반환함
					switch (num) {
					case 0:
						try {
						
						int book_id = (int)(model.getValueAt(table.getSelectedRow(), 0));
						
							bookDao.delete(book_id);
							
							
							bookVO = new ArrayList<>();
							
				            bookVO.clear();
				            bookVO.addAll(bookDao.get(cb.getSelectedIndex() + 1, textF.getText()));
				            model.setRowCount(bookVO.size());
				            model.setColumnIdentifiers(bookColumn);
				            
				            int resetRow = 0;
				            for (BookVO book : bookVO) {
				               for (int i = 0; i < book.getList().length; ++i) {
				                  
				                  model.setValueAt(book.getList()[i], resetRow, i);
				               }
				               ++resetRow;
				            }
				            table.setModel(model);
				            scroll.validate();
				            bookMgmt.validate();
				            bookMgmtframe.validate();
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
//						BookDao bookDao = new BookDao();
//						ArrayList<BookVO> bookVO = new ArrayList<>();
//						try {
//							bookVO.clear();
//							bookVO.addAll(bookDao.get(1, String.valueOf(table.getValueAt(table.getSelectedRow(), 0))));
//							bookDao.delete(bookVO.get(0));
//						} catch (SQLException e1) {
//							e1.printStackTrace();
//						}						
						bookMgmt.validate();
						JOptionPane.showMessageDialog(bookMgmtframe, "선택한 도서를 삭제했습니다. 다시 되돌릴 수 없습니다.");
						break;
					case 1:
						JOptionPane.showMessageDialog(bookMgmtframe, "취소합니다.");
						break;
					}
				}
			}
		});
		bookMgmt.add(delete);

		// 정보수정 버튼 선언
		BufferedImage bfi_modification = ImageIO
				.read(new File("src\\lmp\\admin\\menu\\book\\images\\bookModifyIconImage.png"));
		Image image_modification = bfi_modification.getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING);

		JButton modification = getButton(" 수정");
		modification.setIcon(new ImageIcon(image_modification));
		modification.setBounds(1020, 110, 120, 40);
		modification.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedRow() != -1) {
						BookModification bookmodification = new BookModification("정보수정");
					for (int i = 1; i < model.getColumnCount(); i++) {
						bookmodification.model.setValueAt(model.getValueAt(table.getSelectedRow(), i), 0, i - 1);
						bookmodification.comebackList[i - 1] = String.valueOf(model.getValueAt(table.getSelectedRow(), i));
						
						if(bookmodification.comebackList[i - 1]==null) {
//						bookmodification.comebackList[i - 1] = String.valueOf(model.getValueAt(table.getSelectedRow(), i));
//						bookmodification.comebackList[9] = null;						
//						bookmodification.model.setValueAt("", 0, i-1);
						}
					}
					bookmodification.table.setModel(bookmodification.model);
				}
			}
		});
		bookMgmt.add(modification);

		bookMgmt.add(label);
		bookMgmt.add(cb);
		bookMgmt.add(textF);
		bookMgmt.add(button);

		bookMgmtframe.add(bookMgmt);
		bookMgmtframe.setBounds(300, 100, 1200, 800);
		bookMgmtframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bookMgmtframe.setVisible(true);
	}
}
