package dnt.vip.foododer

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val selectedFoodList = mutableSetOf<String>()

    fun getSelectedFoodList(): List<String> {
        return selectedFoodList.toList()
    }

    fun addSelectedFood(food: String) {
        selectedFoodList.add(food)
    }

    fun removeSelectedFood(food: String) {
        selectedFoodList.remove(food)
    }
}