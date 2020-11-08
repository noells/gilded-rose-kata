package gilded.rose.quality.management

import gilded.rose.item.Item

interface QualityManagementFactory {
    fun getQualityManagerForItem(item: Item): QualityManager
}