package lmp.members.menu.readingroom.jy;

import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.plaf.synth.SynthScrollPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import lmp.members.menu.readingroom.jy.ReadingRoomTable.JTableMouseListener;

public class Compulsory_CheckOut_Frame extends JFrame {

	JFrame child = this;
	JFrame parent;

	JLabel CheckOut = new JLabel() {
		{
			setText("해당 좌석을 퇴실처리 하시겠습니까?");
			setBounds(40, 30, 250, 50);
		}
	};




	JButton yes_button = new JButton("예") {
		{
			setBounds(35, 100, 100, 30);
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("버튼이 눌리면 자동으로 종료시간에 '현재 시간'이 들어가고 동시에 사용여부가 '사용가능'으로 바뀐다.");
					child.setVisible(false);
				}
			});
		}
	};


	// 아니요 버튼을 누르면 창이 꺼진다.
	JButton no_button = new JButton("아니요") {
		{
			setBounds(155, 100, 100, 30);
			addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					child.setVisible(false);
				}
			});
		}
	};


	public Compulsory_CheckOut_Frame (JFrame parent) {
		this.parent = parent;
		add(CheckOut);
		add(yes_button);
		add(no_button);
		setLayout(null);
		setLocation(700, 200);
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}

	public void open() {
		setVisible(true);
		parent.setVisible(true);
	}
}