package com.mainafelix.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter= TodoAdapter(mutableListOf())
        val rvToDo = findViewById<RecyclerView>(R.id.rvTodo)
        val btnAddTodo =findViewById<Button>(R.id.btnAddTodo)
        val btnDeletedoneTodo = findViewById<Button>(R.id.btnDeletedoneTodo)
        val etTodoTitle = findViewById<EditText>(R.id.etToDoTitle)
       rvToDo.adapter = todoAdapter
        rvToDo.layoutManager = LinearLayoutManager(this)
        btnAddTodo.setOnClickListener{
            val todoTitle = etTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()){
                val  todo = Todo(todoTitle)
                todoAdapter. addTodoItem(todo)
                etTodoTitle.text.clear()
            }
        }
        btnDeletedoneTodo. setOnClickListener{
            todoAdapter.deleteDone()
        }

    }
}