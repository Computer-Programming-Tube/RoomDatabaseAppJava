package com.android.roomdatabaseappjava.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.android.roomdatabaseappjava.R;
import com.android.roomdatabaseappjava.data.Word;

public class WordAdapter extends ListAdapter<Word, WordAdapter.WordViewHolder> {

    public static DiffUtil.ItemCallback<Word> diffCallback = new DiffUtil.ItemCallback<Word>(){

        @Override
        public boolean areItemsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
            return oldItem.getWord() == newItem.getWord();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
            return true;
        }
    };

    public WordAdapter(@NonNull DiffUtil.ItemCallback<Word> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);


        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
            holder.bind(getItem(position));
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        private void bind(Word word){
           TextView tvWord =  itemView.findViewById(R.id.word);
           tvWord.setText(word.getWord());
        }
    }
}
