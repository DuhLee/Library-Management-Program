package lmp.admin.menu.member;

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

public class MemberMgmt extends JPanel{
	
	public MemberMgmt() {

		JLabel memberInquiry = new JLabel("회원 조회"); // 회원조회글씨
		JTextField searchField = new JTextField(); // 이름검색창	
		JButton searchBtn = new JButton("검색"); // 검색버튼
		JButton changeBtn = new JButton("수정"); // 수정버튼
		JButton deleteBtn = new JButton("삭제"); // 삭제버튼

		// 회원조회 타이틀 설정
		memberInquiry.setBounds(18, 35, 150, 30);
		memberInquiry.setFont(new Font(null, Font.BOLD, 30));
		add(memberInquiry);

		// "이름" 텍스트필드 설정
		searchField.setBounds(138, 100, 500, 30);
		add(searchField);

		// 검색버튼 설정
		searchBtn.setBounds(668, 100, 60, 30);
		add(searchBtn);

		// 수정버튼 설정
		changeBtn.setBounds(1000, 600, 60, 30);
		add(changeBtn);
		
		// 삭제버튼 설정
		deleteBtn.setBounds(1080, 600, 60, 30);
		add(deleteBtn);

		// 콤보박스로 검색할내용 선택하기
		String[] keywordList = {"번호", "회원번호", "이름", "아이디", "생년월일", "성별", "전화번호"};
		JComboBox keyword = new JComboBox<>(keywordList);
		keyword.setBounds(18, 100, 100, 30);
		add(keyword);

		// JTable 구성품 
		String[] header = {"번호","회원번호", "이름", "아이디", "생년월일", "성별", "전화번호", "이메일", "주소",
				"대출상태", "비고"};
		String[][] contents = {
				{"0001", "160254", "김한글", "hangle", "1995.07.15", "남", "010-1234-5678", "abc@naver.com",
					"서울시ㅇㅇ구", "대출가능", ""},
				{"0002", "180157", "이영어", "eng", "1996.02.08","여", "010-5244-2347", "cde@naver.com",
						"서울시ㅇㅇ구", "대출중", ""},
				{"0003","145267", "박구리", "guri", "1990.09.23","여", "010-5676-1237", "dsaf@naver.com",
							"경기도ㅇㅇ시", "대출가능", ""},
				{"0004", "204579", "김자바", "java", "2002.08.15", "남", "010-4865-2168", "afdsaf@naver.com",
								"경기도ㅇㅇ구", "대출불가", ""},
				{"0005", "221208", "이허브", "hub", "2013.09.26", "남", "010-4567-5578", "dfsf@naver.com",
									"서울시ㅇㅇ구", "대출가능", ""},
		};

		// 검색 버튼누르면 결과가 JTable로 생성
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] valid = new String[30][11];
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
				add(result);
				validate();
				
			}
		});

		// 판넬기본설정
		setLayout(null);
		//setBorder(new LineBorder(Color.WHITE, 5, false)); // 판넬테두리 
		setBounds(0, 100, 1180, 650);
	}


	public static void main(String[] args) {
		JFrame f = new JFrame();

		f.add(new MemberMgmt());

		f.setLayout(null);
		f.setBounds(300, 100, 1200, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
