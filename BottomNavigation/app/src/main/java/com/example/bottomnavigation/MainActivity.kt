package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.NavigationMenuItemView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.MyFragment, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(FirstFragment())
        replaceFragment(SecondFragment())
        replaceFragment(ThirdFragment())


        val mOnNavigationiItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { Item ->

            when (Item.itemId) {
                R.id.action_first-> {
                    replaceFragment(FirstFragment())
                    return @mOnNavigationiItemSelectedListener true
                }
                R.id.action_second -> {
                    replaceFragment(SecondFragment())
                    return@mOnNavigationiItemSelectedListener true
                }
                R.id.action_third-> {
                    replaceFragment(ThirdFragment())
                    return@mOnNavigationiItemSelectedListener true
                }
                else -> {
                    return@mOnNavigationiItemSelectedListener false
                }

            }
        }
    }
}

    //화면 이동
    //해당 네비게이션을 선택했을 때 해당 프레그먼트로 이동한다




