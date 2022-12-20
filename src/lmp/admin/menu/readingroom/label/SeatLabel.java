package lmp.admin.menu.readingroom.label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class SeatLabel extends JLabel{

	public SeatLabel(int seatNum) {
		
		setText(Integer.toString(seatNum));
		this.setOpaque(true);
		this.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 15));
		this.setForeground(Color.GRAY);
		this.setHorizontalAlignment(JLabel.CENTER);
	}
}