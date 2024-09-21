package dnt.vip.foododer.ui.activity.selectedfood

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dnt.vip.foododer.databinding.ActivitySelectedFoodBinding
import dnt.vip.foododer.ui.adapter.FoodAdapter

class SelectedFoodActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySelectedFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectedFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedFoodList = intent.getStringArrayListExtra("selectedFoodList")

        if (!selectedFoodList.isNullOrEmpty()) {
            val adapter = FoodAdapter(this, selectedFoodList)
            binding.lvSelectedFood.adapter = adapter
        } else {
            Toast.makeText(this, "Không có món ăn được chọn.", Toast.LENGTH_SHORT).show()
        }
    }

}