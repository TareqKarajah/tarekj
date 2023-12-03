package WarOnGaza;

import java.util.ArrayList;
import java.util.List;

public class Family {
    private String familyName;
    private List<Person> members = new ArrayList<>();
    private List<Person> parents = new ArrayList<>();

    public Family(String familyName) {
        this.familyName = familyName;
    }
    public boolean addMember(Person member, String roleInFamily) {
        if (roleInFamily.equalsIgnoreCase("mom") || roleInFamily.equalsIgnoreCase("dad") || roleInFamily.equalsIgnoreCase("son") || roleInFamily.equalsIgnoreCase("daughter")) {
            members.add(member);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeMember(Person member) {
        if (members.contains(member)) {
            members.remove(member);
            return true;
        } else {
            return false;
        }
    }

    public List<Person> getMembers() {
        //return parents and members
        return members;
    }

    public String getFamilyName() {
        return familyName;
    }


    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void addParent(Person parent) {

        parents.add(parent);
    }

    public void removeParent(Person parent) {
        parents.remove(parent);
    }

    public List<Person> getParents() {
        return parents;
    }


    @Override
    public String toString() {
        return "Family{" +
                "familyName='" + familyName + '\'' +
                ", members=" + members +
                ", parents=" + parents +
                '}';
    }

    public int numberOfMartyrs(){
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
    public boolean equals(Object obj) {
        if (obj instanceof Family) {
            Family family = (Family) obj;
            // do it by number of martyrs in parents and members
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


