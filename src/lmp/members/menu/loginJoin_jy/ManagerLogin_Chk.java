package lmp.members.menu.loginJoin_jy;

import java.sql.SQLException;
import java.util.ArrayList;

import lmp.admin.dao.AdminDao;
import lmp.admin.vo.AdminVO;

public class ManagerLogin_Chk {
	
	public ManagerLogin_Chk() {

	}

	public boolean LogInList_Chk(String sNum, String sPW) {
		// TODO Auto-generated method stub
		AdminDao adminDao = new AdminDao();
		ArrayList<AdminVO> adminList = new ArrayList<>();
		try {
			adminList.addAll(adminDao.get());
			for (AdminVO admin : adminList) {
				System.out.println(admin.getNum());
				if (admin.getNum().equals(sNum) && admin.getPw().equals(sPW)) {
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
