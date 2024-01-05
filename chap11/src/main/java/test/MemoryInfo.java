package test;

import java.text.DecimalFormat;

public class MemoryInfo {

	
	private final static String TAG = "Memory Infomation";

	public static String getMemoryInfo() {
	    String info = "";
	    
	    DecimalFormat format_mem =   new DecimalFormat("#,###KB");
	    DecimalFormat format_ratio = new DecimalFormat("##.#");
	    long free =  Runtime.getRuntime().freeMemory() / 1024;
	    long total = Runtime.getRuntime().totalMemory() / 1024;
	    long max =   Runtime.getRuntime().maxMemory() / 1024;
	    long used =  total - free;
	    double ratio = (used * 100 / (double)total);

	    info += "Total   = " + format_mem.format(total);
	    info += "\n";
	    info += "Free    = " + format_mem.format(total);
	    info += "\n";
	    info += "use     = " + format_mem.format(used) + " (" + format_ratio.format(ratio) + "%)";
	    info += "\n";
	    info += "can use = " + format_mem.format(max);
	    return info;
	}

	public static void viewMemoryInfo() {
	    Log.d(TAG,"---------- MemoryInfo --------");
	    Log.d(TAG,getMemoryInfo());
	    Log.d(TAG,"------------------------------");
	}
	
}
