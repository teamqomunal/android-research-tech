import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.text.SimpleDateFormat
import java.util.Date

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    id("kotlin-parcelize")
}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas") // If Using Ksp
}

base {
    // Naming APK // AAB
    val timestamp = SimpleDateFormat("dd-MM-yyyy_hh-mm").format(Date())
    archivesName = "${ProjectSetting.NAME_APP}-${ProjectSetting.VERSION_CODE}-[${ProjectSetting.VERSION_NAME}]-$timestamp"
}

android {
    namespace = ProjectSetting.PACKAGE_NAME
    compileSdk = ProjectSetting.COMPILE_SDK

    defaultConfig {
        applicationId = ProjectSetting.PACKAGE_NAME
        minSdk = ProjectSetting.MIN_SDK
        targetSdk = ProjectSetting.TARGET_SDK
        versionCode = ProjectSetting.VERSION_CODE
        versionName = ProjectSetting.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    lint {
        abortOnError = false
        checkReleaseBuilds = false
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
        freeCompilerArgs.add("-opt-in=kotlin.RequiresOptIn")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.swiperefreshlayout)
    implementation(libs.androidx.work.runtime.ktx)

    implementation(libs.androidx.room.runtime)
    implementation(libs.play.services.measurement.api)
    testImplementation(libs.junit.jupiter)

    // To use Kotlin annotation processing tool (kapt)
    ksp(libs.androidx.room.compiler)

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)

    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.common.java8)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.process)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.datastore.preferences)

    implementation(libs.google.play.services.auth)

    implementation(libs.google.play.services.location)
    implementation(libs.google.play.services.maps)
    implementation(libs.google.places)

    implementation(libs.google.maps.services)

    implementation(libs.google.material)
    implementation(libs.flexbox)

    // CameraX core library using camera2 implementation
    implementation(libs.androidx.camera.core)
    implementation(libs.androidx.camera.camera2)
    implementation(libs.androidx.camera.lifecycle)
    implementation(libs.androidx.camera.video)
    implementation(libs.androidx.camera.view)
    implementation(libs.androidx.camera.extensions)

    // Glide
    implementation(libs.glide)

    implementation("com.github.bumptech.glide:recyclerview-integration:4.16.0") {
        // Excludes the support library because it"s already included by Glide.
        isTransitive = false
    }

    // Skip this if you don"t want to use integration libraries or configure Glide.
    ksp(libs.glide.compiler)

    implementation(libs.google.gson)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp3.logging.interceptor)

    implementation(libs.hilt.android)

    ksp(libs.hilt.android.compiler)

    implementation(libs.timber)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics.ktx)
    implementation(libs.firebase.crashlytics.ktx)
    implementation("com.google.firebase:firebase-auth") {
        exclude("", "play-services-safetynet")
    }
    implementation(libs.firebase.messaging)

    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.media3.exoplayer.dash)
    implementation(libs.androidx.media3.ui)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.permissionx)
    implementation(libs.prettytime)
    implementation(libs.commons.text)

    implementation(libs.locus.android)
    implementation(libs.imagepicker)
    implementation(libs.lightcompressor)
    implementation(libs.mpandroidchart)
    implementation(libs.pusher.java.client)

    implementation(libs.socialview)
    implementation(libs.socialview.autocomplete)

    implementation(libs.pinview)
    implementation(libs.compressor)

    implementation(libs.scrollingpagerindicator)
    implementation(libs.currencyedittext)

    implementation(libs.colorpickerview)
    implementation(libs.progressview)
    implementation(libs.balloon)

    implementation(libs.customactivityoncrash)

    implementation(libs.zxing.core)

    implementation(libs.zxing.android.embedded) {
        exclude(
            group = "com.google.zxing",
            module = "core"
        )
    }

    implementation(libs.monthyear.picker)

    implementation(libs.markwon)
    implementation(libs.jodaTime)

    implementation(libs.fastadapter)
    implementation(libs.fastadapter.extensions.expandable)
    implementation(libs.fastadapter.extensions.binding) // view binding helpers
    implementation(libs.fastadapter.extensions.diff) // diff util helpers
    implementation(libs.fastadapter.extensions.drag) // drag support
    implementation(libs.fastadapter.extensions.paged) // paging support
    implementation(libs.fastadapter.extensions.scroll) // scroll helpers
    implementation(libs.fastadapter.extensions.swipe) // swipe support
    implementation(libs.fastadapter.extensions.ui) // pre-defined ui components
    implementation(libs.fastadapter.extensions.utils) // needs the `expandable`, `drag` and `scroll` extension.

    testImplementation(libs.hilt.android.testing)
    kspTest(libs.hilt.android.compiler)

    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.no.op)

    testImplementation(libs.junit)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.junit.jupiter)
    testImplementation(libs.mockito.inline)
    testImplementation(libs.okhttp3.mockwebserver)

    //special testing
    testImplementation(libs.androidx.core.testing) // InstantTaskExecutorRule
    testImplementation(libs.kotlinx.coroutines.test) //TestCoroutineDispatcher

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.runner)
    androidTestImplementation(libs.androidx.rules)

}