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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import lmp.admin.AdminFrame;


public class ManagerLogin {


	public void ManagerLoginFrame() {
		JFrame frame = new JFrame("관리자 로그인");
		JPanel panel = new JPanel();

		Font font = new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14);

		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBackground(new Color(186, 206, 194));
		panel.setSize(400, 300);

		JLabel LoginLabel = new JLabel("관리자 로그인");
		JLabel managerIdLabel = new JLabel("관리자번호");
		JLabel managerPwLabel = new JLabel("관리자암호");
		LoginLabel.setBounds(140, 30, 150, 30);
		managerIdLabel.setBounds(60, 80, 100, 30);
		managerPwLabel.setBounds(60, 120, 100, 30);
		LoginLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		managerIdLabel.setFont(font);
		managerPwLabel.setFont(font);
		LoginLabel.setForeground(Color.WHITE);
		managerIdLabel.setForeground(Color.WHITE);
		managerPwLabel.setForeground(Color.WHITE);


		JTextField managerIdTf = new JTextField("관리자번호를 입력하세요");
		JPasswordField managerPwTf = new JPasswordField("관리자암호를 입력하세요");
		managerIdTf.setBounds(130, 80, 180, 30);
		managerPwTf.setBounds(130, 120, 180, 30);
		managerIdTf.setForeground(Color.LIGHT_GRAY);
		managerPwTf.setForeground(Color.LIGHT_GRAY);
		managerIdTf.setBorder(null); // TextField 테두리 없애기
		managerPwTf.setBorder(null); // TextField 테두리 없애기

		managerIdTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				managerIdTf.setText(null);
			}
		});

		managerPwTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				managerPwTf.setText(null);
			}
		});


//		// 텍스트 필드에서 엔터키를 누르면 액션 이벤트 발생
//		managerIdTf.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				managerIdTf.setText(null);
//			}
//		});
//
//		managerPwTf.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				managerPwTf.setText(null);
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
						String id = managerIdTf.getText();
						char[] pw = managerPwTf.getPassword();
						String password = new String(pw);
						//					            System.out.println(id);
						//					            System.out.println(password);
						if (id.equals("test") && password.equals("1234")) {
							frame.dispose();
							new AdminFrame();
							JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다.", "로그인 실패", 1);
							frame.toFront();
							
						} else {
							frame.dispose();
							JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.", "로그인 실패", 1);
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






		frame.add(loginBtn);
		frame.add(cancelBtn);
		frame.add(LoginLabel);
		frame.add(managerIdLabel);
		frame.add(managerPwLabel);
		frame.add(managerIdTf);
		frame.add(managerPwTf);
		frame.add(panel);
		frame.setTitle("관리자 로그인");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(new Dimension(400, 300));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null); // 화면 중앙에 띄우기
	}


	public static void main(String[] args) {
		new ManagerLogin();
	}

	public void open() {
		this.ManagerLoginFrame();
	}

}