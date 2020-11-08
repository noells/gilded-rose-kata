package gilded.rose.sell.management

import gilded.rose.item.Item

interface SellManager {
    fun updateSellInFor(item: Item)
}