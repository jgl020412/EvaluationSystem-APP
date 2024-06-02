package com.evaluation.evaluation.model.model

data class EvaluationModel(
    val id: String,
    val name: String,
    val serviceId: String,
    val userId: String,
    val content: String,
    val level: Int,
    val time: String
)