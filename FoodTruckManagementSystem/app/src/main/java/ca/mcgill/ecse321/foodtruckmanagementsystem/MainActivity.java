package ca.mcgill.ecse321.foodtruckmanagementsystem;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> foodList;
    private ArrayAdapter<String> adapterList;
    private EditText newfood_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listFood);

        try {
            foodList = (ArrayList<String>)readCachedFile (MainActivity.this, "apk");
        } catch (IOException e) {
            String[] foods = {""};
            foodList = new ArrayList<>(Arrays.asList(foods));
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            String[] foods = {""};
            foodList = new ArrayList<>(Arrays.asList(foods));
            e.printStackTrace();
        }

        /*
        String[] foods = {""};
        foodList = new ArrayList<>(Arrays.asList(foods));
        try {
            createCachedFile (MainActivity.this, "apk", foodList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        adapterList = new ArrayAdapter<String>(this, R.layout.list_food, R.id.textitem, foodList);

        listView.setAdapter(adapterList);
        newfood_name = (EditText)findViewById(R.id.newfood_name);

        refreshData();
    }

    private void refreshData() {
        TextView tv = (TextView) findViewById(R.id.newfood_name);
        tv.setText("");
    }

    public void addFood(View v) throws IOException, ClassNotFoundException {
        TextView errorTextView = (TextView)findViewById(R.id.error);

        /*
        TextView tv = (TextView) findViewById(R.id.newfood_name);
        Food food = new Food(tv.getText().toString(), 12.95D, 0);

        try {
            ftmsc.addFood(food);
            errorTextView.setText("");
        } catch (InvalidInputException e) {
            errorTextView.setText("Food name cannot be empty!");
        }
        */

        String newItem = newfood_name.getText().toString();
        if (newItem.equals("")) {
            errorTextView.setText("Food name cannot be empty!");
        } else {
            foodList.add(newItem);
            adapterList.notifyDataSetChanged();
            errorTextView.setText("");
        }

        createCachedFile (MainActivity.this, "apk", foodList);
        refreshData();
    }

    public static void createCachedFile (Context context, String key, ArrayList<String> fileName) throws IOException {

        String tempFile = null;
        for (String file : fileName) {
            FileOutputStream fos = context.openFileOutput (key, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject (fileName);
            oos.close ();
            fos.close ();

        }
    }

    public static Object readCachedFile (Context context, String key) throws IOException, ClassNotFoundException {
        FileInputStream fis = context.openFileInput (key);
        ObjectInputStream ois = new ObjectInputStream (fis);
        Object object = ois.readObject ();
        return object;
    }

    public void clearing(View v) {
        String[] foods = {""};
        foodList = new ArrayList<>(Arrays.asList(foods));
        try {
            createCachedFile (MainActivity.this, "apk", foodList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ListView listView = (ListView)findViewById(R.id.listFood);

        adapterList = new ArrayAdapter<String>(this, R.layout.list_food, R.id.textitem, foodList);

        listView.setAdapter(adapterList);
        newfood_name = (EditText)findViewById(R.id.newfood_name);

        TextView errorTextView = (TextView)findViewById(R.id.error);
        errorTextView.setText("");
        refreshData();
    }
}
