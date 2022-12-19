package lmp.members.menu.readingroom.sj.seatlist.label;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class SeatLabel extends JLabel{

	public SeatLabel(int seatNum) {
		
		setText(Integer.toString(seatNum));
		setOpaque(true);
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		setHorizontalAlignment(JLabel.CENTER);
		
	}
	
	
	
}