package com.pjkr.sunnyweather

/**
 * Created by root on 20.09.2017.
 */
interface PermissionInteraction {

    fun handleThePermission(requestCode: Int,
                            permissions: Array<String>,
                            grantResults: IntArray)
}