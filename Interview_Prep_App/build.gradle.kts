buildscript {
    extra["compose_version"] = "1.0.1"
    extra["kotlin_version"] = "1.6.10"
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.1.3" apply false
    id("com.android.library") version "7.1.3" apply false
    id("org.jetbrains.kotlin.android") version "1.5.21" apply false
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}
