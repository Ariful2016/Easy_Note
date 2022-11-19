package com.bangla.nobijider.kahini.todo_kotlin.dialogs

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerDialogFragment(val callback: (Long) -> Unit) : DialogFragment(), DatePickerDialog.OnDateSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(requireContext(),this,year,month,dayOfMonth)
    }
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val calender = Calendar.getInstance()
        calender.set(year,month,dayOfMonth)
        callback(calender.timeInMillis)
    }
}