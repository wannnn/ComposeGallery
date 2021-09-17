object Dependencies {

    // gradle-plugin
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kgp = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val daggerHiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.daggerHilt}"

    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"

    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"

    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val composeToolPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val composeTool = "androidx.compose.ui:ui-tooling:${Versions.compose}"

    const val constraintCompose = "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintCompose}"

    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleViewModel}"

    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"

    // daggerHilt
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"

    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}"

    // navigation
    const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"

    const val pager = "com.google.accompanist:accompanist-pager:${Versions.pager}"
    const val indicators = "com.google.accompanist:accompanist-pager-indicators:${Versions.pager}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofitConverter}"

    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"

    // third
    const val nestedScrollView = "com.github.Tlaster:NestedScrollView:${Versions.nestedScroll}"

    const val junit = "junit:junit:4.+"
    const val junitExt = "androidx.test.ext:junit:1.1.3"
    const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
}