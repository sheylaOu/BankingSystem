package service;

import java.util.ArrayList;

import db_dao.TransferDAO;
import db_dao.TransferDAOImpl;
import db_vo.Deposits;
import db_vo.Transfer;

public class TransferServiceImpl implements TransferService {
	Transfer tran=new Transfer();
	TransferDAO trand=new TransferDAOImpl();

	@Override
	public boolean transfer(Transfer tran) {
		// TODO Auto-generated method stub
		try {
			AccountCurrencyService accs=new AccountCurrencyServiceImpl();
			if(accs.addBalance(tran.getA_id_in(), tran.getCurrency(), tran.getAmount(),"current")
					&&accs.subtractBalance(tran.getA_id_out(), tran.getCurrency(), tran.getAmount(),"current")){
				return trand.addTranfer(tran);
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<Transfer> checkTransferRecordRecord(String a_id) {
		// TODO Auto-generated method stub
		ArrayList<Transfer> tranList=new ArrayList<Transfer>();
		try {
			ArrayList<Transfer> tranInList=trand.selectTransferByA_id_in(a_id);
			java.util.Iterator<Transfer> it=tranInList.iterator();
			while(it.hasNext()){
				tran=it.next();
				tranList.add(tran);
			}
			ArrayList<Transfer> tranOutList=trand.selectTransferByA_id_out(a_id);
			java.util.Iterator<Transfer> it2=tranOutList.iterator();
			while(it2.hasNext()){
				tran=it2.next();
				tranList.add(tran);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tranList;
	}

}
