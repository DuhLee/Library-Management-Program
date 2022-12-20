package lmp.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lmp.admin.vo.AdminLogHistoryVO;
import lmp.admin.vo.AdminVO;

public class AdminLogHistoryDao extends MenuDao{


	
	@Override
	public void add(AdminLogHistoryVO adminLogVO) throws SQLException{
		
		Connection conn = getConnection();
		
		String sql = "INSERT INTO admin_log_histroy(admin_log_id,admin_num) VALUES(mem_log_id_seq.nextval,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, adminLogVO.getAdminVO().getNum());
		
		pstmt.executeUpdate();
			
		pstmt.close();
		conn.close();
	}
	
	/**
	 * 회원 정보 수정
	 * 
	 * @param memberVO
	 * @throws SQLException
	 */
	@Override
	public void update(AdminLogHistoryVO adminLogVO) throws SQLException {
		
		Connection conn = getConnection();
		
		String sql =  "UPDATE admin_log_history SET logout_time = to_char(sysdate, 'yyyy.mm.dd hh24:mi') WHERE admin_num = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
			
		pstmt.setInt(1,adminLogVO.getLog_id());
			
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	@Override
	public AdminLogHistoryVO getLog() throws SQLException {
		String sql = "SELECT * FROM admin_log_history JOIN admins USING(admin_num) WHERE logout_time IS NULL";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		AdminLogHistoryVO adminLogVO = null;
		while (rs.next()) {
			adminLogVO = new AdminLogHistoryVO(rs.getInt("admin_log_id"), 
					new AdminVO(
					rs.getInt("admin_num"),
					rs.getString("admin_name"),
					rs.getString("admin_pw"),
					rs.getString("admin_phone"),
					rs.getString("admin_email"),
					rs.getString("admin_address"),
					rs.getString("admin_registrationdate"),
					rs.getString("admin_updatedate"),
					rs.getString("admin_note")), 
					rs.getString("login_Time"), rs.getString("logout_Time"));
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return adminLogVO;
	}

	@Override
	public void delete(Integer mem_id) throws SQLException {
		String sql = "DELETE FROM admin_log_history WHERE admin_id = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, mem_id);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	
}
