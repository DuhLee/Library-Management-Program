package lmp.admin.menu.book.bookregisterframe.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class RegisterListDeleteButton extends JButton{
	
	public RegisterListDeleteButton() {
	
		this.setText("취소");
		this.setBounds(1020, 110, 120, 40);
		this.setFont(new Font("한컴 말랑말랑 Regular",Font.BOLD, 15));
		this.setForeground(Color.WHITE);
		this.setBackground(Color.GRAY);
		this.setBorderPainted(false); // 버튼외곽선 가리기
		this.setFocusPainted(false); // 버튼 선택시 외곽선 없애기 
	}
}
