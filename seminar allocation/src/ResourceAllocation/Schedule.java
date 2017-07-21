package ResourceAllocation;

import java.io.IOException;
import java.text.*;
import java.util.*;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public interface Schedule {
	
	Calendar c = Calendar.getInstance();
	//String Slots[] = {"10:00:00","11:00:00", "12:00:00", "13:00:00", "14:00:00", "15:00:00", "16:00:00"};
	
	boolean availableSlots() throws ParseException;
	boolean reservedSlots() throws ParseException;
	public boolean bookSlot(String DateRequired, int slot, String topic) throws ParseException, BiffException, IOException, RowsExceededException, WriteException;
}
