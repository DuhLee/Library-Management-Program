package lmp.admin.menu.readingroom.seatlist.label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class SeatLabel extends JLabel{

	// 열람실 각 좌석
	public SeatLabel(int seatNum) {
		
		setText(Integer.toString(seatNum));
		setOpaque(true);
		setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 15));
		setForeground(Color.GRAY);
		setBackground(Color.WHITE);
		setBorder(new LineBorder(Color.GRAY));
		setHorizontalAlignment(JLabel.CENTER);
		
	}
	
	
	
}
