package com.example.twoforyou_allmighty.navigation

sealed class Screen(val route: String) {

    object MightyRecordScreen : Screen(route = "mighty_record_screen")

}
