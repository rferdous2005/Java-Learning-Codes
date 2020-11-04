public class Car extends Vehicle {
    String type;
    String model;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setName(String name) {
        super.name = name +"-"+ this.model;
    }

    public String getName() {
        return super.name;
    }
    public String toString() {
        String description = super.toString()+"Name: "+ this.getName()+
                "\nModel: "+this.model+"\nType: "+this.type+"\n";
        return description;
    }
}
