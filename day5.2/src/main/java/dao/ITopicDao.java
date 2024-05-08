package dao;
import java.sql.SQLException;
import java.util.List;

public interface ITopicDao {
	List<String> getAllTopicNames() throws SQLException;
}
