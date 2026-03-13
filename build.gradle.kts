plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")

    // RestAssured
    testImplementation("io.rest-assured:rest-assured:5.4.0")

    // JSON Path (usado pelo RestAssured)
    testImplementation("io.rest-assured:json-path:5.4.0")

}

tasks.test {
    useJUnitPlatform()
}
