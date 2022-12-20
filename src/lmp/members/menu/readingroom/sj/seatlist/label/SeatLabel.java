package lmp.members.menu.readingroom.sj.seatlist.label;

import java.awt.Color;
import java.awt.Font;

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
		setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 15));
	}
	
}