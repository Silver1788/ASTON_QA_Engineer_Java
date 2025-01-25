public class Employee {
    private String fullName;   // ФИО
    private String position;   // Должность
    private String email;      // Email
    private String phone;      // Телефон
    private double salary;     // Зарплата
    private int age;           // Возраст

    /**
     * Конструктор для создания объекта сотрудника.
     *
     * @param fullName  ФИО сотрудника
     * @param position  Должность сотрудника
     * @param email     Электронная почта сотрудника
     * @param phone     Телефон сотрудника
     * @param salary    Зарплата сотрудника
     * @param age       Возраст сотрудника
     */
    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    /**
     * Метод для вывода информации о сотруднике в консоль.
     */
    public void printInfo() {
        System.out.println("ФИО: " + this.fullName + "\nДолжность: " + this.position + "\nEmail: " + this.email + "\nТелефон: " + this.phone + "\nЗарплата: " + this.salary + "\nВозраст: " + this.age + "\n_______________________________");
    }
}
