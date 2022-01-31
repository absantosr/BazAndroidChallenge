package com.santos.androidchallenge.presentation.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.santos.androidchallenge.R
import com.santos.androidchallenge.core.Failure
import com.santos.androidchallenge.core.ResultType
import com.santos.androidchallenge.databinding.FragmentSearchBinding
import com.santos.androidchallenge.domain.model.Song
import com.santos.androidchallenge.domain.model.Summary
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel by viewModels<SearchViewModel>()

    private val songAdapter by lazy {
        SongAdapter(::onSongSelected)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.title_app)
        configureRecyclerView()
        viewModel.songLiveData.observe(viewLifecycleOwner, ::renderFetchSong)

        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if (p0 != null) {
                    viewModel.onTextChange(p0)
                }
                return false
            }

        })
    }

    private fun renderFetchSong(resource: ResultType<Summary, Failure>) {
        when (resource) {
            is ResultType.Error -> {
                //Pending
            }
            is ResultType.Success -> {
                binding.run {
                    songAdapter.items = resource.data.data
                }
            }
        }
    }

    private fun configureRecyclerView() {
        binding.rvSong.run {
            setHasFixedSize(true)
            adapter = songAdapter
        }
    }

    private fun onSongSelected(song: Song) {
        findNavController().navigate(
            SearchFragmentDirections.actionSearchFragmentToLyricsFragment(song)
        )
    }
}