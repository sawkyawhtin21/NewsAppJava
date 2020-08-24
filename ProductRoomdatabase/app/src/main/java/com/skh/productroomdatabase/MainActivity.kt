package com.skh.productroomdatabase

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.skh.productroomdatabase.adapter.ProductAdapter
import com.skh.productroomdatabase.model.Product
import com.skh.productroomdatabase.viewmodel.AddProductActivity
import com.skh.productroomdatabase.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.activity_add_product.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_home.view.*

class MainActivity : AppCompatActivity(), ProductAdapter.ClickListener {
    lateinit var productAdapter: ProductAdapter
    lateinit var productViewModel: ProductViewModel
    private val addProductActivityResultCode =
        1   // get code from onActivity result request code and result code

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productViewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)
        productAdapter = ProductAdapter()

        recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = productAdapter
        }
        productViewModel.allproduct.observe(
            this, Observer { product ->
                product.let {
                    productAdapter.addProductList(product)
                }
            }
        )
        btn_add.setOnClickListener {
            var intent = Intent(this, AddProductActivity::class.java)
            //     startActivity(intent)

            startActivityForResult(intent, addProductActivityResultCode)
        }
        productAdapter.setOnClickListener(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == addProductActivityResultCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(AddProductActivity.EXTRA_REPLY)?.let {
                val product = Product(it)
                productViewModel.insert(product)

            }

        }
    }


    override fun onClick(product: Product) {
        var builder = AlertDialog.Builder(this)
        builder.apply {
            setTitle("delete item")
            setIcon(android.R.drawable.ic_dialog_alert)
            setPositiveButton("Yes") { dialogInterface, i ->
                productViewModel.deleteItem(product.productName)
            }
            setNegativeButton("No") { dialogInterface, i ->
                Toast.makeText(applicationContext, "delete cancel", Toast.LENGTH_LONG).show()
            }
            setNeutralButton("update") { dialogInterface: DialogInterface, i: Int ->
                val updateBuilder = AlertDialog.Builder(context)
                val dialogLayout = layoutInflater.inflate(
                    R.layout.dialog_update, null
                )

                updateBuilder.apply {
                    setTitle("update product")
                    setView(dialogLayout)
                    setPositiveButton("OK") { dialogInterface, i ->
                        var updateText = dialogLayout.edit_update.text.toString()
                        productViewModel.updateItem(updateText, product.productName)

                    }
                }
                val updateDialog: AlertDialog = updateBuilder.create()
                updateDialog.show()
            }


        }
        val alertDialog:AlertDialog=builder.create()
        alertDialog.show()


    }



}
