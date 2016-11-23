package julio.com.br.applytheme2.model;

import java.util.ArrayList;
import java.util.List;

import julio.com.br.applytheme2.R;

/**
 * Created by Shido on 15/11/2016.
 */

public class NavigationDrawerItem {


    private String title;
    private int imageId;


    private static int[] getImages(){
        return new int[]{
                R.drawable.ic_bird,
                R.drawable.ic_cat,
                R.drawable.ic_doc,
                R.drawable.ic_horse
        };
    }

    public static List<NavigationDrawerItem> getData(){
        List<NavigationDrawerItem> navs = new ArrayList<>();
        int[] images = getImages();
        String[] titles = getTitles();

        for (int i = 0; i< titles.length; i++){
            NavigationDrawerItem nav = new NavigationDrawerItem();
            nav.setTitle(titles[i]);
            nav.setImageId(images[i]);
            navs.add(nav);
        }

        return navs;
    }



    private static String[] getTitles(){
        return new String[]{
                "Birds","Cats", "Dogs", "Horses"
        };
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
