package com.update.server;

public class BsDiff {
	
	/**
	 * 生成差分包
	 * 
	 * @param oldFile 旧的apk文件路径
	 * @param newFile 新的apk文件路径
	 * @param patchFile 差分包存放的路径
	 */
	public native static void diff(String oldFile,String newFile,String patchFile); 
	
	static {
//		String osName = 
//		System.loadLibrary("bsdiff");
		System.load("/usr/steve/apks/bsdiff.so");
	}
}
