package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Tutorial;

public interface ITutorialDao {

	// add a method to ret list of tut names for a choosen topic
	List<String> getAllTutorialsByTopic(String topicName) throws SQLException;
	//add a method to return selected tutorial details
	Tutorial getTutorialDetails(String tutName) throws SQLException;
	//add a method to update visit count
	String updateVisits(String tutName) throws SQLException; 
	
	
}
