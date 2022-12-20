package lmp.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lmp.admin.AdminFrame;
import lmp.members.MemberFrame;

public class EntranceFrame {


	public EntranceFrame() {

		JFrame frame = new JFrame();

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBackground(new Color(42, 64, 61));
		panel.setSize(500, 400);

		// 이미지 아이콘 만들기
		ImageIcon memberImg = new ImageIcon("src/lmp/admin/menuButtonImages/membersEntrance.png");
		ImageIcon managerImg = new ImageIcon("src/lmp/admin/menuButtonImages/adminEntrance.png");


		// 이미지 사이즈 변경
		Image memberImgs = memberImg.getImage();
		Image memberImgss = memberImgs.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon changemember = new ImageIcon(memberImgss);

		Image managerImgs = managerImg.getImage();
		Image managerImgss = managerImgs.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon changemanager = new ImageIcon(managerImgss);


		JButton memberBtn = new JButton(changemember) {
			{
				setBounds(60, 80, 150, 150);
				setBorderPainted(false); // 버튼외곽선 가리기
				setContentAreaFilled(false); // 버튼 내부영역 채우지 않기
				setFocusPainted(false); // 버튼 선택시 외곽선 없애기 
				addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						new MemberFrame();
						System.out.println("회원창");
					}
				});
			}
		};


		JButton managerBtn = new JButton(changemanager) {
			{
				setBounds(270, 80, 150, 150);
				setBorderPainted(false); // 버튼외곽선 가리기
				setContentAreaFilled(false); // 버튼 내부영역 채우지 않기
				setFocusPainted(false); // 버튼 선택시 외곽선 없애기 
				addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							new AdminFrame();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("관리자창");
					}
				});
			}
		};



		Font font = new Font("한컴 말랑말랑 Regular", Font.BOLD, 20);
		JLabel memberLb = new JLabel("회원용");
		memberLb.setBounds(110, 140, 150, 150);
		JLabel managerLb = new JLabel("관리자용");
		managerLb.setBounds(310, 140, 150, 150);


		memberLb.setFont(font);
		memberLb.setForeground(Color.WHITE);
		managerLb.setFont(font);
		managerLb.setForeground(Color.WHITE);


		frame.add(memberBtn);
		frame.add(managerBtn);
		frame.add(memberLb);
		frame.add(managerLb);
		frame.add(panel);
		frame.setTitle("도서관 관리 프로그램");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(new Dimension(500, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // 화면 중앙에 띄우기
	}


	public static void main(String[] args) {
		new EntranceFrame();
	}
}