package com.example.videoplayer.player

data class PlayBean(
        val id: String,
        var streamId: String = "",
        var playType: PlayType? = PlayType.CONTEST,
        var url: String="",
        var candidateName: String="Host Name ",
        var description: String = " blah blah"
)


enum class PlayType {
        CONTEST,
        TRAILER,
        HOST,
}
