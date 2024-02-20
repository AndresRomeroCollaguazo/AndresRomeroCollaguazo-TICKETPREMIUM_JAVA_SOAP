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

public class TicketAdapter extends ArrayAdapter<Ticket> {
public TicketAdapter(Context context, List<Ticket> tickets) {
        super(context, 0, tickets);
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
                Ticket ticket = getItem(position);

                // Muestra la información del Ticket en la vista
                TextView textView = view.findViewById(android.R.id.text1);
                textView.setText(ticket.getEquipoLocal() + " vs " + ticket.getEquipoVisita() + " - "
                        + ticket.getFechaPartido().toString().substring(0,10) + " - " + ticket.getHoraPartido());

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
                Ticket ticket = getItem(position);

                // Muestra la información del Ticket en la vista
                TextView textView = view.findViewById(android.R.id.text1);
                textView.setText(ticket.getEquipoLocal() + " vs " + ticket.getEquipoVisita() + " - "
                        + ticket.getFechaPartido().toString().substring(0,10) + " - " + ticket.getHoraPartido());

                return view;
        }
}
