package WarOnGaza;

import java.util.ArrayList;
import java.util.List;

public class Family implements Sortable {

    private String familyName;
    private List<Person> members = new ArrayList<>();
    private List<Person> parents = new ArrayList<>();

    public Family(String familyName) {
        this.familyName = familyName;
    }

    public Family() {

    }

    // method to Adds a person to the family with a specified role, return true if
    // added successfully
    public boolean addMember(Person member, String roleInFamily) {
        // if there is no two parents throw exception

        try {
            if (parents.size() != 2) {
                throw new AddMemberException("You can't add a member without two parents");
            }
            if (roleInFamily.equalsIgnoreCase("son") || roleInFamily.equalsIgnoreCase("daughter")) {
                members.add(member);
                System.out.println(roleInFamily + " added successfully");
                return true;
            } else {
                return false;
            }
        } catch (AddMemberException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // method to remove person from the family , return true if removed successfully
    public boolean removeMember(Person member) {
        if (members.contains(member)) {
            members.remove(member);
            System.out.println("Member removed successfully");
            return true;
        } else {
            return false;
        }
    }

    // method to deep copy the object using clone method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Family family = (Family) super.clone();
        family.members = (List<Person>) ((ArrayList<Person>) this.members).clone();
        family.parents = (List<Person>) ((ArrayList<Person>) this.parents).clone();

        return family;
    }

    // method Retrieves the list of family members.
    public List<Person> getMembers() {
        return members;
    }

    // Retrieves the Family Name.
    public String getFamilyName() {
        return familyName;
    }

    // method to set a name for family.
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    // method to add a parent to the family
    public void addParent(Person parent) throws AddParentException {
        try {
            if (parents.size() == 2) {
                throw new AddParentException("You can't add more than two parents");
            }
            System.out.println("Parent added successfully");
            parents.add(parent);
        } catch (AddParentException e) {
            System.out.println(e.getMessage());
        }
    }

    // method to remove a parent from the family
    public void removeParent(Person parent) {
        System.out.println("Parent removed successfully");
        parents.remove(parent);
    }

    // Retrieves the list of family parents.
    public List<Person> getParents() {
        return parents;
    }

    // string representation of the object, return family name , members and parents
    @Override
    public String toString() {
        return "Family{" +
                "familyName='" + familyName + '\'' +
                ", members=" + members +
                ", parents=" + parents +
                '}';
    }

    // method to calculate number of orphans in a single family, i added it to help
    // me in the equals method
    public int numberOfOrphans() {

        int totalOrphans = 0;
        int bothParents = 0;
        for (Person person : parents) {
            if (person instanceof Martyr) {
                bothParents++;
                if (bothParents == 2) {
                    for (Person person1 : members) {
                        if (person1 instanceof LivePerson) {
                            totalOrphans++;
                        }
                    }
                }
            }
        }

        return totalOrphans;
    }

    // method to calculate number of martyrs in a single family, i added it to help
    // me in the equals method
    public int numberOfMartyrs() {
        int totalMartyrs = 0;
        for (Person person : members) {
            if (person instanceof Martyr) {
                totalMartyrs++;
            }
        }
        for (Person person : parents) {
            if (person instanceof Martyr) {
                totalMartyrs++;
            }
        }
        return totalMartyrs;
    }

    @Override
    public ArrayList<Family> sortByMartyrs(ArrayList<Family> families) {
        // /* The sorting should be based on the number of Martyrs. Keep the original
        // family list as it is. */
        ArrayList<Family> sortedFamilies = new ArrayList<>();
        sortedFamilies.addAll(families);
        for (int i = 0; i < sortedFamilies.size(); i++) {
            for (int j = 0; j < sortedFamilies.size() - 1; j++) {
                if (sortedFamilies.get(j).numberOfMartyrs() < sortedFamilies.get(j + 1).numberOfMartyrs()) {
                    Family temp = sortedFamilies.get(j);
                    sortedFamilies.set(j, sortedFamilies.get(j + 1));
                    sortedFamilies.set(j + 1, temp);
                }
            }
        }
        return sortedFamilies;
    }

    // method to sort the families based on the number of orphans in each family
    @Override
    public ArrayList<Family> sortByOrphans(ArrayList<Family> families) {
        ArrayList<Family> sortedFamilies = new ArrayList<>();
        sortedFamilies.addAll(families);
        for (int i = 0; i < sortedFamilies.size(); i++) {
            for (int j = 0; j < sortedFamilies.size() - 1; j++) {
                if (sortedFamilies.get(j).numberOfOrphans() > sortedFamilies.get(j + 1).numberOfOrphans()) {
                    Family temp = sortedFamilies.get(j);
                    sortedFamilies.set(j, sortedFamilies.get(j + 1));
                    sortedFamilies.set(j + 1, temp);
                }
            }
        }
        return sortedFamilies;
    }

    // equals method considers two families as equal if they have the same number of
    // martyrs.
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Family) {
            Family family = (Family) obj;
            if (this.numberOfMartyrs() == family.numberOfMartyrs()) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

}
