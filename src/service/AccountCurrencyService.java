package service;

import java.util.ArrayList;

import db_vo.Account_currency;

public interface AccountCurrencyService {
	public ArrayList checkBalance(String a_id);                   //该账户中所有币种的存款
	public boolean addBalance(String a_id,String currency,double add,String type);    //存款时，先判断币种是否已存在，若存在balance上加上金额，否则新建一个account_currency
	public boolean subtractBalance(String a_id,String currency, double sub,String type); //取款或转账时，在balance上减去金额，减完后余额为0，就删除这个account_currency

}
