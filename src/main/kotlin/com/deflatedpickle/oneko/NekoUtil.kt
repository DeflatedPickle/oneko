package com.deflatedpickle.oneko

object NekoUtil {
    fun frameToName(index: Int) =
        when (index) {
            32 -> "awake"
            9 -> "down1"
            10 -> "down2"
            21 -> "dtogi1"
            22 -> "dtogi2"
            11 -> "dwleft1"
            12 -> "dwleft2"
            7 -> "dwright1"
            8 -> "dwright2"
            31 -> "jare2"
            27 -> "kaki1"
            28 -> "kaki2"
            13 -> "left1"
            14 -> "left2"
            23 -> "ltogi1"
            24 -> "ltogi2"
            25 -> "mati2"
            26 -> "mati3"
            5 -> "right1"
            6 -> "right2"
            19 -> "rtogi1"
            20 -> "rtogi2"
            29 -> "sleep1"
            30 -> "sleep2"
            1 -> "up1"
            2 -> "up2"
            15 -> "upleft1"
            16 -> "upleft2"
            3 -> "upright1"
            4 -> "upright2"
            17 -> "utogi1"
            18 -> "utogi2"
            else -> ""
        }

    fun packToCursor(pack: String) = when (pack) {
        "bsd" -> "bsd"
        "dog" -> "bone"
        "neko" -> "mouse"
        "sakura" -> "petal"
        "tomoyo" -> "card"
        "tora" -> "mouse"
        else -> ""
    }
}