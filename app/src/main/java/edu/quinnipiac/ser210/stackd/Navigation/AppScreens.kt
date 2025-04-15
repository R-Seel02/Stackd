package edu.quinnipiac.ser210.stackd.Navigation

import okhttp3.Route

enum class AppScreens{
    Mainscreen,
    AlmanacScreen,
    SplitScreen,
    SettingScreen;
    companion object{
        fun fromRoute (route: String?): AppScreens
        = when(route?.substringBefore("/"))
        {
            Mainscreen.name -> Mainscreen
            SplitScreen.name -> SplitScreen
            AlmanacScreen.name -> AlmanacScreen
            SettingScreen.name -> SettingScreen
            null -> Mainscreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}
