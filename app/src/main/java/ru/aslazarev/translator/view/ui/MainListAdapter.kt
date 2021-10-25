package ru.aslazarev.translator.view.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.aslazarev.translator.databinding.ItemWordBinding
import ru.aslazarev.translator.model.DataModel

class MainListAdapter (
    private val itemClickListener: (DataModel) -> Unit
) : ListAdapter<DataModel, MainListAdapter.MainViewHolder>(MainCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class MainViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        ItemWordBinding.inflate(parent.inflater(), parent, false).root
    ) {

        fun bind(data: DataModel) {
            val binder = ItemWordBinding.bind(itemView)

            binder.headerTextviewRecyclerItem.text = data.text
            binder.descriptionTextviewRecyclerItem.text =
                data.meanings?.firstOrNull()?.translation?.translation

            binder.root.setOnClickListener { itemClickListener(data) }
        }
    }

    private fun ViewGroup.inflater() = LayoutInflater.from(context)
}

object MainCallback : DiffUtil.ItemCallback<DataModel>() {

    override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
        return oldItem == newItem
    }
}