package com.mainafelix.myapplication

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    private val todos :MutableList<Todo>
):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val cbDone: CheckBox =itemView.findViewById(R.id.cbdone)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todos,
                parent,
                false
            )
        )
    }

    private fun  toggleStrikeThrough(tvTodoTitle:TextView,isChecked:Boolean){
        if (isChecked){
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        }else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()

        }
    }
    fun addTodoItem(todo :Todo){
        todos.add(todo)
        notifyItemInserted(todos.size-1)
    }
    fun  deleteDone(){


        todos.removeAll { todo: Todo ->
            todo.isChecked
        }

        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val  currentTodo = todos[position]
   holder.apply {
   tvTitle.text = currentTodo.title
   cbDone.isChecked =currentTodo.isChecked
    toggleStrikeThrough(tvTitle ,currentTodo.isChecked)
    cbDone.setOnCheckedChangeListener{_,isChecked->
        toggleStrikeThrough(tvTitle , isChecked)
        currentTodo.isChecked = !currentTodo.isChecked
}
      }

    }

    override fun getItemCount(): Int {
      return todos.size
    }
}