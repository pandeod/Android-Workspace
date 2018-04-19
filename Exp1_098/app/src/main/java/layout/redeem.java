package layout;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

import com.lightning.exp1_098.MainActivity;
import com.lightning.exp1_098.R;

/**
 * Implementation of App Widget functionality.
 */
/**
 * Implementation of App Widget functionality.
 */
public class redeem extends AppWidgetProvider {
    public static int clickcount=0;
    public static String t1,t2,t3;
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        CharSequence widgetText = context.getString(R.string.appwidget_text);
// Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.redeem);
// Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
// There may be multiple widgets active, so update all of them
        int widgetId=0;
        final int count = appWidgetIds.length;
        for (int i = 0;i<count ; i++)
        {
            widgetId = appWidgetIds[i];
        }

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.redeem);

            views.setTextViewText(R.id.offerView,setOffer());

        Intent intent = new Intent(context, redeem.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        views.setOnClickPendingIntent(R.id.button, pendingIntent);
        appWidgetManager.updateAppWidget(widgetId, views);
        updateAppWidget(context, appWidgetManager, widgetId);
    }

    private String setOffer() {
        t1 = "Get Upto 57 Off Extra 25 Cashback On Food, Drinks and Movie";
        t2 = "Now Get Every Food Order At Flat Rs.99 On Box8";
        t3 = "Now Get Free Saucy Wrap/Mc-Aloo/Mc-Egg On Online Order";

        clickcount=(clickcount+1)%3;
        if(clickcount==0)
            return t1;
        else if (clickcount==1)
            return t2;
        else if (clickcount==2)
            return t3;
        else
            return t1;
    }
    @Override
    public void onEnabled(Context context) {
// Enter relevant functionality for when the first widget is created
    }
    @Override
    public void onDisabled(Context context) {
// Enter relevant functionality for when the last widget is disabled
    }
}