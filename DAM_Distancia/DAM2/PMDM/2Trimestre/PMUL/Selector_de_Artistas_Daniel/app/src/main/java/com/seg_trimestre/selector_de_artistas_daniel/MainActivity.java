package com.seg_trimestre.selector_de_artistas_daniel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView img1, img2, img3, img4;
    private String urlSeleccionada = "", nombreCancion = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        img1 = findViewById(R.id.afterlive);
        img2 = findViewById(R.id.weGot);
        img3 = findViewById(R.id.saveRock);
        img4 = findViewById(R.id.hk_music);

        registerForContextMenu(img1);
        registerForContextMenu(img2);
        registerForContextMenu(img3);
        registerForContextMenu(img4);
    }

    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu, menu);

        if (v.getId()==R.id.afterlive) {
            urlSeleccionada = "https://en.wikipedia.org/wiki/AfterLife_(album)";
            nombreCancion = "Welcome to the Circus";
        } else if (v.getId() == R.id.weGot){
            urlSeleccionada = "https://en.wikipedia.org/wiki/Electric_Callboy";
            nombreCancion = "We got the moves";
        } else if (v.getId() == R.id.saveRock){
            urlSeleccionada = "https://en.wikipedia.org/wiki/Save_Rock_and_Roll";
            nombreCancion = "Where did the party go";
        } else if (v.getId() == R.id.hk_music){
            urlSeleccionada = "https://www.youtube.com/watch?v=mYEA5A0Bjyo";
            nombreCancion = "Dirtmouth";
        }
    }

    @Override
    public boolean onContextItemSelected (@NonNull MenuItem item) {
        if (item.getItemId() == R.id.info_cancion){
            Toast.makeText(this, nombreCancion, Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.abrir_web){
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("URL",urlSeleccionada);
            startActivity(intent);
            return true;
        } else
            return super.onContextItemSelected(item);
    }
}