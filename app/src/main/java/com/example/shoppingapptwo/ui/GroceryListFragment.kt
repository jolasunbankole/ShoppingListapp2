package com.example.shoppingapptwo.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.shoppingapptwo.R
import com.example.shoppingapptwo.databinding.FragmentGroceryListBinding
import com.example.shoppingapptwo.model.GroceryListData
import com.example.shoppingapptwo.sharedViewModel.SharedViewModel
import java.util.*
import kotlin.collections.ArrayList

class GroceryListFragment : Fragment() {
    private var _binding: FragmentGroceryListBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var groceryList: GroceryListData
    lateinit var listing: ArrayList<String>
    private var listIndex = 0


    private var theList = arrayListOf(
        GroceryListData(
            "",
            arrayListOf(
                "Bread",
                "Eggs",
                "Milk",
                "Butter",
                "Frozen Chips",
                "Frozen Pizza",
                "Tea Bags",
                "Sugar",
                "Salt",
                "Sauces",
                "Bottle of Water",
                "Pasta",
                "Cheese",
                "Fruits",
                "Onions",
                "Honey",
                "Vegetables",
                "Salmon",
                "Cooking Oil",

                )
        ),
    )

    private fun setShoppingList() {
        sharedViewModel.groceryList.value
        groceryList = theList[listIndex]
        listing = ArrayList(groceryList.ActualList)
        Log.d(
            "AnswerL",
            listing[0] + " " + listing[1] + " " + listing[2] + " " + listing[3] + " " + listing[4] + " " + listing[5] + " " + listing[6]
                    + " " + listing[7] + " " + listing[8] + " " + listing[9] + " " + listing[10]
        )


    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_grocery_list, container, false)


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModels = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            shopList = this@GroceryListFragment
            check = this@GroceryListFragment
            setShoppingList()


        }





    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}