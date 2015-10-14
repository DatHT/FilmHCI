package com.fpt.hci.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 10/10/2015.
 */
public class PlaceFilmBooking {
    String cinemaName;

    public String getCinemaName() {
        return cinemaName;
    }

    public PlaceFilmBooking(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public List<PlaceFilmBooking> initialData() {

        List<PlaceFilmBooking> list = new ArrayList<>();
        list.add(new PlaceFilmBooking("Galaxy Tân Bình"));
        list.add(new PlaceFilmBooking("Galaxy Quang Trung"));
        list.add(new PlaceFilmBooking("Galaxy Nguyễn Du"));
        list.add(new PlaceFilmBooking("Galaxy Nguyễn Trãi"));
        list.add(new PlaceFilmBooking("CGV Trường Sơn"));
        list.add(new PlaceFilmBooking("CGV Pandora"));
        list.add(new PlaceFilmBooking("Lotte"));
        list.add(new PlaceFilmBooking("BHD"));
        return list;
    }
}
