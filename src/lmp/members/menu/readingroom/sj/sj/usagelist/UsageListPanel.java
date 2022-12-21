package lmp.members.menu.readingroom.sj.usagelist;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import lmp.db.vo.SeatUseDetailVO;
import lmp.members.menu.readingroom.sj.seatlist.panel.StatusPanel;
import lmp.members.menu.readingroom.sj.usagelist.panel.UsageListTitlePanel;
//import lmp.members.menu.readingroom.sj.usagelist.scrollpane.UsageListScrollPane;

public class UsageListPanel extends JPanel{

	static BorderLayout borderLayout = new BorderLayout();
	
	UsageListTitlePanel usagListTitlePanel;
	
	public UsageListPanel() {
		
		System.out.println("usagelistpanel");
		
		this.setLayout(borderLayout);
		
	}
		
}