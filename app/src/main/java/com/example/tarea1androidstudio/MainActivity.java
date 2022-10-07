package com.example.tarea1androidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tarea1androidstudio.utilidades.Assets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Connection connection = new Connection(this, Assets.DB_NAME, null, Assets.DB_VERSION);
    }


        public void onClick(View view){

            Intent intent = null;

            switch (view.getId()){
                case R.id.btnRegistrar:
                    intent = new Intent(this, RegistrarProducto.class);
                    break;
                case R.id.btnListarProducto:
                    intent = new Intent(this, ListarProducto.class);
                    break;
            }
            if (intent!=null){
                startActivity(intent);
            }
        }
    }

