package com.reflection;

public abstract class Department {

    private String name;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
/*AN Abstract class is a class where atleast one method is not implemented in the class but must
implemented in Devrived class
 */


