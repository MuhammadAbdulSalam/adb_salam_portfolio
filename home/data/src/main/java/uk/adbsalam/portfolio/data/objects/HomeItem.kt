package uk.adbsalam.portfolio.data.objects

import androidx.compose.runtime.Stable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import javax.annotation.concurrent.Immutable

@Immutable
@Stable
@JsonClass(generateAdapter = true)
data class HomeItems(
    @Json(name = "home") val home: List<HomeItem>
) {
    @JsonClass(generateAdapter = true)
    data class HomeItem(
        @Json(name = "tags") val tags: List<String>,
        @Json(name = "title") val title: String,
        @Json(name = "type") val type: String,
        @Json(name = "res") val res: String,
        @Json(name = "body") val body: String,
        @Json(name = "deeplink") val deeplink: String
    )
}
