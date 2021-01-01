class A{
    private void printName(){
        System.out.println("Value-A");
    }
}
class B extends A{
    public void printName(){
        System.out.println("Name-B");
    }
}
 class Test{
    public static void main (String[] args){
        B b = new B();
        b.printName();
    }
}

abstract class abs {
    public int lolNumber;

    public abstract void thisIsCool();

    public void thisIsAMethod() {

    }
}

class C extends abs {

    @Override
    public void thisIsCool()
    {

    }
}