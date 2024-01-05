package WarOnGaza;

import java.util.ArrayList;

public interface Sortable {
//  sort the families based on the number of martyrs in each family
    public ArrayList<Family> sortByMartyrs(ArrayList<Family> families);


    //  sort the families based on the number of orphans in each family
    public ArrayList<Family>  sortByOrphans (ArrayList<Family> families);

}
