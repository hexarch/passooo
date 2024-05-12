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
import java.util.HashMap;
import java.util.Map;

public class CustomAdapter extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> passwordNames;
    private ArrayList<String> passwordIcons; // Resim dosya adlarını içeren liste
    // İkon adlarıyla drawable kaynaklarını eşleştiren Map
    private static final Map<String, Integer> iconResourceMap;
    static {
        iconResourceMap = new HashMap<>();
        iconResourceMap.put("Adobe", R.drawable.adobe100x100);
        iconResourceMap.put("Airbnb", R.drawable.airbnb100x100);
        iconResourceMap.put("Amazon", R.drawable.amazon100x100);
        iconResourceMap.put("Android", R.drawable.android100x100);
        iconResourceMap.put("Apple", R.drawable.appel100x100);
        iconResourceMap.put("Atlassian", R.drawable.atlassian100x100);
        iconResourceMap.put("Bitbucket", R.drawable.bitbucker100x100);
        iconResourceMap.put("Bitcoin", R.drawable.bitcoin100x100);
        iconResourceMap.put("Blogger", R.drawable.blogger100x100);
        iconResourceMap.put("Discord", R.drawable.discord100x100);
        iconResourceMap.put("Dropbox", R.drawable.dropbox100x100);
        iconResourceMap.put("Ebay", R.drawable.ebay100x100);
        iconResourceMap.put("Epic", R.drawable.epic100x100);
        iconResourceMap.put("Facebook", R.drawable.facebook);
        iconResourceMap.put("Flickr", R.drawable.flickr100x100);
        iconResourceMap.put("Github", R.drawable.github100x100);
        iconResourceMap.put("Gmail", R.drawable.gmail100x100);
        iconResourceMap.put("Google", R.drawable.google100x100);
        iconResourceMap.put("Huawei", R.drawable.huawei100x100);
        iconResourceMap.put("Instagram", R.drawable.instagramicon150x150);
        iconResourceMap.put("Linkedin", R.drawable.linkedln100x100);
        iconResourceMap.put("Microsoft", R.drawable.microsoft100x100);
        iconResourceMap.put("Netflix", R.drawable.netflix100x100);
        iconResourceMap.put("Mastercard", R.drawable.mastercard100x100);
        iconResourceMap.put("Nintendo", R.drawable.nintendo100x100);
        iconResourceMap.put("Paypal", R.drawable.paypal100x100);
        iconResourceMap.put("Playstation", R.drawable.playstation100x100);
        iconResourceMap.put("Reddit", R.drawable.redditicon150x150);
        iconResourceMap.put("Skype", R.drawable.skype100x100);
        iconResourceMap.put("Slack", R.drawable.slack100x100);
        iconResourceMap.put("Snapchat", R.drawable.snapchat100x100);
        iconResourceMap.put("Spotify", R.drawable.spotify100x100);
        iconResourceMap.put("Steam", R.drawable.steamicon2);
        iconResourceMap.put("Teamviewer", R.drawable.teamviewer100x100);
        iconResourceMap.put("Telegram", R.drawable.telegram100x100);
        iconResourceMap.put("Tinder", R.drawable.tinder100x100);
        iconResourceMap.put("Tumblr", R.drawable.tumblr100x100);
        iconResourceMap.put("Twitch", R.drawable.twitch100x100);
        iconResourceMap.put("Twitter", R.drawable.twittericon150x150);
        iconResourceMap.put("Visa", R.drawable.visa100x100);
        iconResourceMap.put("Vk", R.drawable.vk100x100);
        iconResourceMap.put("Wechat", R.drawable.wechat100x100);
        iconResourceMap.put("Windows", R.drawable.windows100x100);
        iconResourceMap.put("Xbox", R.drawable.xbox100x100);
        iconResourceMap.put("Xiaomi", R.drawable.xiaomi100x100);
        iconResourceMap.put("Youtube", R.drawable.youtube100x100);
        iconResourceMap.put("Zoom", R.drawable.zoom100x100);

    }
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
        String iconName = passwordIcons.get(position);
        Integer resourceId = iconResourceMap.get(iconName); // İlgili drawable kaynağını al
        if (resourceId != null) {
            imageView.setImageResource(resourceId); // Resmi ayarla
        } else {
            // İlgili drawable kaynağı bulunamazsa hata mesajı göster
            Toast.makeText(context, "Drawable resource not found for icon: " + iconName, Toast.LENGTH_SHORT).show();
        }
        textView.setText(passwordNames.get(position)); // Metni ayarla
        return view;
    }
}
