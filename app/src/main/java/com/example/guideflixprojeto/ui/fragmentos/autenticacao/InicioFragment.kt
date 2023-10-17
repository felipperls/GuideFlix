package com.example.guideflixprojeto.ui.fragmentos.autenticacao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.guideflixprojeto.R
import com.example.guideflixprojeto.databinding.FragmentInicioBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class InicioFragment : Fragment() {

    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClicks()
    }
    private fun initClicks() {
        binding.btnlogin.setOnClickListener{
            findNavController().navigate(R.id.action_inicioFragment_to_loginFragment)
        }

        binding.btnCadastro.setOnClickListener {
            findNavController().navigate(R.id.action_inicioFragment_to_cadastroFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}