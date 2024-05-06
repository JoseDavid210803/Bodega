package com.example.bodega.frontend.app.drawer_menu.registrar_entradas;
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
import com.example.bodega.backend.clases.Producto;
import com.example.bodega.backend.clases.pair;

import java.util.List;

public class ListAdapterRegistrarEntradas extends RecyclerView.Adapter<ListAdapterRegistrarEntradas.ViewHolder> {
    private List<pair<Producto, Integer>> mData;
    private final LayoutInflater mInflater;

    public ListAdapterRegistrarEntradas(List<pair<Producto, Integer>> itemList, Context context){
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

    public void setItems(List<pair<Producto, Integer>> items){mData=items;}

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

        void bindData(final pair<Producto, Integer> item){
            iconImage.setColorFilter(Color.parseColor(item.getFirst().getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(truncateText(item.getFirst().getNombre()));
            cantidad.setText(String.valueOf(item.getSecond())); // Convertir a String antes de setText
            precio.setText("$" + item.getFirst().getPrecio());
        }

        String truncateText(String s)
        {
            int max_tamanio=16;

            if(s.length()>max_tamanio)
            {
                return s.substring(0, max_tamanio) + "...";
            }
            else {
                return s;
            }

        }
    }
}
