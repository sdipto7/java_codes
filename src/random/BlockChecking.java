package random;

class Subclass extends Superclass{
    Subclass(){
        System.out.println("Subclass no-arg constructor!");
    }
    Subclass(int x){
        System.out.println("Subclass 1-arg constructor!");
    }

    {
        System.out.println("instance init block-2");
    }

    {
        System.out.println("instance init block-1");
    }

    static {
        System.out.println("static init block-2");
    }

    static {
        System.out.println("static init block-1");
    }
}

class Superclass{
    Superclass(){
        System.out.println("Superclass no-arg constructor");
    }
}

public class BlockChecking{
    public static void main(String[] args) {
        new Subclass();
        System.out.println();
        new Subclass(7);
    }
}