package lmp.admin.menu.readingroom.sj.label;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class UserSeatLabel extends JLabel{

	public UserSeatLabel(int seatNum) {
		
		setText(Integer.toString(seatNum));
		setOpaque(true);
		setForeground(Color.BLACK);
		setBackground(Color.GRAY);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setHorizontalAlignment(JLabel.CENTER);
		
	}
	
	
	
	
}
