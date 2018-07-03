package com.example.onkarpande.mybrowser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    private static final String[] COUNTRIES = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final String url="https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=SwixWvyiKqemX5XYnoAM&gws_rd=ssl";
        loadWebView(url);

        final EditText searchText =  findViewById(R.id.search_box);
        ImageView menuButton =findViewById(R.id.menu_button);
        ImageView searchButton=findViewById(R.id.search_button);
        ImageView homeButton=findViewById(R.id.menu_home);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);

        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.search_box);

        textView.setAdapter(adapter);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String query =searchText.getText().toString();
                String escapedQuery = null;
                try {
                    escapedQuery = URLEncoder.encode(query, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String uri = "http://www.google.com/#q=" + escapedQuery;
                loadWebView(uri);
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               loadWebView(url);
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(view);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.setting :
                return  true;
            case R.id.github :
                loadWebView("https://github.com/pandeod");
                return true;
            case R.id.w3school:
                loadWebView("https://www.w3schools.com/colors/colors_picker.asp");
                return true;
            case R.id.javatpoint:
                loadWebView("https://www.javatpoint.com/java-tutorial");
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu, popup.getMenu());
        popup.show();
    }

    public void loadWebView(String addr)
    {
        WebView myWebView = findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl(addr);
    }
}
