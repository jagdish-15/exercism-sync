public class Lasagna {
    // Method that returns expected time for Lasagna in oven
    public int expectedMinutesInOven() {
        return 40;
    }

    // Method that returns remaining time in oven for Lasagna to cook
    public int remainingMinutesInOven(int timePassed) {
        return expectedMinutesInOven() - timePassed;
    }

    // Method that returns preparation time based on no. of layes of Lasagna
    public int preparationTimeInMinutes(int layers) {
        return layers * 2;
    }

    // Method that returns the total time of preparation of Lasagna
    public int totalTimeInMinutes(int layers, int timeInOven) {
        return timeInOven + preparationTimeInMinutes(layers);
    }
}
