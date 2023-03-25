package sn.esmt.jobsearchapp.tools;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import sn.esmt.jobsearchapp.R;
import sn.esmt.jobsearchapp.httpconfig.CvResponse;

public class CVListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<CvResponse> cvList;
    private LayoutInflater inflater;

    // Constructeur
    public CVListAdapter(Context context, ArrayList<CvResponse> cvList) {
        this.context = context;
        this.cvList = cvList;
        inflater = LayoutInflater.from(context);
    }

    // Renvoie le nombre d'éléments dans la liste
    @Override
    public int getCount() {
        return cvList.size();
    }

    // Renvoie l'élément à la position donnée dans la liste
    @Override
    public Object getItem(int position) {
        return cvList.get(position);
    }

    // Renvoie l'ID de l'élément à la position donnée dans la liste
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Classe interne qui stocke les vues des éléments de la liste
    public static class ViewHolder {
        TextView nomPrenomTextView;
        TextView ageTextView;
        TextView adresseTextView;
        TextView emailTextView;
        TextView telephoneTextView;
        TextView specialiteTextView;
        TextView niveauEtudeTextView;
        TextView experienceTextView;
    }

    // Renvoie la vue de l'élément à la position donnée dans la liste
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        // Si convertView est null, on l'initialise avec le layout "listview_cv_item"
        // et on crée un nouvel objet ViewHolder qui va stocker les vues des éléments
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_cv_item, null);
            holder = new ViewHolder();
            holder.nomPrenomTextView = convertView.findViewById(R.id.nom_prenom_textview);
            holder.ageTextView = convertView.findViewById(R.id.age_textview);
            holder.adresseTextView = convertView.findViewById(R.id.adresse_textview);
            holder.emailTextView = convertView.findViewById(R.id.email_textview);
            holder.telephoneTextView = convertView.findViewById(R.id.telephone_textview);
            holder.specialiteTextView = convertView.findViewById(R.id.specialite_textview);
            holder.niveauEtudeTextView = convertView.findViewById(R.id.niveau_etude_textview);
            holder.experienceTextView = convertView.findViewById(R.id.experience_textview);
            convertView.setTag(holder);
        }
        // Sinon, on récupère l'objet ViewHolder déjà créé pour cette vue
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        // On récupère le CvResponse à la position donnée dans la liste
        CvResponse cv = cvList.get(position);

        // On met à jour les vues de l'élément avec les valeurs du CvResponse correspondant
        holder.nomPrenomTextView.setText(cv.getNom() + " " + cv.getPrenom());
        holder.ageTextView.setText(context.getString(R.string.age_format, cv.getAge()));
        holder.adresseTextView.setText(cv.getAdresse());
        holder.emailTextView.setText(cv.getEmail());
        holder.telephoneTextView.setText(cv.getTelephone());
        holder.specialiteTextView.setText(cv.getSpecialite());
        holder.niveauEtudeTextView.setText(cv.getNiveauEtude());
        holder.experienceTextView.setText(cv.getExperienceProfessionnelle());

        // On retourne la vue convertie
        return convertView;
    }
}
