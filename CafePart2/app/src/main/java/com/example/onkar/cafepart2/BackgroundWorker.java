package com.example.onkar.cafepart2;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class BackgroundWorker extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;

    public BackgroundWorker(Context context) {
        this.context=context;
    }

    @Override
    protected String doInBackground(String... voids) {
        String type=voids[0];
        String login_url="https://vedh.000webhostapp.com/connect/getOrder.php";

        if(type.equals("getOrder"))
        {
            try
            {
                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("get_data","UTF-8")+"="+URLEncoder.encode("get_data","UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream =httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        alertDialog =new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Placing Order ....");
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}


/*
    getOrder.php
    <?php
	require "connect.php";
	$getData=$_POST["get_data"];

	if($getData=="get_data")
	{
		$query="select * from`orders`";
		$result=mysqli_query($db,$query);
		$rows=array();
		if($result)
		{
			while($r=mysqli_fetch_assoc($result))
			{
				$rows[]=$r;
			}
			echo json_encode($rows);
		}
		else
		{
			echo "Error...";
		}
	}
?>

 */