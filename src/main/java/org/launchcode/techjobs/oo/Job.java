package org.launchcode.techjobs.oo;

import java.util.Objects;

import static java.util.Objects.isNull;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job () {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }


    public String toString(){
        String jobDescription = "\n";
        jobDescription += "ID: ";
        if (isNull(id)) {
            jobDescription += "Data not available";
        } else {
            jobDescription += id;
        }

        jobDescription += "\nName: ";
        if (isNull(name) || name.equals("")) {
            jobDescription += "Data not available";
        } else {
            jobDescription += name;
        }

        jobDescription += "\nEmployer: ";
        if (isNull(employer) || employer.getValue().equals("")) {
            jobDescription += "Data not available";
        } else {
            jobDescription += employer;
        }

        jobDescription += "\nLocation: ";
        if (isNull(location) || location.getValue().equals("")) {
            jobDescription += "Data not available";
        } else {
            jobDescription += location;
        }

        jobDescription += "\nPosition Type: ";
        if (isNull(positionType) || positionType.getValue().equals("")) {
            jobDescription += "Data not available";
        } else {
            jobDescription += positionType;
        }

        jobDescription += "\nCore Competency: ";
        if (isNull(coreCompetency) || coreCompetency.getValue().equals("")) {
            jobDescription += "Data not available";
        } else {
            jobDescription += coreCompetency;
        }

        jobDescription += ("\n");

        return jobDescription;
    }

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
}
