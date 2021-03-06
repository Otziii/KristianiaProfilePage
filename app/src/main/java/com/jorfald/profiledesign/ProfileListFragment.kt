package com.jorfald.profiledesign

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class ProfileListFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: ProfileAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profiles = listOf(
            User(
                "Ola Nordmann",
                500,
                60,
                800,
                "ola@norge.no",
                "+47 909 99 909",
                R.drawable.profile_pic
            ),
            User(
                "Kari Nordmann",
                1990,
                780,
                75,
                "kari@norge.no",
                "+47 808 88 808",
                R.drawable.profile_pic2
            ),
            User(
                "Ola Nordmann 2",
                500,
                60,
                800,
                "ola@norge.no",
                "+47 909 99 909",
                R.drawable.profile_pic
            ),
            User(
                "Kari Nordmann 2",
                1990,
                780,
                75,
                "kari@norge.no",
                "+47 808 88 808",
                R.drawable.profile_pic2
            ),
            User(
                "Ola Nordmann 3",
                500,
                60,
                800,
                "ola@norge.no",
                "+47 909 99 909",
                R.drawable.profile_pic
            ),
            User(
                "Berit Nordmann",
                1990,
                780,
                75,
                "kari@norge.no",
                "+47 808 88 808",
                R.drawable.profile_pic2
            )
        )

        recyclerView = view.findViewById(R.id.recycler_view)

        layoutManager = LinearLayoutManager(activity)
//        layoutManager = GridLayoutManager(activity, 3, GridLayoutManager.VERTICAL, false)
//        layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        // Eksempel:
        val a = ProfileAdapter(
            listOf()
        ) { user ->

            // Hva skal skje n??r callback blir kalt...? Bruk user

        }



        adapter = ProfileAdapter(profiles) { user ->
            // Navigere til profilsiden

            val bundle = Bundle()
            bundle.putSerializable("user_object", user)

            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<ProfileFragment>(R.id.fragment_container, args = bundle)
                addToBackStack(null)
            }
        }

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter






        // Threads

        // Her f??r jeg ikke hente noe fra API / Nett
        // Her f??r jeg ikke hente noe fra Database
        Thread {
            // Her f??r jeg ikke hente noe fra API / Nett
            // Her f??r jeg  hente noe fra Database

            // Her f??r jeg ikke lov til ?? endre viewet

            requireActivity().runOnUiThread {
                // Her f??r jeg lov til ?? endre viewet
            }
        }.start()
    }
}