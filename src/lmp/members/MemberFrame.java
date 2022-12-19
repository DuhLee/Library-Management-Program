package lmp.members;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lmp.admin.menu.book.booksearch.BookSearchPanel;
import lmp.admin.menu.checkin_out.Member_Searching_Panel;
import lmp.admin.menu.readingroom.readingroom_jy.AdminReadingRoom;
import lmp.members.menu.readingroom.ReadingRoomMain;


public class MemberFrame extends JFrame{

	JButton bookMgmt, memberMgmt, readingRoom;
	
	JFrame f = this;
	public MemberFrame() {

		JPanel menuButtonPanel = new JPanel(new GridLayout(1, 5, 100, 0));
		
		CardLayout card = new CardLayout();
		JPanel menuCardPanel = new JPanel(card);
		
		setTitle("회원 모드");
		setLayout(null);
		
		BufferedImage bufferedBookMgmt = null;
		BufferedImage bufferedCheckIn_Out = null;
		BufferedImage bufferedEmployeeMgmt = null;
		BufferedImage befferedMemberMgmt = null;
		BufferedImage bufferedReadingRoom = null;
		try {
			bufferedBookMgmt = ImageIO.read(new File("src/lmp/admin/menuButtonImages/bookMgmtImage.png"));
			befferedMemberMgmt = ImageIO.read(new File("src/lmp/admin/menuButtonImages/memberMgmtImage.png"));
			bufferedReadingRoom = ImageIO.read(new File("src/lmp/admin/menuButtonImages/readingRoomMgmtImage.png"));
			
			Image bookMgmtIcon = bufferedBookMgmt.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			Image memberMgmtIcon = befferedMemberMgmt.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			Image readingRoomIcon = bufferedReadingRoom.getScaledInstance(100, 100, Image.SCALE_SMOOTH);			
			
			// 버튼 생성 메서드 테스트
			bookMgmt = getButton("도서");
			bookMgmt.setIcon(new ImageIcon(bookMgmtIcon));
			bookMgmt.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					card.show(menuCardPanel, "2");
					
				}
			});	
			
			
			readingRoom = getButton("열람실 관리");
			readingRoom.setIcon(new ImageIcon(readingRoomIcon));
			readingRoom.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					card.show(menuCardPanel, "6");	
				}
			});
			
			memberMgmt = getButton("회원 관리");
			memberMgmt.setIcon(new ImageIcon(memberMgmtIcon));
			
		} catch (IOException e) {
			e.printStackTrace();
		}         
		
		menuButtonPanel.setBounds(90, 40, 1000, 120);
		menuButtonPanel.setBackground(new Color(49, 82, 91));
		
		menuCardPanel.setBounds(17, 200, 1150, 550);
		menuCardPanel.add("1", initialLabel());
		menuCardPanel.add("3", new Member_Searching_Panel());
		
		menuCardPanel.setBounds(17, 200, 1150, 550);
		menuCardPanel.add("1", initialLabel());
		menuCardPanel.add("2", new BookSearchPanel());
		
		menuCardPanel.setBounds(17, 200, 1150, 550);
		menuCardPanel.add("1", initialLabel());
		menuCardPanel.add("6", new ReadingRoomMain());
		
		
		
		menuButtonPanel.add(bookMgmt);
		menuButtonPanel.add(memberMgmt);
		menuButtonPanel.add(readingRoom);
		
		add(menuButtonPanel);
		add(menuCardPanel);
		
		setBounds(300, 100, 1200, 800);
		getContentPane().setBackground(new Color(49, 82, 91));
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
			Image image = buffer.getScaledInstance(1150, 550, Image.SCALE_SMOOTH);
			label.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		label.setSize(1150, 550);
		
		initImagePanel.setLayout(null);
		initImagePanel.add(label);
		
		return initImagePanel;
	}
	
	// 버튼 생성 및 설정 메서드
	public static JButton getButton(String text) {
		 return new JButton() {
			 {
				setHorizontalTextPosition(CENTER);
				setVerticalTextPosition(BOTTOM);
				setForeground(Color.WHITE);
				setFont(new Font("한컴 말랑말랑 Regular",Font.PLAIN, 15));
				setText(text);
				setToolTipText(text);
				setBorderPainted(false);
				setFocusPainted(false);
				setContentAreaFilled(false);
				addMouseListener(new MouseAdapter() {
					// 버튼에 마우스 올리면 테두리 생성
					@Override
					public void mouseEntered(MouseEvent e) {
						setBorderPainted(true);
					}
					// 버튼에서 마우스 떼면 테두리 삭제
					@Override
					public void mouseExited(MouseEvent e) {
						setBorderPainted(false);
					}
				});
				}
		 };
	}
	
	
	public static void main(String[] args) {
		new MemberFrame();
	}
}
