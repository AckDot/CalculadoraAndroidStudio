package com.example.myappp3432

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        variablesyconstantes()

    }

    private fun variablesyconstantes() {

        val uno = findViewById<Button>(R.id.btn1)
        val dos = findViewById<Button>(R.id.btn2)
        val tres = findViewById<Button>(R.id.btn3)
        val cuatro = findViewById<Button>(R.id.btn4)
        val cinco = findViewById<Button>(R.id.btn5)
        val seis = findViewById<Button>(R.id.btn6)
        val siete = findViewById<Button>(R.id.btn7)
        val ocho = findViewById<Button>(R.id.btn8)
        val nueve = findViewById<Button>(R.id.btn9)
        val cero = findViewById<Button>(R.id.btn0)
        val coma = findViewById<Button>(R.id.btnPunto)
        val del = findViewById<Button>(R.id.btnDel)
        val suma = findViewById<Button>(R.id.btnMas)
        val resta = findViewById<Button>(R.id.btnMenos)
        val multiplicacion = findViewById<Button>(R.id.btnMultiplicacion)
        val division = findViewById<Button>(R.id.btnDiv)
        val igual = findViewById<Button>(R.id.btnigual)
        val ed = findViewById<EditText>(R.id.etOperaciones)
        var res = findViewById<TextView>(R.id.resultado)
        var obtTexto: String
        var num1:Double = 0.0
        var num2: Double
        var sign:Char = ' '

        cero.setOnClickListener {
            obtTexto = ed.getText().toString()
            ed.setText(obtTexto+"0")
        }
        uno.setOnClickListener{
            obtTexto = ed.getText().toString()
            ed.setText(obtTexto+"1")
        }
        dos.setOnClickListener{
            obtTexto = ed.getText().toString()
            ed.setText(obtTexto+"2")
        }
        tres.setOnClickListener {
            obtTexto = ed.getText().toString()
            ed.setText(obtTexto+"3")
        }
        cuatro.setOnClickListener{
            obtTexto = ed.getText().toString()
            ed.setText(obtTexto+"4")
        }
        cinco.setOnClickListener{
            obtTexto = ed.getText().toString()
            ed.setText(obtTexto+"5")
        }
        seis.setOnClickListener{
            obtTexto = ed.getText().toString()
            ed.setText(obtTexto+"6")
        }
        siete.setOnClickListener{
            obtTexto = ed.getText().toString()
            ed.setText(obtTexto+"7")
        }
        ocho.setOnClickListener{
            obtTexto = ed.getText().toString()
            ed.setText(obtTexto+"8")
        }
        nueve.setOnClickListener{
            obtTexto = ed.getText().toString()
            ed.setText(obtTexto+"9")
        }
        del.setOnClickListener {
            //obtTexto = ed.getText().toString()
            /*if(obtTexto != ""){
                ed.setText(obtTexto.substring(0,obtTexto.length -1))
            }*/
            num1 =0.0
            num2=0.0
            sign=' '
            ed.setText("")
            res.setText("")
        }
        coma.setOnClickListener{
            obtTexto = ed.getText().toString()
            //verificar que la coma que se creara no estara al vacio ni habra repetido
            ed.setText(obtTexto+".")
        }
        suma.setOnClickListener {
            obtTexto = ed.getText().toString()
            if(!obtTexto.equals("") ){ //verificar que el eT no este vacio
                //Verificar que el eT este con una operacion definida
                if(BuscarSigno(obtTexto,sign)){
                 num1 = res.getText().toString().toDouble()
                    ed.setText("ans")
                }else{ //si no tiene una operacion
                num1 = obtTexto.toDouble()
                sign = '+'
                ed.setText("")
                }
            }

        }
        resta.setOnClickListener {
            obtTexto = ed.getText().toString()
            if(!obtTexto.equals("") ){ //verificar que el eT no este vacio
                //Verificar que el eT este con una operacion definida
                if(BuscarSigno(obtTexto,sign)){
                    num1 = res.getText().toString().toDouble()
                    ed.setText("")
                    sign = '-'
                }else{ //si no tiene una operacion
                    num1 = obtTexto.toDouble()
                    sign = '-'
                    ed.setText("")
                }
            }
        }
        multiplicacion.setOnClickListener {
            obtTexto = ed.getText().toString()
            if(!obtTexto.equals("") ){ //verificar que el eT no este vacio

                if(BuscarSigno(obtTexto,sign)){//Verificar que el eT este con una operacion definida
                    num1 = res.getText().toString().toDouble()
                    ed.setText("")
                    sign = '*'
                }else{ //si no tiene una operacion
                    num1 = obtTexto.toDouble()
                    sign = '*'
                    ed.setText("")
                }
            }
        }
        division.setOnClickListener {
            obtTexto = ed.getText().toString()
            if(!obtTexto.equals("") ){ //verificamos que no este vacio
                if(BuscarSigno(obtTexto,sign)){
                    num1 = res.getText().toString().toDouble()
                    ed.setText("")
                    sign = '/'
                }else{ //si no tiene una operacion
                    num1 = obtTexto.toDouble()
                    sign = '/'
                    ed.setText("")
                }
            }
        }

        igual.setOnClickListener {
            //casos del igual , cuando se tiene un signo
            obtTexto = ed.getText().toString()
            if(!obtTexto.equals("") && !sign.equals(' ')){// si no tenemos el obtTexto vacio y si el signo esta definido entramos
                num2 = obtTexto.toDouble()
                if(obtTexto.toDouble()==num1){
                    res.setText(num1.toString())
                }
                if(sign =='+'){
                    var resultadeishon:Double? = num1 +num2?:0.0
                    res.setText(resultadeishon.toString())
                    ed.setText("$num1$sign$num2")
                }
                if(sign =='-'){
                    var resultadeishon:Double? = num1 -num2?:0.0
                    res.setText(resultadeishon.toString())
                    ed.setText("$num1$sign$num2")
                }
                if(sign =='*'){
                    var resultadeishon:Double? = num1 *num2?:0.0
                    res.setText(resultadeishon.toString())
                    ed.setText("$num1$sign$num2")
                }
                if(sign=='/'){
                    var resultadeishon:Double? = num1/num2?:0.0
                    res.setText(resultadeishon.toString())
                    ed.setText("$num1$sign$num2")
                }
            }else{
                num1 = ed.getText().toString().toDouble()?:0.0
               res.setText(num1.toString())
            }
        }


    }

    private fun BuscarSigno(obtTexto: String, sign: Char): Boolean {
        var boleano = false
        for(c in obtTexto){
            if(c == sign) {
            boleano = true
        }
        }
        return boleano
    }
}