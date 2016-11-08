package julio.com.br.applytheme2;

import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import julio.com.br.applytheme2.adapter.RecyclerAdapter;
import julio.com.br.applytheme2.model.Landscape;

public class
MainActivity extends AppCompatActivity {


    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        /**********Toolbar  Standalone*************************/
        toolbar.setTitle("Welcome");
        toolbar.setSubtitle("Folks");
        toolbar.inflateMenu(R.menu.menu_main);
        //Method Reference Java 8
        toolbar.setOnClickListener(this::onClick);
        setUpOptionsMenu();


        setUpRecyclerView();
    }





    public void onClick(View v) {
        Snackbar.make(v, "teste", Snackbar.LENGTH_LONG).show();


    }


    public void setUpRecyclerView() {
        RecyclerAdapter adapter = new RecyclerAdapter(Landscape.getData(), this);

        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }




    public void setUpOptionsMenu(){
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                String msg = "";

                switch (item.getItemId()) {
                    case R.id.discard:
                        msg = "Delete";
                        break;

                    case R.id.search:
                        msg = "Search";
                        break;

                    case R.id.edit:
                        msg = "Edit";
                        break;

                    case R.id.settings:
                        msg = "Settings";
                        break;

                    case R.id.exit:
                        msg = "Exit";
                        break;
                }

                Snackbar.make(toolbar, msg, Snackbar.LENGTH_LONG).show();

                return true;
            }

        });
    }








}

        /**********Toolbar as a Action Bar*************************/

       /* toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Welcome !");
        getSupportActionBar().setSubtitle("Folks");
*/


        /*
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10f);
        }*/

        /*toolbar.setLogo(R.drawable.good_day);
        toolbar.setNavigationIcon(R.drawable.navigation_back) ;*/


/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";

        switch (item.getItemId()){
            case R.id.discard:
                msg = "Delete";
                break;

            case R.id.search:
                msg = "Search";
                break;

            case R.id.edit:
                msg = "Edit";
                break;

            case R.id.settings:
                msg = "Settings";
                break;

            case R.id.exit:
                msg = "Exit";
                break;
        }

        Snackbar.make(toolbar, msg, Snackbar.LENGTH_LONG).show();

        return super.onOptionsItemSelected(item);
    }
*/

