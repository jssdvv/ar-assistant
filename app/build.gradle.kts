plugins {
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.jetbrains.compose.compiler)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.android.application)
    alias(libs.plugins.cashapp.sqldelight)
}

android {
    namespace = "com.jssdvv.ar_maintassist"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets.all {
        java.srcDir("src/main/kotlin")
        manifest.srcFile("src/main/AndroidManifest.xml")
        res.srcDirs("src/main/res")
    }
    defaultConfig {
        applicationId = "com.jssdvv.ar_maintassist"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    composeCompiler {}
}


sqldelight {
    databases {
        create("Database") {
            packageName.set("com.jssdvv.ar_maintassist")
        }
    }
}

dependencies {
    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    //androidTestImplementation(libs.androidx.compose.ui.test.junit4)

    // Androidx
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)

    // Kotlinx
    implementation(libs.jetbrains.kotlinx.serialization.json)

    // Lifecycle
    implementation(libs.bundles.androidx.lifecycle)

    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.androidx.compose)
    debugImplementation(libs.androidx.compose.ui.tooling)
    //debugImplementation(libs.androidx.compose.ui.test.manifest)

    // Navigation
    implementation(libs.androidx.navigation.compose)

    // Camera
    implementation(libs.bundles.androidx.camera)

    // Augmented Reality
    implementation(libs.sceneview.arsceneview)
}