package tn.esprit.salmen.advancedintents;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callIntent(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.Button01:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.tourismtunisia.com/"));
                startActivity(intent);
                break;
            case R.id.Button02:
                intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:(+216)53244860"));
                startActivity(intent);
                break;
            case R.id.Button03:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:36.899202,10.189615?z=19"));
                startActivity(intent);
                break;
            case R.id.Button04:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=SidiBouzid"));
                startActivity(intent);
                break;
            case R.id.Button05:
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
                break;
            case R.id.Button06:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("content://contacts/people/"));
                startActivity(intent);
                break;
            case R.id.Button07:
                intent = new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
                startActivity(intent);
                break;
            case R.id.Button08:
                intent = new Intent();
                intent.setAction(android.content.Intent.ACTION_VIEW);
                File file = new File("/sdcard/awicha1.mp3");
                intent.setDataAndType(Uri.fromFile(file), "audio/*");
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public boolean isIntentAvailable(Context context, String action) {
        final PackageManager packageManager = context.getPackageManager();
        final Intent intent = new Intent(action);
        List<ResolveInfo> resolveInfo = packageManager.queryIntentActivities(
                intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (resolveInfo.size() > 0) {
            return true;
        }
        return false;
    }
}
