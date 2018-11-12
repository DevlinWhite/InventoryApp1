package com.example.android.inventoryapp1;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.inventoryapp1.data.ClothesContract.ClothesEntry;
import com.example.android.inventoryapp1.data.ClothesdbHelper;

/**
 * Allows user to create a new pet or edit an existing one.
 */
public class EditorActivity extends AppCompatActivity {

    /** EditText field to enter the pet's name */
    private EditText mProductNameEditText;

    /** EditText field to enter the pet's breed */
    private EditText mPriceEditText;

    /** EditText field to enter the pet's weight */
    private EditText mQtyEditText;

    /** EditText field to enter the pet's gender */
    private EditText mSuppNameEditText;

    /** EditText field to enter the pet's gender */
    private EditText mSuppNumberEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        // Find all relevant views that we will need to read user input from
        mPriceEditText = (EditText) findViewById(R.id.edit_price);
        mProductNameEditText = (EditText) findViewById(R.id.edit_product_name);
        mQtyEditText = (EditText) findViewById(R.id.edit_qty);
        mSuppNameEditText = (EditText) findViewById(R.id.edit_supp_name);
        mSuppNumberEditText = (EditText) findViewById(R.id.edit_supp_number);


    }


    /**
     * Get user input from editor and save new pet into database.
     */
    private void insertPet() {
        // Read from input fields
        // Use trim to eliminate leading or trailing white space
        String priceString = mPriceEditText.getText().toString().trim();
        String productNameString = mProductNameEditText.getText().toString().trim();
        String suppNameString = mSuppNameEditText.getText().toString().trim();
        String qtyString = mQtyEditText.getText().toString().trim();
        int qty = Integer.parseInt(qtyString);
        String suppNumberString = mSuppNumberEditText.getText().toString().trim();

        // Create database helper
        ClothesdbHelper mDbHelper = new ClothesdbHelper(this);

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and pet attributes from the editor are the values.
        ContentValues values = new ContentValues();
        values.put(ClothesEntry._PRICE, priceString);
        values.put(ClothesEntry.COLUMN_PRODUCT_NAME, productNameString);
        values.put(ClothesEntry.COLUMN_SUPP_NAME, suppNameString);
        values.put(ClothesEntry.COLUMN_QTY, qty);
        values.put(ClothesEntry.COLUMN_SUPP_PHONENUMBER, suppNumberString);

        // Insert a new row for pet in the database, returning the ID of that new row.
        long newRowId = db.insert(ClothesEntry.TABLE_NAME, null, values);

        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving pet", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Pet saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                // Save pet to database
                insertPet();
                // Exit activity
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Do nothing for now
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}