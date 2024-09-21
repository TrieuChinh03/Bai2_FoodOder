package dnt.vip.foododer.ui.fragment.maincourse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dnt.vip.foododer.MainViewModel
import dnt.vip.foododer.databinding.FragmentMainCourseBinding
import dnt.vip.foododer.ui.adapter.FoodAdapter

class MainCourseFragment : Fragment() {

    private var _binding: FragmentMainCourseBinding? = null

    private val binding get() = _binding!!

    private lateinit var mainCourseViewModel : MainCourseViewModel
    private lateinit var mainViewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainCourseViewModel = ViewModelProvider(this)[MainCourseViewModel::class.java]
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        _binding = FragmentMainCourseBinding.inflate(inflater, container, false)
        val root: View = binding.root

        mainCourseViewModel.getFoodList().observe(viewLifecycleOwner) {
            val adapter = FoodAdapter(requireContext(), it)

            adapter.setSelectedFood(object : FoodAdapter.SelectedFood {
                override fun onSelectedFood(food: String, isChecked: Boolean) {
                    if (isChecked) {
                        mainViewModel.addSelectedFood(food)
                    } else {
                        mainViewModel.removeSelectedFood(food)
                    }
                }
            })

            binding.lvMainCourses.adapter = adapter
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}