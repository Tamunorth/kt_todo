package com.example.kt_todo_app

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kt_todo_app.databinding.ItemTodoBinding
import kotlinx.android.synthetic.main.item_todo.view.*


class TodoAdaptor (
    private val todos: MutableList<Todo>) :RecyclerView.Adapter<TodoAdaptor.TodoViewHolder>() {




    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

//    private lateinit var binding: ItemTodoBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {


//        val  inflaterView =   LayoutInflater.from(parent.context).inflate(
//            R.layout.item_todo,
//            parent,
//            false
//        )
//
//        binding = ItemTodoBinding.bind(inflaterView)

            return  TodoViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_todo,
                    parent,
                    false
                )

            )


    }


    fun addTodo (todo:Todo){
        todos.add(todo);
        notifyItemInserted(todos.size -1)

    }

   fun  deleteDoneTodos() {
       todos.removeAll{ todo -> todo.isChecked }
       notifyDataSetChanged()
    }

    private  fun  toggleStrike (tvTodoTitle: TextView, isChecked: Boolean){

        if(isChecked) {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        }else{

            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()

        }

    }





    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        val currentTodo = todos[position]
        holder.itemView.apply {
            tvTodoTitle.text = currentTodo.title
            cbDone.isChecked = currentTodo.isChecked

            toggleStrike( tvTodoTitle,currentTodo.isChecked)

            cbDone.setOnCheckedChangeListener{_, isChecked ->

                toggleStrike( tvTodoTitle, isChecked)
                currentTodo.isChecked = !currentTodo.isChecked
            }
      }

    }

    override fun getItemCount(): Int {
return  todos.size
    }
}