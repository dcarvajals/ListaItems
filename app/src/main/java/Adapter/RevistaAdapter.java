package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.listaitems.R;

import java.util.List;

import Model.Revista;

public class RevistaAdapter extends RecyclerView.Adapter<RevistaAdapter.RevistaViewHolder> {

    private Context ctx;
    private List<Revista> lista_revistas;

    public RevistaAdapter (Context mCtx, List<Revista> revistas) {
        this.lista_revistas = revistas;
        this.ctx = mCtx;
    }

    @Override
    public RevistaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.card_view, null);
        return new RevistaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RevistaAdapter.RevistaViewHolder holder, int position) {
        Revista revista = lista_revistas.get(position);

        holder.title.setText(revista.getTitle());
        holder.date_published.setText(revista.getDate_published());
        holder.volume.setText(revista.getVolume());
        holder.year.setText(revista.getYear());
        holder.doi.setText(revista.getDoi());

       Glide.with(ctx)
                .load(revista.getCover())
                .into(holder.cover);

       holder.cv_lista.setAnimation(AnimationUtils.loadAnimation(ctx, R.anim.left_to_right));

    }

    @Override
    public int getItemCount() {
        return lista_revistas.size();
    }

    class RevistaViewHolder extends RecyclerView.ViewHolder {
        TextView volume, year, date_published, title, doi;
        ImageView cover;
        CardView cv_lista;

        public RevistaViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_titulo_revista);
            cover = itemView.findViewById(R.id.iv_cover);
            date_published = itemView.findViewById(R.id.tv_fecha_publicacion);
            year = itemView.findViewById(R.id.tv_anio);
            volume = itemView.findViewById(R.id.tv_volumen);
            doi = itemView.findViewById(R.id.tv_doi);
            cv_lista = itemView.findViewById(R.id.cv_lista);
        }
    }
}


