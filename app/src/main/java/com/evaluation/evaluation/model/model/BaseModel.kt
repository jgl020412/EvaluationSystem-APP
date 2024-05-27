package com.evaluation.evaluation.model.model

data class BaseModel<T> (
    val `data`: T,
    val msg: String,
    val status: Int,
    val success: Boolean
)