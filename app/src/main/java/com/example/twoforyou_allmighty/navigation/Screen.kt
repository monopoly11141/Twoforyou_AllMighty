package com.example.twoforyou_allmighty.navigation

sealed class Screen(val route: String) {

    data object MightyRecordScreen : Screen(route = "mighty_record_screen")

    data object RecordDetailScreen : Screen(route = "record_detail_screen")

}
