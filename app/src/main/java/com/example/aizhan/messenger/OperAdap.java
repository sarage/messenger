package com.example.aizhan.messenger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aizhan on 8/16/17.
 */

public class OperAdap extends BaseAdapter{

    Context contxt;
    LayoutInflater lInflater;
    ArrayList<Oper> operators;

    public OperAdap(Context context, ArrayList<Oper> operator) {
        contxt = context;
        operators = operator;
        lInflater = (LayoutInflater) LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return operators.size();
    }

    @Override
    public Object getItem(int position) {
        return operators.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.oper, parent, false);
        }

        Oper o = getOperator(position);

        ((TextView) view.findViewById(R.id.operName)).setText(o.getOperName());
        ((ImageView) view.findViewById(R.id.operIcon)).setImageResource(o.getOperIcon());

        return view;
    }
    Oper getOperator(int position) {
        return ((Oper) getItem(position));
    }
}
