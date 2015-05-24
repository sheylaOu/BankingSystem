package db_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




import db_vo.Users;

public class UsersDaoImpl implements UsersDAO {

	@Override
	public Users userDetails(String u_id) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql="select * from users where u_id='"+u_id+"'";
		Users user = new Users();
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				user.setU_id(u_id);
				user.setUsername(rs.getString("username"));
				user.setLogin_pwd(rs.getString("login_pwd"));
				user.setEmail(rs.getString("email"));
				user.setQuestion(rs.getString("question"));
				user.setAnswer(rs.getString("answer"));
				user.setRealname(rs.getString("realname"));
				user.setStatement(rs.getString("statement"));
			}else{
				user=null;
			}
			return user;
		} catch (SQLException e) {
			throw new Exception("select user details exception:" + e.getMessage());
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

	@Override
	public boolean updateStatement(String u_id,String statement) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql="update users set statement='"+statement+"' where u_id='"+u_id+"'";
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

	@Override
	public boolean updateLoginpwd(String u_id,String loginpwd) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql="update users set login_pwd='"+loginpwd+"' where u_id='"+u_id+"'";
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
			throw new Exception("update login_pwd exception:" + e.getMessage());
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
	
	public String selectQuestion(String u_id) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql="select question from users where u_id='"+u_id+"'";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			String question="";
			if (rs.next()) {
				question=rs.getString("question");
			}
			return question;
		} catch (SQLException e) {
			throw new Exception("select question details exception:" + e.getMessage());
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
	
	public String selectAnswer(String u_id) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql="select answer from users where u_id='"+u_id+"'";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			String answer="";
			if (rs.next()) {
				answer=rs.getString("answer");
			}
			return answer;
		} catch (SQLException e) {
			throw new Exception("select answer details exception:" + e.getMessage());
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
	
	public boolean addUser(Users user) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into users(u_id,username,realname,question,answer,email,login_pwd,statement) values('"
				+ user.getU_id()
				+ "','"
				+ user.getUsername()
				+ "','"
				+user.getRealname()
				+"','"
				+ user.getQuestion()
				+ "','"
				+ user.getAnswer()
				+ "','"
				+ user.getEmail()
				+ "','"
				+ user.getLogin_pwd()
				+ "','"
				+ user.getStatement() + "')";
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
			throw new Exception("insert user exception:" + e.getMessage());
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
	
	public boolean selectUsername(String name) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql="select * from users where username='"+name+"'";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return false;
			}
			return false;
		} catch (SQLException e) {
			throw new Exception("select user by username exception:" + e.getMessage());
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
	public String selectRealname(String u_id) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql="select realname from users where u_id='"+u_id+"'";
		String realname="";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				realname=rs.getString("realname");
			}
			return realname;
		} catch (SQLException e) {
			throw new Exception("select user by realname exception:" + e.getMessage());
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
	
	public String selectEmail(String u_id) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql="select email from users where u_id='"+u_id+"'";
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			String email="";
			if (rs.next()) {
				email=rs.getString("email");
			}
			return email;
		} catch (SQLException e) {
			throw new Exception("select email exception:" + e.getMessage());
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
