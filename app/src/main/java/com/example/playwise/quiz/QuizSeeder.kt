package com.example.playwise.quiz

object QuizSeeder {
    fun getDefaultQuestions(): List<QuestionEntity> {
        return listOf(
            QuestionEntity(
                question = "How many players are there in a cricket team?",
                option1 = "9", option2 = "10", option3 = "11", option4 = "12",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "Which country won the first ever Football World Cup?",
                option1 = "Brazil", option2 = "Uruguay", option3 = "Argentina", option4 = "Germany",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "What is the duration of a standard football match?",
                option1 = "45 mins", option2 = "60 mins", option3 = "90 mins", option4 = "120 mins",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "In which sport would you use a shuttlecock?",
                option1 = "Tennis", option2 = "Table Tennis", option3 = "Badminton", option4 = "Squash",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "How many points is a free throw worth in basketball?",
                option1 = "1", option2 = "2", option3 = "3", option4 = "5",
                correctAnswer = 1
            ),
            QuestionEntity(
                question = "What is the length of a cricket pitch?",
                option1 = "20 yards", option2 = "22 yards", option3 = "24 yards", option4 = "26 yards",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Which sport is known as the 'king of sports'?",
                option1 = "Cricket", option2 = "Football", option3 = "Basketball", option4 = "Tennis",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "How many sets are usually played in a women's Grand Slam tennis match?",
                option1 = "1", option2 = "3", option3 = "5", option4 = "7",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Which of these is NOT a way to get out in cricket?",
                option1 = "Bowled", option2 = "Caught", option3 = "LBW", option4 = "Dribbled",
                correctAnswer = 4
            ),
            QuestionEntity(
                question = "What is the diameter of a basketball hoop in inches?",
                option1 = "16", option2 = "18", option3 = "20", option4 = "22",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Which country has won the most FIFA World Cups?",
                option1 = "Germany", option2 = "Italy", option3 = "Brazil", option4 = "Argentina",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "How many rings are there on the Olympic flag?",
                option1 = "4", option2 = "5", option3 = "6", option4 = "7",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "In which sport is the term 'Home Run' used?",
                option1 = "Cricket", option2 = "Baseball", option3 = "Hockey", option4 = "Golf",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Which grand slam is played on a clay court?",
                option1 = "Wimbledon", option2 = "US Open", option3 = "French Open", option4 = "Australian Open",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "How many players are on a volleyball court per team?",
                option1 = "5", option2 = "6", option3 = "7", option4 = "8",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Which sport uses the term 'Birdie'?",
                option1 = "Tennis", option2 = "Golf", option3 = "Badminton", option4 = "Hockey",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Who is known as 'The Flying Sikh' of India?",
                option1 = "Milkha Singh", option2 = "P.T. Usha", option3 = "Abhinav Bindra", option4 = "Sachin Tendulkar",
                correctAnswer = 1
            ),
            QuestionEntity(
                question = "What is the maximum score possible in a single frame of ten-pin bowling?",
                option1 = "10", option2 = "20", option3 = "30", option4 = "100",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "How long is a marathon in kilometers?",
                option1 = "21.1", option2 = "32.2", option3 = "42.195", option4 = "50",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "Which sport is played at Lord's in London?",
                option1 = "Football", option2 = "Rugby", option3 = "Cricket", option4 = "Tennis",
                correctAnswer = 3
            ),
            // Add new questions here
            QuestionEntity(
                question = "Which country won FIFA 2022?",
                option1 = "Brazil", option2 = "France", option3 = "Argentina", option4 = "Germany",
                correctAnswer = 3
            ),
            // Add these 10 more questions

            QuestionEntity(
                question = "Which sport is known as the 'gentleman's game'?",
                option1 = "Football", option2 = "Cricket", option3 = "Tennis", option4 = "Golf",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "How many players are there in a basketball team on court?",
                option1 = "4", option2 = "5", option3 = "6", option4 = "7",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Which country hosted the 2016 Summer Olympics?",
                option1 = "China", option2 = "Brazil", option3 = "UK", option4 = "Japan",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "In cricket, what does LBW stand for?",
                option1 = "Leg Before Wicket", option2 = "Long Bat Wicket", option3 = "Last Ball Win", option4 = "Leg By Wide",
                correctAnswer = 1
            ),
            QuestionEntity(
                question = "Which sport uses a racket and a shuttlecock?",
                option1 = "Tennis", option2 = "Badminton", option3 = "Squash", option4 = "Table Tennis",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Who has won the most Olympic gold medals?",
                option1 = "Usain Bolt", option2 = "Michael Phelps", option3 = "Carl Lewis", option4 = "Mark Spitz",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Which country is famous for sumo wrestling?",
                option1 = "China", option2 = "Japan", option3 = "Korea", option4 = "Thailand",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "What is the standard duration of an ODI cricket match (per side overs)?",
                option1 = "20 overs", option2 = "40 overs", option3 = "50 overs", option4 = "60 overs",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "Which sport is associated with the term 'Ace'?",
                option1 = "Football", option2 = "Tennis", option3 = "Basketball", option4 = "Cricket",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "In football, how many players are there on the field for one team?",
                option1 = "9", option2 = "10", option3 = "11", option4 = "12",
                correctAnswer = 3
            ),
            // 10 More Questions

            QuestionEntity(
                question = "Which country invented cricket?",
                option1 = "India", option2 = "Australia", option3 = "England", option4 = "South Africa",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "What is the national sport of India?",
                option1 = "Cricket", option2 = "Hockey", option3 = "Kabaddi", option4 = "Football",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "How many players are there in a kabaddi team on the court?",
                option1 = "5", option2 = "6", option3 = "7", option4 = "8",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "Which sport is played at Wimbledon?",
                option1 = "Cricket", option2 = "Tennis", option3 = "Football", option4 = "Badminton",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "In which sport is the term 'Goalkeeper' used?",
                option1 = "Cricket", option2 = "Football", option3 = "Basketball", option4 = "Tennis",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Which Indian cricketer is known as 'Master Blaster'?",
                option1 = "Virat Kohli", option2 = "MS Dhoni", option3 = "Sachin Tendulkar", option4 = "Rohit Sharma",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "How many points is a three-pointer worth in basketball?",
                option1 = "1", option2 = "2", option3 = "3", option4 = "4",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "Which sport uses a bat, ball, and stumps?",
                option1 = "Baseball", option2 = "Cricket", option3 = "Hockey", option4 = "Golf",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "What is the maximum number of overs in a T20 cricket match per side?",
                option1 = "10", option2 = "15", option3 = "20", option4 = "25",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "Which sport is known as the fastest racket sport?",
                option1 = "Tennis", option2 = "Badminton", option3 = "Squash", option4 = "Table Tennis",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "How many players are there in a cricket team?",
                option1 = "9", option2 = "10", option3 = "11", option4 = "12",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "What is the length of a cricket pitch?",
                option1 = "20 yards", option2 = "22 yards", option3 = "24 yards", option4 = "18 yards",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "How many balls are there in one over?",
                option1 = "5", option2 = "6", option3 = "7", option4 = "8",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "What is a 'duck' in cricket?",
                option1 = "Scoring zero runs", option2 = "Hitting six runs", option3 = "Getting injured", option4 = "Wide ball",
                correctAnswer = 1
            ),
            QuestionEntity(
                question = "Which country hosted the first Cricket World Cup?",
                option1 = "India", option2 = "Australia", option3 = "England", option4 = "South Africa",
                correctAnswer = 3
            ),QuestionEntity(
                question = "What does LBW stand for in cricket?",
                option1 = "Long Ball Wide", option2 = "Leg Before Wicket", option3 = "Low Bat Wicket", option4 = "Leg Ball Win",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "How many runs are awarded for hitting the ball over the boundary without bouncing?",
                option1 = "4", option2 = "5", option3 = "6", option4 = "3",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "What is a hat-trick in cricket?",
                option1 = "3 runs in one ball", option2 = "3 wickets in 3 consecutive balls", option3 = "3 catches", option4 = "3 overs",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Which player is known as the 'God of Cricket'?",
                option1 = "Virat Kohli", option2 = "MS Dhoni", option3 = "Sachin Tendulkar", option4 = "Ricky Ponting",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "What is the maximum number of overs per side in a One Day International (ODI) match?",
                option1 = "20", option2 = "40", option3 = "50", option4 = "60",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "How many players are there in a football team on the field?",
                option1 = "9", option2 = "10", option3 = "11", option4 = "12",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "What is the total duration of a standard football match?",
                option1 = "60 minutes", option2 = "70 minutes", option3 = "80 minutes", option4 = "90 minutes",
                correctAnswer = 4
            ),
            QuestionEntity(
                question = "Which player can use hands during the match?",
                option1 = "Defender", option2 = "Midfielder", option3 = "Goalkeeper", option4 = "Striker",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "What does FIFA stand for?",
                option1 = "Football India Federation Association", option2 = "Federation Internationale de Football Association", option3 = "Football International Federation Association", option4 = "None",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "What happens when a player gets a red card?",
                option1 = "Warning", option2 = "Free kick", option3 = "Player is sent off", option4 = "Goal awarded",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "What is the distance of a penalty kick in football?",
                option1 = "10 yards", option2 = "12 yards", option3 = "15 yards", option4 = "18 yards",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "How many referees are there on the field during a football match?",
                option1 = "1", option2 = "2", option3 = "3", option4 = "4",
                correctAnswer = 1
            ),
            QuestionEntity(
                question = "What is an offside in football?",
                option1 = "Ball out of ground", option2 = "Foul play", option3 = "Player closer to goal than ball and defenders", option4 = "Goal scored illegally",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "Which country won the FIFA World Cup 2018?",
                option1 = "Germany", option2 = "Brazil", option3 = "France", option4 = "Argentina",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "What is shown to indicate a warning to a player?",
                option1 = "Red card", option2 = "Yellow card", option3 = "Green card", option4 = "Blue card",
                correctAnswer = 2
            )



            )
    }
}
