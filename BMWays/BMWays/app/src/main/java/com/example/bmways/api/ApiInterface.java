package com.example.bmways.api;

import com.example.bmways.modelos.Carroceria;
import com.example.bmways.modelos.Serie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiInterface {
   /* @POST("email")
    Call<List<usuario>> getUsuarios();

    @GET("existe_usuario.php")
    Call<List<usuario>> getUsuario(@Query("codigo") String codigo);
*/
    @POST("getSerie.php")
    Call<List<Serie>> getSeries();


    @POST("getCarroceria.php")
    Call<List<Carroceria>> getCarroceriasPorSerie(@Query("id_serie") String id_serie);


   /* @GET("get_usuario.php")
    Call<List<usuario>> getUsuarioDetail(@Query("codigo") String codigo);

    @GET("get_dispositivo.php")
    Call <dispositivo> getDispo (@Query("codigo") String codigo);

    @GET("get_dispositivos.php")
    Call<List<dispositivo>> getDispositivo(@Query("codigo") String codigo);

    @GET("get_curas.php")
    Call<List<cura>> getCuras(@Query("codigo") String codigo);

    @GET("inserta_cura.php")
    Call<String> insertaCura(@Query("fecha_cura") String fecha, @Query("incidencias") String incidencias, @Query("longitud_insercion") float insercion, @Query("procedimiento") String procedimiento, @Query("antiseptico") String antiseptico, @Query("complicaciones") String complicaciones, @Query("persona_realiza") String persona, @Query("lugar_realiza") String lugar, @Query("dispositivo") String dispositivo, @Query("usuario") String usuario);

    @GET("inserta_recordatorio.php")
    Call<String> insertaRecordatorio(@Query("id_usuario") String id_usuario, @Query("dispositivo") String dispositivo);

    @GET("get_longitudes.php")
    Call<String[]>getLongitudes(@Query("id_usuario") String id_usuario, @Query("dispositivo") String dispositivo);
    */
}
