package gilded.rose

import gilded.rose.item.Item
import gilded.rose.quality.management.QualityManagementFactory
import gilded.rose.sell.management.SellManagementFactory

fun <T> T.pipe(vararg functions: (T) -> T): T {
    return functions.fold(this) { value, f -> f(value) }
}

class GildedRoseKata(
    private val qualityManagementFactory: QualityManagementFactory,
    private val sellManagementFactory: SellManagementFactory
) {

    fun updateQualityFor(items: Array<Item>): Array<Item> {
        return items.map { item ->
            item.pipe(
                {this.updateQualityForItem(it)},
                {this.updateSellInForItem(it)}
            )
        }.toTypedArray()
    }

    private fun updateQualityForItem(item: Item): Item {
        this.qualityManagementFactory.getQualityManagerForItem(item).updateQualityFor((item))
        return item
    }

    private fun updateSellInForItem(item: Item): Item {
        this.sellManagementFactory.getSellManagerForItem(item).updateSellInFor(item)
        return item
    }
}