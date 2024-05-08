package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTopicDaoImpl {
	private TopicDaoImpl topicDao;
	
	@BeforeEach
	void setUp() throws Exception {
		topicDao = new TopicDaoImpl(); 
	}

	@Test
	void testGetAllTopicNames() throws Exception {
		List<String> allTopicNames = topicDao.getAllTopicNames();
		assertEquals(4,allTopicNames.size());
		topicDao.cleanUp();
	}

}
