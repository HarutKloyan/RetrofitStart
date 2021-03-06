package com.example.retrofitstart;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private Context context;
    private List<Item> data;
    private String USER_AGENT;

    public ItemAdapter(Context context, List<Item> data) {
        this.context = context;
        this.data = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private TextView albumId;
        private Button more;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            albumId = itemView.findViewById(R.id.albumId);
            image = itemView.findViewById(R.id.image);
            more = itemView.findViewById(R.id.more);
        }

        @Override
        public void onClick(View v) {
            if (v.equals(more)) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show();
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(data.get(position).title);
        holder.albumId.setText("Album no" + data.get(position).albumId);

        GlideUrl url = new GlideUrl(data.get(position).url, new LazyHeaders.Builder()
                .addHeader("User-Agent", USER_AGENT)
                .build());
        Glide.with(context).load(url).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
