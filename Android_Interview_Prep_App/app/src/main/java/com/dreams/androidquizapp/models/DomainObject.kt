package com.dreams.androidquizapp.models

import retrofit2.http.GET

interface DomainObject {
    fun getId(): Int?
    fun setId(id: Int?)
}
