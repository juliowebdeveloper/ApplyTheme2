package julio.com.br.applytheme2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import julio.com.br.applytheme2.R;
import julio.com.br.applytheme2.model.Landscape;

/**
 * Created by Shido on 06/11/2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

        private static final int PRIME_ROW = 0;
        private static final int NON_PRIME_ROW = 1;


        public List<Landscape> landscapeList;
        public LayoutInflater inflater;

    public RecyclerAdapter(List<Landscape> landscapeList, Context context){
        this.landscapeList = landscapeList;
        this.inflater = LayoutInflater.from(context);
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.list_row, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;


    }



    @Override
    public int getItemCount() {
        return landscapeList.size();
    }


    public int getItemViewType(int position){
        Landscape landscape = landscapeList.get(position);
        if(landscape.isPrime()){
            return PRIME_ROW;
        }else{
            return NON_PRIME_ROW;
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Landscape current = landscapeList.get(position);
        holder.setData(current, position);
        holder.setListeners();
    }


    public void removeItem(int position){
        landscapeList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, landscapeList.size());
    }

    public void addItem(int position, Landscape landscape){
        landscapeList.add(position, landscape);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, landscapeList.size());

    }







    class MyViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.txtTitle) TextView title;
        @BindView(R.id.imgRow) ImageView imgThumb;
        @BindView(R.id.imgRowDelete) ImageView imgDelete;
        @BindView(R.id.imgRowAdd) ImageView imgAdd;
        int position;
        Landscape current;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void setData(Landscape current, int position){
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageId());
            this.position = position;
            this.current = current;
        }

        public void setListeners(){
            imgDelete.setOnClickListener(MyViewHolder.this);
            imgAdd.setOnClickListener(MyViewHolder.this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case  R.id.imgRowDelete:
                    removeItem(position);
                    break;
                case R.id.imgRowAdd:
                    addItem(position, current );
                    break;
            }
        }
    }









}
