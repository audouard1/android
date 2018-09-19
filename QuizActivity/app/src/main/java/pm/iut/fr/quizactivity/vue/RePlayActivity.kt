package pm.iut.fr.quizactivity.vue

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.replay_activity.*
import pm.iut.fr.quizactivity.R

class RePlayActivity : Activity(){
    lateinit var textview: TextView
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.replay_activity)
        textview = result_id
    }

    public fun displayRes(res: Boolean){
        if(res){
            textview.text = this.getString(R.string.win)
        }else{
            textview.text = this.getString(R.string.loose)
        }
    }

}