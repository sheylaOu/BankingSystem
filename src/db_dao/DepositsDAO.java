package db_dao;

import java.util.ArrayList;

import db_vo.Deposits;

public interface DepositsDAO {
	public boolean addDeposit(Deposits deposit) throws Exception;
	public ArrayList selectAllDepositsByAid(String a_id) throws Exception;
	public ArrayList selectTimeDepositByAid(String a_id) throws Exception;
	public boolean updateTimeDepositStatement(Deposits deposit) throws Exception;

}
