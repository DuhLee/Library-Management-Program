package lmp.admin.menu.book.booksearch.label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class BookSearchLabel extends JLabel{
	
	public BookSearchLabel() {
		
		this.setText("도서검색");
		this.setBounds(500, 25, 200, 50);
		this.setFont(new Font("한컴 말랑말랑 Regular", Font.BOLD, 30));
		this.setForeground(Color.WHITE);
		
	}

}
