package com.example.tongtong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import static com.example.tongtong.SubActivity2.items;


public class CustomArrayAdapter extends ArrayAdapter<String>{

    int resourceId;

    public CustomArrayAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<String> objects) {
        super(context, resource, textViewResourceId, objects);

        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.resourceId,parent,false);
        }

        Button button9 = (Button)convertView.findViewById(R.id.button9);
        button9.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                items.remove(pos);
                notifyDataSetChanged();
            }
        });

        return super.getView(position, convertView, parent);
    }

}