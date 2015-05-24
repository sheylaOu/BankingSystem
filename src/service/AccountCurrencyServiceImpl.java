package service;

import java.util.ArrayList;

import db_dao.AccountCurrencyDAO;
import db_dao.AccountCurrencyDAOImpl;
import db_vo.Account_currency;

public class AccountCurrencyServiceImpl implements AccountCurrencyService {
	Account_currency ac_c = new Account_currency();
	AccountCurrencyDAO ac_cd = new AccountCurrencyDAOImpl();

	@Override
	public ArrayList checkBalance(String a_id) {
		// TODO Auto-generated method stub
		ArrayList<Account_currency> accList = new ArrayList<Account_currency>();
		try {
			accList = ac_cd.selectAccountCurrencyByAid(a_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accList;
	}

	@Override
	public boolean addBalance(String a_id, String currency, double add,String type) {
		// TODO Auto-generated method stub
		double oldBalance;
		double newBalance;
		try {
			if(type.equals("current")){
			oldBalance = ac_cd.selectCurrentBalance(a_id, currency);
			}else{
			 oldBalance = ac_cd.selectTimeBalance(a_id, currency);
			}
			if (oldBalance == 0) {
				ac_c.setCurrency(currency);
				ac_c.setA_id(a_id);
				ac_c.setBalance(add);
				ac_c.setType(type);
				return ac_cd.addAccountCurrency(ac_c);
			}else{
				newBalance=oldBalance+add;
				return ac_cd.updateBalance(a_id, currency, newBalance,type);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean subtractBalance(String a_id, String currency, double sub,String type) {
		// TODO Auto-generated method stub
		double oldBalance;
		double newBalance;
		try {
			if(type.equals("current")){
			oldBalance = ac_cd.selectCurrentBalance(a_id, currency);
			}else{
			 oldBalance = ac_cd.selectTimeBalance(a_id, currency);
			}
			newBalance=oldBalance-sub;
			if(newBalance==0){
				return ac_cd.delectAccountCurrency(a_id, currency,type);
			}else{
				return ac_cd.updateBalance(a_id, currency, newBalance,type);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

}
