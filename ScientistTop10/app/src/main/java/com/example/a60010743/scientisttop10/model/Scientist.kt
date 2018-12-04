package com.example.a60010743.scientisttop10.model

import java.io.FileDescriptor

public class Scientist(name : String, otherNames : List<String>, origin : String,
                       desc : String, img : String, ing: List<String>){

    lateinit var mainName: String
    lateinit var alsoKnownAs:List<String>
    lateinit var placeOfOrigin:String
    lateinit var description:String
    lateinit var image:String
    lateinit var ingredients:List<String>

    init {
        mainName = name
        alsoKnownAs = otherNames
        placeOfOrigin = origin
        description = desc
        image = img
        ingredients = ing
    }


}