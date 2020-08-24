package com.skh.productroomdatabase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skh.productroomdatabase.MainActivity
import com.skh.productroomdatabase.R
import com.skh.productroomdatabase.model.Product
import kotlinx.android.synthetic.main.dialog_update.view.*
import kotlinx.android.synthetic.main.item_home.view.*
import kotlinx.android.synthetic.main.item_home.view.edit_update as edit_update1

class ProductAdapter():
    RecyclerView.Adapter<ProductAdapter.HomeViewHolder>(){

        var mClickListener: ClickListener? = null

        fun setOnClickListener(clickListener: ClickListener){
            this.mClickListener = clickListener
        }
        var productList = emptyList<Product>()

        inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

            lateinit var product: Product
            init {
                itemView.setOnClickListener(this)
            }

            fun bind(product: Product) {
                this.product = product
                itemView.text1.text= product.productName
            }

            override fun onClick(p0: View?) {
                mClickListener?.onClick(product)
            }
        }
        fun updateArticle(productList: List<Product>) {
            this.productList = productList
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder{
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_home, parent, false)
            return HomeViewHolder(view)
        }

        override fun getItemCount(): Int {
            return productList.size
        }

        override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
            holder.bind(productList.get(position))
        }

        fun addProductList(productList: List<Product>){
            this.productList=productList
            notifyDataSetChanged()
        }
        interface  ClickListener{
            fun onClick(product: Product)
           // abstract fun Product(productId: String): Product
        }



}