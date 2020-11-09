package ru.mvlikhachev.stopdrinkmvvm.utilits

import android.util.Log
import android.widget.Toast
import java.text.ParseException
import java.text.SimpleDateFormat

fun showToast(message: String) {
    Toast.makeText(APP_ACTIVITY, message, Toast.LENGTH_SHORT).show()
}

// Метот расчитывает время с даты последнего употребления алкоголя до текущего момента
fun calculateTimeWithoutDrink(date: String?): Array<String>? {
    val result = arrayOf("10", "00", "00")
    val format = SimpleDateFormat("dd.MM.yyyy")
    var timeUp: Long = 0
    try {
        timeUp = format.parse(date).time
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    val diff = System.currentTimeMillis() - timeUp

    val diffMinutes = diff / (60 * 1000) % 60
    val diffHours = diff / (60 * 60 * 1000) % 24
    val diffDays = diff / (24 * 60 * 60 * 1000)

    Log.d("testDateUtil", "Прилетело: $date")
    Log.d("testDateUtil", "Текущая: ${System.currentTimeMillis()}")
    Log.d("testDateUtil", "timeUp: $timeUp")
    Log.d("testDateUtil", "diff: $diff")
    Log.d("testDateUtil", "days: $diffDays")
    Log.d("testDateUtil", "hours: $diffHours")
    Log.d("testDateUtil", "minutes: $diffMinutes")


    // Проверка если минуты и секунды меньше 10 - выполняем форматирование, чтоб красиво отображалось во вью
    var hoursString = ""
    var minutesString = ""
    val daysString = diffDays.toString()
    hoursString = if (diffHours < 10) {
        "0$diffHours"
    } else {
        diffHours.toString()
    }
    minutesString = if (diffMinutes < 10) {
        "0$diffMinutes"
    } else {
        diffMinutes.toString()
    }
    result[0] = daysString
    result[1] = hoursString
    result[2] = minutesString
    return result
}