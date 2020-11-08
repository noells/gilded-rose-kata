package gilded.rose.sell.management

import gilded.rose.item.Item

class DefaultSellManagementFactory private constructor(
    private val defaultManager: SellManager,
    private val sulfurasSellManager: SellManager
): SellManagementFactory {

    companion object{
        private const val SULFURAS_NAME = "Sulfuras"
        fun of(): DefaultSellManagementFactory {
            val defaultManager = DefaultSellManager()
            val sulfurasSellManager = SulfurasSellManager()
            return DefaultSellManagementFactory(defaultManager, sulfurasSellManager)
        }
    }

    override fun getSellManagerForItem(item: Item): SellManager {
        return if(item.name == SULFURAS_NAME) this.sulfurasSellManager else this.defaultManager
    }
}