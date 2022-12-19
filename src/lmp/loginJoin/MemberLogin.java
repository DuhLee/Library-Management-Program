package lmp.loginJoin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import lmp.admin.menu.readingroom.jy.AdminReadingRoom;



public class MemberLogin extends JFrame {
	
	private JPanel contentPane;
	private JTextField idTextFiled;
	private JPasswordField pwField;

	private String sID = "";
	private String sPW = "";
	
	
	public MemberLogin() {
		
		// 기본 프레임 세팅
		setTitle("회원 로그인");
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
//		setMinimumSize(new Dimension(510, 164));
		setMinimumSize(new Dimension(400, 164));
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(186, 206, 194));
		
		
		// 라벨 
		JLabel idLabel = new JLabel("아이디", JLabel.LEFT);
		idLabel.setHorizontalAlignment(JLabel.CENTER);
		idLabel.setBounds(40, 30, 47, 15);
		contentPane.add(idLabel);
		
		
		idTextFiled = new JTextField("아이디를 입력해주세요");
		idTextFiled.setText("");
		// sID = idTextFiled.getText();
		idTextFiled.setBounds(99, 27, 167, 21);
		contentPane.add(idTextFiled);
		idTextFiled.setColumns(10);
		
		
		JLabel pwLabel = new JLabel("비밀번호", JLabel.LEFT);
		pwLabel.setHorizontalAlignment(JLabel.CENTER);
		pwLabel.setBounds(40, 55, 47, 15);
		contentPane.add(pwLabel);
		
		
		pwField  = new JPasswordField("비밀번호를 입력해주세요");
		pwField.setText("");
		// sPW = pwField.getText();
		pwField.setBounds(99, 52, 167, 21);
		contentPane.add(pwField);
		pwField.setColumns(10);

		
		JButton loginBtn = new JButton("로그인");
		loginBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				// 로그인 했을 때 작업
				boolean bLoginChk = false;
				GetIdandPw(idTextFiled, pwField); // 입력된 값 각각 넘겨 주기
				MemberLogin_Chk loginchk = new MemberLogin_Chk();
				bLoginChk = loginchk.LogInList_Chk(sID, sPW); // false면 로그인 실패

				if (!bLoginChk) { // 로그인 실패
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 확인 후\n다시 로그인해주세요.");
				} else { // 로그인 성공
					setVisible(false); // 기존의 로그인 화면 꺼주기
					new AdminReadingRoom(); // 열람실 조회화면으로 갱신
				}
			}
		});
		loginBtn.setBounds(274, 27, 80, 46);
		contentPane.add(loginBtn);

		
		JButton searchIdBtn = new JButton("아이디 찾기");
		// 아이디 찾기 버튼 이벤트
		searchIdBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				// ID찾기 했을 때 작업
				dispose();			// 로그인 화면 off
				// new FindIdFrame();a		// ID찾기 페이지 화면으로 갱신
			}
		});
		searchIdBtn.setBounds(30, 80, 109, 30);
		contentPane.add(searchIdBtn);
		
		
		JButton searchPwBtn = new JButton("비밀번호 찾기");
		// 비밀번호 찾기 버튼 이벤트
		 searchPwBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					// PW찾기 했을 때 작업
					dispose();			// 로그인 화면 off
					// new FindPwFrame();		// PW찾기 페이지 화면으로 갱신
			}
		});
		searchPwBtn.setBounds(145, 80, 118, 30);
		contentPane.add(searchPwBtn);
		 		
		
		JButton joinBtn = new JButton("회원가입");
		// 회원가입 버튼 이벤트
		joinBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				// 회원가입 했을 때 작업
				dispose();			// 로그인 화면 off
				// new JoinScreen();		 // 회원 가입 화면 켜주기
			}
		});
		joinBtn.setBounds(260, 80, 102, 30);
		contentPane.add(joinBtn);	
		
		
		
//		JButton guestBtn = new JButton("게스트입장");
//		guestBtn.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				super.mouseClicked(e);
//				setVisible(false); // 기존의 로그인 화면 꺼주기
//				new ReadingRoomMain();		// 좌석 조회만 가능하게..?
//			}
//		});
//		guestBtn.setBounds(360, 27, 95, 46);
//		contentPane.add(guestBtn);

//		Reset(idTextFiled, pwField);
		
		// 게스트 입장했을 때 발권 버튼 막기
		
		

		
		// 버튼 테두리 설정
		loginBtn.setBorderPainted(false);
		searchIdBtn.setBorderPainted(false);
		searchPwBtn.setBorderPainted(false);
		joinBtn.setBorderPainted(false);
//		guestBtn.setBorderPainted(false);
		
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
//		guestBtn.setFocusPainted(false);
		
		// 로그인 버튼의 배경 색상을 변경
		loginBtn.setBackground(Color.WHITE);
//		guestBtn.setBackground(Color.WHITE);
		
		// 로그인 버튼의 폰트 색상을 변경
		loginBtn.setForeground(Color.GRAY);
//		guestBtn.setForeground(Color.GRAY);
		
		
		// 폰트설정
		idLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		pwLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		
//		idTextFiled.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
//		pwField.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		
		loginBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		searchIdBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		searchPwBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		joinBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
//		guestBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		
		// 색상 변경
		idLabel.setForeground(Color.WHITE);
		pwLabel.setForeground(Color.WHITE);
		
		idTextFiled.setForeground(Color.LIGHT_GRAY);
		pwField.setForeground(Color.LIGHT_GRAY);
	
		searchIdBtn.setForeground(Color.WHITE);
		searchPwBtn.setForeground(Color.WHITE);
		joinBtn.setForeground(Color.WHITE);
		
	
	}
	
	
	private void GetIdandPw (JTextField idTextFiled, JTextField pwField) {
		// TODO Auto-generated method stub
		sID = idTextFiled.getText();
		sPW = pwField.getText();
	}

	private void Reset (JTextField idTextFiled, JTextField pwField) {
		idTextFiled.setText(null);
		pwField.setText(null);
	}
	
	public static void main(String[] args) {
		new MemberLogin();
		
	}
	
}