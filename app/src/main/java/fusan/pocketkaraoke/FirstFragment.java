package fusan.pocketkaraoke;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Fusan on 26-Mar-22.
 */

public class FirstFragment extends Fragment {
    ListView list;
    String[] song;
    String[] artist;
    Integer[] img;
    String[] karaokeType = {"Solo Karaoke", "Duo Karaoke", "Karaoke Tournament"};
    int karaokeTypeSelected;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        setHasOptionsMenu(true);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle("PocketKaraoke 2.0");
        //activity.getSupportActionBar().hide();

        list=(ListView)v.findViewById(R.id.listView);
        song=new String[]{"Aj Raate Kono Rupkotha Nei","Numb"};
        artist=new String[]{"Old School","Linking Park"};
        img=new Integer[]{R.raw.song1,R.raw.song2};

        CustomList adapter = new CustomList(v.getContext(),song,artist,img);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new itemClicked());

        return v;
    }

    public static FirstFragment newInstance() {

        FirstFragment f = new FirstFragment();
        return f;
    }

    public class itemClicked implements AdapterView.OnItemClickListener
    {


        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            karaokeTypeSelected = 0;
            // MainActivity.changeFrag();
            AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
            build.setTitle(song[i]+"\nChoose karaoke Type:");
            final int x11=i;
            build.setSingleChoiceItems(karaokeType, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    karaokeTypeSelected = i;
                }
            });
            build.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    switch(karaokeTypeSelected) {
                        case 0:
                            Intent intent = new Intent(getActivity(),KaraokeActivity.class);
                            Bundle b = new Bundle();
                            b.putInt("choice",0);
                            b.putInt("pos",x11);
                            intent.putExtras(b);
                            startActivity(intent);
                            break;
                        case 1:
                            Toast.makeText(getActivity(), "Duo Karaoke is not yet implemented", Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            Toast.makeText(getActivity(), "Karaoke Tournament is not yet implemented", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

            build.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //tv.setText("No Clicked");
                }
            });
            build.show();
        }
    }

    /*
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getMenuInflater().inflate(R.menu.options,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    */
}

