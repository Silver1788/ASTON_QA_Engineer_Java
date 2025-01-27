public class Animal {
    protected String name;
    protected int runLimit;
    protected int swimLimit;

    protected static int animalCount = 0;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        animalCount++;
    }

    public void  run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробежал " + distance + "м.");
        } else {
            System.out.println(name + " не смог пробежать " + distance + "м.");
        }
    }

    public void swim(int distance) {
        if (distance <= swimLimit) {
            System.out.println(name + " проплыл " + distance + "м.");
        } else if (swimLimit == 0) {
            System.out.println(name + " не умеет плавать.");
        } else {
            System.out.println(name + " не смог проплыть " + distance + "м.");
        }
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}
