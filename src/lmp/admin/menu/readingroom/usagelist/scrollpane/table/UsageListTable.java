package lmp.admin.menu.readingroom.usagelist.scrollpane.table;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class UsageListTable extends JTable{
	
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
	
	public UsageListTable(DefaultTableModel model) {
		
		System.out.println("usageListTable");
		
		this.getTableHeader().setReorderingAllowed(false); // 테이블 컬럼 이동 불가
		this.getTableHeader().setResizingAllowed(false); // 테이블 크기 조절 불가
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한개의 행만 선택 가능
		this.getTableHeader().setResizingAllowed(false); // JTable 컬럼의 사이즈 변경 불가
		this.setRowHeight(30);
		this.setModel(model);
		

		// 컬럼내 데이터 가운데정렬
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
		TableColumnModel tcm = this.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴

		//전체 열을 가운데 정렬
		for(int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}	
		
	}

}