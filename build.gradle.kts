import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("com.diffplug.spotless") version "6.22.0"
    id("org.jetbrains.kotlin.jvm") version "2.0.0-Beta1"
    id("scala")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://www.seasar.org/maven/maven2/")
    }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    testImplementation("org.scalatest:scalatest_3:3.2.17")

    implementation("io.vavr:vavr:0.10.4")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    // implementation("org.scala-lang:scala-library:2.13.12")
    implementation("org.scala-lang:scala3-library_3:3.6.1")
    implementation("org.jetbrains:annotations:24.1.0")
    implementation("org.seasar.util:s2util:0.0.1")
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    ext {
        set("vendor", JvmVendorSpec.ADOPTIUM)
    }
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
        vendor = JvmVendorSpec.ADOPTIUM
    }
    withSourcesJar()
}

scala {
    zincVersion = "1.9.3"
}

tasks {
    withType<ScalaCompile>().configureEach {
        scalaCompileOptions.apply {
            additionalParameters = listOf("-feature", "_")
        }
    }

    withType<Test> {
        useJUnitPlatform()
        outputs.upToDateWhen { false }
        testLogging {
            showStandardStreams = true
            events = setOf(TestLogEvent.STARTED, TestLogEvent.SKIPPED, TestLogEvent.PASSED, TestLogEvent.FAILED)
            exceptionFormat = TestExceptionFormat.FULL
        }
    }

    withType<Wrapper> {
        gradleVersion = "8.4"
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs.add("-Xlint:deprecation")
    }
}

spotless {
    java {
        googleJavaFormat()
    }
    kotlin {
        ktfmt()
    }
    kotlinGradle {
        target("*.gradle.kts")
        ktlint()
    }
    scala {
        scalafmt()
    }
}
