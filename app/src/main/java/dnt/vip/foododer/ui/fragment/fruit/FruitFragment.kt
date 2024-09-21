package dnt.vip.foododer.ui.fragment.fruit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dnt.vip.foododer.MainViewModel
import dnt.vip.foododer.databinding.FragmentFruitBinding
import dnt.vip.foododer.ui.adapter.FoodAdapter

class FruitFragment : Fragment() {

    private var _binding: FragmentFruitBinding? = null

    private val binding get() = _binding!!

    private lateinit var fruitViewModel : FruitViewModel
    private lateinit var mainViewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fruitViewModel = ViewModelProvider(this)[FruitViewModel::class.java]
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        _binding = FragmentFruitBinding.inflate(inflater, container, false)
        val root: View = binding.root

        fruitViewModel.getFruits().observe(viewLifecycleOwner) {
            val adapter = FoodAdapter(requireContext(), it)
            adapter.setSelectedFood(object: FoodAdapter.SelectedFood {
                override fun onSelectedFood(food: String, isChecked: Boolean) {
                    if (isChecked) {
                        mainViewModel.addSelectedFood(food)
                    } else {
                        mainViewModel.removeSelectedFood(food)
                    }
                }
            })
            binding.lvFruits.adapter = adapter
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}