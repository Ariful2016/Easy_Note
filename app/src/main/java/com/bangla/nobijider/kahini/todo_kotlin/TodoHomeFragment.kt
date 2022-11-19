package com.bangla.nobijider.kahini.todo_kotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bangla.nobijider.kahini.todo_kotlin.adapters.TodoAdapter
import com.bangla.nobijider.kahini.todo_kotlin.databinding.FragmentTodoHomeBinding

import com.bangla.nobijider.kahini.todo_kotlin.viewModels.TodoViewModel

class TodoHomeFragment : Fragment() {


    lateinit var binding : FragmentTodoHomeBinding
    private lateinit var todoViewModel: TodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTodoHomeBinding.inflate(inflater)

        todoViewModel = ViewModelProvider(requireActivity()).get(TodoViewModel::class.java)

        //val todoList = todoViewModel.getTodos()
        //Log.i("TAG", "onCreateView: "+todoList.size)
        val adapter = TodoAdapter()
        binding.recycler.adapter = adapter
        todoViewModel.getTodos().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }




        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_todoHomeFragment_to_todoAddFragment)
        }

        return binding.root
    }


}