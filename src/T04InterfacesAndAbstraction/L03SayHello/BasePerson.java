package T04InterfacesAndAbstraction.L03SayHello;

public abstract class BasePerson implements Person {
String name;

    public BasePerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return null;
    }
}
