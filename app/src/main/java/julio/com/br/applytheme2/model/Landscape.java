package julio.com.br.applytheme2.model;

import java.util.ArrayList;

/**
 * Created by Shido on 06/11/2016.
 */

public class Landscape {

    private int imageId;
    private String title;
    private String description;
    private boolean prime;

    public boolean isPrime() {
        return prime;
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }

    public static ArrayList<Landscape> getData(){
        ArrayList<Landscape> dataListe = new ArrayList<>();
        int[] images = getImages();
        for(int  i= 0; i < images.length; i++){
            Landscape landscape=  new Landscape();
            landscape.setImageId(images[i]);
            landscape.setTitle("Landscape" + i);
            landscape.setPrime(checkPrime(i));
            dataListe.add(landscape);

        }

        return dataListe;
    }


    public static boolean checkPrime(int position){
        if(position == 0 || position == 1){
            return  false;
        }
        for(int i = 2; i <=position /2; ++i){
            if(position %i == 0){
                return false;
            }
        }
        return true;
    }


public static int[] getImages(){
    int[] images = {
        android.R.drawable.alert_light_frame, android.R.drawable.alert_dark_frame,
                android.R.drawable.arrow_down_float, android.R.drawable.btn_default,
        android.R.drawable.btn_dropdown, android.R.drawable.zoom_plate, android.R.drawable.toast_frame,
            android.R.drawable.dialog_holo_light_frame, android.R.drawable.gallery_thumb,
            android.R.drawable.alert_dark_frame, android.R.drawable.arrow_up_float


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
