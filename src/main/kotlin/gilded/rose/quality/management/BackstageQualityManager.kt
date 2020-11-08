package gilded.rose.quality.management

import gilded.rose.item.Item

class BackstageQualityManager : QualityManager {

    companion object {
        private const val HIGH_QUALITY_VARIATION = 3
        private const val MEDIUM_QUALITY_VARIATION = 2
        private const val REGULAR_QUALITY_VARIATION = 1
    }

    override fun updateQualityFor(item: Item) {
        item.quality = this.computeItemQuality(item)
    }

    private fun computeItemQuality(item: Item): Int {
        if (item.sellIn <= 0) {
            return 0
        }

        val value = item.quality + this.computeQualityVariationForItem(item)
        return value.coerceAtMost(MAX_ALLOWED_QUALITY)
    }

    private fun computeQualityVariationForItem(item: Item): Int {
        if (item.sellIn <= 5) {
            return HIGH_QUALITY_VARIATION
        } else if (item.sellIn <= 10) {
            return MEDIUM_QUALITY_VARIATION
        }

        return REGULAR_QUALITY_VARIATION
    }
}