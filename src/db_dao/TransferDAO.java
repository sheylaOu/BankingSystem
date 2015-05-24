package db_dao;

import java.util.ArrayList;

import db_vo.Transfer;

public interface TransferDAO {
	public boolean addTranfer(Transfer tran) throws Exception;
	public ArrayList selectTransferByA_id_out (String a_id) throws Exception;
	public ArrayList selectTransferByA_id_in (String a_id) throws Exception;
	
}
