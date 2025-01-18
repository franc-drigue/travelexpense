package com.example.gastoviagem

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View Binding
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.buttonCalculate.setOnClickListener {
            if (isValid()) {
                var distance = binding.editDistance.text.toString().toFloat();

                var price = binding.editPrice.text.toString().toFloat();

                var autonomy = binding.editAutonomy.text.toString().toFloat();

                var total = (distance * price) / autonomy
                var totalStr = "R$ ${"%.2f".format(total)}"

                binding.totalValue.text = totalStr
            }else {
                Toast.makeText(this, R.string.fill_in_all_fields, Toast.LENGTH_SHORT).show()
            }
        }
    }

    //Função para validar se os campos são deferentes de vazios e zero
    private fun isValid(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f
                )
    }
}