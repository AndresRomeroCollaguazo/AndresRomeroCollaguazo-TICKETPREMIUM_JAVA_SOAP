package com.example.ticket_premium_movil;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompraActivity extends AppCompatActivity {
    private Spinner seleccionPartidos;
    private ListView listaLocalidades;
    private TextView estadio;
    private Button comprar;
    private Button atras;
    private Button escoger;
    private Button agregar;

    int codigoPartido = 1;

    Map<String, Integer> cantidadesEscogidas = new HashMap<>();

    List<Localidad> localidadGuardada;
    List<Integer> selectedNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
        seleccionPartidos = findViewById(R.id.spnPartidos);
        listaLocalidades = findViewById(R.id.lstPartidos);
        estadio = findViewById(R.id.txtEstadio);

        comprar = findViewById(R.id.btnComprar);
        atras = findViewById(R.id.btnAtrasCompra);
        escoger = findViewById(R.id.btnEscoger);
        agregar = findViewById(R.id.btnAgregar);

        escoger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el código de partido seleccionado
                codigoPartido = ((Ticket) seleccionPartidos.getSelectedItem()).getCodigoPartido();

                // Llamar al servicio web para obtener la lista de localidades del partido seleccionado
                new LocalidadesTask().execute(codigoPartido);
            }
        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNumberDialog(localidadGuardada);
            }
        });

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Map.Entry<String, Integer> entry: cantidadesEscogidas.entrySet()) {
                    System.out.println(entry.getKey() + " = " + entry.getValue());
                }
                selectedNumbers = new ArrayList<>();
                for (int i=0; i<localidadGuardada.size(); i++){
                    Localidad lc = localidadGuardada.get(i);
                    if (cantidadesEscogidas.containsKey(lc.getNombreLocalidad())) {
                        selectedNumbers.add(cantidadesEscogidas.get(lc.getNombreLocalidad()));
                    } else {
                        selectedNumbers.add(0);
                    }
                }
                for (Integer integer : selectedNumbers) {
                    System.out.println(integer);
                }
                Intent intent = new Intent(CompraActivity.this, DetalleActivity.class);
                intent.putExtra("index", codigoPartido);
                intent.putExtra("cantidades", new ArrayList<>(selectedNumbers));
                startActivity(intent);
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CompraActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });


        new CompraActivity.LoginTask().execute();

    }

    private class LoginTask extends AsyncTask<String, Void, List<Ticket>> {

        @Override
        protected List<Ticket> doInBackground(String... params) {
            List<Ticket> lista = WebServiceHelper.traerPartidos();
            return lista;
        }

        @Override
        protected void onPostExecute(List<Ticket> tickets) {
            TicketAdapter adapter = new TicketAdapter(CompraActivity.this, tickets);
            seleccionPartidos.setAdapter(adapter);

        }
    }

    private class LocalidadesTask extends AsyncTask<Integer, Void, List<Localidad>> {

        @Override
        protected List<Localidad> doInBackground(Integer... params) {
                int codigoPartido = params[0];
                System.out.println(codigoPartido);
                List<Localidad> localidades = WebServiceHelper.traerLocalidades(codigoPartido);
                localidadGuardada = localidades;
                return localidades;
            }

        @Override
        protected void onPostExecute(List<Localidad> localidades) {
            /*LocalidadAdapter adapterLc = new LocalidadAdapter(CompraActivity.this, localidades);
            listaLocalidades.setAdapter(adapterLc);*/

            String mostrarEstadio = ((Ticket) seleccionPartidos.getSelectedItem()).getNombreEstadio();
            estadio.setText("Estadio: " + mostrarEstadio);
        }
    }

    private void showNumberDialog(List<Localidad> localidades) {

        AlertDialog.Builder builder = new AlertDialog.Builder(CompraActivity.this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_number_selection, null);
        builder.setView(dialogView);

        Spinner localidadSpinner = dialogView.findViewById(R.id.spnLocalidades);
        TextView entradas = dialogView.findViewById(R.id.txtEntradas);
        TextView disponibilidad = dialogView.findViewById(R.id.txtDisponible);
        TextView precioEntrada = dialogView.findViewById(R.id.txtPrecio);
        NumberPicker numberPicker = dialogView.findViewById(R.id.numberPicker);
        Button btnAccept = dialogView.findViewById(R.id.btnAccept);
        Button btnEscoger = dialogView.findViewById(R.id.btnEscogerLocalidad);

        LocalidadSpnAdapter adapter = new LocalidadSpnAdapter(CompraActivity.this, localidades);
        localidadSpinner.setAdapter(adapter);

        // Configura el NumberPicker según tus necesidades
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(10);

        final String[] nombre = new String[1];

        btnEscoger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Localidad lc = ((Localidad) localidadSpinner.getSelectedItem());
                entradas.setText("Selecciona el número de entradas de " + lc.getNombreLocalidad() + " que deseas: \n\n");
                disponibilidad.setText("Disponibles: " + lc.getDisponibilidadLocalidad() + "\n");
                precioEntrada.setText("Precio por unidad: $" + lc.getPrecioLocalidad()+ "\n");
                nombre[0] = lc.getNombreLocalidad();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cantidadesEscogidas.containsKey(nombre[0])) {
                    cantidadesEscogidas.put(nombre[0], numberPicker.getValue());
                } else {
                    cantidadesEscogidas.put(nombre[0], cantidadesEscogidas.get(nombre[0]) + numberPicker.getValue());
                }
                for (Map.Entry<String, Integer> map: cantidadesEscogidas.entrySet()) {
                    System.out.println("Localidad: " + map.getKey() + map.getValue());
                }
                // Crear una instancia de LocalidadAdapter y pasar el Map como argumento
                LocalidadAdapter adapter = new LocalidadAdapter(CompraActivity.this, cantidadesEscogidas);
                // Asignar el adaptador al ListView
                listaLocalidades.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                dialog.dismiss(); // Cierra el diálogo
            }
        });
    }
}