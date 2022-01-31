package com.santos.androidchallenge.presentation.ui.lyrics

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.santos.androidchallenge.R
import com.santos.androidchallenge.core.Failure
import com.santos.androidchallenge.core.ResultType
import com.santos.androidchallenge.databinding.FragmentLyricsBinding
import com.santos.androidchallenge.domain.model.Lyrics
import com.santos.androidchallenge.presentation.util.setSafeOnClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_lyrics.*


@AndroidEntryPoint
class LyricsFragment : Fragment() {

    private lateinit var binding: FragmentLyricsBinding
    private val viewModel by viewModels<LyricsViewModel>()
    private val args: LyricsFragmentArgs by navArgs()

    private lateinit var artist: String
    private lateinit var song: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        artist = args.song.artist.name
        song = args.song.title
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLyricsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = String.format(getString(R.string.s_s), artist, song)
        viewModel.getLyrics(artist, song)
        viewModel.lyricsLiveData.observe(viewLifecycleOwner, ::renderLyricsSong)
    }

    private fun renderLyricsSong(resource: ResultType<Lyrics, Failure>) {
        when(resource) {
            is ResultType.Error -> {
                //Pending
            }
            is ResultType.Success -> {
                binding.run {
                    tvLyrics.text = resource.data.lyrics
                    btCopy.setSafeOnClickListener {
                        copyTextToClipboard()
                    }
                }
            }
        }
    }

    private fun copyTextToClipboard() {
        val textToCopy = tvLyrics.text
        val clipboardManager = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText(getString(R.string.text), textToCopy)
        clipboardManager.setPrimaryClip(clipData)
        Toast.makeText(context, getString(R.string.copied_text), Toast.LENGTH_LONG).show()
    }
}