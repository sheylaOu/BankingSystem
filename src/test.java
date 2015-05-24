

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.text.html.HTMLDocument.Iterator;

import db_vo.Account_currency;
import db_vo.Accounts;
import db_vo.Deposits;
import db_vo.Transfer;
import db_vo.Users;
import service.AccountCurrencyService;
import service.AccountCurrencyServiceImpl;
import service.AccountsService;
import service.AccountsServiceImpl;
import service.DepositsService;
import service.DepositsServiceImpl;
import service.MD5;
import service.TransferService;
import service.TransferServiceImpl;
import service.UsersServiceImpl;
import service.WithdrawsService;
import service.WithdrawsServiceImpl;

public class test {

	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		df.format(new Date());

//		WithdrawsService wds=new WithdrawsServiceImpl();
//		Deposits dep=new Deposits();
//		dep.setA_id("1");
//		dep.setAmount(1000);
//		dep.setCurrency("CNY");
//		dep.setDeposit_time("2015-05-05 17:26:03");
//		dep.setInterest(0.78);
//		dep.setPeriod("6 months");
//		dep.setStatement("deposit");
//		dep.setType("time");
//		//System.out.println(wds.TimeDepositWithdraw(dep))
//		//System.out.println(wds.CurrentDepositWithdraw("2", "CNY", 200));
//		wds.CheckWithdrawRecordByAid("2");
		
		TransferService trans=new TransferServiceImpl();
		Transfer tran=new Transfer();
		tran.setA_id_in("2");
		tran.setA_id_out("3");
		tran.setAmount(100);
		tran.setCurrency("CNY");
		tran.setTransfer_time(df.format(new Date()));
		tran.setMemo("huaiqian");
		
		System.out.println(trans.transfer(tran));
	}
}
