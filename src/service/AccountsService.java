package service;

import java.util.ArrayList;

import db_vo.Accounts;

public interface AccountsService {
	public ArrayList bindingAccounts(String u_id); //ѡ������û��󶨵������˺���Ϣ
	public Accounts accountDetail(String a_id);    //�˻���ϸ��Ϣ
	public boolean resetTransPwd(String a_id,String pwd); //���ý�������
	public boolean openAccount(Accounts ac);        //�������û�
	public String getOwerName(String a_id);         //��ȡ�˺�����������
	
}
