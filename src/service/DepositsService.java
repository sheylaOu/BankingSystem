package service;

import java.util.ArrayList;

import db_vo.Deposits;

public interface DepositsService {
	public boolean deposit(Deposits deposit);         //���
	public ArrayList checkDepositsRecord(String a_id);    //��ȡ����¼
	public ArrayList selectTimeDepositByAid(String a_id); //��ȡ���ڴ���¼
	public boolean changeTimeDepositStatement(Deposits deposit); //���ڴ��ȡ���󣬰�״̬��Ϊwithdraw,��־�Ѿ�ȡ����
}
