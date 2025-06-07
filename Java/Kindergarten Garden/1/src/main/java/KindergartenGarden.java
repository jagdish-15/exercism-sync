import java.util.*;

class KindergartenGarden {

    public static final ArrayList<String> students = new ArrayList<>(List.of("Alice", "Bob", "Charlie", "David",
                                                                             "Eve", "Fred", "Ginny", "Harriet", 
                                                                             "Ileana", "Joseph", "Kincaid", "Larry"));
    public String garden1;
    public String garden2;
    
    KindergartenGarden(String garden) {
        garden = garden.replace("\n", "");
        int halfLength = garden.length() / 2;
        garden1 = garden.substring(0, halfLength);
        garden2 = garden.substring(halfLength);
    }

    List<Plant> getPlantsOfStudent(String student) {
        int studentIndex = students.indexOf(student);
        int indexOfPlant1And3 = studentIndex * 2;
        int indexOfPlant2And4 = studentIndex * 2 + 1;

        List<Plant> studentPlants = new ArrayList<>();
        studentPlants.add(Plant.getPlant(garden1.charAt(indexOfPlant1And3)));
        studentPlants.add(Plant.getPlant(garden1.charAt(indexOfPlant2And4)));
        studentPlants.add(Plant.getPlant(garden2.charAt(indexOfPlant1And3)));
        studentPlants.add(Plant.getPlant(garden2.charAt(indexOfPlant2And4)));

        return studentPlants;
    }
}