package service;

import java.util.ArrayList;

import db_dao.DepositsDAO;
import db_dao.DepositsDAOImpl;
import db_vo.Deposits;

public class DepositsServiceImpl implements DepositsService {
	Deposits dep=new Deposits();
	DepositsDAO depd=new DepositsDAOImpl();

	@Override
	public boolean deposit(Deposits deposit) {
		// TODO Auto-generated method stub
		AccountCurrencyService accs=new AccountCurrencyServiceImpl();
		if(accs.addBalance(deposit.getA_id(), deposit.getCurrency(), deposit.getAmount(),deposit.getType())){
			try {
				return depd.addDeposit(deposit);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else{
			return false;
		}
	}

	@Override
	public ArrayList checkDepositsRecord(String a_id) {
		// TODO Auto-generated method stub
		ArrayList<Deposits> depList=new ArrayList<Deposits>();
		try {
			depList=depd.selectAllDepositsByAid(a_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return depList;
	}
	
	public ArrayList selectTimeDepositByAid(String a_id){
		ArrayList<Deposits> depList=new ArrayList<Deposits>();
		try {
			depList=depd.selectTimeDepositByAid(a_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return depList;
	}
	
	public boolean changeTimeDepositStatement(Deposits deposit){
		try {
			return depd.updateTimeDepositStatement(deposit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
