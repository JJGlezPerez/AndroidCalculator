package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadora.ui.theme.CalculadoraTheme
import java.util.Arrays

class MainActivity : ComponentActivity() {
    var operador:String =""
    var numero1: Double = 0.0
    var numero2: Double = 0.0
    var resultado: Double = 0.0
    lateinit var etProceso: EditText
    var onDisplayChangue:Boolean=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)

        val btnSuma: Button = findViewById(R.id.plus)
        val btnRest: Button = findViewById(R.id.minus)
        val btnMult: Button = findViewById(R.id.mult)
        val btnDiv: Button = findViewById(R.id.div)
        val btnResult: Button = findViewById(R.id.equal)
        val btnClear: Button = findViewById(R.id.clear)
        val btnDot: Button = findViewById(R.id.dot)
        val btnPercent: Button = findViewById(R.id.percent)
        val btnMod:Button = findViewById(R.id.mod)
        val btnchange:Button = findViewById(R.id.changer)

        this.etProceso=findViewById(R.id.res)


        var listButtons:List<Button> = Arrays.asList<Button>(
            findViewById(R.id.zero_0),
            findViewById(R.id.one_1),
            findViewById(R.id.two_2),
            findViewById(R.id.three_3),
            findViewById(R.id.four_4),
            findViewById(R.id.five_5),
            findViewById(R.id.six_6),
            findViewById(R.id.seven_7),
            findViewById(R.id.eight_8),
            findViewById(R.id.nine_9)
        )

        onClicOperator("+",btnSuma)
        onClicOperator("-",btnRest)
        onClicOperator("/",btnDiv)
        onClicOperator("*",btnMult)
        //onClicOperator("%",btnPercent)
        onClicOperator("mod",btnMod)


        listButtons.forEach{button->
            button.setOnClickListener{
                var buttonId = resources.getResourceName(button.id)
                var num = buttonId.split('_')[1]
                if(this.onDisplayChangue){
                    etProceso.setText(num)
                    this.onDisplayChangue=false

                }else{
                    etProceso.setText(etProceso.text.toString()+num)
                }

            }

        }

        btnchange.setOnClickListener{
            var displayText = this.etProceso.text.toString()
            var n = displayText.toDouble()
            n *=-1.0
            this.etProceso.setText(n.toString())
        }

        btnPercent.setOnClickListener {
            var displayText = this.etProceso.text.toString()
            var n = displayText.toDouble()

            if (this.operador == "") {
                n /= 100
                this.etProceso.setText(n.toString())
                this.onDisplayChangue = true
            } else {
                this.numero2 = n
                this.numero2 = (this.numero1 * this.numero2)/100
            }
        }

        btnDot.setOnClickListener{
            var displayText = this.etProceso.text.toString()
            if(!displayText.contains('.')){
                this.etProceso.setText(this.etProceso.text.toString()+".");
            }
        }

        btnResult.setOnClickListener{
            if(this.operador!="" || this.operador!="%"){
                this.numero2=this.etProceso.text.toString().toDouble()
                this.numero1=calcular(this.operador)
            }
            this.etProceso.setText(this.numero1.toString())
            this.onDisplayChangue=true
        }

        btnClear.setOnClickListener{
            etProceso.setText("0")
            this.numero1=0.0
            this.numero2=0.0
            this.operador=""
            this.onDisplayChangue=true
        }



    }
    fun onClicOperator(operator:String,btn:Button){
        btn.setOnClickListener {
            if(this.operador!="" && !this.onDisplayChangue){
                this.numero2=this.etProceso.text.toString().toDouble()
                this.numero1=calcular(this.operador)
                this.operador=operator

            }else{
                this.operador = operator
                this.numero1 = this.etProceso.text.toString().toDouble();

            }
            this.etProceso.setText(this.numero1.toString())
            this.onDisplayChangue=true

        }
    }

    fun calcular(operator: String):Double{
        println(operator)
        return when(operator){
            "+" -> this.numero1 + this.numero2
            "-" -> this.numero1 - this.numero2
            "*" -> this.numero1 * this.numero2
            "/" -> {
                if (this.numero2 != 0.0) {
                    this.numero1 / this.numero2
                } else {
                    throw IllegalArgumentException("Infinito")
                }

            }
            "mod" -> this.numero1 % this.numero2
            //"%" -> this.numero1 * (this.numero2 / 100) // Calcula el porcentaje del primer número
            else -> throw IllegalArgumentException("Operador no soportado")
        }
    }



}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculadoraTheme {
        Greeting("Android")
    }
}