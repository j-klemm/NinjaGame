package com.example.jakob.ninjagame;

import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class InGameActvity extends AppCompatActivity {
    AnimationDrawable skateboardAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game_actvity);
        ConstraintLayout layout = (ConstraintLayout)findViewById(R.id.parentLayout);
        final ImageView backgroundOne = (ImageView) findViewById(R.id.background_one);
        final ImageView backgroundTwo = (ImageView) findViewById(R.id.background_two);

        final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(5000L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float progress = (float) animation.getAnimatedValue();
                final float height = backgroundOne.getHeight();
                final float translationY = height * progress;
                backgroundOne.setTranslationY(translationY);
                backgroundTwo.setTranslationY(translationY - height);
            }
        });
        animator.start();

        ImageView skateboardImage = (ImageView) findViewById(R.id.skateboard);
        skateboardImage.setBackgroundResource(R.drawable.skateboard_animation);
        skateboardAnimation = (AnimationDrawable) skateboardImage.getBackground();

        skateboardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(skateboardAnimation.isRunning()){
                    skateboardAnimation.stop();
                }
                    skateboardAnimation.start();

            }
        });
    }

    }

