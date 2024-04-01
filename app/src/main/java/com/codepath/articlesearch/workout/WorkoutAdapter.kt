package com.codepath.articlesearch.workout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.codepath.articlesearch.R

class WorkoutAdapter(private val context: Context, private val listener: WorkoutClickListener):
    RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>(){

    private val todoList = ArrayList<Workout>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutAdapter.WorkoutViewHolder {
        return WorkoutViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_workout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WorkoutAdapter.WorkoutViewHolder, position: Int) {
        val item = todoList[position]
        holder.textExercise.text = item.exercise
        holder.textWeight.text = item.weightLifted.toString()
        holder.textReps.text = item.repsDone.toString()
        holder.date.text = item.creationDate

        holder.todoLayout.setOnClickListener {
            listener.onItemClicked(todoList[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    fun updateList(newList: List<Workout>){
        todoList.clear()
        todoList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class WorkoutViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val todoLayout: CardView = itemView.findViewById(R.id.card_layout)
        val textExercise: TextView = itemView.findViewById(R.id.textExercise)
        val textWeight: TextView = itemView.findViewById(R.id.textWeight)
        val textReps: TextView = itemView.findViewById(R.id.textReps)
        val date: TextView = itemView.findViewById(R.id.textDate)
    }

    interface WorkoutClickListener {
        fun onItemClicked(journal: Workout)
    }
}