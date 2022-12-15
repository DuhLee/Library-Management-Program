package lmp.admin.menu.readingroom.sj;

import java.awt.Color;



import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import lmp.db.dao.MemberDao;
import lmp.db.dao.MenuDao;
import lmp.db.vo.MemberVO;


public class MemberLoginFrame extends MenuDao {

	private JTextField idTextFiled = new JTextField("아이디를 입력를 입력해주세요");
	private JPasswordField pwField  = new JPasswordField("비밀번호를 입력");
	private JFrame frame = new JFrame();
	
	MemberDao memberDao = new MemberDao();
	ArrayList<MemberVO> memberVO = new ArrayList<>();
	
	public MemberLoginFrame() {
		
		// 라벨 
		JLabel LoginLabel = new JLabel("로그인", JLabel.CENTER);
		JLabel idLabel = new JLabel("아이디", JLabel.LEFT);
		JLabel pwLabel = new JLabel("비밀번호", JLabel.LEFT);
		
		// 텍스트필드 
//		JTextField idTextFiled = new JTextField("아이디를 입력를 입력해주세요");
//		JPasswordField pwField  = new JPasswordField("비밀번호를 입력");
		
		// 확인버튼 
		JButton loginBtn = new JButton("Login");
		JButton searchIdBtn = new JButton("아이디찾기");
		JButton searchPwBtn = new JButton("비밀번호찾기");
		JButton joinBtn = new JButton("회원가입");
		
		// 라벨, 텍스트필드, 확인버튼 추가
		frame.add(LoginLabel);
		frame.add(idLabel);
		frame.add(pwLabel);
		frame.add(idTextFiled);
		frame.add(pwField);
		frame.add(loginBtn);
		frame.add(searchIdBtn);
		frame.add(searchPwBtn);
		frame.add(joinBtn);
		
		// 위치와 크기 설정
		LoginLabel.setBounds(0, 20, 400, 30);
		idLabel.setBounds(30, 90, 50, 30);
		pwLabel.setBounds(30, 125, 50, 30);
		idTextFiled.setBounds(90, 90, 175, 30);
		pwField.setBounds(90, 125, 175, 30);
		loginBtn.setBounds(275, 90, 80, 65);
		searchIdBtn.setBounds(20, 200, 100, 30);
		searchPwBtn.setBounds(120, 200, 140, 30);
		joinBtn.setBounds(270, 200, 100, 30);
		
		// id텍스트필드 마우스 클릭 이벤트
		idTextFiled.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	        	 idTextFiled.setText("");
	         }
	    });
		
		// pw텍스트필드 마우스 클릭 이벤트
		pwField.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	        	 pwField.setText("");
	         }
	    });
		
		// 버튼 테두리 설정
		loginBtn.setBorderPainted(false);
		searchIdBtn.setBorderPainted(false);
		searchPwBtn.setBorderPainted(false);
		joinBtn.setBorderPainted(false);
		
		// 텍스트필드와 패스워드필드 테두리 설정
		pwField.setBorder(null);
		idTextFiled.setBorder(null);
		
		// 버튼 영역 배경 표시 설정
		searchIdBtn.setContentAreaFilled(false);
		searchPwBtn.setContentAreaFilled(false);
		joinBtn.setContentAreaFilled(false);
	
		// 포커스 표시 설정
		loginBtn.setFocusPainted(false);
		searchIdBtn.setFocusPainted(false);
		searchPwBtn.setFocusPainted(false);
		joinBtn.setFocusPainted(false);
		
		// 로그인 버튼의 배경 색상을 변경
		loginBtn.setBackground(Color.WHITE);
		
		// 로그인 버튼의 폰트 색상을 변경
		loginBtn.setForeground(Color.GRAY);
	
		// 로그인 성공시, 회원정보창 띄우기 
		// 또는 로그인 성공시, 열람실 조회화면으로 이동하여 좌석 선택
		// 로그인 실패시, 에러메시지 띄우기
