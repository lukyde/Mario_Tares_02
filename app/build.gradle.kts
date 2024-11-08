plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "dam.pmdm.tarea2RMLP"
    compileSdk = 34

    defaultConfig {
        applicationId = "dam.pmdm.tarea2RMLP"
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
    buildFeatures{
        viewBinding = true;
        dataBinding= true;
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation ("com.squareup.picasso:picasso:2.71828")
    implementation("androidx.navigation:navigation-ui:2.8.3")
    implementation("androidx.navigation:navigation-fragment:2.8.3")
    implementation("androidx.core:core-splashscreen:1.0.1")

    implementation ("androidx.navigation:navigation-ui-ktx:2.8.2")

    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.recommendation)
    implementation(libs.cardview)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.preference)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

}