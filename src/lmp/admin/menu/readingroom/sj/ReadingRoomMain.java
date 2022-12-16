package lmp.admin.menu.readingroom.sj;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import lmp.db.dao.SeatUseDetailDao;
import lmp.db.vo.SeatUseDetailVO;

public class ReadingRoomMain extends JFrame {

	// 좌석 배열 초기화
	int totalSeatCnt = 18;
	JLabel[] labels = new JLabel[totalSeatCnt];
	Font font = new Font("한컴 말랑말랑 Regular", Font.PLAIN, 15);

	public ReadingRoomMain() {
		setTitle("열람실 자리 현황");
		add(getPanel());
		setVisible(true);
		setResizable(false);
		setSize(1200, 800);	// setBounds(300, 100, 1200, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public JPanel getPanel() {
		JPanel myPanel = new JPanel();	// 각각의 패널이 붙을 전체 패널

		// 패널추가
		JPanel titlePanel = new JPanel();			// 제목(현재좌석배치도) 라벨이 붙을 패널
		JPanel cntPanel = new JPanel();			// 총좌석, 사용중, 사용가능 라벨이 붙을 패널

		// 라벨추가
		JLabel titleLabel = new JLabel("현재 좌석 배치도", JLabel.CENTER);
		JLabel usingLabel = new JLabel("사용중", JLabel.CENTER);					
		JLabel usingCntLabel = new JLabel("", JLabel.CENTER);
		JLabel totalLabel = new JLabel("총 좌석", JLabel.CENTER);
		JLabel totalCntLabel = new JLabel("", JLabel.CENTER);
		JLabel remainLabel = new JLabel("사용가능", JLabel.CENTER);
		JLabel remainCntLabel = new JLabel("", JLabel.CENTER);
		JLabel maleLabel = new JLabel("남성", JLabel.CENTER);
		JLabel femaleLabel = new JLabel("여성", JLabel.CENTER);
		JLabel maleColorLabel = new JLabel("", JLabel.CENTER);
		JLabel femaleColorLabel = new JLabel("", JLabel.CENTER);

		// maleColorLabel, femaleColorLabel --> 이미지 넣기
		ImageIcon maleImg = new ImageIcon("images/male.png");
		ImageIcon femaleImg = new ImageIcon("images/female.png");
		maleColorLabel = new JLabel("", maleImg, JLabel.CENTER);
		femaleColorLabel = new JLabel("", femaleImg, JLabel.CENTER);

		// 패널 간 배치
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
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

		// 총좌석, 이용중좌석, 잔여좌석 숫자 부분 테두리 넣기
		LineBorder lb = new LineBorder(Color.WHITE, 1, true);
		totalCntLabel.setBorder(lb);
		usingCntLabel.setBorder(lb);
		remainCntLabel.setBorder(lb);

		// 라벨의 위치와 크기
		titleLabel.setBounds(100, 180, 1000, 50);
		usingLabel.setBounds(230, 250, 80, 30);
		usingCntLabel.setBounds(310, 250, 100, 30);
		totalLabel.setBounds(440, 250, 80, 30);
		totalCntLabel.setBounds(520, 250, 100, 30);
		remainLabel.setBounds(650, 250, 80, 30);
		remainCntLabel.setBounds(730, 250, 100, 30);
		maleLabel.setBounds(900, 240, 50, 30);
		femaleLabel.setBounds(900, 280, 50, 30);
		maleColorLabel.setBounds(960, 240, 30, 30);
		femaleColorLabel.setBounds(960, 280, 30, 30);

		// 라벨 폰트
		titleLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 30));
		totalLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 16));
		totalCntLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
		usingLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 16));
		usingCntLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
		remainLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 16));
		remainCntLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
		maleLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 16));
		femaleLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 16));

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

		// count 라벨에 해당 좌석 숫자 표시
		SeatUseDetailDao sudDao = new SeatUseDetailDao();
		ArrayList<SeatUseDetailVO> sudList=  new ArrayList<>();
		try {
			// usingCntLabel(사용중)
			sudList.addAll(sudDao.get());
			usingCntLabel.setText(sudList.size() + "");
			// remainCntLabel(잔여좌석)
			int rCnt = 18 - sudList.size();
			remainCntLabel.setText(rCnt + "");
			// totalCntLabel(총좌석)
			totalCntLabel.setText("18");	
		} catch (Exception e) {
			e.printStackTrace();
		}


		for (int i = 0; i < totalSeatCnt; i++) {
			labels[i] = new JLabel("" + (i+1), JLabel.CENTER);
			labels[i].setOpaque(true);
			labels[i].setFont(font);
			//			labels[i].setHorizontalAlignment(JTextFiled.CENTER);
			labels[i].setBorder(javax.swing.BorderFactory.createEmptyBorder());
		}

		labels[0].setBounds(230, 380, 90, 90);
		labels[1].setBounds(230, 475, 90, 90);
		labels[2].setBounds(230, 570, 90, 90);
		labels[3].setBounds(325, 380, 90, 90);
		labels[4].setBounds(325, 475, 90, 90);
		labels[5].setBounds(325, 570, 90, 90);
		labels[6].setBounds(515, 380, 90, 90);
		labels[7].setBounds(515, 475, 90, 90);
		labels[8].setBounds(515, 570, 90, 90);
		labels[9].setBounds(610, 380, 90, 90);
		labels[10].setBounds(610, 475, 90, 90);
		labels[11].setBounds(610, 570, 90, 90);
		labels[12].setBounds(800, 380, 90, 90);
		labels[13].setBounds(800, 475, 90, 90);
		labels[14].setBounds(800, 570, 90, 90);
		labels[15].setBounds(895, 380, 90, 90);
		labels[16].setBounds(895, 475, 90, 90);
		labels[17].setBounds(895, 570, 90, 90);

		for (int i = 0; i < labels.length; i++) {
			add(labels[i]);
		}


		try {
			sudList.addAll(sudDao.get());

			for (int i = 0; i < totalSeatCnt; i++) {
				labels[i].setBackground(Color.GRAY);
			}

			for (SeatUseDetailVO sud : sudList) {
				if (sud.getMember().getSex().equals("0")) {
					labels[sud.getReadingroom().getSeatNum() - 1].setBackground(Color.BLUE);
				} else if (sud.getMember().getSex().equals("1")) {
					labels[sud.getReadingroom().getSeatNum() - 1].setBackground(Color.PINK);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


	
		
		
		

		boolean bLoginChk = false;
	
		if (!bLoginChk) { // 로그인 실패
			
		} else { // 로그인 성공
			
		}	
		
		// 좌석 1~ 18번 이벤트 (18개 같은 동작 실행)
		// Local variable i defined in an enclosing scope must be final or effectively final -- 오류발생
		// final int j = i; 추가함
		try {
			sudList.addAll(sudDao.get());
		
			for (int i = 0; i < totalSeatCnt; i++) {
				final int j = i;
				labels[i].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseClicked(e);
						int result = JOptionPane.showConfirmDialog(labels[j], "좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.NO_OPTION) {

							dispose();
							setVisible(true);
						} else if (result == JOptionPane.YES_OPTION) {

							// 로그인 정보 넘어와야 하는 부분 아직...
							
							SeatUseDetailDao sudDao = new SeatUseDetailDao();
							ArrayList<SeatUseDetailVO> sudList=  new ArrayList<>();
						
							try {
								sudList.addAll(sudDao.get());
								for (SeatUseDetailVO sud : sudList) {
									if (sud.getReadingroom().getSeatNum().equals(j) && sud.getMember().getSex().equals("0")) {
										labels[sud.getReadingroom().getSeatNum() - 1].setBackground(Color.BLUE);
									} else if (sud.getReadingroom().getSeatNum().equals(j) && sud.getMember().getSex().equals("1")) {
										labels[sud.getReadingroom().getSeatNum() - 1].setBackground(Color.PINK);
									}
								}
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							JOptionPane.showMessageDialog(labels[j], "좌석 발권이 완료되었습니다.", "Message", 1);
						} 
					}	
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

			

		this.add(myPanel);
		myPanel.add(titlePanel);
		myPanel.add(cntPanel);
		myPanel.setBounds(0, 100, 1100, 600);

		// 서브 배경색상 변경
		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		p2.setBackground(new Color(126, 151, 148));
		p2.setBounds(50, 100, 1100, 600);
		add(p2);

		// 메인 배경색상 변경
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setBackground(new Color(42, 64, 61));
		p.setBounds(0, 0, 1200, 800);
		add(p);

		JOptionPane.setDefaultLocale(null);

		return myPanel;
	}



	public static void main(String[] args) {	
		new ReadingRoomMain();

	}

}











