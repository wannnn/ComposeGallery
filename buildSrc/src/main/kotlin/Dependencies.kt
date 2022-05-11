object Versions {
    const val compileSdk = 31
    const val buildToolsVersion = "31.0.0"
    const val minSdk = 21
    const val targetSdk = 31
    const val versionCode = 1
    const val versionName = "1.0"

    const val gradle = "7.0.0"
    const val kotlin = "1.6.10"
    const val core = "1.7.0"
    const val appCompat = "1.4.1"
    const val material = "1.4.0"
    const val activityCompose = "1.3.1"
    const val activityKtx = "1.4.0"
    const val compose = "1.2.0-alpha07"
    const val compose_material3 = "1.0.0-alpha09"
    const val lifecycle = "2.4.1"
    const val coil = "2.0.0-rc03"
    const val daggerHilt = "2.38.1"
    const val hiltNavigation = "1.0.0"
    const val navigation = "2.4.2"
    const val accompanist = "0.23.1"
    const val okhttp = "4.9.3"
    const val retrofit = "2.9.0"
    const val retrofitConverter = "0.8.0"
    const val serialization = "1.3.2"
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

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
            const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
        }

        object Compose {
            const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
            const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
            const val composeMaterial3 = "androidx.compose.material3:material3:${Versions.compose_material3}"
            const val composeMaterialExtended = "androidx.compose.material:material-icons-extended:${Versions.compose}"
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
        const val system_ui = "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
        const val flow_layout = "com.google.accompanist:accompanist-flowlayout:${Versions.accompanist}"
        const val nestedScrollView = "com.github.Tlaster:NestedScrollView:${Versions.nestedScroll}"
    }
}