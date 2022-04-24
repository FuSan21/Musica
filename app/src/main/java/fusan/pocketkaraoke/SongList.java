package fusan.pocketkaraoke;

/**
 * Created by Fusan on 27-Nov-16.
 */

public class SongList {

    String[] list;

    public SongList()
    {
        list = new String[2];
        list[0]="Hai Junoon";
        list[1]="Wonderwall";
    }

    public String[] getArr()
    {
        return list;
    }
}
