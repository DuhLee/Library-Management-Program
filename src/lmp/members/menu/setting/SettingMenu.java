package lmp.members.menu.setting;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import lmp.members.MemberFrame;
import lmp.members.dao.FontDao;
import lmp.members.dao.ThemeDao;
import lmp.members.menu.setting.listener.FontListener;
import lmp.members.menu.setting.listener.ThemeListener;

public class SettingMenu extends JFrame {

	private Font font = new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14);

	GridLayout gridLayout = new GridLayout(1, 3);

	JButton[] themeBtns;
	JButton[] fontBtns;
	ThemeDao themeDao = new ThemeDao();
	FontDao fontDao = new FontDao();
	ArrayList<String> themes = new ArrayList<>();
	ArrayList<String> fonts = new ArrayList<>();
	MemberFrame memberFrame;
	
	public SettingMenu(MemberFrame memberFrame) throws SQLException {
		this.memberFrame = memberFrame;
		initialize();
		
	}

	public void initialize() throws SQLException {
		
		SettingMenu setMenu = this;
		getContentPane().setLayout(null);

		JLabel titleLabel = new JLabel("설정");
		titleLabel.setFont(new Font("굴림", Font.BOLD, 30));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(140, 10, 95, 29);
		getContentPane().add(titleLabel);

		JLabel themeTitleLabel = new JLabel("테마");
		themeTitleLabel.setBounds(12, 54, 57, 15);
		getContentPane().add(themeTitleLabel);

		JPanel themePanel = new JPanel();
		themePanel.setBounds(12, 79, 360, 46);
		getContentPane().add(themePanel);
		themePanel.setLayout(new GridLayout(1, 3, 5, 5));
		
		themes.addAll(themeDao.getThemes());
		themeBtns = new JButton[themes.size()];

		for (int i = 0; i < themes.size(); i++) {
			themeBtns[i] = getThemeButton(themes.get(i));
		}
		
		for (JButton themeBtn : themeBtns) {
			themeBtn.addMouseListener(new ThemeListener(themeBtns));
			themePanel.add(themeBtn);
		}
		
		

		JLabel fontTitleLabel = new JLabel("폰트크기");
		fontTitleLabel.setBounds(12, 135, 57, 15);
		getContentPane().add(fontTitleLabel);

		JPanel fontPanel = new JPanel();
		fontPanel.setBounds(12, 160, 360, 46);
		getContentPane().add(fontPanel);
		fontPanel.setLayout(new GridLayout(1, 3, 5, 5));
		
		
		fonts.addAll(fontDao.getFonts());
		fontBtns = new JButton[fonts.size()];
		
		for (int i = 0; i < fonts.size(); i++) {
			fontBtns[i] = getFontButton(fonts.get(i));
		}
		
		for (JButton fontBtn : fontBtns) {
			fontBtn.addMouseListener(new FontListener(fontBtns));
			fontPanel.add(fontBtn);
		}
		
		JButton btnNewButton = new JButton("닫기");
		btnNewButton.setBounds(275, 228, 97, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					memberFrame.initialize();
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
				memberFrame.validate();
				setMenu.dispose();
				
			}
		});
		getContentPane().add(btnNewButton);
		
		setSize(400,300);

	}
	
	public JButton getThemeButton(String text) throws SQLException {
		
		return new JButton() {
			{
				setText(text);
				if (themeDao.getTheme().equals(text)) {
					setBackground(Color.BLUE);
				} else {
					setBackground(Color.LIGHT_GRAY);
				}
			}
		};
	}

	public JButton getFontButton(String text) throws SQLException {

		return new JButton() {
			{
				setText(text);
				if (fontDao.getFont().equals(text)) {
					setBackground(Color.BLUE);
				} else {
					setBackground(Color.LIGHT_GRAY);
				}
			}
		};
	}

}
