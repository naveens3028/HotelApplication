package com.management.hotelapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.management.hotelapplication.Employee
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.databinding.FragmentHomeBinding
import io.ktor.client.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModel()
    val database : AppDatabase by inject()
    val ktorClient : HttpClient by inject()
    val employee : Employee by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.addDatasToDb(database, ktorClient)
        employee.demo()
        employee.sample()
        println(database.menuDao().getData())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}