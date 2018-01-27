package com.example.miguel909.bh2018;

/**
 * Created by miguel909 on 27/01/2018.
 */

class TribeItem {
    private static int[] resourceIds;
    private static String[] names;

    public TribeItem(){
        resourceIds = new int[] {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
        names = new String[] {"Ifugao", "Aeta"};
    }

    public static int[] getResourceIds() {
        return resourceIds;
    }

    public static void setResourceIds(int[] resourceIds) {
        TribeItem.resourceIds = resourceIds;
    }

    public static String[] getNames() {
        return names;
    }

    public static void setNames(String[] names) {
        TribeItem.names = names;
    }
}
