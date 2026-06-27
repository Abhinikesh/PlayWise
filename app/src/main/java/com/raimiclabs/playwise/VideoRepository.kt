package com.raimiclabs.playwise

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
            "golf" -> listOf(
                VideoItem("Golf Swing for Beginners", "https://www.youtube.com/watch?v=RXiS99Xp4kI", R.drawable.ic_play),
                VideoItem("Putting Basics", "https://www.youtube.com/watch?v=mD_37I8n0jY", R.drawable.ic_play),
                VideoItem("Rules of Golf", "https://www.youtube.com/watch?v=6m89KREq7O4", R.drawable.ic_book)
            )
            "handball" -> listOf(
                VideoItem("Handball Basics", "https://www.youtube.com/watch?v=680XjU5jV0g", R.drawable.ic_ball),
                VideoItem("Rules of Handball", "https://www.youtube.com/watch?v=pDofj4pI-yY", R.drawable.ic_book)
            )
            "boxing" -> listOf(
                VideoItem("Boxing Fundamentals", "https://www.youtube.com/watch?v=u4v_86E9vG8", R.drawable.ic_play),
                VideoItem("Boxing Footwork", "https://www.youtube.com/watch?v=fXW9P9fW9xU", R.drawable.ic_field),
                VideoItem("Rules of Boxing", "https://www.youtube.com/watch?v=ZfJsh5G85pI", R.drawable.ic_book)
            )
            "karate" -> listOf(
                VideoItem("Basic Karate Techniques", "https://www.youtube.com/watch?v=vVEnNfTqj9M", R.drawable.ic_play),
                VideoItem("Karate Kata Tutorial", "https://www.youtube.com/watch?v=qM2nscTfHnI", R.drawable.ic_play),
                VideoItem("Rules of Karate", "https://www.youtube.com/watch?v=3u_C_q4z0iU", R.drawable.ic_book)
            )
            "wrestling" -> listOf(
                VideoItem("Wrestling Takedowns", "https://www.youtube.com/watch?v=Qf4rWv9Z9Xo", R.drawable.ic_field),
                VideoItem("Wrestling Basics", "https://www.youtube.com/watch?v=2r7u_m-q3I4", R.drawable.ic_play),
                VideoItem("Rules of Wrestling", "https://www.youtube.com/watch?v=5z60eXz_0j4", R.drawable.ic_book)
            )
            "formula 1" -> listOf(
                VideoItem("F1 Driving Techniques", "https://www.youtube.com/watch?v=N807-u0_7-k", R.drawable.ic_play),
                VideoItem("F1 Pit Stop Explained", "https://www.youtube.com/watch?v=7VCAL3vLDpw", R.drawable.ic_play),
                VideoItem("Rules of F1", "https://www.youtube.com/watch?v=E6xP_6I5vEw", R.drawable.ic_book)
            )
            "shooting" -> listOf(
                VideoItem("Shooting Stance Basics", "https://www.youtube.com/watch?v=YfM4nI_9z0E", R.drawable.ic_play),
                VideoItem("Precision Shooting", "https://www.youtube.com/watch?v=vVEnNfTqj9M", R.drawable.ic_play),
                VideoItem("Rules of Sport Shooting", "https://www.youtube.com/watch?v=zE6e89_6e8Q", R.drawable.ic_book)
            )
            "kabaddi" -> listOf(
                VideoItem("Kabaddi Raiding Skills", "https://www.youtube.com/watch?v=u_V1m3_z3oA", R.drawable.ic_play),
                VideoItem("Kabaddi Defense Skills", "https://www.youtube.com/watch?v=KzX9pC1pZ7o", R.drawable.ic_field),
                VideoItem("Rules of Kabaddi", "https://www.youtube.com/watch?v=680XjU5jV0g", R.drawable.ic_book)
            )
            else -> emptyList()
        }
    }
}
