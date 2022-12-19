package lmp.admin.menu.readingroom.sj.label;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class UserStatusLabel extends JLabel{
	
	public UserStatusLabel() {
		
		this.setOpaque(true);
		this.setForeground(Color.BLACK);
		this.setBackground(Color.GRAY);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
}
