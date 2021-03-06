package com.example.android.musicscstream;

import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.ListView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

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
    public static ArrayList listSource = new ArrayList();

    /**
     * Creates and populates list of artists
     */
    private static ArrayList<Artist> artists;
    private static ArrayList<Album> albums;
    private static ArrayList<Song> songs;

    /**
     * Returns sample list of objects
     */
    public void generateSampleData() {
        artists = new ArrayList<Artist>();

        Resources res = this.getResources();

        for (int i = 0; i < 10; i++) {
            int j = i + 1;
            String imgName = "artist_" + j + "_thumb";
            int resID = res.getIdentifier(imgName, "drawable", this.getPackageName());
            artists.add(new Artist(this, j, "Artist " + j, resID));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        generateSampleData();
        populateListsOfAlbumsAndSongs();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);

        // Handle search in fragments
        MaterialSearchView searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //TODO: add seach using com.miguelcatalan.materialsearchview
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //TODO: add seach using com.miguelcatalan.materialsearchview
                return true;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //TODO: add seach using com.miguelcatalan.materialsearchview
            }

            @Override
            public void onSearchViewClosed() {
                //TODO: add seach using com.miguelcatalan.materialsearchview
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

        return super.onOptionsItemSelected(item);
    }

    public void populateListsOfAlbumsAndSongs() {

        albums = new ArrayList<Album>();
        songs = new ArrayList<Song>();

        for (Artist artist : artists) {

            for (Album album : artist.getAlbums()) {
                albums.add(album);

                for (Song song : artist.getSongs()) {
                    songs.add(song);
                }
            }
        }
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
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ListView listView = (ListView) rootView.findViewById(R.id.list_view1);

            final int activeFragmentNumber = getArguments().getInt(ARG_SECTION_NUMBER);

            // Choose right adapter for ListView.
            // ListView will display list of artists, albums or songs
            switch (activeFragmentNumber) {
                case 1:
                    listView.setAdapter(new ArtistListAdapter(getActivity(), artists));
                    break;
                case 2:
                    listView.setAdapter(new AlbumListAdapter(getActivity(), albums));
                    break;
                case 3:
                    listView.setAdapter(new SongListAdapter(getActivity(), songs));
                    break;
            }

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent();

                    // Create new intent to open {@link TabbedActivity}
                    switch (activeFragmentNumber) {
                        case 1:
                            intent.setClass(getContext(), ArtistActivity.class);
                            intent.putExtra("artist", artists.get(position));
                            break;
                        case 2:
                            intent.setClass(getContext(), AlbumActivity.class);
                            intent.putExtra("album", albums.get(position));
                            break;
                        case 3:
                            intent.setClass(getContext(), SongActivity.class);
                            intent.putExtra("song", songs.get(position));
                            break;
                    }

                    // Start the new activity
                    startActivity(intent);
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
