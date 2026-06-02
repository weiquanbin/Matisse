plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.parcelize)
    // ==================== [CUSTOM START] ====================
    // Description: 支持 Maven 本地或远端发布插件
    `maven-publish`
    // ==================== [CUSTOM END] ====================
}

android {
    namespace = "github.leavesczy.matisse"

    // ==================== [CUSTOM START] ====================
    // Description: 升级编译目标 sdk，并配置发布时自动包含源码包
    compileSdk = 36

    publishing {
        singleVariant("release") {
            // 内置方法：自动将源码打包成 sources.jar 并附带发布，不再需要手写 Task
            withSourcesJar()
        }
    }
    // ==================== [CUSTOM END] ====================
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.compose)
    compileOnly(libs.coil.compose)
    compileOnly(libs.glide.compose)

    // ==================== [CUSTOM START] ====================
    // Description: 引入 Compose 核心组件支持以满足定制 Widget 渲染需求
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material.icons.extended)
    implementation(libs.androidx.compose.material3)
    // ==================== [CUSTOM END] ====================
}

// ==================== [CUSTOM START] ====================
// Description: 本地或远端 Maven 仓库发布策略配置
publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.yishi"
            artifactId = "matisse"
            version = "0.0.14.8"
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
// ==================== [CUSTOM END] ====================
