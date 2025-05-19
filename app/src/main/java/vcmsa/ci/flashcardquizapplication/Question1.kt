package vcmsa.ci.flashcardquizapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Question1 : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question1)
        //----------------------------------------------------------------------------------
        val btnTrue1 = findViewById<Button>(R.id.btnTrue1)
        val btnFalse1 = findViewById<Button>(R.id.btnFalse1)
        val btnExit1 = findViewById<Button>(R.id.btnExit1)
        //Display a question and include two buttons for the answer options “True” and “False”
        val answers = arrayOf(true, false, true, false, false)  //Correct Answer
        val correctAns = answers[0]
        //initialize score counter = 0
        val score = intent.getIntExtra("score", 0) /* get current score */

            //After you clicking the "answer," the following feedback for each answer will be “Correct!” or “Incorrect”
            btnTrue1.setOnClickListener {
                var updatedScore = score
                updatedScore ++ //Correct
                if (correctAns){
                    Toast.makeText(this,"Correct!",Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,"Incorrect!",Toast.LENGTH_SHORT).show()
                }

                val intentQuestion2 = Intent (this,Question2::class.java)
                intentQuestion2.putExtra("score", updatedScore)
                startActivity(intentQuestion2)
            }
            //----------------------------------------------------------------------------------
            btnFalse1.setOnClickListener {
                if (!correctAns) {
                    Toast.makeText(this,"Correct!",Toast.LENGTH_SHORT).show()
                } else {
                    // Score stays the same because the answer is incorrect
                    Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
                }

                val intentQuestion2 = Intent (this,Question2::class.java)
                intentQuestion2.putExtra("score", score) // Pass current score, unchanged
                startActivity(intentQuestion2)
            }
            //An Exit button that terminates the app
            //(GridoWit, 2017)
            btnExit1.setOnClickListener {
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