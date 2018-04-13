package dev.gwj.myvoice.bean;

import javax.inject.Inject;

/**
 * Created by dd on 18-4-12.
 */

public class Perseon {

    public Food food;
    @Inject
    public Perseon(Food food){
        this.food = food;
    }
}
