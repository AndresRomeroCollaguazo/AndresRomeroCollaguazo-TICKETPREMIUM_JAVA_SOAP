package com.example.ticket_premium_movil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class LocalidadSpnAdapter extends ArrayAdapter<Localidad> {
    public LocalidadSpnAdapter(Context context, List<Localidad> localidades) {
        super(context, 0, localidades);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obtén la vista del elemento seleccionado en el Spinner
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_item, parent, false);
        }

        // Obtén el objeto Ticket en la posición actual
        Localidad localidad = getItem(position);

        // Muestra la información del Ticket en la vista
        TextView textView = view.findViewById(android.R.id.text1);
        textView.setText(localidad.getNombreLocalidad());

        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obtén la vista para mostrar los elementos desplegados en el Spinner
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }

        // Obtén el objeto Ticket en la posición actual
        Localidad localidad = getItem(position);

        // Muestra la información del Ticket en la vista
        TextView textView = view.findViewById(android.R.id.text1);
        textView.setText(localidad.getNombreLocalidad());

        return view;
    }
}
