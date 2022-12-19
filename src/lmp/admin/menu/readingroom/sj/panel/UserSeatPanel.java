package lmp.admin.menu.readingroom.sj.panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import lmp.admin.menu.readingroom.sj.label.UserSeatLabel;
import lmp.db.vo.SeatUseDetailVO;

public class UserSeatPanel extends JPanel{

	GridLayout gridLayout = new GridLayout(5,2);
	UserSeatLabel[] userSeatLabels = new UserSeatLabel[gridLayout.getRows() * gridLayout.getColumns()];
	int tens;
	
	public UserSeatPanel(ArrayList<SeatUseDetailVO> sudVOs,int tensDigit) {
		System.out.println("seatPanel");
		this.setLayout(gridLayout);
		this.tens = tensDigit * 10;
		
		for (int i = 0 + tens; i < gridLayout.getRows() * gridLayout.getColumns() + tens; i++) {
			
			userSeatLabels[i - tens] = new UserSeatLabel(i + 1);
			userSeatLabels[i - tens].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			add(userSeatLabels[i - tens]);
		}
		
		for (SeatUseDetailVO sudVO : sudVOs) {
			int usageSeatNum = sudVO.getReadingroom().getSeatNum();
			String sex = sudVO.getMember().getSex();
			if (usageSeatNum > tens + 1 && usageSeatNum < tens + 10) {
				if (sex.equals("0")) {					
					userSeatLabels[usageSeatNum - tens - 1].setBackground(Color.BLUE);
				} else {
					userSeatLabels[usageSeatNum - tens - 1].setBackground(Color.PINK);
				}
			}
		}
		
	}
	
	public void refresh(ArrayList<SeatUseDetailVO> sudVOs) {
		
		for (int i = 0; i < userSeatLabels.length; i++) {
			userSeatLabels[i].setBackground(Color.GRAY);
		}
		
		for (SeatUseDetailVO sudVO : sudVOs) {
			int usageSeatNum = sudVO.getReadingroom().getSeatNum();
			String sex = sudVO.getMember().getSex();
			if (usageSeatNum > tens + 1 && usageSeatNum < tens + 10) {
				if (sex.equals("0")) {					
					userSeatLabels[usageSeatNum - tens - 1].setBackground(Color.BLUE);
				} else {
					userSeatLabels[usageSeatNum - tens - 1].setBackground(Color.PINK);
				}
			}
		}
		
		this.validate();
		
	}
}
