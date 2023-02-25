package com.example.scanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scanner.databinding.HomeFragmentBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    private val dataAdapter: DataAdapter = DataAdapter(mutableListOf())
    private val dataAdapter2: DataAdapter = DataAdapter(mutableListOf())
    private val dataAdapter3: DataAdapter = DataAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            dataAdapter.setData(
                mutableListOf(
                    ExampleData("0"),
                    ExampleData("1"),
                    ExampleData("2")
                )
            )

            dataAdapter2.setData(
                mutableListOf(
                    ExampleData("test 1"),
                    ExampleData("test 2"),
                    ExampleData("test 3")
                )
            )

            dataAdapter3.setData(
                mutableListOf(
                    ExampleData("test 1"),
                    ExampleData("test 2"),
                    ExampleData("test 3")
                )
            )

            binding.rvExample.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false)
            binding.rvExample.adapter = dataAdapter

            binding.rvExample2.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false)
            binding.rvExample2.adapter = dataAdapter2

            binding.rvExample3.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false)
            binding.rvExample3.adapter = dataAdapter3
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}