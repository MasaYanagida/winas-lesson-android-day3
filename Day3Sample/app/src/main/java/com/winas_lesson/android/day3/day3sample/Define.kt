package com.winas_lesson.android.day3.day3sample

import android.graphics.Color

enum class ActivityExtraData(val key: String) {
    SAMPLE_NUMBER("sample_number"), CONTENT("content");
}

enum class ActivityResultData(val key: String) {
    SAMPLE_NUMBER("sample_number");
}

enum class ActivityRequestCode(val code: Int) {
    CUSTOM_UI(11111);
}

enum class ActivityResultCode(val code: Int) {
    CUSTOM_UI(1111);
}

// MARK: - BrandIcon

enum class BrandIcon(val key: Int) {
    TWITTER(1), REDDIT(2), INSTAGRAM(3), SNAPCHAT(4), LINE(5), WHATSAPP(6);
    val resourceId: Int
        get() {
            return when (this) {
                TWITTER -> R.string.icon_brand_twitter
                REDDIT -> R.string.icon_brand_reddit
                INSTAGRAM -> R.string.icon_brand_instagram
                SNAPCHAT -> R.string.icon_brand_snapchat
                LINE -> R.string.icon_brand_line
                WHATSAPP -> R.string.icon_brand_whatsapp
            }
        }
    val color: Int
        get() {
            return when (this) {
                TWITTER -> Color.parseColor("#55acee")
                REDDIT -> Color.parseColor("#ff4500")
                INSTAGRAM -> Color.parseColor("#c13584")
                SNAPCHAT -> Color.parseColor("#fffc00")
                LINE -> Color.parseColor("#1dcd00")
                WHATSAPP -> Color.parseColor("#25d366")
            }
        }
    val title: String
        get() {
            return when (this) {
                TWITTER -> "Twitter"
                REDDIT -> "Reddit"
                INSTAGRAM -> "Instagram"
                SNAPCHAT -> "Snapchat"
                LINE -> "LINE"
                WHATSAPP -> "WhatsApp"
            }
        }
    val url: String
        get() {
            return when (this) {
                TWITTER -> "https://twitter.com"
                REDDIT -> "https://www.reddit.com"
                INSTAGRAM -> "https://www.instagram.com"
                SNAPCHAT -> "https://www.snapchat.com"
                LINE -> "https://line.me"
                WHATSAPP -> "https://www.whatsapp.com"
            }
        }
}
