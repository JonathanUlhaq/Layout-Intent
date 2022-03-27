package com.example.belajarintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public static  String NAMA="";
    public static  String HOBI="";
    ImageView visible,visible1;
    boolean b = true;
    EditText passwords,confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText password = findViewById(R.id.username);
        EditText username = findViewById(R.id.password);

        //inisialisasi id

        visible = findViewById(R.id.visible);
        visible1 = findViewById(R.id.visible1);

        passwords = findViewById(R.id.password);
        confirm = findViewById(R.id.confirm);


        Button buton = findViewById(R.id.login);

        buton.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                validateEmpty();

            }
        });








        visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b)
                {
                    passwords.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    visible.setImageResource(R.drawable.unvisibility);
                    b = false;
                } else {
                    passwords.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    visible.setImageResource(R.drawable.visibility);
                    b = true;
                }
            }
        });


        visible1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b)
                {
                    confirm.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    visible1.setImageResource(R.drawable.unvisibility);
                    b = false;
                } else {
                    confirm.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    visible1.setImageResource(R.drawable.visibility);
                    b = true;
                }
            }
        });



    }

    //validasi inputan
//    public void validateEmPass()
//    {
//        EditText email;
//        email = findViewById(R.id.email);
//
//        String em = email.getText().toString().trim();
//        String pass = passwords.getText().toString().trim();
//        String conf = confirm.getText().toString().trim();
//
//
//    }

    // validasi
    public void validateEmpty()
    {
        //deklarasi

        EditText username,phone,email,universitas,studi;

        // insialisasi
        username = findViewById(R.id.username);
        phone = findViewById(R.id.phone);
        universitas = findViewById(R.id.universitas);
        studi = findViewById(R.id.program_studi);
        email = findViewById(R.id.email);

        //ambil nilai
        String pass = passwords.getText().toString().trim();
        String conf = confirm.getText().toString().trim();
        String usname = username.getText().toString().trim();
        String phon = phone.getText().toString().trim();
        String univ = universitas.getText().toString().trim();
        String stud = studi.getText().toString().trim();
        String em = email.getText().toString().trim();

        if (stud.isEmpty() && univ.isEmpty() && phon.isEmpty() && usname.isEmpty()  && em.isEmpty() && conf.isEmpty() && pass.isEmpty()  )
        {
            Toast.makeText(this, "Please fill all form", Toast.LENGTH_SHORT).show();
        }
       else if(pass.isEmpty())
        {
            Toast.makeText(this, "Please fill password", Toast.LENGTH_SHORT).show();
        } else if (conf.isEmpty())
        {
            Toast.makeText(this, "Please fill confirm password", Toast.LENGTH_SHORT).show();
        }
        else if (usname.isEmpty())
        {
            Toast.makeText(this, "Please fill username", Toast.LENGTH_SHORT).show();
        }
        else if (phon.isEmpty())
        {
            Toast.makeText(this, "Please fill phone number", Toast.LENGTH_SHORT).show();
        }
        else if (univ.isEmpty())
        {
            Toast.makeText(this, "Please fill university", Toast.LENGTH_SHORT).show();
        }
        else if (stud.isEmpty())
        {
            Toast.makeText(this, "Please fill study program", Toast.LENGTH_SHORT).show();
        }
        else if (em.isEmpty())
        {
            Toast.makeText(this, "Please fill study program", Toast.LENGTH_SHORT).show();
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(em).matches())
        {
            Toast.makeText(this, "Fill in according to the email format", Toast.LENGTH_SHORT).show();
        } else if (pass.length()<3){
            Toast.makeText(this, "Password min length 3 character", Toast.LENGTH_SHORT).show();
        } else if (!pass.equals(conf))
        {
            Toast.makeText(this, "Password are not same", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(MainActivity.this,Hasil.class);



            intent.putExtra("usname",usname);
            intent.putExtra("conf",conf);
            intent.putExtra("pass",pass);
            intent.putExtra("phon",phon);
            intent.putExtra("univ",univ);
            intent.putExtra("stud",stud);
            intent.putExtra("em",em);




            startActivity(intent);
        }

    } // end validasi


}