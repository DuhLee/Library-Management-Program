package lmp.admin.menu.readingroom.sj;

import java.awt.Color;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import lmp.admin.menu.readingroom.sj.panel.UserSeatPanel;
import lmp.admin.menu.readingroom.sj.panel.UserStatusPanel;
import lmp.db.dao.SeatUseDetailDao;
import lmp.db.vo.SeatUseDetailVO;

public class UserSeatListPanel extends JPanel{
	
	GridLayout gridLayout = new GridLayout(1,6,30,0);

	UserStatusPanel statusPanel;
	UserSeatPanel[]	seatPanels = new UserSeatPanel[gridLayout.getColumns() - 1];
	
	
	SeatUseDetailDao sudDao = new SeatUseDetailDao();
	ArrayList<SeatUseDetailVO> sudVO;
	public UserSeatListPanel() {
		System.out.println("seatlistpanel");
		setLayout(gridLayout);
		setBorder(new TitledBorder(new LineBorder(new Color(49, 82, 91),30)));
		setBackground(new Color(49, 82, 91));
	
		try {
			sudVO = sudDao.get();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		statusPanel = new UserStatusPanel(sudVO);
		add(statusPanel);
		
		for (int i = 0; i < gridLayout.getColumns() - 1; i++) {
			seatPanels[i] = new UserSeatPanel(sudVO,i);
			add(seatPanels[i]);
		}
		
	}
	
	public void refresh(ArrayList<SeatUseDetailVO> sudVO) {
		statusPanel.refresh(sudVO);
		for (UserSeatPanel seatPanel : seatPanels) {
			seatPanel.refresh(sudVO);
		}
		
		this.validate();
	}

}

