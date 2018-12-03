package ped.lfm.common;


public enum TYPE_DATA_STATUS {
	STATUS_NEW(0, "ใหม่(New)"), 
	STATUS_USE(100, "ใช้งานได้ แก้ไขได้(Enable)"), 
	STATUS_LOCK(101, "ใช้งานได้ แก้ไขได้ แต่ห้ามยกเลิกข้อมูล(Lock)"), 
	STATUS_PERMANENT(111, "ใช้งานได้ ห้ามแก้ไข ห้ามยกเลิกข้อมูล(Permanent)"), 
	STATUS_PAUSE(211, "ห้ามใช้งานชั่วคราว(Pause)"), 
	STATUS_DISABLE(411, "ยกเลิก (Disable)"), 
	STATUS_DELETE(511, "ข้อมูลถูกลบ รอการนำออก(Deleted)");

	private static final int[] StatusValue = { 0, 100, 101, 111, 211, 411, 511 };

	private static final int[][] StatusFlow = { { 0, 0, 100 }, { 100, 100, 101, 211 }, { 101, 101, 100, 111 }, { 111, 111 }, { 211, 211, 411, 100 }, { 411, 411, 100, 511 }, { 511, 511 } };

	private int Value;
	private String Message;

	private TYPE_DATA_STATUS(int value, String message) {
		this.Value = value;
		this.Message = message;
	}

	public int getValue() {
		return this.Value;
	}

	public static int[] getStatusValue() {
		return StatusValue;
	}

	public static int[][] getStatusFlow() {
		return StatusFlow;
	}

	public void setValue(int value) {
		this.Value = value;
	}

	public String getMessage() {
		return this.Message;
	}

	public void setMessage(String message) {
		this.Message = message;
	}

	public static TYPE_DATA_STATUS getEnum(int Data) {
		TYPE_DATA_STATUS[] CheckList = TYPE_DATA_STATUS.values();
		for (int i = 0; i < CheckList.length; i++) {
			if (CheckList[i].getValue() == Data) {
				return CheckList[i];
			}
		}
		return TYPE_DATA_STATUS.STATUS_NEW;
	}

	public TYPE_DATA_STATUS[] getValues(int ai_Mode) {
		return null;
	}

	public static TYPE_DATA_STATUS[] GetNextState(Integer ai_CurrStatus) {
		if (ai_CurrStatus != null) {
			for (int i = 0; i < StatusFlow.length; i++) {
				if (ai_CurrStatus == StatusFlow[i][0]) {
					TYPE_DATA_STATUS[] ResultList = new TYPE_DATA_STATUS[StatusFlow[i].length-1];
					for (int j = 1; j < StatusFlow[i].length; j++) {
						ResultList[j-1] = TYPE_DATA_STATUS.getEnum(StatusFlow[i][j]);
					}
					return ResultList;
				}
			}
			return new TYPE_DATA_STATUS[0];
		} else {
			TYPE_DATA_STATUS[] ResultList = new TYPE_DATA_STATUS[StatusFlow[0].length-1];
			for (int j = 1; j < StatusFlow[0].length; j++) {
				ResultList[j-1] = TYPE_DATA_STATUS.getEnum(StatusFlow[0][j]);
			}
			return ResultList;
		}
	}

//	 public static void main(String[] args){
//		 TYPE_DATA_STATUS[] CheckList = TYPE_DATA_STATUS.GetNextState(null);
//		 for (int i = 0; i < CheckList.length; i++) {
//			 System.out.println(CheckList[i].getValue()+" = "+CheckList[i].getMessage());
//		 }
//			
//	 }
}