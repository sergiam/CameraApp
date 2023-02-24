package com.example.cameraapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.io.File;
import java.util.ArrayList;

public class CustomGalleryActivity extends AppCompatActivity {

    ArrayList<String> f = new ArrayList<>();
    File[] listFile;
    private String folderName = "MyPhotoDir";
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    private ImageButton buttonBack;
    


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        getFromSdcard();
        buttonBack = findViewById(R.id.button);
        viewPager = findViewById(R.id.viewPagerMain);
        viewPagerAdapter = new ViewPagerAdapter(this,f);
        viewPager.setAdapter(viewPagerAdapter);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomGalleryActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getFromSdcard(){
        File file = new File(getExternalFilesDir(folderName),"/");
        if (file.isDirectory()) {
            listFile = file.listFiles();
            for (int i = 0; i < listFile.length; i++) {
                f.add(listFile[i].getAbsolutePath());
            }
            System.out.println("niggerman");
        }
    }
}
