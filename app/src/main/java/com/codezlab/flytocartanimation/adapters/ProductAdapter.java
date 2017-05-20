package com.codezlab.flytocartanimation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.codezlab.flytocartanimation.R;
import com.codezlab.flytocartanimation.models.Product;

import java.util.List;

/**
 * Created by coderzlab on 20/5/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    private List<Product> mList;
    private Context mContext;

    private ProductItemActionListener actionListener;
    public ProductAdapter(Context mContext, List<Product> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    public void setActionListener(ProductItemActionListener actionListener) {
        this.actionListener = actionListener;
    }


    @Override
    public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ProductHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_single_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final ProductHolder holder, int position) {


        Product product=mList.get(position);

        holder.itemIV.setImageResource(product.getResourceId());
        holder.itemCopyIV.setImageResource(product.getResourceId());

        holder.itemCopyIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actionListener!=null)
                    actionListener.onItemTap(holder.itemCopyIV);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class  ProductHolder extends RecyclerView.ViewHolder{


        protected ImageView itemIV;
        protected ImageView itemCopyIV;


        public ProductHolder(View itemView) {
            super(itemView);
            itemIV=(ImageView) itemView.findViewById(R.id.itemIV);
            itemCopyIV=(ImageView) itemView.findViewById(R.id.itemCopyIV);

        }

    }


    public interface ProductItemActionListener{
        void onItemTap(ImageView imageView);
    }
}
