import com.android.build.gradle.AppExtension

val android = project.extensions.getByType(AppExtension::class.java)

android.apply {
    flavorDimensions("flavor-type")

    productFlavors {
        create("mazda") {
            dimension = "flavor-type"
            applicationId = "com.example.mazda"
            resValue(type = "string", name = "app_name", value = "Mazda App")
            signingConfig = signingConfigs.getByName("mazdaConfig")
        }
        create("nissan") {
            dimension = "flavor-type"
            applicationId = "com.example.nissan"
            resValue(type = "string", name = "app_name", value = "Nissan App")
            signingConfig = signingConfigs.getByName("nissanConfig")
        }
    }
}