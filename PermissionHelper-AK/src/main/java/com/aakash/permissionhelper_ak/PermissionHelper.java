package com.aakash.permissionhelper_ak;

import android.Manifest;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionHelper {

    private final Activity activity;
    private PermissionCallback callback;
    private static final int REQUEST_CODE = 999;

    public PermissionHelper(Activity activity) {
        this.activity = activity;
    }

    // === Public Request Methods ===

    public void requestCamera(PermissionCallback callback) {
        requestSingle(Manifest.permission.CAMERA, callback);
    }

    public void requestMicrophone(PermissionCallback callback) {
        requestSingle(Manifest.permission.RECORD_AUDIO, callback);
    }

    public void requestStorage(PermissionCallback callback) {
        requestMultiple(new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, callback);
    }

    public void requestSMS(PermissionCallback callback) {
        requestSingle(Manifest.permission.READ_SMS, callback);
    }

    public void requestContacts(PermissionCallback callback) {
        requestSingle(Manifest.permission.READ_CONTACTS, callback);
    }

    public void requestPhoneState(PermissionCallback callback) {
        requestSingle(Manifest.permission.READ_PHONE_STATE, callback);
    }

    public void requestLocation(PermissionCallback callback) {
        requestMultiple(new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        }, callback);
    }

    public void requestAllFilesAccess(PermissionCallback callback) {
        this.callback = callback;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && !Environment.isExternalStorageManager()) {
            try {
                Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                intent.setData(Uri.parse("package:" + activity.getPackageName()));
                activity.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Intent fallbackIntent = new Intent(Settings.ACTION_SETTINGS);
                activity.startActivity(fallbackIntent);
            }
        } else {
            callback.onPermissionGranted();
        }
    }

    public void requestOverlayPermission(PermissionCallback callback) {
        this.callback = callback;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(activity)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + activity.getPackageName()));
            activity.startActivity(intent);
        } else {
            callback.onPermissionGranted();
        }
    }

    public void requestUsageAccess(PermissionCallback callback) {
        this.callback = callback;
        if (!hasUsageAccessPermission()) {
            Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
            intent.setData(Uri.parse("package:" + activity.getPackageName()));
            activity.startActivity(intent);
        } else {
            callback.onPermissionGranted();
        }
    }

    public void requestIgnoreBatteryOptimization(PermissionCallback callback) {
        this.callback = callback;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PowerManager pm = (PowerManager) activity.getSystemService(Context.POWER_SERVICE);
            if (!pm.isIgnoringBatteryOptimizations(activity.getPackageName())) {
                Intent intent = new Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
                activity.startActivity(intent);
                return;
            }
        }
        callback.onPermissionGranted();
    }

    // === Internal Helpers ===

    private void requestSingle(String permission, PermissionCallback callback) {
        requestMultiple(new String[]{permission}, callback);
    }

    private void requestMultiple(String[] permissions, PermissionCallback callback) {
        this.callback = callback;
        List<String> toRequest = new ArrayList<>();
        for (String p : permissions) {
            if (ContextCompat.checkSelfPermission(activity, p) != PackageManager.PERMISSION_GRANTED) {
                toRequest.add(p);
            }
        }
        if (toRequest.isEmpty()) {
            callback.onPermissionGranted();
        } else {
            ActivityCompat.requestPermissions(activity,
                    toRequest.toArray(new String[0]), REQUEST_CODE);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE) {
            for (int result : grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    callback.onPermissionDenied();
                    return;
                }
            }
            callback.onPermissionGranted();
        }
    }

    private boolean hasUsageAccessPermission() {
        AppOpsManager appOps = (AppOpsManager) activity.getSystemService(Context.APP_OPS_SERVICE);
        int mode;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            mode = appOps.unsafeCheckOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS,
                    android.os.Process.myUid(), activity.getPackageName());
        } else {
            mode = appOps.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS,
                    android.os.Process.myUid(), activity.getPackageName());
        }

        return mode == AppOpsManager.MODE_ALLOWED;
    }
}
