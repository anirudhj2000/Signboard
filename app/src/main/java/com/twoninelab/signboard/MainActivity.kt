package com.twoninelab.signboard

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_main)

        try{
            var finalFont: Typeface? = ResourcesCompat.getFont(this, R.font.montserrat_regular)
            var selectedFont:String? = ""

            findViewById<Button>(R.id.buttonSubmit).setOnClickListener(View.OnClickListener {
                findViewById<LinearLayout>(R.id.previewLayout).visibility = View.INVISIBLE;
                val text1 = findViewById<EditText>(R.id.etTxt1).text.toString();
                var intent = Intent(this, DisplayActivity::class.java)
                intent.putExtra("text", text1)
                intent.putExtra("font",selectedFont)
                startActivity(intent);
            } )

            findViewById<Button>(R.id.btnPreview).setOnClickListener(View.OnClickListener {
                findViewById<LinearLayout>(R.id.previewLayout).visibility = View.VISIBLE;
                val text1 = findViewById<EditText>(R.id.etTxt1).text.toString()
                val marqText = findViewById<TextView>(R.id.marqeeText)
                marqText.typeface = finalFont
                marqText.setText(text1.toString())
                marqText.setSelected(true)
            } )

            findViewById<ImageView>(R.id.cross).setOnClickListener(View.OnClickListener {
                findViewById<LinearLayout>(R.id.previewLayout).visibility = View.INVISIBLE;
            })


            var dropDown = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView1)
            var fonts = listOf("MontSerrat", "MontSerrat-Bold", "Monoton", "PressStart", "Raleway-Dots", "Bungee")
            dropDown.setAdapter(ArrayAdapter<String>(this,R.layout.list_item,fonts))

            dropDown.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, i, l ->
                var customFont : Typeface? = FontClass().getTextFont(this,fonts[i])
                //findViewById<EditText>(R.id.etTxt1).typeface = customFont
                findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView1).typeface = customFont
                finalFont = customFont
                selectedFont = fonts[i]
             })

        }
        catch(e: NullPointerException){
            e.printStackTrace();
        }
    }
}