package db_dao;

import java.util.ArrayList;

import db_vo.Accounts;

public interface AccountsDAO {
	public ArrayList selectByU_id(String u_id) throws Exception;	
	public Accounts accountDetail(String a_id) throws Exception;
	public String selectTranspwd(String a_id) throws Exception;
	public String selectUidByAid(String a_id) throws Exception;
	public boolean updateTransPwd(String a_id,String transpwd) throws Exception;
	public boolean addAccount(Accounts ac) throws Exception;
}
