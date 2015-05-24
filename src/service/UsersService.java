package service;

import db_vo.Users;

public interface UsersService {
	public String login(String u_id, String pwd);    //��½
	public boolean lock(String u_id);                //����������󶳽��û�
	public String showQuestion(String u_id);         //��������ʱ����ʾע��ʱ��ѡ���ܱ�����
	public boolean matchAnswer(String u_id,String answer);//ƥ���
	public boolean retsetPwd(String u_id,String loginpwd); //���õ�½����
	public boolean u_idExistOrNot(String u_id);            //ע��ǰ���ж�ID�Ƿ�ע���
	public boolean usernameExistOrNot(String name);        //�ж��û����Ƿ�ע���
	public boolean register(Users user);                  //ע�����û�
	public String getEmail(String u_id);              //ͨ���ʼ��һ�����
	public String getRealname(String u_id);          //��ȡ�û�����
}
