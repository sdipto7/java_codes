package random;

public enum Action {
    ADD("add"), UPDATE("update"), DELETE("delete");

    private String action;

    Action(String text){
        this.action = text;
    }

    public String getAction(){
        return this.action;
    }

    public static Action fromString(String str){
        for (Action action : Action.values()) {
            if (action.getAction().equalsIgnoreCase(str)){
                return action;
            }
        }
        return null;
    }
}

class A{
    public static void main(String[] args) {
        System.out.println(Action.fromString("aDd"));
    }
}
