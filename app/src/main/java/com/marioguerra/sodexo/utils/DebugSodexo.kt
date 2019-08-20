package com.marioguerra.sodexo.utils

import android.util.Log

/**
 * @author Mario Guerra on 20/08/2018
 */

class DebugSodexo{

    companion object {
        var enable = true
    }

    class Log{
        companion object {
            fun i(tag : String, message : String){
                if (enable)
                    android.util.Log.i(tag, message)
            }

            fun e(tag : String, message : String){
                if (enable)
                    android.util.Log.e(tag, message)
            }
        }
    }
}