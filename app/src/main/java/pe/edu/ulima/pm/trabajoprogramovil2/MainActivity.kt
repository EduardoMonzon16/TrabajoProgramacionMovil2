package pe.edu.ulima.pm.trabajoprogramovil2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import pe.edu.ulima.pm.trabajoprogramovil2.fragments.CarteleraFragments
import pe.edu.ulima.pm.trabajoprogramovil2.fragments.SobreNosotrosFragments

class MainActivity : AppCompatActivity() {
    private lateinit var mDlaMain : DrawerLayout
    private lateinit var mNvMain : NavigationView
    private lateinit var mToolbar : Toolbar

    private val fragmentCartelera = CarteleraFragments()
    private val fragmentSobreNosotros = SobreNosotrosFragments()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDlaMain = findViewById(R.id.dlaMain)
        mNvMain = findViewById(R.id.nviMain)
        mToolbar = findViewById(R.id.toolbar)

        //setSupportActionBar(mToolbar)

        mNvMain.setNavigationItemSelectedListener {
            it.setChecked(true)

            val ft = supportFragmentManager.beginTransaction()

            when(it.itemId) {
                /*  */
                R.id.menCartelera -> MostrarFragmentCartelera(ft)
                R.id.menSobreNosotros -> MostrarFragmentSobreNosotros(ft)
            }
            ft.addToBackStack(null)

            ft.commit()

            mDlaMain.closeDrawers()
            true
        }

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fcvSecciones, fragmentCartelera)
        ft.commit()

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    private fun MostrarFragmentSobreNosotros(ft : FragmentTransaction) {
        ft.replace(R.id.fcvSecciones, fragmentSobreNosotros)
    }

    private fun MostrarFragmentCartelera(ft : FragmentTransaction) {
        ft.replace(R.id.fcvSecciones, fragmentCartelera)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cartelera, menu)
        return true
    }

    /* override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if(item.itemId == R.id.men_ir_registro) {
        val intent = Intent(this, RegistroActivity::class.java)
        startActivity(intent)
    } */
}
