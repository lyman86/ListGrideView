package com.example.listgridview.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.listgridview.R;
import com.example.listgridview.bean.Mybean;
import com.example.listgridview.utils.ViewHolder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


public class MyAdapter extends CommonAdapter<Mybean> {
	private List<Mybean> list;
	private Context context;
	public MyAdapter(Context context, List<Mybean> list, int layoutId) {
		super(context, list, layoutId);
		this.context = context;
		this.list = list;
		ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
		
	}
int pos;
	@Override
	public void convert(final ViewHolder viewHolder, Mybean t) {
		
		ImageView imageView = viewHolder.getImageView(R.id.image01);
		ImageLoader.getInstance().displayImage(t.imagePath, imageView,baseOptions);
		
		imageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				pos = viewHolder.position*4;
				Toast.makeText(context, pos+"", Toast.LENGTH_SHORT).show();
			}
		});
		
		ImageView imageView2 = viewHolder.getImageView(R.id.image02);
		ImageLoader.getInstance().displayImage(t.imagePath2, imageView2,baseOptions);
		imageView2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println(pos+">>>>");
				System.out.println(pos+1+"imageView2");
				pos = viewHolder.position*4+1;
				Toast.makeText(context, (pos)+"", Toast.LENGTH_SHORT).show();
			}
		});
		ImageView imageView3 = viewHolder.getImageView(R.id.image03);
		ImageLoader.getInstance().displayImage(t.imagePath3, imageView3,baseOptions);
		imageView3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println(pos+2+"imageView3");
				pos = viewHolder.position*4+2;
				Toast.makeText(context, (pos)+"", Toast.LENGTH_SHORT).show();
			}
		});
		ImageView imageView4 = viewHolder.getImageView(R.id.image04);
		ImageLoader.getInstance().displayImage(t.imagePath4, imageView4,baseOptions);
		imageView4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println(pos+3+"imageView4");
				pos = viewHolder.position*4+3;
				Toast.makeText(context, (pos)+"", Toast.LENGTH_SHORT).show();
			}
		});
		
	}

}
