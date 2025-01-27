public class LectureSix {

    /**
     * Задание 1:
     * Создать классы Собака и Кот с наследованием от класса Животное.
     * Добавить подсчет созданных котов, собак и животных.
     * Расширить задачу, добавив для котов возможность кушать из миски.
     *
     * Задание 2:
     * Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур: круг, прямоугольник, треугольник.
     */
    public static void main(String[] args) {
        // Создание котов и собак
        Dog dogBobik = new Dog("Бобик");
        Cat catBarsik = new Cat("Барсик");
        Cat catMurzik = new Cat("Мурзик");
        Cat catPushok = new Cat("Пушок");
        Cat catVasya = new Cat("Вася");

        // Тестирование бега и плавания
        dogBobik.run(550);
        dogBobik.swim(5);
        catBarsik.run(150);
        catBarsik.swim(1);

        // Создание миски с едой
        Bowl bowl = new Bowl(30);

        // Массив котов
        Cat[] cats = {catBarsik, catMurzik, catPushok, catVasya};

        // Коты пытаются покушать
        for (Cat cat : cats) {
            cat.eatFromBowl(bowl, 10); // Каждый кот хочет съесть 10 единиц еды
        }

        // Информация о сытости котов
        System.out.println("\nИнформация о сытости котов:");
        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isSatiety());
        }

        // Добавление еды в миску
        bowl.addFood(20);

        // Статистика животных
        System.out.println("\nВсего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());

        // Создание фигур
        GeometricShapes circle = new Circle(5, "Красный", "Желтый");
        GeometricShapes rectangle = new Rectangle(4, 7, "Синий", "Черный");
        GeometricShapes triangle = new Triangle(3, 4, 5, "Белый", "Красный");

        // Вывод характеристик фигур
        System.out.println("\nПараметры круга: "
                + "\nПериметр: " + String.format("%.2f", circle.perimeter())
                + "\nПлощадь: " + String.format("%.2f", circle.area())
                + "\nЦвет фона: " + circle.getFillColor()
                + "\nЦвет границ: " + circle.getBorderColor());
        System.out.println("\nПараметры прямоугольника: "
                + "\nПериметр: " + String.format("%.2f", rectangle.perimeter())
                + "\nПлощадь: " + String.format("%.2f", rectangle.area())
                + "\nЦвет фона: " + rectangle.getFillColor()
                + "\nЦвет границ: " + rectangle.getBorderColor());
        System.out.println("\nПараметры треугольника: "
                + "\nПериметр: " + String.format("%.2f", triangle.perimeter())
                + "\nПлощадь: " + String.format("%.2f", triangle.area())
                + "\nЦвет фона: " + triangle.getFillColor()
                + "\nЦвет границ: " + triangle.getBorderColor());
    }
}
