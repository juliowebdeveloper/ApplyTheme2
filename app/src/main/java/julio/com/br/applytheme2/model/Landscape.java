package julio.com.br.applytheme2.model;

import java.util.ArrayList;

/**
 * Created by Shido on 06/11/2016.
 */

public class Landscape {

    private int imageId;
    private String title;
    private String description;


    public static ArrayList<Landscape> getData(){
        ArrayList<Landscape> dataListe = new ArrayList<>();
        int[] images = getImages();
        for(int  i= 0; i < images.length; i++){
            Landscape landscape=  new Landscape();
            landscape.setImageId(images[i]);
            landscape.setTitle("Landscape" + i);
            dataListe.add(landscape);
        }

        return dataListe;
    }

public static int[] getImages(){
    int[] images = {
        android.R.drawable.alert_light_frame, android.R.drawable.alert_dark_frame,
                android.R.drawable.arrow_down_float, android.R.drawable.btn_default,
        android.R.drawable.btn_dropdown, android.R.drawable.zoom_plate


    };
    return images;

}


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
