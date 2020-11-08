package gilded.rose.quality.management

import gilded.rose.item.Item

class DefaultQualityManager : QualityManager {
    companion object {
        private const val DEFAULT_QUALITY_LOST = 1
    }

    override fun updateQualityFor(item: Item) {
        item.quality = this.computeItemQuality(item)
    }

    private fun computeItemQuality(item: Item): Int {
        if (item.quality - this.computeQualityLost(item) < 0) {
            return 0
        }

        return item.quality - this.computeQualityLost(item)
    }

    private fun computeQualityLost(item: Item): Int {
        return if (item.sellIn < 0) DEFAULT_QUALITY_LOST * 2 else DEFAULT_QUALITY_LOST
    }
}