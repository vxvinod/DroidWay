package com.example.a60010743.scientisttop10

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import com.example.a60010743.scientisttop10.model.Scientist
import com.example.a60010743.scientisttop10.utils.JsonUtils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {

    lateinit var mPlaceofOrigin:TextView
    lateinit var mOrigin:TextView
    lateinit var mIngredients:TextView
    lateinit var mDescription:TextView
    lateinit var mOtherNames:TextView
    lateinit var mImage:ImageView
    val DEFAULT_POSITION = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        mPlaceofOrigin = findViewById<TextView>(R.id.s_origin)
        mIngredients = findViewById<TextView>(R.id.s_ingredients)
        mOrigin = findViewById(R.id.s_origin) as TextView
        mOtherNames = findViewById(R.id.s_other_names) as TextView
        mDescription = findViewById(R.id.s_description) as TextView
        //val nameList = findViewById<TextView>(R.id.)
        mImage = findViewById<ImageView>(R.id.image_iv)
        var bundle = intent.extras

        if(bundle == null){
            closeOnError()
        }

        var pos = bundle.getString("position")
        if(pos.isNullOrBlank() || pos.toInt().equals(DEFAULT_POSITION)){
            closeOnError()
        }


        Log.d("INTENT_DATA", pos)
        var datas = resources.getStringArray(R.array.sandwich_details)

        var data : String = datas[pos.toInt()]
        var sc:Scientist = JsonUtils.parseSandwichJson(data)

        if(sc == null){
            closeOnError()
            return
        }
        populateUi(sc)

        setTitle(sc.mainName)
        Log.d("IMAGE_VIEW", sc.image)
        Picasso.with(this@SecondActivity)
                .load(sc.image)
                .resize(300, 200)
                .into(mImage)

       // mPlaceofOrigin.setText(sc.mainName)
    }

    private fun populateUi(data:Scientist){

        mDescription.setText(data.description)
        var ing = TextUtils.join(",", data.ingredients)
        mIngredients.setText(ing)

//        var originLayout : LinearLayout = findViewById<LinearLayout>(R.id.origin_layout)
//        var otherNamesLayout : LinearLayout = findViewById(R.id.other_names_layout) as LinearLayout

        var origin : String = data.placeOfOrigin
//        if(origin.isNullOrBlank() || origin.isNullOrEmpty()){
//            originLayout.visibility()
//        }else{
            mOrigin.setText(data.placeOfOrigin)
//        }

        var otherNames = TextUtils.join(",", data.alsoKnownAs)
//        if( otherNames.isNullOrEmpty() || otherNames.isNullOrBlank()){
//            otherNamesLayout.visibility(View.INVISIBLE)
//        } else {
            mOtherNames.setText(otherNames)
//        }














    }

    private fun closeOnError(){
        finish()
        Toast.makeText(this@SecondActivity, "Terminated as position not found", Toast.LENGTH_LONG).show()
    }
}
