package sn.esmt.jobsearchapp.httpconfig;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {
    @GET("/api/cv/all") // retourne tous les objets CvResponse disponibles sur le serveur.
    Call<ArrayList<CvResponse>> getAllCvs();

    @GET("/api/cv/{id}") // retourne l'objet CvResponse ayant l'identifiant spécifié.
    Call<CvResponse> getCvById(@Path("id") int id);

    @POST("/api/cv/new") // ajoute un nouvel objet CvResponse sur le serveur.
    Call<CvResponse> addCv(@Body CvResponse cv);

    @PUT("/api/cv/{id}") // met à jour l'objet CvResponse ayant l'identifiant spécifié avec les nouvelles données fournies.
    Call<CvResponse> updateCv(@Path("id") int id, @Body CvResponse cv);

    @DELETE("/api/cv/{id}") // supprime l'objet CvResponse ayant l'identifiant spécifié
    Call<Void> deleteCv(@Path("id") int id);
}

/*
*Dans cette interface, on définit un ensemble de méthodes qui utilisent la
* bibliothèque Retrofit pour effectuer des requêtes HTTP vers un serveur.
* */
