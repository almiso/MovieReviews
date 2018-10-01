package org.almiso.nyt.moview.reviews.objects

import com.google.gson.annotations.SerializedName

open class Review {
    @SerializedName("display_title") var displayTitle: String? = null
    @SerializedName("byline") var byline: String? = null
    @SerializedName("headline") var headline: String? = null
    @SerializedName("summary_short") var summaryShort: String? = null
    @SerializedName("publication_date") var date: String? = null
    @SerializedName("multimedia") var image: Multimedia? = null
    @SerializedName("link") var link: Link? = null

    open class Link {
        @SerializedName("type") var type: String? = null
        @SerializedName("url") var url: String? = null
        @SerializedName("suggested_link_text") var text: String? = null
    }

    open class Multimedia {
        @SerializedName("type") var type: String? = null
        @SerializedName("src") var src: String? = null
        @SerializedName("width") var width: Int? = null
        @SerializedName("height") var height: Int? = null
    }
}
