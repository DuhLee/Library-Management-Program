package lmp.members.menu.readingroom.jy;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class SeatList {
	
	public JScrollPane scrollpane;
	
	public SeatList() {
		// JTable을 이용해 좌석목록을 조회한다
		String header[] = {"좌석번호", "회원번호", "회원명", "회원연락처", "성별", "시작시간", "사용여부"};
		String contents[][] = {
				{"1", "1010101", "피카츄", "01011111111",   "여", "10:10", "사용중"},
				{"2", "1010101", "라이츄", "01011111111", "남", "10:10", "사용중"},
				{"3", "1010101", "파이리", "01011111111", "남", "10:10", "사용중"},
				{"4", "1010101", "꼬부기", "01011111111", "남", "10:10", "사용중"},
				{"5", "1010101", "버터플", "01011111111", "남", "10:10", "사용중"},
				{"6", "1010101", "야도란", "01011111111", "남", "10:10", "사용중"},
				{"7", "1010101", "피존투", "01011111111", "여", "10:10", "사용중"},
				{"8", "1010101", "또가스", "01011111111", "여", "10:10", "사용중"},
				{"9", "1010101", "이상해씨", "01011111111", "여", "10:10", "사용중"},
				{"10", "1010101", "캐터피", "01011111111", "여", "10:10", "사용중"},
				{"11", "1010101", "아보", "01011111111", "여", "10:10", "사용중"},
				{"12", "1010101", "삐삐", "01011111111", "여", "10:10", "사용중"},
				{"13", "1010101", "푸린", "01011111111", "여", "10:10", "사용중"},
				{"14", "1010101", "뚜벅쵸", "01011111111", "여", "10:10", "사용중"},
				{"15", "1010101", "콘팡", "01011111111", "여", "10:10", "사용중"},
				{"16", "1010101", "디그다", "01011111111", "여", "10:10", "사용중"},
				{"17", "1010101", "나옹", "01011111111", "여", "10:10", "사용중"},
				{"18", "1010101", "고라파덕", "01011111111", "여", "10:10", "사용중"}	
		};
		
		DefaultTableModel model = new DefaultTableModel(contents, header) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JTable table = new JTable(model);
		
		table.getTableHeader().setReorderingAllowed(false); // 테이블 컬럼 이동 불가
		table.getTableHeader().setResizingAllowed(false); // 테이블 크기 조절 불가
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한개의 행만 선택 가능
		table.getTableHeader().setResizingAllowed(false); // JTable 컬럼의 사이즈 변경 불가
		
		scrollpane = new JScrollPane(table);

		// 컬럼내 데이터 가운데정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
		TableColumnModel tcm = table.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴

		//전체 열을 가운데 정렬
		for(int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}
	
}
