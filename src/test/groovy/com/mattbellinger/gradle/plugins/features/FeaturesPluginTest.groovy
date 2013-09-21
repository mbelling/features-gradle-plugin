import com.mattbellinger.gradle.plugins.features.FeaturesPluginExtension
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.testng.Assert.assertTrue
import static org.testng.AssertJUnit.assertEquals

class FeaturesPluginTest {
    @Test
    public void featuresPluginAddsFeaturesExtensionToProject() {
        Project project = ProjectBuilder.builder().withName("testProject").build()
        project.version = "1.0"

        project.apply plugin: 'features'

        assertTrue(project.extensions.features instanceof FeaturesPluginExtension)
        assertEquals("testProject", project.extensions.features.name)
        assertEquals("1.0", project.extensions.features.version)

        project.extensions.features.name = "newTestProject"

        assertEquals("newTestProject", project.extensions.features.name)
    }
}