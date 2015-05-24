package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import db_dao.WithdrawsDAO;
import db_dao.WithdrawsDAOImpl;
import db_vo.Deposits;
import db_vo.Transfer;
import db_vo.Withdraws;

public class WithdrawsServiceImpl implements WithdrawsService {
	Withdraws wd = new Withdraws();
	WithdrawsDAO wdd = new WithdrawsDAOImpl();
	AccountCurrencyService accs = new AccountCurrencyServiceImpl();
	DepositsService deps=new DepositsServiceImpl();

	@Override
	public boolean TimeDepositWithdraw(Deposits dep) {
		// TODO Auto-generated method stub
		try {
			if (accs.subtractBalance(dep.getA_id(), dep.getCurrency(),
					dep.getAmount(),"time")&&deps.changeTimeDepositStatement(dep)) {
				wd.setA_id(dep.getA_id());
				wd.setAmount((int)dep.getAmount());
				wd.setCurrency(dep.getCurrency());
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				wd.setDraw_time(df.format(new Date()));
				return wdd.addWithdraw(wd);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    }
		return false;
	}

	@Override
	public boolean CurrentDepositWithdraw(String a_id, String currency,
			int amount) {
		// TODO Auto-generated method stub
		if (accs.subtractBalance(a_id, currency, amount,"current")){
			wd.setA_id(a_id);
			wd.setAmount(amount);
			wd.setCurrency(currency);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			wd.setDraw_time(df.format(new Date()));
			try {
				return wdd.addWithdraw(wd);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public ArrayList CheckWithdrawRecordByAid(String a_id) {
		// TODO Auto-generated method stub
		ArrayList<Withdraws> drawList=new ArrayList<Withdraws>();
		try {
			drawList=wdd.selectWithdrawsByA_id(a_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drawList;
	}

}
