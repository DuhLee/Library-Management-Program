package lmp.members.memberframe.frame;

import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lmp.members.dao.ThemeDao;
import lmp.members.memberframe.button.LogButton;
import lmp.members.memberframe.button.MenuButton;
import lmp.members.memberframe.button.OptionButton;
import lmp.members.memberframe.button.listener.LogButtonListener;
import lmp.members.memberframe.button.listener.MenuButtonListener;
import lmp.members.memberframe.button.listener.OptionButtonListener;
import lmp.members.memberframe.frame.listener.MemberFrameWindowListener;
import lmp.members.memberframe.label.ClockLabel;
import lmp.members.memberframe.panel.HomePanel;
import lmp.members.memberframe.panel.MenuButtonPanel;
import lmp.members.memberframe.panel.MenuCardPanel;
import lmp.members.menu.book.BookSearchPanel;
import lmp.members.menu.member.MemberPanel;
import lmp.members.menu.readingroom.ReadingRoomPanel;
import lmp.members.vo.ThemeVO;
import lmp.util.theme.Theme;


public class MemberFrame extends JFrame{
	
	JPanel panel = new JPanel();
	JScrollPane sp = new JScrollPane();
	
	private static MenuButtonPanel menuButtonPanel;
	private static MenuCardPanel menuCardPanel;
	
	private static  MenuButton bookBtn;
	private static  MenuButton readingroomBtn; 
	private static  MenuButton memberBtn;

	private static  HomePanel homePanel;
	private static BookSearchPanel bookSearchPanel;
	private static ReadingRoomPanel readingroomPanel;
	private static MemberPanel memberPanel;
	
	private static  LogButton loginButton;
	private static  LogButton logoutButton;
	
	private static ClockLabel clockLabel;
	
	private static  OptionButton homeButton;
	private static  OptionButton setupButton;
	
	private static ThemeDao themeDao = new ThemeDao();
	private static Theme theme = new Theme();
	
	public MemberFrame() throws SQLException {
		setLayout(null);
		setBounds(300, 100, 1200, 800);
		setTitle("회원 모드");
		MemberFrame memberFrame = this;
		ThemeVO getTheme = themeDao.getTheme();
		theme.setTheme(getTheme.getName());
		
		
		menuButtonPanel = new MenuButtonPanel();
		menuCardPanel = new MenuCardPanel();
		
		homePanel = new HomePanel();
		bookSearchPanel = new BookSearchPanel();
		readingroomPanel = new ReadingRoomPanel();
		memberPanel = new MemberPanel(this);
		
		bookBtn = new MenuButton("book");
		readingroomBtn = new MenuButton("readingroom"); 
		memberBtn = new MenuButton("member");
		
		loginButton = new LogButton("로그인");
		logoutButton = new LogButton("로그아웃");
		
		homeButton = new OptionButton("home");
		setupButton = new OptionButton("setup");
		
		clockLabel = new ClockLabel();
		
		bookBtn.addActionListener(new MenuButtonListener(this));
		readingroomBtn.addActionListener(new MenuButtonListener(this));
		memberBtn.addActionListener(new MenuButtonListener(this));
		
		loginButton.addActionListener(new LogButtonListener(this));
		logoutButton.addActionListener(new LogButtonListener(this)); 
		homeButton.addActionListener(new OptionButtonListener(this));
		setupButton.addActionListener(new OptionButtonListener(this));
		
		menuButtonPanel.add(bookBtn);
		menuButtonPanel.add(readingroomBtn);
		menuButtonPanel.add(memberBtn);
		
		menuCardPanel.add("홈 화면", homePanel);
		menuCardPanel.add("도서검색", bookSearchPanel);
		menuCardPanel.add("열람실", readingroomPanel);
		menuCardPanel.add("회원정보", memberPanel);
		
		panel.add(clockLabel);
		panel.add(homeButton);
		panel.add(setupButton);
		panel.add(loginButton);
		panel.add(logoutButton);
		panel.add(menuButtonPanel);
		panel.add(menuCardPanel);

		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(1900, 1000));
		panel.setBackground(theme.getMainColor());
		sp.setViewportView(panel);
		sp.getVerticalScrollBar().setUnitIncrement(16);
		
		addWindowListener(new MemberFrameWindowListener());
		setExtendedState(this.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		getContentPane().add(sp);
		setContentPane(sp);
	}

	public void refresh() throws SQLException {
		ThemeVO getTheme = themeDao.getTheme();
		theme.setTheme(getTheme.getName());
	
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(1900, 1000));
		panel.setBackground(theme.getMainColor());
		sp.setViewportView(panel);
		sp.getVerticalScrollBar().setUnitIncrement(16);
	}

	
	
	public MenuCardPanel getMenuCardPanel() {
		return menuCardPanel;
	}

	public LogButton getLoginButton() {
		return loginButton;
	}

	public MemberPanel getMemberMenuPanel() {
		return memberPanel;
	}

	public static Theme getTheme() {
		return theme;
	}
	
	
	
}
