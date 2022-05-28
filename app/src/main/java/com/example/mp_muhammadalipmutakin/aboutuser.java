package com.example.mp_muhammadalipmutakin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class aboutuser extends Activity implements View.OnClickListener {
    Button btkembali;
    private static final int AMBIL_FOTO_KECIL = 1;
    private static final int TAMPILKAN_GALLERY = 2;

    private static final String JPEG_FILE_PREFIX = "IMG_";
    private static final String JPEG_FILE_SUFFIX = ".jpg";

    private ImageView imageView;
    private Bitmap bitmap;
    private VideoView videoView;
    private Uri videoUri;

    private String mCurrentPhotoPath;

    private Intent ambilGambarIntent;
    private Intent tampilkanGalleryIntent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutuser);


        imageView = (ImageView) findViewById(R.id.imageView);

        findViewById(R.id.btkamera).setOnClickListener(this);
        findViewById(R.id.btgaleri).setOnClickListener(this);
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.activity_aboutuser, menu);
        return true;
    }

    private File getAlbumDir() {
        File storageDir = null;
        final String namaDirektori = "/DCIM/CameraSample";

        if
        (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            storageDir = new File
                    (Environment.getExternalStorageDirectory() + namaDirektori);
            if (storageDir != null) {
                if (!storageDir.mkdirs()) {
                    if (!storageDir.exists()) {
                        Log.d("CameraSample", "Gagal membuat direktori " + storageDir);
                        return null;
                    }
                }
            }

        } else {

            Log.v(getString(R.string.app_name), "Eksternal penyimpanan tidak diset READ/WRITE");
        }
        return storageDir;
    }

    private File createImageFile() throws IOException {
        String timeStamp = new
                SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = JPEG_FILE_PREFIX + timeStamp;

        File albumF = getAlbumDir();
        File imageF = File.createTempFile(imageFileName,
                JPEG_FILE_SUFFIX, albumF);

        return imageF;
    }

    private File setUpPhotoFile() throws IOException {
        File f = createImageFile();

        mCurrentPhotoPath = f.getAbsolutePath();
        return f;
    }

    public void onClick(View v) {
        switch
            // TODO Auto-generated method stub
        (v.getId()) {
            case R.id.btkamera:
                ambilGambarIntent = new
                        Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(ambilGambarIntent,
                        AMBIL_FOTO_KECIL);
                break;
            case R.id.btgaleri:
                tampilkanGalleryIntent = new
                        Intent(Intent.ACTION_PICK);
                tampilkanGalleryIntent.setType("image/*");
                startActivityForResult(tampilkanGalleryIntent,
                        TAMPILKAN_GALLERY);
                break;
            default:
        }
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        switch (requestCode) {
            case AMBIL_FOTO_KECIL:
                if (resultCode == RESULT_OK) {
                    handleSmallCameraPhoto(data);
                }
                break;
            case TAMPILKAN_GALLERY:
                if (resultCode == RESULT_OK) {
                    Uri photoUri = data.getData();
                    imageView.setImageURI(photoUri);

                    imageView.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    private void handleBigCameraPhoto() {
        if (mCurrentPhotoPath != null) {
            setPic();
            galleryAddPic();
            mCurrentPhotoPath = null;
        }
    }

    private void handleSmallCameraPhoto(Intent intent) {
        Bundle extras = intent.getExtras();
        bitmap = (Bitmap) extras.get("data");
        imageView.setImageBitmap(bitmap);

        String timeStamp = new
                SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = JPEG_FILE_PREFIX + timeStamp;


        if (MediaStore.Images.Media.insertImage(getContentResolver(),
                bitmap, imageFileName, null) != null) {
            Toast.makeText(this, "Saved",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Save Failed",
                    Toast.LENGTH_SHORT).show();
        }

        videoUri = null;
        imageView.setVisibility(View.VISIBLE);
    }

    private void setPic() {
        int targetW = imageView.getWidth();
        int targetH = imageView.getHeight();

        BitmapFactory.Options bmOptions = new
                BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        int scaleFactor = 1;
        if ((targetW > 0) || (targetH > 0)) {
            scaleFactor = Math.min(photoW / targetW, photoH / targetH);

        }
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new
                Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }
    public void onBackPressed() {
        Intent intent1 = new Intent(getApplicationContext(), MenuUtama.class);
        startActivity(intent1);
    }
}
