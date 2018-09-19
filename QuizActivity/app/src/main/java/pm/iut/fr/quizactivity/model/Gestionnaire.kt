package pm.iut.fr.quizactivity.model

import android.content.Context
import pm.iut.fr.quizactivity.R
import pm.iut.fr.quizactivity.vue.QuizActivity
import java.util.*

class Gestionnaire {
    private var questions: LinkedList<TrueFalseQuestion> = LinkedList<TrueFalseQuestion>()

    constructor(context: Context) {
        questions.add(TrueFalseQuestion(true, context.getString(R.string.question1)))
        questions.add(TrueFalseQuestion(true, context.getString(R.string.question2)))
    }

    public fun play(choix: Boolean): Boolean {
        val result = (questions.first.bonneReponse == choix)

        questions.removeFirst()

        return result
    }

    public fun canPlay(): Boolean {
        return !questions.isEmpty()
    }

    public fun getQuestion(): String {
        return questions.first.question
    }
}