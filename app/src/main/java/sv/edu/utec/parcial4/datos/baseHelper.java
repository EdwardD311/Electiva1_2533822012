package sv.edu.utec.parcial4.datos;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class baseHelper extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS=1;
    private static final String NOMBRE_BASE="DBPARCIAL4.db";
    private static final String NOMBRE_TABLAE="tEvento";
    private static final String NOMBRE_TABLEA="tAsignatura";
    private static final String NOMBRE_TABLEH="tHorario";
    private static final String NOMBRE_TABLED="tDeber";

    public baseHelper(@Nullable Context context) {
        super(context, NOMBRE_BASE, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+NOMBRE_TABLAE+"  ("+
                "idEvento INTERGER PRIMARY KEY AUTOINCREMENT, "+
                "Nombre VARCHAR NOT NULL, "+
                "Descripcion VARCHAR NOT NULL,"+
                "Ubicacion VARCHAR NOT NULL"
                +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+NOMBRE_TABLAE);
        onCreate(db);

    }
}
