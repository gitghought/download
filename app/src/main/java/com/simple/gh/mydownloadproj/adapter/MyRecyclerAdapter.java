package com.simple.gh.mydownloadproj.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simple.gh.mydownloadproj.R;
import com.simple.gh.mydownloadproj.object.MyTask;
import com.simple.gh.mydownloadproj.utils.MyLog;

import java.util.ArrayList;

/**
 * Created by gh on 2017-08-11.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private ArrayList<MyTask> tasks = new ArrayList<>();

    public MyRecyclerAdapter(ArrayList<MyTask> tasks) {
        this.tasks = tasks;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_in_recyclerview, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyTask task = this.tasks.get(position);

        MyLog.d(MyLog.TAG, "name = " + task.getmName());
        holder.tvName.setText(task.getmName());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.tvName = (TextView) itemView.findViewById(R.id.tv_name);
            this.tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = MyViewHolder.this.getAdapterPosition();

                    MyTask task = tasks.get(pos);
                    MyLog.d(MyLog.TAG, "name = " + task.getmName());
                }
            });
        }
    }
}
