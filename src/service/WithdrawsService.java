package service;

import java.util.ArrayList;

import db_vo.Deposits;
import db_vo.Withdraws;

public interface WithdrawsService {
	public boolean TimeDepositWithdraw(Deposits dep);   //ȫ��ȡһ�ʶ��ڴ��
	public boolean CurrentDepositWithdraw(String a_id,String currency,int amount);//�ӻ��ڴ����ȡǮ
	public ArrayList CheckWithdrawRecordByAid(String a_id); //��ȡȡ���¼

}
