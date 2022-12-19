package lmp.loginJoin;

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
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FindIdFrame {


	public FindIdFrame() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		Font font = new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14);

		
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBackground(new Color(186, 206, 194));
		panel.setSize(300, 400);

		JLabel findIdLabel = new JLabel("아이디 찾기");
		findIdLabel.setBounds(100, 30, 150, 30);
		findIdLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		findIdLabel.setForeground(Color.WHITE);

		JLabel nameLabel = new JLabel("이　름");
		nameLabel.setBounds(30, 75, 50, 30);
		nameLabel.setFont(font);
		nameLabel.setForeground(Color.WHITE);

		JLabel emailLabel = new JLabel("이메일");
		emailLabel.setBounds(30, 120, 50, 30);
		emailLabel.setFont(font);
		emailLabel.setForeground(Color.WHITE);


		JTextField nameTf = new JTextField("이름을 입력하세요");
		JTextField emailTf = new JTextField("이메일을 입력하세요");
		nameTf.setBounds(75, 80, 180, 30);
		emailTf.setBounds(75, 120, 180, 30);
		nameTf.setForeground(Color.LIGHT_GRAY);
		emailTf.setForeground(Color.LIGHT_GRAY);
		nameTf.setBorder(null);
		emailTf.setBorder(null);

		nameTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nameTf.setText("");
			}
		});
		

		emailTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				emailTf.setText("");
			}
		});


		// 텍스트 필드에서 엔터키를 누르면 액션 이벤트 발생
		nameTf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nameTf.setText(null);
			}
		});

		emailTf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				emailTf.setText(null);
			}
		});
			

		JButton loginBtn = new JButton("찾기") {
			{
				setBounds(50, 300, 80, 30);
				setFont(font);
				setBackground(Color.LIGHT_GRAY);
				setForeground(Color.WHITE);
				setBorderPainted(false); // 버튼 외곽선 없애기
				setFocusPainted(false); // 버튼 선택시 외곽선 없애기 
				addActionListener(new ActionListener() {
//					if (id =! id) {
//					public void actionPerformed(ActionEvent e) {
//						failIdLogin failidlogin = new failIdLogin();
//					failidlogin.open();
//					}
//				}
					@Override
					public void actionPerformed(ActionEvent e) {
						FoundId foundid = new FoundId();
						foundid.open();
					}
				});
			}
		};


		JButton cancelBtn = new JButton("취소") {
			{
				setBounds(160, 300, 80, 30);
				setFont(font);
				setBackground(Color.LIGHT_GRAY);
				setForeground(Color.WHITE);
				setBorderPainted(false);
				setFocusPainted(false); // 버튼 선택시 외곽선 없애기 
				addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);

					}
				});
			}
		};
		
		frame.add(findIdLabel);
		frame.add(loginBtn);
		frame.add(cancelBtn);
		frame.add(nameLabel);
		frame.add(emailLabel);
		frame.add(nameTf);
		frame.add(emailTf);
		frame.add(panel);
		frame.setTitle("아이디 찾기");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(new Dimension(300, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // 화면 중앙에 띄우기
	}


	public static void main(String[] args) {
		new FindIdFrame();
	}

//	public void open() {
//		this.FindIdFrame();
//	}
}