package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pojos.Tutorial;

class TutorialDaoImplTest {
	private TutorialDaoImpl dao;
	
	@BeforeEach
	void setUp() throws Exception {
		dao = new TutorialDaoImpl();
	}
	@AfterEach 
	void cleanUp() throws Exception
	{
		dao.cleanUp();
	}

	@Test
	void testGetAllTutorialsByTopic() throws Exception {
		List<String> allTutorialsByTopic = dao.getAllTutorialsByTopic("Spring Framework");
		System.out.println(allTutorialsByTopic);
		assertEquals(true, allTutorialsByTopic.contains("Spring MVC"));
	}
	
	@Test
	void testGetTutorialDetails()throws Exception{
		Tutorial tutorialDetails = dao.getTutorialDetails("Spring Boot");
		System.out.println(tutorialDetails);
		assertEquals("Mihir", tutorialDetails.getAuthor());
	}
	@Test
	void testupdateVisits() throws Exception
	{
		String updateVisits = dao.updateVisits("Spring Boot");
		assertEquals("Visits updated", updateVisits);
	}

}
