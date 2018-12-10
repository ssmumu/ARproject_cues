package com.example.samiha.glassapp4;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.speech.RecognizerIntent;
import android.support.v4.app.NavUtils;
import android.widget.Toast;


public class MyNoteActivity extends Activity implements OnClickListener {
    public ListView mList;
    public Button speakButton;

    public static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;

    private static final int SPEECH_REQUEST_CODE = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_note);

        this.arrayAdapterListView();

        speakButton = (Button) findViewById(R.id.button3);
        speakButton.setOnClickListener(this);

        voiceinputbuttons();
        startVoiceRecognitionActivity();
    }

    private void arrayAdapterListView()
    {
        setTitle("ListView");

        List<String> dataList = new ArrayList<String>();
        ListView listView = (ListView)findViewById(R.id.list1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, dataList);
        listView.setAdapter(arrayAdapter);


    }

    public void CameraOnPage() {
      //  startActivity(new Intent("android.intent.action.INFOSCREEN"));
          Intent intent = new Intent(this, CameraActivity.class);
          startActivity(intent);


    }

    public void voiceinputbuttons() {
        speakButton = (Button) findViewById(R.id.button3);
        mList = (ListView) findViewById(R.id.list1);
    }

    public void startVoiceRecognitionActivity() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
               "Speech recognition demo");
        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub

        startVoiceRecognitionActivity();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {
            // Fill the list view with the strings the recognizer thought it
            // could have heard
            ArrayList matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            mList.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, matches));
            // matches is the result of voice input. It is a list of what the
            // user possibly said.
            // Using an if statement for the keyword you want to use allows the
            // use of any activity if keywords match
            // it is possible to set up multiple keywords to use the same
            // activity so more than one word will allow the user
            // to use the activity (makes it so the user doesn't have to
            // memorize words from a list)
            // to use an activity from the voice input information simply use
            // the following format;
            // if (matches.contains("keyword here") { startActivity(new
            // Intent("name.of.manifest.ACTIVITY")

            if (matches.contains("show smile cues")) {
                List<String> yes = new ArrayList<String>();
                yes.add("YES");
                mList.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, yes));

                Intent intent = new Intent(this, FaceTrackerActivity.class);
                startActivity(intent);
            }
        }
    }


//    // Create an intent that can start the Speech Recognizer activity
//    private void displaySpeechRecognizer() {
//        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
//                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//        // Start the activity, the intent will be populated with the speech text
//        startActivityForResult(intent, SPEECH_REQUEST_CODE);
//    }
//
//
//
//
//    // This callback is invoked when the Speech Recognizer returns.
//    // This is where you process the intent and extract the speech text from the intent.
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
//            List<String> results = data.getStringArrayListExtra(
//                    RecognizerIntent.EXTRA_RESULTS);
//            String spokenText = results.get(0);
//            // Do something with spokenText
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//


}
