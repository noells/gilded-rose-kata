package gilded.rose.quality.management

import gilded.rose.item.Item

class AgedBrieQualityManager : QualityManager {
    override fun updateQualityFor(item: Item) {
        item.quality = this.computeItemQuality(item)
    }

    private fun computeItemQuality(item: Item): Int {
        return (item.quality + 1).coerceAtMost(MAX_ALLOWED_QUALITY)
    }
}