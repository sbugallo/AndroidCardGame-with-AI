package es.uvigo.teleco.prohis;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AboutAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabTitles[] =
            new String[] { "Rules", "About"};

    public AboutAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment f = null;

        switch(position) {
            case 0: f = RulesFragment.newInstance();
                        break;
            case 1: f = AboutFragment.newInstance();
                    break;
        }

        return f;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitles[position];
    }
}