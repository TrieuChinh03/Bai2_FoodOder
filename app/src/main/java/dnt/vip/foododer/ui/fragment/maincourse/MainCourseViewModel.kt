package dnt.vip.foododer.ui.fragment.maincourse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainCourseViewModel : ViewModel() {

    private val mainCourses = MutableLiveData<List<String>>().apply {
        value = listOf("Pizza", "Burger", "Sushi", "Salad")
    }

    fun getFoodList(): LiveData<List<String>> {
        return mainCourses
    }

}