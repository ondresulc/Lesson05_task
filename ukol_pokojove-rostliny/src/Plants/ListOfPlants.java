package Plants;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ListOfPlants {
    private ArrayList<Plant> list = new ArrayList<>();

    public int size()
    {
        return list.size();
    }

    public void addNewPlant(Plant plant) {
        list.add(plant);
    }
//    public void addNewPlant(Plant plant) {
//        list.add(plant);
//    }

    public Plant getPlantAtPosition(int position) {
        return list.get(position);
    }

    public void removePlant(int index) {
        list.remove(index);
    }

    public void importFromFile(String pathToFile) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(pathToFile)))) {
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                list.add(Plant.parsePlant(nextLine));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Soubor " + pathToFile + " nebyl nalezen: " + e.getLocalizedMessage());
        } catch (PlantException e) {
            System.err.println("Chyba v souboru "+pathToFile+": "+e.getLocalizedMessage());
        }
    }

    public void exportToFile(String outputFile) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)))) {
            for (Plant plant : list) {
                writer.println(plant.prepareToWrite());
            }
        } catch (IOException e) {
            System.err.println("Chyba pri zapisu do souboru " + outputFile + ": " + e.getLocalizedMessage());
        }
    }
}


