package lmp.members.menu.readingroom.sj.seatlist.label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import lmp.members.menu.readingroom.sj.ReadingRoomPanel;
import lmp.members.menu.readingroom.sj.seatlist.SeatListPanel;
import lmp.members.menu.readingroom.sj.seatlist.panel.StatusPanel;
import lmp.members.menu.readingroom.sj.usagelist.UsageListPanel;

public class StatusLabel extends JLabel{

	public StatusLabel() {

		this.setOpaque(true);
		this.setForeground(Color.BLACK);
		this.setBackground(Color.GRAY);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	}

}