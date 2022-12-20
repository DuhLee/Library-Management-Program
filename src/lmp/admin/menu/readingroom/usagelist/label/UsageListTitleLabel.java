package lmp.admin.menu.readingroom.usagelist.label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class UsageListTitleLabel extends JLabel{
	
	public UsageListTitleLabel() {
		
		System.out.println("titlelabel");
		this.setText("열람실 현황");
		this.setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 30));
		this.setForeground(Color.WHITE);
	}
}
