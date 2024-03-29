plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.android.hilt.plugin)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "uk.adbsalam.portfolio"
    compileSdk = 34

    defaultConfig {
        applicationId = "uk.adbsalam.portfolio"
        minSdk = 28
        targetSdk = 34
        versionCode = 6
        versionName = "2.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
        debug {
            applicationIdSuffix = ".debug"
        }
    }

    buildFeatures{
        buildConfig = true
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(project(":startup:feature"))
    implementation(libs.app.compat)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}