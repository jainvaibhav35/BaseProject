package baseproject.com.database.sqllite;

import android.provider.BaseColumns;

/**
 * Created by lin on 27/7/16.
 */

public class ContractClass {

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ENTRY_ID = "name";
    }
}
