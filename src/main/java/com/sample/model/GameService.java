package com.sample.model;

import java.util.*;

public class GameService {


    public List getavailablegames(GameType type) {

        List brands = new ArrayList();


        if (type.equals(GameType.PS4)) {
            brands.add("MGS");
            brands.add("Crash Bandicoot");
        } else if (type.equals(GameType.Xbox)) {
            brands.add("Halo");
            brands.add("Fable");
        } else if (type.equals(GameType.PC)) {
            brands.add("Age of Empires");
            brands.add("Dawn of War");
        } else {
            brands.add("NONE");
        }

        return brands;

    }
}