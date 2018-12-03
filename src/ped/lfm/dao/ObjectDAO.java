package ped.lfm.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.plw.util.DataNotFoundException;

import ped.lfm.util.CommonLog;
import ped.lfm.util.LOG_LEVEL;

//@Deprecated
public class ObjectDAO {

	public static Object Add(Session MyHSs, Object ao_Object) throws Exception {
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "Add", "[BEGIN]");
		try {
			MyHSs.save(ao_Object);
			CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "Add", "[END]");
			return ao_Object;
		} catch (Exception ex) {
			CommonLog.Print(LOG_LEVEL.ERROR_LEVEL, "ObjectDAO", "Add", "[ERROR] : " + ex.toString());
			throw ex;
		} finally {
		}
	}

	public static Object Disable(Session MyHSs, Object ao_Object) throws Exception {
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "Disable", "[BEGIN]");
		try {
			MyHSs.saveOrUpdate(ao_Object);
			CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "Disable", "[END]");
			return ao_Object;
		} catch (Exception ex) {
			CommonLog.Print(LOG_LEVEL.ERROR_LEVEL, "ObjectDAO", "Disable", "[ERROR] : " + ex.toString());
			throw ex;
		} finally {
		}
	}

	public static Object Delete(Session MyHSs, Object ao_Object) throws Exception {
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "Delete", "[BEGIN]");
		try {
			MyHSs.delete(ao_Object);
			CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "Delete", "[END]");
			return ao_Object;
		} catch (Exception ex) {
			CommonLog.Print(LOG_LEVEL.ERROR_LEVEL, "ObjectDAO", "Delete", "[ERROR] : " + ex.toString());
			throw ex;
		} finally {
		}
	}

	public static Object Modify(Session MyHSs, Object ao_Object) throws Exception {
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "Modify", "[BEGIN]");
		try {
			MyHSs.update(ao_Object);
			CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "Modify", "[END]");
			return ao_Object;
		} catch (Exception ex) {
			CommonLog.Print(LOG_LEVEL.ERROR_LEVEL, "ObjectDAO", "Modify", "[ERROR] : " + ex.toString());
			throw ex;
		} finally {
		}
	}

	public static List FindBySQL(Session MyHSs, Class ac_ClassName, String as_SQLCommand, int BeginRow, int MaxRow) throws DataNotFoundException, Exception {
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "FindBySQL", "[BEGIN]");
		try {
			CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "FindBySQL", "[SQL_COMMAND] : " + as_SQLCommand);
			Query query = MyHSs.createNativeQuery(as_SQLCommand,ac_ClassName);
			query.setFirstResult(BeginRow);
			if (MaxRow > 0) {
				query.setMaxResults(MaxRow);
			}
			List<Object> ObjectList = query.getResultList();
			if (ObjectList.isEmpty() != true) {
				CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "FindBySQL", "[END]");
				return ObjectList;
			} else {
				CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "FindBySQL", "[Not Found]");
				throw new DataNotFoundException("Find By SQL[Search By :" + as_SQLCommand + "] is not found.");
			}
		} catch (Exception ex) {
			CommonLog.Print(LOG_LEVEL.ERROR_LEVEL, "ObjectDAO", "FindBySQL", "[ERROR] : " + ex.toString());
			throw ex;
		} finally {
		}
	}

	public static int GetSizeBySQL(Session MyHSs, String as_SQLCommand) throws DataNotFoundException, Exception {
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "GetSizeBySQL", "[BEGIN]");
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "GetSizeBySQL", "[SQL_COMMAND] : " + as_SQLCommand);
		Query query = MyHSs.createNativeQuery(as_SQLCommand);
		query.setFirstResult(0);
		query.setMaxResults(1);
		Integer RowCount = (Integer) query.getSingleResult();
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "GetSizeBySQL", "[ROW_COUNT] : " + RowCount.intValue());
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "GetSizeBySQL", "[END]");
		return RowCount.intValue();
	}
	
	public static Object GetObjectBySQL(Session MyHSs, String as_SQLCommand) throws DataNotFoundException, Exception {
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "GetSizeBySQL", "[BEGIN]");
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "GetSizeBySQL", "[SQL_COMMAND] : " + as_SQLCommand);
		Query query = MyHSs.createNativeQuery(as_SQLCommand);
		query.setFirstResult(0);
		query.setMaxResults(1);
		Object RowCount = (Object) query.getSingleResult();
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "GetSizeBySQL", "[ROW_COUNT] : " + RowCount);
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "GetSizeBySQL", "[END]");
		return RowCount;
	}
	
	public static List FindByHQL(Session MyHSs, Class ac_ClassName, String as_SQLCommand, int BeginRow, int MaxRow) throws DataNotFoundException, Exception {
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "FindByHQL", "[BEGIN]");
		try {
			CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "FindByHQL", "[SQL_COMMAND] : " + as_SQLCommand);
			Query query = MyHSs.createQuery(as_SQLCommand,ac_ClassName);
			query.setFirstResult(BeginRow);
			if (MaxRow > 0) {
				query.setMaxResults(MaxRow);
			}
			CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "FindByHQL", "[SQL_COMMAND_Query] : " + query.toString());
			
			List<Object> ObjectList = query.getResultList();
			if (ObjectList.isEmpty() != true) {
				CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "FindByHQL", "[END]");
				return ObjectList;
			} else {
				CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "FindByHQL", "[Not Found]");
				throw new DataNotFoundException("Find By SQL[Search By :" + as_SQLCommand + "] is not found.");
			}
		} catch (Exception ex) {
			CommonLog.Print(LOG_LEVEL.ERROR_LEVEL, "ObjectDAO", "FindByHQL", "[ERROR] : " + ex.toString());
			throw ex;
		} finally {
		}
	}

	public static int GetSizeByHQL(Session MyHSs, String as_SQLCommand) throws DataNotFoundException, Exception {
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "GetSizeByHQL", "[BEGIN]");
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "GetSizeByHQL", "[HQL_COMMAND] : " + as_SQLCommand);
		Query query = MyHSs.createQuery(as_SQLCommand);
		query.setFirstResult(0);
		query.setMaxResults(1);
		Long RowCount = (Long) query.getSingleResult();
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "GetSizeByHQL", "[ROW_COUNT] : " + RowCount.intValue());
		CommonLog.Print(LOG_LEVEL.INFO_LEVEL, "ObjectDAO", "GetSizeByHQL", "[END]");
		return RowCount.intValue();
	}
	
	public static String TrimSpecialChar(String as_SearchString){
		if(as_SearchString != null){
			return as_SearchString.replace("'", "");
		}else{
			return as_SearchString;
		}
		
	}
}
