package ru.aslazarev.translator.view.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.aslazarev.translator.databinding.ItemWordBinding
import ru.aslazarev.translator.model.DataModel

class MainAdapter(
    val modelList: List<DataModel>
    ): RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder= ViewHolder(ItemWordBinding.inflate(LayoutInflater.from(parent.context), parent,false)).apply {

        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(modelList[position])
    }

    override fun getItemCount(): Int = modelList.size

    inner class ViewHolder(val vb: ItemWordBinding) : RecyclerView.ViewHolder(vb.root){
        fun bind(dataModel: DataModel) {
            val binder = ItemWordBinding.bind(itemView)

            binder.headerTextviewRecyclerItem.text = dataModel.text
            binder.descriptionTextviewRecyclerItem.text =
                dataModel.meanings?.firstOrNull()?.translation?.translation

        }

    }
}
