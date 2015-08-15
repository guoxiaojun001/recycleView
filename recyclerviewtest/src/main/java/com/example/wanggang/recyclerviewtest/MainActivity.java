package com.example.wanggang.recyclerviewtest;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    String[] data = {"AAA", "BBB", "CCC", "DDDD", "EEEE", "FFFFF", "GGGG", "HHHH", "III", "JJJJ", "KKKK"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到 RecyclerView
        RecyclerView recylcer = (RecyclerView) findViewById(R.id.recyclerView);
        //ListView效果的 LinearLayoutManager
        //LinearLayoutManager mgr = new LinearLayoutManager(this);
        //VERTICAL纵向，类似ListView，HORIZONTAL横向，类似Gallery
        //mgr.setOrientation(LinearLayoutManager.HORIZONTAL);

        //GridLayout 3列
        //GridLayoutManager mgr=new GridLayoutManager(this,3);

        //3列   方向垂直
        StaggeredGridLayoutManager mgr = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recylcer.setLayoutManager(mgr);
        //设置适配器
        recylcer.setAdapter(new MyAdapter());
    }

    //继承自 RecyclerView.Adapter
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        //RecyclerView显示的子View
        //该方法返回是ViewHolder，当有可复用View时，就不再调用
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = getLayoutInflater().inflate(R.layout.recycler_item, null);
            return new ViewHolder(v);
        }

        //将数据绑定到子View
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.textView.setText(data[i]);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    100+(int) (Math.random() * 50));
            viewHolder.imageView.setLayoutParams(lp);

        }

        //RecyclerView显示数据条数
        @Override
        public int getItemCount() {
            return data.length;
        }

        //自定义的ViewHolder,减少findViewById调用次数
        class ViewHolder extends RecyclerView.ViewHolder {

            TextView textView;
            ImageView imageView;

            public ViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.textView);
                imageView = (ImageView) itemView.findViewById(R.id.imageView);
            }
        }
    }


}
