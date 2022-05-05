package com.mainafelix.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    private val todos :MutableList<Todo>
):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
    return  TodoViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_todos,
            parent,
            false
        )
    )
    }
    private fun  toggleStrikeThrough(tvTodoTitle:TextView,isChecked:Boolean){
        if (isChecked){
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags
        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val  currentTodo = todos[position]
      holder.itemView.apply {
          tvTitle.text= currentTodo.title
          cbDone.isChecked = currentTodo.isChecked

      }

    }

    override fun getItemCount(): Int {
      return todos.size
    }
}