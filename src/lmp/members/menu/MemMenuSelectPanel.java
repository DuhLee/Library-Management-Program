package lmp.members.menu;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JFrame;

import lmp.members.menu.readingroom.sj.ReadingRoomPanel;

public class MemMenuSelectPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		try {
			
			frame.add(new ReadingRoomPanel());
			frame.setBounds(300, 0, 1200, 800);
			frame.getContentPane().setBackground(new Color(49, 82, 91));
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setVisible(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}