package random;

class Person{
    Person(){
        System.out.println("Inside Person Class");
    }
}

class Graduate extends Person{
    Graduate(){
        System.out.println("Inside Graduate class");
    }
}

class Employer extends Graduate{
    String name;
    Employer(){
        System.out.println("Inside Employer Class default constructor");
    }
    Employer(String name){
        this();
        System.out.println("Inside Employer Class parameter constructor");
    }
}

class Test {
    public static void main(String[] args) {
        Employer p1 = new Employer("Dipto");
    }
}