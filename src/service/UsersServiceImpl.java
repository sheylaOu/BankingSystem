package service;

import db_dao.UsersDAO;
import db_dao.UsersDaoImpl;
import db_vo.Users;

public class UsersServiceImpl implements UsersService{
	Users user = new Users();
	UsersDAO ud = new UsersDaoImpl();

	public String login(String u_id, String pwd) {
		String reply = "";
		try {
			user = ud.userDetails(u_id);
			if (user == null) {
				reply = "User does not exist.";
			} else {
				if (user.getStatement().equals("lock")) {
					reply = "User is locked.";
				}else {
					if (!user.getLogin_pwd().equals(pwd)) {
						reply = "Invalid password.";
					} else {
						reply = "Login succeed.";
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reply;

	}

	public boolean lock(String u_id) {
		try {
			return ud.updateStatement(u_id, "lock");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public String showQuestion(String u_id){
		try {
			return ud.selectQuestion(u_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "exception";
		}
	}
	
	public boolean matchAnswer(String u_id,String answer){
		try {
			if(answer.equals(ud.selectAnswer(u_id))){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean retsetPwd(String u_id,String loginpwd){
		try {
			return ud.updateLoginpwd(u_id, loginpwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean u_idExistOrNot(String u_id){
		try {
			user=ud.userDetails(u_id);
			if(user==null){
				return false;
			}
			else{
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
	}
	public boolean usernameExistOrNot(String name){
		try {
			return ud.selectUsername(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
	}
	
	public boolean register(Users user){
		try {
			return ud.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public String getEmail(String u_id){
		try {
			return ud.selectEmail(u_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No emain.";
		}
	}
	
	public String getRealname(String u_id){
		try {
			return ud.selectRealname(u_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No realname.";
		}
	}
}
