package com.example.notesapplofcoding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapplofcoding.data.Note
import com.example.notesapplofcoding.databinding.NotesItemBinding

class NotesAdapter:RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    inner class NotesViewHolder(private val binding: NotesItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note?) {
          binding.tvNoteTitle.text=note?.noteTitle
        }
    }

    private val diffCallBack= object: DiffUtil.ItemCallback<Note>(){
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.nodeId==newItem.nodeId
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem==newItem
        }

    }

    val diff=AsyncListDiffer(this,diffCallBack)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            NotesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note=diff.currentList[position]
        holder.bind(note)

        holder.itemView.setOnClickListener{
            onClick?.invoke(note)
        }
     }



    override fun getItemCount()=diff.currentList.size

    var onClick: ((Note) -> Unit)?=null



}