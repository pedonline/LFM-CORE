package ped.lfm.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ped.lfm.dao.PersonDAO;
import ped.lfm.model.Person;
import ped.lfm.model.util.HibernateUtil;
import ped.lfm.util.CommonLog;
import ped.lfm.util.LOG_LEVEL;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session MyHSs = HibernateUtil.getSession();
		Transaction MyHTs = MyHSs.beginTransaction();
		Person lo_ps = new Person();
		lo_ps.setFirstName("weerayut");
		lo_ps.setLastName("wichaidit");
		try {
			PersonDAO.Add(MyHSs, lo_ps);
			MyHTs.commit();
		} catch (Exception ex) {
			CommonLog.Print(LOG_LEVEL.ERROR_LEVEL, "PersonDAO", "Add",  ex.toString());		
			ex.printStackTrace();
			MyHTs.rollback();
		} finally {
			MyHSs.close();
		}
		

	}

}
