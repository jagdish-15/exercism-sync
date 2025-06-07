import java.util.List;
import java.util.ArrayList;

class KindergartenGarden {

    public static final List<String> students = new ArrayList<>(List.of(
        "Alice", "Bob", "Charlie", "David",
        "Eve", "Fred", "Ginny", "Harriet", 
        "Ileana", "Joseph", "Kincaid", "Larry"));
    public String[] garden;

    KindergartenGarden(String garden) {
        this.garden = garden.split("\\n");
    }

    List<Plant> getPlantsOfStudent(String student) {
        int studentIndex = students.indexOf(student);

        List<Plant> studentPlants = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            studentPlants.add(Plant.getPlant(garden[i].charAt(studentIndex * 2)));
            studentPlants.add(Plant.getPlant(garden[i].charAt(studentIndex * 2 + 1)));
        }

        return studentPlants;
    }
}