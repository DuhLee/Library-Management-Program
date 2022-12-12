package lmp.members.menu.member;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MemberJoin extends JFrame {

	public MemberJoin() {
		JLabel join = new JLabel("회원가입");
		JLabel id = new JLabel("아이디");
		JLabel pw = new JLabel("비밀번호");
		JLabel chkpw = new JLabel("비밀번호확인");
		JLabel name = new JLabel("이름");
		JLabel birth = new JLabel("생년월일");
		JLabel sex = new JLabel("성별");
		JLabel phone = new JLabel("전화번호");
		JLabel email = new JLabel("이메일");
		JLabel address = new JLabel("주소");
		
		JTextField idField = new JTextField();
		JTextField pwField = new JTextField(" 8자리이상 입력해주세요");
		JTextField chkpwField = new JTextField();
		JTextField nameField = new JTextField();
		JTextField birthField = new JTextField(" ex) 1997-05-05");
		JTextField phoneField = new JTextField();
		JTextField emailField = new JTextField();
		JTextField addressField = new JTextField();
		
		JButton idcheckBtn = new JButton("중복확인");
		JButton emailcheckBtn = new JButton("중복확인");
		JButton joinBtn = new JButton("가입하기");
		
		JRadioButton maleBtn = new JRadioButton("남");
		JRadioButton femaleBtn = new JRadioButton("여");
		
		
		
		
		setlabel(join, 40, 55, 13);
		
		setlabel(id, 18, 40, 90);
		setField(idField, 113);
		setBtn(idcheckBtn, 13, 400, 113);
		checkBtn(idcheckBtn);
		
		setlabel(pw, 18, 40, 140);
		setField(pwField, 163);
		
		setlabel(chkpw, 18, 40, 190);
		setField(chkpwField, 213);
		
		setlabel(name, 18, 40, 240);
		setField(nameField, 263);
		
		setlabel(birth, 18, 40, 290);
		setField(birthField, 313);
		
		Font font = new Font("한컴 말랑말랑 Bold", Font.BOLD, 18);
		setlabel(sex, 18, 40, 340);
		maleBtn.setFont(font);
		maleBtn.setBounds(200, 360, 100, 30);
		add(maleBtn);
		
		femaleBtn.setFont(font);
		femaleBtn.setBounds(300, 360, 100, 30);
		add(femaleBtn);
		
		ButtonGroup g = new ButtonGroup();
		g.add(femaleBtn);
		g.add(maleBtn);
		
		setlabel(phone, 18, 40, 390);
		setField(phoneField, 413);
		
		setlabel(email, 18, 40, 440);
		setField(emailField, 463);
		setBtn(emailcheckBtn, 13, 400, 463);
		checkBtn(emailcheckBtn);
		
		setlabel(address, 18, 40, 490);
		setField(addressField, 513);
		
		setBtn(joinBtn, 15, 330, 580);
		joinBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame r = new JFrame();
				
				JLabel delete = new JLabel("성공적으로 가입되었습니다");
				
				delete.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 20));
				delete.setBounds(30, 40, 250, 30);
				r.add(delete);
				
				
				r.dispose();
				r.setLayout(null);
				r.setBounds(450, 350, 300, 150);
				r.getContentPane().setBackground(Color.WHITE);
				r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				r.setVisible(true);
				
			}
		});
		
		
		setLayout(null);
		setBounds(300, 100, 550, 700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void setlabel(JLabel label , int size, int x, int y) {
		Font font = new Font("한컴 말랑말랑 Bold", Font.BOLD, size);
		label.setFont(font);
		label.setForeground(new Color(49, 82, 91));
		label.setBounds(x, y, 200, 70);
		add(label);
	}
	
	public void setField(JTextField field, int y) {
		Font font = new Font("한컴 말랑말랑 Bold", Font.BOLD, 13);
		field.setFont(font);
		field.setBounds(180, y, 200, 30);
		field.setBorder(new LineBorder(new Color(49, 82, 91), 2, false));
		add(field);
	}
	
	public void setBtn(JButton button , int size, int x, int y) {
		Font font = new Font("한컴 말랑말랑 Bold", Font.BOLD, size);
		
		button.setFont(font);
		button.setBackground(new Color(87, 119, 119));
		button.setForeground(Color.WHITE);
		button.setFocusable(false);
		button.setBounds(x, y, 90, 30);
		add(button);
	}
	
	public void checkBtn(JButton button) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame r = new JFrame();
				
				JLabel delete = new JLabel("사용가능합니다");
				
				delete.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 20));
				delete.setBounds(75, 40, 250, 30);
				r.add(delete);
				
				
				r.dispose();
				r.setLayout(null);
				r.setBounds(450, 350, 300, 150);
				r.getContentPane().setBackground(Color.WHITE);
				r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				r.setVisible(true);
				
			}
		});
	}
	
	
	
	public static void main(String[] args) {
		new MemberJoin();
		
		//		JFrame f = new JFrame();
//
//
//		f.add(new MemberJoin(), "Center");
//
//
//		//f.getContentPane().setBackground(Color.WHITE);
//		f.setLayout(null);
//		f.setBounds(300, 100, 560, 750);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
	}
}
