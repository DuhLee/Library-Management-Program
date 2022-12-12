package lmp.admin.menu.readingroom.sj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberLoginFrame extends JFrame {

	public MemberLoginFrame() {
		
		// 라벨 
		JLabel LoginLabel = new JLabel("로그인", JLabel.CENTER);
		JLabel idLabel = new JLabel("아이디", JLabel.LEFT);
		JLabel pwLabel = new JLabel("비밀번호", JLabel.LEFT);
		
		// 텍스트필드 
		JTextField idTf = new JTextField("아이디를 입력하세요");
		JTextField pwTf = new JTextField("비밀번호를 입력하세요");
		
		// 확인버튼 
		JButton loginBtn = new JButton("Login");
		JButton searchIdBtn = new JButton("아이디찾기");
		JButton searchPwBtn = new JButton("비밀번호찾기");
		JButton joinBtn = new JButton("회원가입");
		
		// 라벨, 텍스트필드, 확인버튼 추가
		add(LoginLabel);
		add(idLabel);
		add(pwLabel);
		add(idTf);
		add(pwTf);
		add(loginBtn);
		add(searchIdBtn);
		add(searchPwBtn);
		add(joinBtn);
		
		// 위치와 크기 설정
		LoginLabel.setBounds(0, 20, 500, 50);
		idLabel.setBounds(40, 100, 80, 30);
		pwLabel.setBounds(40, 140, 80, 30);
		idTf.setBounds(120, 100, 200, 30);
		pwTf.setBounds(120, 140, 200, 30);
		loginBtn.setBounds(335, 100, 120, 70);
		searchIdBtn.setBounds(50, 200, 120, 30);
		searchPwBtn.setBounds(180, 200, 120, 30);
		joinBtn.setBounds(320, 200, 120, 30);
		
		// id텍스트필드 마우스 클릭 이벤트
		idTf.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	        	 idTf.setText("");
	         }
	    });
		
		// pw텍스트필드 마우스 클릭 이벤트
		pwTf.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	        	 pwTf.setText("");
	         }
	    });
		
		
		// 버튼 테두리 설정
		searchIdBtn.setBorderPainted(false);
		searchPwBtn.setBorderPainted(false);
		joinBtn.setBorderPainted(false);
		
		// 버튼 영역 배경 표시 설정
		searchIdBtn.setContentAreaFilled(false);
		searchPwBtn.setContentAreaFilled(false);
		joinBtn.setContentAreaFilled(false);
	
		// 포커스 표시 설정
		loginBtn.setFocusPainted(false);
		searchIdBtn.setFocusPainted(false);
		searchPwBtn.setFocusPainted(false);
		joinBtn.setFocusPainted(false);
		
		// 로그인 버튼 이벤트
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				// new memberInfoScreen(); // 회원정보창으로 이동
				 new SeatTicketScreen();	// 발권창으로 이동
			}
		});
		
		// 아이디 찾기 버튼 이벤트
		searchIdBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				// new searchIdScreen();
			}
		});
		
		
		// 비밀번호 찾기 버튼 이벤트
		 searchPwBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				// new searchPwScreen();
			}
		});
		
		// 회원가입 버튼 이벤트
		joinBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				// new JoinScreen();
			}
		});
		
		
		
		
		LoginLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 24));
		idLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		pwLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		idTf.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		pwTf.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		loginBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		searchIdBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		searchPwBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		joinBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		
		
		LoginLabel.setForeground(Color.WHITE);
		idLabel.setForeground(Color.WHITE);
		pwLabel.setForeground(Color.WHITE);
		idTf.setForeground(Color.WHITE);
		pwTf.setForeground(Color.WHITE);
	
		searchIdBtn.setForeground(Color.WHITE);
		searchPwBtn.setForeground(Color.WHITE);
		joinBtn.setForeground(Color.WHITE);
		
		
		
		// 기본 프레임 세팅
		setTitle("회원 로그인");
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setMinimumSize(new Dimension(500, 300));
		
		
		// 메인 배경색상 변경
		Color c = new Color(42, 64, 61);
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setBackground(c);
		p.setBounds(0, 0, 500, 300);
		add(p);
		
		
		
	}
	
	public static void main(String[] args) {
		new MemberLoginFrame();
	}
}
