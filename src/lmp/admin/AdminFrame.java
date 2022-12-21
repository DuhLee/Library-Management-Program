package lmp.admin;

import java.awt.CardLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import lmp.admin.menu.book.BookMgmt;
import lmp.admin.menu.book.BookModification;
import lmp.admin.menu.book.booksearch.BookSearchPanel;
import lmp.admin.menu.checkin_out.Member_Searching_Panel;
import lmp.admin.menu.employees.EmployeesMgmt;
import lmp.admin.menu.member.MemberMgmt;
import lmp.admin.menu.readingroom.ReadingRoomPanel;
import lmp.members.menu.book.BookSearchFrame;


public class AdminFrame extends JFrame{

	JButton homeBtn, bookMgmt, checkIn_Out, readingRoom, employeeMgmt, memberMgmt;

	
	JFrame f = this;
	public AdminFrame() throws SQLException {

		JPanel menuButtonPanel = new JPanel(new GridLayout(1, 6, 50, 0));
		
		CardLayout card = new CardLayout();
		JPanel menuCardPanel = new JPanel(card);
		
		setTitle("관리자 모드");
		setLayout(null);
		
		BufferedImage bufferedHome = null;
		BufferedImage bufferedBookMgmt = null;
		BufferedImage bufferedCheckIn_Out = null;
		BufferedImage bufferedEmployeeMgmt = null;
		BufferedImage befferedMemberMgmt = null;
		BufferedImage bufferedReadingRoom = null;
		
		try {
			bufferedHome = ImageIO.read(new File("src/lmp/admin/menuButtonImages/libraryIcon.png"));
			bufferedBookMgmt = ImageIO.read(new File("src/lmp/admin/menuButtonImages/bookMgmtImage.png"));
			bufferedCheckIn_Out = ImageIO.read(new File("src/lmp/admin/menuButtonImages/checkInOut.png"));
			bufferedEmployeeMgmt = ImageIO.read(new File("src/lmp/admin/menuButtonImages/employeeMgmtImage.png"));
			befferedMemberMgmt = ImageIO.read(new File("src/lmp/admin/menuButtonImages/memberMgmtImage.png"));
			bufferedReadingRoom = ImageIO.read(new File("src/lmp/admin/menuButtonImages/readingRoomMgmtImage.png"));
			
			Image homeIcon = bufferedHome.getScaledInstance(80, 80, Image.SCALE_SMOOTH);	
			Image bookMgmtIcon = bufferedBookMgmt.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			Image checkIn_OutIcon = bufferedCheckIn_Out.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			Image employeeMgmtIcon = bufferedEmployeeMgmt.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			Image memberMgmtIcon = befferedMemberMgmt.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			Image readingRoomIcon = bufferedReadingRoom.getScaledInstance(80, 80, Image.SCALE_SMOOTH);	
			
			// 버튼 생성 메서드 테스트
			homeBtn = getButton("홈");
			homeBtn.setIcon(new ImageIcon(homeIcon));
			homeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					card.show(menuCardPanel, "1");
				}
			});
			
			bookMgmt = getButton("도서 관리");
			bookMgmt.setIcon(new ImageIcon(bookMgmtIcon));
			bookMgmt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					card.show(menuCardPanel, "2");
				}
			});	
			
			checkIn_Out = getButton("대출/반납");
			checkIn_Out.setIcon(new ImageIcon(checkIn_OutIcon));
			checkIn_Out.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					card.show(menuCardPanel, "3");	
				}
			});
			
			readingRoom = getButton("열람실 관리");
			readingRoom.setIcon(new ImageIcon(readingRoomIcon));
			readingRoom.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					card.show(menuCardPanel, "4");	
				}
			});
			
			memberMgmt = getButton("회원 관리");
			memberMgmt.setIcon(new ImageIcon(memberMgmtIcon));
			memberMgmt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					card.show(menuCardPanel, "5");
				}
			});
			
			employeeMgmt = getButton("직원 관리");
			employeeMgmt.setIcon(new ImageIcon(employeeMgmtIcon));
			memberMgmt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					card.show(menuCardPanel, "6");
				}
			});
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		menuButtonPanel.setBounds(90, 25, 1000, 120);
		menuButtonPanel.setBackground(new Color(42, 64, 61));
		
		menuCardPanel.setBounds(17, 150, 1150, 600);
		menuCardPanel.add("1", initialLabel());
		menuCardPanel.add("2", new BookSearchPanel());
		menuCardPanel.add("3", new Member_Searching_Panel());
		menuCardPanel.add("4", new ReadingRoomPanel());
		menuCardPanel.add("5", new MemberMgmt());
		menuCardPanel.add("6", new EmployeesMgmt());
		
		
		menuButtonPanel.add(homeBtn);
		menuButtonPanel.add(bookMgmt);
		menuButtonPanel.add(checkIn_Out);
		menuButtonPanel.add(readingRoom);
		menuButtonPanel.add(memberMgmt);
		menuButtonPanel.add(employeeMgmt);
		
		add(menuButtonPanel);
		add(menuCardPanel);
		
		setBounds(300, 100, 1200, 800);
		getContentPane().setBackground(new Color(42, 64, 61));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	// 버튼 누르기 전 초기 화면 이미지 설정
	public static JPanel initialLabel() {
		JPanel initImagePanel = new JPanel();
		JLabel label = new JLabel();
		try {
			BufferedImage buffer = ImageIO.read(new File("src/lmp/admin/menuButtonImages/initialImage.jpg"));
			Image image = buffer.getScaledInstance(1150, 600, Image.SCALE_SMOOTH);
			label.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		label.setSize(1150, 600);
		
		initImagePanel.setLayout(null);
		initImagePanel.add(label);
		
		return initImagePanel;
	}
	
	
	// ------------------추가---------------------------------------------
	public static JTable getTable(DefaultTableModel model) {
	      JTable table = new JTable(model);
	      
	      table.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 15));
	      table.setRowHeight(25);
	      // 테이블 컬럼 이동 안되게 설정
	      table.getTableHeader().setReorderingAllowed(false);
	      // 테이블에서 하나의 행만 선택되게 설정
	      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	      
	      return table;
	   }
	// ------------------------------------------------------------------
	
	// 버튼 생성 및 설정 메서드
	public static JButton getButton(String text) {
		 return new JButton() {
			 {
				setHorizontalTextPosition(CENTER);
				setVerticalTextPosition(BOTTOM);
				setForeground(Color.WHITE);
				setFont(new Font("한컴 말랑말랑 Regular",Font.BOLD, 15));
				setText(text);
				setToolTipText(text);
				setBorderPainted(false);
				setFocusPainted(false);
				setContentAreaFilled(false);
				}
		 };
	}
	
	
	public static void main(String[] args) throws SQLException {
		new AdminFrame();
	}
}
