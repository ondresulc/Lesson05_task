package Plants;

import java.time.LocalDate;

public class Main {
    private static final String INPUT_FILE = "data/kvetiny.txt";
    private static final String OUTPUT_FILE = "data/vystup.txt";

    public static void main(String[] args) {
        ListOfPlants listOfPlants = new ListOfPlants();
        listOfPlants.importFromFile(INPUT_FILE);

        for (int i = 0; i < listOfPlants.size(); i++) {
            Plant plant = listOfPlants.getPlantAtPosition(i);
            System.out.println(plant.getWateringInfo());
        }

        listOfPlants.addNewPlant(new Plant("Amarylis","v obyvaku", 7, LocalDate.of(2021, 5, 13), LocalDate.of(2021,5, 13)) );
        listOfPlants.addNewPlant(new Plant("Bazalka"));
        listOfPlants.removePlant(2);

        listOfPlants.exportToFile(OUTPUT_FILE);

    }
}
