package lmp.admin.menu.member;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

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
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import lmp.admin.AdminFrame;
import lmp.admin.menu.book.BookMgmt;
import lmp.admin.dao.CheckOutDao;
import lmp.admin.dao.MemberDao;
import lmp.admin.dao.MenuDao;
import lmp.admin.vo.CheckOutVO;
import lmp.admin.vo.MemberVO;
import lmp.util.Validator;

public class MemberMgmt extends JPanel {

	// JTable 구성품 
	String[] header = {"회원번호", "이름", "아이디", "생년월일", "성별", "전화번호", "이메일", "주소",
			"등록일", "비고"};
	DefaultTableModel model = new DefaultTableModel(header, 30) {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	JTable table;
	JScrollPane scroll;
	
	Validator vd = new Validator();

	public MemberMgmt() {

		JLabel memberInquiry = new JLabel("회원 조회"); // 회원조회글씨
		JTextField searchField = new JTextField(); // 검색창	
		JButton searchBtn = AdminFrame.getButton("검색"); // 검색버튼
		JButton changeBtn = BookMgmt.getButton("수정"); // 수정버튼
		JButton deleteBtn = BookMgmt.getButton("삭제"); // 삭제버튼
		JButton resetPasswordBtn = new JButton("비밀번호 초기화");

		// 회원조회 타이틀 설정
		memberInquiry.setBounds(600, 30, 300, 50);
		memberInquiry.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 40));
		memberInquiry.setForeground(Color.WHITE);
		memberInquiry.setHorizontalAlignment(JLabel.CENTER);
		add(memberInquiry);

