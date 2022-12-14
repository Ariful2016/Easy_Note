package com.bangla.nobijider.kahini.todo_kotlin.dialogs

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerDialogFragment(val callback : (Long)-> Unit) : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hours = calendar.get(Calendar.HOUR)
        val minite = calendar.get(Calendar.MINUTE)
        return TimePickerDialog(requireContext(),this,hours,minite,false)
    }


    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(0,0,0,hourOfDay,minute)
        callback(calendar.timeInMillis)
    }
}