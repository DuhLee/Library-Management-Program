package lmp.members.menu.readingroom.jy;

import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle; 
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import 연습.SeatList;

public class ReadingRoomTable extends JPanel{

	// DB에서 스윙 화면으로 테이블 값 가져오기(select) , 저장하기(insert), 수정하기(update), 삭제하기(delete)
	private static final long serialVersionUID = 1L;
	private JButton jBtnAddRow = null;    // 테이블 한줄 추가 버튼
	private JButton jBtnSaveRow = null;    // 테이블 한줄 저장 버튼
	private JButton jBtnEditRow = null;    // 테이블 한줄 저장 버튼
	private JButton jBtnDelRow = null;        // 테이블 한줄 삭제 버튼
	private JTable table;    
	private JScrollPane scrollPane;        // 테이블 스크롤바 자동으로 생성되게 하기

	private String driver = "oracle.jdbc.driver.OracleDriver";        
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";        // @호스트 IP : 포트 : SID
	private String colNames[] = {"좌석번호","회원번호","회원명","연락처","성별", "시작시간", "사용여부"};  // 테이블 컬럼 값들
	private DefaultTableModel model = new DefaultTableModel(colNames, 0); //  테이블 데이터 모델 객체 생성

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;   // 리턴받아 사용할 객체 생성 ( select에서 보여줄 때 필요 )
	protected JFrame frame;
	
	SeatList seatlist = new SeatList();

	public ReadingRoomTable() {

		setLayout(null);        // 레이아웃 배치관리자 삭제
		table = new JTable(model);  // 테이블에 모델객체 삽입
		table.addMouseListener(new JTableMouseListener());        // 테이블에 마우스리스너 연결
		setScrollPane(new JScrollPane(table));            // 테이블에 스크롤 생기게 하기
		getScrollPane().setBounds(40, 150, 1100, 275);
		add(getScrollPane());      
//		initialize();    
//		select();

		table.getTableHeader().setReorderingAllowed(false); // 테이블 컬럼 이동 불가
		table.getTableHeader().setResizingAllowed(false); // 테이블 크기 조절 불가
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한개의 행만 선택 가능
		table.getTableHeader().setResizingAllowed(false); // JTable 컬럼의 사이즈 변경 불가

		// 컬럼내 데이터 가운데정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
		TableColumnModel tcm = table.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴

		//전체 열을 가운데 정렬
		for(int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}	
	}

	public class JTableMouseListener implements MouseListener{    // 마우스로 눌려진값확인하기
		public void mouseClicked(java.awt.event.MouseEvent e) {    // 선택된 위치의 값을 출력

			JTable jtable = (JTable)e.getSource();
			int row = jtable.getSelectedRow();                // 선택된 테이블의 행값
			int col = jtable.getSelectedColumn();         // 선택된 테이블의 열값

			System.out.println(model.getValueAt(row, col));   // 선택된 위치의 값을 얻어내서 출력

		}
		public void mouseEntered(java.awt.event.MouseEvent e) {
		}
		public void mouseExited(java.awt.event.MouseEvent e) {    
		}
		public void mousePressed(java.awt.event.MouseEvent e) {
		}
		public void mouseReleased(java.awt.event.MouseEvent e) {
		}
	}


//	private void select(){        // 테이블에 보이기 위해 검색     
//		String query = "SELECT seat_num, mem_num, mem_name, mem_contact, mem_sex, start_time, available FROM ReadingRoom";     
//		try{
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, "testuser", "1234");
//			pstmt = con.prepareStatement(query);
//			rs = pstmt.executeQuery(); // 리턴받아와서 데이터를 사용할 객체생성
//
//			while(rs.next()){            // 각각 값을 가져와서 테이블값들을 추가
//				model.addRow(new Object[]{
//						rs.getInt("seat_num"),
//						rs.getInt("mem_num"),
//						rs.getString("mem_name"),
//						rs.getString("mem_contact"),
//						rs.getString("mem_sex"),
//						rs.getTimestamp(6),
//						rs.getString("available")
//				});
//			}
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//		}finally{
//			try {
//				rs.close(); 
//				pstmt.close(); 
//				con.close();   // 객체 생성한 반대 순으로 사용한 객체는 닫아준다.
//			} catch (Exception e2) {}
//		}
//	}
//
//	private void initialize() {            // 액션이벤트와 버튼 컴포넌트 설정         
//
//		// 선택된 테이블 한줄 삭제하는 부분
//		jBtnDelRow = new JButton();
//		jBtnDelRow.addActionListener(new ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent e) {
//				//                	Compulsory_CheckOut_Frame2 ccf = new Compulsory_CheckOut_Frame2(frame);
//				//					ccf.open();
//				//					ccf.toFront();
//				System.out.println(e.getActionCommand());        // 선택된 버튼의 텍스트값 출력
//				DefaultTableModel model2 = (DefaultTableModel)table.getModel();
//				int row = table.getSelectedRow();
//				if(row<0) return; // 선택이 안된 상태면 -1리턴
//				String query = "DELETE FROM ReadingRoom WHERE seat_num= ?";
//
//				try{
//					Class.forName(driver);  // 드라이버 로딩
//					con = DriverManager.getConnection(url, "testuser", "1234"); // DB 연결
//					pstmt = con.prepareStatement(query);   
//
//					pstmt.setString(1, (String) model2.getValueAt(row, 0));
//					int cnt = pstmt.executeUpdate();
//				}catch(Exception eeee){
//					System.out.println(eeee.getMessage());
//				}finally{
//					try {
//						pstmt.close();con.close();
//					} catch (Exception e2) {}
//				}
//				model2.removeRow(row);    // 테이블 상의 한줄 삭제
//			}
//		});
//		jBtnDelRow.setBounds(new Rectangle(1000, 110, 100, 30));
//		jBtnDelRow.setText("강제퇴실");
//		add(jBtnDelRow);
//	}


	public static void main(String[] args) {

		ReadingRoomTable panel = new ReadingRoomTable();
		JFrame win = new JFrame();

		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		win.add(panel);
		win.setSize(1200,800);
		win.setVisible(true);
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public int getSelectedRow() {
		// TODO Auto-generated method stub
		return 0;
	}

	public DefaultTableModel getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}