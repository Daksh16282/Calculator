package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var b1: Button;
    lateinit var b2: Button;
    lateinit var b3: Button;
    lateinit var b4: Button;
    lateinit var b5: Button;
    lateinit var b6: Button;
    lateinit var b7: Button;
    lateinit var b8: Button;
    lateinit var b9: Button;
    lateinit var b0: Button
    lateinit var badd: Button;
    lateinit var bsub: Button;
    lateinit var bmul: Button;
    lateinit var bdiv: Button;
    lateinit var bdot: Button;
    lateinit var bcut: Button;
    lateinit var bclear: Button;
    lateinit var bmod: Button;
    lateinit var bequate: Button;

    var result: Double = 0.0;
    var value1: Double = 0.0;
    var value2: Double = 0.0;
    var equate_flag=true
    var resTemp: StringBuffer = StringBuffer()

    lateinit var history: TextView;
    lateinit var res: TextView

    var arr = ArrayList<Any>()
    var ind = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4 = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6 = findViewById(R.id.b6)
        b7 = findViewById(R.id.b7)
        b8 = findViewById(R.id.b8)
        b9 = findViewById(R.id.b9)
        b0 = findViewById(R.id.b0)
        badd = findViewById(R.id.add)
        bmul = findViewById(R.id.mul)
        bsub = findViewById(R.id.sub)
        bdot = findViewById(R.id.dot)
        bdiv = findViewById(R.id.div)
        bcut = findViewById(R.id.cut)
        bclear = findViewById(R.id.clear)
        bmod = findViewById(R.id.mod)
        bequate = findViewById(R.id.equate)


        //---------TextViews----------
        history = findViewById(R.id.history)
        res = findViewById(R.id.result)
        history.setText("")
        res.setText("0")

        //-------------------------

        b1.setOnClickListener {

            resTemp.append("1")
            res.setText(resTemp)

        }
        b2.setOnClickListener {

            resTemp.append("2")
            res.setText(resTemp)

        }
        b3.setOnClickListener {

            resTemp.append("3")
            res.setText(resTemp)

        }
        b4.setOnClickListener {

            resTemp.append("4")
            res.setText(resTemp)

        }
        b5.setOnClickListener {

            resTemp.append("5")
            res.setText(resTemp)

        }
        b6.setOnClickListener {

            resTemp.append("6")
            res.setText(resTemp)

        }
        b7.setOnClickListener {

            resTemp.append("7")
            res.setText(resTemp)

        }
        b8.setOnClickListener {

            resTemp.append("8")
            res.setText(resTemp)

        }
        b9.setOnClickListener {

            resTemp.append("9")
            res.setText(resTemp)

        }
        b0.setOnClickListener {

            resTemp.append("0")
            res.setText(resTemp)

        }
        badd.setOnClickListener {
            if(resTemp.length!=0) {
                if (resTemp.get(resTemp.length - 1).equals('+') || resTemp.get(resTemp.length - 1)
                        .equals('-') || resTemp.get(resTemp.length - 1).equals('/') || resTemp.get(
                        resTemp.length - 1
                    ).equals('*') || resTemp.get(resTemp.length - 1).equals('%')
                ) {
                    resTemp.deleteCharAt(resTemp.length - 1)
                }
                resTemp.append("+")

            }else{
                resTemp.append("0+")
            }

            res.setText(resTemp)



        }
        bsub.setOnClickListener {
            if (resTemp.length!=0) {
                if (resTemp.get(resTemp.length - 1).equals('+') || resTemp.get(resTemp.length - 1)
                        .equals('-') || resTemp.get(resTemp.length - 1).equals('/') || resTemp.get(
                        resTemp.length - 1
                    ).equals('*') || resTemp.get(resTemp.length - 1).equals('%')
                ) {
                    resTemp.deleteCharAt(resTemp.length - 1)
                }
                resTemp.append("-")
            }else{
                resTemp.append("0-")
            }
            res.setText(resTemp)


        }
        bmul.setOnClickListener {
            if (resTemp.length!=0) {
                if (resTemp.get(resTemp.length - 1).equals('+') || resTemp.get(resTemp.length - 1)
                        .equals('-') || resTemp.get(resTemp.length - 1).equals('/') || resTemp.get(
                        resTemp.length - 1
                    ).equals('*') || resTemp.get(resTemp.length - 1).equals('%')
                ) {
                    resTemp.deleteCharAt(resTemp.length - 1)
                }
                resTemp.append("*")
            }else{
                resTemp.append("0*")
            }
            res.setText(resTemp)


        }
        bdiv.setOnClickListener {
            if(resTemp.length!=0) {
                if (resTemp.get(resTemp.length - 1).equals('+') || resTemp.get(resTemp.length - 1)
                        .equals('-') || resTemp.get(resTemp.length - 1).equals('/') || resTemp.get(
                        resTemp.length - 1
                    ).equals('*') || resTemp.get(resTemp.length - 1).equals('%')
                ) {
                    resTemp.deleteCharAt(resTemp.length - 1)
                }
                resTemp.append("/")
            }else{
                resTemp.append("0/")
            }
            res.setText(resTemp)


        }
        bdot.setOnClickListener {

            resTemp.append(".")
            res.setText(resTemp)

        }
        bmod.setOnClickListener {
            if(resTemp.length!=0) {
                if (resTemp.get(resTemp.length - 1).equals('+') || resTemp.get(resTemp.length - 1)
                        .equals('-') || resTemp.get(resTemp.length - 1).equals('/') || resTemp.get(
                        resTemp.length - 1
                    ).equals('*') || resTemp.get(resTemp.length - 1).equals('%')
                ) {
                    resTemp.deleteCharAt(resTemp.length - 1)
                }
                resTemp.append("%")
            }else{
                resTemp.append("0%")
            }
            res.setText(resTemp)


        }
        bclear.setOnClickListener {

            resTemp.setLength(0)
            res.setText("0")
            arr.clear()
            ind = 0
            history.setText("")
            equate_flag=true
        }
        bcut.setOnClickListener {

            resTemp.deleteCharAt(resTemp.length - 1)
            res.setText(resTemp)


        }

            bequate.setOnClickListener {
                if(equate_flag){
//                    equate_flag=false;
                    if (resTemp.get(resTemp.length - 1).equals('+') || resTemp.get(resTemp.length - 1)
                            .equals('-') || resTemp.get(resTemp.length - 1).equals('/') || resTemp.get(
                            resTemp.length - 1
                        ).equals('*') || resTemp.get(resTemp.length - 1).equals('%')
                    ) {
                        resTemp.deleteCharAt(resTemp.length - 1)
                    }

                for (i in 0..resTemp.length - 1) {
                    Log.d("MYTAG", "i:" + i + " value:" + resTemp.get(i).toString())
                    if (resTemp.get(i).equals('+') || resTemp.get(i).equals('-') || resTemp.get(i)
                            .equals('/') || resTemp.get(i).equals('*') || resTemp.get(i).equals('%')
                    ) {
                        arr.add(resTemp.substring(ind, i).toString())
                        arr.add(resTemp.get(i).toString())
                        ind = i + 1
                    }
                }
                arr.add(resTemp.substring(ind, resTemp.length))
                Log.d("MYTAG", "Array of size ${arr.size} created")

//              Data Checking by Log
//                var st: StringBuffer = StringBuffer()
//                for (i in arr) {
//                    st.append(i.toString() + "  ")
//                }
//            Log.d("MYTAG",""+st.toString())


                //Primary Logic
                var j = 0.0
                var j1: Int = arr.size - 1
                var i1: Int
                var i2: Int
                var flag = 1


                while (arr.size > 1) {
                    i1 = 0
                    if (!arr.contains("*") && !arr.contains("%") && !arr.contains("/")) {
                        Log.d("MYTAG", "No operator among / * %")

                        break
                    }
//                Log.d("MYTAG","Running, Size:"+arr.size.toString())
                    for (i in 0..arr.size - 1) {
                        if (arr.get(i).equals("/") && arr.get(i + 1).equals("0")) {
                            flag = 0
                            res.setText("Can't divide by zero")
                            history.setText(resTemp.toString())
                            break;
                        }
                    }

                    while (i1 <= j1) {
                        if (!arr.contains("*") && !arr.contains("%") && !arr.contains("/")) {
                            Log.d("MYTAG", "No operator among / * % 2")

                            break
                        }
//                    Log.d("MYTAG", "Checking for " + arr.get(i1))
                        if (arr.get(i1).equals("*") || arr.get(i1).equals("/") || arr.get(i1)
                                .equals("%")
                        ) {
                            when (arr.get(i1)) {
                                "*" -> {
                                    j = mul(
                                        arr.get(i1 - 1).toString().toDouble(),
                                        arr.get(i1 + 1).toString().toDouble()
                                    )
                                    arr.add(i1 - 1, j)
                                    arr.removeAt(i1)
                                    arr.removeAt(i1)
                                    arr.removeAt(i1)
                                    j1 -= 2

                                    Log.d("MYTAG", "Executed *")

                                }

                                "/" -> {
                                    j = div(
                                        arr.get(i1 - 1).toString().toDouble(),
                                        arr.get(i1 + 1).toString().toDouble()
                                    )
                                    arr.add(i1 - 1, j)
                                    arr.removeAt(i1)
                                    arr.removeAt(i1)
                                    arr.removeAt(i1)
                                    j1 -= 2

                                    Log.d("MYTAG", "Executed /")

                                }

                                "%" -> {
                                    j = mod(
                                        arr.get(i1 - 1).toString().toDouble(),
                                        arr.get(i1 + 1).toString().toDouble()
                                    )
                                    arr.add(i1 - 1, j)
                                    arr.removeAt(i1)
                                    arr.removeAt(i1)
                                    arr.removeAt(i1)
                                    j1 -= 2

                                    Log.d("MYTAG", "Executed %")
                                }
                            }
                        }

                        var st: StringBuffer = StringBuffer()
                        for (i in arr) {
                            st.append(i.toString() + "  ")
                        }
                        Log.d("MYTAG","Expression:"+st.toString())

                        if(j1>1) {
                            if (!arr.get(i1).equals("*") && !arr.get(i1).equals("/") && !arr.get(i1)
                                    .equals("%")
                            ) {
                                i1++
                            }
                        }
                    }
                }

                while (arr.size > 1) {
                    i2 = 0
                    if (!arr.contains("+") && !arr.contains("-")) {
                        Log.d("MYTAG", "No operator among + - ")

                        break
                    }
                    while (i2 <= j1) {
                        if (!arr.contains("+") && !arr.contains("-")) {
                            Log.d("MYTAG", "No operator among + - 2")

                            break
                        }
                        Log.d("MYTAG", "Checking for " + arr.get(i2) +" at index:"+i2)

                        if (arr.get(i2).equals("-") || arr.get(i2).equals("+")) {
                            when (arr.get(i2)) {
                                "+" -> {
                                    j = add(
                                        arr.get(i2 - 1).toString().toDouble(),
                                        arr.get(i2 + 1).toString().toDouble()
                                    )
                                    arr.add(i2 - 1, j)
                                    arr.removeAt(i2)
                                    arr.removeAt(i2)
                                    arr.removeAt(i2)
                                    j1 -= 2

                                    Log.d("MYTAG", "Executed +")

                                }

                                "-" -> {
                                    j = sub(
                                        arr.get(i2 - 1).toString().toDouble(),
                                        arr.get(i2 + 1).toString().toDouble()
                                    )
                                    arr.add(i2 - 1, j)
                                    arr.removeAt(i2)
                                    arr.removeAt(i2)
                                    arr.removeAt(i2)
                                    j1 -= 2

                                    Log.d("MYTAG", "Executed -")

                                }

                            }

                        }
                        var st: StringBuffer = StringBuffer()
                        for (i in arr) {
                            st.append(i.toString() + "  ")
                        }
                        Log.d("MYTAG","Expression:"+st.toString())

                        Log.d("MYTAG","Comparing when i2 is $i2")

                        if(j1>1) {
                            if (!arr.get(i2).equals("+") && !arr.get(i2).equals("-")) {
                                i2++
                            }
                        }
                    }

                }

                if (flag != 0) {
                    res.setText(arr.get(0).toString())
                    history.setText(resTemp)
                    resTemp.setLength(0)
                    resTemp.append(arr.get(0).toString())
                    ind=0
                    arr.clear()
                }
                Log.d("MYTAG", "ENDED")

            }
        }

    }

    fun add(a: Double = 0.0, b: Double = 0.0): Double {
        return a + b

    }

    fun sub(a: Double = 0.0, b: Double = 0.0): Double {
        return a - b

    }

    fun mul(a: Double = 0.0, b: Double = 0.0): Double {
        return a * b

    }

    fun mod(a: Double = 0.0, b: Double = 0.0): Double {
        return a % b

    }

    fun div(a: Double = 0.0, b: Double = 0.0): Double {
        if (b.equals(0)) {
            return 0.0
        }
        return a / b
    }
}
