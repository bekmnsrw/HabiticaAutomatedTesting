plugins {
    id("java")
}

group = "com.habitica"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.seleniumhq.selenium:selenium-firefox-driver:4.18.1")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.18.1")
    testImplementation("org.seleniumhq.selenium:selenium-support:4.18.1")
}

tasks.test {
    useJUnitPlatform()
}
