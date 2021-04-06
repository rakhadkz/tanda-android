package com.example.tanda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.tanda.adapters.SliderAdapterExample;
import com.example.tanda.models.SliderItem;
import com.example.tanda.models.StepModel;
import com.google.android.material.appbar.AppBarLayout;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class Recipe extends AppCompatActivity{
    RecyclerView stepRecycler;
    StepAdapter stepAdapter;
    int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        SliderView sliderView = findViewById(R.id.imageSlider);

        SliderAdapterExample adapter = new SliderAdapterExample(this);
        adapter.addItem(new SliderItem("Eggs", "https://cdn.pixabay.com/photo/2015/05/31/11/24/tap-791172_1280.jpg"));
        adapter.addItem(new SliderItem("Fruits", "https://cdn.pixabay.com/photo/2014/10/22/16/38/ingredients-498199_1280.jpg"));
        adapter.addItem(new SliderItem("Breakfast", "https://cdn.pixabay.com/photo/2015/05/25/14/29/strawberries-783351_1280.jpg"));
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        AppBarLayout appBarLayout = findViewById(R.id.appBarLayout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
                    final LinearLayout layout = findViewById(R.id.chef_layout);
                    layout.animate()
                            .translationY(0)
                            .alpha(0.0f)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    layout.setVisibility(View.GONE);
                                }
                            });
                } else if (verticalOffset == 0) {
                    final LinearLayout layout = findViewById(R.id.chef_layout);
                    layout.animate()
                            .translationY(0)
                            .alpha(1f)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    layout.setVisibility(View.VISIBLE);
                                }
                            });
                } else {
                    final LinearLayout layout = findViewById(R.id.chef_layout);
                    layout.animate()
                            .translationY(0)
                            .alpha(1f)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    layout.setVisibility(View.VISIBLE);
                                }
                            });
                }
            }
        });
    }

    private ArrayList<StepModel> getList(){
        ArrayList<StepModel> list = new ArrayList<>();
        list.add(new StepModel("https://cdn.pixabay.com/photo/2015/05/31/11/24/tap-791172_1280.jpg", "Яйцо с сахаром перемещиваем и " +
                "добавляем сливочное масло (не маргарин)", "На каждый сухой слой уходит по 3-4 столовой ложки"));
        list.add(new StepModel("https://cdn.pixabay.com/photo/2014/10/22/16/38/ingredients-498199_1280.jpg", "Нарезаем овощи"));
        list.add(new StepModel("https://cdn.pixabay.com/photo/2014/10/22/16/38/ingredients-498199_1280.jpg", "Нарезаем овощи"));
        list.add(new StepModel("https://cdn.pixabay.com/photo/2014/10/22/16/38/ingredients-498199_1280.jpg", "Нарезаем овощи"));
        list.add(new StepModel("https://cdn.pixabay.com/photo/2014/10/22/16/38/ingredients-498199_1280.jpg", "Нарезаем овощи"));
        return list;
    }
}