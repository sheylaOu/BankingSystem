package db_dao;

import java.util.ArrayList;

import db_vo.Withdraws;

public interface WithdrawsDAO {
	public boolean addWithdraw(Withdraws wd) throws Exception;
	public ArrayList selectWithdrawsByA_id(String a_id) throws Exception;

}
