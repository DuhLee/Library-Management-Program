package lmp.admin.menu.readingroom.seatlist;

import java.awt.Color;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import lmp.admin.dao.SeatUseDetailDao;
import lmp.admin.menu.readingroom.panel.SeatPanel;
import lmp.admin.menu.readingroom.panel.StatusPanel;
import lmp.admin.vo.SeatUseDetailVO;



public class SeatListPanel extends JPanel{
	
			
	GridLayout gridLayout = new GridLayout(1,5,30,0);

	StatusPanel statusPanel;
	SeatPanel[]	seatPanels = new SeatPanel[gridLayout.getColumns() - 1];
	
	
	SeatUseDetailDao sudDao = new SeatUseDetailDao();
	ArrayList<SeatUseDetailVO> sudVO;
	public SeatListPanel() {
		
		System.out.println("seatlistpanel");
		setLayout(gridLayout);
		setBorder(new TitledBorder(new LineBorder(new Color(126, 151, 148), 20)));
	
		try {
			sudVO = sudDao.get();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		statusPanel = new StatusPanel(sudVO);
		add(statusPanel);
		
		for (int i = 0; i < gridLayout.getColumns() - 1; i++) {
			seatPanels[i] = new SeatPanel(sudVO,i);
			add(seatPanels[i]);
		}
		
	}
	
	public void refresh(ArrayList<SeatUseDetailVO> sudVO) {
		statusPanel.refresh(sudVO);
		for (SeatPanel seatPanel : seatPanels) {
			seatPanel.refresh(sudVO);
		}
		
		this.validate();
	}

}