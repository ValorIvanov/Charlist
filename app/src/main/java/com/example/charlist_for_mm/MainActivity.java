package com.example.charlist_for_mm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ImageView imageViewChar;
    int count;

    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = 0;
        textView = findViewById(R.id.textDicethrow);
        Button button = findViewById(R.id.buttonDiceThrow);

        final EditText etName = (EditText) findViewById(R.id.textName);
        final EditText etRace = (EditText) findViewById(R.id.textRace);
        final EditText etMightNom = (EditText) findViewById(R.id.MightNom);
        final EditText etMightTek = (EditText) findViewById(R.id.MightTek);
        final EditText etReactionNom = (EditText) findViewById(R.id.ReactionNom);
        final EditText etReactionTek = (EditText) findViewById(R.id.ReactionTek);
        final EditText etMentalMightNom = (EditText) findViewById(R.id.MentalMightNom);
        final EditText etMentalMightTek = (EditText) findViewById(R.id.MentalMightTek);
        final EditText etConcentrationNom = (EditText) findViewById(R.id.ConcentrationNom);
        final EditText etConcentrationTek = (EditText) findViewById(R.id.ConcentrationTek);
        final EditText etCharismNom = (EditText) findViewById(R.id.CharismNom);
        final EditText etCharismTek = (EditText) findViewById(R.id.CharismTek);
        final EditText etMassiveNom = (EditText) findViewById(R.id.MassiveNom);
        final EditText etMassiveTek = (EditText) findViewById(R.id.MassiveTek);
        final CheckBox etMagichnost = (CheckBox) findViewById(R.id.textMagichnost);

        Button btnSave = (Button) findViewById(R.id.buttonSave);
        Button btnClear = (Button) findViewById(R.id.buttonClear);
        Button btnLoad = (Button) findViewById(R.id.buttonLoad);
        Button btnDelete = (Button) findViewById(R.id.buttonDelete);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings = getSharedPreferences("CharList", MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("Name", etName.getText().toString());
                editor.putString("Race", etRace.getText().toString());
                editor.putInt("MightNom", Integer.parseInt(etMightNom.getText().toString()));
                editor.putInt("MightTek", Integer.parseInt(etMightTek.getText().toString()));
                editor.putInt("ReactionNom", Integer.parseInt(etReactionNom.getText().toString()));
                editor.putInt("ReactionTek", Integer.parseInt(etReactionTek.getText().toString()));
                editor.putInt("MentalMightNom", Integer.parseInt(etMentalMightNom.getText().toString()));
                editor.putInt("MentalMightTek", Integer.parseInt(etMentalMightTek.getText().toString()));
                editor.putInt("ConcentrationNom", Integer.parseInt(etConcentrationNom.getText().toString()));
                editor.putInt("ConcentrationTek", Integer.parseInt(etConcentrationTek.getText().toString()));
                editor.putInt("CharismNom", Integer.parseInt(etCharismNom.getText().toString()));
                editor.putInt("CharismTek", Integer.parseInt(etCharismTek.getText().toString()));
                editor.putInt("MassiveNom", Integer.parseInt(etMassiveNom.getText().toString()));
                editor.putInt("MassiveTek", Integer.parseInt(etMassiveTek.getText().toString()));

                SharedPreferences sharedPreferences=getSharedPreferences("shared", 0);
                SharedPreferences.Editor editor1 =sharedPreferences.edit();
                editor1.putBoolean("checkboxMagichnost", etMagichnost.isChecked());
                editor1.commit();
                editor.apply();
                Toast.makeText(MainActivity.this, "Saved successful",Toast.LENGTH_SHORT).show();
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings = getSharedPreferences("CharList", MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                etName.setText(settings.getString("Name",""));
                etRace.setText(settings.getString("Race",""));
                etMightNom.setText(String.valueOf(settings.getInt("MightNom",0)));
                etMightTek.setText(String.valueOf(settings.getInt("MightTek",0)));
                etReactionNom.setText(String.valueOf(settings.getInt("ReactionNom",0)));
                etReactionTek.setText(String.valueOf(settings.getInt("ReactionTek",0)));
                etMentalMightNom.setText(String.valueOf(settings.getInt("MentalMightNom",0)));
                etMentalMightTek.setText(String.valueOf(settings.getInt("MentalMightTek",0)));
                etConcentrationNom.setText(String.valueOf(settings.getInt("ConcentrationNom",0)));
                etConcentrationTek.setText(String.valueOf(settings.getInt("ConcentrationTek",0)));
                etCharismNom.setText(String.valueOf(settings.getInt("CharismNom",0)));
                etCharismTek.setText(String.valueOf(settings.getInt("CharismTek",0)));
                etMassiveNom.setText(String.valueOf(settings.getInt("MassiveNom",0)));
                etMassiveTek.setText(String.valueOf(settings.getInt("MassiveTek",0)));

                SharedPreferences sharedPreferences= getSharedPreferences("shared", 0);
                etMagichnost.setChecked(sharedPreferences.getBoolean("checkboxMagichnost", false));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("0");
                etRace.setText("0");
                etMightNom.setText("0");
                etMightTek.setText("0");
                etReactionNom.setText("0");
                etReactionTek.setText("0");
                etMentalMightNom.setText("0");
                etMentalMightTek.setText("0");
                etConcentrationNom.setText("0");
                etConcentrationTek.setText("0");
                etCharismNom.setText("0");
                etCharismTek.setText("0");
                etMassiveNom.setText("0");
                etMassiveTek.setText("0");

                SharedPreferences sharedPreferences= getSharedPreferences("shared", 0);
                etMagichnost.setChecked(false);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings = getSharedPreferences("CharList", MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                editor.remove("Name");
                editor.remove("Race");
                editor.remove("ReactionNom");
                editor.remove("ReactionTek");
                editor.remove("MentalMightNom");
                editor.remove("MentalMightTek");
                editor.remove("ConcentrationNom");
                editor.remove("ConcentrationTek");
                editor.remove("CharismNom");
                editor.remove("CharismTek");
                editor.remove("MightNom");
                editor.remove("MightTek");
                editor.remove("MassiveNom");
                editor.remove("MassiveTek");

                SharedPreferences sharedPreferences=getSharedPreferences("shared", 0);
                SharedPreferences.Editor editor1 =sharedPreferences.edit();
                editor1.remove("checkboxMagichnost");

                editor.apply();
                editor1.apply();
                Toast.makeText(MainActivity.this, "Delete successful",Toast.LENGTH_SHORT).show();
            }
        });

        imageViewChar = findViewById(R.id.characterImage);
        imageViewChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_DENIED){
                    //permission not granted, request it.
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                    //show popup for runtime permission
                        requestPermissions(permissions, PERMISSION_CODE);
                    } else  {
                        //permission already granted
                        pickImageFromGallery();
                    }
                } else {
                    //system osis less then ghm...
                    pickImageFromGallery();
                }
            }
        });
    }

    private void pickImageFromGallery() {
        //intent to pick image
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    //handle result of runtime permission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    //permission was granted
                    pickImageFromGallery();
                } else {
                    //permission was denide
                    Toast.makeText(this,"Permission was denied!", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }

    //handle result of picked image


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            //set image to image view
            imageViewChar.setImageURI(data.getData());
        }
    }

    public void ThrowDice(View view) {
        count = (int) Math.round(Math.random()*4+1 - Math.random()*4+1);
        textView.setText(String.valueOf(count));

    }

    public void chooseImage(View view) {

    }
}
