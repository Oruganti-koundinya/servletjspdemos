package hibernatetests;

import org.hibernate.Session;

import com.samples.domain.Message;
import com.samples.utils.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Message message1 = new Message("Message 1"); 
		Message message2 = new Message("Message 2");
		Message message3 = new Message("Message 3");
		Message message4 = new Message("Message 4");
		Message message5 = new Message("Message 5");
		
		session.save(message1);
		session.save(message2);
		session.save(message3);
		session.save(message4);
		session.save(message5);
		
		session.getTransaction().commit();
		
		session.close();
		
	}
}