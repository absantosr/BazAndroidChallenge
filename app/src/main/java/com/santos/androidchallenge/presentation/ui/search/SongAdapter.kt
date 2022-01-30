package com.santos.androidchallenge.presentation.ui.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.santos.androidchallenge.databinding.ItemSongBinding
import com.santos.androidchallenge.domain.model.Song
import com.santos.androidchallenge.presentation.util.setSafeOnClickListener

class SongAdapter(val onSongSelected: ((Song) -> Unit)) :
    RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    var items: List<Song> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var itemSelected: Int = -1


    inner class SongViewHolder(
        private val binding: ItemSongBinding,
        val context: Context
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Song) {
            with(binding) {
                ivSong.load(item.album.cover)
                tvSongTitle.text = String.format(
                    "%s - %s",
                    item.artist.name,
                    item.title
                )
                clSong.setSafeOnClickListener {
                    notifyItemChanged(itemSelected)
                    itemSelected = adapterPosition
                    onSongSelected(item)
                }
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder(
            ItemSongBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), parent.context
        )
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}