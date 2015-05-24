package db_dao;

import java.util.ArrayList;

import db_vo.Account_currency;

public interface AccountCurrencyDAO {
	public ArrayList selectAccountCurrencyByAid(String A_id) throws Exception;
	public double selectCurrentBalance(String a_id,String currency) throws Exception;
	public double selectTimeBalance(String a_id,String currency) throws Exception;
	public boolean addAccountCurrency(Account_currency ac_c) throws Exception;
	public boolean updateBalance(String a_id,String currency,double balance,String type) 
			throws Exception;
	public boolean delectAccountCurrency(String a_id,String currency,String type) throws Exception;
	
	
}
