package com.example.tanda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tanda.adapters.KeyValueAdapter;
import com.example.tanda.models.ChefModel;
import com.example.tanda.models.KeyValueModel;
import com.example.tanda.models.MasterclassModel;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MasterClass extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView mainRecycler, requirementsRecycler, termsRecycler;
    KeyValueAdapter mainAdapter, requirementsAdapter, termsAdapter;

    TextView title, chefName, chefCity, liveTime;
    ImageView chefAva, image;
    Button btnLink;
    MasterclassModel model;
    RelativeLayout live_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_class);
        toolbar = findViewById(R.id.masterclass_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        model = getModel();

        mainAdapter = new KeyValueAdapter(this, getMainInfo());
        requirementsAdapter = new KeyValueAdapter(this, model.getRequirementsList());
        termsAdapter = new KeyValueAdapter(this, model.getTermsList());
        mainRecycler = findViewById(R.id.masterclass_main_recycler);
        requirementsRecycler = findViewById(R.id.masterclass_requirements_recycler);
        termsRecycler = findViewById(R.id.masterclass_terms_recycler);
        live_layout = findViewById(R.id.live_layout);
        liveTime = findViewById(R.id.live_time);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if (sdf1.format(new Date()).compareTo(sdf1.format(model.getDate1())) < 0){
            live_layout.setVisibility(View.GONE);
        }else{
            live_layout.setVisibility(View.VISIBLE);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            liveTime.setText("У вас идет онлайн урок с " + sdf.format(model.getDate1()));
        }
        chefName = findViewById(R.id.recipe_card_author_name);
        chefCity = findViewById(R.id.recipe_card_author_city);
        chefAva = findViewById(R.id.recipe_card_author_ava);
        title = findViewById(R.id.masterclass_title);
        title.setText(model.getRecipeName());

        String fullName = model.getAuthor().getFirstName() + " " + model.getAuthor().getLastName();

        chefName.setText(fullName);
        Picasso.get().load(model.getAuthor().getAva()).into(chefAva);

        image = findViewById(R.id.masterclass_image);
        Picasso.get().load(model.getAuthor().getAva()).into(chefAva);


        btnLink = findViewById(R.id.masterclass_button);




        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mainRecycler.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mainRecycler.getContext(),
                linearLayoutManager.getOrientation());
        mainRecycler.addItemDecoration(dividerItemDecoration);
        mainRecycler.setAdapter(mainAdapter);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        requirementsRecycler.setLayoutManager(linearLayoutManager2);
        DividerItemDecoration dividerItemDecoration2 = new DividerItemDecoration(requirementsRecycler.getContext(),
                linearLayoutManager2.getOrientation());
        requirementsRecycler.addItemDecoration(dividerItemDecoration2);
        requirementsRecycler.setAdapter(requirementsAdapter);

        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this);
        termsRecycler.setLayoutManager(linearLayoutManager3);
        DividerItemDecoration dividerItemDecoration3 = new DividerItemDecoration(termsRecycler.getContext(),
                linearLayoutManager3.getOrientation());
        termsRecycler.addItemDecoration(dividerItemDecoration3);
        termsRecycler.setAdapter(termsAdapter);

    }

    private MasterclassModel getModel(){
        ChefModel chef2 = new ChefModel("https://www.escoffier.edu/wp-content/uploads/2015/11/Culinary-Arts-Program.png", "Чингис", "Рахад", "Нур-Султан");

        Calendar currentDate = Calendar.getInstance();
        currentDate.set(Calendar.YEAR, 2020);
        currentDate.set(Calendar.MONTH, 6);
        currentDate.set(Calendar.DAY_OF_MONTH, 22);
        currentDate.set(Calendar.HOUR, 9);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);

        return new MasterclassModel(
                "id", "imageURL", currentDate.getTime(), 2500, "Zoom", "1.5 часа", 5 ,"Фисташки", getRequirements(), getTerms(), chef2
                );
    }

    private ArrayList<KeyValueModel> getMainInfo(){
        ArrayList<KeyValueModel> list = new ArrayList<>();
        list.add(new KeyValueModel("Дата", model.getDate()));
        list.add(new KeyValueModel("Цена", String.valueOf(model.getPrice())));
        list.add(new KeyValueModel("Длительность", model.getDuration()));
        list.add(new KeyValueModel("Платформа", model.getPlatform()));
        list.add(new KeyValueModel("Участники", String.valueOf(model.getMembers())));
        return list;
    }

    private ArrayList<KeyValueModel> getRequirements(){
        ArrayList<KeyValueModel> list = new ArrayList<>();
        list.add(new KeyValueModel("Пол", "Женский"));
        list.add(new KeyValueModel("Возраст", "18+"));
        return list;
    }

    private ArrayList<KeyValueModel> getTerms(){
        ArrayList<KeyValueModel> list = new ArrayList<>();
        list.add(new KeyValueModel("1) Something about first term. Lorem Ipsum, bro. Lorem Ipsum, bro. Lorem Ipsum, bro"));
        list.add(new KeyValueModel("2) Do not forget about knife, bro. Do not forget about knife, bro. Do not forget about knife, bro"));
        return list;
    }

}