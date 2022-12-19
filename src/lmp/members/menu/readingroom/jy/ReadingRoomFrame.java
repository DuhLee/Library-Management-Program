package lmp.members.menu.readingroom.jy;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ReadingRoomFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
//		ReadingRoomTable rrtable = new ReadingRoomTable();
		SeatList seatlist = new SeatList();

		/*
         패널을 1~4까지 생성
         [      1      ]
         [      2      ]
         [   3    ][   4   ]
         p1 : 관리자가 이용자를 선택해서 사용과 퇴실처리 할 수 있도록 하는 버튼을 배치
         p2 : 회원의 좌석 이용 상태를 조회할 수 있는 테이블을 배치
         p3 : 총좌석, 이용중인좌석, 잔여좌석을 조회할 수 있는 부분
         p4 : 좌석 배치도를 배치하되, 이용중인 사용자의 성별에 따라 색상이 변동되도록 설정
		 */


		Color color = new Color(126, 151, 148);

		// 패널1
		JPanel p1 = new JPanel(); 
		p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
		p1.setBackground(color);
		p1.setBounds(40, 100, 1100, 50);




		// 패널2
//		ReadingRoomTable rrt = new ReadingRoomTable();
		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
		p2.setBackground(Color.GRAY);
		p2.setBounds(40, 150, 1100, 275);
		p2.setBackground(color);
		p2.add(seatlist.scrollpane); // JTable 삽입


		// 패널3
		JPanel p3 = new JPanel();
		p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS));
		p3.setBackground(color);
		p3.setBounds(40, 400, 200, 275);


		// 패널4
		JPanel p4 = new JPanel();
		p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
		p4.setBackground(color);
		p4.setBounds(240, 400, 900, 275);





		// '강제퇴실' 버튼 삽입 
		JButton checkOutBtn = new JButton("강제퇴실") {
			{
				setBounds(1000, 110, 100, 30);
				addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						Compulsory_CheckOut_Frame ccf = new Compulsory_CheckOut_Frame(frame);
						ccf.open();
						ccf.toFront();
					}
				});
			}
		};


		frame.add(checkOutBtn); // 프레임내 '강제퇴실' 버튼 삽입
		// 프레임에 패널을 추가
		frame.add(p1);
		frame.add(p2);
		frame.add(p3);
		frame.add(p4);

		// 프레임과 패널 크기 설정
		// frame.setBounds(300, 100, 1200, 800);
		frame.setBounds(0, 0, 1200, 800);
		panel.setBounds(0, 100, 1100, 600);

		// 기본세팅
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);// 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}