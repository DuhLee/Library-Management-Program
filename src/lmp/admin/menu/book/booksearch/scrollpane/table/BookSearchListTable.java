package lmp.admin.menu.book.booksearch.scrollpane.table;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class BookSearchListTable extends JTable{
	
	private static String[] category = { "제목", "저자", "출판사", "ISBN", "편권수", "복권수", "등록일", "가격", "위치", "비고" };
	
	static DefaultTableModel model = new DefaultTableModel(category, 30) {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	
	public BookSearchListTable() {
		
		this.setModel(model);
        this.getTableHeader().setReorderingAllowed(false);
        this.getTableHeader().setResizingAllowed(false); // 테이블 컬럼 사이즈 변경 불가
        this.setRowHeight(30);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
	
	public String[] getCategory() {
        return category;
    }

	public DefaultTableModel getModel() {
		return model;
	}
	
	
	
	

}
