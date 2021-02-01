package cn.edu.xjtlu.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MyContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contact);

        MyContactDatabase db = new MyContactDatabase(this);
        db.addContact(new Contact(1012, "Alice", "88160000"));
        db.addContact(new Contact(913, "Bob", "88160001"));
        // Reading contact
        Contact contact = db.getContact(1);
        String log = "Id: "+ contact.getID()+" ,Name: " + contact.getName() + " ,Phone: " +
                contact.getPhoneNumber();
        // Writing Contacts to log
        Log.d("Name: ", log);
    }
}
