package vcmsa.ci.flashcardquizapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Question5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question5)
        //----------------------------------------------------------------------------------
        val btnTrue5 = findViewById<Button>(R.id.btnTrue5)
        val btnFalse5 = findViewById<Button>(R.id.btnFalse5)
        val btnExit5 = findViewById<Button>(R.id.btnExit5)
        //Display a question and include two buttons for the answer options “True” and “False”
        val answers = arrayOf(true, false, true, false, false)  //Correct Answer
        val correctAns = answers[4]
        val score = intent.getIntExtra("score", 0)

        //After you clicking the "answer," the following feedback for each answer will be “Correct!” or “Incorrect”
        btnTrue5.setOnClickListener {
            if (!correctAns) {
                Toast.makeText(this,"Incorrect!",Toast.LENGTH_SHORT).show()
            } else {
                // Score stays the same because the answer is incorrect
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            }

            val intentReview = Intent (this,ScoreReview::class.java)
            intentReview.putExtra("score", score) // Pass current score, unchanged
            startActivity(intentReview)
        }
        //----------------------------------------------------------------------------------
        btnFalse5.setOnClickListener {
            var updatedScore = score
            updatedScore ++ //Correct
            if (correctAns){
                Toast.makeText(this,"Incorrect!",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Correct!",Toast.LENGTH_SHORT).show()
            }

            val intentReview = Intent (this,ScoreReview::class.java)
            intentReview.putExtra("score", updatedScore)
            startActivity(intentReview)
        }
        //An Exit button that terminates the app
        //(GridoWit, 2017)
        btnExit5.setOnClickListener {
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