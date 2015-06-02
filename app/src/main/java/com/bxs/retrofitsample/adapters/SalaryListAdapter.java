package com.bxs.retrofitsample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bxs.retrofitsample.R;
import com.bxs.retrofitsample.models.Salary;

import java.util.ArrayList;

/**
 * Created by bhupinder on 2/6/15.
 */
public class SalaryListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Salary> salaryArrayList;
    public SalaryListAdapter(Context context, ArrayList<Salary> salaryArrayList ) {
        this.mContext = context;
        this.salaryArrayList = salaryArrayList;
    }
    @Override
    public int getCount() {
        return salaryArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return salaryArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if(convertView==null){
            // inflate the layout
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.adapter_salary, parent, false);

            // well set up the ViewHolder
            viewHolder = new ViewHolder();
            viewHolder.tvSalaryAmount = (TextView) convertView.findViewById(R.id.tv_salary);
            viewHolder.tvDate = (TextView) convertView.findViewById(R.id.tv_date);

            // store the holder with the view.
            convertView.setTag(viewHolder);
        }else{
            // we've just avoided calling findViewById() on resource everytime
            // just use the viewHolder
            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.tvSalaryAmount.setText(salaryArrayList.get(position).getSalaryAmount()+"");
        viewHolder.tvDate.setText(salaryArrayList.get(position).getDate()+"");

        return convertView;
    }

    private static class ViewHolder {
        private TextView tvSalaryAmount;
        private TextView tvDate;
    }
}
