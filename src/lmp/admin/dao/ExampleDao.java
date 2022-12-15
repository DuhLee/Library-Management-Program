package lmp.admin.dao;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageWriter;
import javax.swing.ImageIcon;

import lmp.admin.vo.BookVO;

public class ExampleDao {
	
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user = "mydb";
	private static String pw = "1234";
	
	public void add(BookVO bookVO) throws SQLException {
		
		Connection conn = getConnection(); 
		System.out.println("커넥션");
		String sql = "INSERT INTO books("
									  + "book_id,"
									  + "book_title,"
									  + "book_author,"
									  + "book_publisher,"
									  + "book_isbn,"
									  + "book_price,"
									  + "location_id,"
									  + "book_registrationdate,"
									  + "book_note) VALUES(book_id_seq.nextval,?,?,?,?,?,?,sysdate,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
			
		pstmt.setString(1, bookVO.getTitle());
		pstmt.setString(2, bookVO.getAuthor());
		pstmt.setString(3, bookVO.getPublisher());
		pstmt.setString(4, bookVO.getIsbn());
//		pstmt.setInt(5, bookVO.getBias());
//		pstmt.setInt(6, bookVO.getDuplicates());//복권수 확인 절차
		pstmt.setInt(5, bookVO.getPrice());
		pstmt.setString(6, bookVO.getLocation().getLocID());
		pstmt.setString(7, bookVO.getNote());
		System.out.println("쓰기?");	
		pstmt.executeUpdate();
		System.out.println("성공?");
		pstmt.close();
		conn.close();
		
	}
	
	public void add(File file) throws SQLException, IOException {
		
		String sql = "INSERT INTO images VALUES(image_id_seq.nextval,?,?)";
		FileInputStream fis = new FileInputStream(file);
		
		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "" + file.getName());
		pstmt.setBlob(2, fis, (int)file.length());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();		
	}
	
	public byte[] getImage(String image_name) throws SQLException, IOException {
		
		String sql = "SELECT image_info FROM images WHERE image_name = ?";
		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,image_name);
		ResultSet rs = pstmt.executeQuery();
		
		byte[] bytes = null;
		while(rs.next()) {
			bytes = rs.getBytes("image_info"); 
		}
		
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return bytes;
	}
	
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, pw);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("Class 못찾음");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		}
		return null; 
	}

}
