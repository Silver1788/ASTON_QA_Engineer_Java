class Cat extends Animal {
    private boolean satiety; // Поле для определения сытости кота
    private static int catCount = 0;

    public Cat(String name) {
        super(name, 200, 0); // У кота ограничение: бег 200 м., плавание 0 м.
        this.satiety = false; // Изначально все голодные
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eatFromBowl(Bowl bowl, int foodAmount) {
        if (bowl.decreaseFood(foodAmount)) {
            this.satiety = true;
            System.out.println(name + " покушал и стал сытым.");
        } else {
            System.out.println(name + " не смог покушать, еды в миске недостаточно.");
        }
    }
}
