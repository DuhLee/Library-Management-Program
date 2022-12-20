package lmp.admin.menu.readingroom;

import java.awt.Color;
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
		
		seatListPanel.setBackground(new Color(126, 151, 148));
		usageListPanel.setBackground(new Color(126, 151, 148));
		usageListScrollPane.setBackground(new Color(126, 151, 148));
		usageListTitlaPanel.setBackground(new Color(126, 151, 148));
		this.setBackground(new Color(126, 151, 148));
		
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