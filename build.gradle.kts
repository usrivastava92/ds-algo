plugins {
    java
    id("com.diffplug.spotless") version "8.4.0"
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
        compileOnly("org.projectlombok:lombok:1.18.46")
        annotationProcessor("org.projectlombok:lombok:1.18.46")
        implementation("org.apache.commons:commons-lang3:3.20.0")
        implementation("org.apache.poi:poi:5.5.1")
        implementation("org.apache.poi:poi-ooxml:5.5.1")
        implementation("org.slf4j:slf4j-api:2.0.17")
        implementation("junit:junit:4.13.2")
        testImplementation("junit:junit:4.13.2")
        testCompileOnly("org.projectlombok:lombok:1.18.46")
        testAnnotationProcessor("org.projectlombok:lombok:1.18.46")
        if (project.name != "data-structures") {
            implementation(project(":data-structures"))
        }
    }

    apply(plugin = "com.diffplug.spotless")

    spotless {
        java {
            target("**/*.java")
            removeUnusedImports()
            cleanthat()
            googleJavaFormat()
        }
    }
}


// Task to install project-wide pre-commit hook for Spotless
tasks.register("installSpotlessHook") {
    doLast {
        val hookSrc = file(".githooks/pre-commit")
        val hookDest = file(".git/hooks/pre-commit")
        if (!hookSrc.exists()) {
            throw GradleException("Hook source does not exist: ${hookSrc}")
        }
        hookDest.parentFile.mkdirs()
        hookSrc.inputStream().use { input ->
            hookDest.outputStream().use { output ->
                input.copyTo(output)
            }
        }
        hookDest.setExecutable(true)
        println("Installed pre-commit hook to ${hookDest}")
    }
}
