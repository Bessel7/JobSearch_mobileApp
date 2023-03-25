package sn.esmt.jobsearchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sn.esmt.jobsearchapp.httpconfig.Api;
import sn.esmt.jobsearchapp.httpconfig.ApiClient;
import sn.esmt.jobsearchapp.httpconfig.CvResponse;
import sn.esmt.jobsearchapp.tools.CVListAdapter;

public class CVListActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<CvResponse> cvList = new ArrayList<CvResponse>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvlist);
        listView = findViewById(R.id.listview_cv);
        displayCVList();
    }

    public void displayCVList(){

        //Création de l'objet Api à partir de la classe ApiClient
        Api api = ApiClient.getApi();

        //creation d'un objet Call pour l'appel à la méthode getAllCvs() de l'interface Api.
        Call<ArrayList<CvResponse>> call = api.getAllCvs();

        call.enqueue(new Callback<ArrayList<CvResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<CvResponse>> call, Response<ArrayList<CvResponse>> response) {
                if (response.isSuccessful()) {
                    Log.d("Response :", response.body().get(0).getEmail());
                    cvList.addAll(response.body());
                    CVListAdapter adpt = new CVListAdapter(CVListActivity.this,cvList);
                    Log.d("Debbugage : " , cvList.get(0).getPrenom());
                    listView.setAdapter(adpt);
                } else {
                    Log.d("error message exception", response.toString());

                }
            }

            @Override
            public void onFailure(Call<ArrayList<CvResponse>> call, Throwable t) {
                Log.d("Error : ", t.getMessage());
                //D/Error :: CLEARTEXT communication to 192.168.1.9 not permitted by network security policy
            }

        });


    }
}
