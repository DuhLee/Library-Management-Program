package lmp.members.menu.readingroom.sj.usagelist.panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import lmp.members.menu.readingroom.sj.ReadingRoomPanel;
import lmp.members.menu.readingroom.sj.seatlist.label.StatusLabel;
import lmp.members.menu.readingroom.sj.usagelist.label.UsageListCheckOutLabel;
import lmp.members.menu.readingroom.sj.usagelist.label.UsageListTitleLabel;

public class UsageListTitlePanel extends JPanel{
	
	BorderLayout borderLayout = new BorderLayout();
	UsageListTitleLabel usageListTitleLabel;
	UsageListCheckOutLabel usageListCheckOutLabel;
	
	public UsageListTitlePanel(ReadingRoomPanel readingRoomPanel) {
		System.out.println("titlePanel");
		usageListCheckOutLabel = new UsageListCheckOutLabel(readingRoomPanel);
		usageListTitleLabel = new UsageListTitleLabel();
		
		this.setLayout(borderLayout);
		this.add(usageListTitleLabel, "North");
		this.add(usageListCheckOutLabel, "East");
		
	}
}