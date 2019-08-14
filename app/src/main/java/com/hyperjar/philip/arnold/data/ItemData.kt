package com.hyperjar.philip.arnold.data

data class ItemData(
    val id: String,
    val legalProfile: LegalProfile,
    val publicIdentifier: Int,
    val transactionLog: TransactionLog
)