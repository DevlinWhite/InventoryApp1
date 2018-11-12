package com.example.android.inventoryapp1.data;

import android.provider.BaseColumns;

public final class ClothesContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private ClothesContract() {}

    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single pet.
     */
    public static final class ClothesEntry implements BaseColumns {

        /** Name of database table for pets */
        public final static String TABLE_NAME = "clothes";

        /**
         * Unique ID number for the pet (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Unique ID number for the pet (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _PRICE = "price";

        /**
         * Name of the pet.
         *
         * Type: TEXT
         */
        public final static String COLUMN_PRODUCT_NAME ="name";

        /**
         * Gender of the pet.
         *

         * Type: INTEGER
         */
        public final static String COLUMN_QTY = "QTY";

        /**
         * Breed of the pet.
         *
         * Type: TEXT
         */
        public final static String COLUMN_SUPP_NAME = "Supplier Name";


        /**
         * Weight of the pet.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_SUPP_PHONENUMBER = "SUPPLIER PHONE NUMBER";

        /**
         * Possible values for the gender of the pet.
         */

    }

}