package com.android.restapiexercise.ui.facts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.restapiexercise.R;
import com.android.restapiexercise.data.model.Facts;
import com.android.restapiexercise.data.model.Row;
import com.android.restapiexercise.ui.base.BaseViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Apple on 19/02/18.
 */

public class FactsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Row> mFactsList;

    public FactsAdapter(List<Row> factsList) {
        mFactsList = factsList;
    }

    public class ViewHolder extends BaseViewHolder implements View.OnClickListener {

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.tvDescription)
        TextView tvDescription;

        @BindView(R.id.ivFactImage)
        ImageView ivFactImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        protected void clear() {
            ivFactImage.setImageDrawable(null);
            tvTitle.setText("");
            tvDescription.setText("");
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            final Row row = mFactsList.get(position);
                Glide.with(itemView.getContext())
                        .asBitmap()
                        .load(row.getImageHref())
                        .apply(new RequestOptions()
                                .centerCrop()
                                .placeholder(R.drawable.img_placeholder))
                        .into(ivFactImage);

            if (row.getTitle() != null)
                tvTitle.setText(row.getTitle());

            if (row.getDescription() != null)
                tvDescription.setText(row.getDescription());

            if (row.getTitle() == null && row.getDescription() == null && row.getImageHref() == null){
                itemView.setVisibility(View.GONE);
                itemView.setLayoutParams(new RecyclerView.LayoutParams(0,0));
            }else {
                itemView.setVisibility(View.VISIBLE);
                itemView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
        }

        @Override
        public void onClick(View v) {
            //we are showing a toast to check if the correct position was tapped or not
            Toast.makeText(v.getContext(),"Clicked item : " + getAdapterPosition(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rowview_facts, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mFactsList.size();
    }

    public void addFacts(List<Row> factsList) {
        mFactsList = new ArrayList<>();
        mFactsList.addAll(factsList);
        notifyDataSetChanged();
    }
}
