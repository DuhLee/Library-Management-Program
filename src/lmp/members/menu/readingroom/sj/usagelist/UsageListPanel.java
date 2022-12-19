package lmp.members.menu.readingroom.sj.usagelist;

import java.awt.BorderLayout;


import javax.swing.JPanel;

import lmp.members.menu.readingroom.sj.seatlist.panel.StatusPanel;
import lmp.members.menu.readingroom.sj.usagelist.panel.UsageListTitlePanel;
//import lmp.members.menu.readingroom.sj.usagelist.scrollpane.UsageListScrollPane;

public class UsageListPanel extends JPanel{

	static BorderLayout borderLayout = new BorderLayout();
	
	StatusPanel statusPanel;
	UsageListTitlePanel usagListTitlePanel;
	
	public UsageListPanel() {
		
		System.out.println("usagelistpanel");
		
		this.setLayout(borderLayout);
		
	}
	
	public StatusPanel getStatusPanel() {
		return statusPanel;
	}
	
		
}