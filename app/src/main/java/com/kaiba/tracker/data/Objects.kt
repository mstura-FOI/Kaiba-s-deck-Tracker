package com.kaiba.tracker.data

data class DataCard(
    var data: List<YuGiOhCard>
)

data class YuGiOhCard(
    val id: Int,
    val name: String,
    val type: String,
    val frameType: String,
    val description: String,
    val attack: Int,
    val defense: Int,
    val level: Int,
    val race: String,
    val attribute: String,
    val archetype: String,
    val ygoprodeckUrl: String,
    val card_images: List<CardImage>,
    val card_prices: List<CardPrice>
)

data class CardImage(
    val id: Int,
    val imageUrl: String,
    val imageUrlSmall: String,
    val image_url_cropped: String
)

data class CardPrice(
    val cardmarket_price: String,
    val tcgplayer_price: String,
    val ebayPrice: String,
    val amazonPrice: String,
    val coolstuffincPrice: String
)
