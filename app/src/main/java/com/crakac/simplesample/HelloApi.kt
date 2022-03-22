package com.crakac.simplesample

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

interface Mastodon {
    @GET("/api/v1/instance")
    suspend fun getInformation(): Response<Instance>
}

data class Instance(
    @SerializedName("uri")
    val uri: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("short_description")
    val shortDescription: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("version")
    val version: String = "",
    @SerializedName("languages")
    val languages: List<String> = emptyList(),
    @SerializedName("registrations")
    val registrations: Boolean = false,
    @SerializedName("approval_required")
    val approvalRequired: Boolean = false,
    @SerializedName("invites_enabled")
    val invitesEnabled: Boolean = false,
    @SerializedName("urls")
    val streamingApi: StreamingApi = StreamingApi(),
    @SerializedName("stats")
    val stats: Stats = Stats(),
    @SerializedName("user_count")
    val userCount: Long = 0L,
    @SerializedName("status_count")
    val statusCount: Long = 0L,
    @SerializedName("domain_count")
    val domainCount: Long = 0L,
    @SerializedName("thumbnail")
    val thumbnail: String? = null,
    @SerializedName("contact_account")
    val contactAccount: Account? = null,
) {
    data class StreamingApi(
        @SerializedName("streaming_api")
        val endpoint: String = ""
    )

    data class Stats(
        @SerializedName("user_count")
        val userCount: Long = 0L,

        @SerializedName("status_count")
        val statusCount: Long = 0L,

        @SerializedName("domain_count")
        val domainCount: Long = 0L
    )
}

data class Account(
    @SerializedName("id")
    val id: Long = 0L,
    @SerializedName("username")
    val username: String = "",
    @SerializedName("acct")
    val acct: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("display_name")
    val displayName: String = "",
    @SerializedName("note")
    val note: String = "",
    @SerializedName("avatar")
    val avatar: String = "",
    @SerializedName("avatar_static")
    val avatarStatic: String = "",
    @SerializedName("header")
    val header: String = "",
    @SerializedName("header_static")
    val headerStatic: String = "",
    @SerializedName("locked")
    val locked: String = "",
    @SerializedName("emojis")
    val emojis: List<Emoji> = emptyList(),
    @SerializedName("discoverable")
    val discoverable: Boolean = false,
    @SerializedName("created_at")
    val createdAt: String = "",
    @SerializedName("last_status_at")
    val lastStatusAt: String = "",
    @SerializedName("statuses_count")
    val statusesCount: Long = 0L,
    @SerializedName("followers_count")
    val followersCount: Long = 0L,
    @SerializedName("following_count")
    val followingCount: Long = 0L,
    @SerializedName("moved")
    val moved: Account? = null,
    @SerializedName("fields")
    val fields: List<Field> = emptyList(),
    @SerializedName("bot")
    val bot: Boolean = false,
    @SerializedName("source")
    val source: Source? = null,
    @SerializedName("suspended")
    val suspended: Boolean = false,
    @SerializedName("mute_expires_at")
    val muteExpiresAt: String = "",
)

data class Emoji(
    @SerializedName("shortcode")
    val shortcode: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("static_url")
    val staticUrl: String = "",
    @SerializedName("visible_in_picker")
    val visibleInPicker: Boolean = false,
    @SerializedName("category")
    val category: String = "",
)

data class Field(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("value")
    val value: String = "",
    @SerializedName("verified_at")
    val verifiedAt: String = "",
)

data class Source(
    @SerializedName("note")
    val note: String = "",
    @SerializedName("fields")
    val fields: List<Field> = emptyList(),
    @SerializedName("privacy")
    val privacy: String = "",
    @SerializedName("sensitive")
    val sensitive: Boolean = false,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("follow_requests_count")
    val followRequestsCount: Int = 0,
)

