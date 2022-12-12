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

public class issueCompleteScreen extends JFrame{
	public issueCompleteScreen() {
		
		JLabel CompleteMsgLabel = new JLabel("좌석이 발권되었습니다.", JLabel.CENTER);
		JButton checkBtn = new JButton("확인");
		
		checkBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		// 확인 버튼 포커스 표시 설정
		checkBtn.setFocusPainted(false);
		
		
		add(CompleteMsgLabel);
		add(checkBtn);
		
		CompleteMsgLabel.setBounds(100, 20, 200, 50);
		checkBtn.setBounds(150, 100, 100, 30);
		
		CompleteMsgLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		checkBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 14));
		
		CompleteMsgLabel.setForeground(Color.WHITE);
		
		setTitle("좌석 발권 완료!");
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setMinimumSize(new Dimension(400, 200));
		
		
		// 메인 배경색상 변경
		Color c = new Color(42, 64, 61);
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setBackground(c);
		p.setBounds(0, 0, 400, 200);
		add(p);
		
	}
	
	
//	public static void main(String[] args) {
//		new issueCompleteScreen();
//	}
//	
}
