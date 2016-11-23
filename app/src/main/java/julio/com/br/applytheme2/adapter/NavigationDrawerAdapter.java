package julio.com.br.applytheme2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import julio.com.br.applytheme2.R;
import julio.com.br.applytheme2.model.Landscape;
import julio.com.br.applytheme2.model.NavigationDrawerItem;

/**
 * Created by Shido on 15/11/2016.
 */

public class NavigationDrawerAdapter extends  RecyclerView.Adapter<NavigationDrawerAdapter.NavigationDrawerViewHolder>{

private List<NavigationDrawerItem> mdataList = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public NavigationDrawerAdapter(Context context, List<NavigationDrawerItem> navs){
        mdataList = navs;
        this.context = context;
        inflater = LayoutInflater.from(this.context);

    }


    @Override
    public NavigationDrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.nav_drawer_list_item, parent, false);
        NavigationDrawerViewHolder holder = new NavigationDrawerViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(NavigationDrawerViewHolder holder, int position) {
            NavigationDrawerItem current = mdataList.get(position);

            holder.title.setText(current.getTitle());
            holder.imgIcon.setImageResource(current.getImageId());
            holder.imgIcon.setOnClickListener((View v)->{
                    Toast.makeText(context, holder.title.getText().toString(), Toast.LENGTH_LONG).show();
        });


    }

    @Override
    public int getItemCount() {
        return mdataList.size();
    }


    class NavigationDrawerViewHolder extends RecyclerView.ViewHolder{


        TextView title;
        ImageView imgIcon;

        public  NavigationDrawerViewHolder(View v){
            super(v);
            imgIcon = (ImageView) v.findViewById(R.id.imgIcon);
            title = (TextView) v.findViewById(R.id.dtitle);
        }


    }


}
