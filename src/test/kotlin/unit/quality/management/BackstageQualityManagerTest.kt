package unit.quality.management

import gilded.rose.item.Item
import gilded.rose.quality.management.BackstageQualityManager
import gilded.rose.quality.management.QualityManager
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BackstageQualityManagerTest {
    private lateinit var qualityManager: QualityManager

    @BeforeAll
    fun `Given a backstage quality manager`() {
        qualityManager = BackstageQualityManager()
    }

    @Test
    fun `Should increase quality by one if more than 10 days to sell`() {
        val quality = 42
        val item = Item("Backstage Passes", 13, quality)
        qualityManager.updateQualityFor(item)

        Assertions.assertEquals(quality + 1, item.quality)
    }

    @Test
    fun `Should increase quality by two if 10 or less days to sell`() {
        val quality = 42
        val item = Item("Backstage Passes", 10, quality)
        qualityManager.updateQualityFor(item)

        Assertions.assertEquals(quality + 2, item.quality)
    }

    @Test
    fun `Should increase quality by three if 5 or less days to sell`() {
        val quality = 42
        val item = Item("Backstage Passes", 5, quality)
        qualityManager.updateQualityFor(item)

        Assertions.assertEquals(quality + 3, item.quality)
    }

    @Test
    fun `Should be zero if sellIn passes`() {
        val quality = 42
        val item = Item("Backstage Passes", 0, quality)
        qualityManager.updateQualityFor(item)

        Assertions.assertEquals(0, item.quality)
    }

    @Test
    fun `Should have a quality greater than maximum`() {
        val quality = 50
        val item = Item("Backstage Passes", 14, quality)
        qualityManager.updateQualityFor(item)

        Assertions.assertEquals(quality, item.quality)
    }
}