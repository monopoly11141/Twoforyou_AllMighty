package com.example.twoforyou_allmighty.feature_record.ui.screen

sealed class Screen(val route: String) {

    data object RecordScreen : Screen(route = "record_screen")

    data object RecordDetailScreen : Screen(route = "record_detail_screen")

}
