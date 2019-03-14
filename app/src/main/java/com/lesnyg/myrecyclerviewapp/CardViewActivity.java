package com.lesnyg.myrecyclerviewapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lesnyg.myrecyclerviewapp.models.CardItem;
import com.lesnyg.myrecyclerviewapp.models.Weather;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CardViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<CardItem> cardlist = new ArrayList<>();
        cardlist.add(new CardItem("제주", "20도"));
        cardlist.add(new CardItem("도쿄", "17도"));
        cardlist.add(new CardItem("수원", "18도"));
        cardlist.add(new CardItem("안양", "14도"));
        cardlist.add(new CardItem("부산", "17도"));
        cardlist.add(new CardItem("광주", "11도"));
        cardlist.add(new CardItem("대전", "13도"));
        cardlist.add(new CardItem("평양", "12도"));
        cardlist.add(new CardItem("제주", "20도"));
        cardlist.add(new CardItem("도쿄", "17도"));

        MyAdapter adapter = new MyAdapter(cardlist);

        recyclerView.setAdapter(adapter);
    }


    private static class MyAdapter extends RecyclerView.Adapter<MyAdapter.cardViewHolder> {
        private List<CardItem> mlist ;

        public MyAdapter(List<CardItem> list){
            mlist = list;
        }

//        public void additems(List<CardItem> cardlist) {
//            mlist.addAll(cardlist);
//        }

        @NonNull
        @Override
        public cardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card,viewGroup,false);
            return new cardViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull cardViewHolder cardViewHolder, int i) {
            CardItem item = mlist.get(i);
            cardViewHolder.title.setText(item.getTitle());
            cardViewHolder.contents.setText(item.getContents());
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }

        public static class cardViewHolder extends RecyclerView.ViewHolder {
            TextView title;
            TextView contents;
            public cardViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.title_text);
                contents = itemView.findViewById(R.id.contents_text);
            }
        }
    }
}
