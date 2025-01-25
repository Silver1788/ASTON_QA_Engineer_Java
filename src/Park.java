public class Park {
    private String name;                // Название парка
    private String location;            // Местоположение парка
    public Attraction[] attractions;    // Аттракционы

    public Park(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Внутренний класс Attraction
    public static class Attraction {
        private String attractionName;  // Название аттракциона
        private String workingHours;    // Часы работы
        private double price;           // Стоимость посещения

        /**
         *
         * @param attractionName    Название аттракциона
         * @param workingHours      Время работы
         * @param price             Стоимость
         */
        public Attraction(String attractionName, String workingHours, double price) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.price = price;
        }

        /**
         * Метод для вывода информации об аттракционе
         */
        public void printInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Часы работы: " + workingHours);
            System.out.println("Стоимость: " + price + " рублей");
        }
    }

    /**
     * Метод для вывода информации о парке
     */
    public void printParkInfo() {
        System.out.println("Парк: " + name);
        System.out.println("Местоположение: " + location);
    }
}
