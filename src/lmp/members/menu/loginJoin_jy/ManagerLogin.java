package lmp.members.menu.loginJoin_jy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class ManagerLogin extends JFrame {
	
	private JPanel contentPane;
	private JTextField idTextFiled;
	private JPasswordField pwField;

	private String sID = "";
	private String sPW = "";
	
	
	public ManagerLogin() {
		
		// 기본 프레임 세팅
		setTitle("관리자 로그인");
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setMinimumSize(new Dimension(400, 164));
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(186, 206, 194));
		
		
		// 라벨 
		JLabel idLabel = new JLabel("관리자번호", JLabel.LEFT);
		idLabel.setHorizontalAlignment(JLabel.CENTER);
		idLabel.setBounds(30, 40, 65, 15);
		contentPane.add(idLabel);
		
		
		idTextFiled = new JTextField("관리자번호를 입력해주세요");
		idTextFiled.setText("");
		// sID = idTextFiled.getText();
		idTextFiled.setBounds(99, 40, 167, 21);
		contentPane.add(idTextFiled);
		idTextFiled.setColumns(10);
		
		
		JLabel pwLabel = new JLabel("관리자암호", JLabel.LEFT);
		pwLabel.setHorizontalAlignment(JLabel.CENTER);
		pwLabel.setBounds(30, 65, 65, 15);
		contentPane.add(pwLabel);
		
		
		pwField  = new JPasswordField("관리자암호를 입력해주세요");
		pwField.setText("");
		// sPW = pwField.getText();
		pwField.setBounds(99, 65, 167, 21);
		contentPane.add(pwField);
		pwField.setColumns(10);

		
		JButton loginBtn = new JButton("로그인");
		loginBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				// 로그인 했을 때 작업
				boolean bLoginChk = false;
				GetIdandPw(idTextFiled, pwField); // 입력된 값 각각 넘겨 주기
				ManagerLogin_Chk loginchk = new ManagerLogin_Chk();
				bLoginChk = loginchk.LogInList_Chk(sID, sPW); // false면 로그인 실패

				if (!bLoginChk) { // 로그인 실패
					JOptionPane.showMessageDialog(null, "관리자번호 또는 관리자암호를 확인 후\n다시 로그인해주세요.");
				} else { // 로그인 성공
					setVisible(false); // 기존의 로그인 화면 꺼주기
					 // 열람실 조회화면으로 갱신
				}
			}
		});
		loginBtn.setBounds(274, 40, 80, 46);
		contentPane.add(loginBtn);

		
		Reset(idTextFiled, pwField);
		
		// 버튼 테두리 설정
		loginBtn.setBorderPainted(false);
		
		// 텍스트필드와 패스워드필드 테두리 설정
		pwField.setBorder(null);
		idTextFiled.setBorder(null);
		
		// 포커스 표시 설정
		loginBtn.setFocusPainted(false);
		
		// 로그인 버튼의 배경 색상을 변경
		loginBtn.setBackground(Color.GRAY);
		
		// 로그인 버튼의 폰트 색상을 변경
		loginBtn.setForeground(Color.WHITE);
		
		
		// 폰트설정
		idLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		pwLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 14));
		loginBtn.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 15));

		// 색상 변경
		idLabel.setForeground(Color.WHITE);
		pwLabel.setForeground(Color.WHITE);
		
		idTextFiled.setForeground(Color.LIGHT_GRAY);
		pwField.setForeground(Color.LIGHT_GRAY);

	}
	
	
	private void GetIdandPw (JTextField idTextFiled, JTextField pwField) {
		// TODO Auto-generated method stub
		sID = idTextFiled.getText();
		sPW = pwField.getText();
	}

	private void Reset (JTextField idTextFiled, JTextField pwField) {
		idTextFiled.setText(null);
		pwField.setText(null);
	}
	
	public static void main(String[] args) {
		new ManagerLogin();
		
	}
	
}