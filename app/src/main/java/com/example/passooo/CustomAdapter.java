package com.example.passooo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Objects;

public class CustomAdapter extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> passwordNames;
    private ArrayList<String> passwordIcons; // Resim dosya adlarını içeren liste

    public CustomAdapter(Context context, ArrayList<String> passwordNames, ArrayList<String> passwordIcons) {
        super(context, R.layout.list_item, passwordNames);
        this.context = context;
        this.passwordNames = passwordNames;
        this.passwordIcons = passwordIcons;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, null);
        }

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);

        // Resmi yüklemek için resim dosya adını al
        String iconName = passwordIcons.get(position);
        int resourceId = context.getResources().getIdentifier(iconName, "drawable", context.getPackageName());

        imageView.setImageResource(resourceId); // Resmi ayarla
        textView.setText(passwordNames.get(position)); // Metni ayarla
        if(Objects.equals(iconName, "Adobe"))
        {
            imageView.setImageResource(R.drawable.adobe100x100);
        }
        if(Objects.equals(iconName, "Airbnb"))
        {
            imageView.setImageResource(R.drawable.airbnb100x100);
        }
        if(Objects.equals(iconName, "Amazon"))
        {
            imageView.setImageResource(R.drawable.amazon100x100);
        }
        if(Objects.equals(iconName, "Android"))
        {
            imageView.setImageResource(R.drawable.android100x100);
        }
        if(Objects.equals(iconName, "Apple"))
        {
            imageView.setImageResource(R.drawable.appel100x100);
        }
        if(Objects.equals(iconName, "Atlassian"))
        {
            imageView.setImageResource(R.drawable.atlassian100x100);
        }
        if(Objects.equals(iconName, "Bitbucket"))
        {
            imageView.setImageResource(R.drawable.bitbucker100x100);
        }
        if(Objects.equals(iconName, "Bitcoin"))
        {
            imageView.setImageResource(R.drawable.bitcoin100x100);
        }
        if(Objects.equals(iconName, "Blogger"))
        {
            imageView.setImageResource(R.drawable.blogger100x100);
        }
        if(Objects.equals(iconName, "Discord"))
        {
            imageView.setImageResource(R.drawable.discord100x100);
        }
        if(Objects.equals(iconName, "Dropbox"))
        {
            imageView.setImageResource(R.drawable.dropbox100x100);
        }
        if(Objects.equals(iconName, "Ebay"))
        {
            imageView.setImageResource(R.drawable.ebay100x100);
        }

        return view;
    }
}
