
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SimpleCamera extends AppCompatActivity {
Button btnc;
ImageView imv;
private static final int CAMERA_REQUEST=123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_camera);
        imv=(ImageView)findViewById(R.id.imv);
        btnc=(Button)findViewById(R.id.btn);
        
    }

    public void btnclick(View view) {

        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,CAMERA_REQUEST);
    }
    public  void onActivityResult(int requestCode,int resultCode,Intent data){
        if (requestCode==CAMERA_REQUEST &&resultCode== Activity.RESULT_OK){
            Bitmap photo =(Bitmap)data.getExtras().get("data");
            imv.setImageBitmap(photo);
        }
    }
}
