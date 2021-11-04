package random;

class equalChecking {
    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = new String("Hello");
        String s3 = new String("hello");
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s1 == s2);
        System.out.println("----------");
        Therap t1 = new Therap();
        Therap t2 = new Therap();
        Therap t3 = new Therap();
        t3.message();
        System.out.println(t1.equals(t3));
        System.out.println(t1 == t3);
    }
}
class Therap{
    public Therap(){
        System.out.println("It is a constructor until their is a return type provided. " +
                "Then it becomes a method");
    }
    static {
        System.out.println("Only for the first object");
    }
    public void message(){
        System.out.println("This is a message");
    }
}
