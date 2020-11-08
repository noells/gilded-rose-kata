package unit.quality.management

import gilded.rose.item.Item
import gilded.rose.quality.management.DefaultQualityManager
import gilded.rose.quality.management.QualityManager
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DefaultQualityManagerTest {

    private lateinit var qualityManager: QualityManager

    @BeforeAll
    fun `Given a default quality manager`() {
        qualityManager = DefaultQualityManager()
    }

    @Test
    fun `Should decrease quality by one each day before the SellIn time`() {
        val quality = 3
        val item = Item("regular", 3, quality)
        qualityManager.updateQualityFor(item)

        Assertions.assertEquals(quality - 1, item.quality)
    }

    @Test
    fun `Should decrease quality by two each day before the SellIn time`() {
        val quality = 3
        val item = Item("regular", -1, quality)
        qualityManager.updateQualityFor(item)

        Assertions.assertEquals(quality - 2, item.quality)
    }
}