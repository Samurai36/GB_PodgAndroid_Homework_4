package viktor.khlebnikov.gb.gb_podgandroid_homework_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import viktor.khlebnikov.gb.gb_podgandroid_homework_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val homeFragment = HomeFragment()
    private val classesFragment = ClassesFragment()
    private var previousFragment: Fragment = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragments_container, homeFragment)
            .add(R.id.fragments_container, classesFragment).hide(classesFragment).commit()
        with(binding) {
            bottomNavigation.addBubbleListener { id ->
                if (id == R.id.home_fragment) {
                    openFragment(homeFragment)
                }
                if (id == R.id.classes_fragment) {
                    openFragment(classesFragment)
                }
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        if (previousFragment == fragment) return
        supportFragmentManager.beginTransaction()
            .hide(previousFragment).show(fragment)
            .commit()
        previousFragment = fragment
    }

}