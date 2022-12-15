package lmp.admin.menu.readingroom.sj;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import lmp.db.dao.SeatUseDetailDao;
import lmp.db.vo.SeatUseDetailVO;

public class ReadingRoomMain extends JFrame {
	
	private JPasswordField passText;
	private JTextField userText;
	
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
		
		// 좌석 1~18번 만듦
		JLabel label01 = new JLabel("01", JLabel.CENTER);
		JLabel label02 = new JLabel("02", JLabel.CENTER);
		JLabel label03 = new JLabel("03", JLabel.CENTER);
		JLabel label04 = new JLabel("04", JLabel.CENTER);
		JLabel label05 = new JLabel("05", JLabel.CENTER);
		JLabel label06 = new JLabel("06", JLabel.CENTER);
		JLabel label07 = new JLabel("07", JLabel.CENTER);
		JLabel label08 = new JLabel("08", JLabel.CENTER);
		JLabel label09 = new JLabel("09", JLabel.CENTER);
		JLabel label10 = new JLabel("10", JLabel.CENTER);
		JLabel label11 = new JLabel("11", JLabel.CENTER);
		JLabel label12 = new JLabel("12", JLabel.CENTER);
		JLabel label13 = new JLabel("13", JLabel.CENTER);
		JLabel label14 = new JLabel("14", JLabel.CENTER);
		JLabel label15 = new JLabel("15", JLabel.CENTER);
		JLabel label16 = new JLabel("16", JLabel.CENTER);
		JLabel label17 = new JLabel("17", JLabel.CENTER);
		JLabel label18 = new JLabel("18", JLabel.CENTER);
		
	
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
		
		
		// 좌석 1~ 18번 프레임에 추가
		this.add(label01);
		this.add(label02);
		this.add(label03);
		this.add(label04);
		this.add(label05);
		this.add(label06);
		this.add(label07);
		this.add(label08);
		this.add(label09);
		this.add(label10);
		this.add(label11);
		this.add(label12);
		this.add(label13);
		this.add(label14);
		this.add(label15);
		this.add(label16);
		this.add(label17);
		this.add(label18);
		
		// 좌석 1~ 18번 위치와 크기
		label01.setBounds(230, 380, 90, 90);
		label02.setBounds(230, 475, 90, 90);
		label03.setBounds(230, 570, 90, 90);
		label04.setBounds(325, 380, 90, 90);
		label05.setBounds(325, 475, 90, 90);
		label06.setBounds(325, 570, 90, 90);
		label07.setBounds(515, 380, 90, 90);
		label08.setBounds(515, 475, 90, 90);
		label09.setBounds(515, 570, 90, 90);
		label10.setBounds(610, 380, 90, 90);
		label11.setBounds(610, 475, 90, 90);
		label12.setBounds(610, 570, 90, 90);
		label13.setBounds(800, 380, 90, 90);
		label14.setBounds(800, 475, 90, 90);
		label15.setBounds(800, 570, 90, 90);
		label16.setBounds(895, 380, 90, 90);
		label17.setBounds(895, 475, 90, 90);
		label18.setBounds(895, 570, 90, 90);

		                            
		// 좌석 1~ 18번 폰트
		label01.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label02.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label03.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label04.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label05.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label06.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label07.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label08.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label09.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label10.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label11.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label12.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label13.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label14.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label15.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label16.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label17.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		label18.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		
		// 좌석 1~ 18번 폰트의 색상
		label01.setForeground(Color.GRAY);
		label02.setForeground(Color.GRAY);
		label03.setForeground(Color.GRAY);
		label04.setForeground(Color.GRAY);
		label05.setForeground(Color.GRAY);
		label06.setForeground(Color.GRAY);
		label07.setForeground(Color.GRAY);
		label08.setForeground(Color.GRAY);
		label09.setForeground(Color.GRAY);
		label10.setForeground(Color.GRAY);
		label11.setForeground(Color.GRAY);
		label12.setForeground(Color.GRAY);
		label13.setForeground(Color.GRAY);
		label14.setForeground(Color.GRAY);
		label15.setForeground(Color.GRAY);
		label16.setForeground(Color.GRAY);
		label17.setForeground(Color.GRAY);
		label18.setForeground(Color.GRAY);
		
		// 좌석 1~ 18번 투명하게..
		label01.setOpaque(true);
		label02.setOpaque(true);
		label03.setOpaque(true);
		label04.setOpaque(true);
		label05.setOpaque(true);
		label06.setOpaque(true);
		label07.setOpaque(true);
		label08.setOpaque(true);
		label09.setOpaque(true);
		label10.setOpaque(true);
		label11.setOpaque(true);
		label12.setOpaque(true);
		label13.setOpaque(true);
		label14.setOpaque(true);
		label15.setOpaque(true);
		label16.setOpaque(true);
		label17.setOpaque(true);
		label18.setOpaque(true);
		
		// 좌석 1~ 18번 배경색 채우기
		label01.setBackground(Color.WHITE);
		label02.setBackground(Color.WHITE);
		label03.setBackground(Color.WHITE);
		label04.setBackground(Color.WHITE);
		label05.setBackground(Color.WHITE);
		label06.setBackground(Color.WHITE);
		label07.setBackground(Color.WHITE);
		label08.setBackground(Color.WHITE);
		label09.setBackground(Color.WHITE);
		label10.setBackground(Color.WHITE);
		label11.setBackground(Color.WHITE);
		label12.setBackground(Color.WHITE);
		label13.setBackground(Color.WHITE);
		label14.setBackground(Color.WHITE);
		label15.setBackground(Color.WHITE);
		label16.setBackground(Color.WHITE);
		label17.setBackground(Color.WHITE);
		label18.setBackground(Color.WHITE);
		
		
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
		
		
		
		// 기존 이용자 버튼 색깔 바꾸기 (1, 2, 6번)
		try {
			sudList.addAll(sudDao.get());
			
			
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
		
		
		
		// 좌석 1~ 18번 이벤트 (18개 같은 동작 실행)
		
		label01.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label01, "1번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					SeatUseDetailDao sudDao = new SeatUseDetailDao();
					ArrayList<SeatUseDetailVO> sudList=  new ArrayList<>();
					
					JOptionPane.showMessageDialog(label01, "1번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		label02.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label02, "2번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					
					JOptionPane.showMessageDialog(label02, "2번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		label03.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label03, "3번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(label03, "3번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		
		label04.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label04, "4번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(label04, "4번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});

		
		label05.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label05, "5번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(label05, "5번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		label06.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label06, "6번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(label06, "6번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		label07.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label07, "7번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(label07, "7번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		label08.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label08, "8번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(label08, "8번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		
		label09.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label09, "9번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(label09, "9번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		label10.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label10, "10번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(label10, "10번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		label11.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label11, "11번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(label11, "11번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		label12.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label12, "12번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(label12, "12번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		label13.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label13, "13번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(label13, "13번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		label14.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label14, "1번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(label14, "14번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		
		label15.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label15, "15번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(label15, "15번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		label16.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label16, "16번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(label16, "16번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		
		label17.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label17, "17번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(label17, "17번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		label18.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int result = JOptionPane.showConfirmDialog(label18, "18번 좌석을 발권하겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					dispose();
					setVisible(true);
				} else if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(label18, "18번 좌석 발권이 완료되었습니다.", "Message", 1);
				} 
			}	
		});
		
		
		
		// 입실 좌석 수만큼 색깔 채워보기 (test)
//		Color maleC = new Color(138, 228, 255);
//		Color femaleC = new Color(255, 183, 210);	
//
//		label01.setBackground(maleC);
//		label02.setBackground(femaleC);

		

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

 






