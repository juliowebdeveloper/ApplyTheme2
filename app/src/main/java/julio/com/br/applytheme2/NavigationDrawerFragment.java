package julio.com.br.applytheme2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import julio.com.br.applytheme2.adapter.NavigationDrawerAdapter;
import julio.com.br.applytheme2.model.NavigationDrawerItem;

/**
 * Created by Teste2 on 23/11/2016.
 */

public class NavigationDrawerFragment extends Fragment {

    @BindView(R.id.drawerList)
    RecyclerView recyclerView;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        ButterKnife.bind(this, view);
        setUpRecyclerView(view);

        return view;
    }

    private void setUpRecyclerView(View view) {
        //Pegando a instancia da activity na qual o navigation drawer existe (No caso a Main Activity)
        recyclerView.setAdapter(new NavigationDrawerAdapter(getActivity(), NavigationDrawerItem.getData()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }


    public void setUpDrawer(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar) {

        mDrawerToggle = new
                ActionBarDrawerToggle
                (getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close){
                    @Override
                    public void onDrawerClosed(View drawerView) {
                        super.onDrawerClosed(drawerView);
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        super.onDrawerOpened(drawerView);
                    }

                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        super.onDrawerSlide(drawerView, slideOffset);
                    }
                };
            mDrawerLayout = drawerLayout;

            mDrawerLayout.addDrawerListener(mDrawerToggle);


            //Utilizando Lambda em um metodo que pede uma Runnable
            mDrawerLayout.post(()-> mDrawerToggle.syncState());
            //Serve para ir rodando o icone de menu enquanto vai fazendo o slide do navigation drawer



          /*  mDrawerToggle.setToolbarNavigationClickListener
                    (view ->Toast.makeText(getActivity(),"On Drawer Closed",Toast.LENGTH_LONG).show() );*/

    }






}
