package lmp.mainFrame_jy;

import java.awt.BorderLayout;



import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lmp.admin.menu.readingroom.ReadingRoomMgmt;
import lmp.admin.menu.readingroom.readingroom_jy.ReadingRoomFrame;


public class ManagerFrame extends JFrame {

	public void ManagerFrame() {
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
		ImageIcon rentImg = new ImageIcon("./images/대출반납.png");
		ImageIcon roomImg = new ImageIcon("./images/열람실.png");
		ImageIcon memImg = new ImageIcon("./images/회원관리.png");
		ImageIcon empImg = new ImageIcon("./images/직원관리.png");
		ImageIcon mainImg = new ImageIcon("./images/메인창.jpg");

		// 이미지 사이즈 변경
		Image bookimg = bookImg.getImage();
		Image bookimgs = bookimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon changebook = new ImageIcon(bookimgs);

		Image rentimg = rentImg.getImage();
		Image rentimgs = rentimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon changerent = new ImageIcon(rentimgs);

		Image roomimg = roomImg.getImage();
		Image roomimgs = roomimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon changeroom = new ImageIcon(roomimgs);

		Image memimg = memImg.getImage();
		Image memimgs = memimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon changemem = new ImageIcon(memimgs);

		Image empimg = empImg.getImage();
		Image empimgs = empimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon changeemp = new ImageIcon(empimgs);
		
		Image mainimg = mainImg.getImage();
		Image mainimgs = mainimg.getScaledInstance(1150, 635, mainimg.SCALE_SMOOTH);
		ImageIcon changeMain = new ImageIcon(mainimgs);


		// 버튼에 이미지아이콘 넣기
		JButton bookBtn = new JButton(changebook);
		JButton rentBtn = new JButton(changerent);
		JButton roomBtn = new JButton(changeroom);

		roomBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				new ReadingRoomFrame();
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		
		JButton memberBtn = new JButton(changemem);
		JButton empBtn = new JButton(changeemp);

		// 버튼 외곽선 가리기
		bookBtn.setBorderPainted(false);
		rentBtn.setBorderPainted(false);
		roomBtn.setBorderPainted(false);
		memberBtn.setBorderPainted(false);
		empBtn.setBorderPainted(false);

		// 버튼 내부영역 채우지 않기
		bookBtn.setContentAreaFilled(false);
		rentBtn.setContentAreaFilled(false);
		roomBtn.setContentAreaFilled(false);
		memberBtn.setContentAreaFilled(false);
		empBtn.setContentAreaFilled(false);

		// 버튼 선택시 외곽선 없애기 
		bookBtn.setFocusPainted(false); 
		rentBtn.setFocusPainted(false);
		roomBtn.setFocusPainted(false);
		memberBtn.setFocusPainted(false);
		empBtn.setFocusPainted(false);

		JLabel bookLb = new JLabel("도서관리");
		JLabel rentLb = new JLabel("대출/반납");
		JLabel roomLb = new JLabel("열람실");
		JLabel memberLb = new JLabel("회원관리");
		JLabel empLb = new JLabel("직원관리");

		bookBtn.setBounds(150, 0, 100, 100);
		rentBtn.setBounds(350, 0, 100, 100);
		roomBtn.setBounds(550, 0, 100, 100);
		memberBtn.setBounds(750, 0, 100, 100);
		empBtn.setBounds(950, 0, 100, 100);

		bookLb.setBounds(175, 40, 100, 100);
		rentLb.setBounds(375, 40, 100, 100);
		roomLb.setBounds(580, 40, 100, 100);
		memberLb.setBounds(775, 40, 100, 100);
		empLb.setBounds(975, 40, 100, 100);


		// 버튼 및 라벨 폰트설정
		Font font = new Font("한컴 말랑말랑 Regular", Font.PLAIN, 15);

		bookBtn.setFont(font);
		rentBtn.setFont(font);
		roomBtn.setFont(font);
		memberBtn.setFont(font);
		empBtn.setFont(font);

		bookLb.setFont(font);
		rentLb.setFont(font);
		roomLb.setFont(font);
		memberLb.setFont(font);
		empLb.setFont(font);

		bookLb.setForeground(Color.WHITE);
		rentLb.setForeground(Color.WHITE);
		roomLb.setForeground(Color.WHITE);
		memberLb.setForeground(Color.WHITE);
		empLb.setForeground(Color.WHITE);

		add(bookBtn);
		add(rentBtn);
		add(roomBtn);
		add(memberBtn);
		add(empBtn);

		add(bookLb);
		add(rentLb);
		add(roomLb);
		add(memberLb);
		add(empLb);

		// Main창 Panel2 이미지
		JLabel mainLb = new JLabel();
		mainLb.setIcon(changeMain);
		mainLb.setBounds(18, 110, 1150, 635);
		mainLb.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(mainLb);
		
		// 프레임에 패널을 추가
		add(panel2);
		add(panel1);

		setTitle("관리자전용");
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		setVisible(true);
		setResizable(false);// 창 크기 고정
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


	public void open() {
		this.ManagerFrame();
	}
}