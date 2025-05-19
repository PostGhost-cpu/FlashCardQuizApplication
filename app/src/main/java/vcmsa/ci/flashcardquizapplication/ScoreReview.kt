package vcmsa.ci.flashcardquizapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreReview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_review)
        //----------------------------------------------------------------------------------
        val txtTotalScore = findViewById<TextView>(R.id.txtTotalScore)
        val txtFeedBack = findViewById<TextView>(R.id.txtFeedBack)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnAgain = findViewById<Button>(R.id.btnAgain)
        val btnExit = findViewById<Button>(R.id.btnExit)
        //----------------------------------------------------------------------------------
        //The IIE(2025, p75-76) Declaring the Array
        val question = arrayOf<String>("What ancient structure was used by early civilizations to observe the sky and track stars",
            "Who invented the light bulb that led to widespread use of electric lighting",
            "What major invention in the 15th century revolutionized the way people shared information",
            "What technology, first launched in the late 20th century, made global communication and information sharing possible through computers",
            "Which company released the first smartphone with a touchscreen in 2007 that transformed mobile technology")
        val answers = arrayOf(true, false, true, false, false)  //Correct Answer
        //Display the total number of correct answers and provide personalised feedback based on the score
        var score = intent.getIntExtra("score", 0)

        txtTotalScore.text = "$score / 5"
        //Display feedback based on the total score 3 > "Great job!" | 3 < "Keep practising"
        if (score >= 3) {
            txtFeedBack.text = "Great Job!"
        } else {
            txtFeedBack.text = "Keep Practicing"
        }
        //----------------------------------------------------------------------------------
        //The "Review" button should allow user to review all the question and their correct answer
        val txtQ1Review = findViewById<TextView>(R.id.txtQ1Review)
        val txtQ2Review = findViewById<TextView>(R.id.txtQ2Review)
        val txtQ3Review = findViewById<TextView>(R.id.txtQ3Review)
        val txtQ4Review = findViewById<TextView>(R.id.txtQ4Review)
        val txtQ5Review = findViewById<TextView>(R.id.txtQ5Review)
            //----------------------------------------------------------------------------------
            btnReview.setOnClickListener { /* The IIE(2025, p77) Accessing the Elements */
                Toast.makeText(this, "Corrections", Toast.LENGTH_SHORT).show()

                txtQ1Review.text = "${question[0]} - Correct Answer: ${(answers[0])}"
                txtQ2Review.text = "${question[1]} - Correct Answer: ${(answers[1])}"
                txtQ3Review.text = "${question[2]} - Correct Answer: ${(answers[2])}"
                txtQ4Review.text = "${question[3]} - Correct Answer: ${(answers[3])}"
                txtQ5Review.text = "${question[4]} - Correct Answer: ${(answers[4])}"
            }
            //----------------------------------------------------------------------------------
            //You can return to the homepage by clicking the "Again" button
            btnAgain.setOnClickListener {
                val intentHomePage = Intent(this, HomePage::class.java)
                startActivity(intentHomePage)
            }

        /*
        An Exit button that terminates the app
        (GridoWit, 2017)
        */
        btnExit.setOnClickListener {
                finishAffinity()
            }
            //----------------------------------------------------------------------------------
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }

