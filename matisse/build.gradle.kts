plugins {
    alias(libs.plugins.matisse.android.library)
    alias(libs.plugins.matisse.android.compose)
    id("maven-publish")
    id("signing")
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
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material.icons.extended)
    implementation(libs.androidx.compose.material3)
    compileOnly(libs.coil.compose)
    compileOnly(libs.glide.compose)

}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.yishi"
            artifactId = "matisse"
            version = "0.0.14"
            afterEvaluate {
                from(components["release"])
            }
        }
        create<MavenPublication>("debug") {
            groupId = "com.yishi"
            artifactId = "matisse"
            version = "0.0.14"
            afterEvaluate {
                from(components["debug"])
            }
        }
    }
}
