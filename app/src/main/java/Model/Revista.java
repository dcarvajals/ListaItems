package Model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {

    private String issue_id = "";
    private String volume = "";
    private String number = "";
    private String year = "";
    private String date_published = "";
    private String title = "";
    private String doi = "";
    private String cover = "";

    public Revista (JSONObject jsonObject) throws JSONException {
        issue_id = jsonObject.getString("issue_id").toString();
        volume = jsonObject.getString("volume").toString();
        number = jsonObject.getString("number").toString();
        year = jsonObject.getString("year").toString();
        date_published = jsonObject.getString("date_published").toString();
        title = jsonObject.getString("title").toString();
        doi = jsonObject.getString("doi").toString();
        cover = jsonObject.getString("cover").toString();
    }

    public static ArrayList<Revista> JsonObjectsBuild  (JSONArray datos) throws JSONException{
        ArrayList<Revista> revistas = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            Log.e("CARGANDO.. ",datos.getJSONObject(i).toString());
            revistas.add(new Revista(datos.getJSONObject(i)));
        }
        return revistas;
    }

    public Revista() {
    }

    public String getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(String issue_id) {
        this.issue_id = issue_id;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

}
