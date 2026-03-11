plugins {
    java
}

allprojects {
    group = "com.coding"
    version = "1.0"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    dependencies {
        compileOnly("org.projectlombok:lombok:1.18.44")
        annotationProcessor("org.projectlombok:lombok:1.18.44")
        implementation("org.apache.commons:commons-lang3:3.20.0")
        implementation("org.apache.poi:poi:5.5.1")
        implementation("org.apache.poi:poi-ooxml:5.5.1")
        implementation("org.slf4j:slf4j-api:2.0.17")
        implementation("junit:junit:4.13.2")
        testImplementation("junit:junit:4.13.2")
        testCompileOnly("org.projectlombok:lombok:1.18.44")
        testAnnotationProcessor("org.projectlombok:lombok:1.18.44")
        if (project.name != "data-structures") {
            implementation(project(":data-structures"))
        }
    }
}
