package lmp.admin.menu.book.booksearch.scrollpane;

import java.awt.Color;

import javax.swing.JScrollPane;

import lmp.admin.menu.book.booksearch.scrollpane.table.BookSearchListTable;

public class BookSearchListPane extends JScrollPane{
	
	BookSearchListTable bookSearchListTable;
	
	public BookSearchListPane() {
	
		this.bookSearchListTable = new BookSearchListTable();
		this.setViewportView(this.bookSearchListTable);
        this.setBounds(0, 150, 1151, 450);
        this.setBackground(new Color(126, 151, 148));
        
	}

	public BookSearchListTable getBookSearchListTable() {
		return bookSearchListTable;
	}
	
}
