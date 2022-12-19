package lmp.admin.menu.book.booksearch.button;

import lmp.admin.menu.book.booksearch.scrollpane.table.BookSearchListTable;

public class BookSearchButton extends BookButton{

	BookSearchListTable bookSearchListTable;
	
	public BookSearchButton(BookSearchListTable bookSearchListTable) {
		this.setText("검색");
		this.bookSearchListTable = bookSearchListTable;
		this.setBounds(840, 80, 100, 30);
	}
}
