package com.jorfald.profiledesign

import java.io.Serializable

class User(
    val name: String,
    val photos: Int,
    var followers: Int,
    val following: Int,
    val email: String,
    val phoneNumber: String,
    val pictureResource: Int
) : Serializable