package cn.byhieg.volleydemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    RequestQueue queue;
    StringRequest stringRequest;
    JsonObjectRequest jsonObjectRequest;
    ImageRequest imageRequest;
    GsonRequest<CPS> gsonRequest;
    public ImageView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        queue = Volley.newRequestQueue(getApplicationContext());
//        stringRequest = new StringRequest("http://www.baidu.com", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                result.setText(response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                result.setText("请求失败");
//            }
//        });

//        jsonObjectRequest = new JsonObjectRequest
//                (Request.Method.GET,"http://115.159.145.201:8011/cps/api/v1/subInfos", null, new
//                        Response
//                        .Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        result.setText(response.toString());
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        result.setText("请求失败");
//                    }
//                });

        imageRequest = new ImageRequest("http://wx3.sinaimg" +
                ".cn/mw600/a8f500c0gy1ffey2ge6juj20ka0ufwgb.jpg", new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                result.setImageBitmap(response);
            }
        }, 0, 0, Bitmap.Config
                .RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "显示失败", Toast.LENGTH_SHORT).show();
            }
        });

        ImageLoader imageLoader = new ImageLoader(queue, new BitmapCache());
        result = (ImageView) findViewById(R.id.result);

        ImageLoader.ImageListener listener = ImageLoader.getImageListener(result, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher);

        imageLoader.get("http://wx3.sinaimg" +
                ".cn/mw600/a8f500c0gy1ffey2ge6juj20ka0ufwgb.jpg", listener);

        gsonRequest = new GsonRequest<>(Request.Method.GET, "http://115.159.145.201:8011/cps/api/v1/subInfos", CPS.class, new Response.Listener<CPS>() {
            @Override
            public void onResponse(CPS response) {
                Toast.makeText(getApplicationContext(),response.getResult(),Toast
                        .LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                queue.add(imageRequest);
                    queue.add(gsonRequest);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    static class BitmapCache implements ImageLoader.ImageCache {

        LruCache<String, Bitmap> cache;

        public BitmapCache() {
            int maxtSize = 10 * 1024 * 1024;
            cache = new LruCache<>(maxtSize);
        }

        @Override
        public Bitmap getBitmap(String url) {
            return cache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            cache.put(url, bitmap);
        }
    }
}
