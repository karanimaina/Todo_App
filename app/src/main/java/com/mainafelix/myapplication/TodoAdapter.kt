package com.mainafelix.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    private val todo :MutableList<Todo>
) {
    class TodoViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)
}