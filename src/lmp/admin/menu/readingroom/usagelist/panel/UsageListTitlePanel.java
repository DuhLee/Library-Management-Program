package lmp.admin.menu.readingroom.usagelist.panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import lmp.admin.menu.readingroom.ReadingRoomPanel;
import lmp.admin.menu.readingroom.usagelist.UsageListPanel;
import lmp.admin.menu.readingroom.usagelist.label.UsageListCheckOutLabel;
import lmp.admin.menu.readingroom.usagelist.label.UsageListTitleLabel;

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
