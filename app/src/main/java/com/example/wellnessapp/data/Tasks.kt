package com.example.wellnessapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.wellnessapp.R

data class Tasks(
    @StringRes val topic: Int,
    val day: Int,
    @StringRes val description: Int,
    @DrawableRes val imageResourceId: Int
)

val tasks = listOf(
    Tasks(R.string.day1, 1, R.string.descrp1, R.drawable.day_1),
    Tasks(R.string.day2, 2, R.string.descrp2, R.drawable.day_2),
    Tasks(R.string.day3, 3, R.string.descrp3, R.drawable.day_3),
    Tasks(R.string.day4, 4, R.string.descrp4, R.drawable.day_4),
    Tasks(R.string.day5, 5, R.string.descrp5, R.drawable.day_5),
    Tasks(R.string.day6, 6, R.string.descrp6, R.drawable.day_6),
    Tasks(R.string.day7, 7, R.string.descrp7, R.drawable.day_7),
    Tasks(R.string.day8, 8, R.string.descrp8, R.drawable.day_8),
    Tasks(R.string.day9, 9, R.string.descrp9, R.drawable.day_9),
    Tasks(R.string.day10, 10, R.string.descrp10, R.drawable.day_10),
    Tasks(R.string.day11, 11, R.string.descrp11, R.drawable.day_11),
    Tasks(R.string.day12, 12, R.string.descrp12, R.drawable.day_12),
    Tasks(R.string.day13, 13, R.string.descrp13, R.drawable._0day_13),
    Tasks(R.string.day14, 14, R.string.descrp14, R.drawable._0day_14),
    Tasks(R.string.day15, 15, R.string.descrp15, R.drawable._0day_15),
    Tasks(R.string.day16, 16, R.string.descrp16, R.drawable._0day_16),
    Tasks(R.string.day17, 17, R.string.descrp17, R.drawable._0day_17),
    Tasks(R.string.day18, 18, R.string.descrp18, R.drawable._0day_18),
    Tasks(R.string.day19, 19, R.string.descrp19, R.drawable._0day_19),
    Tasks(R.string.day20, 20, R.string.descrp20, R.drawable._0day_20),
    Tasks(R.string.day21, 21, R.string.descrp21, R.drawable._0day_21),
    Tasks(R.string.day22, 22, R.string.descrp22, R.drawable._0day_22),
    Tasks(R.string.day23, 23, R.string.descrp23, R.drawable._0day_23),
    Tasks(R.string.day24, 24, R.string.descrp24, R.drawable._0day_24),
    Tasks(R.string.day25, 25, R.string.descrp25, R.drawable._0day_25),
    Tasks(R.string.day26, 26, R.string.descrp26, R.drawable._0day_26),
    Tasks(R.string.day27, 27, R.string.descrp27, R.drawable._0day_27),
    Tasks(R.string.day28, 28, R.string.descrp28, R.drawable._0day_28),
    Tasks(R.string.day29, 29, R.string.descrp29, R.drawable._0day_29),
    Tasks(R.string.day30, 30, R.string.descrp30, R.drawable._0day_30)
)
