package ped.lfm.util;



public class LogUtil {
	private static boolean cl_DebugMode = PolicyController.CommonLog;

	public static void PrintLogInfo(String AppName, String ModuleName, Object Message) {
		if (cl_DebugMode) {
			System.out.println("[" + AppName + ":" + ModuleName + "] -> " + Message);	
		}
	}
}
