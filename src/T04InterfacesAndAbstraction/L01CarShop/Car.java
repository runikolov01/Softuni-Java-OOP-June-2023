package T04InterfacesAndAbstraction.L01CarShop;

public interface Car {
    public static final int TIRES = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();


}
