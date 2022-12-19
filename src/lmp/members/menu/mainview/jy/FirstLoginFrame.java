package lmp.members.menu.mainview.jy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FirstLoginFrame {


	public FirstLoginFrame() {

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();


		Color panelColor = new Color(49, 82, 91);
		Color btnColor = new Color(204, 139, 101);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBackground(panelColor);
		panel.setSize(500, 400);

		Font font = new Font("한컴 말랑말랑 Regular", Font.PLAIN, 30);




		JButton memberBtn = new JButton("회원") {
			{
				setBounds(50, 100, 150, 150);
				addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						MemberFrame memberframe = new MemberFrame();
						memberframe.open();
					}
				});
			}
		};


		JButton managerBtn = new JButton("관리자") {
			{
				setBounds(280, 100, 150, 150);
				addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						ManagerLoginFrame managerloginframe = new ManagerLoginFrame();
						managerloginframe.open();
					}
				});
			}
		};


		memberBtn.setFont(font);
		managerBtn.setFont(font);
		memberBtn.setForeground(Color.WHITE);
		managerBtn.setForeground(Color.WHITE);

		memberBtn.setBackground(btnColor);
		managerBtn.setBackground(btnColor);

		memberBtn.setBorderPainted(false);
		managerBtn.setBorderPainted(false);


		frame.add(memberBtn);
		frame.add(managerBtn);
		frame.add(panel);
		frame.setTitle("도서관 관리 프로그램");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(new Dimension(500, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // 화면 중앙에 띄우기
	}


	public static void main(String[] args) {
		new FirstLoginFrame();
	}
}