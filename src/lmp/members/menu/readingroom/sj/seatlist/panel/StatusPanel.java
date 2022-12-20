package lmp.members.menu.readingroom.sj.seatlist.panel;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import lmp.db.vo.SeatUseDetailVO;
import lmp.members.menu.readingroom.sj.seatlist.label.StatusLabel;

public class StatusPanel extends JPanel{

	GridLayout gridLayout = new GridLayout(1,6);
	BorderLayout borderLayout = new BorderLayout();
	private static JLabel[] LABELS = new JLabel[6]; 
	
	
	public StatusPanel() {
		System.out.println("statusPanel");
		setLayout(gridLayout);
		setBorder(new TitledBorder(new LineBorder(new Color(49, 82, 91),30)));
		setBackground(new Color(49, 82, 91));
		
	}
	
	public StatusPanel(ArrayList<SeatUseDetailVO> sudVO) {
		
		setLayout(gridLayout);
		for (int i = 0; i < LABELS.length; i++) {
			LABELS[i] = new StatusLabel();
		}
		LABELS[0].setText("총 자리 : ");
		LABELS[1].setText("60");
		LABELS[2].setText("이용중인 자리 : ");
		LABELS[3].setText("" + sudVO.size());
		LABELS[4].setText("남은 자리 : ");
		LABELS[5].setText("" + (60 - sudVO.size()));
		for (JLabel label : LABELS) {
			this.add(label);
		}
	}
	
	public void refresh(ArrayList<SeatUseDetailVO> sudVO) {
		
		LABELS[3].setText("" + sudVO.size());
		LABELS[5].setText("" + (60 - sudVO.size()));
		this.validate();
	}
	


}