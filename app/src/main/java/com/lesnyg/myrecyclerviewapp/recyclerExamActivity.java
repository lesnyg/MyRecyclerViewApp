package com.lesnyg.myrecyclerviewapp;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lesnyg.myrecyclerviewapp.models.CardItem;
import com.lesnyg.myrecyclerviewapp.models.Weather;

import java.util.ArrayList;
import java.util.List;

public class recyclerExamActivity extends AppCompatActivity {

    private MyAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_exam);

        mRecyclerView = findViewById(R.id.exam_view);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);

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


        mAdapter = new MyAdapter(weatherList);
        mRecyclerView.setAdapter(mAdapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.exam, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_add:
                Toast.makeText(this, "추가됨", Toast.LENGTH_SHORT).show();
                mAdapter.addItem(new Weather(R.drawable.weather_07, "추가한 내용","18도"), 0);
                mAdapter.notifyItemInserted(0);
                mRecyclerView.smoothScrollToPosition(0);
                return true;

            
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        private List<Weather> mList;

        private int mSelectedPosition = -1;

        public MyAdapter(List<Weather> list) {
            mList = list;
        }

        public void addItem(Weather weather,int index) {
            mList.add(index,weather);

        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_exam,viewGroup,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
            final Weather weather = mList.get(i);
            viewHolder.image.setImageResource(weather.getImageRes());
            viewHolder.city.setText(weather.getCity());
            viewHolder.temp.setText(weather.getTemp());

            if (mSelectedPosition == i) {
                viewHolder.itemView.setBackgroundColor(Color.parseColor("#b0c4de"));
            } else {
                viewHolder.itemView.setBackgroundColor(Color.WHITE);
            }
            
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mSelectedPosition = i;
                    notifyDataSetChanged();
                    Toast.makeText(recyclerExamActivity.this, weather.getCity()+" 선택", Toast.LENGTH_SHORT).show();
//                    v.setBackgroundColor(Color.parseColor("#b0c4de"));
//                    notifyDataSetChanged();
                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(recyclerExamActivity.this, weather.getCity()+" 삭제", Toast.LENGTH_SHORT).show();
                    mList.remove(i);



                    // 7. 어댑터에서 RecyclerView에 반영하도록 합니다.
                    notifyItemRemoved(i);
                    notifyItemRangeChanged(i, mList.size());

                    return true;
                }
            });
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
                image = itemView.findViewById(R.id.imageView3);
                city = itemView.findViewById(R.id.menu_text);
                temp = itemView.findViewById(R.id.count_text);

            }
        }


    }
}
