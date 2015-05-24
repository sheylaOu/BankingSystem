package service;

import java.util.ArrayList;

import db_vo.Transfer;

public interface TransferService {
	public boolean transfer(Transfer tran);  //转账
	public ArrayList<Transfer> checkTransferRecordRecord(String a_id); //获取转账记录
}
