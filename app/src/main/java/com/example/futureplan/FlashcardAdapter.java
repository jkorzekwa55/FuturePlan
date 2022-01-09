package com.example.futureplan;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FlashcardAdapter extends RecyclerView.Adapter<FlashcardAdapter.FlashcardViewHolder>{

    private List<Flashcard> flashcardsList;

    public FlashcardAdapter(List<Flashcard> flashcardsList) {
        this.flashcardsList = flashcardsList;
    }

    @NonNull
    @Override
    public FlashcardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FlashcardViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.new_flashcard_add_item,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull FlashcardViewHolder holder, int position) {
        //holder.setDataFlash(flashcardsList.get(position));
    }

    @Override
    public int getItemCount() {
        return flashcardsList.size();
    }

    class FlashcardViewHolder extends RecyclerView.ViewHolder {

      /**  EditText opis1;
        EditText notatka1;
        EditText opis2;
        EditText notatka2;**/

        public FlashcardViewHolder(@NonNull View itemView) {
            super(itemView);

           /** opis1 = itemView.findViewById(R.id.opis);
            notatka1 = itemView.findViewById(R.id.notatka);
            opis2 = itemView.findViewById(R.id.opis2);
            notatka2 = itemView.findViewById(R.id.notatka2);**/

        }

        void setDataFlash(Flashcard flashcard){
           /** String op1;
            String n1;
            String op2;
            String n2;

            op1 = opis1.getText().toString();
            n1 = notatka1.getText().toString();
            op2 = opis2.getText().toString();
            n2 = notatka2.getText().toString();

            //flashcard.setData(op1,n1,op2,n2);**/
        }


    }

}
