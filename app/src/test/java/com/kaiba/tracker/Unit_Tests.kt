package com.kaiba.tracker

import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import org.junit.Test

import org.junit.Assert.*
import com.kaiba.tracker.api.*
import com.kaiba.tracker.data.YuGiOhCard
import kotlinx.coroutines.runBlocking

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Unit_Tests {
    @Test
    fun GetCardDarkMagicianTest() = runBlocking {
       var cardTest: List<YuGiOhCard?>?  = GetCards("Dark Magician")
        if (cardTest != null) {
            assert(!cardTest.isEmpty())
        }
    }
    @Test
    fun GetAllCardsToScrollAfterLogin() = runBlocking {
        var cardTest: List<YuGiOhCard?>?  = GetCard()
        if (cardTest != null) {
            assert(!cardTest.isEmpty())
        }
    }
}