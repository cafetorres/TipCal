package me.cafetorres.myapplication.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;
import butterknife.Bind;
import butterknife.ButterKnife;
import me.cafetorres.myapplication.R;
import me.cafetorres.myapplication.models.TipRecord;

/**
 * Created by Carlos on 13/10/2016.
 */

public class TipAdapter extends RecyclerView.Adapter<TipAdapter.ViewHolder>{
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TipRecord element=dataset.get(position);
        String strTip = String.format(context.getString.global_message_tip),element.getTip());
        holder.txtContent.setText(strTip);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void  add(TipRecord record){
        dataset.add(0,record);
    }
    

    public static class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.txtContent)
        TextView txtContent;

        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
