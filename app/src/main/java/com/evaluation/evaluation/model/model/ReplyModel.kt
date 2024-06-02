package com.evaluation.evaluation.model.model

data class ReplyModel (
    val id: String,
    val userId: String,
    val fatherId: String,
    val evaluationId: String,
    val content: String,
    val time: String,
    val fatherContent: String,
    val isAdmin: Int,
    val fatherUserId: String,
)