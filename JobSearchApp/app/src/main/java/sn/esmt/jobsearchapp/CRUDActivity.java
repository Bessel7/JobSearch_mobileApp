package sn.esmt.jobsearchapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sn.esmt.jobsearchapp.R;
import sn.esmt.jobsearchapp.httpconfig.Api;
import sn.esmt.jobsearchapp.httpconfig.ApiClient;
import sn.esmt.jobsearchapp.httpconfig.CvResponse;

public class CRUDActivity extends AppCompatActivity {

    private EditText editTextId, editTextNom, editTextPrenom, editTextAge, editTextAdresse, editTextEmail, editTextTelephone, editTextSpecialite, editTextNiveauEtude, editTextExperience;
    private Button buttonAdd, buttonUpdate, buttonDelete, buttonGet;

    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        api = ApiClient.getApi();

        editTextId = findViewById(R.id.editText_id);
        editTextNom = findViewById(R.id.editText_nom);
        editTextPrenom = findViewById(R.id.editText_prenom);
        editTextAge = findViewById(R.id.editText_age);
        editTextAdresse = findViewById(R.id.editText_adresse);
        editTextEmail = findViewById(R.id.editText_email);
        editTextTelephone = findViewById(R.id.editText_telephone);
        editTextSpecialite = findViewById(R.id.editText_specialite);
        editTextNiveauEtude = findViewById(R.id.editText_niveau_etude);
        editTextExperience = findViewById(R.id.editText_experience);

        buttonAdd = findViewById(R.id.button_ajouter);
        buttonUpdate = findViewById(R.id.button_modifier);
        buttonDelete = findViewById(R.id.button_supprimer);
        buttonGet = findViewById(R.id.button_lire);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCv();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCv();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteCv();
            }
        });

        buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCv();
            }
        });
    }

    // Fonction pour ajouter un CV
    private void addCv() {
        CvResponse cv = new CvResponse(
                Integer.parseInt(editTextId.getText().toString().trim()),
                editTextNom.getText().toString().trim(),
                editTextPrenom.getText().toString().trim(),
                Integer.parseInt(editTextAge.getText().toString().trim()),
                editTextAdresse.getText().toString().trim(),
                editTextEmail.getText().toString().trim(),
                editTextTelephone.getText().toString().trim(),
                editTextSpecialite.getText().toString().trim(),
                editTextNiveauEtude.getText().toString().trim(),
                editTextExperience.getText().toString().trim()
        );

        Call<CvResponse> call = api.addCv(cv);
        call.enqueue(new Callback<CvResponse>() {
            @Override
            public void onResponse(Call<CvResponse> call, Response<CvResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(CRUDActivity.this, "Erreur " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(CRUDActivity.this, "CV ajouté avec succès", Toast.LENGTH_SHORT).show();
                clearFields();
            }
            @Override
            public void onFailure(Call<CvResponse> call, Throwable t) {
                Toast.makeText(CRUDActivity.this, "Erreur " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Fonction pour mettre à jour un CV
    private void updateCv() {
        int id = Integer.parseInt(editTextId.getText().toString().trim());

        CvResponse cv = new CvResponse(
                id,
                editTextNom.getText().toString().trim(),
                editTextPrenom.getText().toString().trim(),
                Integer.parseInt(editTextAge.getText().toString().trim()),
                editTextAdresse.getText().toString().trim(),
                editTextEmail.getText().toString().trim(),
                editTextTelephone.getText().toString().trim(),
                editTextSpecialite.getText().toString().trim(),
                editTextNiveauEtude.getText().toString().trim(),
                editTextExperience.getText().toString().trim()
        );

        Call<CvResponse> call = api.updateCv(id, cv);
        call.enqueue(new Callback<CvResponse>() {
            @Override
            public void onResponse(Call<CvResponse> call, Response<CvResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(CRUDActivity.this, "Erreur " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(CRUDActivity.this, "CV mis à jour avec succès", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CvResponse> call, Throwable t) {
                Toast.makeText(CRUDActivity.this, "Erreur " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Fonction pour supprimer un CV
    private void deleteCv() {
        int id = Integer.parseInt(editTextId.getText().toString().trim());

        Call<Void> call = api.deleteCv(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(CRUDActivity.this, "Erreur " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(CRUDActivity.this, "CV supprimé avec succès", Toast.LENGTH_SHORT).show();
                clearFields();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(CRUDActivity.this, "Erreur " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Fonction pour récupérer un CV par ID
    private void getCv() {
        // Récupérer l'ID du CV à récupérer
        int cvId = Integer.parseInt(editTextId.getText().toString());

        // Appeler l'API pour récupérer le CV correspondant à cet ID
        Call<CvResponse> call = api.getCvById(cvId);
        call.enqueue(new Callback<CvResponse>() {
            @Override
            public void onResponse(Call<CvResponse> call, Response<CvResponse> response) {
                if (response.isSuccessful()) {
                    CvResponse cvResponse = response.body();

                    // Afficher les informations du CV dans les EditText correspondants
                    editTextNom.setText(cvResponse.getNom());
                    editTextPrenom.setText(cvResponse.getPrenom());
                    editTextAge.setText(String.valueOf(cvResponse.getAge()));
                    editTextAdresse.setText(cvResponse.getAdresse());
                    editTextEmail.setText(cvResponse.getEmail());
                    editTextTelephone.setText(cvResponse.getTelephone());
                    editTextSpecialite.setText(cvResponse.getSpecialite());
                    editTextNiveauEtude.setText(cvResponse.getNiveauEtude());
                    editTextExperience.setText(cvResponse.getExperienceProfessionnelle());

                    Toast.makeText(CRUDActivity.this, "CV récupéré avec succès", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CRUDActivity.this, "Erreur lors de la récupération du CV", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CvResponse> call, Throwable t) {
                Toast.makeText(CRUDActivity.this, "Erreur lors de la récupération du CV : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void clearFields() {
        editTextId.setText("");
        editTextNom.setText("");
        editTextPrenom.setText("");
        editTextAge.setText("");
        editTextAdresse.setText("");
        editTextEmail.setText("");
        editTextTelephone.setText("");
        editTextSpecialite.setText("");
        editTextNiveauEtude.setText("");
        editTextExperience.setText("");
    }
}