plugins {
    id("com.android.application")
    id("kotlin-android")
    id("dev.flutter.flutter-gradle-plugin")
}

import java.util.Properties
import java.io.FileInputStream

val keystoreProperties = Properties()
val keystorePropertiesFile = rootProject.file("key.properties")
if (keystorePropertiesFile.exists()) {
    keystoreProperties.load(FileInputStream(keystorePropertiesFile))
}

android {
    namespace = "com.example.flavors_test"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        applicationId = "com.example.flavors_test"
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    signingConfigs {
        create("mazdaConfig") {
            if (System.getenv("CI") != null) {
                storeFile = file(System.getenv("MAZDA_KEYSTORE_PATH"))
                storePassword = System.getenv("MAZDA_KEYSTORE_PASSWORD")
                keyAlias = System.getenv("MAZDA_KEY_ALIAS")
                keyPassword = System.getenv("MAZDA_KEY_PASSWORD")
            } else {
                storeFile = keystoreProperties["mazda_storeFile"]?.let { file(it as String) }
                storePassword = keystoreProperties["mazda_storePassword"] as String?
                keyAlias = keystoreProperties["mazda_keyAlias"] as String?
                keyPassword = keystoreProperties["mazda_keyPassword"] as String?
            }
        }

        create("nissanConfig") {
            if (System.getenv("CI") != null) {
                storeFile = file(System.getenv("NISSAN_KEYSTORE_PATH"))
                storePassword = System.getenv("NISSAN_KEYSTORE_PASSWORD")
                keyAlias = System.getenv("NISSAN_KEY_ALIAS")
                keyPassword = System.getenv("NISSAN_KEY_PASSWORD")
            } else {
                storeFile = keystoreProperties["nissan_storeFile"]?.let { file(it as String) }
                storePassword = keystoreProperties["nissan_storePassword"] as String?
                keyAlias = keystoreProperties["nissan_keyAlias"] as String?
                keyPassword = keystoreProperties["nissan_keyPassword"] as String?
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}

apply(from = "flavorizr.gradle.kts")
