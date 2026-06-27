package com.example.playwise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.playwise.databinding.ActivityTipsBinding

class TipsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val sport = intent.getStringExtra("sport_name") ?: "Sport"
        binding.toolbar.title = "$sport - Tips"

        val tips = getTipsForSport(sport)
        
        binding.rvTips.layoutManager = LinearLayoutManager(this)
        binding.rvTips.adapter = TipsAdapter(tips)
    }

    private fun getTipsForSport(sport: String): List<TipItem> {
        return when (sport.lowercase()) {
            "cricket" -> listOf(
                TipItem("Perfect Stance", "Keep your feet shoulder-width apart and head still. Your eyes should be level to track the ball accurately."),
                TipItem("Bowling Grip", "For seam bowling, hold the ball with your first two fingers across the seam to get maximum movement off the pitch."),
                TipItem("Fielding Readiness", "Stay on the balls of your feet and keep your hands ready. Always watch the ball into your hands to avoid drops.")
            )
            "football" -> listOf(
                TipItem("Close Control", "Practice dribbling with both the inside and outside of your foot. Keep the ball close to maintain control under pressure."),
                TipItem("Body Positioning", "When defending, stay low and jockey the attacker. Avoid diving in; wait for the right moment to make a tackle."),
                TipItem("Scanning", "Always look over your shoulder before receiving the ball. Knowing where your teammates and opponents are is crucial.")
            )
            "basketball" -> listOf(
                TipItem("Shooting Form", "Remember 'BEEF': Balance, Eyes on target, Elbow in, and Follow-through. Flick your wrist for a natural backspin."),
                TipItem("Triple Threat", "Master the stance where you can either shoot, pass, or dribble. Keep the ball protected near your hip."),
                TipItem("Defensive Slide", "Stay low in a wide stance and move your feet without crossing them to stay in front of the offensive player.")
            )
            "volleyball" -> listOf(
                TipItem("Platform Passing", "Keep your arms straight and together to create a flat surface. Use your legs to push the ball toward the setter."),
                TipItem("Setting Technique", "Use the pads of your fingers, not your palms. Shape your hands like a ball and extend your arms upward and outward."),
                TipItem("Spiking Approach", "Master the three-step approach to build momentum. Jump vertically and snap your wrist over the top of the ball.")
            )
            "hockey" -> listOf(
                TipItem("Stick Control", "Your left hand should be at the top of the stick for rotation, while your right hand stays lower for power and guidance."),
                TipItem("Low Posture", "Keep your knees bent and back straight. Staying low allows for quicker reactions and better stick control on the turf."),
                TipItem("Push Passing", "Use a smooth pushing motion rather than a hit for short, accurate passes. It's harder for opponents to read.")
            )
            "tennis" -> listOf(
                TipItem("Split Step", "Perform a small hop just as your opponent strikes the ball. This resets your balance and prepares you for quick movement."),
                TipItem("Racket Preparation", "Take your racket back early as soon as you see which side the ball is coming to. This gives you time for a clean stroke."),
                TipItem("Follow Through", "Complete your swing fully over your shoulder. A good follow-through ensures power, spin, and control.")
            )
            "badminton" -> listOf(
                TipItem("Grip Versatility", "Switch quickly between forehand and backhand grips. Keep your grip relaxed until the moment of impact for extra snap."),
                TipItem("Central Base", "Always return to the 'T' at the center of the court after every shot. This puts you in the best position to reach any return."),
                TipItem("Shuttle Timing", "Focus on hitting the shuttlecock in front of your body. Taking it early gives your opponent less time to react.")
            )
            "rugby" -> listOf(
                TipItem("Safe Tackling", "Keep your head to the side and shoulder into the opponent's thigh. Drive with your legs and wrap your arms tightly."),
                TipItem("Spin Passing", "Flick your wrists to put a spiral on the ball. This makes the pass faster and more stable in windy conditions."),
                TipItem("Ruck Awareness", "Enter the ruck from the 'gate' (the hindmost foot of your teammate). Keep your body low and drive through contact.")
            )
            "golf" -> listOf(
                TipItem("Proper Grip", "Hold the club primarily in your fingers, not your palms. This allows for better wrist hinge and control."),
                TipItem("Ball Position", "For most shots, place the ball slightly forward in your stance to ensure a clean strike."),
                TipItem("Smooth Tempo", "Focus on a consistent, smooth swing rhythm rather than trying to hit the ball as hard as possible.")
            )
            "handball" -> listOf(
                TipItem("Ball Handling", "Use your fingertips, not your palms, to control the ball. This allows for quicker passing and more accurate shooting."),
                TipItem("Defensive Stance", "Keep your arms up and feet moving. Stay between the attacker and the goal to block passing lanes."),
                TipItem("Jump Shot", "Master the timing of your jump to release the ball at the highest point, making it harder for the goalkeeper.")
            )
            "boxing" -> listOf(
                TipItem("Keep Your Guard Up", "Always keep your hands up to protect your face. Your chin should be tucked slightly behind your lead shoulder."),
                TipItem("Footwork", "Move with small, purposeful steps. Never cross your feet, as this leaves you off balance and vulnerable."),
                TipItem("Breath Control", "Exhale sharply with every punch. This helps with power and prevents you from getting winded.")
            )
            "karate" -> listOf(
                TipItem("Strong Stance", "Focus on your 'Zenkutsu-dachi' (front stance). A low, stable base is essential for both power and defense."),
                TipItem("Kiai", "Use a powerful shout (Kiai) when executing techniques to focus your energy and breathe properly."),
                TipItem("Precision over Power", "Focus on the correct form and accuracy of your strikes. Speed and power will naturally follow.")
            )
            "wrestling" -> listOf(
                TipItem("Stay Low", "Maintain a low center of gravity. This makes it harder for opponents to get under your hips for a takedown."),
                TipItem("Hand Fighting", "Control your opponent's wrists and head. Dominating the hand fight is key to setting up your attacks."),
                TipItem("Bridge and Roll", "Practice your bridge to avoid being pinned. Being strong on your back is a vital defensive skill.")
            )
            "formula 1" -> listOf(
                TipItem("Racing Line", "Use the entire width of the track. Enter corners wide, hit the apex, and exit wide to carry maximum speed."),
                TipItem("Smooth Inputs", "Be progressive with the throttle and brakes. Sudden movements can upset the car's balance."),
                TipItem("Brake Management", "Master 'trail braking'—gradually releasing the brakes as you turn into a corner to maximize grip.")
            )
            "shooting" -> listOf(
                TipItem("Stance and Balance", "Find a comfortable, stable position. Your body should be relaxed but firm to provide a steady platform."),
                TipItem("Sight Alignment", "Ensure your front and rear sights are perfectly aligned with your target before initiating the trigger."),
                TipItem("Trigger Control", "Apply steady, rearward pressure on the trigger. Avoid 'jerking' the trigger, which can pull your shot.")
            )
            "kabaddi" -> listOf(
                TipItem("Raider's Cant", "Practice holding your breath and repeating 'Kabaddi' clearly. Lung capacity is crucial for long raids."),
                TipItem("Footwork and Agility", "Stay light on your feet. Quick changes in direction are needed to touch defenders and escape."),
                TipItem("Defensive Chain", "Work closely with your teammates. Use the chain system to surround and trap the raider effectively.")
            )
            else -> listOf(
                TipItem("General Fitness", "Maintain a good level of cardio and strength training tailored to your specific sport."),
                TipItem("Stay Hydrated", "Drink plenty of water before, during, and after your practice or match to maintain performance.")
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
