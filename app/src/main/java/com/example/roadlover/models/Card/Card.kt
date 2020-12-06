package com.example.roadlover.models.Card

data class Card(
    val certificationRequiredForPublish: Boolean,
    val certificationRequiredForPublishRemarks: Any,
    val certificationRequiredForUser: Boolean,
    val endDate: String,
    val id: Int,
    val productActive: Boolean,
    val productAmount: Int,
    val productCategoryId: Int,
    val productCustomerList: String,
    val productFeatures: String,
    val productModuleList: String,
    val productSubCategoryId: Int,
    val productTypeId: String,
    val recommandationRequiredForPublish: Boolean,
    val recommandationRequiredForPublishRemarks: Any,
    val regUserId: Int,
    val regUserProductDescription: String,
    val regUserProductImage: String,
    val regUserProductName: String,
    val requirements: String,
    val skillRequired: Boolean,
    val startDate: String,
    val trainingRequiredForUser: Boolean
)