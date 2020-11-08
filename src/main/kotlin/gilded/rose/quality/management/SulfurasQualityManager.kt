package gilded.rose.quality.management

import gilded.rose.item.Item

class SulfurasQualityManager : QualityManager {
    companion object {
        private const val SULFURAS_DEFAULT_QUALITY = 80
    }

    override fun updateQualityFor(item: Item) {
        item.quality = SULFURAS_DEFAULT_QUALITY
    }
}