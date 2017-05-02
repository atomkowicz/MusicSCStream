package com.example.android.musicscstream;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    /**
     * Holds list of artists, albums or songs
     */
    public static String[] listSource = new String[]{};

    /**
     * Creates and populates list of artists
     */
    static String[] artists = generateList("Artist");
    /**
     * Creates and populates list of albums
     */
    static String[] albums = generateList("Album");
    /**
     * Creates and populates list of songs
     */
    static String[] songs = generateList("Song");

    /**
     * Returns sample list of 20 string elements
     */
    static String[] generateList(String listType) {
        String[] list = new String[20];

        for (int i = 0; i < 20; i++) {
            list[i] = listType + " " + (i + 1);
        }

        return list;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);

        MaterialSearchView searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText != null && !newText.isEmpty()) {
                    List<String> lstFound = new ArrayList<String>();

                    for (String item : listSource) {
                        if (item.toLowerCase().contains(newText.toLowerCase()))
                            lstFound.add(item);
                    }

                    ListView lstView = (ListView) findViewById(R.id.list_view1);

                    ArrayAdapter<String> adapter =
                            new ArrayAdapter<String>(MainActivity.this, R.layout.artist_list_item, lstFound);
                    lstView.setAdapter(adapter);

                } else {
                    // serarch is null default
                }
                return true;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {

                ListView lstView = (ListView) findViewById(R.id.list_view1);
                ArrayAdapter<String> adapter =
                        new ArrayAdapter<String>(MainActivity.this, R.layout.artist_list_item, listSource);

                lstView.setAdapter(adapter);
            }
        });


        searchView.setMenuItem(item);


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setTextColor(getResources().getColor(R.color.colorTextPrimary));

            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    listSource = artists;
                    break;
                case 2:
                    listSource = albums;
                    break;
                case 3:
                    listSource = songs;
                    break;
            }

            ListView lstView = (ListView) rootView.findViewById(R.id.list_view1);
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(rootView.getContext(), R.layout.artist_list_item, listSource);
            lstView.setAdapter(adapter);


            lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent formIntend = new Intent();

                    // Create new intent to open {@link TabbedActivity}
                    switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                        case 1:
                            formIntend = new Intent(getContext(), ArtistAcitvity.class);
                            break;
                        case 2:
                            formIntend = new Intent(getContext(), AlbumActivity.class);
                            break;
                        case 3:
                            formIntend = new Intent(getContext(), SongActivity.class);
                            break;
                    }

                    // Start the new activity
                    startActivity(formIntend);
                }
            });

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Artist";
                case 1:
                    return "Albums";
                case 2:
                    return "Songs";
            }
            return null;
        }
    }


}
