package io.sh4.uj_puma_2021

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import io.sh4.uj_puma_2021.services.AuthService

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
    ): View? {
        val v = inflater.inflate(R.layout.fragment_register, container, false)
        val context = (activity as MainActivity)

        val loginTextView : TextView = v.findViewById(R.id.loginTextView)
        val btnRegister : Button = v.findViewById(R.id.registerButton)

        context.setTitle("Register")

        btnRegister.setOnClickListener {
            register(v)
        }

        loginTextView.setOnClickListener {
            context.replaceFragment(LoginFragment(), false)
        }
        return v
    }

    fun register(view : View) {
        var email = getView()?.findViewById<TextView>(R.id.editTextEmail).toString()
        var password = getView()?.findViewById<TextView>(R.id.editTextPassword).toString()
        var passwordRepeat = getView()?.findViewById<TextView>(R.id.editTextPasswordRepeat).toString()
        if (password.equals(passwordRepeat) && AuthService.register(email, password)) {
            (activity as MainActivity).changeActivityToShop(view)
        } else {

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}