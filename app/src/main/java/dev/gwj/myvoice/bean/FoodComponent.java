package dev.gwj.myvoice.bean;

import dagger.Component;
import dev.gwj.myvoice.MainActivity;

/**
 * Created by dd on 18-4-12.
 */

@Component
public interface FoodComponent {

    void inject(MainActivity mainActivity);

}
