/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package jujinsuo.yuanze.com.jujinsuo_v20.common;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import jujinsuo.yuanze.com.jujinsuo_v20.application.JujinsuoApplication;
import jujinsuo.yuanze.com.jujinsuo_v20.tools.MyFileUtils;
import jujinsuo.yuanze.com.jujinsuo_v20.tools.SystemTool;
import jujinsuo.yuanze.com.jujinsuo_v20.ui.UserHomeActivity;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
	private Context mContext;
	public boolean openUpload = true;
	private static final String DEFAULT_LOG_DIR = "log";
	private static final String FILE_NAME_SUFFIX = ".log";
	private static CrashHandler sInstance = null;
	private Thread.UncaughtExceptionHandler mDefaultCrashHandler;

	private CrashHandler(Context cxt) {
		this.mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();

		Thread.setDefaultUncaughtExceptionHandler(this);

		this.mContext = cxt.getApplicationContext();
	}

	public static synchronized CrashHandler create(Context cxt) {
		if (sInstance == null) {
			sInstance = new CrashHandler(cxt);
		}
		return sInstance;
	}


	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		try {

			saveToSDCard(ex);
//			ActivityPageManager.getInstance().finishAllActivity();
//			MobclickAgent.onKillProcess(JujinsuoApplication.getInstance());
			// 联网发送
//			MobclickAgent.reportError(JujinsuoApplication.getInstance(), str);//发给友盟统计
			Intent intent = new Intent(JujinsuoApplication.getInstance(), UserHomeActivity.class);
			PendingIntent restartIntent = PendingIntent.getActivity(JujinsuoApplication.getInstance(), 0, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
			//退出程序
			AlarmManager mgr = (AlarmManager) JujinsuoApplication.getInstance().getSystemService(Context.ALARM_SERVICE);
			mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 1000,
					restartIntent); // 1秒钟后重启应用
			System.exit(0);
		} catch (Exception localException) {

		}
	}


	private void saveToSDCard(Throwable ex) throws Exception {
		File file = MyFileUtils.getSaveFile(this.mContext.getPackageName() + File.separator + "log", SystemTool.getDataTime("yyyy-MM-dd-HH-mm-ss") + ".log");
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

		pw.println(SystemTool.getDataTime("yyyy-MM-dd-HH-mm-ss"));

		dumpPhoneInfo(pw);

		pw.println();

		ex.printStackTrace(pw);
		pw.flush();
		pw.close();
	}

	private void dumpPhoneInfo(PrintWriter pw)
			throws PackageManager.NameNotFoundException {
		PackageManager pm = this.mContext.getPackageManager();
		PackageInfo pi = pm.getPackageInfo(this.mContext.getPackageName(), 1);
		pw.print("App Version: ");
		pw.print(pi.versionName);
		pw.print('_');
		pw.println(pi.versionCode);
		pw.println();

		pw.print("OS Version: ");
		pw.print(Build.VERSION.RELEASE);
		pw.print("_");
		pw.println(Build.VERSION.SDK_INT);
		pw.println();

		pw.print("Vendor: ");
		pw.println(Build.MANUFACTURER);
		pw.println();

		pw.print("Model: ");
		pw.println(Build.MODEL);
		pw.println();

		pw.print("CPU ABI: ");
		pw.println(Build.CPU_ABI);
		pw.println();
	}


}