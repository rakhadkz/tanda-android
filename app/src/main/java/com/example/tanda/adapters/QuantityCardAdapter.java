package com.example.tanda.adapters;

import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;
import com.example.tanda.holders.QuantityCardHolder;
import com.example.tanda.models.CollectionProductModel;
import com.example.tanda.models.FCProductModel;
import com.example.tanda.models.QuantityModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.HashMap;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class QuantityCardAdapter extends RecyclerView.Adapter<QuantityCardHolder>{
    Context context;
    ArrayList<QuantityModel> list;
    public static int position;
    PopupWindow mPopupWindow;
    FCProductModel currentProduct;
    public static HashMap<String, Integer> hashMap;
    CollectionProductModel inCollectionProduct;
    public QuantityCardAdapter(Context context, ArrayList<QuantityModel> list, FCProductModel currentProduct) {
        this.context = context;
        this.list = list;
        this.currentProduct = currentProduct;
    }
    private int currentCount = 0;

    @NonNull
    @Override
    public QuantityCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_quantity, null);
        return new QuantityCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuantityCardHolder holder, final int position) {
        if (!FCProductAdapter.isClickable){
            holder.itemView.setEnabled(false);
        }else{
            holder.itemView.setEnabled(true);
        }
        final QuantityModel model = list.get(position);
        CollectionProductModel currentProductInCollection = new CollectionProductModel(currentProduct.getName() + " " + model.getType(), model.getCount(), model.getPrice());
        CollectionProductModel.selectedProducts.add(currentProductInCollection);
        String price = model.getPrice() + " " + context.getResources().getString(R.string.tenge_symbol);
        holder.price.setText(price);
        holder.type.setText(model.getType());
        holder.count.setText(String.valueOf(model.getCount()));
        if (model.getCount() == 0)
            holder.count.setVisibility(View.INVISIBLE);
        else
            holder.count.setVisibility(View.VISIBLE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (model.getCount() == 0){
                    currentCount = 1;
                    hashMap.put(model.getId(), currentCount);
                }
                else
                    currentCount = model.getCount();

                if (CollectionProductModel.selectedProductsHash.containsKey(model.getId())){
                    inCollectionProduct = CollectionProductModel.selectedProductsHash.get(model.getId());
                }else{
                    inCollectionProduct = new CollectionProductModel(currentProduct.getName() + " " + model.getType(), currentCount, model.getPrice());
                    CollectionProductModel.selectedProductsHash.put(model.getId(), inCollectionProduct);
                }

                model.setCount(currentCount);
                holder.count.setVisibility(View.INVISIBLE);
                LayoutInflater inflater = (LayoutInflater) context.getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                assert inflater != null;
                View customView = inflater.inflate(R.layout.add_to_cart_popup,null);
                mPopupWindow = new PopupWindow(
                        customView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                ImageButton increase = customView.findViewById(R.id.popup_increase_quantity_button);
                final ImageButton decrease = customView.findViewById(R.id.popup_decrease_quantity_button);
                final ImageButton delete = customView.findViewById(R.id.popup_delete_quantity_button);
                if (currentCount == 1){
                    delete.setVisibility(View.VISIBLE);
                    decrease.setVisibility(View.GONE);
                }
                else{
                    delete.setVisibility(View.GONE);
                    decrease.setVisibility(View.VISIBLE);
                }
                final TextView count = customView.findViewById(R.id.popup_quantity_count);
                count.setText(String.valueOf(currentCount));

                increase.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        currentCount++;
                        hashMap.put(model.getId(), currentCount);
                        delete.setVisibility(View.GONE);
                        decrease.setVisibility(View.VISIBLE);
                        count.setText(String.valueOf(currentCount));
                        model.setCount(currentCount);
                        inCollectionProduct.setQuantity(currentCount);
                        CollectionProductModel.selectedProductsHash.put(model.getId(), inCollectionProduct);
                    }
                });
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        currentCount = 0;
                        hashMap.remove(model.getId());
                        CollectionProductModel.selectedProductsHash.remove(model.getId());
                        model.setCount(0);
                        mPopupWindow.dismiss();
                    }
                });
                decrease.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        currentCount--;
                        hashMap.put(model.getId(), currentCount);
                        inCollectionProduct.setQuantity(currentCount);
                        CollectionProductModel.selectedProductsHash.put(model.getId(), inCollectionProduct);
                        if (currentCount == 1){
                            delete.setVisibility(View.VISIBLE);
                            decrease.setVisibility(View.GONE);
                        }
                        else{
                            delete.setVisibility(View.GONE);
                            decrease.setVisibility(View.VISIBLE);
                        }
                        count.setText(String.valueOf(currentCount));
                        model.setCount(currentCount);
                    }
                });

                // Set an elevation value for popup window
                // Call requires API level 21
                if(Build.VERSION.SDK_INT >= 21){
                    mPopupWindow.setElevation(5.0f);
                }
                holder.quantity_layout.setAlpha((float) 0.5);
                mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        holder.quantity_layout.setAlpha(1);
                        notifyDataSetChanged();
                    }
                });
                mPopupWindow.setOutsideTouchable(true);
                mPopupWindow.setFocusable(true);
                mPopupWindow.showAsDropDown(view, 0, -holder.quantity_layout.getHeight() * 2, Gravity.CENTER_HORIZONTAL);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
