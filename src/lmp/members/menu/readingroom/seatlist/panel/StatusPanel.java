package lmp.members.menu.readingroom.seatlist.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lmp.members.db.dao.SeatUseDetailDao;
import lmp.members.db.dao.ThemeDao;
import lmp.members.db.vo.SeatUseDetailVO;
import lmp.members.menu.readingroom.seatlist.SeatListPanel;
import lmp.members.menu.readingroom.seatlist.label.StatusLabel;
import lmp.util.theme.Theme;

public class StatusPanel extends JPanel{

	GridLayout gridLayout = new GridLayout(1,6);
	BorderLayout borderLayout = new BorderLayout();
	private static JLabel[] LABELS = new JLabel[6]; 
	
	SeatListPanel seatListPanel = new SeatListPanel();
	static SeatUseDetailDao sudDao = new SeatUseDetailDao();
	ArrayList<SeatUseDetailVO> sudVOs = new ArrayList<>();
	
	ThemeDao themeDao = new ThemeDao();
	Theme theme = new Theme();
	
	public StatusPanel() throws SQLException {
		
		setLayout(gridLayout);
		setBounds(250, 180, 1000, 50);
		setBackground(new Color(0,0,0,0));
		setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		theme.setTheme(themeDao.getTheme().getName());
		
		for (int i = 0; i < LABELS.length; i++) {
			LABELS[i] = new StatusLabel();
			if (i%2 == 0) {				
//				LABELS[i].setBackground(theme.getSub2Color());
				LABELS[i].setBackground(new Color(0,0,0,0));
				LABELS[i].setForeground(Color.WHITE);
			}
		}
		sudVOs = sudDao.getUse();
		
		LABELS[0].setText("총 자리");
//		LABELS[0].setBackground(theme.getSub2Color());
		LABELS[0].setBackground(new Color(0,0,0,0));
		LABELS[1].setText("" + (seatListPanel.gridLayout.getColumns() * 10));
		LABELS[2].setText("이용중인 자리");
		LABELS[3].setText("" + sudVOs.size());
		LABELS[4].setText("남은 자리");
		LABELS[5].setText("" + ( seatListPanel.gridLayout.getColumns() * 10  - sudVOs.size()));
		for (JLabel label : LABELS) {
			this.add(label);
		}
		LABELS[3].setText("" + sudVOs.size());
		LABELS[5].setText("" + (seatListPanel.gridLayout.getColumns() * 10 - sudVOs.size()));
	}
	
	public void refresh() throws SQLException {
	
		sudVOs = sudDao.getUse();
		LABELS[3].setText("" + sudVOs.size());
		LABELS[5].setText("" + ( seatListPanel.gridLayout.getColumns() * 10  - sudVOs.size()));
		for (JLabel label : LABELS) {
			this.add(label);
		}
		this.validate();
	}
	


}