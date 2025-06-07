import java.util.List;
import java.util.ArrayList;

class KindergartenGarden {

    public static final List<String> students = new ArrayList<>(List.of(
        "Alice", "Bob", "Charlie", "David",
        "Eve", "Fred", "Ginny", "Harriet", 
        "Ileana", "Joseph", "Kincaid", "Larry"));
    public String gardenFirstHalf;
    public String gardenSecondHalf;

    KindergartenGarden(String garden) {
        garden = garden.replace("\n", "");
        int halfLength = garden.length() / 2;
        gardenFirstHalf = garden.substring(0, halfLength);
        gardenSecondHalf = garden.substring(halfLength);
    }

    List<Plant> getPlantsOfStudent(String student) {
        int studentIndex = students.indexOf(student);
        int[] indexForPlants = {studentIndex * 2, studentIndex * 2 + 1, studentIndex * 2, studentIndex * 2 + 1};

        List<Plant> studentPlants = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (i == 0 || i == 1) {
                studentPlants.add(Plant.getPlant(gardenFirstHalf.charAt(indexForPlants[i])));
            } else {
                studentPlants.add(Plant.getPlant(gardenSecondHalf.charAt(indexForPlants[i])));
            }
        }

        return studentPlants;
    }
}