package vcmsa.ci.flashcardquizapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Question3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question3)
        //----------------------------------------------------------------------------------
        //(Kotlinlang, 2024)
        val btnTrue3 = findViewById<Button>(R.id.btnTrue3)
        val btnFalse3 = findViewById<Button>(R.id.btnFalse3)
        val btnExit3 = findViewById<Button>(R.id.btnExit3)
        //Display a question and include two buttons for the answer options “True” and “False”
        //(Donn Felker, 2017)
        val answers = arrayOf(true, false, true, false, false)  //Correct Answer
        val correctAns = answers[2]
        val score = intent.getIntExtra("score", 0)

        //After you clicking the "answer" the following feedback for each answer will be “Correct!” or “Incorrect”
        btnTrue3.setOnClickListener {
            var updatedScore = score
            updatedScore ++ //Correct
            if (correctAns){
                Toast.makeText(this,"Correct!",Toast.LENGTH_SHORT).show() /* (Android Developer, 2024) */
            } else {
                Toast.makeText(this,"Incorrect!",Toast.LENGTH_SHORT).show()
            }

            val intentQuestion4 = Intent (this,Question4::class.java)
            intentQuestion4.putExtra("score", updatedScore)
            startActivity(intentQuestion4)
        }

        //----------------------------------------------------------------------------------
        btnFalse3.setOnClickListener {
            if (!correctAns) {
                Toast.makeText(this,"Correct!",Toast.LENGTH_SHORT).show()
            } else {
                // Score stays the same because the answer is incorrect
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
            }
            val intentQuestion4 = Intent (this,Question4::class.java)
            intentQuestion4.putExtra("score", score) // Pass current score, unchanged
            startActivity(intentQuestion4)
        }
        //An Exit button that terminates the app
        //(GridoWit, 2017)
        btnExit3.setOnClickListener {
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
