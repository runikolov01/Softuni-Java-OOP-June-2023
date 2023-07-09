package T05Polymorphism.L04WildFarm;

public class Felime extends Mammal {
    protected Felime(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }
    @Override
    public void eat (Food food){
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());

    }
}