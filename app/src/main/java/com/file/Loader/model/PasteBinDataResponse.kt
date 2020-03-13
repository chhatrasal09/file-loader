package com.file.Loader.model

data class PasteBinDataResponse(
    val categories: List<Category>? = null,
    val color: String? = null,
    val created_at: String? = null,
    val current_user_collections: List<Any>? = null,
    val height: Int = 0,
    val id: String?= null,
    val liked_by_user: Boolean = false,
    val likes: Int = 0,
    val links: Links? = null,
    val urls: Urls? = null,
    val user: User? = null,
    val width: Int = 0
)