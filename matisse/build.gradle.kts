plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.parcelize)
    //custom
    `maven-publish`
}

android {
    namespace = "github.leavesczy.matisse"

    //custom
    compileSdk = 36

    publishing {
        singleVariant("release") {
            // 内置方法：自动将源码打包成 sources.jar 并附带发布，不再需要手写 Task
            withSourcesJar()
        }
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.compose)
    compileOnly(libs.coil.compose)
    compileOnly(libs.glide.compose)

    //custom
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material.icons.extended)
    implementation(libs.androidx.compose.material3)
}

//custom
publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.yishi"
            artifactId = "matisse"
            version = "0.0.14.4"
            afterEvaluate {
                from(components["release"])
            }
        }
    }
    repositories {
        maven {
            isAllowInsecureProtocol = true
            url = uri("url")
            credentials {
                username = "username"
                password = "password"
            }
        }
    }
}
