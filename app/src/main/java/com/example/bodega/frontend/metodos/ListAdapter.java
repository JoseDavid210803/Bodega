package com.example.bodega.frontend.metodos;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodega.R;
import com.example.bodega.backend.clases.producto;
import com.example.bodega.frontend.app.drawer_menu.ver_stock.VerStockFragment;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<producto> mData;
    private final LayoutInflater mInflater;

    public ListAdapter(List<producto> itemList, Context context){
        this.mInflater=LayoutInflater.from(context);
        this.mData=itemList;
    }

    @Override
    public int getItemCount(){return mData.size();}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view=mInflater.inflate(R.layout.stock_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<producto> items){mData=items;}

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView name, cantidad, precio;

        ViewHolder(View itemView){
            super(itemView);
            iconImage=itemView.findViewById(R.id.iconImageView);
            name=itemView.findViewById(R.id.nameTextView);
            cantidad=itemView.findViewById(R.id.cantidadTextView);
            precio=itemView.findViewById(R.id.precioTextView);
        }

        void bindData(final producto item){
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(item.getNombre());
            cantidad.setText(String.valueOf(item.getCantidad())); // Convertir a String antes de setText
            precio.setText("$" + item.getPrecio());
        }
    }
}
