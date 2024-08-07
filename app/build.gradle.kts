plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

android {
    namespace = ProjectSetting.PACKAGE_NAME
    compileSdk = 34

    defaultConfig {
        applicationId = ProjectSetting.PACKAGE_NAME
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("androidx.activity:activity-ktx:1.9.0")
    implementation("androidx.fragment:fragment-ktx:1.8.1")
    
    implementation("androidx.lifecycle:lifecycle-livedata-core-ktx:2.8.3")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.3")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.3")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.8.3")

    kapt("androidx.lifecycle:lifecycle-compiler:2.8.3")
    //noinspection GradleDependency
    implementation("androidx.lifecycle:lifecycle-common-java8:2.7.0")
    implementation("androidx.lifecycle:lifecycle-service:2.8.3")
    implementation("androidx.lifecycle:lifecycle-process:2.8.3")
    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:2.8.3")

    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation ("androidx.lifecycle:lifecycle-runtime-testing:2.8.3")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}