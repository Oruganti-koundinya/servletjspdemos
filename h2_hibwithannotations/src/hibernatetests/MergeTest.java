package hibernatetests;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.Message;
import com.samples.utils.HibernateUtil;

public class MergeTest {

	public static void main(String[] args) {

		Session session1 = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session1.getTransaction();
		txn.begin();
		Message message = session1.get(Message.class, 3);
		System.out.println(message);
		txn.commit();
		session1.close();

		message.setText("new text");
		
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		Message message2 = session2.get(Message.class, 3);
		session2.merge(message);
		session2.getTransaction().commit();
		session2.close();

	}

}