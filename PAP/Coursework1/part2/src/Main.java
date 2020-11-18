public class Main
{
    public static void main(String args[])
    {
        String password = new Password().NewPassword(20,5,5);
        System.out.println(password);
        System.out.println(new Password().ValidatePassword(password));
//        System.out.println(new Password().ValidatePassword("arrison"));

    }
}
