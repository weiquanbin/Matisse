plugins {
    alias(libs.plugins.matisse.android.library)
    alias(libs.plugins.matisse.android.compose)
    alias(libs.plugins.app.kotlin.parcelize)
    alias(libs.plugins.app.library.publish)
}

android {
    namespace = "github.leavesczy.matisse"
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.compose)
    compileOnly(libs.coil.compose)
    compileOnly(libs.glide.compose)
}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.yishi"
            artifactId = "matisse"
            version = "0.0.14.3"
            afterEvaluate {
                from(components["release"])
            }
        }
        create<MavenPublication>("debug") {
            groupId = "com.yishi"
            artifactId = "matisse"
            version = "0.0.14.3"
            afterEvaluate {
                from(components["debug"])
            }
        }
    }
}
