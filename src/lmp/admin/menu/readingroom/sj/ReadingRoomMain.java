package lmp.admin.menu.readingroom.sj;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import lmp.db.dao.SeatUseDetailDao;
import lmp.db.vo.SeatUseDetailVO;

public class ReadingRoomMain extends JFrame {

	int totalSeatCnt = 60;
	Font font = new Font("한컴 말랑말랑 Regular", Font.PLAIN, 15);

	LineBorder lb = new LineBorder(Color.WHITE, 1, true);


	public ReadingRoomMain() {

		

		JLabel titleLabel = new JLabel("현재 좌석 배치도", JLabel.CENTER);
		this.add(titleLabel);
		titleLabel.setBounds(100, 180, 1000, 50);
		titleLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 30));
		titleLabel.setForeground(Color.WHITE);

		JButton exitBtn = new JButton("퇴실하기");
		add(exitBtn);
		exitBtn.setBounds(1030, 120, 100, 30);
		exitBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 15));
		exitBtn.setForeground(Color.WHITE);
		exitBtn.setBackground(Color.LIGHT_GRAY);
		exitBtn.setBorderPainted(false);
		exitBtn.setFocusPainted(false); 
		
		JLabel usingLabel = new JLabel("사용중", JLabel.CENTER);		
		this.add(usingLabel);
		usingLabel.setBounds(200, 250, 100, 30);
		usingLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 16));
		usingLabel.setForeground(Color.WHITE);

		JLabel usingCntLabel = new JLabel("", JLabel.CENTER);
		this.add(usingCntLabel);
		lb = new LineBorder(Color.WHITE, 1, true);
		usingCntLabel.setBorder(lb);
		usingCntLabel.setBounds(300, 250, 100, 30);
		usingCntLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
		usingCntLabel.setForeground(Color.WHITE);

		JLabel totalLabel = new JLabel("총 좌석", JLabel.CENTER);
		this.add(totalLabel);
		totalLabel.setBounds(400, 250, 100, 30);
		totalLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 16));
		totalLabel.setForeground(Color.WHITE);

		JLabel totalCntLabel = new JLabel("", JLabel.CENTER);
		this.add(totalCntLabel);
		lb = new LineBorder(Color.WHITE, 1, true);
		totalCntLabel.setBorder(lb);
		totalCntLabel.setBounds(500, 250, 100, 30);
		totalCntLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
		totalCntLabel.setForeground(Color.WHITE);

		JLabel remainLabel = new JLabel("사용가능", JLabel.CENTER);
		this.add(remainLabel);
		remainLabel.setBounds(600, 250, 100, 30);
		remainLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 16));
		remainLabel.setForeground(Color.WHITE);

		JLabel remainCntLabel = new JLabel("", JLabel.CENTER);
		this.add(remainCntLabel);
		lb = new LineBorder(Color.WHITE, 1, true);
		remainCntLabel.setBorder(lb);
		remainCntLabel.setBounds(700, 250, 100, 30);
		remainCntLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
		remainCntLabel.setForeground(Color.WHITE);

		JLabel maleLabel = new JLabel("남성", JLabel.CENTER);
		this.add(maleLabel);
		maleLabel.setBounds(850, 250, 50, 30);
		maleLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 16));
		maleLabel.setForeground(Color.WHITE);

		JLabel maleColorLabel = new JLabel("", JLabel.CENTER);
		ImageIcon maleImg = new ImageIcon("images/male.png");
		maleColorLabel = new JLabel("", maleImg, JLabel.CENTER);
		this.add(maleColorLabel);
		maleColorLabel.setBounds(900, 250, 30, 30);
		maleColorLabel.setForeground(Color.WHITE);

		JLabel femaleLabel = new JLabel("여성", JLabel.CENTER);
		this.add(femaleLabel);
		femaleLabel.setBounds(950, 250, 50, 30);
		femaleLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 16));
		femaleLabel.setForeground(Color.WHITE);

		JLabel femaleColorLabel = new JLabel("", JLabel.CENTER);
		ImageIcon femaleImg = new ImageIcon("images/female.png");
		femaleColorLabel = new JLabel("", femaleImg, JLabel.CENTER);
		this.add(femaleColorLabel);
		femaleColorLabel.setBounds(1000, 250, 30, 30);
		femaleColorLabel.setForeground(Color.WHITE);


		// count 라벨에 해당 좌석 숫자 표시
		SeatUseDetailDao sudDao = new SeatUseDetailDao();
		ArrayList<SeatUseDetailVO> sudList=  new ArrayList<>();
		try {
			// usingCntLabel(사용중)
			sudList.addAll(sudDao.get());
			usingCntLabel.setText(sudList.size() + "");
			// remainCntLabel(잔여좌석)
			int rCnt = 60 - sudList.size();
			remainCntLabel.setText(rCnt + "");
			// totalCntLabel(총좌석)
			totalCntLabel.setText("60");	
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		
		
		
		
//		// 좌석 1~60 추가
//		JLabel[] labels = new JLabel[60];
//		for(int i = 0; i < labels.length; i++) {
//			labels[i] = new JLabel("" + (i + 1) +"번", JLabel.CENTER);
//			labels[i].setOpaque(true);
//			labels[i].setFont(font);
//			labels[i].setBorder(javax.swing.BorderFactory.createEmptyBorder());
//			add(labels[i]);
//		}
//		
//		labels[0].setBounds(100, 350, 90, 30);
//		labels[1].setBounds(200, 350, 90, 30);
//		labels[2].setBounds(300, 350, 90, 30);
//		labels[3].setBounds(400, 350, 90, 30);
//		labels[4].setBounds(500, 350, 90, 30);
//		labels[5].setBounds(600, 350, 90, 30);
//		labels[6].setBounds(700, 350, 90, 30);
//		labels[7].setBounds(800, 350, 90, 30);
//		labels[8].setBounds(900, 350, 90, 30);
//		labels[9].setBounds(1000, 350, 90, 30);
//		
//		labels[10].setBounds(100, 400, 90, 30);
//		labels[11].setBounds(200, 400, 90, 30);
//		labels[12].setBounds(300, 400, 90, 30);
//		labels[13].setBounds(400, 400, 90, 30);
//		labels[14].setBounds(500, 400, 90, 30);
//		labels[15].setBounds(600, 400, 90, 30);
//		labels[16].setBounds(700, 400, 90, 30);
//		labels[17].setBounds(800, 400, 90, 30);
//		labels[18].setBounds(900, 400, 90, 30);
//		labels[19].setBounds(1000, 400, 90, 30);
//		
//		labels[20].setBounds(100, 450, 90, 30);
//		labels[21].setBounds(200, 450, 90, 30);
//		labels[22].setBounds(300, 450, 90, 30);
//		labels[23].setBounds(400, 450, 90, 30);
//		labels[24].setBounds(500, 450, 90, 30);
//		labels[25].setBounds(600, 450, 90, 30);
//		labels[26].setBounds(700, 450, 90, 30);
//		labels[27].setBounds(800, 450, 90, 30);
//		labels[28].setBounds(900, 450, 90, 30);
//		labels[29].setBounds(1000, 450, 90, 30);
//		
//		labels[30].setBounds(100, 500, 90, 30);
//		labels[31].setBounds(200, 500, 90, 30);
//		labels[32].setBounds(300, 500, 90, 30);
//		labels[33].setBounds(400, 500, 90, 30);
//		labels[34].setBounds(500, 500, 90, 30);
//		labels[35].setBounds(600, 500, 90, 30);
//		labels[36].setBounds(700, 500, 90, 30);
//		labels[37].setBounds(800, 500, 90, 30);
//		labels[38].setBounds(900, 500, 90, 30);
//		labels[39].setBounds(1000, 500, 90, 30);
//		
//		labels[40].setBounds(100, 550, 90, 30);
//		labels[41].setBounds(200, 550, 90, 30);
//		labels[42].setBounds(300, 550, 90, 30);
//		labels[43].setBounds(400, 550, 90, 30);
//		labels[44].setBounds(500, 550, 90, 30);
//		labels[45].setBounds(600, 550, 90, 30);
//		labels[46].setBounds(700, 550, 90, 30);
//		labels[47].setBounds(800, 550, 90, 30);
//		labels[48].setBounds(900, 550, 90, 30);
//		labels[49].setBounds(1000, 550, 90, 30);
//		
//		labels[50].setBounds(100, 600, 90, 30);
//		labels[51].setBounds(200, 600, 90, 30);
//		labels[52].setBounds(300, 600, 90, 30);
//		labels[53].setBounds(400, 600, 90, 30);
//		labels[54].setBounds(500, 600, 90, 30);
//		labels[55].setBounds(600, 600, 90, 30);
//		labels[56].setBounds(700, 600, 90, 30);
//		labels[57].setBounds(800, 600, 90, 30);
//		labels[58].setBounds(900, 600, 90, 30);
//		labels[59].setBounds(1000, 600, 90, 30);
		
			
		
		
//		// 좌석 1~ 60번 이벤트 (60개 같은 동작 실행)
//				// Local variable i defined in an enclosing scope must be final or effectively final -- 오류발생
//				// final int j = i; 추가함
//				try {
//					sudList.addAll(sudDao.get());
//				
//					for (int i = 0; i < totalSeatCnt; i++) {
//						final int j = i;
//						labels[i].addMouseListener(new MouseAdapter() {
//							@Override
//							public void mouseClicked(MouseEvent e) {
//								super.mouseClicked(e);
//								int result = JOptionPane.showConfirmDialog(labels[j], "좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
//								if (result == JOptionPane.NO_OPTION) {
//
//									dispose();
//									setVisible(true);
//								} else if (result == JOptionPane.YES_OPTION) {
//
//									// 로그인 정보 넘어와야 하는 부분 아직...
//									
//									
//									SeatUseDetailDao sudDao = new SeatUseDetailDao();
//									ArrayList<SeatUseDetailVO> sudList=  new ArrayList<>();
//								
//									try {
//										sudList.addAll(sudDao.get());
//										for (SeatUseDetailVO sud : sudList) {
//											if (sud.getReadingroom().getSeatNum().equals(j) && sud.getMember().getSex().equals("0")) {
//												labels[sud.getReadingroom().getSeatNum() - 1].setBackground(Color.BLUE);
//											} else if (sud.getReadingroom().getSeatNum().equals(j) && sud.getMember().getSex().equals("1")) {
//												labels[sud.getReadingroom().getSeatNum() - 1].setBackground(Color.PINK);
//											}
//										}
//									} catch (SQLException e2) {
//										// TODO Auto-generated catch block
//										e2.printStackTrace();
//									}
//									JOptionPane.showMessageDialog(labels[j], "좌석 발권이 완료되었습니다.", "Message", 1);
//								} 
//							}	
//						});
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}

					
		
	
		// 서브 배경색상 변경
		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
		p2.setBackground(new Color(126, 151, 148));
		p2.setBounds(50, 100, 1100, 600);
		add(p2);

		// 메인 배경색상 변경
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setBackground(new Color(42, 64, 61));
		p.setBounds(0, 0, 1200, 800);
		add(p);
		
		// 기본 세팅
		setTitle("열람실 자리 현황");
		setVisible(true);
		setResizable(false);
		setSize(1200, 800);	// setBounds(300, 100, 1200, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



	}


	public static void main(String[] args) {	
		new ReadingRoomMain();
	}

}
