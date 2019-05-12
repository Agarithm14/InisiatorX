package com.lombalomba.inisiator;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AddNewActivity extends AppCompatActivity {
    //Content layout
    LinearLayout contentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contentLayout = this.findViewById(R.id.content_add_new);

        //Get from prev intent
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            String name =(String) b.get("name");
            int type = (int) b.get("type");

            toolbar.setTitle("Add new " + name);

            switch (type) {
                case 0:
                    formArticle();
                    break;
                case 1:
                    formCompetition();
                    break;
                case 2:
                    formWorkshop();
                    break;
                case 3:
                    formSeminar();
                    break;
            }
        }
    }

    private void formArticle(){
        for(int i=0;i<3;i++){
            EditText editText = new EditText(this);
            editText.setText("test");
            contentLayout.addView(editText);
        }
    }

    private void formCompetition(){
        for(int i=0;i<3;i++){
            EditText editText = new EditText(this);
            editText.setText("test");
            contentLayout.addView(editText);
        }
    }
    private void formWorkshop(){
        for(int i=0;i<3;i++){
            EditText editText = new EditText(this);
            editText.setText("test");
            contentLayout.addView(editText);
        }
    }
    private void formSeminar(){
        for(int i=0;i<3;i++){
            EditText editText = new EditText(this);
            editText.setText("test");
            contentLayout.addView(editText);
        }
    }
}
