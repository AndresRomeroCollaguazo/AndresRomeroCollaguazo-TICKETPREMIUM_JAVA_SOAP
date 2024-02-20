package com.example.ticket_premium_movil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DetalleLcAdapter extends ArrayAdapter<Localidad> {
    private LayoutInflater inflater;
    private List<Integer> cantidades;

    public DetalleLcAdapter(Context context, List<Localidad> localidades, List<Integer> cantidad) {
        super(context, 0, localidades);
        inflater = LayoutInflater.from(context);
        cantidades = cantidad;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DetalleLcAdapter.ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_detallelc, parent, false);

            holder = new DetalleLcAdapter.ViewHolder();
            holder.nombreTextView = convertView.findViewById(R.id.txtNombreDetalle);
            holder.cantidadTextView = convertView.findViewById(R.id.txtCantidadDetalle);
            holder.precioTextView = convertView.findViewById(R.id.txtValorUnitario);
            holder.totalTextView = convertView.findViewById(R.id.txtValorTotal);

            convertView.setTag(holder);
        } else {
            holder = (DetalleLcAdapter.ViewHolder) convertView.getTag();
        }

        Localidad localidad = getItem(position);

        holder.nombreTextView.setText(localidad.getNombreLocalidad());
        holder.cantidadTextView.setText("Cantidad: " + String.valueOf(cantidades.get(position)));
        holder.precioTextView.setText("Valor Unitario: $" + String.valueOf(localidad.getPrecioLocalidad()) );
        holder.totalTextView.setText("Valor Total: $" + String.valueOf(cantidades.get(position) * localidad.getPrecioLocalidad())+ "\n");

        return convertView;
    }

    private static class ViewHolder {
        TextView nombreTextView;
        TextView cantidadTextView;
        TextView precioTextView;
        TextView totalTextView;

    }
}
