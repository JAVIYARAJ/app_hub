package com.example.apphub.ui.fragment.auth

import android.app.ActionBar
import android.app.Dialog
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.apphub.R
import com.example.apphub.databinding.CustomAlertDialogBinding
import com.example.apphub.databinding.FragmentVerificationBinding

class VerificationFragment : Fragment() {

    private lateinit var binding: FragmentVerificationBinding
    private lateinit var dialogBinding: CustomAlertDialogBinding
    private lateinit var counter:CountDownTimer
    private lateinit var dialog:Dialog

    private var optValue:String=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentVerificationBinding.inflate(inflater,container,false)
        init()
        clickEvent()
        return binding.root
    }

    private fun init() {
        counter = object: CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes=(millisUntilFinished/1000)/60
                val seconds=(millisUntilFinished/1000)%60
                binding.timerTv.text = "Resend code in ${String.format("%02d:%02d", minutes, seconds)}"
            }

            override fun onFinish() {
                binding.timerTv.text="00:00"
                binding.resendTv.visibility=View.VISIBLE
            }
        }
        counter.start()
    }

    private fun clickEvent() {
        binding.verificationBackButton.setOnClickListener {
            dialogBinding=CustomAlertDialogBinding.inflate(layoutInflater)
            dialog= Dialog(requireContext())
            dialog.setContentView(dialogBinding.root)
            dialog.window?.apply {
                setLayout(ActionBar.LayoutParams.MATCH_PARENT,ActionBar.LayoutParams.WRAP_CONTENT)
            }
            dialog.show()

            dialogBinding.confirmBtn.setOnClickListener {
                dialog.dismiss()

                findNavController().navigate(R.id.action_global_loginFragment)
            }

            dialogBinding.cancelBtn.setOnClickListener {
                dialog.dismiss()
            }
        }

        binding.oneTv.setOnClickListener {
            setOtpValue("1")
        }
        binding.twoTv.setOnClickListener {
            setOtpValue("2")
        }
        binding.threeTv.setOnClickListener {
            setOtpValue("3")
        }
        binding.fourTv.setOnClickListener {
            setOtpValue("4")
        }
        binding.fiveTv.setOnClickListener {
            setOtpValue("5")
        }
        binding.sixTv.setOnClickListener {
            setOtpValue("6")
        }
        binding.sevenTv.setOnClickListener {
            setOtpValue("7")
        }
        binding.eightTv.setOnClickListener {
            setOtpValue("8")
        }
        binding.nineTv.setOnClickListener {
            setOtpValue("9")
        }
        binding.zeroTv.setOnClickListener {
            setOtpValue("0")
        }

        binding.keyboardBackImg.setOnClickListener {
            if(optValue.isNotEmpty()){
                optValue=optValue.substring(0,optValue.length-1)
                when (optValue.length) {
                    0 -> {
                        binding.otpFiledFirstTI.setText("")
                    }

                    1 -> {
                        binding.otpFiledSecondTI.setText("")
                    }

                    2 -> {
                        binding.otpFiledThirdTI.setText("")
                    }

                    3 -> {
                        binding.otpFiledFourTI.setText("")
                    }
                }
            }
        }

        binding.resendTv.setOnClickListener {
            counter.start()
            binding.resendTv.visibility=View.GONE
        }

    }

    private fun setOtpValue(value: String) {
        if (optValue.length < 4) {
            optValue += value
        }
        when (optValue.length-1) {
            0 -> {
                binding.otpFiledFirstTI.setText(value)
            }

            1 -> {
                binding.otpFiledSecondTI.setText(value)
            }

            2 -> {
                binding.otpFiledThirdTI.setText(value)
            }

            3 -> {
                binding.otpFiledFourTI.setText(value)
            }
        }
        if(optValue.length==4){
            findNavController().navigate(R.id.action_verificationFragment_to_createPasswordFragment)
        }
    }
}