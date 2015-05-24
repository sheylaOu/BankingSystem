package db_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db_vo.Deposits;
import db_vo.Withdraws;

public class WithdrawsDAOImpl implements WithdrawsDAO {

	@Override
	public boolean addWithdraw(Withdraws wd) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into withdraws(a_id,amount,currency,draw_time) values('"
				+wd.getA_id()+"','"
				+wd.getAmount()+"','"
				+wd.getCurrency()+"','"
				+wd.getDraw_time()+"')";
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
			throw new Exception("insert withdraw record exception:" + e.getMessage());
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
	public ArrayList selectWithdrawsByA_id(String a_id) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Withdraws> result=new ArrayList<Withdraws>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from withdraws where a_id='"+a_id+"'");
			while(rs.next()){
				Withdraws wd=new Withdraws();
				wd.setA_id(a_id);
				wd.setAmount(rs.getInt("amount"));
				wd.setCurrency(rs.getString("currency"));
				wd.setDraw_time(rs.getString("draw_time"));
				result.add(wd);			
			}
	}catch (SQLException e) {
		throw new Exception("select withdraws by a_id exception:" + e.getMessage());
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

}
