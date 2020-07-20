package com.example.cepcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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


        buttonSearch.setOnClickListener {
            if(!editTextCep.text.isNullOrEmpty()){
                setupObservers(editTextCep.text.toString())
            }
        }
    }
    private fun setupObservers(cep: String) {
        viewModel.getAddress(cep).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        constLayout.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { cep -> populateTextViews(cep) }
                    }
                    Status.ERROR -> {
                        constLayout.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        Log.e("TAG", it.message.toString())
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        constLayout.visibility = View.GONE
                    }
                }
            }
        })
    }
    private fun populateTextViews(cep: Cep) {
        textViewLogradouro.text = cep.logradouro
        textViewComplemento.text = cep.complemento
        textViewLocalidade.text = cep.localidade
        textViewBairro.text = cep.bairro
        textViewUf.text = cep.uf
    }
}