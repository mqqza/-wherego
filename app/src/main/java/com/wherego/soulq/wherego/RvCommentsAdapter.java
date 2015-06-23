package com.wherego.soulq.wherego;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

import java.util.List;

public class RvCommentsAdapter extends RecyclerView.Adapter<RvCommentsAdapter.ViewHolder> {

    private List<Comments> items;
    private int itemLayout;

    public RvCommentsAdapter(int itemLayout, Context context, List<Comments> items) {
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
        final Comments item = items.get(position);
        viewHolder.mName.setText(item.getName());
        viewHolder.mText.setText(item.getText());
        viewHolder.mDate.setText(item.getDate());
        ImageLoader.getInstance().displayImage(item.getImage(), viewHolder.mImageView);
        viewHolder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private SquareImageView mImageView;
        private TextView mName;
        private TextView mText;
        private TextView mDate;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (SquareImageView) itemView.findViewById(R.id.imageView);
            mName = (TextView) itemView.findViewById(R.id.tvName);
            mText = (TextView) itemView.findViewById(R.id.tvText);
            mDate = (TextView) itemView.findViewById(R.id.tvDate);
        }
    }


}
