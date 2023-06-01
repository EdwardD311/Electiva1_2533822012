package sv.edu.utec.parcial4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigationrail.NavigationRailView;

import sv.edu.utec.parcial4.datos.baseHelper;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drwerLayout;
    Toolbar tlBar;
    NavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tlBar=findViewById(R.id.toolbar);
        drwerLayout=findViewById(R.id.drawerLayout);
        navView=findViewById(R.id.navigator);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drwerLayout, tlBar, R.string.open, R.string.close);
        drwerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white,null));

        baseHelper basehelper = new baseHelper(this);
        SQLiteDatabase db = basehelper.getWritableDatabase();
        if(db!=null){
            Toast.makeText(this,"Base de datos creada", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "ERROR AL CREAR BD", Toast.LENGTH_LONG).show();
        }
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.Mensajes:
                        fragmentosR(new MensajesFragment());
                        drwerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(getApplicationContext(), "Mensaje", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Comentarios:
                        fragmentosR(new ComentariosFragment());
                        drwerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(getApplicationContext(), "Comentarios", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Enviar:
                        fragmentosR(new EnviarFragment());
                        drwerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(getApplicationContext(), "Enviar", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Compartir:
                        fragmentosR(new CompartirFragment());
                        drwerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(getApplicationContext(), "Compartir", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Explorar:
                        fragmentosR(new ExplorarFragment());
                        drwerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(getApplicationContext(), "Explorar", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });



    }
    private void fragmentosR(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frmLayoutContenedor,fragment);
        fragmentTransaction.commit();
    }
}