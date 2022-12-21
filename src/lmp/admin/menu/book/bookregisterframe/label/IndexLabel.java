package lmp.admin.menu.book.bookregisterframe.label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class IndexLabel extends JLabel{
	
	
	public IndexLabel(String index) {
		
		this.setText(index);
		this.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 15));
		this.setForeground(Color.WHITE);
		
	}

}
