package me.cafetorres.myapplication.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.cafetorres.myapplication.R;
import me.cafetorres.myapplication.entity.TipRecord;
import me.cafetorres.myapplication.utils.TipUtils;

import static me.cafetorres.myapplication.entity.TipRecord_Table.timestamp;

/**
 * Created by Carlos on 13/10/2016.
 */

public class TipAdapter extends RecyclerView.Adapter<TipAdapter.ViewHolder>{

    private Context context;
    private List<TipRecord> dataset;
    private OnItemClickListener onItemClickListener;

    public TipAdapter(Context context, List<TipRecord> dataset, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.dataset = dataset;
        this.onItemClickListener=onItemClickListener;
    }
    public TipAdapter(Context context, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.dataset = new ArrayList<TipRecord>();
        this.onItemClickListener=onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);

        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TipRecord element=dataset.get(position);
        String strTip = String.format(context.getString(R.string.global_message_tip, TipUtils.getTip(element)));
        holder.txtContent.setText(strTip);
        holder.setOnItemClickListener(element,onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void  add(TipRecord record){
        //dataset.add(0,record);
        record.save();
        dataset=new Select().from(TipRecord.class).queryList();
        notifyDataSetChanged();
    }

    public void clear() {
        dataset.clear();
        Delete.table(TipRecord.class);
        notifyDataSetChanged();
    }

    public void init() {
        dataset=new Select().from(TipRecord.class).orderBy(timestamp,true).queryList();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.txtContent)
        TextView txtContent;

        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void setOnItemClickListener(final TipRecord element, final OnItemClickListener onItemClickListener){
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(element);
                }
            });
        }
    }
}
