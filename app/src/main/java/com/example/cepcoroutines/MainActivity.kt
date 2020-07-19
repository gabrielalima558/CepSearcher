package com.example.cepcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cepcoroutines.model.Cep
import com.example.cepcoroutines.utils.Status
import com.example.cepcoroutines.viewmodel.CepViewModel
import com.example.cepcoroutines.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel: CepViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory).get(CepViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupObservers()

    }
    private fun setupObservers() {
        viewModel.getAddress("06086070").observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
//                        recyclerView.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
                        resource.data?.let { cep -> retrieveList(cep) }
                    }
                    Status.ERROR -> {
//                        recyclerView.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        Log.e("TAG", it.message.toString())
                    }
                    Status.LOADING -> {
//                        progressBar.visibility = View.VISIBLE
//                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }
    private fun retrieveList(cep: Cep) {
//        adapter.apply {
//            addUsers(users)
//            notifyDataSetChanged()
//        }
        Toast.makeText(this, cep.bairro, Toast.LENGTH_LONG).show()
        txt.text


    }
}