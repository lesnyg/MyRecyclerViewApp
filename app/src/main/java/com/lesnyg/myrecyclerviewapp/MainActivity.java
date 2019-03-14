package com.lesnyg.myrecyclerviewapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lesnyg.myrecyclerviewapp.models.Weather;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        WeatherRecyclerAdapter adapter = new WeatherRecyclerAdapter();
        adapter.addItems(weatherList);

        RecyclerView recyclerView = findViewById(R.id.weatherList);
        recyclerView.setAdapter(adapter);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, CardViewActivity.class);
        startActivity(intent);
    }

    public void onClick2(View view) {
        Intent intent = new Intent(this, recyclerExamActivity.class);
        startActivity(intent);
    }

    private static class WeatherRecyclerAdapter extends RecyclerView.Adapter<WeatherRecyclerAdapter.WeatherViewHolder> {
        private List<Weather> mItems = new ArrayList<>();

        @NonNull
        //실행 코드들을 작성,레이아웃을 뿌려준다. 실제 데이터가 아니다
        @Override
        public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater
                    .from(viewGroup.getContext())
                    .inflate(R.layout.item_weather, viewGroup, false);
            return new WeatherViewHolder(view);
        }

        //실제 데이터를 레이아웃에 뿌려주는 부분
        @Override
        public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {
            Weather weather = mItems.get(i);
            weatherViewHolder.weatherImageView.setImageResource(weather.getImageRes());
            weatherViewHolder.cityTextView.setText(weather.getCity());
            weatherViewHolder.tempTextView.setText(weather.getTemp());
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public void addItems(List<Weather> items) {
            mItems.addAll(items);
        }

        public static class WeatherViewHolder extends RecyclerView.ViewHolder {
            public ImageView weatherImageView;
            public TextView cityTextView;
            public TextView tempTextView;

            public WeatherViewHolder(@NonNull View itemView) {
                super(itemView);

                weatherImageView = itemView.findViewById(R.id.imageView);
                cityTextView = itemView.findViewById(R.id.cityText);
                tempTextView = itemView.findViewById(R.id.tempText);
            }
        }
    }
}
