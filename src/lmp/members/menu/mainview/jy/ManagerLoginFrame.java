package lmp.members.menu.mainview.jy;

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
import javax.swing.JTextField;

public class ManagerLoginFrame {


	public void ManagerLoginFrame() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		Font font = new Font("한컴 말랑말랑 Regular", Font.BOLD, 14);

		Color panelColor = new Color(49, 82, 91);
		Color btnColor = new Color(204, 139, 101);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBackground(panelColor);
		panel.setSize(400, 300);

		JLabel managerIdLabel = new JLabel("관리자번호");
		JLabel managerPwLabel = new JLabel("관리자암호");
		managerIdLabel.setBounds(40, 80, 100, 30);
		managerPwLabel.setBounds(40, 120, 100, 30);
		managerIdLabel.setFont(font);
		managerPwLabel.setFont(font);
		managerIdLabel.setForeground(Color.WHITE);
		managerPwLabel.setForeground(Color.WHITE);


		JTextField managerIdTf = new JTextField("관리자번호를 입력하세요");
		JPasswordField managerPwTf = new JPasswordField("관리자암호를 입력하세요");
		managerIdTf.setBounds(130, 80, 180, 30);
		managerPwTf.setBounds(130, 120, 180, 30);
		managerIdTf.setForeground(Color.LIGHT_GRAY);
		managerPwTf.setForeground(Color.LIGHT_GRAY);
		managerIdTf.setBorder(null);
		managerPwTf.setBorder(null);

		managerIdTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				managerIdTf.setText("");
			}
		});

		managerPwTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				managerPwTf.setText("");
			}
		});


		// 텍스트 필드에서 엔터키를 누르면 액션 이벤트 발생
		managerIdTf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				managerIdTf.setText(null);
			}
		});

		managerPwTf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				managerPwTf.setText(null);
			}
		});


		JButton loginBtn = new JButton("로그인") {
			{
				setBounds(90, 180, 80, 30);
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ManagerFrame managerframe = new ManagerFrame();
						managerframe.open();
					}
				});
			}
		};
		
		
		loginBtn.setBounds(90, 180, 80, 30);
		loginBtn.setFont(font);
		loginBtn.setBackground(Color.WHITE);
		loginBtn.setForeground(Color.GRAY);
		loginBtn.setBorderPainted(false);


		JButton cancelBtn = new JButton("취소") {
			{
				setBounds(220, 180, 80, 30);
				addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);

					}
				});
			}
		};
		
		cancelBtn.setFont(font);
		cancelBtn.setBackground(Color.WHITE);
		cancelBtn.setForeground(Color.GRAY);
		cancelBtn.setBorderPainted(false);





		frame.add(loginBtn);
		frame.add(cancelBtn);

		frame.add(managerIdLabel);
		frame.add(managerPwLabel);
		frame.add(managerIdTf);
		frame.add(managerPwTf);
		frame.add(panel);
		frame.setTitle("관리자 로그인");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(new Dimension(400, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // 화면 중앙에 띄우기
	}

	public void open() {
		this.ManagerLoginFrame();
	}
	
	public void close() {
	}
}