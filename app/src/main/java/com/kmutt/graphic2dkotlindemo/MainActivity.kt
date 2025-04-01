package com.kmutt.graphic2dkotlindemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(MyView(this))

    }

    class  MyView (context: Context?) : View(context){
       private var circleX: Float? = null
        private  var circleY: Float? = null

        private val paint = Paint().apply {
            style = Paint.Style.FILL
            color = Color.parseColor("#CD5C5C")
        }
        private val paintgreen = Paint().apply {
            style = Paint.Style.FILL
            color = Color.parseColor("#02c133")
        }


        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            val xR = width / 2
            val yR = height / 2
            val radius = 100f
            canvas.drawColor(Color.WHITE)
            val rectLeft = (xR / 4).toFloat()
            val rectTop = (yR / 4).toFloat()
            val rectRight = (xR * 3 / 4).toFloat()
            val rectBottom = (yR * 2 / 4).toFloat()
            canvas.drawRect(rectLeft, rectTop, rectRight, rectBottom, paintgreen)
            circleX?.let { xC ->
                circleY?.let { yC ->
                    canvas.drawCircle(xC, yC, radius, paint)
                }
            }
        }
        override fun onTouchEvent(event: MotionEvent): Boolean {
            when (event.action) {
                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                    circleX = event.x
                    circleY = event.y
                    invalidate() // รีเฟรชหน้าจอ
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    circleX = null
                    circleY = null
                    invalidate() // รีเฟรชหน้าจอเพื่อลบวงกลม
                }
            }
            return true
        }

    }
}