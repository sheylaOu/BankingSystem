package service;

import java.util.ArrayList;

import db_vo.Account_currency;

public interface AccountCurrencyService {
	public ArrayList checkBalance(String a_id);                   //���˻������б��ֵĴ��
	public boolean addBalance(String a_id,String currency,double add,String type);    //���ʱ�����жϱ����Ƿ��Ѵ��ڣ�������balance�ϼ��Ͻ������½�һ��account_currency
	public boolean subtractBalance(String a_id,String currency, double sub,String type); //ȡ���ת��ʱ����balance�ϼ�ȥ����������Ϊ0����ɾ�����account_currency

}
