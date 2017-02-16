package com.steve.appupdate;

import java.io.File;

import com.steve.appupdate.util.ApkUtils;
import com.steve.appupdate.util.BsPatch;
import com.steve.appupdate.util.Constants;
import com.steve.appupdate.util.DownloadUtils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static final String TAG = "steve";
	ProgressDialog progressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		progressBar = new ProgressDialog(this);
		
	}


	public void update(View view){
		progressBar.setMessage("正在下载。。。。。。");
		progressBar.show();
		new ApkUpdateTask().execute();
	}
	
	class ApkUpdateTask extends AsyncTask<Void, Void, Boolean>{

		@Override
		protected Boolean doInBackground(Void... params) {
			Log.d(TAG, "开始下载。。。。");
			try {
				//1.下载查分包
				File patchFile = DownloadUtils.download(Constants.URL_PATCH_DOWNLOAD);
				
				
				//2.合并得到最新版本的apk文件
				
				//获取当前应用的apk, /data/app/myapk.apk
				String oldfile = ApkUtils.getSourceApkPath(MainActivity.this, Constants.PACKAGE_NAME);
				String newfile = Constants.NEW_APK_PATH;
				String patchfile = patchFile.getAbsolutePath();
				
				Log.d(TAG, "oldfile:"+oldfile);
				Log.d(TAG, "newfile:"+newfile);
				Log.d(TAG, "patchfile:"+patchFile);
				BsPatch.patch(oldfile, Constants.NEW_APK_PATH, patchfile);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		@Override
		protected void onPostExecute(Boolean result) {
			super.onPostExecute(result);
			if(progressBar.isShowing()){
				progressBar.dismiss();
			}
			//3.安装
			if(result){
				Toast.makeText(getApplicationContext(), "您正在进行无流量更新", Toast.LENGTH_SHORT).show();
				ApkUtils.installApk(MainActivity.this, Constants.NEW_APK_PATH);
			}else{
				Log.d(TAG, "下载失败。。。。");
			}
			
		}
		
	}
	
}
