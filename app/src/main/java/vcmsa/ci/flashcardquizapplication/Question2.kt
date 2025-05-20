package vcmsa.ci.flashcardquizapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Question2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question2)
        //----------------------------------------------------------------------------------
        //(Kotinlang, 2024)
        val btnTrue2 = findViewById<Button>(R.id.btnTrue2)
        val btnFalse2 = findViewById<Button>(R.id.btnFalse2)
        val btnExit2 = findViewById<Button>(R.id.btnExit2)
        //Display a question and include two buttons for the answer options “True” and “False”
        //(Donn Felker, 2017)
        val answers = arrayOf(true, false, true, false, false)  //Correct Answer
        val correctAns = answers[1]
        val score = intent.getIntExtra("score", 0)

        //After you clicking the "answer" the following feedback for each answer will be “Correct!” or “Incorrect”
        btnTrue2.setOnClickListener {
            if (!correctAns) {
                Toast.makeText(this,"Incorrect!",Toast.LENGTH_SHORT).show() /* (Android Developer, 2024) */
            } else {
                // Score stays the same because the answer is incorrect
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            }

            val intentQuestion3 = Intent(this, Question3::class.java)
            intentQuestion3.putExtra("score", score) // Pass current score, unchanged
            startActivity(intentQuestion3)
            }
        //----------------------------------------------------------------------------------
        btnFalse2.setOnClickListener {
            var updatedScore = score
            updatedScore ++ //Correct
            if (correctAns){
                Toast.makeText(this,"Incorrect!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Correct!",Toast.LENGTH_SHORT).show()
            }

            val intentQuestion3 = Intent (this,Question3::class.java)
            intentQuestion3.putExtra("score", updatedScore)
            startActivity(intentQuestion3)
        }
        //An Exit button that terminates the app
        //(GridoWit, 2017)
        btnExit2.setOnClickListener {
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
