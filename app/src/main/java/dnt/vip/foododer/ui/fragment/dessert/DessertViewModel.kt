package dnt.vip.foododer.ui.fragment.dessert

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DessertViewModel : ViewModel() {

    private val desserts = MutableLiveData<List<String>>().apply {
        value = listOf("Tiramisu", "Cannoli", "Gelato", "Panna cotta")
    }

    fun getDesserts(): LiveData<List<String>> {
        return desserts
    }

}