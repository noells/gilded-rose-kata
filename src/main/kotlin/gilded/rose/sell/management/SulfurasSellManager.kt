package gilded.rose.sell.management

import gilded.rose.item.Item

class SulfurasSellManager: SellManager {
    override fun updateSellInFor(item: Item) {
        item.sellIn = item.sellIn
    }
}