package com.example.guideflixprojeto.ui.fragmentos
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.content.Intent
import com.example.guideflixprojeto.databinding.FragmentSeriesBinding
import com.example.guideflixprojeto.ui.fragmentos.detalhesactivity.ArcaneActivity
import com.example.guideflixprojeto.ui.fragmentos.detalhesactivity.LokiActivity
import com.example.guideflixprojeto.ui.fragmentos.detalhesactivity.TlouActivity


class SeriesFragment : Fragment() {

    private var _binding: FragmentSeriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSeriesBinding.inflate(inflater, container, false)

        binding.arcane.setOnClickListener {
            val intent = Intent(context, ArcaneActivity::class.java)
            startActivity(intent)
        }
        binding.tlou.setOnClickListener {
            val intent = Intent(context, TlouActivity::class.java)
            startActivity(intent)
        }

        binding.loki.setOnClickListener {
            val intent = Intent(context, LokiActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
