package WebServicies;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Adapter.RevistaAdapter;
import Model.Revista;

public class WsRevista {
    private String url = "";
    private JsonArrayRequest json_respuesta = null;
    private Context ctx;


    public WsRevista(String url, Context ctx){
        this.url = url;
        this.ctx = ctx;
    }

    public void executeWs(RecyclerView recyclerView){
        final ArrayList<Revista>[] lista_revistas = new ArrayList[]{new ArrayList<Revista>()};
        RequestQueue respuesta = Volley.newRequestQueue(this.ctx);
        JsonArrayRequest json_respuesta = new JsonArrayRequest(
                Request.Method.GET,
                this.url,
                null,
                new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            lista_revistas[0] = Revista.JsonObjectsBuild(response);



                            RevistaAdapter adaptador_revista = new RevistaAdapter(getCtx(), lista_revistas[0]);
                            recyclerView.setAdapter(adaptador_revista);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error", error.getMessage());
                    }
                });
        respuesta.add(json_respuesta);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JsonArrayRequest getJson_respuesta() {
        return json_respuesta;
    }

    public void setJson_respuesta(JsonArrayRequest json_respuesta) {
        this.json_respuesta = json_respuesta;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }
}
