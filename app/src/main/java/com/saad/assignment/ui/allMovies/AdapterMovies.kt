package com.saad.assignment.ui.allMovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.saad.assignment.R
import com.saad.assignment.databinding.RvMoviesItemBinding
import com.saad.assignment.model.models.ResultsItem
import com.saad.assignment.utils.Helper

class AdapterMovies(private val list: List<ResultsItem>) :
    RecyclerView.Adapter<AdapterMovies.MoviesVH>() {

    //click listeners
    var onItemClick : ((ResultsItem) -> Unit)? = null

    class MoviesVH(private val binding: RvMoviesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResultsItem) {

            //setting data
            item.posterPath?.let { Helper.loadImage(binding.root.context, it, binding.imgPoster) }
            binding.tvName.text = item.title
            binding.tvReleaseDate.text = item.releaseDate

            if (item.isLiked) {
                binding.imgFav.setImageDrawable(
                    ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.ic_heart_red
                    )
                )
            } else {
                binding.imgFav.setImageDrawable(
                    ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.ic_heart_white
                    )
                )
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesVH {
        val binding =
            RvMoviesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesVH(binding)
    }

    override fun onBindViewHolder(holder: MoviesVH, position: Int) {
        val item = list[position]
        holder.bind(item)

        //click listeners
        holder.itemView.setOnClickListener { onItemClick?.invoke(item) }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}