//		 JOptionPane.showMessageDialog(loginBtn, "<html><body>로그인에 실패하였습니다. "
//		 		+ "<br> <br>아이디와 비밀번호를 확인해주세요.</body></html>", null, 0);
		// new memberInfoScreen(); // 회원정보창으로 이동
		//  new LoginSuccessScreen(); // 로그인 성공 메시치 창
		

		// 로그인 버튼 이벤트
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id = idTextFiled.getText();
				char[] pw = pwField.getPassword();
				String password = new String(pw);
				System.out.println(id);
				System.out.println(password);
				
				if (id.equals("test") && password.equals("1234")) {
					// db 정보 불러와서 조건문 수정 필요!
					// 아이디 유효성 확인 -> 팀장님...
					
					frame.dispose();
					new ReadingRoomMain();
					
				} else {
					 JOptionPane.showMessageDialog(loginBtn, "<html><body>로그인에 실패하였습니다. "
			 		+ "<br> <br>아이디와 비밀번호를 확인해주세요.</body></html>", null, 0);
				}
				
				
			
				
				
			}
		});
		
//				String id = idTextFiled.getText();
//				char[] pw = pwField.getPassword();
//				String password = new String(pwField.getPassword());
//				memberVO.addAll(memberDao.get(3, idTextFiled.getText()));
//				memberVO.addAll(memberDao.get(4, password));
//				if (id.equals("") || password.equals("")) {
//					frame.dispose();
//					new LoginSuccessScreen(); 
//				} else {
//					if (id.equals() && password.equals()) {
//						// 로그인 정보 일치시 로그인 성공	
//					} else {
//						// 로그인 정보 일치하지 않을 시 로그인 실패
//					}
//				}
		
		
		// 로그인 버튼 이벤트
//		loginBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String id = idTextFiled.getText();
//				char[] pw = pwField.getPassword();
//				String password = new String(pw);
//				System.out.println(id);
//				System.out.println(password);
//				
//				if (id.equals("test") && password.equals("1234")) {
//					dispose();
//					
//				} else {
//					dispose();
//					
//				}
//			}
//		});
		
		
		
		
		
		
		
		// 아이디 찾기 버튼 이벤트
		searchIdBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				// new FindIdFrame();
			}
		});
		
		
		// 비밀번호 찾기 버튼 이벤트
		 searchPwBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				// new FindPwFrame();
			}
		});
		
		// 회원가입 버튼 이벤트
		joinBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				// new JoinScreen();
			}
		});
	
				

		
		// 폰트설정
		LoginLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 24));
		idLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		pwLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		
		idTextFiled.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		pwField.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		
		loginBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		searchIdBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		searchPwBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		joinBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		
		// 색상 변경
		LoginLabel.setForeground(Color.WHITE);
		idLabel.setForeground(Color.WHITE);
		pwLabel.setForeground(Color.WHITE);
		
		idTextFiled.setForeground(Color.LIGHT_GRAY);
		pwField.setForeground(Color.LIGHT_GRAY);
	
		searchIdBtn.setForeground(Color.WHITE);
		searchPwBtn.setForeground(Color.WHITE);
		joinBtn.setForeground(Color.WHITE);
		
		
		// 기본 프레임 세팅
		frame.setTitle("회원 로그인");
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setMinimumSize(new Dimension(400, 300));
		frame.setLocationRelativeTo(null);
		
		
		// 메인 배경색상 변경
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setBackground(new Color(186, 206, 194));
		p.setBounds(0, 0, 400, 300);
		frame.add(p);
		
	}
	
	
	
	
//	public boolean logincheck(String _id, String _pw) {
//		 boolean flag = false;
//		 
//		 String mem_id = _id;
//		 String mem_pw = _pw;
//		 
//		 try {
//			String checkingStr = "SELECT mem_pw FROM members WHERE mem_id='" + mem_id + "'";
//			ResultSet result = stmt.executeQuery(checkingStr);
//			
//			int count = 0;
//			while (result.next()) {
//				if(mem_pw.equals(result.getString("mem_pw"))) {
//					flag = true;
//					System.out.println("로그인 성공");
//				} else {
//					flag = false;
//					System.out.println("로그인 실패");
//				}
//				count++;
//			}
//			
//		} catch (Exception e) {
//			flag = false;
//			System.out.println("로그인 실패 > " + e.toString());
//		}
//		 
//		 return flag;
//		 
//	}

	

	
	
	
	
	
	public static void main(String[] args) {
		new MemberLoginFrame();
		

		
	}
	
}
