package com.example.kt_todo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kt_todo_app.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)






        rvTodoItems.layoutManager = LinearLayoutManager(this)


        todoAdapter = TodoAdaptor(mutableListOf())


        rvTodoItems.adapter = todoAdapter



        btnAddTodo.setOnClickListener{
            val todoTitle = etTodoTItle.text.toString()
            if(todoTitle.isNotEmpty() ){
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTItle.text.clear()
            }
        }

        btnDeleteDoneTodos.setOnClickListener{
            todoAdapter.deleteDoneTodos()
        }


    }




}