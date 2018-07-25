package org.robertlyon.newsreader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.PlaceViewHolder> {

    private Context mCtx;
    private List<String> newsArticles;

    Adapter(Context aContext, List<String> newsArticles)
    {
        mCtx = aContext;
        this.newsArticles = newsArticles;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View v = inflater.inflate(R.layout.recycler_layout, null);
        return new PlaceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        String article = newsArticles.get(position);
        holder.textView.setText(article);
    }

    @Override
    public int getItemCount() {
        return newsArticles.size();
    }


    class PlaceViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;

        PlaceViewHolder(final View itemView)
        {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
