package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;


public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;
    private TextView mOtherNames;
    private TextView mIngredients;
    private TextView mDescription;
    private ImageView mIngredientsIv;
    private TextView mOrigin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mIngredientsIv = findViewById(R.id.image_iv);
        mDescription = findViewById(R.id.s_description);
        mIngredients = findViewById(R.id.s_ingredients);
        mOtherNames  = findViewById(R.id.s_other_names);
        mOrigin      = findViewById(R.id.s_origin);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);

        try {
            String json = sandwiches[position];
            Sandwich sandwich = JsonUtils.parseSandwichJson(json);
            if (sandwich == null) {
                // Sandwich data unavailable
                closeOnError();
                return;
            }

            populateUI(sandwich);

            /* Display placeholder if not found or not loaded */
            Picasso.with(this)
                    .load(sandwich.getImage())
                    .resize(300, 200)
                    .placeholder(R.drawable.image_error)
                    .into(mIngredientsIv);

            setTitle(sandwich.getMainName());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich) {
        /* String Builder to store ingredients data and alsoName data */
        StringBuilder ingredientsData = new StringBuilder();
        StringBuilder mAlsoName = new StringBuilder();
        String origin;
        String otherName;

        /* handle of origin and name layout*/
        LinearLayout originLayout = (LinearLayout)this.findViewById(R.id.origin_layout);
        LinearLayout otherNameLayout = (LinearLayout)this.findViewById(R.id.other_names_layout);

        /* Construct String with ingredients data */
        for(String ing: sandwich.getIngredients()){
            ingredientsData.append("\u2022"+ing+"\n");
        }

        /* Construct String with alsoKnown name data */
        for(String name : sandwich.getAlsoKnownAs()){
            mAlsoName.append(name + ", ");
        }

        mDescription.setText(sandwich.getDescription());
        mIngredients.setText(ingredientsData.toString());

        /* Handle origin Layout visiblity on availability of data */
        origin = sandwich.getPlaceOfOrigin();
        if(origin.isEmpty() || origin.equals("null") || origin == null){
            originLayout.setVisibility(LinearLayout.GONE);
        } else {
            mOrigin.setText(sandwich.getPlaceOfOrigin());
        }

        /* Handle alsoKnownName Layout visiblity on availability of data */
        otherName = mAlsoName.toString().replaceAll(", $", "");
        if(otherName.equals("null") || otherName.isEmpty() || otherName == null){
            otherNameLayout.setVisibility(LinearLayout.GONE);
        } else {
            mOtherNames.setText(otherName);
        }


    }
}
