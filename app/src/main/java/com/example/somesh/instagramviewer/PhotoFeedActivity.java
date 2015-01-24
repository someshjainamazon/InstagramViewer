package com.example.somesh.instagramviewer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PhotoFeedActivity extends ActionBarActivity {

    private final String clientId="b0ddc9bc7657454989b02c70c9b2c9b6";
    private ArrayList<Photo> photoArrayList;
    private PhotoAdapter photoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_feed);
        populatePhotos();
    }

    private void populatePhotos() {
        String instagramPhotoStreamUrl = "https://api.instagram.com/v1/media/popular?client_id="+clientId;
        AsyncHttpClient httpClient = new AsyncHttpClient();
        photoArrayList = new ArrayList<Photo>();
        photoAdapter= new PhotoAdapter(this, photoArrayList);
        ListView lvPhotos = (ListView)findViewById(R.id.lvItems);
        lvPhotos.setAdapter(photoAdapter)   ;

        httpClient.get(instagramPhotoStreamUrl, new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                JSONArray jsonPhotos = null;

                try{
                    jsonPhotos = response.getJSONArray("data");
                    photoArrayList.clear();
                    for (int i=0;i<jsonPhotos.length();i++){

                        JSONObject jsonPhoto = jsonPhotos.getJSONObject(i);
                        Photo photo = new Photo();
                        photo.setUsername(jsonPhoto.getJSONObject("user").getString("username"));
                        photo.setProfilePictureUrl(jsonPhoto.getJSONObject("user").getString("profile_picture"));
                        if(jsonPhoto.getJSONObject("caption")!=null) photo.setCaption(jsonPhoto.getJSONObject("caption").getString("text"));
                        photo.setPhotoUrl(jsonPhoto.getJSONObject("images").getJSONObject("standard_resolution").getString("url"));
                        photo.setTimeElapsed(Long.valueOf(jsonPhoto.getString("created_time")));
                        photo.setPhotoHeight(jsonPhoto.getJSONObject("images").getJSONObject("standard_resolution").getInt("height"));
                        photo.setLikesCount(jsonPhoto.getJSONObject("likes").getInt("count"));
                        photoArrayList.add(photo);

                    }
                    photoAdapter.notifyDataSetChanged();
                }catch(JSONException e){

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_photo_feed, menu);
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
}
