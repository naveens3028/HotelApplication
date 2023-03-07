package com.management.hotelapplication.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.database.FirebaseDatabase
import com.management.hotelapplication.Employee
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.databinding.FragmentHomeBinding
import com.management.hotelapplication.table.MenuModel
import io.ktor.client.*
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var homeViewModel: HomeViewModel
    val database: AppDatabase by inject()
    val ktorClient: HttpClient by inject()
    val employee: Employee by inject()
    val firebaseInstance: FirebaseDatabase by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // val textView: TextView = binding.textHome
/*
        homeViewModel.text.observe(viewLifecycleOwner) {
            //   textView.text = it
        }
*/
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      //  val myRef = firebaseInstance.getReference("Employee")

        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

        binding.button2.setOnClickListener {
            val data = MenuModel(itemName = binding.hotelname.text.toString(), price = binding.totalSeat.text.toString(),
            image = "sample", description = "hello")

            homeViewModel.saveDataToDb(data, database)
        }


        homeViewModel.myLiveData.observe(viewLifecycleOwner, Observer {
            Log.e("PoperDb", it.toString())
        })


/*
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.forEach {
                    Toast.makeText(requireContext(), it.value.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), "Cancelled", Toast.LENGTH_SHORT).show()
            }

        })
*/
    }

/*
    private fun postDataToFireBase(myRef: DatabaseReference) {
        val id = myRef.push().key

        id?.let {
            myRef.child(it).setValue(binding.totalSeat.text.toString()).addOnCompleteListener {
                Toast.makeText(requireContext(), "Added", Toast.LENGTH_SHORT).show()
            }
        }

    }
*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}