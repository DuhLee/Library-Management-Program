package lmp.admin.menu.readingroom.usagelist.scrollpane;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import lmp.admin.dao.SeatUseDetailDao;
import lmp.admin.menu.readingroom.usagelist.scrollpane.table.UsageListTable;
import lmp.admin.vo.SeatUseDetailVO;

public class UsageListScrollPane extends JScrollPane{
	
	private static String colNames[] = {"좌석번호","회원번호","회원명","연락처","성별", "시작시간", "사용여부"};
	DefaultTableModel model;
	
	UsageListTable usageListTable;

	public UsageListScrollPane() throws SQLException {
		System.out.println("scrollpane");
		SeatUseDetailDao sudDao = new SeatUseDetailDao();
		ArrayList<SeatUseDetailVO> sudList = new ArrayList<>();
		System.out.println(sudDao.get());
		
		sudList.addAll(sudDao.get());
		int resetRow = 0;
		model = new DefaultTableModel(colNames, 30);
		for (SeatUseDetailVO sud : sudList) {
			System.out.println(sud.getUse_id());
			model.setRowCount(sudList.size());
			for (int i = 0; i < sud.getSudList().length; i++) {
				model.setValueAt(sud.getSudList()[i], resetRow, i);
			}
			resetRow++;
		}
		
		usageListTable = new UsageListTable(model);
		this.setViewportView(usageListTable);
		
	}

	public UsageListTable getUsageListTable() {
		return usageListTable;
	}

	public DefaultTableModel getModel() {
		return model;
	}
	
	
	
	

}
