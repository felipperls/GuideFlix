package com.example.guideflixprojeto.ui.fragmentos
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.guideflixprojeto.databinding.FragmentDescobrirBinding
import com.example.guideflixprojeto.ui.fragmentos.detalhesactivity.ArcaneActivity
import com.example.guideflixprojeto.ui.fragmentos.detalhesactivity.BerbieActivity
import com.example.guideflixprojeto.ui.fragmentos.detalhesactivity.LokiActivity
import com.example.guideflixprojeto.ui.fragmentos.detalhesactivity.TlouActivity
import com.example.guideflixprojeto.ui.fragmentos.detalhesactivity.TopGunActivity

class DescobrirFragment : Fragment() {

    private var _binding: FragmentDescobrirBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDescobrirBinding.inflate(inflater, container, false)

        initClicks()

        return binding.root
    }

    private fun initClicks() {

        binding.barbie.setOnClickListener {
            val intent = Intent(context, BerbieActivity::class.java)
            startActivity(intent)
        }

        binding.topgun.setOnClickListener {
            val intent = Intent(context, TopGunActivity::class.java)
            startActivity(intent)
        }

        binding.arcane.setOnClickListener {
            val intent = Intent(context, ArcaneActivity::class.java)
            startActivity(intent)
        }

        binding.loki.setOnClickListener {
            val intent = Intent(context, LokiActivity::class.java)
            startActivity(intent)
        }

        binding.tlou.setOnClickListener {
            val intent = Intent(context, TlouActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
