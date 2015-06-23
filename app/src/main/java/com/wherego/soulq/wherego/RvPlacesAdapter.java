package com.wherego.soulq.wherego;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class RvPlacesAdapter extends RecyclerView.Adapter<RvPlacesAdapter.ViewHolder> {

    private List<Places> items;
    private int itemLayout;

    public RvPlacesAdapter(int itemLayout, Context context, List<Places> items) {
        this.itemLayout = itemLayout;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        final Places item = items.get(position);
        viewHolder.mTitle.setText(item.getTitle());
        viewHolder.mAdress.setText(item.getAdress());
        if (item.getAdress().isEmpty())
            viewHolder.mAdress.setVisibility(View.GONE);
        else
            viewHolder.mAdress.setVisibility(View.VISIBLE);
        viewHolder.mAbout.setText(item.getAbout());
        ImageLoader.getInstance().displayImage(item.getImage(), viewHolder.mImageView);
        viewHolder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mTitle;
        private TextView mAdress;
        private TextView mAbout;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
            mTitle = (TextView) itemView.findViewById(R.id.tvName);
            mAdress = (TextView) itemView.findViewById(R.id.tvAdress);
            mAbout = (TextView) itemView.findViewById(R.id.tvAbout);
        }
    }


}
