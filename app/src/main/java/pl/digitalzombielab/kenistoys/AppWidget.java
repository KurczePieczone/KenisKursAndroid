package pl.digitalzombielab.kenistoys;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Random;

/**
 * Implementation of App Widget functionality.
 */
public class AppWidget extends AppWidgetProvider {

    private static String path = Environment.getExternalStorageDirectory() + "/Digital Zombie Lab/Kenis Toys/";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId, int[] appWidgetIds) {
        // TODO load file
        String content = getContent();
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.app_widget);
        views.setTextViewText(R.id.appwidget_text, content);

        // Instruct the widget manager to update the widget
        Intent intent = new Intent(context, AppWidget.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        views.setOnClickPendingIntent(R.id.imageIco, pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId, appWidgetIds);
        }

    }

    private static String getContent()
    {
        try{
            File file = new File(path);
            String[] paths = file.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String filename) {
                    return filename.endsWith(".txt");
                }
            });
            Random generator = new Random();
            int i = generator.nextInt(paths.length);
            return Files.toString(new File(path + paths[i]), Charsets.UTF_8);
        }
        catch (Exception e)
        {
            return e.toString();
        }
    }

}

