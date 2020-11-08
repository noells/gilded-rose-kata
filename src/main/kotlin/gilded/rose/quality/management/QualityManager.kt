package gilded.rose.quality.management

import gilded.rose.item.Item

const val MAX_ALLOWED_QUALITY = 50

interface QualityManager {
    fun updateQualityFor(item: Item)
}