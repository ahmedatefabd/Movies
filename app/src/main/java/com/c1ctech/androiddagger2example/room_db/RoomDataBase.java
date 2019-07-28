package com.c1ctech.androiddagger2example.room_db;
import android.content.Context;
import com.c1ctech.androiddagger2example.model_db.Movie_DB;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Movie_DB.class}, version = 1, exportSchema = false)
public abstract class RoomDataBase extends RoomDatabase {

    private static RoomDatabase instance;
    public abstract DAO oper();

    public RoomDataBase() {
    }

    public static RoomDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (RoomDataBase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDataBase.class,
                            "product_database")
                            .build();

                }
            }
        }
        return instance;
    }

}
