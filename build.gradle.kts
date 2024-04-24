plugins {
    id("java")
}

group = "com.habitica"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.2")
    testImplementation("junit:junit:4.13.1")

    testImplementation("org.seleniumhq.selenium:selenium-firefox-driver:4.18.1")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.18.1")
    testImplementation("org.seleniumhq.selenium:selenium-support:4.18.1")

    testImplementation("javax.xml.bind:jaxb-api:2.3.1")
    testImplementation("com.sun.xml.bind:jaxb-impl:2.3.1")
    testImplementation("org.glassfish.jaxb:jaxb-runtime:2.3.1")
}

tasks.test {
    useJUnitPlatform()
}
