package dnt.vip.foododer.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import dnt.vip.foododer.R

class FoodAdapter(
    private val context: Context,
    private val foods: List<String>
) : BaseAdapter() {

    interface SelectedFood {
        fun onSelectedFood(food: String, isChecked: Boolean)
    }

    private var selectedFood: SelectedFood? = null

    fun setSelectedFood(selectedFood: SelectedFood) {
        this.selectedFood = selectedFood
    }

    override fun getCount(): Int {
        return foods.size
    }

    override fun getItem(p0: Int): Any {
        return foods[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var rowView = p1
        if (rowView == null) {
            val inflater = LayoutInflater.from(context)
            rowView = inflater.inflate(R.layout.item_food, p2, false)
        }


        val checkBox = rowView!!.findViewById<CheckBox>(R.id.cbItemFood)

        checkBox.text = foods[p0]

        checkBox.isChecked = false

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            selectedFood?.onSelectedFood(foods[p0], isChecked)
        }

        return rowView
    }
}