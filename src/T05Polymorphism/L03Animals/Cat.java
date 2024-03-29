package T05Polymorphism.L03Animals;

public class Cat extends Animal {

    public Cat(String name, String favFood) {
        super(name, favFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s%n", super.getName(), super.getFavouriteFood());
    }
}
