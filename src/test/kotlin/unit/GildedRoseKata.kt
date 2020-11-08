package unit

import gilded.rose.GildedRoseKata
import gilded.rose.item.Item
import gilded.rose.quality.management.QualityManagementFactory
import gilded.rose.quality.management.QualityManager
import gilded.rose.sell.management.SellManagementFactory
import gilded.rose.sell.management.SellManager
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito
import org.mockito.Mockito.*;

private fun <T> anyObject(): T = Mockito.any<T>() as T

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GildedRoseKataTest {

    private lateinit var kata: GildedRoseKata

    private lateinit var qualityManagementFactoryMock: QualityManagementFactory
    private lateinit var qualityManagerMock: QualityManager

    private lateinit var sellManagementFactoryMock: SellManagementFactory
    private lateinit var sellManagerMock: SellManager

    @BeforeAll
    fun setup() {
        qualityManagementFactoryMock = mock(QualityManagementFactory::class.java)
        qualityManagerMock = mock(QualityManager::class.java)
        Mockito.`when`(qualityManagementFactoryMock.getQualityManagerForItem(anyObject()))
            .thenReturn(qualityManagerMock)

        sellManagementFactoryMock = mock(SellManagementFactory::class.java)
        sellManagerMock = mock(SellManager::class.java)
        Mockito.`when`(sellManagementFactoryMock.getSellManagerForItem(anyObject()))
            .thenReturn(sellManagerMock)

        kata = GildedRoseKata(qualityManagementFactoryMock, sellManagementFactoryMock)
    }

    @Test
    fun `Should be possible to update items`() {
        val item = Item("randomName", 7, 10)
        val otherItem = Item("otherRandomName", 8, 15)
        kata.updateQualityFor(arrayOf(item, otherItem))

        Mockito.verify(qualityManagerMock).updateQualityFor(item)
        Mockito.verify(qualityManagerMock).updateQualityFor(otherItem)
        Assertions.assertEquals(2, mockingDetails(qualityManagerMock).invocations.size)

        Mockito.verify(sellManagerMock).updateSellInFor(item)
        Mockito.verify(sellManagerMock).updateSellInFor(otherItem)
        Assertions.assertEquals(2, mockingDetails(sellManagerMock).invocations.size)
    }
}