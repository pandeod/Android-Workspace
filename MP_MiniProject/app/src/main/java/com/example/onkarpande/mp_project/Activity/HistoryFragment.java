package com.example.onkarpande.mp_project.Activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.example.onkarpande.mp_project.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HistoryFragment extends Fragment {

    private ListView listView;
    String[] history;

    public HistoryFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_history, container, false);

        listView=root.findViewById(R.id.list_view);

        GetJSON getJSON = new GetJSON();
        getJSON.execute();

        Button btn=root.findViewById(R.id.sync_history);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"History Synced",Toast.LENGTH_SHORT).show();
                GetJSON getJSON = new GetJSON();
                getJSON.execute();
            }
        });

        return root;
    }

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String json) {
                super.onPostExecute(json);
                try {
                    loadIntoListView(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL("https://summarysite.000webhostapp.com/include/getAllorders.php");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }

                    return sb.toString().trim();

                } catch (Exception e) {
                    return null;
                }
            }
        }

        void loadIntoListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
         history = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            String status="";
            if(obj.getString("status").equals("0"))
            {
                status="pending";
            }
            else if(obj.getString("status").equals("1"))
            {
                status="preparing";
            }
            else if(obj.getString("status").equals("2"))
            {
                status="completed";
            }
            else
            {
                status="cancelled";
            }
            history[i] = "\nOrder No: "+obj.getString("order_id")+"\t\t\t\t\t\tOrder by : "+obj.getString("user")+"\n"+obj.getString("ordered")+"\nStatus : "+status+"\n";
        }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, history);
            listView.setAdapter(arrayAdapter);
    }

}

