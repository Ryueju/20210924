package PersonList;

import java.util.Scanner;

public class ScanUtil {
	
	static Scanner scn = new Scanner(System.in);
	
	public static int readInt(String msg) {
		System.out.println(msg);
		int Num = scn.nextInt();
		scn.nextLine();
		return Num;
	//	return scn.nextInt();
	}
	
	public static String readStr(String msg) {
		
		System.out.println(msg);
		return scn.nextLine();
		
	}

}
