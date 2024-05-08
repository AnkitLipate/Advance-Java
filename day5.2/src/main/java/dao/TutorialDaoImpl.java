package dao;

import static utils.DBUtils.fetchDBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Tutorial;

public class TutorialDaoImpl implements ITutorialDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3;

	public TutorialDaoImpl() throws ClassNotFoundException, SQLException {
		// get cn
		cn = fetchDBConnection();
		// pst1
		pst1 = cn.prepareStatement(
				"select t1.name from tutorials t1 inner join topics t2 on t1.topic_id=t2.id where t2.name=?");
		// pst2 : get tut details by it's name
		pst2 = cn.prepareStatement("select * from tutorials where name=?");
		// pst3 : update visits
		pst3 = cn.prepareStatement("update tutorials set visits=visits+1 where name=?");
		System.out.println("tut dao created....");
	}

	@Override
	public List<String> getAllTutorialsByTopic(String topicName) throws SQLException {
		List<String> tutNames = new ArrayList<>();
		// set IN param : topic name
		pst1.setString(1, topicName);
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				tutNames.add(rst.getString(1));
		}
		return tutNames;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		System.out.println("tut dao cleaned up");
	}

	@Override
	public Tutorial getTutorialDetails(String tutName) throws SQLException {
		// set In Param : tut name
		pst2.setString(1, tutName);
		try (ResultSet rst = pst2.executeQuery()) {
			if (rst.next())
				// int tutorialId, String tutorialName, String author, Date publishDate, int
				// visits, int topicId
				return new Tutorial(rst.getInt(1), tutName, rst.getString(3), rst.getDate(4), rst.getInt(5),
						rst.getInt(6));
		}
		return null;
	}

	@Override
	public String updateVisits(String tutName) throws SQLException {
		// set In Param 
		pst3.setString(1,tutName);
		int updateCount = pst3.executeUpdate();
		if(updateCount ==1)
			return "Visits Updated";
		return "Visits updation failed....";
	}
}
