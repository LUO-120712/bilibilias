plugins {
    alias(libs.plugins.bilibilias.multiplatform.library)
    alias(libs.plugins.bilibilias.multiplatform.koin)
    alias(libs.plugins.ksp)
}

kotlin {
    android {
        namespace = "com.imcys.bilibilias.shared"
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ASShared"
            isStatic = true
            export(project(":core:data"))
            transitiveExport = true
        }
    }

    sourceSets {
        commonMain {
            kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
            dependencies {
                implementation(libs.kmp.androidx.lifecycle.runtimeCompose)
                implementation(libs.kmp.androidx.lifecycle.viewmodel)
                api(project(":core:data"))
                api(project(":core:common"))
            }
        }
    }

}
dependencies {
    add("kspCommonMainMetadata", project(":core:ksp-processor"))
}
