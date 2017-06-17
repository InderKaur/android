package com.user_id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by HP on 07-06-2017.
 */

public class Second extends Activity {

    Button b;
    ImageView iv;
     int []array=new int[5];
    int m=0;


    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        array[0]=R.drawable.change;
        array[1]=R.drawable.nature;
        array[2]=R.drawable.image4;
        array[3]=R.drawable.image5;
      b=(Button)findViewById(R.id.button3);
        iv=(ImageView)findViewById(R.id.imageView);

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        Toast.makeText(Second.this, "Done", Toast.LENGTH_SHORT).show();
                        iv.setImageResource(array[m]);
                        m++;
                    if(m==4)
                    {
                        m=0;
                    }
                }
            });

    }




}
