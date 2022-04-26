package fusan.pocketkaraoke;

/**
 * Created by Fusan on 27-Mar-22.
 */

public class SongList {

    String[] list;

    public SongList()
    {
        list = new String[2];
        list[0]="Aj Raate Kono Rupkotha Nei";
        list[1]="Numb";
    }

    public String[] getArr()
    {
        return list;
    }
}
