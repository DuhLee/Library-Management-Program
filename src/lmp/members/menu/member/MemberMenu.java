package lmp.members.menu.member;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import lmp.members.dao.MemberLogHistroyDao;
import lmp.members.vo.MemberLogHistoryVO;
import lmp.members.vo.MemberVO;


public class MemberMenu extends JPanel {

	MemberLogHistroyDao mdao = new MemberLogHistroyDao();
	MemberLogHistoryVO logvo = new MemberLogHistoryVO(mdao.getLog());
	
	public MemberMenu() throws SQLException {
		JLabel memberInfo = new JLabel("회원 정보");
		JLabel membernum = new JLabel("회원번호");
		JLabel membername = new JLabel("이름");
		JLabel memberId = new JLabel("아이디");
		JLabel memberbirth = new JLabel("생년월일");
		JLabel membersex = new JLabel("성별");
		JLabel memberphone = new JLabel("전화번호");
		JLabel memberemail = new JLabel("이메일");
		JLabel memberaddress = new JLabel("주소");

		// 받아온내용 get.mem_name;
		MemberVO mvo = logvo.getMemberVO();
		JLabel membernum2 = new JLabel("" + mvo.getNum());
		JLabel membername2 = new JLabel("" + mvo.getName());
		JLabel memberId2 = new JLabel("" + mvo.getId());
		JLabel memberbirth2 = new JLabel("" + mvo.getBirthDay());
		JLabel membersex2 = new JLabel("" + (mvo.getSex().equals("0") ? "남" : "여"));
		JLabel memberphone2 = new JLabel("" + mvo.getPhone());
		JLabel memberemail2 = new JLabel("" + mvo.getEmail());
		JLabel memberaddress2 = new JLabel("" + mvo.getAddress());

		JButton changeBtn = new JButton("수정");
		JButton deleteBtn = new JButton("탈퇴");


		setlabel(memberInfo, 25, 30, 30);

		setlabel(membernum, 20, 100 ,100);
		setlabel(membernum2, 20, 300 ,100);

		setlabel(membername, 20, 130, 180);
		setlabel(membername2, 20, 300, 180);

		setlabel(memberId, 20, 120, 260);
		setlabel(memberId2, 20, 300, 260);

		setlabel(memberbirth, 20, 100, 340);
		setlabel(memberbirth2, 20, 300, 340);

		setlabel(membersex, 20, 130, 420);
		setlabel(membersex2, 20, 300, 420);

		setlabel(memberphone, 20, 600, 100);
		setlabel(memberphone2, 20, 800, 100);

		setlabel(memberemail, 20, 620, 180);
		setlabel(memberemail2, 20, 800, 180);

		setlabel(memberaddress, 20, 630, 260);
		setlabel(memberaddress2, 20, 800, 260);

		setBtn(changeBtn, 20, 950, 480);

		setBtn(deleteBtn, 20, 1050, 480);

		// 수정버튼 구현
		changeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame j = new JFrame();

				JLabel join = new JLabel("회원수정");
				JLabel id = new JLabel("아이디");
				JLabel pw = new JLabel("비밀번호");
				JLabel chkpw = new JLabel("비밀번호확인");
				JLabel name = new JLabel("이름");
				JLabel birth = new JLabel("생년월일");
				JLabel sex = new JLabel("성별");
				JLabel phone = new JLabel("전화번호");
				JLabel email = new JLabel("이메일");
				JLabel address = new JLabel("주소");

				// get
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
				JButton changeBtn2 = new JButton("수정");
				JButton cancelBtn = new JButton("취소");


				JRadioButton maleBtn = new JRadioButton("남");
				JRadioButton femaleBtn = new JRadioButton("여");


				setlabel2(join, 40, 55, 13);
				j.add(join);

				setlabel2(id, 18, 40, 90);
				setField(idField, 113);
				setBtn(idcheckBtn, 13, 400, 113);
				checkBtn(idcheckBtn);
				j.add(id);
				j.add(idField);

				setlabel2(pw, 18, 40, 140);
				setField(pwField, 163);
				j.add(pw);
				j.add(pwField);

				setlabel2(chkpw, 18, 40, 190);
				setField(chkpwField, 213);
				j.add(chkpw);
				j.add(chkpwField);

				setlabel2(name, 18, 40, 240);
				setField(nameField, 263);
				j.add(name);
				j.add(nameField);

				setlabel2(birth, 18, 40, 290);
				setField(birthField, 313);
				j.add(birth);
				j.add(birthField);

				Font font = new Font("한컴 말랑말랑 Bold", Font.BOLD, 18);
				setlabel2(sex, 18, 40, 340);
				j.add(sex);
				maleBtn.setFont(font);
				maleBtn.setBounds(200, 360, 100, 30);
				j.add(maleBtn);

				femaleBtn.setFont(font);
				femaleBtn.setBounds(300, 360, 100, 30);
				j.add(femaleBtn);

				ButtonGroup g = new ButtonGroup();
				g.add(femaleBtn);
				g.add(maleBtn);

				setlabel2(phone, 18, 40, 390);
				setField(phoneField, 413);
				j.add(phone);
				j.add(phoneField);

				setlabel2(email, 18, 40, 440);
				setField(emailField, 463);
				setBtn2(emailcheckBtn, 13, 400, 463, 80, 30);
				checkBtn(emailcheckBtn);
				j.add(email);
				j.add(emailField);
				j.add(emailcheckBtn);

				setlabel2(address, 18, 40, 490);
				setField(addressField, 513);
				j.add(address);
				j.add(addressField);

				setBtn2(changeBtn2, 18, 280, 580, 80, 40 );
				j.add(changeBtn2);

				changeBtn2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame r = new JFrame();

						JLabel delete = new JLabel("수정이 완료되었습니다");

						delete.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 20));
						delete.setBounds(50, 40, 200, 30);
						r.add(delete);


						r.dispose();
						r.setLayout(null);
						r.setBounds(450, 400, 300, 150);
						r.getContentPane().setBackground(Color.WHITE);
						r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						r.setVisible(true);

					}
				});

				setBtn2(cancelBtn, 18, 380, 580, 80, 40);
				j.add(cancelBtn);

				cancelBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						j.dispose();
					}
				});

				j.setLayout(null);
				j.setBounds(330, 130, 550, 700);
				j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				j.setVisible(true);
			}
		});

		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int var = JOptionPane.showConfirmDialog
						(null, "삭제하시겠습니까?", " ",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null);
				if (var == JOptionPane.YES_OPTION) {

				}
			}
		});



		// 판넬 설정
		setBackground(new Color(87, 119, 119));
		setLayout(null);
		//setBorder(new LineBorder(Color.WHITE, 2, false)); // 테두리
		setBounds(15, 180, 1150, 550);
	}

	// 라벨 생성 및 설정함수
	public void setlabel(JLabel label , int size, int x, int y) {
		Font font = new Font("한컴 말랑말랑 Bold", Font.BOLD, size);
		label.setFont(font);
		label.setForeground(Color.WHITE);
		label.setBounds(x, y, 300, 30);
		add(label);
	}

	public void setlabel2(JLabel label , int size, int x, int y) {
		Font font = new Font("한컴 말랑말랑 Bold", Font.BOLD, size);
		label.setFont(font);
		label.setForeground(new Color(49, 82, 91));
		label.setBounds(x, y, 200, 70);
		add(label);
	}

	// 버튼 생성 및 설정함수
	public void setBtn(JButton button , int size, int x, int y) {
		Font font = new Font("한컴 말랑말랑 Bold", Font.BOLD, size);

		button.setFont(font);
		button.setBackground(Color.WHITE);
		button.setForeground(new Color(49, 82, 91));
		button.setFocusable(false);
		button.setBounds(x, y, 70, 50);
		add(button);
	}

	public void setBtn2(JButton button , int size, int x, int y, int a, int b) {
		Font font = new Font("한컴 말랑말랑 Bold", Font.BOLD, size);

		button.setFont(font);
		button.setBackground(new Color(87, 119, 119));
		button.setForeground(Color.WHITE);
		button.setFocusable(false);
		button.setBounds(x, y, a, b);
		add(button);
	}

	// 텍스트필드 생성 및 설정함수
	public void setField(JTextField field, int y) {
		Font font = new Font("한컴 말랑말랑 Bold", Font.BOLD, 13);
		field.setFont(font);
		field.setBounds(180, y, 200, 30);
		field.setBorder(new LineBorder(new Color(49, 82, 91), 2, false));
		add(field);
	}

	// 중복확인 버튼 액션리스너
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
}
