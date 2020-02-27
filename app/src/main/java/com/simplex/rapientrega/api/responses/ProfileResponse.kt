package com.simplex.rapientrega.api.responses

import com.google.gson.annotations.SerializedName

class ProfileResponse(
    id: Int,
    isSuperUser: Boolean,
    username: String,
    email: String
)