package com.jorfald.profiledesign

import android.graphics.drawable.Drawable
import java.io.Serializable

class User(
    val name: String,
    val photos: Int,
    var followers: Int,
    val following: Int,
    val email: String,
    val phoneNumber: String,
    val picture: Drawable?,
    val pictureResource: Int
) : Serializable