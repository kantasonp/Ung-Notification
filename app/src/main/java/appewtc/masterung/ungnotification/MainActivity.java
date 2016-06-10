package appewtc.masterung.ungnotification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private TextView textView;
    private CalendarView calendarView;
    private String dateString;
    private int hrAnInt, minusAnInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        textView = (TextView) findViewById(R.id.textView);
        calendarView = (CalendarView) findViewById(R.id.calendarView);

        //Get Current Date
        Calendar calendar = Calendar.getInstance();
        int intDay = calendar.get(Calendar.DAY_OF_MONTH);
        int intMonth = calendar.get(Calendar.MONTH) + 1;
        int intYear = calendar.get(Calendar.YEAR);
        hrAnInt = calendar.get(Calendar.HOUR_OF_DAY);
        minusAnInt = calendar.get(Calendar.MINUTE);

        dateString = findMyDate(intDay, intMonth, intYear);

        setupDate(dateString);

        changeDateActive();



    }   // Main Method

    private String findMyDate(int intDay, int intMonth, int intYear) {

        String result = null;

        result = Integer.toString(intDay) + "/" +
                Integer.toString(intMonth) + "/" +
                Integer.toString(intYear);


        return result;
    }

    private void changeDateActive() {

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {

                setupDate(findMyDate(day, month + 1, year));

            }   // onSelectDate
        });

    }   // changeDateActive

    private void setupDate(String dateString) {
        textView.setText(dateString);
    }

    public void clickAddDate(View view) {

        String[] dateStrings = textView.getText().toString().split("/");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateStrings[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(dateStrings[1]) -1 );
        calendar.set(Calendar.YEAR, Integer.parseInt(dateStrings[2]));
        calendar.set(Calendar.HOUR_OF_DAY, hrAnInt);
        calendar.set(Calendar.MINUTE, minusAnInt+1);
        calendar.set(Calendar.SECOND, 0);

        Log.d("10JuneV1", "Date Set ==> " + calendar.getTime().toString());

        sentValueToReceiver(calendar);

    }   // clickAddDate

    private void sentValueToReceiver(Calendar calendar) {

        int intRandom = 0;
        Random random = new Random();
        intRandom = random.nextInt(1000);

        Intent intent = new Intent(getBaseContext(), MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(),
                intRandom, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                pendingIntent);


    }   // sentValue

}   // Main Class
