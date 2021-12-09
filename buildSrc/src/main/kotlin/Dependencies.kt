object Versions {
    const val compileSdk = 31
    const val buildToolsVersion = "31.0.0"
    const val minSdk = 21
    const val targetSdk = 31
    const val versionCode = 1
    const val versionName = "1.0"

    const val gradle = "7.0.0"
    const val kotlin = "1.6.0"
    const val core = "1.6.0"
    const val appCompat = "1.3.1"
    const val material = "1.4.0"
    const val activityCompose = "1.3.1"
    const val compose = "1.1.0-beta04"
    const val constraintCompose = "1.0.0-beta02"
    const val lifecycle = "2.3.1"
    const val lifecycleViewModel = "1.0.0-alpha07"
    const val coil = "1.3.1"
    const val daggerHilt = "2.38.1"
    const val hiltNavigation = "1.0.0-alpha03"
    const val navigation = "2.4.0-alpha06"
    const val accompanist = "0.21.4-beta"
    const val okhttp = "4.9.1"
    const val retrofit = "2.9.0"
    const val retrofitConverter = "0.8.0"
    const val serialization = "1.2.2"
    const val nestedScroll = "0.7.0"
}

object Libs {

    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val junit = "junit:junit:4.+"

    object Kotlin {
        const val kgp = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.kotlin}"
    }

    object NetWorking {
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofitConverter}"
    }

    object AndroidX {

        const val core = "androidx.core:core-ktx:${Versions.core}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val constraintCompose = "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintCompose}"

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
        }

        object Compose {
            const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
            const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
            const val composeRuntime = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
            const val composeToolPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
            const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
            const val composeTool = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        }

        object Navigation {
            const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"
        }

        object Lifecycle {
            const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
            const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleViewModel}"
        }

        object Hilt {
            const val daggerHiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.daggerHilt}"
            const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
            const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
            const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}"
        }

        object Test {
            const val junitExt = "androidx.test.ext:junit:1.1.3"
            const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
        }
    }

    object ThirdParty {
        const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
        const val pager = "com.google.accompanist:accompanist-pager:${Versions.accompanist}"
        const val indicators = "com.google.accompanist:accompanist-pager-indicators:${Versions.accompanist}"
        const val insets = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
        const val insets_ui = "com.google.accompanist:accompanist-insets-ui:${Versions.accompanist}"
        const val nestedScrollView = "com.github.Tlaster:NestedScrollView:${Versions.nestedScroll}"
    }
}