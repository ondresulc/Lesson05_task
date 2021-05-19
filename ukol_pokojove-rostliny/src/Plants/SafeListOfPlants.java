package Plants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SafeListOfPlants {
    ArrayList<Plant> list = new ArrayList<>();

    public void addNewPlant(String name) {

        list.add(new Plant(name));
    }

    public Plant getPlantAtPosition(int position) throws IOException {
//        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
//        position = Integer.parseInt(bis.readLine());
        return list.get(position);
    }

    public void removePlant(int index) {
        list.remove(index);
    }
}
