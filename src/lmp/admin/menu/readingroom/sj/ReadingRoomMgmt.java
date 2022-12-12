package lmp.admin.menu.readingroom.sj;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

	public class ReadingRoomMgmt extends JFrame {

	private static final long serialVersionUID = 7287413355503880465L;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		/*
			패널을 1~4까지 생성
			[		1		]
			[		2		]
			[	3 	][	4	]
			p1 : 관리자가 이용자를 선택해서 사용과 퇴실처리 할 수 있도록 하는 버튼을 배치
			p2 : 회원의 좌석 이용 상태를 조회할 수 있는 테이블을 배치
			p3 : 총좌석, 이용중인좌석, 잔여좌석을 조회할 수 있는 부분
			p4 : 좌석 배치도를 배치하되, 이용중인 사용자의 성별에 따라 색상이 변동되도록 설정
		 */

		// ***** 패널2 -> 이용자 조회하는 테이블 *****
		// JTable 생성되어야 강제종료 버튼과 연동하여 삭제할 수 있는 기능 추가할 수 있으므로 코드상에는 앞에 배치함
		JPanel p2 = new JPanel();

		// "좌석번호", "회원번호", "회원명", "회원연락처", "성별", "시작시간", "종료시간", "사용여부"
		String header[] = {"좌석번호", "회원번호", "회원명", "회원연락처", "성별", "시작시간", "사용여부"};
		String contents[][] = {
				{"3", "10001256", "김지우", "010-6897-1240", "0", "11:35 am", "이용중"},
				{"1", "10001234", "최민준", "010-2548-6898", "1", "10:02 am", "이용중"},
				{"7", "10001258", "이건우", "010-1203-4698", "0", "12:16 pm", "이용중"},
				{"15", "10001067", "강서연", "010-1426-8103", "1", "13:53 pm", "이용중"},
//				{"10", "10001304", "박예진", "010-9821-2039", "0", "14:50 pm", "이용중"},
//				{"18", "10005036", "조현우", "010-7463-0398", "1", "12:47 pm", "이용중"},
//				{"13", "10001405", "정우진", "010-7110-5632", "0", "10:35 am", "이용중"},
//				{"16", "10001578", "전지민", "010-4202-6895", "1", "15:03 pm", "이용중"},
//				{"8", "10001600", "박건우", "010-3200-3578", "0", "14:03 pm", "이용중"},
//				{"11", "10001020", "김이레", "010-3659-7810", "1", "10:35 am", "이용중"},			
		};
		DefaultTableModel model = new DefaultTableModel(contents, header);
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한개의 행만 선택 가능
		p2.add(scrollpane);
		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
		p2.setBounds(40, 150, 1100, 275);
		p2.setVisible(true);
		p2.setBackground(Color.WHITE);
		p2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1), ""));	// 패널에 테두리 추가
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		// ***** 패널1 -> 강제종료 버튼 *****
		JPanel p1 = new JPanel();

		JButton cancelBtn = new JButton("퇴실처리");

		p1.add(cancelBtn);
		//		p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
		p1.setBounds(40, 100, 1100, 50);
		p1.setBackground(Color.WHITE);
		p1.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1), ""));	// 패널에 테두리 추가
		p1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		// ***** 패널3 -> 왼쪽 하단 총좌석, 이용중좌석, 잔여좌석 표시 *****
		JPanel p3 = new JPanel();
		p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS));
		p3.setBackground(Color.WHITE);
		p3.setBounds(40, 425, 200, 275);
		p3.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1), ""));	// 패널에 테두리 추가

		// 총좌석 라벨
		LineBorder lb2 = new LineBorder(Color.BLACK, 1, true);
		JLabel label2 = new JLabel("총 좌석", JLabel.CENTER);
		frame.add(label2);
		label2.setBorder(lb2);
		label2.setBounds(60, 450, 150, 20);
		label2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		// 총좌석의 숫자
		LineBorder lb2_1 = new LineBorder(Color.BLACK, 1, true);
		JLabel label2_1 = new JLabel("", JLabel.CENTER);
		frame.add(label2_1);
		label2_1.setText("18");	
		label2_1.setBorder(lb2_1);
		label2_1.setBounds(60, 471, 150, 50);
		label2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		// 이용중인 좌석의 라벨
		LineBorder lb3 = new LineBorder(Color.BLACK, 1, true);
		JLabel label3 = new JLabel("이용중인 좌석", JLabel.CENTER);
		frame.add(label3);
		label3.setBorder(lb3);
		label3.setBounds(60, 522, 150, 20);
		label3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		// 이용중인 좌석의 숫자
		LineBorder lb3_1 = new LineBorder(Color.BLACK, 1, true);
		JLabel label3_1 = new JLabel("", JLabel.CENTER);
		frame.add(label3_1);
		int cnt = 0;
		for (int i = 0; i < contents.length; i++) {
			if (table.getValueAt(i, 5) != null) {
				cnt++;
			}
		}
		// System.out.println(cnt);
		label3_1.setText(cnt + "");
		label3_1.setBorder(lb3_1);
		label3_1.setBounds(60, 543, 150, 50);
		label3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		// 잔여 좌석의 라벨
		LineBorder lb4 = new LineBorder(Color.BLACK, 1, true);
		JLabel label4 = new JLabel("잔여 좌석", JLabel.CENTER);
		frame.add(label4);
		label4.setBorder(lb4);
		label4.setBounds(60, 594, 150, 20);
		label4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		// 잔여 좌석의 숫자
		LineBorder lb4_1 = new LineBorder(Color.BLACK, 1, true);
		JLabel label4_1 = new JLabel("", JLabel.CENTER);
		frame.add(label4_1);
		label4_1.setText((18 - cnt) + "");
		label4_1.setBorder(lb4_1);
		label4_1.setBounds(60, 615, 150, 50);
		label4_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		// ***** 패널4 -> 좌석 배치도를 표시 *****
		JPanel p4 = new JPanel();
		p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
		p4.setBounds(240, 425, 900, 275);
		p4.setBackground(Color.WHITE);
		p4.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1), ""));	// 패널에 테두리 추가

		// 패널4에 패널4_1 ~ 4_8을 추가하여
		// 홀수(1,3,5,7)에는 테이블 6개의 묶음과 짝수(2,4,6,8)에는 테이블 묶음 간 여백을 추가한다
		// 패널4_9는 입구를 표시
		JPanel p4_1 = new JPanel();
		JPanel p4_2 = new JPanel();
		JPanel p4_3 = new JPanel();
		JPanel p4_4 = new JPanel();
		JPanel p4_5 = new JPanel();
		JPanel p4_6 = new JPanel();
		JTextField doorField = new JTextField();
		JTextField doorField2 = new JTextField();

		// 테이블6개 묶음에 각각 버튼을 추가한다
		JButton btn = new JButton();
		JButton btns4_1[] = new JButton[6];
		JButton btns4_3[] = new JButton[6];
		JButton btns4_5[] = new JButton[6];
		
		JLabel doorLabel = new JLabel();

		// 좌석 1~24번까지 생성(좌석 버튼 위에 표시되는 번호)
		ArrayList<String> seatList = new ArrayList<>();
		for (int i = 1; i <= 24; ++i) {
			seatList.add(i + "");
		}

		// panel4_1에 좌석 1~6 추가
		frame.add(p4_1);
		p4_1.setBounds(350, 450, 180, 220);
		p4_1.setBackground(SystemColor.WHITE);
		p4_1.setLayout(new GridLayout(3,2,2,2));
		for(int i = 0; i < btns4_1.length; i++) {
			btns4_1[i] = new JButton();
			btns4_1[i].setText("" + seatList.get(i));
			p4_1.add(btns4_1[i]);
			btns4_1[i].setBackground(Color.WHITE);
			btns4_1[i].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		}	

		// 좌석 묶음 간 여백 넣기
		frame.add(p4_2);
		p4_2.setBounds(530, 450, 60, 220);
		p4_2.setBackground(SystemColor.WHITE);

		// panel4_1에 좌석 7~12 추가
		frame.add(p4_3);
		p4_3.setBounds(590, 450, 180, 220);
		p4_3.setBackground(SystemColor.WHITE);
		p4_3.setLayout(new GridLayout(3,2,2,2));
		for(int i = 0; i < btns4_3.length; i++) {
			btns4_3[i] = new JButton();
			btns4_3[i].setText("" + seatList.get(i+6));
			p4_3.add(btns4_3[i]);
			btns4_3[i].setBackground(Color.WHITE);
			btns4_3[i].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		}

		// 좌석 묶음 간 여백 넣기		
		frame.add(p4_4);
		p4_4.setBounds(770, 450, 60, 220);
		p4_4.setBackground(SystemColor.WHITE);

		// panel4_1에 좌석 13~18 추가
		frame.add(p4_5);
		p4_5.setBounds(830, 450, 180, 220);
		p4_5.setBackground(SystemColor.WHITE);
		p4_5.setLayout(new GridLayout(3,2,2,2));
		for(int i = 0; i < btns4_5.length; i++) {
			btns4_5[i] = new JButton();
			btns4_5[i].setText("" + seatList.get(i+12));
			p4_5.add(btns4_5[i]);
			btns4_5[i].setBackground(Color.WHITE);
			btns4_5[i].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		}

		// 좌석 묶음 간 여백 넣기		
		frame.add(p4_6);
		p4_6.setBounds(1030, 450, 60, 220);
		p4_6.setBackground(SystemColor.WHITE);

		// 입구를 표시
		frame.add(doorField);
		doorField.setBounds(1090, 500, 30, 50);
		doorField.setBackground(SystemColor.WHITE);
		doorField.setText("입");
		doorField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		doorField.setBorder(null);
		frame.add(doorField2);
		doorField2.setBounds(1090, 550, 30, 50);
		doorField2.setBackground(SystemColor.WHITE);
		doorField2.setText("구");
		doorField2.setBorder(null);
		doorField2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));

		// 이용자가 1명일 때
		if (contents.length == 1) {	
			if(contents[0][4] == "0") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[0][4] == "1") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
		}
		
		// 이용자가 2명일 때
		if (contents.length == 2) {	
			if(contents[0][4] == "0") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[0][4] == "1") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[1][4] == "0") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[1][4] == "1") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
		}
		
		// 이용자가 3명일 때
		if (contents.length == 3) {	
			if(contents[0][4] == "0") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[0][4] == "1") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[1][4] == "0") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[1][4] == "1") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[2][4] == "0") {
				if(contents[2][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[2][4] == "1") {
				if(contents[2][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[2][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[2][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
		}
		
		// 이용자가 4명일 때
		if (contents.length == 4) {	
			if(contents[0][4] == "0") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[0][4] == "1") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[1][4] == "0") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[1][4] == "1") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[2][4] == "0") {
				if(contents[2][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[2][4] == "1") {
				if(contents[2][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[2][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[2][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[3][4] == "0") {
				if(contents[3][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[3][4] == "1") {
				if(contents[3][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[3][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[3][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
		}
		
		// 이용자가 5명일 때
		if (contents.length == 5) {	
			if(contents[0][4] == "0") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[0][4] == "1") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[1][4] == "0") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[1][4] == "1") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[2][4] == "0") {
				if(contents[2][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[2][4] == "1") {
				if(contents[2][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[2][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[2][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[3][4] == "0") {
				if(contents[3][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[3][4] == "1") {
				if(contents[3][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[3][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[3][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[4][4] == "0") {
				if(contents[4][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[4][4] == "1") {
				if(contents[4][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[4][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[4][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
		}
		
		// 이용자가 6명일 때
		if (contents.length == 6) {	
			if(contents[0][4] == "0") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[0][4] == "1") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[1][4] == "0") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[1][4] == "1") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[2][4] == "0") {
				if(contents[2][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[2][4] == "1") {
				if(contents[2][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[2][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[2][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[3][4] == "0") {
				if(contents[3][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[3][4] == "1") {
				if(contents[3][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[3][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[3][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[4][4] == "0") {
				if(contents[4][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[4][4] == "1") {
				if(contents[4][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[4][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[4][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[5][4] == "0") {
				if(contents[5][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[5][4] == "1") {
				if(contents[5][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[5][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[5][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[5][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[5][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[5][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[5][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[5][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[5][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[5][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[5][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[5][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[5][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[5][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[5][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[5][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[5][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[5][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
		}
		
		// 이용자가 7명일 때
		if (contents.length == 7) {	
			if(contents[0][4] == "0") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[0][4] == "1") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[1][4] == "0") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[1][4] == "1") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[2][4] == "0") {
				if(contents[2][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[2][4] == "1") {
				if(contents[2][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[2][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[2][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[3][4] == "0") {
				if(contents[3][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[3][4] == "1") {
				if(contents[3][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[3][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[3][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[4][4] == "0") {
				if(contents[4][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[4][4] == "1") {
				if(contents[4][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[4][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[4][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[5][4] == "0") {
				if(contents[5][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[5][4] == "1") {
				if(contents[5][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[5][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[5][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[5][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[5][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[5][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[5][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[5][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[5][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[5][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[5][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[5][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[5][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[5][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[5][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[5][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[5][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[5][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[6][4] == "0") {
				if(contents[6][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[6][4] == "1") {
				if(contents[6][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[6][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[6][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[6][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[6][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[6][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[6][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[6][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[6][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[6][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[6][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[6][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[6][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[6][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[6][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[6][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[6][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[6][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
		}
		
		// 이용자가 8명일 때
		if (contents.length == 8) {	
			if(contents[0][4] == "0") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[0][4] == "1") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[1][4] == "0") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[1][4] == "1") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[2][4] == "0") {
				if(contents[2][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[2][4] == "1") {
				if(contents[2][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[2][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[2][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[3][4] == "0") {
				if(contents[3][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[3][4] == "1") {
				if(contents[3][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[3][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[3][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[4][4] == "0") {
				if(contents[4][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[4][4] == "1") {
				if(contents[4][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[4][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[4][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[5][4] == "0") {
				if(contents[5][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[5][4] == "1") {
				if(contents[5][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[5][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[5][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[5][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[5][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[5][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[5][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[5][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[5][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[5][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[5][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[5][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[5][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[5][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[5][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[5][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[5][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[5][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[6][4] == "0") {
				if(contents[6][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[6][4] == "1") {
				if(contents[6][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[6][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[6][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[6][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[6][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[6][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[6][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[6][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[6][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[6][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[6][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[6][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[6][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[6][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[6][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[6][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[6][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[6][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[7][4] == "0") {
				if(contents[7][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[7][4] == "1") {
				if(contents[7][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[7][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[7][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[7][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[7][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[7][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[7][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[7][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[7][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[7][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[7][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[7][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[7][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[7][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[7][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[7][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[7][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[7][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
		}
		
		// 이용자가 9명일 때
		if (contents.length == 9) {	
			if(contents[0][4] == "0") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[0][4] == "1") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[1][4] == "0") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[1][4] == "1") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[2][4] == "0") {
				if(contents[2][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[2][4] == "1") {
				if(contents[2][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[2][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[2][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[3][4] == "0") {
				if(contents[3][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[3][4] == "1") {
				if(contents[3][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[3][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[3][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[4][4] == "0") {
				if(contents[4][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[4][4] == "1") {
				if(contents[4][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[4][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[4][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[5][4] == "0") {
				if(contents[5][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[5][4] == "1") {
				if(contents[5][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[5][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[5][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[5][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[5][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[5][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[5][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[5][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[5][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[5][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[5][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[5][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[5][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[5][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[5][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[5][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[5][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[5][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[6][4] == "0") {
				if(contents[6][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[6][4] == "1") {
				if(contents[6][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[6][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[6][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[6][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[6][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[6][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[6][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[6][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[6][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[6][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[6][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[6][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[6][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[6][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[6][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[6][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[6][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[6][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[7][4] == "0") {
				if(contents[7][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[7][4] == "1") {
				if(contents[7][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[7][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[7][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[7][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[7][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[7][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[7][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[7][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[7][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[7][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[7][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[7][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[7][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[7][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[7][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[7][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[7][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[7][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[8][4] == "0") {
				if(contents[8][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[8][4] == "1") {
				if(contents[8][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[8][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[8][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[8][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[8][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[8][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[8][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[8][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[8][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[8][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[8][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[8][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[8][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[8][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[8][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[8][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[8][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[8][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
		}
		
		// 이용자가 10명일 때
		if (contents.length == 10) {	
			if(contents[0][4] == "0") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[0][4] == "1") {
				if(contents[0][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[0][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[0][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[0][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[0][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[0][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[0][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[1][4] == "0") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[1][4] == "1") {
				if(contents[1][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[1][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[1][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[1][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[1][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[1][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[1][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[2][4] == "0") {
				if(contents[2][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[2][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[2][4] == "1") {
				if(contents[2][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[2][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[2][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[2][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[2][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[2][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[2][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[2][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[3][4] == "0") {
				if(contents[3][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[3][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[3][4] == "1") {
				if(contents[3][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[3][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[3][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[3][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[3][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[3][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[3][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[3][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[4][4] == "0") {
				if(contents[4][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[4][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[4][4] == "1") {
				if(contents[4][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[4][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[4][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[4][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[4][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[4][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[4][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[4][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[5][4] == "0") {
				if(contents[5][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[5][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[5][4] == "1") {
				if(contents[5][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[5][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[5][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[5][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[5][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[5][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[5][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[5][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[5][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[5][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[5][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[5][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[5][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[5][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[5][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[5][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[5][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[5][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[6][4] == "0") {
				if(contents[6][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[6][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[6][4] == "1") {
				if(contents[6][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[6][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[6][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[6][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[6][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[6][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[6][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[6][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[6][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[6][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[6][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[6][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[6][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[6][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[6][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[6][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[6][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[6][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[7][4] == "0") {
				if(contents[7][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[7][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[7][4] == "1") {
				if(contents[7][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[7][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[7][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[7][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[7][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[7][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[7][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[7][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[7][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[7][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[7][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[7][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[7][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[7][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[7][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[7][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[7][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[7][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[8][4] == "0") {
				if(contents[8][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[8][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[8][4] == "1") {
				if(contents[8][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[8][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[8][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[8][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[8][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[8][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[8][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[8][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[8][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[8][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[8][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[8][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[8][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[8][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[8][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[8][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[8][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[8][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
			if(contents[9][4] == "0") {
				if(contents[9][0] == "1"){btns4_1[0].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "2"){btns4_1[1].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "3"){btns4_1[2].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "4"){btns4_1[3].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "5"){btns4_1[4].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "6"){btns4_1[5].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "7"){btns4_3[0].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "8"){btns4_3[1].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "9"){btns4_3[2].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "10"){btns4_3[3].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "11"){btns4_3[4].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "12"){btns4_3[5].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "13"){btns4_5[0].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "14"){btns4_5[1].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "15"){btns4_5[2].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "16"){btns4_5[3].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "17"){btns4_5[4].setBackground(Color.CYAN);} 
				else if(contents[9][0] == "18"){btns4_5[5].setBackground(Color.CYAN);} 
			}
			else if (contents[9][4] == "1") {
				if(contents[9][0] == "1"){btns4_1[0].setBackground(Color.PINK);} 
				else if(contents[9][0] == "2"){btns4_1[1].setBackground(Color.PINK);} 
				else if(contents[9][0] == "3"){btns4_1[2].setBackground(Color.PINK);} 
				else if(contents[9][0] == "4"){btns4_1[3].setBackground(Color.PINK);} 
				else if(contents[9][0] == "5"){btns4_1[4].setBackground(Color.PINK);} 
				else if(contents[9][0] == "6"){btns4_1[5].setBackground(Color.PINK);} 
				else if(contents[9][0] == "7"){btns4_3[0].setBackground(Color.PINK);} 
				else if(contents[9][0] == "8"){btns4_3[1].setBackground(Color.PINK);} 
				else if(contents[9][0] == "9"){btns4_3[2].setBackground(Color.PINK);} 
				else if(contents[9][0] == "10"){btns4_3[3].setBackground(Color.PINK);} 
				else if(contents[9][0] == "11"){btns4_3[4].setBackground(Color.PINK);} 
				else if(contents[9][0] == "12"){btns4_3[5].setBackground(Color.PINK);} 
				else if(contents[9][0] == "13"){btns4_5[0].setBackground(Color.PINK);} 
				else if(contents[9][0] == "14"){btns4_5[1].setBackground(Color.PINK);} 
				else if(contents[9][0] == "15"){btns4_5[2].setBackground(Color.PINK);} 
				else if(contents[9][0] == "16"){btns4_5[3].setBackground(Color.PINK);} 
				else if(contents[9][0] == "17"){btns4_5[4].setBackground(Color.PINK);} 
				else if(contents[9][0] == "18"){btns4_5[5].setBackground(Color.PINK);} 
			}
		}

		

		// 프레임에 패널을 추가
		frame.add(p1);
		frame.add(p2);
		frame.add(p3);
		frame.add(p4);

		// 프레임과 패널 크기 설정
		// frame.setBounds(300, 100, 1200, 800); 
		frame.setBounds(0, 0, 1200, 800);	// --> 노트북이랑 사이즈가 안맞아서 이 코드로 작성함, 위의 코드가 정한 내용임
		panel.setBounds(0, 100, 1100, 600);

		// 기본세팅
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);// 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}
}
