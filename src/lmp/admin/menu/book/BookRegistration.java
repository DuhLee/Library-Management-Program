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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import lmp.db.dao.BookDao;
import lmp.db.vo.BookVO;

public class BookRegistration extends JFrame implements MouseListener, KeyListener {
	
	static final String[] labels_Regist = {"제목", "저자", "출판사", "ISBN", "편권수", "가격", "위치", "비고"};
	private JTextField[] fields_Regist = new JTextField[8];
	private JScrollPane scrolledTable_Regist;
	JTable table_Regist;

	private JButton addBtn;
	private JButton delBtn;
	private JButton saveBtn_Regist;

	public BookRegistration(String title) {

		this.setTitle("신규 도서등록 페이지");
		this.setLayout(new BorderLayout(10, 10));

		// 상단 패널(도서등록 시 텍스트필드 영역)
		JPanel topPanel = new JPanel(new GridLayout(4, 2, 100, 5));
		for (int i = 0; i < labels_Regist.length; i++) {
			JLabel label = new JLabel(labels_Regist[i]);
			label.setForeground(Color.WHITE);
			topPanel.add(label);
			fields_Regist[i] = new JTextField(100);
			topPanel.add(fields_Regist[i]);
		}
		topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.add("North", topPanel); // 가장 위쪽 Panel 설정
		topPanel.setBackground(Color.DARK_GRAY);

		// 중앙 스크롤테이블(도서정보 입력시 그 내용이 출력되는 영역)
		//String header[] = {"등록번호", "제목", "저자", "출판사", "ISBN", "편권수", "복권수" , "등록일", "가격", "위치", "비고"};
		DefaultTableModel model = new DefaultTableModel(labels_Regist, 0); // header추가, 행은 1개 지정

		table_Regist = new JTable(model);
		// table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrolledTable_Regist = new JScrollPane(table_Regist); // 스크롤 될 수 있도록 JScrollPane 적용
		scrolledTable_Regist.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 너무 붙어있어서 가장자리 띄움(padding)
		this.add("Center", scrolledTable_Regist); // 가운데에 JTable 추가

		// 하단 패널(추가/제외/저장 버튼이 위치하는 영역)
		JPanel bottomPanel = new JPanel(new GridLayout(1, 3, 10, 10));
		//bottomPanel.setLayout(null);
		bottomPanel.setBorder(new LineBorder(Color.BLACK));
		
		addBtn = new JButton("추가");
		delBtn = new JButton("제외");
		saveBtn_Regist = new JButton("저장");

		// 추가,제외,저장 각 버튼 이미지 삽입
		// 추가버튼 이미지
		BufferedImage bfi_add = null;
		try {
			bfi_add = ImageIO.read(new File("src\\lmp\\admin\\menu\\book\\images\\plusBtnIcon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image image_add = bfi_add.getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING);

		addBtn = BookMgmt.getButton(" 추가");
		addBtn.setIcon(new ImageIcon(image_add));
		addBtn.setBounds(420, 5, 120, 40);
		addBtn.setForeground(Color.BLACK);

		// 제외버튼 이미지
		BufferedImage bfi_del = null;
		try {
			bfi_del = ImageIO.read(new File("src\\lmp\\admin\\menu\\book\\images\\minusBtnIcon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image del = bfi_del.getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING);

		delBtn = BookMgmt.getButton(" 제외");
		delBtn.setIcon(new ImageIcon(del));
		delBtn.setBounds(720, 0, 120, 40);
		delBtn.setForeground(Color.BLACK);

		// 저장버튼 이미지
		BufferedImage bfi_save = null;
		try {
			bfi_save = ImageIO.read(new File("src\\lmp\\admin\\menu\\book\\images\\saveIconImage_Regist.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image save = bfi_save.getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING);

		saveBtn_Regist = BookMgmt.getButton(" 저장");
		saveBtn_Regist.setIcon(new ImageIcon(save));
		saveBtn_Regist.setBounds(1020, 0, 120, 40);
		saveBtn_Regist.setForeground(Color.BLACK);

		bottomPanel.add(addBtn);
		bottomPanel.add(delBtn);
		bottomPanel.add(saveBtn_Regist);
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.add("South", bottomPanel); // 오른쪽에 버튼들 추가

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1000, 500);
		this.setLocationRelativeTo(null); // 창 가운데 위치
		this.setVisible(true);

		// 이벤트 추가
		addBtn.addMouseListener(this); // 추가 처리
		delBtn.addMouseListener(this); // 삭제 처리
		for (int i = 0; i < labels_Regist.length; i++)
			fields_Regist[i].addKeyListener(this); // 엔터 처리
		table_Regist.addMouseListener(this); // 셀 읽기 처리
	}

	private boolean isInvalidInput(String input) {
		return input == null || input.length() == 0;
	}

	public void removeRecord(int index) {
		DefaultTableModel model = (DefaultTableModel) table_Regist.getModel();
		if (index < 0) {
			if (table_Regist.getRowCount() == 0)// 비어있는 테이블이면
				return;
			index = 0;
		}
		model.removeRow(index);
	}

	public void addRecord() {
		DefaultTableModel model = (DefaultTableModel) table_Regist.getModel();
		String[] record = new String[10];
		for (int i = 0; i < labels_Regist.length; i++) {
			if (i < labels_Regist.length-1) {
				if (isInvalidInput(fields_Regist[i].getText())) {
					JOptionPane.showMessageDialog(this, "입력하지 않은 정보가 있습니다.");
					return;
				}
			}
			record[i] = fields_Regist[i].getText();
		}
		model.addRow(record);

		// 모든 TextField 비우기
		for (int i = 0; i < labels_Regist.length; i++)
			fields_Regist[i].setText("");
		fields_Regist[0].requestFocus();
	}

	public void printCell(int row, int col) {
		DefaultTableModel model = (DefaultTableModel) table_Regist.getModel();
		System.out.println(model.getValueAt(row, col));
	}

	// MouseListener Overrides
	@Override
	public void mouseClicked(MouseEvent e) {
		Object src = e.getSource();
		if (src == addBtn)
			addRecord();

		if (src == delBtn) {
			int selected = table_Regist.getSelectedRow();
			removeRecord(selected);
		}
		
		// 저장버튼 클릭 시 작동기능 명령(196-216)
//		if (src == saveBtn_Regist) {
//			int num = JOptionPane.showConfirmDialog(table, "정말로 저장합니까?", "DB에 저장하기", JOptionPane.YES_NO_OPTION);
//			switch (num) {
//			case 0:
//				BookDao bookDao = new BookDao();
//				ArrayList<BookVO> bookVO = new ArrayList<>();
//				try {
//					bookVO.clear();
//					bookVO.addAll(bookDao.get(1, String.valueOf(table.getValueAt(table.getSelectedRow(), 0))));
//					bookDao.add(bookVO.get(0));
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//				table.validate();
//				JOptionPane.showMessageDialog(table, "입력하신 도서의 정보가 DB에 저장되었습니다.");
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
		if (keyCode == KeyEvent.VK_ENTER) {
			addRecord();
		}
	}

}