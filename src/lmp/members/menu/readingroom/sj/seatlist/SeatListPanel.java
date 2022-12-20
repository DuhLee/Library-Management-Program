package lmp.members.menu.readingroom.sj.seatlist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import lmp.db.dao.SeatUseDetailDao;
import lmp.db.vo.SeatUseDetailVO;
import lmp.members.menu.readingroom.sj.ReadingRoomPanel;
import lmp.members.menu.readingroom.sj.seatlist.label.GenderLabel;
import lmp.members.menu.readingroom.sj.seatlist.label.StatusLabel;
import lmp.members.menu.readingroom.sj.seatlist.panel.SeatPanel;
import lmp.members.menu.readingroom.sj.seatlist.panel.StatusPanel;
import lmp.members.menu.readingroom.sj.usagelist.label.UsageListCheckOutLabel;
import lmp.members.menu.readingroom.sj.usagelist.label.UsageListTitleLabel;

public class SeatListPanel extends JPanel{
	
	GridLayout gridLayout = new GridLayout(1,7,30,0);

//	StatusPanel statusPanel;
	SeatPanel[]	seatPanels = new SeatPanel[gridLayout.getColumns() -1 ];
	
	SeatUseDetailDao sudDao = new SeatUseDetailDao();
	ArrayList<SeatUseDetailVO> sudVO;
		
	public SeatListPanel() {
		System.out.println("seatlistpanel");
		setLayout(gridLayout);
		setBorder(new TitledBorder(new LineBorder(new Color(49, 82, 91),30)));
		setBackground(new Color(49, 82, 91));
	
		try {
			sudVO = sudDao.get();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		statusPanel = new StatusPanel(sudVO);
//		add(statusPanel);
		
		for (int i = 0; i < gridLayout.getColumns() -1 ; i++) {
			seatPanels[i] = new SeatPanel(sudVO,i);
			add(seatPanels[i]);
		}
		
	}
	
	public void refresh(ArrayList<SeatUseDetailVO> sudVO) {
//		statusPanel.refresh(sudVO);
		for (SeatPanel seatPanel : seatPanels) {
			seatPanel.refresh(sudVO);
		}
		
		this.validate();
	}
	
	

}