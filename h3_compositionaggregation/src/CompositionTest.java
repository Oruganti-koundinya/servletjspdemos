import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.Address;
import com.samples.domain.User;
import com.samples.utils.HibernateUtil;

public class CompositionTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();

			Address billAddress = new Address("12", "Street-11", "Hyderabad", "500044");
			Address shipAddress = new Address("127/12", "Patny Center", "Secundrabad", "500003");
			User user = new User("Sarma", billAddress, shipAddress, 33);
			session.save(user);

			txn.commit();

		} catch (Exception ex) {
			if (txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
