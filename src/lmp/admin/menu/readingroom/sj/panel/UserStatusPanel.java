package lmp.admin.menu.readingroom.sj.panel;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import lmp.admin.menu.readingroom.sj.label.UserStatusLabel;
import lmp.db.vo.SeatUseDetailVO;

public class UserStatusPanel extends JPanel{

	GridLayout gridLayout = new GridLayout(6,1);
	private static JLabel[] LABELS = new JLabel[6]; 
	
	
	public UserStatusPanel(ArrayList<SeatUseDetailVO> sudVO) {
		
		setLayout(gridLayout);
		for (int i = 0; i < LABELS.length; i++) {
			LABELS[i] = new UserStatusLabel();
		}
		LABELS[0].setText("총 자리");
		LABELS[1].setText("40");
		LABELS[2].setText("이용중인 자리");
		LABELS[3].setText("" + sudVO.size());
		LABELS[4].setText("남은 자리");
		LABELS[5].setText("" + (40 - sudVO.size()));
		for (JLabel label : LABELS) {
			add(label);
		}
	}
	
	public void refresh(ArrayList<SeatUseDetailVO> sudVO) {
		
		LABELS[3].setText("" + sudVO.size());
		LABELS[5].setText("" + (40 - sudVO.size()));
		this.validate();
	}
	
}
