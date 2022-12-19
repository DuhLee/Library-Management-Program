package lmp.admin.menu.readingroom;

import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JPanel;

import lmp.admin.dao.SeatUseDetailDao;
import lmp.admin.menu.readingroom.seatlist.SeatListPanel;
import lmp.admin.menu.readingroom.usagelist.UsageListPanel;
import lmp.admin.menu.readingroom.usagelist.panel.UsageListTitlePanel;
import lmp.admin.menu.readingroom.usagelist.scrollpane.UsageListScrollPane;

public class ReadingRoomPanel extends JPanel {
	
	SeatUseDetailDao sudDao = new SeatUseDetailDao();
	
	SeatListPanel seatListPanel;
	UsageListPanel usageListPanel;
	UsageListScrollPane usageListScrollPane;
	UsageListTitlePanel usageListTitlaPanel;

	GridLayout gridLayout = new GridLayout(2,1);
	
	
	public ReadingRoomPanel() throws SQLException {
		
		System.out.println("rrpanel");
		seatListPanel = new SeatListPanel();
		usageListPanel = new UsageListPanel();
		usageListScrollPane = new UsageListScrollPane();
		usageListTitlaPanel = new UsageListTitlePanel(this);
		
		
		usageListPanel.add(usageListTitlaPanel, "North");
		usageListPanel.add(usageListScrollPane, "Center");
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


	public UsageListScrollPane getUsageListScrollPane() {
		return usageListScrollPane;
	}
	
	
	
	
}
