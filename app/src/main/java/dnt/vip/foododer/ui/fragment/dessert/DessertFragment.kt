package dnt.vip.foododer.ui.fragment.dessert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dnt.vip.foododer.MainViewModel
import dnt.vip.foododer.databinding.FragmentDessertBinding
import dnt.vip.foododer.ui.adapter.FoodAdapter

class DessertFragment : Fragment() {

    private var _binding: FragmentDessertBinding? = null

    private val binding get() = _binding!!

    private lateinit var dessertViewModel : DessertViewModel
    private lateinit var mainViewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dessertViewModel = ViewModelProvider(this)[DessertViewModel::class.java]
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        _binding = FragmentDessertBinding.inflate(inflater, container, false)
        val root: View = binding.root

        dessertViewModel.getDesserts().observe(viewLifecycleOwner) {
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
            binding.lvDessert.adapter = adapter
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
