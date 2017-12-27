package qingguoguo.com.followqqrecord;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager mViewPager;
    private List<PageModel> pageModels = new ArrayList<>();
    {
        pageModels.add(new PageModel(R.string.title_whine, R.layout.page_record));
        pageModels.add(new PageModel(R.string.title_talk_back, R.layout.page_talking));
        pageModels.add(new PageModel(R.string.title_record, R.layout.page_record));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(pageModel.pageLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private class PageModel {
        @StringRes
        int titleRes;
        @LayoutRes int pageLayoutRes;

        PageModel( @StringRes int titleRes, @LayoutRes int pageLayoutRes) {
            this.titleRes = titleRes;
            this.pageLayoutRes = pageLayoutRes;
        }
    }
}
