package unit.quality.management

import gilded.rose.item.Item
import gilded.rose.quality.management.ConjuredQualityManager
import gilded.rose.quality.management.QualityManager
import gilded.rose.quality.management.SulfurasQualityManager
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ConjuredQualityManagerTest {
    private lateinit var qualityManager: QualityManager

    @BeforeAll
    fun `Given a sulfuras quality manager`() {
        qualityManager = ConjuredQualityManager()
    }

    @Test
    fun `Quality should decrease by two`() {
        val quality = 42
        val item = Item("Sulfuras", 3, quality)
        qualityManager.updateQualityFor(item)

        Assertions.assertEquals(quality -2 , item.quality)
    }
}

