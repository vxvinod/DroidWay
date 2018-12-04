package com.example.a60010743.scientisttop10

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView = findViewById<ListView>(R.id.name_list) as ListView

        var scientistNames:Array<String> = resources.getStringArray(R.array.scientist_names)
        val adp :ArrayAdapter<String> = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, scientistNames)

        listView.adapter = adp


        listView.setOnItemClickListener { parent, view, position, id ->
            val bundle = Bundle()
            val mainIntent = Intent(this@MainActivity, SecondActivity::class.java)
            //Toast.makeText(this@MainActivity, "Item clicked-id--$id--position--$position", Toast.LENGTH_LONG).show()
//            bundle.putString("position", position.toString())
            mainIntent.putExtra("position", position.toString())
            startActivity(mainIntent)
        }



        //intent.putExtras(bundle)





    }
}
