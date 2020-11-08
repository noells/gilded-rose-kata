package acceptance

import gilded.rose.GildedRoseKata
import gilded.rose.item.Item
import gilded.rose.quality.management.DefaultQualityManagementFactory
import gilded.rose.quality.management.QualityManagementFactory
import gilded.rose.sell.management.DefaultSellManagementFactory
import gilded.rose.sell.management.SellManagementFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GildedRoseKataAcceptance {

    private lateinit var kata: GildedRoseKata
    private lateinit var items: Array<Item>

    private lateinit var qualityManagementFactory: QualityManagementFactory
    private lateinit var sellManagementFactory: SellManagementFactory

    @BeforeAll
    fun `Given a list of Items`() {
        qualityManagementFactory = DefaultQualityManagementFactory.of()
        sellManagementFactory = DefaultSellManagementFactory.of()
        kata = GildedRoseKata(qualityManagementFactory, sellManagementFactory)

        items = arrayOf(
            Item("Barceló", 10, 23),
            Item("Potatoes", 3, 16),
            Item("Aged Brie", 15, 42),
            Item("Sulfuras", 0, 0),
            Item("Backstage passes", 4, 34),
            Item("Conjured", 7, 21)
        )
    }

    @Test
    fun `Should update the items correctly`() {
        val updatedItems = kata.updateQualityFor(items)
        val expectedItems = arrayOf(
            Item("Barceló", 9, 22),
            Item("Potatoes", 2, 15),
            Item("Aged Brie", 14, 43),
            Item("Sulfuras", 0, 80),
            Item("Backstage passes", 3, 37),
            Item("Conjured", 6, 19)
        )

        Assertions.assertTrue(
            expectedItems.size == updatedItems.size && expectedItems.contentDeepEquals(updatedItems) && updatedItems.contentDeepEquals(
                expectedItems
            )
        )

    }
}
