package com.technology.joe.inmobileschallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.technology.joe.inmobileschallenge.R
import kotlinx.android.synthetic.main.fragment_confirm_exit.view.*

class ConfirmExitFragment : DialogFragment() {

    private var iConfirmExit: IConfirmExit? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_confirm_exit, container, false)

        view.cancelButton.setOnClickListener {
            dialog?.dismiss()
        }

        view.confirmButton.setOnClickListener {
            iConfirmExit?.onExitBroadcastConfirmed()
            dialog?.dismiss()
        }

        return view

    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        val width = (resources.displayMetrics.widthPixels * 0.80).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.45).toInt()
        dialog?.window?.setLayout(width, height)

    }

    override fun onDestroy() {
        super.onDestroy()
        val parent = view?.parent as? ViewGroup
        parent?.removeView(view)
    }


    interface IConfirmExit {
        fun onExitBroadcastConfirmed()
    }

    fun setCallback(IConfirmExit: IConfirmExit) {
        this.iConfirmExit = IConfirmExit
    }
}
