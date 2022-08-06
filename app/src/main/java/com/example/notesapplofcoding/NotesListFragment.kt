package com.example.notesapplofcoding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapplofcoding.ViewModel.NotesViewModel
import com.example.notesapplofcoding.databinding.FragmentNotesListBinding
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class NotesListFragment : Fragment(R.layout.fragment_notes_list) {
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var binding: FragmentNotesListBinding

    private val notesViewModel by inject<NotesViewModel>()//viewModel<NotesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  notesViewModel=(activity as MainActivity).viewModel

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotesListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()

        lifecycleScope.launchWhenStarted {
          notesViewModel.notes.collect{ notesList ->
              notesAdapter.diff.submitList(notesList)

          }
        }

        lifecycleScope.launchWhenStarted {
            notesViewModel.searchNotes?.collect{searchedNotes ->
                notesAdapter.diff.submitList(searchedNotes)
            }
        }

        binding.edSearch.addTextChangedListener {
            notesViewModel.searchedNotes(it.toString().trim())
        }

        binding.btnAddNote.setOnClickListener{
            findNavController().navigate(R.id.action_notesListFragment_to_noteFragment)
        }

        notesAdapter.onClick = {note ->
            val bundle=Bundle().apply {
                putParcelable("note",note)
            }
            findNavController().navigate(R.id.action_notesListFragment_to_noteFragment,bundle)

        }


    }

    private fun setupRV() {
        notesAdapter=NotesAdapter()
        binding.rvNotes.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=notesAdapter
        }
    }


}