package entity;

import android.app.Activity;
import android.location.Location;
import android.widget.Toast;

import java.util.Random;

public class MyLocation {
    private String commondata = "New location!";
    private Location locaFake;
    private Activity context;

    public MyLocation(Activity context) {
        this.context = context;
    }

    public void fakeLocation() {
        locaFake = new Location("fake");
        Random rd = new Random();
        locaFake.setLatitude(rd.nextDouble() * 199);
        locaFake.setLongitude(rd.nextDouble() * 199);
        commondata = "New location!";
    }

    public void htmlPassing2Android(String data) {
        Toast.makeText(context, "1. \n" + commondata, Toast.LENGTH_LONG).show();
        commondata = data;
        Toast.makeText(context, "2. \n" + commondata, Toast.LENGTH_LONG).show();
    }

    public String getCommondata() {
        return commondata;
    }

    public void setCommondata(String commondata) {
        this.commondata = commondata;
    }

    public Location getLocaFake() {
        return locaFake;
    }

    public void setLocaFake(Location locaFake) {
        this.locaFake = locaFake;
    }


}
