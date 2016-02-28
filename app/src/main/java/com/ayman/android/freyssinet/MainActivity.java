package com.ayman.android.freyssinet;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    WebView webview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webview = (WebView) findViewById(R.id.webView);

                // تمكين جافا سكريبت في صفحة الويب
                webview.getSettings().setJavaScriptEnabled(true);

                // السماح بالتكبير وتصغير في الصفحة
                webview.getSettings().setBuiltInZoomControls(true);

                // تصغير صفحة الويب لتناسب شاشة الجوال
                webview.getSettings().setLoadWithOverviewMode(true);
                webview.getSettings().setUseWideViewPort(true);

                // فتح صفحة الويب المطلوبة .. اكتب رابط الصفحة التي تريد فتحها بالتطبيق بالاسفل
                webview.loadUrl("http://outlook.office365.com ");

                // عرض شريط المعالجة والتقدم لصفحة الويب
                webview.setWebChromeClient(new WebChromeClient() {
                    public void onProgressChanged(WebView view, int progress) {
                        setProgress(progress * 100);
                    }
                });

                // الاتصال بكلاس InsideWebViewClient
                webview.setWebViewClient(new InsideWebViewClient());


            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //WebView webView = (WebView) findViewById(R.id.webView);
        //webView.loadUrl("http://www.andrody.com/");

        // ربط وتعريف المتغير webview بواسطة الآي دي
        webview = (WebView) findViewById(R.id.webView);

        // تمكين جافا سكريبت في صفحة الويب
        webview.getSettings().setJavaScriptEnabled(true);

        // السماح بالتكبير وتصغير في الصفحة
        webview.getSettings().setBuiltInZoomControls(true);

        // تصغير صفحة الويب لتناسب شاشة الجوال
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);

        // فتح صفحة الويب المطلوبة .. اكتب رابط الصفحة التي تريد فتحها بالتطبيق بالاسفل
        webview.loadUrl("http://www.freyssinet.com");

        // عرض شريط المعالجة والتقدم لصفحة الويب
        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                setProgress(progress * 100);
            }
        });

        // الاتصال بكلاس InsideWebViewClient
        webview.setWebViewClient(new InsideWebViewClient());
    }
    private class InsideWebViewClient extends WebViewClient {
        @Override
        // تمكين وعرض الصفحة داخل التطبيق نفسه دون الخروج لمتصفح خارجي
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }}


        @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            webview.getSettings().setJavaScriptEnabled(true);

            // السماح بالتكبير وتصغير في الصفحة
            webview.getSettings().setBuiltInZoomControls(true);

            // تصغير صفحة الويب لتناسب شاشة الجوال
            webview.getSettings().setLoadWithOverviewMode(true);
            webview.getSettings().setUseWideViewPort(true);

            // فتح صفحة الويب المطلوبة .. اكتب رابط الصفحة التي تريد فتحها بالتطبيق بالاسفل
            webview.loadUrl("https://www.google.com.sa/maps/dir/21.5585046,39.1536681/21.5585046,39.1536636/@21.5586168,39.1536253,19.25z/data=!4m2!4m1!3e0");

            // عرض شريط المعالجة والتقدم لصفحة الويب
            webview.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress) {
                    setProgress(progress * 100);
                }
            });

            // الاتصال بكلاس InsideWebViewClient
            webview.setWebViewClient(new InsideWebViewClient());

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
