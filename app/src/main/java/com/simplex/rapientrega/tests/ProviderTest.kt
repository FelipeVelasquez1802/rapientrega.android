package com.simplex.rapientrega.tests

import com.simplex.rapientrega.objects.Provider

class ProviderTest {
    fun providersList(): List<Provider> {
        var providers = ArrayList<Provider>()
        providers.add(
            Provider(
                1,
                "https://cdn6.aptoide.com/imgs/e/9/4/e942ecfcaa0970c64fa0f5379dc4b74b_icon.png?w=256",
                "KFC",
                "Restaurante",
                true,
                5000.0,
                10000.0
            )
        )
        providers.add(
            Provider(
                1,
                "https://www.clipartkey.com/mpngs/m/49-496021_fry-clipart-fry-mcdonalds-mcdonalds-french-fries-icon.png",
                "McDonalds",
                "Restaurante",
                false,
                5000.0,
                10000.0
            )
        )
        providers.add(
            Provider(
                1,
                "https://www.stickpng.com/assets/images/5842996fa6515b1e0ad75add.png",
                "Burger King",
                "Restaurante",
                true,
                5000.0,
                10000.0
            )
        )
        return providers
    }

    fun providersList2(): List<Provider> {
        var providers = ArrayList<Provider>()
        providers.add(
            Provider(
                1,
                "https://cdn6.aptoide.com/imgs/e/9/4/e942ecfcaa0970c64fa0f5379dc4b74b_icon.png?w=256",
                "KFC",
                "Drogueria",
                false,
                5000.0,
                10000.0
            )
        )
        providers.add(
            Provider(
                1,
                "https://www.clipartkey.com/mpngs/m/49-496021_fry-clipart-fry-mcdonalds-mcdonalds-french-fries-icon.png",
                "McDonalds",
                "Drogueria",
                false,
                5000.0,
                10000.0
            )
        )
        providers.add(
            Provider(
                1,
                "https://www.stickpng.com/assets/images/5842996fa6515b1e0ad75add.png",
                "Burger King",
                "Drogueria",
                true,
                5000.0,
                10000.0
            )
        )
        return providers
    }
}