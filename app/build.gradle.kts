plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("org.jetbrains.kotlin.plugin.serialization") version Versions.kotlin
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Versions.compileSdk
    buildToolsVersion = Versions.buildToolsVersion

    defaultConfig {
        applicationId = "com.claire.composegallery"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.core)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material)

    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeToolPreview)
    androidTestImplementation(Dependencies.composeUiTest)
    debugImplementation(Dependencies.composeTool)

    implementation(Dependencies.constraintCompose)

    implementation(Dependencies.lifecycle)
    implementation(Dependencies.lifecycleViewModel)

    implementation(Dependencies.activityCompose)

    implementation(Dependencies.coil)

    // daggerHilt
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerHiltCompiler)
    implementation(Dependencies.hiltNavigation)

    implementation(Dependencies.navigation)

    // pager
    implementation(Dependencies.pager)
    implementation(Dependencies.indicators)

    // okhttp
    implementation(Dependencies.okhttp)

    // retrofit
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitConverter)

    // kotlin serialization
    implementation(Dependencies.serialization)

    // third
    implementation(Dependencies.nestedScrollView)

    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.junitExt)
    androidTestImplementation(Dependencies.espresso)

}