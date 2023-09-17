package com.example.guideflixprojeto.ui.fragmentos.autenticacao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.guideflixprojeto.R
import com.example.guideflixprojeto.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth

        initClicks()
    }

    private fun initClicks() {
        binding.btEntrar.setOnClickListener{ validateData() }

        binding.btnCadastroLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_cadastroFragment)
        }
    }

    private fun validateData(){
        // val name = binding.txtInputLayoutNomeCadastro.text.toString().trim()
        val email = binding.editEmailLogin.text.toString().trim()
        val password = binding.editSenhaLogin.text.toString().trim()

        if (email.isNotEmpty()){
            if (password.isNotEmpty()){

                binding.progressbar.isVisible = true

                loginUser(email, password)
            } else{
                Toast.makeText(requireContext(),"Informe a senha", Toast.LENGTH_SHORT).show()
            }
        } else{
            Toast.makeText(requireContext(),"Informe o E-mail", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loginUser(email:String, password:String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    findNavController().navigate(R.id.action_loginFragment_to_appActivity)
                } else {
                    binding.progressbar.isVisible = false
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}