package com.steve.appupdate.util;

import java.io.File;

import android.os.Environment;

public class Constants {

	public static final String PATCH_FILE = "update.patch";
	public static final String URL_PATCH_DOWNLOAD = "http://192.168.0.5:8080/SteveAppUpdateServer/"+PATCH_FILE;
	//linux remote
//	public static final String URL_PATCH_DOWNLOAD = "http://192"+PATCH_FILE;
	
	public static final String PACKAGE_NAME = "com.steve.appupdate";
	
	public static final String SD_CARD = Environment.getExternalStorageDirectory() + File.separator;
	
	//新版本apk的目录
	public static final String NEW_APK_PATH = SD_CARD+"steve_apk_new.apk";
	
	public static final String PATCH_FILE_PATH = SD_CARD+PATCH_FILE;
	
}
