package com.hyperjar.philip.arnold.data

data class ItemX(
    val amount: Amount,
    val financialDestination: FinancialDestination,
    val financialSource: FinancialSource,
    val id: String,
    val postedTime: Long,
    val status: String,
    val transactionTime: Long
)