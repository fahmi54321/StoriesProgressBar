package com.android.a89storiesprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import jp.shts.android.storiesprogressview.StoriesProgressView;

public class MainActivity extends AppCompatActivity {

    StoriesProgressView storiesProgressView;
    ImageView imageView;

    int counter = 0;
    int[] resources = new int[]{
            R.drawable.fahmi,
            R.drawable.sayank1,
            R.drawable.sayank2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storiesProgressView = findViewById(R.id.stories);
        storiesProgressView.setStoriesCount(3);
        storiesProgressView.setStoryDuration(3000L);
        storiesProgressView.setStoriesListener(new StoriesProgressView.StoriesListener() {
            @Override
            public void onNext() {
                imageView.setImageResource(resources[++counter]);
            }

            @Override
            public void onComplete() {
                Toast.makeText(MainActivity.this, "Completed", Toast.LENGTH_SHORT).show();
            }
        });
        storiesProgressView.startStories();

        imageView = findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storiesProgressView.skip();
            }
        });

        imageView.setImageResource(resources[counter]);

    }

    @Override
    protected void onDestroy() {
        storiesProgressView.destroy();
        super.onDestroy();
    }
}