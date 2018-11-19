package ped.lfm.util;

import java.io.IOException;
import java.util.PropertyResourceBundle;

import ped.lfm.common.TYPE_FLAG;




public class PolicyController {
	public static String ServerWebServiceImagePath = "";
	public static boolean RequestWebServiceImageMode = false;
	public static boolean CommonLog = true;
	public static String PersonImageOffMode = "";
	static {
		PropertyResourceBundle propResBundle;
		try {
			System.out.println("[START] PolicyControler");
			propResBundle = new PropertyResourceBundle(Thread.currentThread().getContextClassLoader().getResourceAsStream("config_policy.properties"));
			try {
				String ls_RequestWebServiceImageMode = propResBundle.getString("RequestWebServiceImageMode");
				if (ls_RequestWebServiceImageMode.equals("true")) {
					RequestWebServiceImageMode = true;
				} else {
					RequestWebServiceImageMode = false;
				}
			} catch (Exception ex) {
				RequestWebServiceImageMode = false;
			}
			try {
				String ls_ServerWebServiceImagePath = propResBundle.getString("ServerWebServiceImagePath");
				ServerWebServiceImagePath = ls_ServerWebServiceImagePath;
			} catch (Exception ex) {
				ex.printStackTrace();
				ServerWebServiceImagePath = "";
			}
			try {
				String ls_PersonImageOffMode = propResBundle.getString("PersonImageOffMode");
				PersonImageOffMode = ls_PersonImageOffMode;
			} catch (Exception ex) {
				ex.printStackTrace();
				PersonImageOffMode = "";
			}
			try{
				TYPE_FLAG lo_CommonLog = TYPE_FLAG.getEnum(Integer.parseInt(propResBundle.getString("CommonLog")));
				if( lo_CommonLog.getValue() == TYPE_FLAG.TYPE_TRUE.getValue()){
					CommonLog = true;
				}else{
					CommonLog = false;
				}
			}catch(Exception ex){
				ex.printStackTrace();
				CommonLog = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
