package service;

import java.util.ArrayList;

import db_vo.Transfer;

public interface TransferService {
	public boolean transfer(Transfer tran);  //ת��
	public ArrayList<Transfer> checkTransferRecordRecord(String a_id); //��ȡת�˼�¼
}
