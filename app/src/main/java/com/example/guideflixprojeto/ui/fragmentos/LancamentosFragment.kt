package com.example.guideflixprojeto.ui.fragmentos

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.guideflixprojeto.R
import com.example.guideflixprojeto.databinding.FragmentLancamentosBinding

class LancamentosFragment : Fragment() {

    private var _binding: FragmentLancamentosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLancamentosBinding.inflate(inflater, container, false)

        initClicks()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initClicks() {
        binding.notificacaojack.setOnClickListener {
            createNotification("O Estranho mundo de Jack", "O filme que você esperava estreou")
        }

        binding.notificacaoflores.setOnClickListener {
            createNotification("Assassino da lua das Flores", "Não perca a estreia!")
        }
    }

    private fun createNotification(title: String, content: String) {
        val channelId = "my_channel_id"
        val notificationManager: NotificationManagerCompat = NotificationManagerCompat.from(requireContext())

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "Nome do Canal", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }


        val permission = Manifest.permission.VIBRATE
        if (ContextCompat.checkSelfPermission(requireContext(), permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(permission), 0)
        } else {
            val builder = NotificationCompat.Builder(requireContext(), channelId)
                .setSmallIcon(R.drawable.app_image)
                .setContentTitle(title)
                .setContentText(content)

            val notification: Notification = builder.build()

            notificationManager.notify(0, notification)
        }
    }
}
