package com.twoninelab.signboard

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_display)

        var marqText = intent.getStringExtra("text");
        var marqFont = intent.getStringExtra("font");
        var font1: Typeface? = marqFont?.let { FontClass().getTextFont(this, it) }
        val marqTextView = findViewById<TextView>(R.id.marqTextFinal)
        marqTextView.setText(marqText.toString().uppercase());
        marqTextView.typeface = font1
        Log.i("DisplayActivity",marqText.toString());
        marqTextView.setSelected(true);

        findViewById<ImageView>(R.id.cross_final).setOnClickListener(View.OnClickListener {
            marqTextView.setText("");
            var Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent);
        })
    }
}