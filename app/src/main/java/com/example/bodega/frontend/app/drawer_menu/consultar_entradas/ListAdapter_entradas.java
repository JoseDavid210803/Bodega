package com.example.bodega.frontend.app.drawer_menu.consultar_entradas;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodega.R;
import com.example.bodega.backend.clases.ticket;

import java.util.List;

public class ListAdapter_entradas extends RecyclerView.Adapter<ListAdapter_entradas.ViewHolder> {
    private List<ticket> mData;
    private final LayoutInflater mInflater;

    public ListAdapter_entradas(List<ticket> itemList, Context context){
        this.mInflater=LayoutInflater.from(context);
        this.mData=itemList;
    }

    @Override
    public int getItemCount(){return mData.size();}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view=mInflater.inflate(R.layout.entrada_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ticket> items){mData=items;}

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView name, cantidad, importe, fecha;

        ViewHolder(View itemView){
            super(itemView);

            name=itemView.findViewById(R.id.id_entranteTextView);
            cantidad=itemView.findViewById(R.id.cantidad_entranteTextView);
            importe=itemView.findViewById(R.id.importeTextView);
            fecha=itemView.findViewById(R.id.fechaTextView);

        }

        void bindData(final ticket item){
            name.setText(truncateText("Entrante N°" + item.getId()));
            cantidad.setText(String.valueOf(item.getNum_productos()));
            importe.setText("$" + item.getImporte());
            fecha.setText(item.getFecha().toString());
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
