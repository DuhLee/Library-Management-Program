package lmp.admin.menu.book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeCellEditor.DefaultTextField;

import lmp.db.dao.BookDao;
import lmp.db.vo.BookVO;

public class BookModification extends JFrame implements MouseListener, KeyListener {

	//static final String[] labels_top = {"등록번호o", "제목", "저자", "출판사", "ISBN", "편권수", "복권수o" , "등록일o", "가격", "위치", "비고"};
	static final String[] labels_modify = {"제목", "저자", "출판사", "ISBN", "편권수", "복권수" , "등록일", "가격", "위치", "비고"};
	private JTextField[] fields = new JTextField[10];
	private JScrollPane scrolledTable;
	static JTable table;
	DefaultTableModel model = new DefaultTableModel(labels_modify, 1); // column추가, 행은 1개 지정
	private JButton overwriteBtn;
	private JButton comebackBtn;
	private JButton saveBtn_Modify;
	String[] comebackList = new String[labels_modify.length];

	public BookModification(String title) {

		this.setTitle("선택도서 내용수정 페이지");
		this.setLayout(new BorderLayout(10, 10));

		// 상단 패널(정보수정할 내용을 입력하는 텍스트필드 영역)
		JPanel topPanel = new JPanel(new GridLayout(6, 2, 100, 5));
		for (int i = 0; i < labels_modify.length; i++) {
			JLabel label = new JLabel(labels_modify[i]);
			label.setForeground(Color.WHITE);
			topPanel.add(label);
			fields[i] = new JTextField(100);
			topPanel.add(fields[i]);
		}
		topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.add("North", topPanel); // 가장 위쪽 Panel 설정
		topPanel.setBackground(Color.DARK_GRAY);

		// 중앙 스크롤테이블(도서검색 후 그 정보를 가져와 보여주는 영역)
		//String header[] = { "제목", "저자", "출판사", "ISBN", "편권수", "복권수", "등록일", "가격", "위치", "비고" };
//		DefaultTableModel model = new DefaultTableModel(labels, 0);

		table = new JTable(model);
		// table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrolledTable = new JScrollPane(table); // 스크롤 될 수 있도록 JScrollPane 적용
		scrolledTable.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 너무 붙어있어서 가장자리 띄움(padding)
		this.add("Center", scrolledTable); // 가운데에 JTable 추가

		// 하단 패널(덮어쓰기/원래대로/저장하기 버튼이 위치하는 영역)
		JPanel bottomPanel = new JPanel(new GridLayout(1, 3, 10, 10));

		overwriteBtn = new JButton("추가");
		comebackBtn = new JButton("제외");
		saveBtn_Modify = new JButton("저장");

		// 덮어쓰기,원래대로,저장 각 버튼 이미지 삽입
		// 덮어쓰기 버튼 이미지
		BufferedImage bfi_overwrite = null;
		try {
			bfi_overwrite = ImageIO.read(new File("src\\lmp\\admin\\menu\\book\\images\\overwriteBtnIcon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image image_overwrite = bfi_overwrite.getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING);

		overwriteBtn = BookMgmt.getButton(" 덮어쓰기");
		overwriteBtn.setIcon(new ImageIcon(image_overwrite));
		overwriteBtn.setBounds(1020, 110, 120, 40);
		overwriteBtn.setForeground(Color.BLACK);

		// 원래대로 버튼 이미지
		BufferedImage bfi_comeback = null;
		try {
			bfi_comeback = ImageIO.read(new File("src\\lmp\\admin\\menu\\book\\images\\comebackBtnIcon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image comeback = bfi_comeback.getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING);

		comebackBtn = BookMgmt.getButton(" 원래대로");
		comebackBtn.setIcon(new ImageIcon(comeback));
		comebackBtn.setBounds(1020, 110, 120, 40);
		comebackBtn.setForeground(Color.BLACK);

		// 저장버튼 이미지
		BufferedImage bfi_save = null;
		try {
			bfi_save = ImageIO.read(new File("src\\lmp\\admin\\menu\\book\\images\\saveIconImage_modify.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image save = bfi_save.getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING);

		saveBtn_Modify = BookMgmt.getButton(" 저장하기");
		saveBtn_Modify.setIcon(new ImageIcon(save));
		saveBtn_Modify.setBounds(1020, 110, 120, 40);
		saveBtn_Modify.setForeground(Color.BLACK);

		bottomPanel.add(overwriteBtn);
		bottomPanel.add(comebackBtn);
		bottomPanel.add(saveBtn_Modify);
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.add("South", bottomPanel); // 오른쪽에 버튼들 추가

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1000, 500);
		this.setLocationRelativeTo(null); // 창 가운데 위치
		this.setVisible(true);

		// 이벤트 추가
		overwriteBtn.addMouseListener(this); // 추가 처리
		comebackBtn.addMouseListener(this); // 삭제 처리
		for (int i = 0; i < labels_modify.length; i++)
			fields[i].addKeyListener(this); // 엔터 처리
		table.addMouseListener(this); // 셀 읽기 처리
	}

	private boolean isInvalidInput(String input) {
		return input == null || input.length() == 0;
	}

	public void comebackRecord(int index) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if (index < 0) {
			if (table.getRowCount() == 0)// 비어있는 테이블이면
				return;
			index = 0;
		}
		model.removeRow(index);
	}

	public void overwriteRecord() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = 0; i < labels_modify.length; i++) {

			// 아무것도 없으면 아래 코드 패스
			if (fields[i].getText().trim().equals("")) {
				continue;
				// fields에 무언가 있을 때 테이블에 있는 정보와 비교해서 다르면 정보 수정
			} else if (!fields[i].getText().equals(model.getValueAt(0, i))) { // && fields[i] == null
				model.setValueAt(fields[i].getText(), 0, i);
			}
		}

		// 모든 TextField 비우기
		for (int i = 0; i < labels_modify.length; i++) {
			fields[i].setText("");
		}
		fields[0].requestFocus();
	}

	public void printCell(int row, int col) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		System.out.println(model.getValueAt(row, col));
	}

	// MouseListener Overrides
	@Override
	public void mouseClicked(MouseEvent e) {
		Object src = e.getSource();
		if (src == overwriteBtn)
			overwriteRecord();

		if (src == comebackBtn) {
			for (int i = 0; i < model.getColumnCount(); i++) {
				model.setValueAt(comebackList[i], 0, i);
				if(comebackList[i-1]==null) {
					model.setValueAt("", 0, i-1);
				}
			}
			table.setModel(model);
		}

		// 저장버튼 클릭 시 작동기능 명령(203-223)
//		if (src == saveBtn_Modify) {
//			int num = JOptionPane.showConfirmDialog(table, "정말로 저장합니까?", "DB에 저장하기", JOptionPane.YES_NO_OPTION);
//			switch (num) {
//			case 0:
//				BookDao bookDao = new BookDao();
//				ArrayList<BookVO> bookVO = new ArrayList<>();
//				try {
//					bookVO.clear();
//					bookVO.addAll(bookDao.get(1, String.valueOf(table.getValueAt(table.getSelectedRow(), 0))));
//					bookDao.update(bookVO.get(0));
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//				table.validate();
//				JOptionPane.showMessageDialog(table, "변경된 내용이 DB에 저장되었습니다.");
//				break;
//			case 1:
//				JOptionPane.showMessageDialog(table, "취소합니다.");
//				break;
//			}
//		}

		// 테이블 안에 해당 위치 마우스로 클릭 시 해당 값 출력
//		if (src == table) {
//			int row = table.getSelectedRow();
//			int col = table.getSelectedColumn();
//			printCell(row, col);
//		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	// KeyListener Overrides
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
//		if (keyCode == KeyEvent.VK_ENTER) {
//			overwriteRecord();
//		}
	}

}