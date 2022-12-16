package lmp.admin.menu.employees;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

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
import javax.swing.table.DefaultTableModel;

import lmp.admin.dao.AdminDao;
import lmp.admin.dao.MenuDao;
import lmp.admin.vo.AdminVO;

public class EmployeesMgmt extends JPanel{
	
	// JTable 구성품
		private String[] header = {"사번", "이름", "비밀번호", "전화번호", "이메일", "주소" ,"입사일", "비고"};
		private DefaultTableModel model = new DefaultTableModel(header, 0);
		private JTable table;
		JScrollPane scroll;

		public EmployeesMgmt() {

			JLabel employeeInquiry = new JLabel("직원 조회"); // 직원조회글씨
			JTextField searchField = new JTextField(); // 검색창	
			JButton searchBtn = new JButton("검색"); // 검색버튼
			JButton addBtn = new JButton("추가"); // 추가버튼
			JButton deleteBtn = new JButton("삭제"); // 삭제버튼 
			
			// 직원조회 타이틀 설정
			employeeInquiry.setBounds(540, 20, 200, 50);
			employeeInquiry.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 22));
			employeeInquiry.setForeground(Color.WHITE);
			add(employeeInquiry);

			// 검색창 텍스트필드 설정
			searchField.setBounds(390, 80, 400, 30);
			add(searchField);

			// 검색버튼 설정
			searchBtn.setBounds(840, 80, 100, 30);
			searchBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 14));
			searchBtn.setBackground(Color.WHITE);
			searchBtn.setForeground(new Color(49, 82, 91));
			add(searchBtn);


			// 콤보박스로 검색할내용 선택하기
			String[] keywordList = {"사번", "이름", "전화번호", "입사일"};
			JComboBox keyword = new JComboBox<>(keywordList);
			keyword.setBounds(230, 80, 110, 30);
			keyword.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 14));
			add(keyword);
			
			table = new JTable(model);
			//table.getTableHeader().setReorderingAllowed(false);
	        //table.setRowHeight(20);
	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scroll = new JScrollPane(table);
			scroll.setBounds(0, 156, 1152, 395);
			
			add(scroll);
			
			searchBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MenuDao mdao = new AdminDao();
					try {
						ArrayList<AdminVO> admins = new ArrayList<>();
						
						admins.addAll(mdao.get(keyword.getSelectedIndex() + 1, searchField.getText()));
						int num = 0;
						model.setRowCount(admins.size());
						for (AdminVO admin : admins) {						
							for (int i = 0; i < admin.getList().length; i++) {
								model.setValueAt(admin.getList()[i], num, i);
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
			

			// 추가버튼 설정
			addBtn.setBounds(1020, 35, 120, 40);
			addBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 14));
			addBtn.setBackground(Color.WHITE);
			addBtn.setForeground(new Color(49, 82, 91));
			add(addBtn);

			// 추가버튼을 누르면 새창이 뜨면서 정보입력하게..
			addBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					addEmployee();
				}
			});

			// 삭제버튼 설정
			deleteBtn.setBounds(1020, 85, 120, 40);
			deleteBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 14));
			deleteBtn.setBackground(Color.WHITE);
			deleteBtn.setForeground(new Color(49, 82, 91));
			add(deleteBtn);

			// 삭제버튼 누르면 해당정보 삭제
			deleteBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					int var = JOptionPane.showConfirmDialog
							(null, "삭제하시겠습니까?", " ",
									JOptionPane.YES_NO_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null);
					if (var == JOptionPane.YES_OPTION) {
						MenuDao mdao = new AdminDao();

						try {
							System.out.println(model.getValueAt(table.getSelectedRow() , 0).toString());
							mdao.delete(table.getValueAt(table.getSelectedRow(), 0).toString());

							// 삭제되면 테이블 업데이트
							ArrayList<AdminVO> admins = new ArrayList<>();
							admins.addAll(mdao.get(keyword.getSelectedIndex() + 1, searchField.getText()));
							int num = 0;
							model.setRowCount(admins.size());
							for (AdminVO admin : admins) {						
								for (int i = 0; i < admin.getList().length; i++) {
									model.setValueAt(admin.getList()[i], num, i);
								}
								num++;
							}

						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}	
			});		


			// 판넬기본설정
			setBackground(new Color(87, 119, 119));
			setLayout(null);
			//setBorder(new LineBorder(Color.WHITE, 5, false)); // 테두리
			setBounds(15, 180, 1150, 550);
		}

		public void addEmployee() {
			JFrame f = new JFrame("직원등록");
			JLabel addemp = new JLabel("직원등록");
			JLabel name = new JLabel("이름");
			JLabel birth = new JLabel("생년월일");
			JLabel phone = new JLabel("전화번호");
			JLabel pw = new JLabel("비밀번호");
			JLabel email = new JLabel("이메일");
			JLabel address = new JLabel("주소");

			JTextField nameField = new JTextField();
			JTextField birthField = new JTextField();
			JTextField phoneField = new JTextField();
			JTextField pwField = new JTextField();
			JTextField emailField = new JTextField();
			JTextField addressField = new JTextField();

			JButton finishBtn = new JButton("완료");

			// 직원등록 타이틀 설정

			addemp.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 35));
			addemp.setBounds(40, 25, 150, 40);
			f.add(addemp);

			// 이름 라벨 , 텍스트필드 설정
			f.add(name);
			f.add(nameField);
			name.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 20));
			name.setBounds(50, 90, 100, 30);
			nameField.setBounds(150, 90, 150, 30);

			
			// 비밀번호 라벨 , 텍스트필드 설정
			f.add(pw);
			f.add(pwField);
			pw.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 20));
			pw.setBounds(50, 140, 100, 30);
			pwField.setBounds(150, 140, 150, 30);
			
			// 전화번호 라벨 , 텍스트필드 설정
			f.add(phone);
			f.add(phoneField);
			phone.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 20));
			phone.setBounds(50, 190, 100, 30);
			phoneField.setBounds(150, 190, 150, 30);

			// 이메일 라벨 , 텍스트필드 설정
			f.add(email);
			f.add(emailField);
			email.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 20));
			email.setBounds(50, 240, 100, 30);
			emailField.setBounds(150, 240, 150, 30);

			// 주소 라벨 , 텍스트필드 설정
			f.add(address);
			f.add(addressField);
			address.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 20));
			address.setBounds(50, 290, 100, 30);
			addressField.setBounds(150, 290, 150, 30);

			f.add(finishBtn);
			finishBtn.setBounds(280, 350, 80 ,30);
			finishBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 14));
			finishBtn.setBackground(new Color(49, 82, 91));
			finishBtn.setForeground(Color.WHITE);

			finishBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame j = new JFrame(); 
					JLabel finish = new JLabel("등록이 완료되었습니다");

					AdminDao dao = new AdminDao();
					AdminVO vo = new AdminVO(null,nameField.getText(), pwField.getText(),
							phoneField.getText(), emailField.getText(), addressField.getText(),
							null, null); 

					try {
						dao.add(vo);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					j.add(finish);
					finish.setBounds(55, 65, 350, 30);
					finish.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 25));

					j.dispose();
					j.setLayout(null);
					j.setBounds(500, 400, 400, 200);
					j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					j.setVisible(true);
				}
			});


			f.dispose();
			f.setLayout(null);
			f.setBounds(500, 300, 400, 450);
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			f.setVisible(true);
		}
}
