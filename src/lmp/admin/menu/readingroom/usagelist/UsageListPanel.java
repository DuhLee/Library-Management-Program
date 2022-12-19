package lmp.admin.menu.readingroom.usagelist;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import lmp.admin.menu.readingroom.usagelist.panel.UsageListTitlePanel;
import lmp.admin.menu.readingroom.usagelist.scrollpane.UsageListScrollPane;

public class UsageListPanel extends JPanel{

	static BorderLayout borderLayout = new BorderLayout();
	
	UsageListScrollPane usageListScrollPane;
	UsageListTitlePanel usagListTitlePanel;
	
	public UsageListPanel() {
		
		System.out.println("usagelistpanel");
		
		this.setLayout(borderLayout);
		
	}
	
	public UsageListScrollPane getUsageListScrollPane() {
		return usageListScrollPane;
	}
	
	
		
}
