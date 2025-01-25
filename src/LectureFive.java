public class LectureFive {
    /**
     * 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
     * Конструктор класса должен заполнять эти поля при создании объекта.
     * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
     *
     * 2. Создать массив из 5 сотрудников.
     *
     * 3. Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах, времени их работы и стоимости.
     */
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee(
                "Иванов Иван Иванович",
                "Инженер",
                "ivan@example.com",
                "+7-999-123-4567",
                75000,
                35
        );
        employees[1] = new Employee(
                "Дубровина Амина Антоновна",
                "Инженер",
                "amina@example.com",
                "+7-999-123-4567",
                75000,
                35
        );
        employees[2] = new Employee(
                "Карасев Михаил Даниилович",
                "Инженер",
                "mihail@example.com",
                "+7-999-123-4567",
                75000,
                35
        );
        employees[3] = new Employee(
                "Рыбаков Всеволод Степанович",
                "Инженер",
                "vsevolod@example.com",
                "+7-999-123-4567",
                75000,
                35
        );
        employees[4] = new Employee(
                "Завьялов Владимир Давидович",
                "Инженер",
                "vladimir@example.com",
                "+7-999-123-4567",
                75000,
                35
        );
        employees[0].printInfo();

        Park park = new Park("Городской парк", "Центр города");
        park.attractions = new Park.Attraction[3];
        park.attractions[0] = new Park.Attraction("Колесо обозрения", "10:00 - 20:00", 300);
        park.attractions[1] = new Park.Attraction("Американские горки", "12:00 - 22:00", 500);
        park.attractions[2] = new Park.Attraction("Качели", "14:00 - 19:00", 200);
        park.attractions[0].printInfo();
        park.printParkInfo();
    }
}
