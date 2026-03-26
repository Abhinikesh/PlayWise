package com.example.playwise

object VideoRepository {
    fun getVideosForSport(sport: String): List<VideoItem> {
        return when (sport.lowercase()) {
            "cricket" -> listOf(
                VideoItem("Batting Tutorial", "https://www.youtube.com/watch?v=xhVZ3KCMTfY", R.drawable.ic_bat),
                VideoItem("Bowling Tutorial", "https://www.youtube.com/watch?v=84G6P9p1T_I", R.drawable.ic_ball),
                VideoItem("Fielding Tutorial", "https://www.youtube.com/watch?v=N6OQ7z6mHwM", R.drawable.ic_field),
                VideoItem("Rules Explanation", "https://www.youtube.com/watch?v=q6_6v5V8S6E", R.drawable.ic_book),
                VideoItem("Highlights", "https://www.youtube.com/watch?v=2f3_56UqHl0", R.drawable.ic_play)
            )
            "football" -> listOf(
                VideoItem("Shooting Tutorial", "https://www.youtube.com/watch?v=M9Uv-kS0G4Y", R.drawable.ic_play),
                VideoItem("Dribbling Skills", "https://www.youtube.com/watch?v=vV7wO_mRzYk", R.drawable.ic_field),
                VideoItem("Rules of Football", "https://www.youtube.com/watch?v=H77Lh6R9m_A", R.drawable.ic_book)
            )
            "basketball" -> listOf(
                VideoItem("Shooting Form", "https://www.youtube.com/watch?v=TB_Oq9_B2M4", R.drawable.ic_ball),
                VideoItem("Dribbling Drills", "https://www.youtube.com/watch?v=2e_mGZ9S8Hk", R.drawable.ic_field),
                VideoItem("Rules of Basketball", "https://www.youtube.com/watch?v=wYjp2zoqQrs", R.drawable.ic_book)
            )
            "tennis" -> listOf(
                VideoItem("Forehand Technique", "https://www.youtube.com/watch?v=V6P3X_L_pI4", R.drawable.ic_bat),
                VideoItem("Backhand Basics", "https://www.youtube.com/watch?v=rT_8DDRfN7U", R.drawable.ic_bat),
                VideoItem("Rules of Tennis", "https://www.youtube.com/watch?v=XhZ_S6_I6Z8", R.drawable.ic_book)
            )
            "badminton" -> listOf(
                VideoItem("Service Tutorial", "https://www.youtube.com/watch?v=1uNTo_E_3Yw", R.drawable.ic_ball),
                VideoItem("Smash Technique", "https://www.youtube.com/watch?v=XhZ_S6_I6Z8", R.drawable.ic_play),
                VideoItem("Rules of Badminton", "https://www.youtube.com/watch?v=XhZ_S6_I6Z8", R.drawable.ic_book)
            )
            "volleyball" -> listOf(
                VideoItem("Serving Basics", "https://www.youtube.com/watch?v=D_vA89LpB3M", R.drawable.ic_ball),
                VideoItem("Rules of Volleyball", "https://www.youtube.com/watch?v=Yp9U-9U9f3M", R.drawable.ic_book)
            )
            "hockey" -> listOf(
                VideoItem("Dribbling Skills", "https://www.youtube.com/watch?v=8I9U-9U9f3M", R.drawable.ic_field),
                VideoItem("Rules of Hockey", "https://www.youtube.com/watch?v=6vG3j5o4e3I", R.drawable.ic_book)
            )
            "rugby" -> listOf(
                VideoItem("Tackling Technique", "https://www.youtube.com/watch?v=8I9U-9U9f3M", R.drawable.ic_field),
                VideoItem("Rules of Rugby", "https://www.youtube.com/watch?v=Yp9U-9U9f3M", R.drawable.ic_book)
            )
            else -> emptyList()
        }
    }
}
