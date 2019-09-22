package com.example.salahuddin.calculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button Switch;

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bdot,badd,bsub,bmul,bdiv,bopen,bclose,bclear,bequal;
    EditText tvExpression;
    TextView tvResult;
    ImageView bback;
    double var1,var2,ans;
    boolean add,sub,mul,div;
    DatabaseReference reff;
    History history;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("sdf");

        try {

           Switch = (Button)findViewById(R.id.Scientific);

           b0 = (Button) findViewById(R.id.Zero);
           b1 = (Button) findViewById(R.id.One);
           b2 = (Button) findViewById(R.id.Two);
           b3 = (Button) findViewById(R.id.Three);
           b4 = (Button) findViewById(R.id.Four);
           b5 = (Button) findViewById(R.id.Five);
           b6 = (Button) findViewById(R.id.Six);
           b7 = (Button) findViewById(R.id.Seven);
           b8 = (Button) findViewById(R.id.Eight);
           b9 = (Button) findViewById(R.id.Nine);
           bdot = (Button) findViewById(R.id.Dot);
           badd = (Button) findViewById(R.id.Plus);
           bsub = (Button) findViewById(R.id.Minus);
           bmul = (Button) findViewById(R.id.Multiply);
           bdiv = (Button) findViewById(R.id.Divide);
           bopen = (Button) findViewById(R.id.Open);
           bclose = (Button) findViewById(R.id.Close);
           bclear = (Button) findViewById(R.id.Clear);
           bback = (ImageView) findViewById(R.id.Backspace);
           bequal = (Button) findViewById(R.id.Equal);

           tvExpression = (EditText) findViewById(R.id.Expression);
           tvResult = (TextView) findViewById(R.id.Result);

            history = new History();

            reff = FirebaseDatabase.getInstance().getReference().child("History");

       }catch(Exception e){
           //Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
       }


       Switch.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               OpenMain2Activity();
           }
       });


        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvExpression.setText(tvExpression.getText()+"0");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvExpression.setText(tvExpression.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvExpression.setText(tvExpression.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvExpression.setText(tvExpression.getText()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvExpression.setText(tvExpression.getText()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvExpression.setText(tvExpression.getText()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvExpression.setText(tvExpression.getText()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvExpression.setText(tvExpression.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvExpression.setText(tvExpression.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvExpression.setText(tvExpression.getText()+"9");
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvExpression.setText(tvExpression.getText()+".");
            }
        });
        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var1 = Double.parseDouble(tvExpression.getText()+"");
                add  = true;
                tvExpression.setText(null);


            }
        });
        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var1 = Double.parseDouble(tvExpression.getText()+"");
//                var1 = Math.toRadians(var1);
//                var1 = Math.cos(var1);
                sub = true;
                //tvExpression.setText(String.valueOf(var1));
                tvExpression.setText(null);

            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mul == false) {
                    var1 = Double.parseDouble(tvExpression.getText() + "");
                }
                else {
                    var2 = Double.parseDouble(tvExpression.getText() + "");
                }
                mul  = true;
                tvExpression.setText(null);

            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var1 = Double.parseDouble(tvExpression.getText()+"");
                div  = true;
                tvExpression.setText(null);

            }
        });
        bopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvExpression.setText(tvExpression.getText()+"(");
            }
        });
        bclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvExpression.setText(tvExpression.getText()+")");
            }
        });
        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvExpression.setText(null);
                tvResult.setText(null);
            }
        });

        bback.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String temp = tvExpression.getText().toString();
                String s = temp.substring(0, temp.length()-1);
                tvExpression.setText(s);

            }
        });
        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = tvExpression.getText().toString();
                var2 = Double.parseDouble(tvExpression.getText()+"");

                if(add == true){
                    tvResult.setText(var1+var2+"");

                    tvExpression.setText(var1+var2+"");
                    history.setResult(tvExpression.getText().toString().trim());
                    reff.push().setValue(history);
                    tvExpression.setText(null);
                    Toast.makeText(MainActivity.this,"Data saved successfully",Toast.LENGTH_LONG);
                    ans=var1+var2;
                    save(ans);
                    add = false;
                }

                if(sub == true){
                    tvResult.setText(var1-var2+"");
                    ans=var1-var2;
                    save(ans);
                    sub = false;
                }

                if(mul == true){
                    tvResult.setText(var1*var2+"");
                    ans=var1*var2;
                    save(ans);
                    mul = false;
                }

                if(div == true){
                    tvResult.setText(var1/var2+"");
                    ans=var1/var2;
                    save(ans);
                    div = false;
                }
            }
        });


    }

    public void OpenMain2Activity(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

private void save(double result){
        String key=reff.push().getKey();
        reff.child(key).setValue(result);

}




}

