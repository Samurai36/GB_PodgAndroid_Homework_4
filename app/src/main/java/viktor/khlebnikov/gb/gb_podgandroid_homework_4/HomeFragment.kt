package viktor.khlebnikov.gb.gb_podgandroid_homework_4

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import viktor.khlebnikov.gb.gb_podgandroid_homework_4.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val classesAdapter = ClassesPagerAdapter(requireContext())

        with(binding) {
            lessons.adapter = classesAdapter
        }

    }

    override fun onDetach() {
        activity?.viewModelStore?.clear()
        super.onDetach()
    }

}