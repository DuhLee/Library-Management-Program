package lmp.admin.menu.readingroom.sj;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ReadingRoomFrame extends JFrame {
	
	public ReadingRoomFrame() {
		setTitle("열람실 자리 현황");
		add(getPanel());
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 1200, 800);	// setBounds(300, 100, 1200, 800);
		
	}
	
	public JPanel getPanel() {
		JPanel myPanel = new JPanel();
		
		// 패널추가
		JPanel titlePanel = new JPanel();	// 제목 라벨이 붙을 패널
		JPanel ticketPanel = new JPanel();
		JPanel cntPanel = new JPanel();		// 총좌석, 사용중, 사용가능 라벨이 붙을 패널
		
		// 라벨추가
		JLabel titleLabel = new JLabel("현재 좌석 배치도", JLabel.CENTER);
		JLabel totalLabel = new JLabel("총 좌석", JLabel.CENTER);
		JLabel totalCntLabel = new JLabel("", JLabel.CENTER);
		JLabel usingLabel = new JLabel("사용중", JLabel.CENTER);
		JLabel usingCntLabel = new JLabel("", JLabel.CENTER);
		JLabel remainLabel = new JLabel("사용가능", JLabel.CENTER);
		JLabel remainCntLabel = new JLabel("", JLabel.CENTER);
		JLabel maleLabel = new JLabel("남성", JLabel.CENTER);
		JLabel femaleLabel = new JLabel("여성", JLabel.CENTER);
		JLabel maleColorLabel = new JLabel("", JLabel.CENTER);
		JLabel femaleColorLabel = new JLabel("", JLabel.CENTER);
		
		// maleColorLabel, femaleColorLabel --> 이미지 넣기
		ImageIcon maleImg = new ImageIcon("menu_images/male.png");
		ImageIcon femaleImg = new ImageIcon("menu_images/female.png");
		maleColorLabel = new JLabel("", maleImg, JLabel.CENTER);
		femaleColorLabel = new JLabel("", femaleImg, JLabel.CENTER);

		
		// 버튼 추가
		JButton ticketBtn = new JButton("좌석발권");	// 좌석 발권 버튼
		JButton btn01 = new JButton("01");
		JButton btn02 = new JButton("02");
		JButton btn03 = new JButton("03");
		JButton btn04 = new JButton("04");
		JButton btn05 = new JButton("05");
		JButton btn06 = new JButton("06");
		JButton btn07 = new JButton("07");	
		JButton btn08 = new JButton("08");
		JButton btn09 = new JButton("09");
		JButton btn10 = new JButton("10");
		JButton btn11 = new JButton("11");
		JButton btn12 = new JButton("12");
		JButton btn13 = new JButton("13");
		JButton btn14 = new JButton("14");
		JButton btn15 = new JButton("15");
		JButton btn16 = new JButton("16");
		JButton btn17 = new JButton("17");
		JButton btn18 = new JButton("18");
		
		// 테두리
		LineBorder totalCntlb = new LineBorder(Color.WHITE, 1, true);
		LineBorder usingCntlb = new LineBorder(Color.WHITE, 1, true);
		LineBorder remainCntlb = new LineBorder(Color.WHITE, 1, true);
		
		// 패널 간 배치
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
		ticketPanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
		cntPanel.setLayout(new BoxLayout(cntPanel, BoxLayout.Y_AXIS));
		
		// 패널 배경
		titlePanel.setBackground(Color.WHITE);
		cntPanel.setBackground(Color.WHITE);
		
		// 패널 위치와 크기
		titlePanel.setBounds(50, 50, 300, 100);
		cntPanel.setBounds(50, 150, 1000, 50);

		// 프레임에 라벨 추가
		this.add(titleLabel);
		this.add(totalLabel);
		this.add(totalCntLabel);
		this.add(usingLabel);
		this.add(usingCntLabel);
		this.add(remainLabel);
		this.add(remainCntLabel);
		this.add(maleLabel);
		this.add(femaleLabel);
		this.add(maleColorLabel);
		this.add(femaleColorLabel);

		// count 라벨에 해당 좌석 숫자 표시
		totalCntLabel.setText("18");	
		usingCntLabel.setText("8");	
		remainCntLabel.setText("10");	
		
		// count 라벨에 테두리 추가
		totalCntLabel.setBorder(totalCntlb);
		usingCntLabel.setBorder(usingCntlb);
		remainCntLabel.setBorder(remainCntlb);
		
		// 라벨의 위치와 크기
		titleLabel.setBounds(100, 180, 1100, 50);
		totalLabel.setBounds(100, 250, 100, 30);
		totalCntLabel.setBounds(200, 250, 100, 30);
		usingLabel.setBounds(350, 250, 100, 30);
		usingCntLabel.setBounds(450, 250, 100, 30);
		remainLabel.setBounds(600, 250, 100, 30);
		remainCntLabel.setBounds(700, 250, 100, 30);
		maleLabel.setBounds(900, 250, 50, 30);
		femaleLabel.setBounds(1000, 250, 50, 30);
		maleColorLabel.setBounds(950, 250, 30, 30);
		femaleColorLabel.setBounds(1050, 250, 30, 30);
		
		// 라벨 폰트
		titleLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 30));
		totalLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
		totalCntLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
		usingLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
		usingCntLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
		remainLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
		remainCntLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
		maleLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
		femaleLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
		
		// 라벨 색상
		titleLabel.setForeground(Color.WHITE);
		totalLabel.setForeground(Color.WHITE);
		totalCntLabel.setForeground(Color.WHITE);
		usingLabel.setForeground(Color.WHITE);
		usingCntLabel.setForeground(Color.WHITE);
		remainLabel.setForeground(Color.WHITE);
		remainCntLabel.setForeground(Color.WHITE);
		maleLabel.setForeground(Color.WHITE);
		femaleLabel.setForeground(Color.WHITE);
		maleColorLabel.setForeground(Color.WHITE);
		femaleColorLabel.setForeground(Color.WHITE);

		
		// 버튼 추가
		this.add(ticketBtn);
		this.add(btn01);
		this.add(btn02);
		this.add(btn03);
		this.add(btn04);
		this.add(btn05);
		this.add(btn06);
		this.add(btn07);
		this.add(btn08);
		this.add(btn09);
		this.add(btn10);
		this.add(btn11);
		this.add(btn12);
		this.add(btn13);
		this.add(btn14);
		this.add(btn15);
		this.add(btn16);
		this.add(btn17);
		this.add(btn18);
		
		// 버튼 위치와 크기
		ticketBtn.setBounds(900, 120, 200, 50);
		btn01.setBounds(200, 380, 95, 95);
		btn02.setBounds(200, 480, 95, 95);
		btn03.setBounds(200, 580, 95, 95);
		btn04.setBounds(300, 380, 95, 95);
		btn05.setBounds(300, 480, 95, 95);
		btn06.setBounds(300, 580, 95, 95);
		btn07.setBounds(500, 380, 95, 95);
		btn08.setBounds(500, 480, 95, 95);
		btn09.setBounds(500, 580, 95, 95);
		btn10.setBounds(600, 380, 95, 95);
		btn11.setBounds(600, 480, 95, 95);
		btn12.setBounds(600, 580, 95, 95);
		btn13.setBounds(800, 380, 95, 95);
		btn14.setBounds(800, 480, 95, 95);
		btn15.setBounds(800, 580, 95, 95);
		btn16.setBounds(900, 380, 95, 95);
		btn17.setBounds(900, 480, 95, 95);
		btn18.setBounds(900, 580, 95, 95);
		                            
		// 버튼 폰트
		btn01.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn02.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn03.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn04.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn05.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn06.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn07.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn08.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn09.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn10.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn11.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn12.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn13.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn14.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn15.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn16.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn17.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		btn18.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		
//		btn01
//		btn02
//		btn03
//		btn04
//		btn05
//		btn06
//		btn07
//		btn08
//		btn09
//		btn10
//		btn11
//		btn12
//		btn13
//		btn14
//		btn15
//		btn16
//		btn17
//		btn18
		
		// 버튼 폰트
		ticketBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 20));

		// 버튼 이벤트
		ticketBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MemberLoginFrame();
			}
		});
		
		this.add(myPanel);
		myPanel.add(titlePanel);
		myPanel.add(cntPanel);
		myPanel.setBounds(0, 100, 1100, 600);
		
		// 서브 배경색상 변경
		Color c2 =  new Color(126, 151, 148);
		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		p2.setBackground(c2);
		p2.setBounds(50, 100, 1100, 600);
		add(p2);
		
		// 메인 배경색상 변경
		Color c = new Color(42, 64, 61);
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setBackground(c);
		p.setBounds(0, 0, 1200, 800);
		add(p);
		
		
		return myPanel;
	}


	public static void main(String[] args) {	
		new ReadingRoomFrame();
	}


}
