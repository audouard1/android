package pm.iut.fr.quizactivity.vue

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import pm.iut.fr.quizactivity.R
import pm.iut.fr.quizactivity.model.Gestionnaire

class QuizActivity : AppCompatActivity() {
    lateinit var gestionnaire: Gestionnaire
    lateinit var textQuestion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        textQuestion = findViewById(R.id.question_id)
        gestionnaire = Gestionnaire(this)
    }


    fun yesClick(view: View) {
        jouer(true)
    }

    fun noClick(view: View) {
        jouer(false)
    }

    fun jouer(choix: Boolean) {
        if (gestionnaire.canPlay()) {
            var result = gestionnaire.play(choix)
            val duration = Toast.LENGTH_SHORT
            val toast: Toast

            if (result) {
                toast = Toast.makeText(applicationContext, R.string.good, duration)

            } else {
                toast = Toast.makeText(applicationContext, R.string.bad, duration)
            }

            if (gestionnaire.canPlay())
                textQuestion.text = gestionnaire?.getQuestion()
            toast.show()
        }
        else {
            startActivity(Intent(this, RePlayActivity::class.java))
        }




    }
}
