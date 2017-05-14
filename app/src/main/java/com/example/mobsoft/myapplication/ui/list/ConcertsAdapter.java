package com.example.mobsoft.myapplication.ui.list;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mobsoft.myapplication.MobSoftApplication;
import com.example.mobsoft.myapplication.R;
import com.example.mobsoft.myapplication.model.Concert;
import com.example.mobsoft.myapplication.ui.list.event.ConcertClickEvent;
import com.example.mobsoft.myapplication.ui.list.event.ConcertFavouriteClickEvent;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

public class ConcertsAdapter extends RecyclerView.Adapter<ConcertsAdapter.MyViewHolder> {

    @Inject
    EventBus bus;

    private List<Concert> concerts;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout concertRow;
        public TextView nameText;
        public TextView dateText;
        public ImageView favImage;

        public MyViewHolder(View view) {
            super(view);
            concertRow = (RelativeLayout) view.findViewById(R.id.concert_row);
            concertRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bus.post(new ConcertClickEvent(concerts.get(getAdapterPosition())));
                }
            });
            nameText = (TextView) view.findViewById(R.id.name_tv);
            dateText = (TextView) view.findViewById(R.id.date_tv);
            favImage = (ImageView) view.findViewById(R.id.fav_image);
            favImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bus.post(new ConcertFavouriteClickEvent(concerts.get(getAdapterPosition())));
                }
            });
        }
    }

    public ConcertsAdapter(List<Concert> concerts) {
        MobSoftApplication.injector.inject(this);
        this.concerts = concerts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.concerts_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Concert concert = concerts.get(position);
        holder.nameText.setText(concert.getName());
        holder.dateText.setText((concert.getDate() == null) ? "" : concert.getDate());
        holder.favImage.setAlpha(concert.getIsFavourite() ? 1.0f : 0.09f);
    }

    @Override
    public int getItemCount() {
        return concerts.size();
    }
}
