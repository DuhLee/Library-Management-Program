package lmp.admin.menu.book.booksearch.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lmp.admin.menu.book.bookregisterframe.BookRegisterFrame;

public class BookRegisterButton extends BookButton {
	
	public BookRegisterButton() {
		
		this.setText("등록");
		this.setBounds(1020, 10, 120, 40);
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new BookRegisterFrame();
				
			}
		});
	}
}
