package lmp.members.menu.readingroom.sj.usagelist.label;

import java.awt.Font;

import javax.swing.JLabel;

public class UsageListTitleLabel extends JLabel{
	
	public UsageListTitleLabel() {
		
		System.out.println("titlelabel");
		this.setText("현재 좌석 배치도");
		this.setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 30));
	}

}