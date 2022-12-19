package lmp.loginJoin;

import java.awt.BorderLayout;
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

public class FoundPw {
	
	public void FoundPw() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBackground(Color.GRAY);
		
	
		
		Font font = new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14);
		
		JLabel pwSuccessLb = new JLabel("<html><body style='text-align:center;'>검색하신 비밀번호는 <br/> [pik12345678] <br/> 입니다.</body></html>", JLabel.CENTER);
		pwSuccessLb.setBounds(40, 10, 200, 100);
		pwSuccessLb.setFont(font);
		pwSuccessLb.setForeground(Color.WHITE);

		JButton okBtn = new JButton("확인") {
			{
				setBounds(100, 110, 80, 30);
				setFont(font);
				setForeground(Color.GRAY);
				setBackground(Color.WHITE);
				setBorderPainted(false); // 버튼 외곽선 없애기
				setFocusPainted(false); // 버튼 선택시 외곽선 없애기 
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
					}
				});
			}
		};
		
		panel.setLayout(new BorderLayout());
		panel.setSize(300, 200);
		
		frame.add(pwSuccessLb);
		frame.add(okBtn);
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(new Dimension(300, 200));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null); // 화면 중앙에 띄우기
	}


	public static void main(String[] args) {
		new FoundPw();
	}

	public void open() {
		this.FoundPw();
	}
}

