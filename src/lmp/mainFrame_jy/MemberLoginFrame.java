package lmp.mainFrame_jy;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class MemberLoginFrame {


	public void ManagerLoginFrame() {
		JFrame frame = new JFrame("회원 로그인");
		JPanel panel = new JPanel();

		Font font = new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14);

		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBackground(new Color(186, 206, 194));
		panel.setSize(400, 300);

		JLabel LoginLabel = new JLabel("회원 로그인");
		JLabel memberIdLabel = new JLabel("아이디");
		JLabel memberPwLabel = new JLabel("비밀번호");
		LoginLabel.setBounds(150, 30, 100, 30);
		memberIdLabel.setBounds(60, 80, 100, 30);
		memberPwLabel.setBounds(60, 120, 100, 30);
		LoginLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		memberIdLabel.setFont(font);
		memberPwLabel.setFont(font);
		LoginLabel.setForeground(Color.WHITE);
		memberIdLabel.setForeground(Color.WHITE);
		memberPwLabel.setForeground(Color.WHITE);


		JTextField memberIdTf = new JTextField("아이디를 입력하세요");
		JPasswordField memberPwTf = new JPasswordField("비밀번호를 입력하세요");
		memberIdTf.setBounds(130, 80, 180, 30);
		memberPwTf.setBounds(130, 120, 180, 30);
		memberIdTf.setForeground(Color.LIGHT_GRAY);
		memberPwTf.setForeground(Color.LIGHT_GRAY);
		memberIdTf.setBorder(null); // TextField 테두리 없애기
		memberPwTf.setBorder(null); // TextField 테두리 없애기

		memberIdTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberIdTf.setText(null);
			}
		});

		memberPwTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberPwTf.setText(null);
			}
		});


//		// 텍스트 필드에서 엔터키를 누르면 액션 이벤트 발생
//		memberIdTf.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				memberIdTf.setText(null);
//			}
//		});
//
//		memberPwTf.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				memberPwTf.setText(null);
//			}
//		});


		JButton loginBtn = new JButton("로그인") {
			{
				setBounds(90, 180, 80, 30);
				setFont(font);
				setBackground(Color.LIGHT_GRAY);
				setForeground(Color.WHITE);
				setBorderPainted(false);
				setFocusPainted(false); // 버튼 선택시 외곽선 없애기 
				// 로그인 버튼 이벤트
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String id = memberIdTf.getText();
						char[] pw = memberPwTf.getPassword();
						String password = new String(pw);
						if (id.equals("test") && password.equals("1234")) {
							new MemberFrame();
							frame.dispose();
							// new 회원용 열람실 입력하기
							JOptionPane.showConfirmDialog(null, "로그인에 성공하였습니다.", "Message", JOptionPane.PLAIN_MESSAGE);
							frame.toFront();	
						} else {
							frame.dispose();
							JOptionPane.showConfirmDialog(null, "로그인에 실패하였습니다.", "Message", JOptionPane.PLAIN_MESSAGE);
						}
					}
				});
			}
		};


		JButton cancelBtn = new JButton("취소") {
			{
				setBounds(220, 180, 80, 30);
				setFocusPainted(false); // 버튼 선택시 외곽선 없애기 
				setFont(font);
				setBackground(Color.LIGHT_GRAY);
				setForeground(Color.WHITE);
				setBorderPainted(false);

				addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);

					}
				});
			}
		};

		JButton findIdBtn = new JButton("아이디 찾기") {
			{
				setBounds(15, 220, 130, 30);
				setFont(font);
				setBackground(Color.LIGHT_GRAY);
				setForeground(Color.WHITE);
				setFocusPainted(false); // 버튼 선택시 외곽선 없애기 
				setBorderPainted(false);
				setContentAreaFilled(false);
				setBorderPainted(false);

				addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);

					}
				});
			}
		};

		JButton findPwBtn = new JButton("비밀번호 찾기") {
			{
				setBounds(135, 220, 130, 30);
				setFont(font);
				setBackground(Color.LIGHT_GRAY);
				setForeground(Color.WHITE);
				setFocusPainted(false); // 버튼 선택시 외곽선 없애기 
				setBorderPainted(false);
				setContentAreaFilled(false);
				setBorderPainted(false);

				addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);

					}
				});
			}
		};

		JButton joinBtn = new JButton("회원가입") {
			{
				setBounds(240, 220, 130, 30);
				setFont(font);
				setBackground(Color.LIGHT_GRAY);
				setForeground(Color.WHITE);
				setFocusPainted(false); // 버튼 선택시 외곽선 없애기 
				setBorderPainted(false);
				setContentAreaFilled(false);
				setBorderPainted(false);

				addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);

					}
				});
			}
		};





		frame.add(loginBtn);
		frame.add(cancelBtn);
		frame.add(findIdBtn);
		frame.add(findPwBtn);
		frame.add(joinBtn);

		frame.add(LoginLabel);
		frame.add(memberIdLabel);
		frame.add(memberPwLabel);
		frame.add(memberIdTf);
		frame.add(memberPwTf);
		frame.add(panel);
		frame.setTitle("관리자 로그인");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null); // 화면 중앙에 띄우기
	}


	public static void main(String[] args) {
		new ManagerLoginFrame();
	}

	public void open() {
		this.ManagerLoginFrame();
	}

}