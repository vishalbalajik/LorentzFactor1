package com.example.android.lorentzfactor
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android.lorentzfactor.databinding.ActivityMainBinding
import kotlin.math.sqrt

lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculate.setOnClickListener {
            val velocit = binding.velocityValue.text.toString()
            val velocity=velocit.toDouble()//velocityValue is the id of inputting edit text view
            val answer = calculator(velocity)
            if(velocity<=0||velocity>=300000000){
                Toast.makeText(this,"Invalid velocity value", Toast.LENGTH_SHORT).show()
            }
            else {
                displayLorentzFactor(answer)
            }
        }
    }
}

fun calculator( velocity: Double):Double{
    val lorentzFactor:Double
    val c:Long =300000000
    lorentzFactor=(1/ sqrt(1-( (velocity*velocity)/(c*c) )))
    return lorentzFactor
}
fun displayLorentzFactor( lorentzFactor:Double){
    binding.answer.setText("γ=${lorentzFactor}")
}


