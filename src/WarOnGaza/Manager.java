package WarOnGaza;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private static List<Family> families = new ArrayList<>();

    public Manager() {

    }


    public ArrayList<Family> getFamilies() {
        return (ArrayList<Family>) families;
    }

    // adds a new family to the system
    public boolean addFamily(Family family) {
        System.out.println("Family added successfully");
        return families.add(family);
    }

//    add family to the system from the console
    public boolean addFamily(String familyName) {
        Family family = new Family(familyName);
        System.out.println("Family added successfully");
        return families.add(family);
    }
//    method to add a member to the family from the console the user will enter the family name and the member attributes
    public boolean addMember(String familyName, Person member, String roleInFamily) {
        for (Family family : families) {
            if (family.getFamilyName().equalsIgnoreCase(familyName)) {
                family.addMember(member, roleInFamily);
                return true;
            }
        }
        return false;
    }
//    method to remove a member from the family from the console the user will enter the family name and the member attributes
    public boolean removeMember(String familyName, Person member) {
        for (Family family : families) {
            if (family.getFamilyName().equalsIgnoreCase(familyName)) {
                family.removeMember(member);
                System.out.println("Member removed successfully");
                return true;
            }
        }
        return false;
    }
    // Updates information about a family based on Family name
    public boolean updateFamily(String familyName, Family updatedFamily) {
        for (Family family : families) {
            if (family.getFamilyName().equals(familyName)) {
                family.setFamilyName(updatedFamily.getFamilyName());
                System.out.println("Family updated successfully");
                return true;
            }
        }
        return false;
    }

    // Deletes a family from the system based on Family name.
    public boolean deleteFamily(String familyName) {
        for (Family family : families) {
            if (family.getFamilyName().equals(familyName)) {
                families.remove(family);
                return true;
            }
        }
        return false;
    }

    // Searches for a family based on Family name.
    public Family searchByName(String familyName) {
        for (Family family : families) {
            if (family.getFamilyName().equalsIgnoreCase(familyName))
                return family;
        }
        return null;
    }

    // Searches for a person based on their ID.
    public Person searchPersonById(String PersonId) {
        for (Family family : families) {
            for (Person person : family.getMembers()) {
                if (person.getID().equalsIgnoreCase(PersonId))
                    return person;
            }
        }
        return null;
    }

    // Returns the total number of martyrs in the system.
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

    // Returns the total number of orphans in the system. orphan is a person who lost both parents.
    public int calculateTotalOrphans() {
        int totalOrphans = 0;
        for (Family family : families) {
            int bothParents = 0;
            for (Person person : family.getParents()) {
                if (person instanceof Martyr) {
                    bothParents++;
                    if (bothParents == 2) {
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

    // Returns the total number of live persons in the system.
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

    // Returns statistics for a specific family, including the number of martyrs, orphans, and live persons.
    //    the flag is to not count the parents twice
    //    the bothParents is to check if the family has both parents dead
    public List<Integer> calculateFamilyStatistics(String familyName) {
        int totalMartyrs = 0;
        int totalLivePersons = 0;
        int totalOrphans = 0;
        boolean exists = false;
        for (Family family : families) {
            if (family.getFamilyName().equalsIgnoreCase(familyName)) {
                exists = true;
                int bothParents = 0;
                int flag = 0;
                for (Person person : family.getParents()) {
                    flag++;
                    if (person instanceof Martyr) {
                        totalMartyrs++;
                        bothParents++;
                        if (bothParents == 2) {
                            for (Person person1 : family.getMembers()) {
                                if (person1 instanceof LivePerson) {
                                    totalLivePersons++;
                                    totalOrphans++;
                                } else if (person1 instanceof Martyr) {
                                    totalMartyrs++;
                                }
                            }
                        }
                    } else {
                        totalLivePersons++;
                    }

                    if (bothParents != 2 && flag == 2) {
                        for (Person person1 : family.getMembers()) {
                            if (person1 instanceof LivePerson) {
                                totalLivePersons++;
                            } else if (person1 instanceof Martyr) {
                                totalMartyrs++;
                            }
                        }
                    }

                }


            }

        }
        if (!exists) {
            System.out.println("Family doesn't exist");
            return null;
        }
        System.out.println("[Total Martyrs,Total LivePersons,totalorphans]");
        return List.of(totalMartyrs, totalLivePersons, totalOrphans);

    }
//    method to add a parent to the family from the console the user will enter the family name and the parent attributes
    public boolean addParent(String familyName, Person parent) {
        for (Family family : families) {
            if (family.getFamilyName().equalsIgnoreCase(familyName)) {
                family.addParent(parent);
                return true;
            }
        }
        return false;
    }




    // Returns overall statistics for the system. Store the returned values in ArrayList.
    public List<Integer> calculateGlobalStatistics() {
        int totalMartyrs = 0;
        int totalLivePersons = 0;
        int totalOrphans = 0;
        totalMartyrs = this.calculateTotalMartyrs();
        totalLivePersons = this.calculateTotalLivePersons();
        totalOrphans = this.calculateTotalOrphans();
        return List.of(totalMartyrs, totalLivePersons, totalOrphans);
    }

    //    method to print all the families in the system
    public void printAllFamilies() {
        for (Family family : families) {
            System.out.println(family);
        }
    }


    //    string representation of the object , return families
    @Override
    public String toString() {
        return "Manager{" +
                "families=" + families +
                '}';

    }

    public void copyMartyr(String martyrName) {
        for (Family family : families) {
            for (Person person : family.getMembers()) {
                if (person instanceof Martyr) {
                    if (person.getName().equalsIgnoreCase(martyrName)) {
                        try {
                            System.out.println("Martyr copied successfully");
                            System.out.println(((Martyr) person).clone());
                        } catch (CloneNotSupportedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
