package com.example.kt_todo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kt_todo_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        todoAdapter = TodoAdaptor(mutableListOf())



        binding.rvTodoItems.adapter = todoAdapter

        binding.rvTodoItems.layoutManager = LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener{
            val todoTitle = binding.etTodoTItle.text.toString()
            if(todoTitle.isNotEmpty() ){
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                binding.etTodoTItle.text.clear()
            }
        }

        binding.btnDeleteDoneTodos.setOnClickListener{
            todoAdapter.deleteDoneTodos()
        }


    }




}