package com.example.salahuddin.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bdot,badd,bsub,bmul,bdiv,bopen,bclose,bclear,bequal;
    Button bsin,bcos,btan,blog,broot,bpow;
    EditText tvExpression;
    TextView tvResult;
    ImageView bback;
    double var1,var2,var3;
    boolean add,sub,mul,div;
    boolean sin,cos,tan,log,root,power;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myRef.setValue("hellow, world!");

        try {
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

            bsin = (Button) findViewById(R.id.Sin);
            bcos = (Button) findViewById(R.id.Cos);
            btan = (Button) findViewById(R.id.Tan);
            blog = (Button) findViewById(R.id.Log);
            broot = (Button) findViewById(R.id.Root);
            bpow = (Button) findViewById(R.id.Power);


            tvExpression = (EditText) findViewById(R.id.Expression);
            tvResult = (TextView) findViewById(R.id.Result);
        }catch(Exception e){
            //Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
        }

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


        bsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var1 = Double.parseDouble(tvExpression.getText()+"");
                var1 = Math.toRadians(var1);
                var1 = Math.sin(var1);
                tvResult.setText(String.valueOf(var1));


            }
        });

        bcos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var1 = Double.parseDouble(tvExpression.getText()+"");
                var1 = Math.toRadians(var1);
                var1 = Math.cos(var1);
                tvResult.setText(String.valueOf(var1));


            }
        });

        btan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var1 = Double.parseDouble(tvExpression.getText()+"");
                var1 = Math.toRadians(var1);
                var1 = Math.tan(var1);
                tvResult.setText(String.valueOf(var1));


            }
        });

        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var1 = Double.parseDouble(tvExpression.getText()+"");
                var1 = Math.log(var1);
                tvResult.setText(String.valueOf(var1));

            }
        });

        broot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var1 = Double.parseDouble(tvExpression.getText()+"");
                var1 = Math.sqrt(var1);
                tvResult.setText(String.valueOf(var1));

            }
        });

        bpow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var1 = Double.parseDouble(tvExpression.getText()+"");
                power = true;
                tvExpression.setText(null);
            }
        });



        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = tvExpression.getText().toString();
                var2 = Double.parseDouble(tvExpression.getText()+"");

                if(add == true){
                    tvResult.setText(var1+var2+"");
                    add = false;
                }

                if(sub == true){
                    tvResult.setText(var1-var2+"");
                    sub = false;
                }

                if(mul == true){
                    tvResult.setText(var1*var2+"");
                    mul = false;
                }

                if(div == true){
                    tvResult.setText(var1/var2+"");
                    div = false;
                }
//                if(power == true){
//                    var3 = Math.pow(var1,var2);
//                    tvResult.setText(var3);
//                    power = false;
//                }


            }
        });


    }
}
