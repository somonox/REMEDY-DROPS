import org.gradle.kotlin.dsl.implementation

plugins {
    java
    id("org.springframework.boot") version "3.5.6"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "hs.bssm.somonox"
version = "0.0.1-SNAPSHOT"
description = "REMEDY-DROPS"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.hibernate.orm:hibernate-spatial:6.5.2.Final")
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.locationtech.jts:jts-core:1.19.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
