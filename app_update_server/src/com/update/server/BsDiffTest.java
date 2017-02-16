package com.update.server;

public class BsDiffTest {

	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		if(osName.toLowerCase().startsWith("win")){
			BsDiff.diff(ConstantsWin.OLD_APK_PATH, ConstantsWin.NEW_APK_PATH, ConstantsWin.PATCH_FILE_PATH);
			
		}else{
			
			BsDiff.diff(ConstantsLinux.OLD_APK_PATH, ConstantsLinux.NEW_APK_PATH, ConstantsLinux.PATCH_FILE_PATH);
		}
		
		//得到差分包
	}

}
