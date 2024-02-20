package com.example.ticket_premium_movil;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DetalleActivity extends AppCompatActivity {

    private List<Integer> cantidades;
    private int codigoPartido;
    double totalPago;
    private double sumaSub = 0;
    private ListView listaLocalidades;
    private TextView subtotal;
    private TextView iva;
    private TextView total;
    private Button atras;
    private Button consumidor;
    private Button factura;
    private List<Localidad> listaLc;
    private String nombreFc;
    private String cedulaFc;
    private String direccionFc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Intent intent = getIntent();
        cantidades = intent.getIntegerArrayListExtra("cantidades");
        codigoPartido = intent.getIntExtra("index",0);

        listaLocalidades = findViewById(R.id.lstDetalle);

        subtotal = findViewById(R.id.txtSubtotal);
        iva = findViewById(R.id.txtIva);
        total = findViewById(R.id.txtTotal);

        atras = findViewById(R.id.btnAtrasDetalle);
        consumidor = findViewById(R.id.btnConsumidorFinal);
        factura = findViewById(R.id.btnFactura);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentA = new Intent(DetalleActivity.this, CompraActivity.class);
                startActivity(intentA);
            }
        });

        consumidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DetalleActivity.ConsumidorTask().execute();

            }
        });

        factura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTaxDialog();
            }
        });
        new DetalleActivity.LocalidadesTask().execute(codigoPartido);
    }

    private class LocalidadesTask extends AsyncTask<Integer, Void, List<Localidad>> {

        @Override
        protected List<Localidad> doInBackground(Integer... params) {
            int codigoPartido = params[0];
            System.out.println(codigoPartido);
            List<Localidad> localidades = WebServiceHelper.traerLocalidades(codigoPartido);
            listaLc = localidades;
            return localidades;
        }

        @Override
        protected void onPostExecute(List<Localidad> localidades) {
            DetalleLcAdapter adapterDetalleLc = new DetalleLcAdapter(DetalleActivity.this, localidades, cantidades);
            listaLocalidades.setAdapter(adapterDetalleLc);
            for (int i=0; i< localidades.size(); i++) {
                Localidad lc = localidades.get(i);
                sumaSub += lc.getPrecioLocalidad() * cantidades.get(i);
            }
            subtotal.setText("$" + String.valueOf(sumaSub));
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            iva.setText("$" + decimalFormat.format(sumaSub * 0.12));
            totalPago = (sumaSub * 0.12) + sumaSub;
            total.setText("$" + String.valueOf(totalPago));
        }
    }



    private class ConsumidorTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            WebServiceHelper.registroCompra("-","-","-",cantidades.get(1),cantidades.get(0),
                    cantidades.get(2),cantidades.get(3),totalPago,codigoPartido);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(DetalleActivity.this, "Compra exitosa", Toast.LENGTH_SHORT).show();
            showSuccessTax("-","-","-");
        }
    }

    private class FacturaTask extends AsyncTask<Void, Void, Void> {
        private String nombreCliente;
        private String cedula;
        private String direccion;
        private int cantPalco;
        private int cantTribuna;
        private int cantGeneral;
        private int cantGeneralVisita;
        private double totalPrecio;
        private int codigoPartido;

        public FacturaTask(String nombreCliente, String cedula, String direccion, int cantPalco, int cantTribuna,
                           int cantGeneral, int cantGeneralVisita, double totalPrecio, int codigoPartido) {
            this.nombreCliente = nombreCliente;
            this.cedula = cedula;
            this.direccion = direccion;
            this.cantPalco = cantPalco;
            this.cantTribuna = cantTribuna;
            this.cantGeneral = cantGeneral;
            this.cantGeneralVisita = cantGeneralVisita;
            this.totalPrecio = totalPrecio;
            this.codigoPartido = codigoPartido;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            WebServiceHelper.registroCompra(nombreCliente, cedula, direccion, cantPalco, cantTribuna, cantGeneral,
                    cantGeneralVisita, totalPrecio, codigoPartido);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(DetalleActivity.this, "Compra exitosa", Toast.LENGTH_SHORT).show();
            showSuccessTax(nombreFc, cedulaFc, direccionFc);
        }
    }

    private void showTaxDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(DetalleActivity.this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_tax_information, null);
        builder.setView(dialogView);

        EditText nombre = dialogView.findViewById(R.id.txtNombreFactura);
        EditText cedula = dialogView.findViewById(R.id.txtCedulaFactura);
        EditText direccion = dialogView.findViewById(R.id.txtDireccionFactura);

        Button btnComprar = dialogView.findViewById(R.id.btnComprarConFactura);
        AlertDialog dialog = builder.create();
        dialog.show();

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FacturaTask(nombre.getText().toString(), cedula.getText().toString(), direccion.getText().toString(),
                        cantidades.get(1),cantidades.get(0), cantidades.get(2),cantidades.get(3), totalPago, codigoPartido).execute();
                nombreFc = nombre.getText().toString();
                cedulaFc = cedula.getText().toString();
                direccionFc = direccion.getText().toString();
                dialog.dismiss(); // Cierra el diálogo
            }
        });
    }

    private void showSuccessTax(String name, String cedulaDiag, String direccionDiag){
        AlertDialog.Builder builder = new AlertDialog.Builder(DetalleActivity.this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_successful_tax, null);
        builder.setView(dialogView);

        StringBuilder localidadText = new StringBuilder();
        StringBuilder cantidadText = new StringBuilder();
        StringBuilder valorUText = new StringBuilder();
        StringBuilder valorTText = new StringBuilder();

        TextView nombre = dialogView.findViewById(R.id.txtNombreDialogFactura);
        TextView cedula = dialogView.findViewById(R.id.txtCedulaDialogFactura);
        TextView direccion = dialogView.findViewById(R.id.txtDireccionDialogFactura);
        TextView localidad = dialogView.findViewById(R.id.txtLocalidadNombreDialogFactura);
        TextView cantidad = dialogView.findViewById(R.id.txtCantidadDialogFactura);
        TextView valorU = dialogView.findViewById(R.id.txtValorUnitarioDialogFactura);
        TextView valorT = dialogView.findViewById(R.id.txtValorTotalDialogFactura);
        TextView valorSubTotal = dialogView.findViewById(R.id.txtSubtotalDialogFactura);
        TextView valorIva = dialogView.findViewById(R.id.txtIvaDialogFactura);
        TextView valorTotal = dialogView.findViewById(R.id.txtTotalDialogFactura);

        Button salir = dialogView.findViewById(R.id.btnSalir);

        nombre.setText(name);
        cedula.setText(cedulaDiag);
        direccion.setText(direccionDiag);
        valorSubTotal.setText("$"+String.valueOf(sumaSub));
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        valorIva.setText("$"+String.valueOf(decimalFormat.format(sumaSub * 0.12)));
        valorTotal.setText("$"+String.valueOf(totalPago));
        for (int i=0; i<listaLc.size(); i++){
            Localidad lc = listaLc.get(i);
            int aux = cantidades.get(i);
            localidadText.append(lc.getNombreLocalidad()).append("\n");
            cantidadText.append(String.valueOf(aux)).append("\n");
            valorUText.append("$").append(String.valueOf(lc.getPrecioLocalidad())).append("\n");
            valorTText.append("$").append(String.valueOf(lc.getPrecioLocalidad())).append("\n");

        }
        localidad.setText(localidadText.toString());
        cantidad.setText(cantidadText.toString());
        valorU.setText(valorUText.toString());
        valorT.setText(valorTText.toString());

        AlertDialog dialog = builder.create();
        dialog.show();

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentA = new Intent(DetalleActivity.this, MenuActivity.class);
                startActivity(intentA);
            }
        });
    }
}