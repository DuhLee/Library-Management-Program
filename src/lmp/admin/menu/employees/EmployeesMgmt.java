package lmp.admin.menu.employees;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class EmployeesMgmt extends JPanel {
	
	// JTable 구성품
	String[] header = {"사번", "이름", "생년월일", "전화번호", "입사일", "비밀번호" ,"이메일", "주소", "비고"};
	String[][] contents = {
			{"00001", "김사서", "1995.11.08", "010-1234-5678","2020.03.05", "1234", 
				"abc@naver.com", "서울시 xx구", ""},
			{"00002", "이사서", "1998.11.25", "010-2346-2146", "2019.08.03", "5678",
					"dsfds@naver.com", "서울시 xx구", ""},
			{"00003",  "박사서", "1993.02.06", "010-8678-3248", "2021.12.05", "9101",
						"adsgdbc@naver.com", "서울시 xx구",  ""},
			{"00004",  "김알바", "2003.04.04", "010-1468-3240", "2022.11.05","1121",
							"dfs@naver.com", "서울시 xx구",  ""}
	};
	
	JTable results;
	
	public EmployeesMgmt() {
		
		JLabel employeeInquiry = new JLabel("직원 조회"); // 직원조회글씨
		JTextField searchField = new JTextField(); // 검색창	
		JButton searchBtn = new JButton("검색"); // 검색버튼
		JButton addBtn = new JButton("추가"); // 추가버튼
		JButton deleteBtn = new JButton("삭제"); // 삭제버튼 
		// JTable 에서 삭제할사람 선택 > 삭제버튼클릭 > 삭제하시겠습니가? yes or no > yes : 삭제완료되었습니다 (삭제) , no : 삭제팝업 종료 
		
		
		
		// 직원조회 타이틀 설정
		employeeInquiry.setBounds(18, 35, 150, 30);
		employeeInquiry.setFont(new Font(null, Font.BOLD, 30));
		add(employeeInquiry);

		// "이름" 텍스트필드 설정
		searchField.setBounds(138, 100, 500, 30);
		add(searchField);

		// 검색버튼 설정
		searchBtn.setBounds(668, 100, 60, 30);
		add(searchBtn);

		
		// 콤보박스로 검색할내용 선택하기
		String[] keywordList = {"사번", "이름", "생년월일", "전화번호", "입사일"};
		JComboBox keyword = new JComboBox<>(keywordList);
		keyword.setBounds(18, 100, 100, 30);
		add(keyword);

		// JTable 검색해주는 기능(?)
		String[][] valid = new String[30][9];
		int index = 0;
		for (int i = 0; i < contents.length; ++i) {
			//System.out.println(contents[i][keyword.getSelectedIndex()]);
			if (contents[i][keyword.getSelectedIndex()].contains(searchField.getText())) {
				valid[index++] = contents[i];
			}
		}
		DefaultTableModel model = new DefaultTableModel(valid, header);
		JTable results = new JTable(model);
		results.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한개의 행만 선택 가능
		//results.setEnabled(false); // 더블클릭불가(수정안됨) 대신선택도안댐...
		JScrollPane result = new JScrollPane(results);
		result.setBounds(18, 170, 1150, 400);
		
		// 검색 버튼누르면 결과가 입력된 새 JTable 추가
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				add(result);
				validate();
			}
		});
		
		// 추가버튼 설정
		addBtn.setBounds(1000, 600, 60, 30);
		add(addBtn);
		
		// 추가버튼을 누르면 새창이 뜨면서 정보입력하게..
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addEmployee();
			}
		});
		
		// 삭제버튼 설정
		deleteBtn.setBounds(1080, 600, 60, 30);
		add(deleteBtn);
		
		// 삭제버튼 누르면 해당정보 삭제...구현못함
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model2 = (DefaultTableModel)results.getModel();
				int row = results.getSelectedRow();
				if(row < 0) {
					return;
				}
				model2.removeRow(row);
			}
		});
		
		// 판넬기본설정
		setLayout(null);
		setBorder(new LineBorder(Color.WHITE, 5, false)); // 테두리
		setBounds(0, 100, 1400, 750);
	}

	public void addEmployee() {
		JFrame f = new JFrame("직원등록");
		JLabel addemp = new JLabel("직원등록");
		JLabel empnum = new JLabel("사번");
		JLabel name = new JLabel("이름");
		JLabel birth = new JLabel("생년월일");
		JLabel phone = new JLabel("전화번호");
		JLabel hireday = new JLabel("입사일");
		JLabel pw = new JLabel("비밀번호");
		JLabel email = new JLabel("이메일");
		JLabel address = new JLabel("주소");
		
		JTextField empnumField = new JTextField();
		JTextField nameField = new JTextField();
		JTextField birthField = new JTextField();
		JTextField phoneField = new JTextField();
		JTextField hiredayField = new JTextField();
		JTextField pwField = new JTextField();
		JTextField emailField = new JTextField();
		JTextField addressField = new JTextField();

		JButton finishBtn = new JButton("완료");

		// 직원등록 타이틀 설정
		
		addemp.setFont(new Font("한컴 말랑말랑", Font.BOLD, 30));
		addemp.setBounds(130, 30, 150, 30);
		f.add(addemp);
		
		// 사번 라벨 , 텍스트필드 설정
		f.add(empnum);
		f.add(empnumField);
		empnum.setFont(new Font("한컴 말랑말랑", Font.BOLD, 15));
		empnum.setBounds(70, 90, 100, 30);
		empnumField.setBounds(130, 90, 150, 30);
		
		
		// 이름 라벨 , 텍스트필드 설정
		f.add(name);
		f.add(nameField);
		name.setFont(new Font(null, Font.BOLD, 15));
		name.setBounds(70, 140, 100, 30);
		nameField.setBounds(130, 140, 150, 30);

		// 생년월일 라벨 , 텍스트필드 설정
		f.add(birth);
		f.add(birthField);
		birth.setFont(new Font(null, Font.BOLD, 15));
		birth.setBounds(40, 190, 100, 30);
		birthField.setBounds(130, 190, 150, 30);

		// 전화번호 라벨 , 텍스트필드 설정
		f.add(phone);
		f.add(phoneField);
		phone.setFont(new Font(null, Font.BOLD, 15));
		phone.setBounds(40, 240, 100, 30);
		phoneField.setBounds(130, 240, 150, 30);

		// 입사일 라벨 , 텍스트필드 설정
		f.add(hireday);
		f.add(hiredayField);
		hireday.setFont(new Font(null, Font.BOLD, 15));
		hireday.setBounds(55, 290, 100, 30);
		hiredayField.setBounds(130, 290, 150, 30);
		
		// 비밀번호 라벨 , 텍스트필드 설정
		f.add(pw);
		f.add(pwField);
		pw.setFont(new Font(null, Font.BOLD, 15));
		pw.setBounds(55, 340, 100, 30);
		pwField.setBounds(130, 340, 150, 30);

		// 이메일 라벨 , 텍스트필드 설정
		f.add(email);
		f.add(emailField);
		email.setFont(new Font(null, Font.BOLD, 15));
		email.setBounds(55, 390, 100, 30);
		emailField.setBounds(130, 390, 150, 30);

		// 주소 라벨 , 텍스트필드 설정
		f.add(address);
		f.add(addressField);
		address.setFont(new Font(null, Font.BOLD, 15));
		address.setBounds(55, 440, 100, 30);
		addressField.setBounds(130, 440, 150, 30);

		f.add(finishBtn);
		finishBtn.setBounds(280, 490, 80 ,30);

		finishBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame j = new JFrame(); 
				JLabel finish = new JLabel("등록이 완료되었습니다");
				
				DefaultTableModel model2 = (DefaultTableModel)results.getModel();
				model2.addRow(new String[]{empnumField.getText(), nameField.getText(),
						birthField.getText(), phoneField.getText(), hiredayField.getText(),
						pwField.getText(), email.getText(), addressField.getText(), ""});
				
				j.add(finish);
				finish.setBounds(55, 65, 350, 30);
				finish.setFont(new Font(null, Font.BOLD, 25));

				j.dispose();
				j.setLayout(null);
				j.setBounds(500, 400, 400, 200);
				j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				j.setVisible(true);
			}
		});


		f.dispose();
		f.setLayout(null);
		f.setBounds(500, 300, 400, 580);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();

		f.add(new EmployeesMgmt());

		f.setLayout(null);
		f.setBounds(300, 100, 1200, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
