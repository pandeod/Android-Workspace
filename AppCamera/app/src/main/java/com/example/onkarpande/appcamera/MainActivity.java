package com.example.onkarpande.appcamera;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.os.Environment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.ContentValues.TAG;
import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;

public class MainActivity extends Activity {

    private Camera mCamera;
    private CameraPreview mPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Camera.PictureCallback mPicture = new Camera.PictureCallback() {

            @Override
            public void onPictureTaken(byte[] data, Camera camera) {

                File pictureFile = getOutputMediaFile(MEDIA_TYPE_IMAGE);
                if (pictureFile == null){
                    Log.d(TAG, "Error creating media file, check storage permissions: ");
                    return;
                }
                try {
                    FileOutputStream fos = new FileOutputStream(pictureFile);
                    fos.write(data);
                    fos.close();
                } catch (FileNotFoundException e) {
                    Log.d(TAG, "File not found: " + e.getMessage());
                } catch (IOException e) {
                    Log.d(TAG, "Error accessing file: " + e.getMessage());
                }
            }
        };

        if(checkCameraHardware(this))
        {
            Toast.makeText(this,"Camera is available",Toast.LENGTH_LONG).show();
            // Create an instance of Camera
            mCamera = getCameraInstance();
            // Create our Preview view and set it as the content of our activity.
            mPreview = new CameraPreview(this, mCamera);
            FrameLayout preview = findViewById(R.id.camera_preview);
            preview.addView(mPreview);

            Button captureButton = findViewById(R.id.button_capture);
            captureButton.setOnClickListener ( new View.OnClickListener() {
                @Override
               public void onClick(View v) {
            // get an image from the camera
                mCamera.takePicture(null, null,null, mPicture);
           } } );
        }
        else
        {
            Toast.makeText(this,"Camera not available",Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    /** A safe way to get an instance of the Camera object. */
    public Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance

            Camera.Parameters parameters=c.getParameters();

            if(this.getResources().getConfiguration().orientation!= Configuration.ORIENTATION_LANDSCAPE)
            {
                parameters.set("orientation","landscape");
                c.setDisplayOrientation(90);
                parameters.setRotation(90);
            }
            else
            {
                parameters.set("orientation","landscape");
                c.setDisplayOrientation(0);
                parameters.setRotation(0);
            }


        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }

    private File getOutputMediaFile(int type) {

        File mediaStorageDir = new File(Environment.getExternalStorageDirectory(), "MyCameraApp");

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Toast.makeText(this,"failed to create directory",Toast.LENGTH_LONG).show();
                return null;
            }
        }
        return mediaStorageDir;
    }
}
