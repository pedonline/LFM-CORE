package ped.lfm.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ped.lfm.model.Person;
import ped.lfm.model.util.HibernateUtil;
import ped.lfm.util.CommonLog;
import ped.lfm.util.LOG_LEVEL;

public class PersonDAO {
	
	public static void Add(Session MyHSs,Person ao_Person) throws Exception {
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "PersonDAO", "Add", "[START]");
		try {
			MyHSs.save(ao_Person);
		} catch (Exception ex) {
			CommonLog.Print(LOG_LEVEL.ERROR_LEVEL, "PersonDAO", "Add",  ex.toString());			
			throw ex;
		} finally {
		}
	}

}
