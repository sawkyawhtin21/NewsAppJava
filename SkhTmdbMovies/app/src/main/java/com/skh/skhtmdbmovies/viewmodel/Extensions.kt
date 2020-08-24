package com.skh.skhtmdbmovies.viewmodel

import java.text.SimpleDateFormat
import java.util.*

fun toSimpleString(publishedAt: String): String{
  val inputFormat = SimpleDateFormat(
   "yyyy-MM-dd'T'HH:mm:ss'Z'",
    Locale.ENGLISH
  )
      val outputFormat = SimpleDateFormat(
      "EEE, dd MM yyyy",
       Locale.getDefault()
      )
    val date = inputFormat.parse(publishedAt)
    return outputFormat.format(date)
}