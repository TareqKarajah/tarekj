package WarOnGaza;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<Family> families=new ArrayList<>();
    
    public Manager() {

        }



    public boolean addFamily(Family family) {
        return families.add(family);
    }

    public boolean updateFamily(String familyName, Family updatedFamily) {
        for (Family family : families) {
            if (family.getFamilyName().equals(familyName)) {
                family.setFamilyName(updatedFamily.getFamilyName());
                return true;
            }
        }
        return false;
    }

    public boolean deleteFamily(String familyName) {
        for (Family family : families) {
            if (family.getFamilyName().equals(familyName)) {
                families.remove(family);
                return true;
            }
        }
        return false;
    }

    public Family searchByName(String familyName) {
        for (Family family : families) {
            if (family.getFamilyName().equalsIgnoreCase(familyName))
                return family;
        }
        return null;
    }

    public Person searchPersonById(String PersonId) {
        for (Family family : families) {
            for (Person person : family.getMembers()) {
                if (person.getID().equalsIgnoreCase(PersonId))
                    return person;
            }
        }
        return null;
    }
    public int calculateFamilyMartyrs(List<Person> family) {
        int totalMartyrs = 0;
        for (Person person : family) {
            if (person instanceof Martyr) {
                totalMartyrs++;
            }
        }
        return totalMartyrs;
    }

    public int calculateFamilyLivePersons(List<Person> family) {
        int totalLivePersons = 0;
        for (Person person : family) {
            if (person instanceof LivePerson) {
                totalLivePersons++;
            }
        }
        return totalLivePersons;
    }
    public int calculateTotalMartyrs() {
        int totalMartyrs = 0;
        for (Family family : families) {

            for (Person person : family.getMembers()) {
                if (person instanceof Martyr) {
                    totalMartyrs++;
                }
            }
            for (Person person : family.getParents()) {
                if (person instanceof Martyr) {
                    totalMartyrs++;
                }
            }
        }
        return totalMartyrs;
    }

        public int calculateTotalOrphans() {
        int totalOrphans = 0;
        for (Family family : families) {
            int bothParents = 0;
            for (Person person : family.getParents()) {
                if (person instanceof Martyr) {
                    bothParents++;
                    if(bothParents==2) {
                        for (Person person1 : family.getMembers()) {
                            if (person1 instanceof LivePerson) {
                                totalOrphans++;
                            }
                        }
                    }
                }
            }
        }
        return totalOrphans;
    }

    public int calculateTotalLivePersons() {
        int totalLivePersons = 0;
        for (Family family : families) {
            for (Person person : family.getMembers()) {
                if (person instanceof LivePerson) {
                    totalLivePersons++;
                }
            }
            for (Person person : family.getParents()) {
                if (person instanceof LivePerson) {
                    totalLivePersons++;
                }
            }

        }
        return totalLivePersons;
    }

    public List<Integer> calculateFamilyStatistics(String familyName) {
    int totalMartyrs = 0;
    int totalLivePersons = 0;
    int totalOrphans = 0;
    for (Family family : families) {
        if(family.getFamilyName() == familyName){
            int bothParents = 0;
            int flag = 0;
            for (Person person : family.getParents()) {
                flag++;
                if (person instanceof Martyr) {
                    totalMartyrs++;
                    bothParents++;
                    if(bothParents==2) {
                        for (Person person1 : family.getMembers()) {
                            if (person1 instanceof LivePerson) {
                                totalLivePersons++;
                                totalOrphans++;
                            }
                            else if (person1 instanceof Martyr) {
                                totalMartyrs++;
                            }
                        }
                    }
                }
                else {
                    totalLivePersons++;
                }
                System.out.println(bothParents+" "+flag);
                if(bothParents!=2 && flag==2){
                    for (Person person1 : family.getMembers()) {
                        if (person1 instanceof LivePerson) {
                            totalLivePersons++;
                        }
                        else if (person1 instanceof Martyr) {
                            totalMartyrs++;
                        }
                    }
                }

            }


        }

    }
    return List.of(totalMartyrs, totalLivePersons, totalOrphans);

}
    public List<Integer> calculateGlobalStatistics() {
        int totalMartyrs = 0;
        int totalLivePersons = 0;
        int totalOrphans = 0;
        totalMartyrs = this.calculateTotalMartyrs();
        totalLivePersons = this.calculateTotalLivePersons();
        totalOrphans = this.calculateTotalOrphans();
        return List.of(totalMartyrs, totalLivePersons, totalOrphans);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "families=" + families +
                '}';
    }
//        public void printAllFamilies() {
//        for (Family family : families) {
//            family.toString();
//        }
//    }
}
