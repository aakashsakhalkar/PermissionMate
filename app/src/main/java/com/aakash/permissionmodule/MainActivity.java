package com.aakash.permissionmodule;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.aakash.permissionhelper_ak.PermissionCallback;
import com.aakash.permissionhelper_ak.PermissionHelper;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity111";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        PermissionHelper helper = new PermissionHelper(this);

// CAMERA
        helper.requestCamera(new PermissionCallback() {
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "📷 Camera granted", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionGranted: 📷 Camera granted");
            }

            public void onPermissionDenied() {
                Toast.makeText(MainActivity.this, "📷 Camera denied", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionDenied: 📷 Camera denied");
            }
        });

// MICROPHONE
        helper.requestMicrophone(new PermissionCallback() {
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "🎤 Microphone granted", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionGranted: 🎤 Microphone granted");
            }

            public void onPermissionDenied() {
                Toast.makeText(MainActivity.this, "🎤 Microphone denied", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionDenied: 🎤 Microphone denied");
            }
        });

// STORAGE
        helper.requestStorage(new PermissionCallback() {
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "💾 Storage granted", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionGranted: 💾 Storage granted");
            }

            public void onPermissionDenied() {
                Toast.makeText(MainActivity.this, "💾 Storage denied", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionDenied: 💾 Storage denied");
            }
        });

// SMS
        helper.requestSMS(new PermissionCallback() {
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "📩 SMS granted", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionGranted: 📩 SMS granted");
            }

            public void onPermissionDenied() {
                Toast.makeText(MainActivity.this, "📩 SMS denied", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionDenied: 📩 SMS denied");
            }
        });

// CONTACTS
        helper.requestContacts(new PermissionCallback() {
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "👥 Contacts granted", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionGranted: 👥 Contacts granted");
            }

            public void onPermissionDenied() {
                Toast.makeText(MainActivity.this, "👥 Contacts denied", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionDenied: 👥 Contacts denied");
            }
        });

// PHONE STATE
        helper.requestPhoneState(new PermissionCallback() {
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "📞 Phone state granted", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionGranted: 📞 Phone state granted");
            }

            public void onPermissionDenied() {
                Toast.makeText(MainActivity.this, "📞 Phone state denied", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionDenied: 📞 Phone state denied");
            }
        });

// LOCATION
        helper.requestLocation(new PermissionCallback() {
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "📍 Location granted", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionGranted: 📍 Location granted");
            }

            public void onPermissionDenied() {
                Toast.makeText(MainActivity.this, "📍 Location denied", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionDenied: 📍 Location denied");
            }
        });

// ALL FILES ACCESS
        helper.requestAllFilesAccess(new PermissionCallback() {
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "📂 All Files Access granted", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionGranted: 📂 All Files Access granted");
            }

            public void onPermissionDenied() {
                Toast.makeText(MainActivity.this, "📂 All Files Access denied", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionDenied: 📂 All Files Access denied");
            }
        });

// OVERLAY
        helper.requestOverlayPermission(new PermissionCallback() {
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "🪟 Overlay granted", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionGranted: 🪟 Overlay granted");
            }

            public void onPermissionDenied() {
                Toast.makeText(MainActivity.this, "🪟 Overlay denied", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionDenied: 🪟 Overlay denied");
            }
        });

// USAGE ACCESS
        helper.requestUsageAccess(new PermissionCallback() {
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "📊 Usage Access granted", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionGranted: 📊 Usage Access granted");
            }

            public void onPermissionDenied() {
                Toast.makeText(MainActivity.this, "📊 Usage Access denied", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionDenied: 📊 Usage Access denied");
            }
        });

// IGNORE BATTERY OPTIMIZATION
        helper.requestIgnoreBatteryOptimization(new PermissionCallback() {
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "🔋 Battery optimization ignored", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionGranted: 🔋 Battery optimization ignored");
            }

            public void onPermissionDenied() {
                Toast.makeText(MainActivity.this, "🔋 Battery optimization required", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPermissionDenied: 🔋 Battery optimization required");
            }
        });

    }
}