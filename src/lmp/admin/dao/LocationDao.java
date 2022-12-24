package lmp.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lmp.admin.vo.LocationVO;

public class LocationDao extends MenuDao{
	
	public void add(LocationVO locationVO) throws SQLException{
		Connection conn = getConnection(); 
		
		String sql = "INSERT INTO locations VALUES(?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
			
		pstmt.setString(1, locationVO.getLocID());
		pstmt.setString(2, locationVO.getLocName());
		
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
}
