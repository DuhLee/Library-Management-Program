package lmp.members.menu.readingroom.sj;

import java.awt.GridLayout;

import java.sql.SQLException;

import javax.swing.JPanel;

import lmp.db.dao.SeatUseDetailDao;
import lmp.members.menu.readingroom.sj.seatlist.SeatListPanel;
import lmp.members.menu.readingroom.sj.seatlist.panel.StatusPanel;
import lmp.members.menu.readingroom.sj.usagelist.UsageListPanel;
import lmp.members.menu.readingroom.sj.usagelist.panel.UsageListTitlePanel;
//import lmp.members.menu.readingroom.sj.usagelist.scrollpane.UsageListScrollPane;

public class ReadingRoomPanel extends JPanel {
	
	SeatUseDetailDao sudDao = new SeatUseDetailDao();
	
	SeatListPanel seatListPanel;
	UsageListPanel usageListPanel;
	StatusPanel statusPanel;
	UsageListTitlePanel usageListTitlaPanel;

	GridLayout gridLayout = new GridLayout(2,1);
	
	
	public ReadingRoomPanel() throws SQLException {
		
		System.out.println("rrpanel");
		seatListPanel = new SeatListPanel();
		usageListPanel = new UsageListPanel();
		statusPanel = new StatusPanel();
		usageListTitlaPanel = new UsageListTitlePanel(this);
		
		
		usageListPanel.add(usageListTitlaPanel, "North");
		usageListPanel.add(statusPanel, "Center");
		setLayout(gridLayout);
		add(usageListPanel);
		add(seatListPanel);

	}


	public SeatListPanel getSeatListPanel() {
		return seatListPanel;
	}

	public UsageListPanel getUsageListPanel() {
		return usageListPanel;
	}
	
	public StatusPanel getStatusPanel() {
		return statusPanel;
	}
	
}