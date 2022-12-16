package lmp.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lmp.admin.vo.AdminVO;
import lmp.admin.vo.MemberVO;

public class MemberDao extends MenuDao{

	/*
	 * 회원 정보 dao
	 */

	/**
	 * 회원 등록
	 * 
	 * @param memberVO
	 * @throws SQLException
	 */

	@Override
	public void add(MemberVO memberVO) throws SQLException {
		Connection conn = getConnection();

		String sql = "INSERT INTO members VALUES(mem_num_seq.nextval,?,?,?,?,?,?,?,?,sysdate,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, memberVO.getName());
		pstmt.setString(2, memberVO.getId());
		pstmt.setString(3, memberVO.getPw());
		pstmt.setString(4, memberVO.getBirthDay());
		pstmt.setString(5, memberVO.getSex());
		pstmt.setString(6, memberVO.getPhone());
		pstmt.setString(7, memberVO.getEmail());
		pstmt.setString(8, memberVO.getAddress());
		pstmt.setString(9, memberVO.getUpdateDate());
		pstmt.setString(10, memberVO.getNote());

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
	public void update(MemberVO memberVO) throws SQLException {
		Connection conn = getConnection();

		String sql =  "Update members "
				+ "SET mem_name = ?,"
				+ "mem_phone = ?,"
				+ "mem_email = ?,"
				+ "mem_address = ?,"
				+ "mem_updatedate = sysdate "
				+ "WHERE "
				+ "mem_num = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1,memberVO.getName());
		pstmt.setString(2,memberVO.getPhone());
		pstmt.setString(3,memberVO.getEmail());
		pstmt.setString(4,memberVO.getAddress());
		pstmt.setInt(5,memberVO.getNum());

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}

	/**
	 * 전체 회원 목록 가져오기
	 * 
	 * @return ArrayList<MemberVO> memberList
	 */
	@Override
	public ArrayList get() throws SQLException {
		String sql = "SELECT * FROM members";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<MemberVO> memberList = new ArrayList<>();
		while (rs.next()) {
			memberList.add(new MemberVO(
					rs.getInt("mem_num"),
					rs.getString("mem_name"),
					rs.getString("mem_id"),
					rs.getString("mem_pw"),
					rs.getString("mem_birthday"),
					rs.getString("mem_sex"),
					rs.getString("mem_phone"),
					rs.getString("mem_email"),
					rs.getString("mem_address"),
					rs.getString("mem_registrationdate"),
					rs.getString("mem_updatedate"),
					rs.getString("mem_note")));
		}
		rs.close();
		pstmt.close();
		conn.close();

		return memberList;
	}


	/**
	 * 회원 조건 검색
	 * header
	 * num - 회원번호
	 * name - 회원이름
	 * id - 회원 아이디
	 * phone - 회원 연락처
	 * 
	 * searchStr
	 * header에 해당하는 값
	 * 
	 * @param header
	 * @param searchStr
	 * @return ArrayList<MemberVO> memberList
	 */
	@Override
	public ArrayList get(int header, String searchStr) throws SQLException {

		StringBuilder sql = new StringBuilder(selectSql(header));

		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, "%"+searchStr+"%");

		ResultSet rs = pstmt.executeQuery();
		ArrayList<MemberVO> memberList = new ArrayList<>();
		while (rs.next()) {
			memberList.add(new MemberVO(
					rs.getInt("mem_num"),
					rs.getString("mem_name"),
					rs.getString("mem_id"),
					rs.getString("mem_pw"),
					rs.getString("mem_birthday"),
					rs.getString("mem_sex"),
					rs.getString("mem_phone"),
					rs.getString("mem_email"),
					rs.getString("mem_address"),
					rs.getString("mem_registrationdate"),
					rs.getString("mem_updatedate"),
					rs.getString("mem_note")));
		}
		rs.close();
		pstmt.close();
		conn.close();

		return memberList;
	}

	/**
	 * 해당하는 조건의 sql문 가져오기
	 * header
	 * 회원번호 - 1
	 * 회원이름 - 2
	 * 회원아이디 - 3
	 * 회원연락처 - 4
	 * 
	 * @param header
	 * @return StringBuilder sql
	 */
	// 회원번호", "이름", "아이디", "생년월일", "성별", "전화번호"
	public StringBuilder selectSql(int header) {
		StringBuilder sql = new StringBuilder();
		String num = "SELECT * FROM members WHERE mem_num LIKE ?";
		String name = "SELECT * FROM members WHERE mem_name LIKE ?";
		String id = "SELECT * FROM members WHERE mem_id LIKE ?";
		String birthday = "SELECT * FROM members WHERE mem_birthDay LIKE ?";
		String sex = "SELECT * FROM members WHERE mem_sex LIKE ?";
		String phone = "SELECT * FROM members WHERE mem_phone LIKE ?";
		if (header == 1) {
			sql.append(num);
		} else if (header == 2) {
			sql.append(name);
		} else if (header == 3) {
			sql.append(id);
		} else if (header == 4) {
			sql.append(birthday);
		} else if (header == 5) {
			sql.append(sex);
		} else if (header == 6) {
			sql.append(phone);
		}
		return sql;
	}

	/**
	 * 회원 삭제
	 * 
	 * @param memberVO
	 * @throws SQLException
	 */
	
	@Override
	public void delete(String mem_num) throws SQLException {
		String sql = "DELETE FROM members WHERE mem_num = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,mem_num);

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}
	
	

	
}
