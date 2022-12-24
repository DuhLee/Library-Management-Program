package lmp.login.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import lmp.admin.AdminFrame;
import lmp.admin.dao.AdminDao;
import lmp.admin.dao.AdminLogHistoryDao;
import lmp.admin.menu.employees.EmployeeRegistrationFrame;
import lmp.admin.vo.AdminVO;
import lmp.login.SelectModeFrame;
import lmp.util.ImageConvert;

public class AdminLoginFrame extends JFrame{

	SelectModeFrame selectModeFrame;
	AdminLoginFrame adminLoginFrame;
	AdminFrame adminFrame;						
	
	AdminLogHistoryDao adminLogHistoryDao = new AdminLogHistoryDao();
	AdminDao adminDao = new AdminDao();

	private JTextField idField;
	private JPasswordField pwField;

	ImageConvert img = new ImageConvert();
	public AdminLoginFrame(SelectModeFrame selectModeFrame) {
		this.selectModeFrame = selectModeFrame;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		adminLoginFrame = this;
		setAutoRequestFocus(false);
		setBounds(100, 100, 400, 350);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		
		JPanel loginPanel = new JPanel();
		getContentPane().add(loginPanel, BorderLayout.CENTER);
		loginPanel.setLayout(null);
		loginPanel.setBackground(new Color(186, 206, 194));
		loginPanel.setFocusCycleRoot(true);
		
		
		
		
		idField = new JTextField("사원번호");
		idField.setBounds(50, 105, 300, 35);
		loginPanel.add(idField);
		idField.setColumns(30);
		
		JTextField pwTField = new JTextField("비밀번호");
		
		pwTField.setBounds(50, 160, 300, 35);
		loginPanel.add(pwTField);
		
		
		pwField = new JPasswordField();
		pwField.setBounds(50, 160, 300, 35);
		loginPanel.add(pwField);
		pwField.setColumns(30);

		JButton loginBtn = new JButton("로그인");
		loginBtn.setBounds(50, 210, 302, 40);
		loginBtn.setFocusPainted(false);
		loginPanel.add(loginBtn);

		JLabel loginImageLabel = new JLabel();
		loginImageLabel.setIcon(img.scaledMenuImage("dhlibrary"));
		loginImageLabel.setBounds(140, 10, 100,100);
		
		loginPanel.add(loginImageLabel);
		
		JLabel joinLabel = new JLabel("회원가입");
		joinLabel.setBounds(290, 270, 70, 15);
		joinLabel.addMouseListener(getMouseListener());
		loginPanel.add(joinLabel);
		
		
		idField.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				if (idField.getText().equals("사원번호")) {
					idField.setText("");
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if (idField.getText().equals("")) {
					idField.setText("사원번호");
				}
				
			}
		});
		
		pwTField.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				pwTField.setVisible(false);
				pwField.setFocusable(true);
				pwField.requestFocusInWindow();
				
			}
		});
		
		pwField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (new String(pwField.getPassword()).equals("")) {					
					pwTField.setVisible(true);
				}
			}
		});
		
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(idField.getText() + new String(pwField.getPassword()));
					if (checkLogin(idField.getText(), new String(pwField.getPassword()))) {
						adminLoginFrame.dispose();
						selectModeFrame.dispose();
						adminFrame = new AdminFrame();

					} else {
						JOptionPane.showMessageDialog(adminLoginFrame, "사원번호/비밀번호를 확인하세요");
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}

		});
		
		joinLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EmployeeRegistrationFrame();
			}
		});
	}
	
	public MouseListener getMouseListener() {
		MouseListener mouse = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {				
				setCursor(null);
			}
		};
		return mouse;
	}
	
	
	

	public boolean checkLogin(String admin_num, String admin_pw) {
		AdminVO adminVO = null;
		try {
			
			adminVO = adminDao.getAdminInfo(Integer.parseInt(admin_num));
			System.out.println(adminVO);
			if (adminVO == null) {
				return false;
			} else {
				if (adminVO.getPw().equals(admin_pw)) {
					adminLogHistoryDao.add(adminVO);
					return true;
				} else {
					return false;
				}
			}
			
		}catch (NumberFormatException nfe) {
			System.out.println("사원번호 확인");
			return false;
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql exception");
			return false;
		}
	}
}
