package dao;

import static utils.DBUtils.fetchDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class TopicDaoImpl implements ITopicDao {
	private Connection cn;
	private PreparedStatement pst1;
	
	public TopicDaoImpl() throws ClassNotFoundException, SQLException{
		//get Singlton cn instance from DBUtils
		cn = fetchDBConnection();
		pst1 = cn.prepareStatement("select name from topics");
		System.out.println("topic dao created....");
	}
	@Override
	public List<String> getAllTutuorialsByTopic(String topicName) throws SQLException {
		List<String> topicNames = new ArrayList<String>();
		try(ResultSet rst = pst1.executeQuery()){
			while(rst.next())
				topicNames.add(rst.getString(1));
		}
		return topicNames;
	}

}
