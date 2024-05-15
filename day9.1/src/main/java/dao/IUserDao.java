 package dao;

import pojos.User; 
 
public interface IUserDao {
	String registerUser(User user);//open session
	String registerUserWithGetCurrentSession(User user);//get current session
	
	//add method to fetch user details from the supplied user id 
	User getUserDetails(int userId);
}
