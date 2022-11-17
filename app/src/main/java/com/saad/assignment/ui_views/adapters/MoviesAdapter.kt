package com.saad.assignment.ui_views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saad.assignment.databinding.RvMoviesItemBinding
import com.saad.assignment.model.models.ResultsItem
import com.saad.assignment.utils.Helper

class MoviesAdapter(private val list: List<ResultsItem>) :
    RecyclerView.Adapter<MoviesAdapter.MoviesVH>() {

    //click listeners
    var onItemClick : ((ResultsItem) -> Unit)? = null

    class MoviesVH(private val binding: RvMoviesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResultsItem) {

            //setting data
            item.posterPath?.let { Helper.loadImage(binding.root.context, it, binding.imgPoster) }
            binding.tvName.text = item.title
            binding.tvReleaseDate.text = item.releaseDate

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