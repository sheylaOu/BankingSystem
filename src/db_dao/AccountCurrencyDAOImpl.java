package db_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




import db_vo.Account_currency;
import db_vo.Accounts;

public class AccountCurrencyDAOImpl implements AccountCurrencyDAO {

	@Override
	public ArrayList selectAccountCurrencyByAid(String a_id) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Account_currency> result=new ArrayList<Account_currency>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from account_currency where a_id='"+a_id+"'");
			while(rs.next()){
				Account_currency ac_c=new Account_currency();
				ac_c.setA_id(a_id);
				ac_c.setCurrency(rs.getString("currency"));
				ac_c.setBalance(Double.parseDouble(rs.getString("balance")));
				ac_c.setType(rs.getString("type"));
				result.add(ac_c);			
			}
	}catch (SQLException e) {
		throw new Exception("select account_currency by a_id exception:" + e.getMessage());
	}finally{
		try{
			if(rs!=null){
				rs.close();
			}
		}catch(Exception e){
			throw new Exception("rs close exception:"+e.getMessage());
		}
		try{
			if(stmt !=null){
				stmt.close();
			}
		}catch(Exception e){
			throw new Exception("stmt close exception:"+e.getMessage());
		}
		try{
			if(conn !=null){
				conn.close();
			}
		}catch(Exception e){
			throw new Exception("conn close exception:"+e.getMessage());
		}
	}
	return result;
	}

	@Override
	public double selectCurrentBalance(String a_id,String currency) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select balance from account_currency where a_id='"+a_id+
					"' and currency='"+currency+"' and type='current'");
			double balance=0;
			if (rs.next()) {
				balance=Double.parseDouble(rs.getString("balance"));
			}
			return balance;
		}catch (SQLException e) {
			throw new Exception("select balance by a_id and currency exception:" +e.getMessage());
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
			}catch(Exception e){
				throw new Exception("rs close exception:"+e.getMessage());
			}
			try{
				if(stmt !=null){
					stmt.close();
				}
			}catch(Exception e){
				throw new Exception("stmt close exception:"+e.getMessage());
			}
			try{
				if(conn !=null){
					conn.close();
				}
			}catch(Exception e){
				throw new Exception("conn close exception:"+e.getMessage());
			}
		}
	}
	@Override
	public double selectTimeBalance(String a_id,String currency) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select balance from account_currency where a_id='"+a_id+
					"' and currency='"+currency+"' and type='time'");
			double balance=0;
			if (rs.next()) {
				balance=Double.parseDouble(rs.getString("balance"));
			}
			return balance;
		}catch (SQLException e) {
			throw new Exception("select balance by a_id and currency exception:" +e.getMessage());
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
			}catch(Exception e){
				throw new Exception("rs close exception:"+e.getMessage());
			}
			try{
				if(stmt !=null){
					stmt.close();
				}
			}catch(Exception e){
				throw new Exception("stmt close exception:"+e.getMessage());
			}
			try{
				if(conn !=null){
					conn.close();
				}
			}catch(Exception e){
				throw new Exception("conn close exception:"+e.getMessage());
			}
		}
	}
	@Override
	public boolean addAccountCurrency(Account_currency ac_c) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into account_currency(a_id,balance,currency,type) values('"
				+ac_c.getA_id()+"','"
				+ac_c.getBalance()+"','"
				+ac_c.getCurrency()+"','"
				+ac_c.getType()+"')";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			int col = ps.executeUpdate();
			if (col > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new Exception("insert account_currency exception:" + e.getMessage());
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				throw new Exception("ps close exception:" + e.getMessage());
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new Exception("conn close exception:" + e.getMessage());
			}
		}
	}


	@Override
	public boolean updateBalance(String a_id, String currency, double balance,String type)
			throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql="update account_currency set balance='"+balance+"' where a_id='"+a_id
				+"' and currency='"+currency+"' and type='"+type+"'";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			int col = ps.executeUpdate();
			if (col > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new Exception("update balance exception:" + e.getMessage());
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				throw new Exception("ps close exception:" + e.getMessage());
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new Exception("conn close exception:" + e.getMessage());
			}
		}
	}
	
	public boolean delectAccountCurrency(String a_id,String currency,String type) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			int cols= stmt.executeUpdate("delete from account_currency where a_id='"+a_id+"' and currency='"
			+currency+"' and type='"+type+"';");
			if(cols>0){
				return true;
			}
			else
				return false;
		} catch (SQLException e) {
			throw new Exception("delete account_currency exception:" + e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				throw new Exception("stmt close exception:" + e.getMessage());
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new Exception("conn close exception:" + e.getMessage());
			}
		}
		
	}

}
