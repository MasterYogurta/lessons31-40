package goncharuk.lessons31_40.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class ViewHolderBaseBinding<T>(private val bindingId: Int, private val binding: ViewDataBinding, private val onClickListener: (item: T) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    var item: T? = null
        set(value) {
            field = value
            val newItem = value ?: return
            binding.setVariable(bindingId, newItem)
            binding.executePendingBindings()
        }

    init {
        binding.root.setOnClickListener { item?.let(onClickListener) }
    }
}

class AdapterBaseBinding<T>(private val bindingId: Int, private val layoutId: Int, private var itemList: List<T> = listOf(), private val onClickListener: (item: T) -> Unit) : RecyclerView.Adapter<ViewHolderBaseBinding<T>>() {

    fun updateList(update: List<T>) {
        itemList = update
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBaseBinding<T> {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(LessonApplication.context), layoutId, parent, false)
        return ViewHolderBaseBinding(bindingId, binding, onClickListener)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolderBaseBinding<T>, position: Int) {
        holder.item = itemList[position]
    }
}