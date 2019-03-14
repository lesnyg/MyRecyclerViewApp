package com.lesnyg.myrecyclerviewapp;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lesnyg.myrecyclerviewapp.models.Weather;

import java.util.ArrayList;
import java.util.List;

public class recyclerExamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_exam);

        RecyclerView recyclerView = findViewById(R.id.exam_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<Weather> weatherList = new ArrayList<>();
        weatherList.add(new Weather(R.drawable.weather_01, "수원", "18도"));
        weatherList.add(new Weather(R.drawable.weather_02, "안양", "14도"));
        weatherList.add(new Weather(R.drawable.weather_03, "부산", "17도"));
        weatherList.add(new Weather(R.drawable.weather_04, "광주", "11도"));
        weatherList.add(new Weather(R.drawable.weather_06, "대전", "13도"));
        weatherList.add(new Weather(R.drawable.weather_08, "평양", "12도"));
        weatherList.add(new Weather(R.drawable.weather_05, "제주", "20도"));
        weatherList.add(new Weather(R.drawable.weather_07, "도쿄", "17도"));
        weatherList.add(new Weather(R.drawable.weather_01, "수원", "18도"));
        weatherList.add(new Weather(R.drawable.weather_02, "안양", "14도"));
        weatherList.add(new Weather(R.drawable.weather_03, "부산", "17도"));
        weatherList.add(new Weather(R.drawable.weather_04, "광주", "11도"));
        weatherList.add(new Weather(R.drawable.weather_06, "대전", "13도"));
        weatherList.add(new Weather(R.drawable.weather_08, "평양", "12도"));
        weatherList.add(new Weather(R.drawable.weather_05, "제주", "20도"));
        weatherList.add(new Weather(R.drawable.weather_07, "도쿄", "17도"));


        MyAdapter adapter = new MyAdapter(weatherList);
        recyclerView.setAdapter(adapter);

    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        private List<Weather> mList;
        public MyAdapter(List<Weather> list) {
            mList = list;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_exam,viewGroup,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            Weather weather = mList.get(i);
            viewHolder.image.setImageResource(weather.getImageRes());
            viewHolder.city.setText(weather.getCity());
            viewHolder.temp.setText(weather.getTemp());
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView image;
            public TextView city;
            public TextView temp;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                image = findViewById(R.id.imageView3);
                city = findViewById(R.id.menu_text);
                temp = findViewById(R.id.count_text);

            }
        }


    }
}
