package com.twoninelab.signboard

import android.app.Activity
import android.content.Context
import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat

class FontClass {

//    listOf("MontSerrat", "MontSerrat-Bold", "Monoton", "PressStart", "Raleway-Dots", "Bungee")
    fun getTextFont(activity: Activity,font: String) : Typeface? {

        var fontM:Typeface? = ResourcesCompat.getFont(activity,R.font.montserrat_regular)

        if(font == "Montserrat"){
            fontM = ResourcesCompat.getFont(activity,R.font.montserrat_regular)
        } else if(font == "MontSerrat-Bold"){
            fontM = ResourcesCompat.getFont(activity,R.font.montserrat_bold)
        } else if(font == "Monoton"){
            fontM = ResourcesCompat.getFont(activity,R.font.monoton_regular)
        }else if(font == "PressStart"){
            fontM = ResourcesCompat.getFont(activity,R.font.pressstart_regular)
        }else if(font == "Raleway-Dots"){
            fontM = ResourcesCompat.getFont(activity,R.font.ralewaydots_regular)
        }else if(font == "Bungee"){
            fontM = ResourcesCompat.getFont(activity,R.font.bungee_regular)
        }

        return fontM
    }

    fun fontList() : MutableList<*>?{
        return mutableListOf("MontSerrat", "MontSerrat-Bold", "Monoton", "PressStart", "Raleway-Dots", "Bungee")
    }
}