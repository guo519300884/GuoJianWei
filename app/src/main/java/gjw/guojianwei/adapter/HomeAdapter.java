package gjw.guojianwei.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import gjw.guojianwei.R;
import gjw.guojianwei.bean.HomeBean;

/**
 * Created by 皇 上 on 2017/3/9.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private final Context context;
    private final List<HomeBean.TrailersBean> trailers;

    public HomeAdapter(Context context, List<HomeBean.TrailersBean> trailers) {
        this.context = context;
        this.trailers = trailers;
    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(context, R.layout.item_net_video, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HomeBean.TrailersBean trailersBean = trailers.get(position);

        Glide.with(context)
                .load(trailersBean.getCoverImg())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.gg)
                .error(R.drawable.gg)
                .into(holder.ivIcon);

        holder.tvName.setText(trailersBean.getMovieName());
        holder.tvDuration.setText(trailersBean.getType() + "\n" + trailersBean.getVideoTitle());
        holder.tvSize.setText(trailersBean.getVideoLength() + "秒");

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.iv_icon)
        ImageView ivIcon;
        @InjectView(R.id.tv_name)
        TextView tvName;
        @InjectView(R.id.tv_duration)
        TextView tvDuration;
        @InjectView(R.id.tv_size)
        TextView tvSize;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener == null) {
                        listener.OnItemClick(getLayoutPosition());
                    }
                }
            });
        }
    }


    public interface OnItemClickListener {
        void OnItemClick(int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
