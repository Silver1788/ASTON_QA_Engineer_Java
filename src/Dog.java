class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name, 500, 10); // У собаки ограничение: бег 500 м., плавание 10 м.
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}
