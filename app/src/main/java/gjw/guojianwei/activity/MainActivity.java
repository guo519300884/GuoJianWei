package gjw.guojianwei.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import butterknife.ButterKnife;
import butterknife.InjectView;
import gjw.guojianwei.R;
import gjw.guojianwei.fragment.FunFragment;
import gjw.guojianwei.fragment.HomeFragment;
import gjw.guojianwei.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.fl_main)
    FrameLayout flMain;
    @InjectView(R.id.rg_btn)
    RadioGroup rgBtn;

    private Fragment homeFragment;
    private Fragment userFragment;
    private Fragment funFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initData();
        initListener();
    }

    private void initListener() {
        rgBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                Fragment fragment = null;
                switch (checkedId) {
                    case R.id.rb_home:
                        fragment = homeFragment;
                        break;
                    case R.id.rb_fun:
                        fragment = funFragment;
                        break;
                    case R.id.rb_user:
                        fragment = userFragment;
                        break;
                }
                if (fragment == null) {
                    return;
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_main, fragment).commit();
            }
        });
        rgBtn.check(R.id.rb_home);

    }

    private void initData() {
        homeFragment = new HomeFragment();
        funFragment = new FunFragment();
        userFragment = new UserFragment();
    }
}
