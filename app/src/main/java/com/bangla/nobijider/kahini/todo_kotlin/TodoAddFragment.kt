package com.bangla.nobijider.kahini.todo_kotlin

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.bangla.nobijider.kahini.todo_kotlin.databinding.FragmentTodoAddBinding
import com.bangla.nobijider.kahini.todo_kotlin.db.TodoDatabase
import com.bangla.nobijider.kahini.todo_kotlin.dialogs.DatePickerDialogFragment
import com.bangla.nobijider.kahini.todo_kotlin.dialogs.TimePickerDialogFragment
import com.bangla.nobijider.kahini.todo_kotlin.entities.TodoModel
import com.bangla.nobijider.kahini.todo_kotlin.viewModels.TodoViewModel

class TodoAddFragment : Fragment() {
    //private val TAG = TodoAddFragment::class.java.canonicalName
    lateinit var binding: FragmentTodoAddBinding
    var priority = priority_normal
    var dateInMillis = System.currentTimeMillis()
    var timeInMillis = System.currentTimeMillis()

    lateinit var todoViewModel: TodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTodoAddBinding.inflate(inflater)

        todoViewModel = ViewModelProvider(requireActivity()).get(TodoViewModel::class.java)

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->

            var rb : RadioButton = group.findViewById(checkedId)
            priority = rb.text.toString()
            Toast.makeText(context,""+priority, Toast.LENGTH_LONG).show()

        }

        binding.date.setOnClickListener {
            DatePickerDialogFragment {
                dateInMillis = it
                binding.date.text = getFormattedDateTime(it,"dd/MM/yyyy")
            }.show(childFragmentManager,"Date_Picker")
        }

        binding.time.setOnClickListener {
            TimePickerDialogFragment{
                timeInMillis = it
                binding.time.text = getFormattedDateTime(it,"HH:mm a")
            }.show(childFragmentManager,"Time_Picker")
        }

        binding.submitBtn.setOnClickListener {
            val todo_txt = binding.editTxt.text.toString()
            if (todo_txt.equals("")){
                //checkEmptyfield("You should write something!")
                binding.editTxt.setError("Field can't be empty!")
            }

            val todo = TodoModel(name = todo_txt,priority = priority, date = dateInMillis, time = timeInMillis)
            Log.i("TAG", ""+todo.toString() )

            todoViewModel.insertTodo(todo)

            findNavController().navigate(R.id.action_todoAddFragment_to_todoHomeFragment)



        }


        return binding.root


    }

    private fun checkEmptyfield(s: String) {


        val builder = AlertDialog.Builder(requireContext())
        builder.setMessage(s)
        builder.setIcon(R.drawable.ic_baseline_cancel_24)

        //performing positive action
        builder.setPositiveButton("Ok"){dialogInterface, which ->

        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()

    }


}