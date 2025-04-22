package edu.quinnipiac.ser210.stackd.Navigation

import okhttp3.Route

enum class AppScreens{
    MainScreen,
    AlmanacScreen,
    SplitScreen,
    SettingScreen;
    companion object{
        fun fromRoute (route: String?): AppScreens
        = when(route?.substringBefore("/"))
        {
            MainScreen.name -> MainScreen
            SplitScreen.name -> SplitScreen
            AlmanacScreen.name -> AlmanacScreen
            SettingScreen.name -> SettingScreen
            null -> MainScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}
