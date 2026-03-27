package com.example.playwise

object VideoRepository {
    fun getVideosForSport(sport: String): List<VideoItem> {
        return when (sport.lowercase()) {
            "cricket" -> listOf(
                VideoItem("Batting Tutorial", "https://www.youtube.com/watch?v=UxX4IQL03UU", R.drawable.ic_bat),
                VideoItem("Bowling Tutorial", "https://www.youtube.com/watch?v=LxG36bHrc2o", R.drawable.ic_ball),
                VideoItem("Fielding Tutorial", "https://www.youtube.com/watch?v=FW_xU1AuHMc", R.drawable.ic_field),
                VideoItem("Rules Explanation", "https://www.youtube.com/watch?v=NZGLHdcw2RM", R.drawable.ic_book),
                VideoItem("Highlights", "https://www.youtube.com/watch?v=rpPCjyVfQOo", R.drawable.ic_play)
            )
            "football" -> listOf(
                VideoItem("Shooting Tutorial", "https://www.youtube.com/watch?v=AgrINZyoeeo", R.drawable.ic_play),
                VideoItem("Dribbling Skills", "https://www.youtube.com/watch?v=naEccnjzLxM", R.drawable.ic_field),
                VideoItem("Rules of Football", "https://www.youtube.com/watch?v=12fe1AXLGAU", R.drawable.ic_book)
            )
            "basketball" -> listOf(
                VideoItem("Shooting Form", "https://www.youtube.com/watch?v=x7anDE7OEww", R.drawable.ic_ball),
                VideoItem("Dribbling Drills", "https://www.youtube.com/watch?v=oADaM2L1YLc", R.drawable.ic_field),
                VideoItem("Rules of Basketball", "https://www.youtube.com/watch?v=wYjp2zoqQrs", R.drawable.ic_book)
            )
            "tennis" -> listOf(
                VideoItem("Forehand Technique", "https://www.youtube.com/watch?v=J96D3wqpd4E", R.drawable.ic_bat),
                VideoItem("Backhand Basics", "https://www.youtube.com/watch?v=WNnW9Dd2vMY", R.drawable.ic_bat),
                VideoItem("Rules of Tennis", "https://www.youtube.com/watch?v=jrhM3k84YJU", R.drawable.ic_book)
            )
            "badminton" -> listOf(
                VideoItem("Service Tutorial", "https://www.youtube.com/watch?v=cWPf3ZEdet0", R.drawable.ic_ball),
                VideoItem("Smash Technique", "https://www.youtube.com/watch?v=H7kpZ9inc10", R.drawable.ic_play),
                VideoItem("Rules of Badminton", "https://www.youtube.com/watch?v=UyLIi-TbcFc", R.drawable.ic_book)
            )
            "volleyball" -> listOf(
                VideoItem("Serving Basics", "https://www.youtube.com/watch?v=SnG7XJDunzs", R.drawable.ic_ball),
                VideoItem("Rules of Volleyball", "https://www.youtube.com/watch?v=OWCkPbzq81g", R.drawable.ic_book)
            )
            "hockey" -> listOf(
                VideoItem("Dribbling Skills", "https://www.youtube.com/watch?v=QH-swZZPNZY", R.drawable.ic_field),
                VideoItem("Rules of Hockey", "https://www.youtube.com/watch?v=M83C70ILng0", R.drawable.ic_book)
            )
            "rugby" -> listOf(
                VideoItem("Tackling Technique", "https://www.youtube.com/watch?v=uQ9iQe_-aWw", R.drawable.ic_field),
                VideoItem("Rules of Rugby", "https://www.youtube.com/watch?v=smnuRhNtT2E", R.drawable.ic_book)
            )
            else -> emptyList()
        }
    }
}
