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

class MainActivity : ComponentActivity() {
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
        val btnMod: Button = findViewById(R.id.percent)

        val btn1: Button = findViewById(R.id.one)
        val btn2: Button = findViewById(R.id.two)
        val btn3: Button = findViewById(R.id.three)
        val btn4: Button = findViewById(R.id.four)
        val btn5: Button = findViewById(R.id.five)
        val btn6: Button = findViewById(R.id.six)
        val btn7: Button = findViewById(R.id.seven)
        val btn8: Button = findViewById(R.id.eight)
        val btn9: Button = findViewById(R.id.nine)
        val btn0: Button = findViewById(R.id.zero)


        val etProceso: EditText =findViewById(R.id.res)
        var etconcatenar: EditText
        var numero1:Double = 0.0
        var numero2:Double = 0.0
        var result: Double = 0.0
        var operador: String = ""
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