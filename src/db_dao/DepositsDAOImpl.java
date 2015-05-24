package db_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db_vo.Accounts;
import db_vo.Deposits;

public class DepositsDAOImpl implements DepositsDAO {

	@Override
	public boolean addDeposit(Deposits deposit) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql="";
		if (deposit.getType().equals("time")) {
		    sql = "insert into deposits(a_id,amount,currency,deposit_time,interest,period,type,statement) values('"
					+ deposit.getA_id()
					+ "','"
					+ deposit.getAmount()
					+ "','"
					+ deposit.getCurrency()
					+ "','"
					+ deposit.getDeposit_time()
					+ "','"
					+ deposit.getInterest()
					+ "','"
					+ deposit.getPeriod()
					+ "','"
					+ deposit.getType()
					+ "','deposit')";
		} else {
			sql = "insert into deposits(a_id,amount,currency,deposit_time,interest,period,type) values('"
					+ deposit.getA_id()
					+ "','"
					+ deposit.getAmount()
					+ "','"
					+ deposit.getCurrency()
					+ "','"
					+ deposit.getDeposit_time()
					+ "','"
					+ deposit.getInterest()
					+ "','"
					+ deposit.getPeriod() + "','" + deposit.getType() + "')";
		}
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
			throw new Exception("insert deposit record exception:"
					+ e.getMessage());
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
	public ArrayList selectAllDepositsByAid(String a_id) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Deposits> result = new ArrayList<Deposits>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from deposits where a_id='" + a_id
					+ "'");
			while (rs.next()) {
				Deposits deposit = new Deposits();
				deposit.setA_id(rs.getString("a_id"));
				deposit.setAmount(rs.getDouble("amount"));
				deposit.setCurrency(rs.getString("currency"));
				deposit.setDeposit_time(rs.getString("deposit_time"));
				deposit.setInterest(rs.getDouble("interest"));
				deposit.setPeriod(rs.getString("period"));
				deposit.setType(rs.getString("type"));
				deposit.setStatement(rs.getString("statement"));
				result.add(deposit);
			}
		} catch (SQLException e) {
			throw new Exception("select deposits by a_id exception:"
					+ e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				throw new Exception("rs close exception:" + e.getMessage());
			}
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
		return result;
	}

	public ArrayList selectTimeDepositByAid(String a_id) throws Exception {
		ArrayList<Deposits> result = new ArrayList<Deposits>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from deposits where a_id='" + a_id
					+ "' and type='time'");
			while (rs.next()) {
				Deposits deposit = new Deposits();
				deposit.setA_id(rs.getString("a_id"));
				deposit.setAmount(rs.getDouble("amount"));
				deposit.setCurrency(rs.getString("currency"));
				deposit.setDeposit_time(rs.getString("deposit_time"));
				deposit.setInterest(rs.getDouble("interest"));
				deposit.setPeriod(rs.getString("period"));
				deposit.setType(rs.getString("type"));
				deposit.setStatement(rs.getString("statement"));
				result.add(deposit);
			}
		} catch (SQLException e) {
			throw new Exception("select deposits by a_id exception:"
					+ e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				throw new Exception("rs close exception:" + e.getMessage());
			}
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
		return result;
	}
	public boolean updateTimeDepositStatement(Deposits deposit) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql="update deposits set statement='withdraw' where a_id='"+deposit.getA_id()
				+"' and deposit_time='"+deposit.getDeposit_time()+"'";
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
			throw new Exception("update statement exception:" + e.getMessage());
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

}
