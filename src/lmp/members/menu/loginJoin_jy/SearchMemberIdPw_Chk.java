package lmp.members.menu.loginJoin_jy;

import java.sql.SQLException;
import java.util.ArrayList;

import lmp.db.dao.MemberDao;
import lmp.db.vo.MemberVO;

public class SearchMemberIdPw_Chk {
	
	public SearchMemberIdPw_Chk() {

	}

	public boolean FindLoginId_Chk(String sName, String sEmail) {
		// TODO Auto-generated method stub
		MemberDao mDao = new MemberDao();
		ArrayList<MemberVO> memberList = new ArrayList<>();
		try {
			memberList.addAll(mDao.get());
			for (MemberVO member : memberList) {
				if (member.getName().equals(sName) && member.getEmail().equals(sEmail)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	public boolean FindLoginPw_Chk(String sId, String sName, String sEmail) {
		// TODO Auto-generated method stub
		MemberDao mDao = new MemberDao();
		ArrayList<MemberVO> memberList = new ArrayList<>();
		try {
			memberList.addAll(mDao.get());
			for (MemberVO member : memberList) {
				if (member.getId().equals(sId) && 
						member.getName().equals(sName) && 
						member.getEmail().equals(sEmail)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
