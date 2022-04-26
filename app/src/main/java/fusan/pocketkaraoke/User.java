package fusan.pocketkaraoke;

/**
 * Created by Fusan on 26-Mar-22.
 */

public class User {
    public String Name;
    public int Challenge_Count;
    public String Email;

    public User()
    {

    }
    public User(String n,String e)
    {
        Name = n;
        Challenge_Count=0;
        Email = e;

    }
    public User(User u)
    {
        Name = u.Name;
        Challenge_Count = u.Challenge_Count;
        Email = u.Email;
    }

}
