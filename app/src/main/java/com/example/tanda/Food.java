package com.example.tanda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tanda.adapters.CommentCardAdapter;
import com.example.tanda.adapters.IngredientSliderAdapter;
import com.example.tanda.adapters.SliderAdapterExample;
import com.example.tanda.models.IngredientModel;
import com.example.tanda.models.SliderItem;
import com.example.tanda.models.StepModel;
import com.google.android.material.appbar.AppBarLayout;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class Food extends AppCompatActivity {

    RecyclerView recyclerView, stepRecycler, commentRecycler;
    MyAdapter2 myAdapter;
    StepAdapter stepAdapter;
    CommentCardAdapter commentCardAdapter;
    boolean isImageFitToScreen;
    ImageView chefAvaSmall, chefAvaLarge;
    TextView recipeName, recipeHash, chefNameSmall, chefNameLarge;
    LinearLayout btnOrderMeal, btnConsultation;
    Button btnAddPortion, btnRemovePortion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        stepRecycler = findViewById(R.id.steps_recycler);
        stepRecycler.setLayoutManager(new LinearLayoutManager(this));

        stepAdapter = new StepAdapter(this, getList());
        stepRecycler.setAdapter(stepAdapter);

        commentRecycler = findViewById(R.id.comments_recycler);
        commentRecycler.setLayoutManager(new LinearLayoutManager(this));

        commentCardAdapter = new CommentCardAdapter(this, getComments());
        commentRecycler.setAdapter(commentCardAdapter);

        SliderView sliderView = findViewById(R.id.imageSlider);

        SliderAdapterExample adapter = new SliderAdapterExample(this);
        adapter.addItem(new SliderItem("Eggs", "https://cdn.pixabay.com/photo/2015/05/31/11/24/tap-791172_1280.jpg"));
        adapter.addItem(new SliderItem("Fruits", "https://cdn.pixabay.com/photo/2014/10/22/16/38/ingredients-498199_1280.jpg"));
        adapter.addItem(new SliderItem("Breakfast", "https://cdn.pixabay.com/photo/2015/05/25/14/29/strawberries-783351_1280.jpg"));
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        SliderView ingredientSlider = findViewById(R.id.ingredientSlider);
        IngredientSliderAdapter ingredientAdapter = new IngredientSliderAdapter(this, list());
        ingredientSlider.setSliderAdapter(ingredientAdapter);

        ingredientSlider.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        ingredientSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        ingredientSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        ingredientSlider.setScrollTimeInSec(4); //set scroll delay in seconds :
        ingredientSlider.startAutoCycle();



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

    public static boolean isVisible(final View view) {
        if (view == null) {
            return false;
        }
        if (!view.isShown()) {
            return false;
        }
        final Rect actualPosition = new Rect();
        view.getGlobalVisibleRect(actualPosition);
        final Rect screen = new Rect(0, 0, Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels);
        return actualPosition.intersect(screen);
    }

    private ArrayList<CommentModel> getComments(){
        ArrayList<CommentModel> list = new ArrayList<>();
        list.add(new CommentModel("https://images.statusfacebook.com/profile_pictures/Beautiful/Beautiful_Profile_Picture04.jpg", "Дина", "У меня всё получилось. Ура, спасибо. Детям всё " +
                "понравилось. Дальше будем смотреть у вас рецепты", "May 2020"));
        list.add(new CommentModel("https://live.staticflickr.com/8458/7910485066_10a1e5e586_b.jpg", "Еркежан", "Замечательный рецепт", "June 2020"));
        return list;
    }

    private ArrayList<StepModel> getList(){
        ArrayList<StepModel> list = new ArrayList<>();
        list.add(new StepModel("https://cdn.pixabay.com/photo/2015/05/31/11/24/tap-791172_1280.jpg", "Яйцо с сахаром перемещиваем и " +
                "добавляем сливочное масло (не маргарин)", "На каждый сухой слой уходит по 3-4 столовой ложки"));
        list.add(new StepModel("https://cdn.pixabay.com/photo/2014/10/22/16/38/ingredients-498199_1280.jpg", "Нарезаем овощи"));
        return list;
    }

    private ArrayList<IngredientModel> list(){
        ArrayList<IngredientModel> list = new ArrayList<>();
        ArrayList<ConcreteIngredient> list1 = new ArrayList<>();
        list1.add(new ConcreteIngredient("Лазаньи", "20 пластин"));
        list1.add(new ConcreteIngredient("Варёная сгущенка", "150 гр"));

        list.add(new IngredientModel("Общие", list1));

        ArrayList<ConcreteIngredient> list2 = new ArrayList<>();
        list2.add(new ConcreteIngredient("Фарши", "300 гр"));
        list2.add(new ConcreteIngredient("Лук", "300 гр", false));
        list2.add(new ConcreteIngredient("Морковь", "150 гр"));
        list2.add(new ConcreteIngredient("Помидор", "150 гр"));
        list2.add(new ConcreteIngredient("Зелень", "150 гр"));
        list2.add(new ConcreteIngredient("Томат", "150 гр"));
        list.add(new IngredientModel("Рагу", list2));
        return list;
    }
}