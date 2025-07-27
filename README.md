# PermissionMate

**PermissionMate** is a simple Android library for requesting runtime and special permissions using clean, callback-based methods.

## 📦 Installation

Add JitPack to your `settings.gradle`:

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://www.jitpack.io' }
    }
}
```

Add the dependency to your `build.gradle`:

```groovy
dependencies {
    implementation 'com.github.aakashsakhalkar:PermissionMate:v1.0.0'
}
```

## 🚀 Usage

Initialize `PermissionHelper` in your Activity:

```java
PermissionHelper helper = new PermissionHelper(this);
```

### Request Permissions

#### CAMERA

```java
helper.requestCamera(new PermissionCallback() {
    public void onPermissionGranted() {
        Toast.makeText(MainActivity.this, "📷 Camera granted", Toast.LENGTH_SHORT).show();
    }

    public void onPermissionDenied() {
        Toast.makeText(MainActivity.this, "📷 Camera denied", Toast.LENGTH_SHORT).show();
    }
});
```

#### MICROPHONE

```java
helper.requestMicrophone(new PermissionCallback() {
    public void onPermissionGranted() {
        Toast.makeText(MainActivity.this, "🎤 Microphone granted", Toast.LENGTH_SHORT).show();
    }

    public void onPermissionDenied() {
        Toast.makeText(MainActivity.this, "🎤 Microphone denied", Toast.LENGTH_SHORT).show();
    }
});
```

#### STORAGE

```java
helper.requestStorage(new PermissionCallback() {
    public void onPermissionGranted() {
        Toast.makeText(MainActivity.this, "💾 Storage granted", Toast.LENGTH_SHORT).show();
    }

    public void onPermissionDenied() {
        Toast.makeText(MainActivity.this, "💾 Storage denied", Toast.LENGTH_SHORT).show();
    }
});
```

#### SMS

```java
helper.requestSMS(new PermissionCallback() {
    public void onPermissionGranted() {
        Toast.makeText(MainActivity.this, "📩 SMS granted", Toast.LENGTH_SHORT).show();
    }

    public void onPermissionDenied() {
        Toast.makeText(MainActivity.this, "📩 SMS denied", Toast.LENGTH_SHORT).show();
    }
});
```

#### CONTACTS

```java
helper.requestContacts(new PermissionCallback() {
    public void onPermissionGranted() {
        Toast.makeText(MainActivity.this, "👥 Contacts granted", Toast.LENGTH_SHORT).show();
    }

    public void onPermissionDenied() {
        Toast.makeText(MainActivity.this, "👥 Contacts denied", Toast.LENGTH_SHORT).show();
    }
});
```

#### PHONE STATE

```java
helper.requestPhoneState(new PermissionCallback() {
    public void onPermissionGranted() {
        Toast.makeText(MainActivity.this, "📞 Phone state granted", Toast.LENGTH_SHORT).show();
    }

    public void onPermissionDenied() {
        Toast.makeText(MainActivity.this, "📞 Phone state denied", Toast.LENGTH_SHORT).show();
    }
});
```

#### LOCATION

```java
helper.requestLocation(new PermissionCallback() {
    public void onPermissionGranted() {
        Toast.makeText(MainActivity.this, "📍 Location granted", Toast.LENGTH_SHORT).show();
    }

    public void onPermissionDenied() {
        Toast.makeText(MainActivity.this, "📍 Location denied", Toast.LENGTH_SHORT).show();
    }
});
```

#### ALL FILES ACCESS

```java
helper.requestAllFilesAccess(new PermissionCallback() {
    public void onPermissionGranted() {
        Toast.makeText(MainActivity.this, "📂 All Files Access granted", Toast.LENGTH_SHORT).show();
    }

    public void onPermissionDenied() {
        Toast.makeText(MainActivity.this, "📂 All Files Access denied", Toast.LENGTH_SHORT).show();
    }
});
```

#### OVERLAY

```java
helper.requestOverlayPermission(new PermissionCallback() {
    public void onPermissionGranted() {
        Toast.makeText(MainActivity.this, "🪟 Overlay granted", Toast.LENGTH_SHORT).show();
    }

    public void onPermissionDenied() {
        Toast.makeText(MainActivity.this, "🪟 Overlay denied", Toast.LENGTH_SHORT).show();
    }
});
```

#### USAGE ACCESS

```java
helper.requestUsageAccess(new PermissionCallback() {
    public void onPermissionGranted() {
        Toast.makeText(MainActivity.this, "📊 Usage Access granted", Toast.LENGTH_SHORT).show();
    }

    public void onPermissionDenied() {
        Toast.makeText(MainActivity.this, "📊 Usage Access denied", Toast.LENGTH_SHORT).show();
    }
});
```

#### IGNORE BATTERY OPTIMIZATION

```java
helper.requestIgnoreBatteryOptimization(new PermissionCallback() {
    public void onPermissionGranted() {
        Toast.makeText(MainActivity.this, "🔋 Battery optimization ignored", Toast.LENGTH_SHORT).show();
    }

    public void onPermissionDenied() {
        Toast.makeText(MainActivity.this, "🔋 Battery optimization required", Toast.LENGTH_SHORT).show();
    }
});
```

## ✅ License

MIT — use it freely.
