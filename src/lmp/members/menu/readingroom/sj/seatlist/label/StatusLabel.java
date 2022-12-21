package lmp.members.menu.readingroom.sj.seatlist.label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import lmp.members.menu.readingroom.sj.ReadingRoomPanel;
import lmp.members.menu.readingroom.sj.seatlist.SeatListPanel;
import lmp.members.menu.readingroom.sj.seatlist.panel.StatusPanel;
import lmp.members.menu.readingroom.sj.usagelist.UsageListPanel;

public class StatusLabel extends JLabel{

	public StatusLabel() {

		this.setOpaque(true);
		this.setBackground(new Color(126, 151, 148));
		this.setHorizontalAlignment(JLabel.CENTER);
//		this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		this.setForeground(Color.WHITE);
		this.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 15));
	}

}