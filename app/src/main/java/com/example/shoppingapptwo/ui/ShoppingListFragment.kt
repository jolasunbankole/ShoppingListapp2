package com.example.shoppingapptwo.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoppingapptwo.R
import com.example.shoppingapptwo.adapters.ShoppingListAdapter
import com.example.shoppingapptwo.databinding.FragmentShoppingListBinding
import com.example.shoppingapptwo.model.ShoppingListData
import com.example.shoppingapptwo.sharedViewModel.SharedViewModel
import kotlin.random.Random


class ShoppingListFragment : Fragment() {


    private var _binding: FragmentShoppingListBinding? = null
    private val binding get() = _binding!!
    private val sList = basketList(100)
    private val shopAdapter = ShoppingListAdapter(sList, this)

    private val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shopping_list, container, false)
        //Initialize data.
        return binding.root

    }


    fun onClick(position: Int) {
        val clickedItem: ShoppingListData = sList[position]
        clickedItem.textView = "clicked"
        sharedViewModel.setList(position)
        sharedViewModel.groceryList.observe(viewLifecycleOwner, { setTheList ->
            setTheList.let {
                this.findNavController().navigate(R.id.action_shoppingListFragment_to_shopListFragment)

            }
        })
        shopAdapter.notifyItemChanged(position)
    }









    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            recyclerView1.layoutManager
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            shoppingListFragment = this@ShoppingListFragment
            recyclerView1.adapter = shopAdapter
        }
        // allows me to add content in my app
        binding.addItem.setOnClickListener {
            val index: Int = Random.nextInt(8)

            val newItem = ShoppingListData(
                R.drawable.shopping_cart,
                "Shopping List  $index",
            )
            sList.add(index, newItem)
            shopAdapter.notifyItemInserted(index)
        }
        // allows me to remove content in my app
        binding.removeItem.setOnClickListener {
            val index: Int = Random.nextInt(8)

            sList.removeAt(index)
            shopAdapter.notifyItemRemoved(index)
        }

    }





    // DummyList
    private fun basketList(size: Int): ArrayList<ShoppingListData> {
        val list = ArrayList<ShoppingListData>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.shopping_cart
                else -> R.drawable.shopping_cart
            }
            val item = ShoppingListData(drawable, "Shopping List $i")
            list += item
        }
        return list


    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}