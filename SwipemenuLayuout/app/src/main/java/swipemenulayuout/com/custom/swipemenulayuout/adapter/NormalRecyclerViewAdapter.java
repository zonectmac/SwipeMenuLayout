package swipemenulayuout.com.custom.swipemenulayuout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import swipemenulayuout.com.custom.swipemenulayoutlibrary.SwipeMenuLayout;
import swipemenulayuout.com.custom.swipemenulayuout.R;

/**
 * Created by Administrator on 2017/6/14.
 */
public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private String[] mTitles;

    public NormalRecyclerViewAdapter(Context context) {
        mTitles = context.getResources().getStringArray(R.array.titles);
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_swipemenu, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        holder.contentText.setText(mTitles[position]);
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView, contentText;
        LinearLayout llRight;

        public NormalTextViewHolder(final View itemView) {
            super(itemView);
            llRight = (LinearLayout) itemView.findViewById(R.id.right);
            contentText = (TextView) itemView.findViewById(R.id.contentText);
            llRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "收藏", Toast.LENGTH_SHORT).show();
                    SwipeMenuLayout easySwipeMenuLayout = (SwipeMenuLayout) itemView.findViewById(R.id.swipemen);
                    easySwipeMenuLayout.resetStatus();
                }
            });

        }
    }
}
