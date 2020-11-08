package unit.quality.management

import gilded.rose.item.Item
import gilded.rose.quality.management.AgedBrieQualityManager
import gilded.rose.quality.management.QualityManager
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AgedBrieQualityManagerTest {
    private lateinit var qualityManager: QualityManager

    @BeforeAll
    fun `Given a aged brie quality manager`() {
        qualityManager = AgedBrieQualityManager()
    }

    @Test
    fun `Should increase quality by one each day`() {
        val quality = 3
        val item = Item("Aged Brie", 3, quality)
        qualityManager.updateQualityFor(item)

        Assertions.assertEquals(quality + 1, item.quality)
    }

    @Test
    fun `Should not increase quality if the maximum allowed has been reached`() {
        val quality = 50
        val item = Item("Aged Brie", 3, quality)
        qualityManager.updateQualityFor(item)

        Assertions.assertEquals(quality, item.quality)
    }
}