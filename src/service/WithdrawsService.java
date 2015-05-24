package service;

import java.util.ArrayList;

import db_vo.Deposits;
import db_vo.Withdraws;

public interface WithdrawsService {
	public boolean TimeDepositWithdraw(Deposits dep);   //全额取一笔定期存款
	public boolean CurrentDepositWithdraw(String a_id,String currency,int amount);//从活期存款里取钱
	public ArrayList CheckWithdrawRecordByAid(String a_id); //获取取款记录

}
