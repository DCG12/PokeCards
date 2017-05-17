package com.example.user.worldmeal;

import nl.littlerobots.cupboard.tools.provider.CupboardContentProvider;
import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class ContentProvider extends CupboardContentProvider {

    public static final String AUTHORITY = BuildConfig.APPLICATION_ID + ".provider";

    static {
        cupboard().register(Meals.class);
    }

    public ContentProvider() {
        super(AUTHORITY, 1);
    }
}
