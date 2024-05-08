package pojos;
import java.sql.Date;
public class Tutorial {
//tut_id | name        | author | publish_date | visit | topic_id
	private int tutorialId;//PK
	private String tutorialName;
	private String author;
	private Date publishDate;
	private int visits;
	private int topicId;//FK---> PK of topic table (topicId)
	
	public Tutorial(int tutorialId, String tutorialName, String author, Date publishDate, int visits, int topicId) {
		super();
		this.tutorialId = tutorialId;
		this.tutorialName = tutorialName;
		this.author = author;
		this.publishDate = publishDate;
		this.visits = visits;
		this.topicId = topicId;
	} 
	public Tutorial() {
		// TODO Auto-generated constructor stub
	}
	public int getTutorialId() {
		return tutorialId;
	}
	public void setTutorialId(int tutorialId) {
		this.tutorialId = tutorialId;
	}
	public String getTutorialName() {
		return tutorialName;
	}
	public void setTutorialName(String tutorialName) {
		this.tutorialName = tutorialName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
	public int getTopicId() {
		return topicId;
	}
	
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	@Override
	public String toString() {
		return "Tutorial [tutorialId=" + tutorialId + ", tutorialName=" + tutorialName + ", author=" + author
				+ ", publishDate=" + publishDate + ", visits=" + visits + ", topicId=" + topicId + "]";
	}
	
	
}
