package viktor.khlebnikov.gb.gb_podgandroid_homework_4

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import viktor.khlebnikov.gb.gb_podgandroid_homework_4.databinding.FragmentClassesBinding

class ClassesFragment : Fragment(R.layout.fragment_classes) {

    private val binding by lazy { FragmentClassesBinding.inflate(layoutInflater) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ClassesAdapter(requireContext())
        with(binding) {
            recyclerView.adapter = adapter
        }
    }

}