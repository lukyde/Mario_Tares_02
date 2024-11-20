package dam.pmdm.tarea2RMLP;

import android.content.SharedPreferences;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.preference.PreferenceManager;

import dam.pmdm.tarea2RMLP.databinding.ActivityMainBinding;
import androidx.appcompat.app.ActionBarDrawerToggle;

/**
 *La clase principal donde se gentiona la vista principal de la app
 *
 */
public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private ActionBarDrawerToggle toggle;
    private ActivityMainBinding binding;

    /**
     * Método que inicializa la actividad, configurando la interfaz de usuario,
     * el controlador de navegación, los menús y la carga de preferencias del usuario.
     *
     * @param savedInstanceState Estado previamente guardado de la actividad.
     */
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

         binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration  appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController);

        ImageView imagenAcerca = (ImageView)findViewById(R.id.contex_imagen);
        registerForContextMenu(imagenAcerca);

        // Configurar menú toggle
        configureToggleMenu();

        // Configurar la navegación
        configureNavigation();

        // Configurar el icono del menú en la ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        }
        //Guardado del setting
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String username = prefs.getString("username", "default_username");
        String contrasena= prefs.getString("password","default_contrasena");
        Preference.saveUserName(this,username);
        Preference.saveKey(this,contrasena );

        String nombreUsuario = Preference.getKeyUsername(this);
        String contrasenaUsuario = Preference.getKeyKey(this);
        Toast.makeText(getApplicationContext(),getString(R.string.mensajeGuardado) + " " + nombreUsuario, Toast.LENGTH_LONG).show();
        

    };



    /**
     *Método para crear el menú contextual
     *
     * @param menu recibe un objeto de tipo menú
     *
     *
     */


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.acerca_de, menu);
      

    }
    /**
     *Método para gestionar le menú contextual de "acerca de"
     * @param item recibe el objeto pulsado, en este caso la imagen.
     *
     */

    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.item_menu){
            FragmentManager fragmentManager = getSupportFragmentManager();
            AcercaDialogo dialogo = new AcercaDialogo();
            dialogo.show(fragmentManager, "tagAlerta");
            return true;
        }
        return super.onContextItemSelected(item);
    }

    /**
     *Método que gestiona cuando el usuario hace click en un personaje , llevando a este a la pantalla detalle
     *Imprime en pantalla un mensaje que muestra el personaje elegido
     * @param mario recibe un objeto de tipo mortadelo en el cual esta las características de los personajes que se visualizarán
     * @param view parametro para pasarle la vista.
     */

    public void marioClicked(Mario mario, View view){

        Bundle bundle = new Bundle();

        bundle.putString("nombre", mario.getNombre());
        bundle.putInt("imagen", mario.getImagen());
        bundle.putString("descripcion", mario.getDescripcion());
        bundle.putString("habilidades", mario.getHabilidades());


        Navigation.findNavController(view).navigate(R.id.action_list_Fragment_to_personajes2, bundle);
        Toast.makeText(getApplicationContext(),getString(R.string.mensaje) + " " +bundle.getString("nombre"), Toast.LENGTH_SHORT).show();

    }

    /**
     * Configura el menú de navegación lateral (drawer) en la ActionBar.
     */
    private void configureToggleMenu() {
        // Configurar el ActionBarDrawerToggle
        toggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                R.string.abierto,
                R.string.cerrado
        );
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    /**
     * Configura la navegación dentro de la aplicación y maneja la selección de elementos en el menú.
     */

    private void configureNavigation() {
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Manejar la selección de elementos del menú
        binding.navView.setNavigationItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.nav_home) {
                navController.navigate(R.id.list_Fragment); // Navegar al fragmento de inicio
            }else if(menuItem.getItemId() == R.id.nav_ajustes){
                navController.navigate(R.id.preferencesFragment);
            }
            binding.drawerLayout.closeDrawers(); // Cerrar el menú
            return true;
        });
    }
    /**
     *Método para la gestión del botónt de retroceso.
     */

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }


}


