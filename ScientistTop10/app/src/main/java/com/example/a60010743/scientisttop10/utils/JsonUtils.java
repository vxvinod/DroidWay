package com.example.a60010743.scientisttop10.utils;

import android.util.Log;

import com.example.a60010743.scientisttop10.model.Scientist;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    /**
     * This method parses String from activity_detail.xml
     * describing the Sandwich name, place of origin, description, image.
     *
     * @param json is sandwich information from activity_detail.xml
     *
     * @return Sandwich object which name, place of origin, description, image url is stored
     *
     * @throws JSONException If JSON data cannot be properly parsed
     */
    public static Scientist parseSandwichJson(String json)
            throws JSONException {

        Scientist sandwichObj = null;
        /* Sandwich information such as name, Main name, other names, place of origin
           description, image url, ingredients
         */
        final String NAME = "name";
        final String MAIN_NAME = "mainName";
        final String ALSO_KNOWN_AS = "alsoKnownAs";
        final String PLACE_OF_ORIGIN = "placeOfOrigin";
        final String DESCRIPTION = "description";
        final String IMAGE = "image";
        final String INGREDIENTS = "ingredients";

        /* Parsing Main name and storing in name variable */
        JSONObject sandwichData = new JSONObject(json);
        JSONObject aName = sandwichData.getJSONObject(NAME);
        String name = aName.getString(MAIN_NAME);

        /* Parsing 'also known as' storing in array List*/
        JSONArray alsoNames = (JSONArray) aName.get(ALSO_KNOWN_AS);
        ArrayList<String> alsoKnownAs = new ArrayList<String>();
        for(int i = 0; i < alsoNames.length(); i++){
            alsoKnownAs.add(alsoNames.get(i).toString());
        }
        /* Parsing place of origin, description, image url, Ingredients */
        String placeOfOrigin = sandwichData.getString(PLACE_OF_ORIGIN);
        String description = sandwichData.getString(DESCRIPTION);
        String image = sandwichData.getString(IMAGE);
        JSONArray ingredients = (JSONArray) sandwichData.get(INGREDIENTS);
        ArrayList<String> ingredientArray = new ArrayList<String>();
        for(int i = 0; i < ingredients.length(); i++){
            ingredientArray.add(ingredients.get(i).toString());
        }

        /* Creating Sandwich object to store the above parsed data */
        sandwichObj = new Scientist(name, alsoKnownAs, placeOfOrigin, description, image, ingredientArray);
        Log.d("SANDWICH", sandwichObj.getMainName());
        return sandwichObj;
    }
}
