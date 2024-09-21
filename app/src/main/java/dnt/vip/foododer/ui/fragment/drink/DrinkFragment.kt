package dnt.vip.foododer.ui.fragment.drink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dnt.vip.foododer.MainViewModel
import dnt.vip.foododer.databinding.FragmentDrinkBinding
import dnt.vip.foododer.ui.adapter.FoodAdapter

class DrinkFragment : Fragment() {

    private var _binding: FragmentDrinkBinding? = null

    private val binding get() = _binding!!

    private lateinit var drinkViewModel : DrinkViewModel
    private lateinit var mainViewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        drinkViewModel = ViewModelProvider(this)[DrinkViewModel::class.java]
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        _binding = FragmentDrinkBinding.inflate(inflater, container, false)
        val root: View = binding.root

        drinkViewModel.getDrinks().observe(viewLifecycleOwner) {
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
            binding.lvDrink.adapter = adapter
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}