package db_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db_vo.Deposits;
import db_vo.Transfer;

public class TransferDAOImpl implements TransferDAO {

	@Override
	public boolean addTranfer(Transfer tran) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into transfer(a_id_out,a_id_in,amount,currency,"
				+ "memo,transfer_time) values('"
				+tran.getA_id_out()+"','"
				+tran.getA_id_in()+"','"
				+tran.getAmount()+"','"
				+tran.getCurrency()+"','"
				+tran.getMemo()+"','"
				+tran.getTransfer_time()+"')";
		//System.out.println(sql);
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
			throw new Exception("insert transfer record exception:" + e.getMessage());
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
	public ArrayList selectTransferByA_id_in(String a_id) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Transfer> result=new ArrayList<Transfer>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from transfer where a_id_in='"+a_id+"'");
			while(rs.next()){
				Transfer tran=new Transfer();
				tran.setA_id_in(a_id);
				tran.setA_id_out(rs.getString("a_id_out"));
				tran.setAmount(rs.getDouble("amount"));
				tran.setCurrency(rs.getString("currency"));
				tran.setMemo(rs.getString("memo"));
				tran.setTransfer_time(rs.getString("transfer_time"));
				result.add(tran);			
			}
	}catch (SQLException e) {
		throw new Exception("select transfer by a_id_in exception:" + e.getMessage());
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
	
	public ArrayList selectTransferByA_id_out (String a_id) throws Exception{
		ArrayList<Transfer> result=new ArrayList<Transfer>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from transfer where a_id_out='"+a_id+"'");
			while(rs.next()){
				Transfer tran=new Transfer();
				tran.setA_id_out(a_id);
				tran.setA_id_in(rs.getString("a_id_in"));
				tran.setAmount(rs.getDouble("amount"));
				tran.setCurrency(rs.getString("currency"));
				tran.setMemo(rs.getString("memo"));
				tran.setTransfer_time(rs.getString("transfer_time"));
				result.add(tran);			
			}
	}catch (SQLException e) {
		throw new Exception("select transfer by a_id_out exception:" + e.getMessage());
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
