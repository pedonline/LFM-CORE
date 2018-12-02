package ped.lfm.model.util;

import java.util.EnumSet;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.ogm.boot.OgmSessionFactoryBuilder;
import org.hibernate.ogm.cfg.OgmConfiguration;
import org.hibernate.ogm.cfg.OgmProperties;
import org.hibernate.ogm.datastore.infinispan.InfinispanEmbedded;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.hibernate.tool.hbm2ddl.SchemaValidator;
import org.hibernate.tool.schema.TargetType;

import ped.lfm.util.LogUtil;

import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	private static final StandardServiceRegistry serviceRegistry;
	private static final Configuration cfg;
	private static final Metadata metadata;
	private static final MetadataSources sources;
	static {
		String ls_host = "";
		String ls_dbName = "";
		String ls_userdb = "";
		String ls_passworddb = null;
		String li_portDB = "27017";
		String ls_max_size = "100";
		String ls_min_size = "40";
		String ls_max_age = "600";
		String ls_show_sql = "false";
	     try{
	            Properties properties = new Properties();
	            Locale locale = Locale.getDefault();
	            PropertyResourceBundle propResBundle = new PropertyResourceBundle(Thread.currentThread().getContextClassLoader().getResourceAsStream("configMG.properties"));
	            ls_host = propResBundle.getString("host");
				ls_dbName = propResBundle.getString("dbName");
				li_portDB = propResBundle.getString("portDB");
				ls_userdb = propResBundle.getString("userdb");
				ls_passworddb = propResBundle.getString("passworddb");
				ls_max_size = propResBundle.getString("max_size");
				ls_min_size = propResBundle.getString("min_size");
				ls_show_sql = propResBundle.getString("show_sql");
				ls_max_age = propResBundle.getString("maxAge");
				System.out.println("ls_host="+ls_host);
			    System.out.println("userDB="+ls_dbName);
			    System.out.println("li_portDB="+li_portDB);
			    System.out.println("maxSize="+ ls_max_size);
			    System.out.println("minSize="+ ls_min_size);
			    System.out.println("showSql="+ls_show_sql );
			    System.out.println("max_age=" + ls_max_age);
	    }catch(Exception exception){
	            System.out.println("load Properties File");
	            exception.printStackTrace();
	    }

		try {
			//cfg = new AnnotationConfiguration();
			cfg = new OgmConfiguration();
			
			
			
			
			cfg.addAnnotatedClass(ped.lfm.model.Person.class);
//			cfg.addAnnotatedClass(rbac.model.GroupAssetPermission.class);
//			cfg.addAnnotatedClass(rbac.model.GroupAssetPermissionPK.class);
//			cfg.addAnnotatedClass(rbac.model.ParameterLookup.class);
//			cfg.addAnnotatedClass(rbac.model.ParameterLookupPK.class);
//			cfg.addAnnotatedClass(rbac.model.SystemAsset.class);
//			cfg.addAnnotatedClass(rbac.model.SystemGroup.class);
//			cfg.addAnnotatedClass(rbac.model.SystemGroupMember.class);
//			cfg.addAnnotatedClass(rbac.model.SystemGroupMemberPK.class);
//			cfg.addAnnotatedClass(rbac.model.SystemUserADR.class);
//			cfg.addAnnotatedClass(rbac.model.SystemUser.class);
//			cfg.addAnnotatedClass(rbac.model.SystemUserRequest.class);
//			cfg.addAnnotatedClass(rbac.model.SystemUserRequestPK.class);
//			cfg.addAnnotatedClass(rbac.model.UserAssetPermission.class);
//			cfg.addAnnotatedClass(rbac.model.UserAssetPermissionPK.class);
			cfg.addPackage("ped.lfm.model");
			cfg.setProperty("javax.persistence.provider","org.hibernate.ogm.jpa.HibernateOgmPersistence");

			cfg.setProperty("hibernate.ogm.datastore.create_database", "true");
			cfg.setProperty("hibernate.ogm.datastore.provider", "mongodb");
			cfg.setProperty("hibernate.ogm.datastore.database", ls_dbName);
			cfg.setProperty("hibernate.ogm.datastore.host",ls_host);
			cfg.setProperty("hibernate.ogm.datastore.port", li_portDB);
			cfg.setProperty("hibernate.ogm.datastore.username", ls_userdb);
			cfg.setProperty("hibernate.ogm.datastore.password", ls_passworddb);
			
			cfg.setProperty("hibernate.show_sql", ls_show_sql);
//			cfg.setProperty("hibernate.hbm2ddl.auto", "update");

			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
			
			sources = new MetadataSources(serviceRegistry);
			metadata = sources.buildMetadata(serviceRegistry);
		    sessionFactory = cfg.buildSessionFactory(ssrb.build());
		} catch (Throwable ex) {
			// Logexception!
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void SchemaExport() {
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.setOutputFile("db-schema.hibernate5.ddl");
		schemaExport.create(EnumSet.of(TargetType.SCRIPT), metadata);
		metadata.buildSessionFactory().close();
	}

	public static void SchemaUpdate() {
		SchemaUpdate schemaUpdate = new SchemaUpdate();
		EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE);
		schemaUpdate.execute(targetTypes, metadata, serviceRegistry);
	}

	public static void SchemaValidate() {
		SchemaValidator schemaValidator = new SchemaValidator();
		schemaValidator.validate(metadata,serviceRegistry);
	}

	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}
	
	public static void main(String[] argv) {
//		HibernateUtil.SchemaValidate();
		HibernateUtil.getSession();
//		HibernateUtil.SchemaUpdate();
		if (argv.length > 0) {
			String CLICommand = argv[0].toUpperCase();
			if (CLICommand.equals("Export".toUpperCase())) {
				LogUtil.PrintLogInfo("RBAC", "DAO", "Export Mode");
//				HibernateUtil.SchemaExport();		
			} else if (CLICommand.equals("Update".toUpperCase())) {
				LogUtil.PrintLogInfo("RBAC", "DAO", "Update Mode");
//				HibernateUtil.SchemaUpdate();
			} else if (CLICommand.equals("Validate".toUpperCase())) {
				LogUtil.PrintLogInfo("RBAC", "DAO", "Validate Mode");
//				HibernateUtil.SchemaValidate();
			} else {
				LogUtil.PrintLogInfo("RBAC", "DAO", "java -jar xx.jar nbd.util.HibernateUtil [Export, Update, Validate]");
			}
		}
	}
}
