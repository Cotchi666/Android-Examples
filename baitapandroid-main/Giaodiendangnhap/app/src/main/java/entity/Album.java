package entity;



public class Album  {
    private String maAblum;
    private String tenAlbum;

    public Album(String maAblum, String tenAlbum) {
        this.maAblum = maAblum;
        this.tenAlbum = tenAlbum;
    }



    public String getMaAblum() {
        return maAblum;
    }

    public void setMaAblum(String maAblum) {
        this.maAblum = maAblum;
    }

    public String getTenAlbum() {
        return tenAlbum;
    }

    public void setTenAlbum(String tenAlbum) {
        this.tenAlbum = tenAlbum;
    }
}
