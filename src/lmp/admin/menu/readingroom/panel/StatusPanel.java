package lmp.admin.menu.readingroom.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import lmp.admin.menu.readingroom.label.StatusLabel;
import lmp.admin.vo.SeatUseDetailVO;

public class StatusPanel extends JPanel{

	GridLayout gridLayout = new GridLayout(6,1);
	private static JLabel[] LABELS = new JLabel[6]; 
	
	
	public StatusPanel(ArrayList<SeatUseDetailVO> sudVO) {
		
		setLayout(gridLayout);
		for (int i = 0; i < LABELS.length; i++) {
			LABELS[i] = new StatusLabel();
		}
		LABELS[0].setText("총 좌석");
		LABELS[1].setText("40");
		LABELS[1].setForeground(Color.GRAY);
		LABELS[1].setBackground(Color.WHITE);
		LABELS[2].setText("이용 중");
		LABELS[3].setText("" + sudVO.size());
		LABELS[3].setForeground(Color.GRAY);
		LABELS[3].setBackground(Color.WHITE);
		LABELS[4].setText("이용 가능");
		LABELS[5].setText("" + (40 - sudVO.size()));
		LABELS[5].setForeground(Color.GRAY);
		LABELS[5].setBackground(Color.WHITE);
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