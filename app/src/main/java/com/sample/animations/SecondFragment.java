package com.sample.animations;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SecondFragment extends Fragment {

    private ProgressBar progressBar;
    private ImageView image;
    private View view;

    public static SecondFragment getInstance(){
        return new SecondFragment();
    }
    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fargment_second, container, false);
        this.view = view.findViewById(R.id.container);
        progressBar = (ProgressBar) view.findViewById(R.id.progress);
        image = (ImageView) view.findViewById(R.id.image);
        playAnim();
        return view;
    }

    public void playAnim(){
        ObjectAnimator rotatePart1 = ObjectAnimator.ofFloat(view, "rotationY", 90);
        ObjectAnimator rotatePart2 = ObjectAnimator.ofFloat(view, "rotationY", 360);

        rotatePart1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                progressBar.setVisibility(View.VISIBLE);
                image.setVisibility(View.INVISIBLE);
                view.setRotationY(270);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });

        AnimatorSet animSetXY = new AnimatorSet();
        animSetXY.setDuration(2000);
        animSetXY.playSequentially(rotatePart1, rotatePart2);
        animSetXY.start();

    }
}
