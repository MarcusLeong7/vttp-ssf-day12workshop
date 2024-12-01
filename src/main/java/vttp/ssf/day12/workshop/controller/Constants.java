package vttp.ssf.day12.workshop.controller;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public final static List<String> images;

    static {
        images = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            images.add(i + ".jpg");
        }
    }

}
