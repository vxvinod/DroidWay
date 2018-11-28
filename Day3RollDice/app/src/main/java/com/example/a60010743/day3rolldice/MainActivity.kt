package com.example.a60010743.day3rolldice

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var diceButton = findViewById<Button>(R.id.roll_dice)
        var diceImage = findViewById<ImageView>(R.id.dice_image)
        var secondDice = findViewById<ImageView>(R.id.second_dice_image)
        diceImage.setImageResource(R.drawable.empty_dice)
        diceButton?.setOnClickListener {
            var firstDiceRandomNum = (1..6).shuffled().first()
            var secondDiceRandomNum = (1..6).shuffled().first()
            when(firstDiceRandomNum){
                 1->diceImage.setImageResource(R.drawable.dice_1)
                2->diceImage.setImageResource(R.drawable.dice_2)
                3->diceImage.setImageResource(R.drawable.dice_3)
                4->diceImage.setImageResource(R.drawable.dice_4)
                5->diceImage.setImageResource(R.drawable.dice_5)
                6->diceImage.setImageResource(R.drawable.dice_6)
            }
            when(secondDiceRandomNum){
                1->secondDice.setImageResource(R.drawable.dice_1)
                2->secondDice.setImageResource(R.drawable.dice_2)
                3->secondDice.setImageResource(R.drawable.dice_3)
                4->secondDice.setImageResource(R.drawable.dice_4)
                5->secondDice.setImageResource(R.drawable.dice_5)
                6->secondDice.setImageResource(R.drawable.dice_6)
            }
            //diceImage.setImageResource(R.drawable.dice_4)
        }

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }





    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
