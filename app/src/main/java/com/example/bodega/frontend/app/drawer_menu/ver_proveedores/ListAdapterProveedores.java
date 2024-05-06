package com.example.bodega.frontend.app.drawer_menu.ver_proveedores;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodega.R;
import com.example.bodega.backend.clases.persona;

import java.util.List;

public class ListAdapterProveedores extends RecyclerView.Adapter<ListAdapterProveedores.ViewHolder> {
    private List<persona> mData;
    private final LayoutInflater mInflater;

    public ListAdapterProveedores(List<persona> itemList, Context context){
        this.mInflater=LayoutInflater.from(context);
        this.mData=itemList;
    }

    @Override
    public int getItemCount(){return mData.size();}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view=mInflater.inflate(R.layout.persona_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<persona> items){mData=items;}

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, correo, telefono, tipo;

        ViewHolder(View itemView){
            super(itemView);

            name=itemView.findViewById(R.id.nombreTextView);;
            correo=itemView.findViewById(R.id.correoTextView);
            telefono=itemView.findViewById(R.id.telefonoTextView);
            tipo=itemView.findViewById(R.id.tipoTextView);
        }

        void bindData(final persona item){
            name.setText(truncateText(item.getNombre()));
            correo.setText((item.getCorreo_electronico()));
            telefono.setText((item.getNumero_telefono()));
            tipo.setText("Proveedor");
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
