package db_dao;

import db_vo.Users;

public interface UsersDAO {
	public Users userDetails(String u_id) throws Exception;
	public boolean updateStatement(String u_id,String statement) throws Exception;
	public boolean updateLoginpwd(String u_id,String loginpwd) throws Exception;
	public String selectQuestion(String u_id) throws Exception;
	public String selectAnswer(String u_id) throws Exception;
	public boolean addUser(Users user) throws Exception;
	public boolean selectUsername(String name) throws Exception;
	public String selectEmail(String u_id) throws Exception;
	public String selectRealname(String a_id) throws Exception;
}
