package service;

import java.util.ArrayList;

import db_vo.Deposits;

public interface DepositsService {
	public boolean deposit(Deposits deposit);         //存款
	public ArrayList checkDepositsRecord(String a_id);    //存取存款记录
	public ArrayList selectTimeDepositByAid(String a_id); //获取定期存款记录
	public boolean changeTimeDepositStatement(Deposits deposit); //定期存款取出后，把状态改为withdraw,标志已经取出了
}
