package four_reflect.three_method;

public class Student extends Person implements Hello {

    public static int number = 0;

    public String name;
    private String address = "beijing";

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student() {
        this("unnamed");
    }

    public Student(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("Hello, " + name + " from " + address + "!");
    }
}
