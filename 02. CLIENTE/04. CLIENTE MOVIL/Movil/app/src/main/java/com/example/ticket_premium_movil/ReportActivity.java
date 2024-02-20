package com.example.ticket_premium_movil;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaScannerConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import android.Manifest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ReportActivity extends AppCompatActivity {

    private TextView localidad;
    private TextView vendidos;
    private TextView recaudado;
    private Spinner partidoSeleccionado;
    private Button atras;
    private Button buscar;
    private Button descargar; // Nuevo botón para la descarga

    private List<Localidad> localidadesLc;
    int codigoPartido = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        localidad = findViewById(R.id.txtLocalidadNombre);
        vendidos = findViewById(R.id.txtVendidos);
        recaudado = findViewById(R.id.txtRecaudado);

        partidoSeleccionado = findViewById(R.id.spnPartidosDisponibles);

        atras = findViewById(R.id.btnAtrasReporte);
        buscar = findViewById(R.id.btnBuscar);
        descargar = findViewById(R.id.btnDescargar); // Referencia al nuevo botón

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                codigoPartido = ((Ticket) partidoSeleccionado.getSelectedItem()).getCodigoPartido();
                new ReportActivity.llenarLocalidadesTask().execute(codigoPartido);
            }
        });

        descargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generarArchivoTxt();
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReportActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        new ReportActivity.llenarSpinner().execute();

    }


    private class llenarSpinner extends AsyncTask<String, Void, List<Ticket>> {

        @Override
        protected List<Ticket> doInBackground(String... params) {
            List<Ticket> lista = WebServiceHelper.traerPartidos();
            return lista;
        }

        @Override
        protected void onPostExecute(List<Ticket> tickets) {
            TicketAdapter adapter = new TicketAdapter(ReportActivity.this, tickets);
            partidoSeleccionado.setAdapter(adapter);

        }
    }

    private class llenarLocalidadesTask extends AsyncTask<Integer, Void, List<Localidad>> {
        private Exception exception;
        @Override
        protected List<Localidad> doInBackground(Integer... params) {
            int codigoPartido = params[0];
            System.out.println(codigoPartido);
            List<Localidad> localidades = WebServiceHelper.traerLocalidades(codigoPartido);
            localidadesLc = localidades;
            return localidades;
        }

        @Override
        protected void onPostExecute(List<Localidad> localidades) {
            if (localidades != null) {
                StringBuilder LocalidadText = new StringBuilder();
                for (Localidad lc : localidades) {
                    LocalidadText.append(lc.getNombreLocalidad()).append("\n");
                }
                localidad.setText(LocalidadText.toString());
            } else {
                localidad.setText("Error en la conexión con el servicio web");
                if(exception != null){
                    localidad.append("\n\n");
                    localidad.append(exception.getMessage());
                }
            }
            new ReportActivity.TraerReporteTask().execute();
        }
    }

    private void generarArchivoTxt() {
        // Verifica si el permiso WRITE_EXTERNAL_STORAGE está concedido
        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            // El permiso está concedido, puedes generar el archivo aquí
            doGenerarArchivoTxt();
        } else {
            // El permiso no está concedido, solicítalo
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    private void doGenerarArchivoTxt() {
        // Obtén los valores de los TextView
        String localidadText = localidad.getText().toString();
        String vendidosText = vendidos.getText().toString();
        String recaudadoText = recaudado.getText().toString();

        // Combinar los datos en una cadena para el archivo de texto
        String datosTabla = "Localidad:\n" + localidadText + "\nVendidos:\n" + vendidosText + "\nRecaudado:\n" + recaudadoText;

        // Verifica si el permiso WRITE_EXTERNAL_STORAGE está concedido
        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            // Permiso concedido, puedes guardar el archivo en la carpeta de Descargas
            guardarArchivoEnDescargas(datosTabla);
        } else {
            // Permiso no concedido, solicítalo al usuario
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    private void guardarArchivoEnDescargas(String datosTabla) {
        // Obtener la ruta de la carpeta de Descargas
        File downloadsFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        try {
            File file = new File(downloadsFolder, "datos_reporte.txt");
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(datosTabla);
            osw.flush();
            osw.close();

            // Escanear el archivo para que sea visible en el sistema de archivos
            MediaScannerConnection.scanFile(this, new String[]{file.getAbsolutePath()}, null, null);

            // Muestra la ruta del archivo en un Toast
            Toast.makeText(this, "Archivo de texto generado en: " + file.getAbsolutePath(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al generar el archivo de texto en la carpeta de Descargas", Toast.LENGTH_SHORT).show();
        }
    }




    // Método para manejar el resultado de la solicitud de permisos
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido, intenta generar el archivo nuevamente
                doGenerarArchivoTxt();
            } else {
                // Permiso denegado, muestra un mensaje al usuario
                Toast.makeText(this, "Permiso de escritura en almacenamiento externo denegado", Toast.LENGTH_SHORT).show();
            }
        }
    }





    private class TraerReporteTask extends AsyncTask<Void, Void, List<Factura>> {

        @Override
        protected List<Factura> doInBackground(Void... voids) {
            // Llamada al método traerReporte para obtener las facturas
            return WebServiceHelper.traerReporte(codigoPartido);
        }

        @Override
        protected void onPostExecute(List<Factura> facturas) {
            // Aquí puedes procesar la lista de facturas obtenida
            if (facturas != null) {
                StringBuilder FacturaText = new StringBuilder();
                double aux = 0;
                int auxP = 0, auxT = 0, auxG = 0, auxGV = 0;
                for (Factura fc : facturas) {
                    aux = aux + fc.getPrecioTotal();
                    auxP = auxP + fc.getCantPalco();
                    auxT = auxT + fc.getCantTribuna();
                    auxG = auxG + fc.getCantGeneral();
                    auxGV = auxGV + fc.getCantGeneralVisita();
                }
                List<Integer> totales = new ArrayList<>();
                totales.add(auxT);
                totales.add(auxP);
                totales.add(auxG);
                totales.add(auxGV);
                StringBuilder FacturaTextRecaudado = new StringBuilder();
                for (int i = 0; i < localidadesLc.size(); i++) {
                    Localidad lc = localidadesLc.get(i);
                    int total = totales.get(i);
                    FacturaText.append(total).append("\n");
                    FacturaTextRecaudado.append("$").append(total * lc.getPrecioLocalidad()).append("\n");
                }
                vendidos.setText(FacturaText.toString());
                recaudado.setText(FacturaTextRecaudado.toString());
            } else {
                Log.e("ReportActivity", "No se pudo obtener el reporte de facturas");
            }
        }
    }



}