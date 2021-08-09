package com.example.onboarding_demo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onboarding_demo.databinding.ItemRecyclerviewBinding
import com.example.onboarding_demo.databinding.ItemRecyclerviewLongBinding

class RecyclerviewAdapter(
    private val context: Context,
    private val data: ArrayList<Item>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class RecyclerViewHolder(
        binding: ItemRecyclerviewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val title: TextView = binding.title
        private val image: ImageView = binding.image
        private val container: LinearLayout = binding.container

        fun bind(item: Item) {

            title.text = item.name
            image.setImageDrawable(context.getDrawable(item.id))

            container.setOnClickListener {

                onClick(item.name)
            }
        }
    }

    inner class RecyclerViewHolderLong(
        binding: ItemRecyclerviewLongBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val title: TextView = binding.title
        private val image: ImageView = binding.image
        private val container: LinearLayout = binding.container

        fun bind(item: Item) {

            title.text = item.name
            image.setImageDrawable(context.getDrawable(item.id))

            container.setOnClickListener {

                onClick(item.name)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == 0) {

            val binding = ItemRecyclerviewLongBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            return RecyclerViewHolderLong(binding)

        } else {

            val binding = ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            return RecyclerViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == 1) {
            val item = data[position]
            (holder as RecyclerViewHolder).bind(item)
        } else {
            val item = data[position]
            (holder as RecyclerViewHolderLong).bind(item)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {

        return if (data[position].name == "Feed") {
            0
        } else 1
    }
}