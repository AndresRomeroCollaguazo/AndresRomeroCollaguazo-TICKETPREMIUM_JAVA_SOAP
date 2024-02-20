package com.example.ticket_premium_movil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocalidadAdapter extends ArrayAdapter<Map.Entry<String, Integer>> {

    private LayoutInflater inflater;

    public LocalidadAdapter(Context context, Map<String, Integer> localidades) {
        super(context, 0, new ArrayList<>(localidades.entrySet()));
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_localidad, parent, false);

            holder = new ViewHolder();
            holder.nombreTextView = convertView.findViewById(R.id.nombreTextView);
            holder.cantidadTextView = convertView.findViewById(R.id.cantidadTextView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Map.Entry<String, Integer> entry = getItem(position);
        String nombreLocalidad = entry.getKey();
        int cantidad = entry.getValue();

        holder.nombreTextView.setText(nombreLocalidad);
        holder.cantidadTextView.setText("Cantidad: " + cantidad);

        return convertView;
    }

    private static class ViewHolder {
        TextView nombreTextView;
        TextView cantidadTextView;
    }
}
