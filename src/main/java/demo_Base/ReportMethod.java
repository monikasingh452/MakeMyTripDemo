package demo_Base;
import com.relevantcodes.extentreports.LogStatus;

public class ReportMethod extends PageBase {
public static void htmlInfo(String info, String arg){
		
		test.log(LogStatus.INFO,""+info+""+arg);
		
	}
	
public static void htmlInfo(String info){
		
test.log(LogStatus.INFO,""+info);
		
	}
	
public static void htmlError(String info, String arg){
		
		test.log(LogStatus.ERROR,""+info+""+arg);
		
	}

public static void htmlError(String info){
	
	test.log(LogStatus.ERROR,""+info);
	
}

public static void htmlWARNING(String info, String arg){
	
	test.log(LogStatus.WARNING,""+info+""+arg);
	
}

public static void htmlWARNING(String info){
	
	test.log(LogStatus.WARNING,""+info);
	
}

public static void htmlFail(String info, String arg){
	
	test.log(LogStatus.FAIL,""+info+""+arg);
	
}

public static void htmlFail(String info){
	
	test.log(LogStatus.FAIL,""+info);
	


}

}
