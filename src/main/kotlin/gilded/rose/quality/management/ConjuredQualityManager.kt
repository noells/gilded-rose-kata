package gilded.rose.quality.management

import gilded.rose.item.Item

class ConjuredQualityManager : QualityManager {
    override fun updateQualityFor(item: Item) {
        item.quality = item.quality - 2
    }
}