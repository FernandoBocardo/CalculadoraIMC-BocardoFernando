package bocardo.fernando.asignacion4_calculadoraimc_bocardo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Listener
        val peso: EditText = findViewById(R.id.weight) as EditText
        val btnCalcular: Button = findViewById(R.id.btnCalcular) as Button

        btnCalcular.setOnClickListener { calcular() }
    }

    fun calcular()
    {
        val peso: EditText = findViewById(R.id.weight) as EditText
        val estatura: EditText = findViewById(R.id.height) as EditText
        val tvRange: TextView = findViewById(R.id.range) as TextView

        if (peso.text.toString().isBlank() || estatura.text.toString().isBlank())
        {
            return
        }

        val pesoDouble = peso.text.toString().toDouble()
        val estaturaDouble = estatura.text.toString().toDouble()

        val imc = pesoDouble/(estaturaDouble*estaturaDouble)


        when
        {
            imc < 18.5 ->
            {
                tvRange.text = "Bajo peso"
                tvRange.setBackgroundResource(R.color.colorGreenish)
            }
            imc in 18.5..24.9 ->
            {
                tvRange.text = "Normal"
                tvRange.setBackgroundResource(R.color.colorGreen)
            }
            imc in 25.0..29.9 ->
            {
                tvRange.text = "Sobrepeso"
                tvRange.setBackgroundResource(R.color.colorYellow)
            }
            imc in 30.0..34.9 ->
            {
                tvRange.text = "Obesidad grado 1"
                tvRange.setBackgroundResource(R.color.colorOrange)
            }
            imc in 35.0..39.9 ->
            {
                tvRange.text = "Obesidad grado 2"
                tvRange.setBackgroundResource(R.color.colorRed)
            }
            imc >= 40.0 ->
            {
                tvRange.text = "Obesidad grado 3"
                tvRange.setBackgroundResource(R.color.colorBrown)
            }
        }

        findViewById<TextView>(R.id.imc).setText(imc.toString())
    }
}