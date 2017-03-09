package gjw.guojianwei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import butterknife.ButterKnife;
import butterknife.InjectView;
import gjw.guojianwei.R;

/**
 * Created by 皇 上 on 2017/3/9.
 */

public class FunFragment extends Fragment {

    @InjectView(R.id.tl_1)
    SegmentTabLayout tl1;
    @InjectView(R.id.iv_type_search)
    ImageView ivTypeSearch;
    @InjectView(R.id.fl_type)
    FrameLayout flType;
    private View view;
    private String[] titles = new String[]{"分类", "标签"};
    private Fragment jokeFragment;
    private Fragment newsFragment;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_fun, null);
        ButterKnife.inject(this, view);

        initFragment();
        iniData();
        initListener();
        return view;
    }

    private void initFragment() {
        jokeFragment = new JokeFragment();
        newsFragment = new NewsFragment();
    }

    private void initListener() {

        tl1.setTabData(titles);

        tl1.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }
        });

    }

    private void iniData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
