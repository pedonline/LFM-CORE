package ped.lfm.util;
public class CommonLog {
	private static boolean cb_LogMode = PolicyController.CommonLog;
	public static void Print(LOG_LEVEL LL, String AppName, String ModuleName, String Message) {
		//System.out.println("CommonLog [START]");
		/*try {
			ESIPrintStream.DisPatch();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}*/
		if (cb_LogMode) {
			if (LL == LOG_LEVEL.INFO_LEVEL) {
				System.out.println("[INFO]-[" + AppName + ":" + ModuleName + "] -> " + Message);
				
			} else if (LL == LOG_LEVEL.WARN_LEVEL) {
				System.out.println("[WARN]-[" + AppName + ":" + ModuleName + "] -> " + Message);
			} else if (LL == LOG_LEVEL.ERROR_LEVEL) {
				System.out.println("[ERROR]-[" + AppName + ":" + ModuleName + "] -> " + Message);
			} else { 
				System.out.println("[INFO]-[" + AppName + ":" + ModuleName + "] -> " + Message);
			}
				
		}
	}
}
