package com.example.bodega.frontend.app.drawer_menu.ver_stock;
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

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private final stockElementInterface stockElementInterface;
    private List<Producto> mData;
    private final LayoutInflater mInflater;
    public ListAdapter(List<Producto> itemList, Context context, stockElementInterface stockElementInterface){
        this.mInflater=LayoutInflater.from(context);
        this.mData=itemList;
        this.stockElementInterface=stockElementInterface;
    }
    @Override
    public int getItemCount(){return mData.size();}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view=mInflater.inflate(R.layout.stock_element, parent, false);
        return new ViewHolder(view, stockElementInterface);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<Producto> items){mData=items;}

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView name, cantidad, precio;

        ViewHolder(View itemView, stockElementInterface stockElementInterface){
            super(itemView);
            iconImage=itemView.findViewById(R.id.iconImageView);
            name=itemView.findViewById(R.id.nameTextView);
            cantidad=itemView.findViewById(R.id.cantidadTextView);
            precio=itemView.findViewById(R.id.precioTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if(stockElementInterface!=null){
                        int position =getAdapterPosition();

                        if(position!=RecyclerView.NO_POSITION)
                        {
                            stockElementInterface.onItemClick(position);
                        }
                    }
                }

            }
            );
        }

        void bindData(final Producto item){
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(truncateText(item.getNombre()));
            cantidad.setText(String.valueOf(item.getCantidad()));
            precio.setText("$" + item.getPrecio());


        }

        String truncateText(@NonNull String s)
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
