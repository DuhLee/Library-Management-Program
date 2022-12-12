package lmp.members.menu.member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import lmp.admin.menu.employees.EmployeesMgmt;

public class MemberMenu extends JPanel {
	
	public MemberMenu() {
		JLabel memberInfo = new JLabel("회원 정보");
		JLabel membernum = new JLabel("회원번호");
		JLabel membername = new JLabel("이름");
		JLabel memberId = new JLabel("아이디");
		JLabel memberbirth = new JLabel("생년월일");
		JLabel membersex = new JLabel("성별");
		JLabel memberphone = new JLabel("전화번호");
		JLabel memberemail = new JLabel("이메일");
		JLabel memberaddress = new JLabel("주소");
		
		JButton changeBtn = new JButton("수정");
		JButton deleteBtn = new JButton("탈퇴");
		
		
		setlabel(memberInfo, 25, 30, 30 );
		
		setlabel(membernum, 20, 100 ,100);
		
		setlabel(membername, 20, 130, 180);
		
		setlabel(memberId, 20, 120, 260);
		
		setlabel(memberbirth, 20, 100, 340);
		
		setlabel(membersex, 20, 130, 420);
		
		setlabel(memberphone, 20, 600, 100);
		
		setlabel(memberemail, 20, 620, 180);
		
		setlabel(memberaddress, 20, 630, 260);
		
		setBtn(changeBtn, 20, 950, 480);
		
		setBtn(deleteBtn, 20, 1050, 480);
		
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame j = new JFrame(); 
				JLabel finish = new JLabel("탈퇴하시겠습니까?");
				JButton yes = new JButton("예");
				JButton no = new JButton("아니요");
				
				yes.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 15));
				yes.setBounds(40, 70, 80, 35);
				yes.setForeground(Color.RED);
				yes.setBackground(Color.WHITE);
				yes.setFocusable(false);
				j.add(yes);
				
				yes.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame r = new JFrame();
						
						JLabel delete = new JLabel("탈퇴가 완료되었습니다");
						
						delete.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 20));
						delete.setBounds(50, 40, 200, 30);
						r.add(delete);
						
						
						r.dispose();
						r.setLayout(null);
						r.setBounds(650, 450, 300, 150);
						r.getContentPane().setBackground(Color.WHITE);
						r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						r.setVisible(true);
						
					}
				});
				
				no.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 15));
				no.setBounds(170, 70, 80, 35);
				no.setBackground(Color.WHITE);
				no.setFocusable(false);
				j.add(no);
				
				no.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						j.dispose();
					}
				});
				
				
				finish.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 20));
				finish.setBounds(70, 20, 200, 30);
				j.add(finish);
				
				j.dispose();
				j.setLayout(null);
				j.setBounds(600, 400, 300, 170);
				//j.getContentPane().setBackground(new Color(49, 82, 91));
				j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				j.setVisible(true);
			}
		});
		
		
		setBackground(new Color(87, 119, 119));
		setLayout(null);
		//setBorder(new LineBorder(Color.WHITE, 2, false)); // 테두리
		setBounds(15, 180, 1150, 550);
	}
	
	public void setlabel(JLabel label , int size, int x, int y) {
		Font font = new Font("한컴 말랑말랑 Bold", Font.BOLD, size);
		label.setFont(font);
		label.setForeground(Color.WHITE);
		label.setBounds(x, y, 100, 30);
		add(label);
	}
	
	public void setBtn(JButton button , int size, int x, int y) {
		Font font = new Font("한컴 말랑말랑 Bold", Font.BOLD, size);
		
		button.setFont(font);
		button.setBackground(Color.WHITE);
		button.setForeground(new Color(49, 82, 91));
		button.setFocusable(false);
		button.setBounds(x, y, 70, 50);
		add(button);
	}
	
	
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		
		f.add(new MemberMenu(), "Center");

		
		f.getContentPane().setBackground(new Color(49, 82, 91));
		f.setLayout(null);
		f.setBounds(300, 100, 1200, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
