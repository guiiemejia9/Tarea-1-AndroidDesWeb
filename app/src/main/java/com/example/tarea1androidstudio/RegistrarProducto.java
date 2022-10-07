package com.example.tarea1androidstudio;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tarea1androidstudio.utilidades.Assets;

public class RegistrarProducto extends AppCompatActivity {
    EditText codigo, nombre, precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_producto);
        this.codigo=findViewById(R.id.editTextCodProduct);
        this.nombre=findViewById(R.id.editTextNameProduct);
        this.precio=findViewById(R.id.editTextPrice);
    }
    public void onClick(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.btnGuardar:
                //intent = new Intent(this, MainActivity.class );
                this.registrarUsuario();
                break;
            case R.id.btnGuardar2:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                break;
        }
        if (intent!=null){
            startActivity(intent);
        }
    }

    private void registrarUsuario(){
        try {
            Connection conexion = new Connection(this, Assets.DB_NAME, null, Assets.DB_VERSION);
            SQLiteDatabase sqLiteDatabase = conexion.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Assets.CAMPO_CODIGO_PRODUCTO, codigo.getText().toString());
            values.put(Assets.CAMPO_NOMBRE_PRODUCTO, nombre.getText().toString());
            values.put(Assets.CAMPO_PRECIO_PRODUCTO, precio.getText().toString());

            Long result= sqLiteDatabase.insert(Assets.TABLA_PRODUCTO, Assets.CAMPO_CODIGO_PRODUCTO, values);
            Toast.makeText(getApplicationContext(), "Producto Registrado", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }

}