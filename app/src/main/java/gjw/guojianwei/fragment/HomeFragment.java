package gjw.guojianwei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import gjw.guojianwei.R;
import gjw.guojianwei.utils.CacheUtils;
import gjw.guojianwei.utils.Constants;
import okhttp3.Call;

/**
 * Created by 皇 上 on 2017/3/9.
 */

public class HomeFragment extends Fragment {

    @InjectView(R.id.tv_scan)
    TextView tvScan;
    @InjectView(R.id.tv_search)
    TextView tvSearch;
    @InjectView(R.id.tv_news)
    TextView tvNews;
    @InjectView(R.id.rv_home)
    RecyclerView rvHome;
    @InjectView(R.id.ib_top)
    ImageButton ibTop;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_home, null);
        ButterKnife.inject(this, view);

        initData();

        return view;
    }

    private void initData() {
        String str = CacheUtils.getString(getActivity(), Constants.NET_URL);
        if (TextUtils.isEmpty(str)) {

        }
        getDataFromNet();
    }

    private void getDataFromNet() {
        OkHttpUtils.get()
                .url(Constants.NET_URL)
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(getActivity(), "联网失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Toast.makeText(getActivity(), "联网成功", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    @OnClick({R.id.tv_scan, R.id.tv_search, R.id.tv_news, R.id.ib_top})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_scan:
                Toast.makeText(getActivity(), "扫", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_search:
                Toast.makeText(getActivity(), "搜", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_news:
                Toast.makeText(getActivity(), "消息", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_top:
                Toast.makeText(getActivity(), "回去", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
