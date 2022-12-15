package lmp.mainFrame_jy;

import java.awt.Color;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MemberFrame {

	public void MemberFrame() {
		JFrame frame = new JFrame("회원전용");
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		panel1.setBackground(new Color(42, 64, 61));
		panel1.setBounds(0, 0, 1200, 800);

		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		panel2.setBackground(new Color(126, 151, 148));
		panel2.setBounds(18, 110, 1150, 635);

		// 이미지 아이콘 만들기
		ImageIcon bookImg = new ImageIcon("./images/도서.png");
		ImageIcon roomImg = new ImageIcon("./images/열람실.png");
		ImageIcon memImg = new ImageIcon("./images/회원관리.png");
		ImageIcon mainImg = new ImageIcon("./images/메인창.jpg");

		// 이미지 사이즈 변경
		Image bookimg = bookImg.getImage();
		Image bookimgs = bookimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon changebook = new ImageIcon(bookimgs);

		Image roomimg = roomImg.getImage();
		Image roomimgs = roomimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon changeroom = new ImageIcon(roomimgs);

		Image memimg = memImg.getImage();
		Image memimgs = memimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon changemem = new ImageIcon(memimgs);

		Image mainimg = mainImg.getImage();
		Image mainimgs = mainimg.getScaledInstance(1150, 635, mainimg.SCALE_SMOOTH);
		ImageIcon changeMain = new ImageIcon(mainimgs);

		JButton bookBtn = new JButton(changebook);
		JButton roomBtn = new JButton(changeroom);
		JButton memberBtn = new JButton(changemem);

		// 버튼 외곽선 가리기
		bookBtn.setBorderPainted(false);
		roomBtn.setBorderPainted(false);
		memberBtn.setBorderPainted(false);

		// 버튼 내부영역 채우지 않기
		bookBtn.setContentAreaFilled(false);
		roomBtn.setContentAreaFilled(false);
		memberBtn.setContentAreaFilled(false);

		// 버튼 선택시 외곽선 없애기 
		bookBtn.setFocusPainted(false); 
		roomBtn.setFocusPainted(false);
		memberBtn.setFocusPainted(false);


		// 열람실 이벤트 설정 --> 바로 로그인 창으로 이동시키기
		roomBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberLoginFrame memberloginframe = new MemberLoginFrame();
				memberloginframe.open();
			}
		});

		// 회원정보 이벤트 설정 --> 바로 로그인 창으로 이동시키기
		memberBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberLoginFrame memberloginframe = new MemberLoginFrame();
				memberloginframe.open();
			}
		});





		JLabel bookLb = new JLabel("도서");
		JLabel roomLb = new JLabel("열람실");
		JLabel memberLb = new JLabel("회원정보");

		bookBtn.setBounds(150, 0, 100, 100);
		roomBtn.setBounds(350, 0, 100, 100);
		memberBtn.setBounds(550, 0, 100, 100);

		bookLb.setBounds(185, 40, 100, 100);
		roomLb.setBounds(380, 40, 100, 100);
		memberLb.setBounds(576, 40, 100, 100);


		// 버튼 및 라벨 폰트설정
		Font font = new Font("한컴 말랑말랑 Regular", Font.PLAIN, 15);

		bookBtn.setFont(font);
		roomBtn.setFont(font);
		memberBtn.setFont(font);

		bookLb.setFont(font);
		roomLb.setFont(font);
		memberLb.setFont(font);

		bookLb.setForeground(Color.WHITE);
		roomLb.setForeground(Color.WHITE);
		memberLb.setForeground(Color.WHITE);


		frame.add(bookBtn);
		frame.add(roomBtn);
		frame.add(memberBtn);


		frame.add(bookLb);
		frame.add(roomLb);
		frame.add(memberLb);

		// Main창 Panel2 이미지
		JLabel mainLb = new JLabel();
		mainLb.setIcon(changeMain);
		mainLb.setBounds(18, 110, 1150, 635);
		mainLb.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(mainLb);


		// 프레임에 패널을 추가	
		frame.add(panel2);
		frame.add(panel1);

		frame.setTitle("회원전용");
		frame.setBounds(0, 0, 1200, 800);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);// 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


	public void open() {
		this.MemberFrame();
	}
}