package gjw.guojianwei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 皇 上 on 2017/3/9.
 */

public class UserFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view = View.inflate(getActivity(), R.layout.fragment_user, null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
