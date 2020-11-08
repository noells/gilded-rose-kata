package gilded.rose.quality.management

import gilded.rose.item.Item

class DefaultQualityManagementFactory private constructor(
    private val defaultManager: QualityManager,
    private val managers: Map<String, QualityManager>
) : QualityManagementFactory {

    companion object {
        private const val AGED_BRIE_KEY = "Aged Brie"
        private const val SULFURAS_KEY = "Sulfuras"
        private const val BACKSTAGE_PASSES_KEY = "Backstage passes"
        private const val CONJURED_KEY = "Conjured"
        private fun buildQualityManagers(): Map<String, QualityManager> {
            val managers = HashMap<String, QualityManager>()
            managers[AGED_BRIE_KEY] = AgedBrieQualityManager()
            managers[SULFURAS_KEY] = SulfurasQualityManager()
            managers[BACKSTAGE_PASSES_KEY] = BackstageQualityManager()
            managers[CONJURED_KEY] = ConjuredQualityManager()
            return managers
        }

        fun of(): QualityManagementFactory {
            return DefaultQualityManagementFactory(DefaultQualityManager(), buildQualityManagers())
        }
    }

    override fun getQualityManagerForItem(item: Item): QualityManager {
        return this.managers.getOrDefault(item.name, this.defaultManager)
    }
}