package com.yblee2001.eyesee.ui.user

import android.os.Bundle
import android.provider.SettingsSlicesContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yblee2001.eyesee.databinding.FragmentUserBinding

class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 나의 게시물 화면
        binding.myPostingsCell.setOnClickListener {
            requireContext().startActivity(MyPostingsActivity.createIntent(requireContext()))
        }

        // 나의 포인트 화면
        binding.pointCell.setOnClickListener {
            requireContext().startActivity(PointsActivity.createIntent(requireContext()))
        }

        // 설정 화면
        binding.settingsCell.setOnClickListener {
            requireContext().startActivity(SettingsActivity.createIntent(requireContext()))
        }
    }
}
