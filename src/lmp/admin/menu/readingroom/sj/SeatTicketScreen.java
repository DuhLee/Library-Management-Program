package lmp.admin.menu.readingroom.sj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SeatTicketScreen extends JFrame {
	
	public SeatTicketScreen() {
		// 라벨추가
		JLabel ReadingRoomLabel = new JLabel("좌석번호", JLabel.CENTER);
		JLabel seatNumLabel = new JLabel("좌석번호", JLabel.LEFT);
		JLabel memNumLabel = new JLabel("회원번호", JLabel.LEFT);
		JLabel memNameLabel = new JLabel("이름", JLabel.LEFT);
		
		// 텍스트필드 추가
		JTextField seatNumTf = new JTextField("좌석번호를 입력하세요");
		JTextField memNumTf = new JTextField("회원번호를 입력하세요");
		JTextField memNameTf = new JTextField("이름을 입력하세요");
		
		// 확인버튼 추가
		JButton addBtn = new JButton("확인");
		
		addBtn.addActionListener(new ActionListener() {
			// 누르면 좌석 발급 완료를 내용으로 하는 새창이 뜨도록 설정
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new issueCompleteScreen();
			}
		});
		
		// 확인 버튼 포커스 표시 설정
		addBtn.setFocusPainted(false);
		
		add(ReadingRoomLabel);
		add(seatNumLabel);
		add(memNumLabel);
		add(memNameLabel);
		
		add(seatNumTf);
		add(memNumTf);
		add(memNameTf);
		
		add(addBtn);
		
		// 크기설정
		ReadingRoomLabel.setBounds(100, 30, 200, 50);
		seatNumLabel.setBounds(50, 100, 80, 30);
		memNumLabel.setBounds(50, 150, 80, 30);
		memNameLabel.setBounds(50, 200, 80, 30);
		
		seatNumTf.setBounds(130, 100, 200, 30);
		memNumTf.setBounds(130, 150, 200, 30);
		memNameTf.setBounds(130, 200, 200, 30);
		
		addBtn.setBounds(250, 300, 80, 30);
		
		// 폰트 설정
		ReadingRoomLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 20));
		seatNumLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		memNumLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		memNameLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		
		seatNumTf.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		memNumTf.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		memNameTf.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		
		addBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		
		// 폰트 색상 설정
		ReadingRoomLabel.setForeground(Color.WHITE);
		seatNumLabel.setForeground(Color.WHITE);
		memNumLabel.setForeground(Color.WHITE);
		memNameLabel.setForeground(Color.WHITE);
		
		seatNumTf.setForeground(Color.WHITE);
		memNumTf.setForeground(Color.WHITE);
		memNameTf.setForeground(Color.WHITE);
		
		
		// 기본 프레임 세팅
		setTitle("좌석 발권");
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setMinimumSize(new Dimension(400, 400));
		
		
		// 메인 배경색상 변경
		Color c = new Color(42, 64, 61);
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setBackground(c);
		p.setBounds(0, 0, 400, 400);
		add(p);
	}

//	public static void main(String[] args) {
//		new SeatTicketScreen();
//	}
//	
	
	
	
}
