package Plants;

import java.time.LocalDate;

public class Plant {
    private static final String FILE_ITEM_DELIMITER = "\t";

    String name;
    LocalDate planted;
    LocalDate watering;
    int frequencyOfWatering;
    String note;



    public static Plant parsePlant(String record) throws PlantException {
        String[] items = record.split(FILE_ITEM_DELIMITER);

        String name = items[0];
        String note = items[1];
        int frequencyOfWatering = Integer.parseInt(items[2]);
        LocalDate planted = LocalDate.parse(items[3]);
        LocalDate watering = LocalDate.parse(items[4]);


        return new Plant(name, note, frequencyOfWatering, planted, watering);
    }

public String prepareToWrite() {
    return getName() + FILE_ITEM_DELIMITER
            + getNote() + FILE_ITEM_DELIMITER
            + getFrequencyOfWatering() + FILE_ITEM_DELIMITER
            + getPlanted() + FILE_ITEM_DELIMITER
            + getWatering();
}



    public Plant(String name, String note, int frequencyOfWatering, LocalDate planted, LocalDate watering) {
        this.name = name;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
        this.note = note;
    }

    public Plant(String name, LocalDate planted, int frequencyOfWatering) {
        this.name = name;
        this.planted = planted;
        this.watering = LocalDate.now();
        this.frequencyOfWatering = frequencyOfWatering;
        this.note = "";
    }

    public Plant(String name) {
        this(name, LocalDate.now(), 7);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) throws PlantException {
        if (watering.isBefore(planted)) {
            throw new PlantException("Watering cannot be older than planting!");
        } else this.watering = watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException {
        if (frequencyOfWatering <= 0) {
            throw new PlantException("Frequency of Watering has to be greater than 0!");
        } else this.frequencyOfWatering = frequencyOfWatering;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getWateringInfo() {
        String info = "";
        String nextRecommendedWatering = String.valueOf(getWatering().plusDays(getFrequencyOfWatering()));
        info = getName() + " " + getWatering() + " " + nextRecommendedWatering;
        return info;
    }
}
