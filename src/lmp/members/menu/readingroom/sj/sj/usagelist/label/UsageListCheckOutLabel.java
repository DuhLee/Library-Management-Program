package lmp.members.menu.readingroom.sj.usagelist.label;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import lmp.db.dao.ReadingRoomDao;
import lmp.db.dao.SeatUseDetailDao;
import lmp.db.vo.SeatUseDetailVO;
import lmp.members.menu.readingroom.sj.ReadingRoomPanel;
import lmp.members.menu.readingroom.sj.seatlist.SeatListPanel;
import lmp.members.menu.readingroom.sj.usagelist.UsageListPanel;
//import lmp.members.menu.readingroom.sj.usagelist.scrollpane.table.UsageListTable;

public class UsageListCheckOutLabel extends JLabel{
	
	public UsageListCheckOutLabel(ReadingRoomPanel readingRoomPanel) {
		
		System.out.println("checkOutlabel");
		this.setText("  퇴실하기  ");
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 15));
		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
		this.setForeground(Color.WHITE);
	
	}
}