		// 텍스트필드 설정
		searchField.setBounds(530, 130, 450, 35);
		searchField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchBtn.doClick();
			}
		});
		add(searchField);

		// 검색버튼 설정
		searchBtn.setBounds(1010, 100, 120, 100);
		try {
			BufferedImage buffer = ImageIO.read(new File("src/lmp/admin/menuButtonImages/searchButtonIcon.png"));
			Image image = buffer.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
			searchBtn.setIcon(new ImageIcon(image));
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		add(searchBtn);

		// 수정버튼 설정
		changeBtn.setBounds(1320, 15, 150, 70);
		try {
			BufferedImage buffer = ImageIO.read(new File("src/lmp/admin/menuButtonImages/bookModifyIconImage.png"));
			Image image = buffer.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			changeBtn.setIcon(new ImageIcon(image));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		add(changeBtn);

		// 삭제버튼 설정
		deleteBtn.setBounds(1320, 95, 150, 70);
		try {
			BufferedImage buffer = ImageIO.read(new File("src/lmp/admin/menuButtonImages/bookdeleteIconImage.png"));
			Image image = buffer.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			deleteBtn.setIcon(new ImageIcon(image));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		add(deleteBtn);
		
		// 비밀번호 초기화 설정
		resetPasswordBtn.setBounds(1340, 175, 120, 50);
		resetPasswordBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 13));
		resetPasswordBtn.setBackground(new Color(227, 94, 79));
		resetPasswordBtn.setForeground(Color.WHITE);
		resetPasswordBtn.setFocusable(false);
		
		resetPasswordBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mem_num = model.getValueAt(table.getSelectedRow(), 0).toString();
				int num = JOptionPane.showConfirmDialog(
						null,
						"회원 번호 : " + mem_num + "\n비밀번호를 초기화 하시겠습니까?",
						"비밀번호 초기화 확인",
						JOptionPane.YES_NO_OPTION);
				
				switch (num) {
				case 0 :
					MemberDao memDao = new MemberDao();
					
					try {
						memDao.resetPassword(mem_num);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "비밀번호 초기화 완료.");
					
					break;
				case 1 :					
					JOptionPane.showMessageDialog(null, "취소되었습니다.");
					break;
				}
			}
		});
		
		add(resetPasswordBtn);
		
		
		// 콤보박스로 검색할내용 선택하기
		String[] keywordList = {"회원번호", "이름", "아이디", "전화번호"};
		JComboBox keyword = new JComboBox<>(keywordList);
		keyword.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 15));
		keyword.setBounds(270, 130, 200, 35);
		add(keyword);
		
		
		table = AdminFrame.getTable(model);
		scroll = new JScrollPane(table);
		scroll.setBounds(0, 250, 1500, 500);
		add(scroll);

		// 검색 버튼누르면 결과가 JTable로 생성
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberDao mdao = new MemberDao();
				try {
					ArrayList<MemberVO> mems = new ArrayList<>();
					
					mems.addAll(mdao.get(keyword.getSelectedIndex() + 1, searchField.getText()));
					int num = 0;
					model.setRowCount(mems.size());
					for (MemberVO mem : mems) {
						for (int i = 0; i < mem.getList().length; i++) {
							// DB에서 가져온 성별 데이터에 따라 남/여로 표시
							if (header[i].equals("성별")) {
								if (mem.getSex().equals("0")) {
									model.setValueAt("남", num, i);
								} else {
									model.setValueAt("여", num, i);
								}
							} else {
								model.setValueAt(mem.getList()[i], num, i);
							}
						}
						num++;
					}

					searchField.setText("");
					table.validate();
					scroll.validate();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

			}
		});
		
		// 수정버튼
		changeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (table.getSelectedRow() == -1 || model.getValueAt(table.getSelectedRow(), 0) == null) {
					JOptionPane.showMessageDialog(null, "수정할 회원을 선택해주세요.");
					return;
				}
				
				JFrame j = new JFrame();
				
				JLabel join = new JLabel("회원수정");
				JLabel id = new JLabel("아이디");
				JLabel name = new JLabel("이름");
				JLabel birth = new JLabel("생년월일");
				JLabel sex = new JLabel("성별");
				JLabel phone = new JLabel("전화번호");
				JLabel email = new JLabel("이메일");
				JLabel address = new JLabel("주소");
				JLabel note = new JLabel("비고");

				JTextField idField = new JTextField
						(model.getValueAt(table.getSelectedRow() , 2).toString());
				JTextField nameField = new JTextField
						(model.getValueAt(table.getSelectedRow() , 1).toString());
				JTextField birthField = new JTextField
						(model.getValueAt(table.getSelectedRow() , 3).toString());
				JTextField sexField = new JTextField
						(model.getValueAt(table.getSelectedRow() , 4).toString());
				JTextField phoneField = new JTextField
						(model.getValueAt(table.getSelectedRow() , 5).toString());
				JTextField emailField = new JTextField
						(model.getValueAt(table.getSelectedRow() , 6).toString());
				JTextField addressField = new JTextField
						(model.getValueAt(table.getSelectedRow() , 7).toString());
				JTextField noteField = new JTextField();
				if (model.getValueAt(table.getSelectedRow() , 9) == null) {
					noteField.setText("");
				} else {
					noteField.setText(model.getValueAt(table.getSelectedRow() , 9).toString());
				}
				
				JButton phonecheckBtn = new JButton("중복확인");
				JButton emailcheckBtn = new JButton("중복확인");
				JButton joinBtn = new JButton("가입하기");
				JButton changeBtn2 = new JButton("수정");
				JButton cancelBtn = new JButton("취소");


				setlabel2(j, join, 40, 40, 13);
				j.add(join);

				setlabel2(j, id, 18, 40, 90);
				setField(j, idField, 113);
				idField.setEditable(false);
				j.add(id);
				j.add(idField);

				setlabel2(j, name, 18, 40, 140);
				setField(j, nameField, 163);
				j.add(name);
				j.add(nameField);

				setlabel2(j, birth, 18, 40, 190);
				setField(j, birthField, 213);
				birthField.setEditable(false);
				j.add(birth);
				j.add(birthField);

				setlabel2(j, sex, 18, 40, 240);
				setField(j, sexField, 263);
				sexField.setEditable(false);
				j.add(sex);
				j.add(sexField);
				
				setlabel2(j, phone, 18, 40, 290);
				setField(j, phoneField, 313);
				setBtn(j, phonecheckBtn, 13, 80, 30);
				phonecheckBtn.setLocation(350, 313);
				
				phonecheckBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						phonecheckBtn.addActionListener(new ActionListener() {
				               @Override
				               public void actionPerformed(ActionEvent e) {
				            	   MemberDao memberDao = new MemberDao();
				            	   
				                  if (vd.isValidatePhone(phoneField.getText()))  {
				                	  
				                     MemberVO memberVo = null;
				                     
				                     try {
				                    	 memberVo = memberDao.getByPhone(phoneField.getText()).get(0);
				                     } catch (SQLException e1) {
				                        JOptionPane.showMessageDialog(null, "사용가능합니다");
				                     } catch (IndexOutOfBoundsException e2) {
				                        JOptionPane.showMessageDialog(null, "사용가능합니다");
				                        changeBtn2.setEnabled(true);
				                     }
				                     
				                     if (memberVo != null) {
				                        JOptionPane.showMessageDialog(null, "중복되는 전화번호 입니다.",
				                              "경고", JOptionPane.ERROR_MESSAGE);
				                        changeBtn2.setEnabled(false);
				                     }
				                  } else {
				                     JOptionPane.showMessageDialog(null, "사용 불가한 전화번호입니다",
				                           "경고", JOptionPane.ERROR_MESSAGE);
				                     changeBtn2.setEnabled(false);
				                  }

				               }
				            });
					}
				});
				
				j.add(phonecheckBtn);
				j.add(phone);
				j.add(phoneField);

				setlabel2(j, email, 18, 40, 340);
				setField(j, emailField, 363);
				setBtn(j, emailcheckBtn, 13, 80, 30);
				emailcheckBtn.setLocation(350, 363);
				emailcheckBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						 MemberDao memberDao = new MemberDao();
		            	   
		                  if (vd.isValidateEmail(phoneField.getText()))  {
		                	  
		                     MemberVO memberVo = null;
		                     
		                     try {
		                    	 memberVo = memberDao.getByPhone(phoneField.getText()).get(0);
		                     } catch (SQLException e1) {
		                        JOptionPane.showMessageDialog(null, "사용가능합니다");
		                     } catch (IndexOutOfBoundsException e2) {
		                        JOptionPane.showMessageDialog(null, "사용가능합니다");
		                        changeBtn2.setEnabled(true);
		                     }
		                     
		                     if (memberVo != null) {
		                        JOptionPane.showMessageDialog(null, "중복되는 전화번호 입니다.",
		                              "경고", JOptionPane.ERROR_MESSAGE);
		                        changeBtn2.setEnabled(false);
		                     }
		                  } else {
		                     JOptionPane.showMessageDialog(null, "사용 불가한 전화번호입니다",
		                           "경고", JOptionPane.ERROR_MESSAGE);
		                     changeBtn2.setEnabled(false);
		                  }
					}
				});
				j.add(email);
				j.add(emailField);
				j.add(emailcheckBtn);

				setlabel2(j, address, 18, 40, 390);
				setField(j, addressField, 413);
				j.add(address);
				j.add(addressField);
				
				
				setlabel2(j, note, 18, 40, 440);
				setField(j, noteField, 463);
				j.add(note);
				j.add(noteField);

				setBtn(j, changeBtn2, 18, 80, 40);
				changeBtn2.setLocation(350, 500);
				j.add(changeBtn2);
				
				changeBtn2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int var = JOptionPane.showConfirmDialog
								(null, "수정하시겠습니까?", "수정 확인",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.INFORMATION_MESSAGE, null);
						if (var == JOptionPane.YES_OPTION) {
							MenuDao mdao = new MemberDao();
							MemberVO vo = new MemberVO((int)model.getValueAt(table.getSelectedRow() , 0),
									nameField.getText(),
									phoneField.getText(),
									emailField.getText(),
									addressField.getText()
									);
							try {
								mdao.update(vo);
								ArrayList<MemberVO> mems = new ArrayList<>();

								mems.addAll(mdao.get(keyword.getSelectedIndex() + 1, searchField.getText()));
								int num = 0;
								model.setRowCount(mems.size());
								for (MemberVO mem : mems) {
									for (int i = 0; i < mem.getList().length; i++) {
										model.setValueAt(mem.getList()[i], num, i);
									}
									num++;
								}
								j.dispose();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}


					}
				});

				j.setLayout(null);
				j.setBounds(330, 130, 480, 600);
				j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				j.setVisible(true);

			}
		});


		// 삭제버튼
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (table.getSelectedRow() == -1 || model.getValueAt(table.getSelectedRow(), 0) == null) {
					JOptionPane.showMessageDialog(null, "탈퇴할 회원을 선택해 주세요");
					return;
				}
				
				// 삭제 버튼 누르면 제일 먼저 미반납 도서 있는지 확인
				CheckOutDao checkOutDao = new CheckOutDao();
				ArrayList<CheckOutVO> checkOutVO = new ArrayList();
				
				try {
					checkOutVO.addAll(checkOutDao.get(3, model.getValueAt(table.getSelectedRow(), 0).toString()));
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
				// 미반납 도서가 존재하면 안내문구 출력 후 삭제 버튼 무효
				if (checkOutVO.size() != 0) {
					JOptionPane.showMessageDialog(null, "미반납 도서가 존재합니다.");
					return;
				}
				
				
				int var = JOptionPane.showConfirmDialog
						(null, "삭제 하시겠습니까?", "삭제 확인",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null);
				if (var == JOptionPane.YES_OPTION) {
					MemberDao mdao = new MemberDao();
					try {
						mdao.delete((int)table.getValueAt(table.getSelectedRow(), 0));
//						mdao.delete(table.getValueAt(table.getSelectedRow(), 0).toString());
						
						// 삭제되면 테이블 업데이트
						model.setRowCount(0);
						ArrayList<MemberVO> mems = new ArrayList<>();
						mems.addAll(mdao.get(keyword.getSelectedIndex() + 1, searchField.getText()));
						model.setRowCount(mems.size());
						int num = 0;
						model.setRowCount(mems.size());
						for (MemberVO mem : mems) {
							for (int i = 0; i < mem.getList().length; i++) {
								// DB에서 가져온 성별 데이터 남/여로 표시
								if (i == 5) {
									if (mem.getSex().equals("0")) {
										model.setValueAt("남", num, i);
									} else {
										model.setValueAt("여", num, i);
									}
								} else {
									model.setValueAt(mem.getList()[i], num, i);
								}
							}
							num++;
						}
						JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});

		// 판넬기본설정
		setLayout(null);
		//setBorder(new LineBorder(Color.WHITE, 5, false)); // 판넬테두리 
//		setBounds(0, 100, 1180, 650);
		setBackground(new Color(87, 119, 119));
	}

	// 라벨 생성 및 설정함수
	public static void setlabel(JFrame frame, JLabel label , int size, int x, int y) {
		Font font = new Font("한컴 말랑말랑 Bold", Font.BOLD, size);
		label.setFont(font);
		label.setForeground(Color.WHITE);
		label.setBounds(x, y, 300, 30);
		frame.add(label);
	}

	public static void setlabel2(JFrame frame, JLabel label , int size, int x, int y) {
		Font font = new Font("한컴 말랑말랑 Bold", Font.BOLD, size);
		label.setFont(font);
		label.setForeground(new Color(49, 82, 91));
		label.setBounds(x, y, 200, 70);
		frame.add(label);
	}

	// 버튼 생성 및 설정함수
	public static void setBtn(JFrame frame, JButton button , int fontSize, int width, int height) {
		Font font = new Font("한컴 말랑말랑 Bold", Font.BOLD, fontSize);

		button.setFont(font);
		button.setBackground(new Color(87, 119, 119));
		button.setForeground(Color.WHITE);
		button.setFocusable(false);
		button.setSize(width, height);
		frame.add(button);
	}

	// 텍스트필드 생성 및 설정함수
	public static void setField(JFrame frame, JTextField field, int y) {
		Font font = new Font("한컴 말랑말랑 Bold", Font.BOLD, 13);
		field.setFont(font);
		field.setBounds(135, y, 200, 30);
		field.setBorder(new LineBorder(new Color(49, 82, 91), 2, false));
		frame.add(field);
	}
	
	// 중복확인 버튼 액션리스너
	public static void checkBtn(JButton button) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				if ()
					
			}
		});
	}

}
