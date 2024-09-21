package dnt.vip.foododer.ui.fragment.drink

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DrinkViewModel : ViewModel() {
    private val drinks = MutableLiveData<List<String>>().apply {
        value = listOf("Coca-Cola", "Pepsi", "Sprite", "Fanta")
    }

    fun getDrinks(): LiveData<List<String>> {
        return drinks
    }

}