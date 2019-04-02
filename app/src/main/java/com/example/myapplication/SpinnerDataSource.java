package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class SpinnerDataSource {

    public List<String> getDataSource() {
        List<String> versions = new ArrayList<>();
        versions.add("Cupcake");
        versions.add("Pie");
        versions.add("KitKat");
        versions.add("Lollipop");
        versions.add("Donut");

        return versions;
    }

}
