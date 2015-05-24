package service;

import db_vo.Users;

public interface UsersService {
	public String login(String u_id, String pwd);    //登陆
	public boolean lock(String u_id);                //三次密码错误冻结用户
	public String showQuestion(String u_id);         //忘记密码时，显示注册时所选的密保问题
	public boolean matchAnswer(String u_id,String answer);//匹配答案
	public boolean retsetPwd(String u_id,String loginpwd); //重置登陆密码
	public boolean u_idExistOrNot(String u_id);            //注册前先判断ID是否注册过
	public boolean usernameExistOrNot(String name);        //判断用户名是否注册过
	public boolean register(Users user);                  //注册新用户
	public String getEmail(String u_id);              //通过邮件找回密码
	public String getRealname(String u_id);          //获取用户真名
}
