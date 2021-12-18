package com.example.unbeatable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var matches=21

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonMove :Button=findViewById(R.id.button)
        val dialogue:TextView=findViewById(R.id.textView)
        val count:TextView=findViewById(R.id.count)
        buttonMove.setOnClickListener {
            move()
        }
    }
    private fun move(){
        val dialogue:TextView=findViewById(R.id.textView)
        val  removeCount: Int =when(findViewById<RadioGroup>(R.id.options).checkedRadioButtonId){
            R.id.option_1 -> 1
            R.id.option_2 -> 2
            R.id.option_3 -> 3
            else -> 4
        }
        if(removeCount in 1..4 && removeCount<=matches){
            matchRemove(removeCount)
            wait(1000000000)
            cpuMove(removeCount)
            wait(1000000000)
            dialogue.text = "Your turn"

        }
        else{val dialogue:TextView=findViewById(R.id.textView)
            dialogue.text = "You can't do that!"
        }
        if(matches==0){val dialogue:TextView=findViewById(R.id.textView)
            dialogue.text = "Yayy! I won"
        }

    }
    private fun cpuMove(k:Int) {
        if (matches == 0) {
            val dialogue:TextView=findViewById(R.id.textView)
            dialogue.text = "Yayy! I won"
        }
        else{val dialogue:TextView=findViewById(R.id.textView)
            dialogue.text = "I remove ${5-k} matches"
            matchRemove(5-k)

        }
    }
    private fun wait(k:Int){
        for(i in 1..k){
            i+1
        }
    }
    private fun matchRemove(x: Int) {
        val count:TextView=findViewById(R.id.count)
        matches-=x
        count.text = matches.toString()
    }

}
