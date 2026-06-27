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
            ),
            QuestionEntity(
                question = "How many players are there in a basketball team on the court?",
                option1 = "4", option2 = "5", option3 = "6", option4 = "7",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "What is the height of a basketball hoop?",
                option1 = "8 feet", option2 = "9 feet", option3 = "10 feet", option4 = "11 feet",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "How many points is a free throw worth?",
                option1 = "1", option2 = "2", option3 = "3", option4 = "4",
                correctAnswer = 1
            ),
            QuestionEntity(
                question = "How many points is a shot from beyond the arc worth?",
                option1 = "1", option2 = "2", option3 = "3", option4 = "4",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "What is it called when a player moves while bouncing the ball?",
                option1 = "Passing", option2 = "Dribbling", option3 = "Shooting", option4 = "Blocking",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "How many quarters are there in a standard basketball game?",
                option1 = "2", option2 = "3", option3 = "4", option4 = "5",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "What happens when a player commits too many fouls?",
                option1 = "Gets warning", option2 = "Gets bonus points", option3 = "Fouls out of the game", option4 = "Nothing",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "What is the time limit to shoot the ball in basketball (shot clock)?",
                option1 = "10 seconds", option2 = "24 seconds", option3 = "30 seconds", option4 = "60 seconds",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "NBA stands for?",
                option1 = "National Basketball Association", option2 = "New Basketball Alliance", option3 = "National Board Association", option4 = "None",
                correctAnswer = 1
            ),
            QuestionEntity(
                question = "What is it called when a player scores by jumping and putting the ball directly into the basket?",
                option1 = "Layup", option2 = "Dribble", option3 = "Dunk", option4 = "Pass",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "How many players are there in a volleyball team on the court?",
                option1 = "5", option2 = "6", option3 = "7", option4 = "8",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "What is the standard size of a volleyball court?",
                option1 = "18m x 9m", option2 = "20m x 10m", option3 = "15m x 8m", option4 = "25m x 12m",
                correctAnswer = 1
            ),
            QuestionEntity(
                question = "How many maximum hits are allowed per side?",
                option1 = "2", option2 = "3", option3 = "4", option4 = "5",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "What is the net height for men's volleyball?",
                option1 = "2.43m", option2 = "2.24m", option3 = "2.50m", option4 = "2.00m",
                correctAnswer = 1
            ),
            QuestionEntity(
                question = "What is it called when the ball touches the ground on the opponent's side?",
                option1 = "Foul", option2 = "Out", option3 = "Point", option4 = "Serve",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "In volleyball, what is a 'serve'?",
                option1 = "Starting the game by hitting the ball over the net", option2 = "Blocking the ball", option3 = "Spiking the ball", option4 = "Passing the ball",
                correctAnswer = 1
            ),
            QuestionEntity(
                question = "What is the role of a libero in volleyball?",
                option1 = "Attacker", option2 = "Defensive specialist", option3 = "Referee", option4 = "Captain",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "How many sets are usually played in a volleyball match?",
                option1 = "3", option2 = "4", option3 = "5", option4 = "6",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "How many points are needed to win a set in volleyball?",
                option1 = "21", option2 = "25", option3 = "30", option4 = "15",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "What is it called when a player jumps and hits the ball forcefully over the net?",
                option1 = "Serve", option2 = "Block", option3 = "Spike", option4 = "Pass",
                correctAnswer = 3
            ),

            // Golf Questions
            QuestionEntity(
                question = "What is the standard number of holes on a full golf course?",
                option1 = "9", option2 = "12", option3 = "18", option4 = "24",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "Which term is used for scoring one stroke under par on a hole?",
                option1 = "Birdie", option2 = "Eagle", option3 = "Bogey", option4 = "Albatross",
                correctAnswer = 1
            ),
            QuestionEntity(
                question = "What is the name of the stick used to hit the ball in golf?",
                option1 = "Bat", option2 = "Club", option3 = "Racket", option4 = "Crosse",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Where does a golfer place the ball to start each hole?",
                option1 = "Green", option2 = "Fairway", option3 = "Tee box", option4 = "Bunker",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "Which major golf tournament is held annually at Augusta National?",
                option1 = "The Open", option2 = "US Open", option3 = "The Masters", option4 = "PGA Championship",
                correctAnswer = 3
            ),

            // Handball Questions
            QuestionEntity(
                question = "How many players are on the court for each team in a standard handball match?",
                option1 = "5", option2 = "6", option3 = "7", option4 = "11",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "How many seconds can a player hold the ball without moving, passing, or dribbling?",
                option1 = "3", option2 = "5", option3 = "7", option4 = "10",
                correctAnswer = 1
            ),
            QuestionEntity(
                question = "What is the duration of a standard adult handball match?",
                option1 = "40 mins", option2 = "50 mins", option3 = "60 mins", option4 = "90 mins",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "Only which player is allowed to enter the goal area in handball?",
                option1 = "Captain", option2 = "Pivot", option3 = "Goalkeeper", option4 = "Winger",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "How many steps is a player allowed to take with the ball without dribbling?",
                option1 = "2", option2 = "3", option3 = "4", option4 = "5",
                correctAnswer = 2
            ),

            // Boxing Questions
            QuestionEntity(
                question = "How long is a standard round in professional men's boxing?",
                option1 = "2 mins", option2 = "3 mins", option3 = "5 mins", option4 = "10 mins",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "What is the name of the person who officiates inside the boxing ring?",
                option1 = "Judge", option2 = "Umpire", option3 = "Referee", option4 = "Marshal",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "Which of these is NOT a standard type of punch in boxing?",
                option1 = "Jab", option2 = "Hook", option3 = "Uppercut", option4 = "Slap",
                correctAnswer = 4
            ),
            QuestionEntity(
                question = "What is the term for a victory achieved by an opponent being unable to stand up by the count of ten?",
                option1 = "TKO", option2 = "KO", option3 = "Decision", option4 = "Draw",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "In which weight class would a boxer weighing over 200 lbs typically compete?",
                option1 = "Flyweight", option2 = "Lightweight", option3 = "Middleweight", option4 = "Heavyweight",
                correctAnswer = 4
            ),

            // Karate Questions
            QuestionEntity(
                question = "What does the word 'Karate' literally mean in Japanese?",
                option1 = "Empty Hand", option2 = "Hard Fist", option3 = "Way of Life", option4 = "Strong Spirit",
                correctAnswer = 1
            ),
            QuestionEntity(
                question = "What is the name of the white uniform worn by Karate practitioners?",
                option1 = "Kimono", option2 = "Gi", option3 = "Hakama", option4 = "Obi",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Which colored belt typically signifies the highest level for a student in Karate?",
                option1 = "White", option2 = "Green", option3 = "Brown", option4 = "Black",
                correctAnswer = 4
            ),
            QuestionEntity(
                question = "What is the Japanese term for a choreographed pattern of movements in Karate?",
                option1 = "Kata", option2 = "Kumite", option3 = "Kihon", option4 = "Dojo",
                correctAnswer = 1
            ),
            QuestionEntity(
                question = "Where is the traditional place of training for Karate?",
                option1 = "Gym", option2 = "Stadium", option3 = "Dojo", option4 = "Ring",
                correctAnswer = 3
            ),

            // Wrestling Questions
            QuestionEntity(
                question = "Which style of wrestling is contested in the Olympics along with Freestyle?",
                option1 = "WWE", option2 = "Greco-Roman", option3 = "Sumo", option4 = "Sambo",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "What is the name of the circle where the wrestling match takes place?",
                option1 = "Ring", option2 = "Octagon", option3 = "Mat", option4 = "Cage",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "In wrestling, what is it called when a player holds both of the opponent's shoulders on the mat?",
                option1 = "Takedown", option2 = "Pin", option3 = "Escape", option4 = "Reversal",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "How many points are typically awarded for a standard takedown in Freestyle wrestling?",
                option1 = "1", option2 = "2", option3 = "4", option4 = "5",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Which of these is NOT allowed in amateur wrestling?",
                option1 = "Takedown", option2 = "Throw", option3 = "Punching", option4 = "Leg attack",
                correctAnswer = 3
            ),

            // Formula 1 Questions
            QuestionEntity(
                question = "What is the name of a race in Formula 1?",
                option1 = "Heat", option2 = "Grand Prix", option3 = "Stage", option4 = "Lap",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Who holds the record for the most Formula 1 World Drivers' Championships?",
                option1 = "Ayrton Senna", option2 = "Michael Schumacher", option3 = "Sebastian Vettel", option4 = "Max Verstappen",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "What color flag is shown to a driver to move over for a faster car?",
                option1 = "Yellow", option2 = "Red", option3 = "Blue", option4 = "Green",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "What is the name of the device used to protect the driver's head in an F1 car?",
                option1 = "Helmet", option2 = "Halo", option3 = "HANS", option4 = "Rollbar",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Which Formula 1 tire compound is usually marked with red?",
                option1 = "Hard", option2 = "Medium", option3 = "Soft", option4 = "Intermediate",
                correctAnswer = 3
            ),

            // Shooting Questions
            QuestionEntity(
                question = "In Olympic shooting, what are the targets usually made of for shotgun events?",
                option1 = "Plastic", option2 = "Paper", option3 = "Clay", option4 = "Wood",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "What is the highest possible score for a single shot in most precision rifle events?",
                option1 = "10", option2 = "10.9", option3 = "11", option4 = "100",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "Which of these is an Olympic shooting discipline?",
                option1 = "Rapid Fire Pistol", option2 = "Sniper", option3 = "Hunting", option4 = "Archery",
                correctAnswer = 1
            ),
            QuestionEntity(
                question = "What do shooters wear to protect their hearing?",
                option1 = "Earplugs", option2 = "Headphones", option3 = "Ear defenders", option4 = "Helmets",
                correctAnswer = 3
            ),
            QuestionEntity(
                question = "In the Biathlon, shooting is combined with which other sport?",
                option1 = "Running", option2 = "Cycling", option3 = "Cross-country skiing", option4 = "Swimming",
                correctAnswer = 3
            ),

            // Kabaddi Questions
            QuestionEntity(
                question = "What must a raider repeatedly chant while in the opponent's half in Kabaddi?",
                option1 = "Victory", option2 = "Kabaddi", option3 = "Attack", option4 = "Run",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "How many points are awarded for a 'Lona' in Kabaddi?",
                option1 = "1", option2 = "2", option3 = "3", option4 = "5",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "How many players are on the field for each team at the start of a Kabaddi match?",
                option1 = "5", option2 = "7", option3 = "9", option4 = "11",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "What is the duration of a standard men's Kabaddi match?",
                option1 = "30 mins", option2 = "40 mins", option3 = "60 mins", option4 = "90 mins",
                correctAnswer = 2
            ),
            QuestionEntity(
                question = "What is a 'Super Tackle' in Kabaddi?",
                option1 = "Tackling with 3 or fewer defenders", option2 = "Tackling the captain", option3 = "Tackling out of bounds", option4 = "Tackling two raiders",
                correctAnswer = 1
            )










            )
    }
}
