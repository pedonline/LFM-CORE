package ped.lfm.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ped.lfm.common.TYPE_DATA_STATUS;
import ped.lfm.dao.PersonDAO;
import ped.lfm.model.Person;
import ped.lfm.model.util.HibernateUtil;
import ped.lfm.util.CommonLog;
import ped.lfm.util.LOG_LEVEL;

public class PersonTest {
	public static void UTTestAdd() {
		Session MyHSs = HibernateUtil.getSession();
		Transaction MyHTs = MyHSs.beginTransaction();
		Person lo_ps = new Person();
		lo_ps.setFirstName("weerayut");
		lo_ps.setLastName("wichaidit");
		try {
			lo_ps = PersonDAO.Add(MyHSs, lo_ps,"Pedonline", null, null);
			MyHTs.commit();
		} catch (Exception ex) {
			CommonLog.Print(LOG_LEVEL.ERROR_LEVEL, "PersonDAO", "Add",  ex.toString());		
			ex.printStackTrace();
			MyHTs.rollback();
		} finally {
			MyHSs.close();
		}
		
		System.out.println(lo_ps);
	}
	
	public static void UTTestGetByID() {
		Session MyHSs = HibernateUtil.getSession();
		try {
			Person lo_ps = PersonDAO.GetByID(MyHSs, 1, null, null);
			System.out.println(lo_ps);
		} catch (Exception ex) {
			CommonLog.Print(LOG_LEVEL.ERROR_LEVEL, "PersonDAO", "GetByID",  ex.toString());		
			ex.printStackTrace();
		} finally {
			MyHSs.close();
		}
		
		
	}
	
	public static void UTTestModify() {
		Session MyHSs = HibernateUtil.getSession();
		Transaction MyHTs = MyHSs.beginTransaction();
		Person lo_ps = null;
		try {
			lo_ps = PersonDAO.GetByID(MyHSs,6, null, null);
			lo_ps.setPersonCode("XXXXXXXXX");
			lo_ps.setDataStatus(TYPE_DATA_STATUS.STATUS_DISABLE.getValue());
			lo_ps = PersonDAO.Modify(MyHSs, lo_ps,"Pedonline", null, null);
			MyHTs.commit();
		} catch (Exception ex) {
			CommonLog.Print(LOG_LEVEL.ERROR_LEVEL, "PersonDAO", "GetByID",  ex.toString());		
			ex.printStackTrace();
			MyHTs.rollback();
		} finally {
			MyHSs.close();
		}
		System.out.println(lo_ps);
		
	}
	
	public static void UTTestFindAll(int BeginRow, int MaxRow) throws Exception {
		Session MyHSs = HibernateUtil.getSession();
//		
		List<Person> lo_List = PersonDAO.FindAll(MyHSs,null,null,BeginRow, MaxRow);
		for (int i = 0; i < lo_List.size(); i++) {
			System.out.println(lo_List.get(i));
		}
		
	}


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		UTTestAdd();
		UTTestGetByID();
		UTTestModify();
		UTTestFindAll(0,0);
	}

}
