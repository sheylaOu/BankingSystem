package db_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;











import db_vo.Accounts;

public class AccountsDAOImpl implements AccountsDAO {

	@Override
	public ArrayList selectByU_id(String u_id) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Accounts> result=new ArrayList<Accounts>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from accounts where u_id='"+u_id+"'");
			while(rs.next()){
				Accounts ac=new Accounts();
				ac.setA_id(rs.getString("a_id"));
				ac.setBind_date(rs.getString("bind_date"));
				ac.setTrans_pwd(rs.getString("trans_pwd"));
				ac.setU_id(u_id);
				result.add(ac);			
			}
	}catch (SQLException e) {
		throw new Exception("select accounts by u_id exception:" + e.getMessage());
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
	public Accounts accountDetail(String a_id) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from accounts where a_id='"+a_id+"'");
			Accounts ac=new Accounts();
			if (rs.next()) {
				ac.setA_id(rs.getString("a_id"));
				ac.setBind_date(rs.getString("bind_date"));
				ac.setTrans_pwd(rs.getString("trans_pwd"));
				ac.setU_id(rs.getString("u_id"));
			}
			return ac;
		}catch (SQLException e) {
			throw new Exception("select account by a_id exception:" +e.getMessage());
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
	
	public String selectTranspwd(String a_id) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql="select trans_pwd from accounts where a_id='"+a_id+"'";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			String transPwd="";
			if (rs.next()) {
				transPwd=rs.getString("trnas_pwd");
			}
			return transPwd;
		} catch (SQLException e) {
			throw new Exception("select trans_pwd exception:" + e.getMessage());
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
		
	}
	public boolean updateTransPwd(String a_id,String transpwd) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql="update accounts set trans_pwd='"+transpwd+"' where a_id='"+a_id+"'";
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
			throw new Exception("update trans_pwd_pwd exception:" + e.getMessage());
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
	public boolean addAccount(Accounts ac) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into accounts(a_id,bind_date,trans_pwd,u_id) values('"
				+ac.getA_id()+"','"
				+ac.getBind_date()+"','"
				+ac.getTrans_pwd()+"','"
				+ac.getU_id()+"')";
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
			throw new Exception("insert account exception:" + e.getMessage());
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
	
	public String selectUidByAid(String a_id) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql="select u_id from accounts where a_id='"+a_id+"'";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			String u_id="";
			if (rs.next()) {
				u_id=rs.getString("u_id");
			}
			return u_id;
		} catch (SQLException e) {
			throw new Exception("select u_id exception:" + e.getMessage());
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
	}

}
