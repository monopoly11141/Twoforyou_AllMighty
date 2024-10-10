package com.example.twoforyou_allmighty.feature_record.presentation.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object TimeUtil {
    fun timeStampToTimeString(timeStamp: Long) : String {
        val format = SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.ENGLISH)
        return format.format(Date(timeStamp))
    }
}