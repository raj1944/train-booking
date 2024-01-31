package models;

import java.util.List;

public class Train {

    private String trainNumber;

    private List<Section> sections;

    public Train(String trainNumber, List<Section> sections) {
        this.trainNumber = trainNumber;
        this.sections = sections;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public Section getSectionByNUmber(int number) {
        return this.sections.get(number);
    }
}
