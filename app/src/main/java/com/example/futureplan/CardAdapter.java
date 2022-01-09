package com.example.futureplan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<CardItem> cardItems;

    public CardAdapter(List<CardItem> cardItems) {
        this.cardItems = cardItems;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.card_item,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.setCardImage(cardItems.get(position));
    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {

        TextView fiszkisrc;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            fiszkisrc = itemView.findViewById(R.id.fiszkiText);
        }

        void setCardImage(CardItem cardItem) {
            fiszkisrc.setText(cardItem.getText());
        }
    }
}
