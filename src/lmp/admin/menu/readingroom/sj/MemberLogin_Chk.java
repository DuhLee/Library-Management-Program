package lmp.admin.menu.readingroom.sj;


import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;

import lmp.db.dao.MemberDao;
import lmp.db.vo.MemberVO;
import lmp.db.vo.SeatUseDetailVO;

public class MemberLogin_Chk {
	
	public MemberLogin_Chk() {

	}

	public boolean LogInList_Chk(String sID, String sPW) {
		// TODO Auto-generated method stub
		MemberDao mDao = new MemberDao();
		ArrayList<MemberVO> memberList = new ArrayList<>();
		try {
			memberList.addAll(mDao.get());
			for (MemberVO member : memberList) {
				if (member.getId().equals(sID) && member.getPw().equals(sPW)) {
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




