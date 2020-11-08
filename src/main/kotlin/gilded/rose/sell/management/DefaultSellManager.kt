package gilded.rose.sell.management

import gilded.rose.item.Item

class DefaultSellManager: SellManager {
    override fun updateSellInFor(item: Item) {
        item.sellIn--
    }
}