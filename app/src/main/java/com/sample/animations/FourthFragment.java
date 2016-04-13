package com.sample.animations;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

public class FourthFragment extends Fragment {
    private TextView TextView2;
    private TextView TextView1;

    public static FourthFragment getInstance(){
        return new FourthFragment();
    }
    public FourthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fargment_four, container, false);

        TextView1 = (TextView) view.findViewById(R.id.tv1);
        TextView2 = (TextView) view.findViewById(R.id.tv2
        );
        floatView();
        return view;
    }

    private void floatView() {
        final ObjectAnimator animXLeft = ObjectAnimator.ofFloat(TextView1, "x", -30f, 30f);
        final ObjectAnimator animXRight = ObjectAnimator.ofFloat(TextView2, "x", 30f, -30f);
        final ObjectAnimator fadeout1 = ObjectAnimator.ofFloat(TextView1, "alpha", 0.01f, 1f, 0.01f);
        final ObjectAnimator fadeout2 = ObjectAnimator.ofFloat(TextView2, "alpha", 0.01f, 1f, 0.01f);

        AnimatorSet animSetXY = new AnimatorSet();
        animSetXY.setDuration(10000);
        animSetXY.playTogether(animXLeft, animXRight, fadeout1, fadeout2);
        animSetXY.setInterpolator(new LinearInterpolator());
        animSetXY.start();

    }
}
