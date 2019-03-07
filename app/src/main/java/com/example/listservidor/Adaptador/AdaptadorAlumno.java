package com.example.listservidor.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listservidor.Modelo.Alumno;
import com.example.listservidor.R;

import java.util.List;

public class AdaptadorAlumno extends BaseAdapter {

    private List<Alumno> list;
    private Context context;

    public AdaptadorAlumno(List<Alumno> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.row,null);

        Alumno a= list.get(position);

        TextView id = convertView.findViewById(R.id.id);
        id.setText(a.getId().toString());

        TextView nom = convertView.findViewById(R.id.nombre);
        nom.setText(a.getNombre());

        return convertView;
    }
}
