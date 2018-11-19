package ped.lfm.util;
import java.util.Arrays;
import java.util.Locale;
import java.util.PropertyResourceBundle;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
public class LFMModelUtil {
	public static MongoClient mongo;
	public static MongoDatabase db;
	public static MongoCredential credential;
	public static MongoClientOptions options;
	public static DB db2;
	static {
		String ls_host = "";
		String ls_dbName = "";
		String ls_userdb = "";
		char[] ls_passworddb = null;
		Integer li_portDB = 27017;
		try {
			java.util.Properties dbProps = new java.util.Properties();
			Locale locale = Locale.getDefault();
			PropertyResourceBundle propResBundle = new PropertyResourceBundle(Thread.currentThread().getContextClassLoader().getResourceAsStream("configMG.properties"));
			ls_host = propResBundle.getString("host");
			ls_dbName = propResBundle.getString("dbNamePias");
			li_portDB = Integer.parseInt(propResBundle.getString("portDB"));
			ls_userdb = propResBundle.getString("userdb");
			ls_passworddb = propResBundle.getString("passworddb").toCharArray();
			credential = MongoCredential.createScramSha1Credential(ls_userdb, ls_dbName, ls_passworddb);

			options = MongoClientOptions.builder().sslEnabled(false).build();
//			mongo = new MongoClient(ls_host, li_portDB);
			mongo = new MongoClient(new ServerAddress(ls_host, li_portDB),Arrays.asList(credential),options);
			db = mongo.getDatabase(ls_dbName);
			db2 = mongo.getDB(ls_dbName);
			System.out.println("host=" + ls_host);
			System.out.println("dbName=" + ls_dbName);
			System.out.println("portDB=" + li_portDB);
			
		} catch (Exception ex) {
			System.out.println("load Properties File");
			ex.printStackTrace();
		}

	}
	public static void main(String[] argv) {
	}
	
	

}
