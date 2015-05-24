package service;

import java.util.ArrayList;

import db_vo.Accounts;

public interface AccountsService {
	public ArrayList bindingAccounts(String u_id); //选择出改用户绑定的银行账号信息
	public Accounts accountDetail(String a_id);    //账户详细信息
	public boolean resetTransPwd(String a_id,String pwd); //重置交易密码
	public boolean openAccount(Accounts ac);        //新增绑定用户
	public String getOwerName(String a_id);         //获取账号所有者真名
	
}
