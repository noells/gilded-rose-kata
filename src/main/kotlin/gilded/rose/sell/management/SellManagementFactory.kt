package gilded.rose.sell.management

import gilded.rose.item.Item

interface SellManagementFactory {
    fun getSellManagerForItem(item: Item): SellManager
}