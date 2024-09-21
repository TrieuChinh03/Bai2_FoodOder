package dnt.vip.foododer.ui.fragment.fruit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FruitViewModel : ViewModel() {

    private val fruits = MutableLiveData<List<String>>().apply {
        value = listOf("Táo", "Mận", "Xoài", "Lê")
    }

    fun getFruits(): LiveData<List<String>> {
        return fruits
    }
}