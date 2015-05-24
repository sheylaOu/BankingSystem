package service;

import java.util.ArrayList;

import db_dao.AccountsDAO;
import db_dao.AccountsDAOImpl;
import db_vo.Accounts;

public class AccountsServiceImpl implements AccountsService {
	Accounts ac = new Accounts();
	AccountsDAO acd = new AccountsDAOImpl();

	@Override
	public ArrayList<Accounts> bindingAccounts(String u_id) {
		// TODO Auto-generated method stub
		ArrayList<Accounts> aclist = new ArrayList<Accounts>();
		try {
			aclist = acd.selectByU_id(u_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aclist;
	}

	@Override
	public Accounts accountDetail(String a_id) {
		// TODO Auto-generated method stub
		try {
			ac = acd.accountDetail(a_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ac;
	}

	@Override
	public boolean resetTransPwd(String a_id, String pwd) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = acd.updateTransPwd(a_id, pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public boolean openAccount(Accounts newAc) {
		try {
			ac = acd.accountDetail(newAc.getA_id());
			if (ac.getA_id()!=null) {
				return false;
			}
			return acd.addAccount(newAc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public String getOwerName(String a_id){
		UsersService us=new UsersServiceImpl();
		String u_id="";
		try {
			u_id = acd.selectUidByAid(a_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return us.getRealname(u_id);
	}

}
