package com.v3cube.beautician.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.daimajia.slider.library.Tricks.ViewPagerEx
import com.v3cube.beautician.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.HashMap

class FirstPage : AppCompatActivity(), BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    //    private var HashMapForURL: HashMap<String, String>? = null
    private var HashMapForLocalRes: HashMap<String, Int>? = null
//    private var language = arrayOf("ENGLISH", "FRENCH", "THAI", "DANISH", "ESTONIAN", "FINNISH", "GERMAN", "LATCIAN", "LITHUANIAN", "NORWEGIAN", "POLISH", "RUSSIAN", "SPANISH", "SWEDISHA", "ITALIAN", "ARABIC", "URDU")
//
//    private var currency = arrayOf("INR", "USD", "GBP", "AUD", "BRL", "CAD", "CLP", "COP", "CRC", "DOP", "EGP", "GHS", "IDR", "IRR", "KZT", "LKR", "MYR")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val langAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, language)
//        langAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        bLang.adapter = langAdapter
//
//        val currAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, currency)
//        currAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        bCurr.adapter = currAdapter
//
        bLogin.setOnClickListener {
            startActivity(Intent(this@FirstPage, Login::class.java))
        }

        bRegister.setOnClickListener {
            startActivity(Intent(this@FirstPage, Register::class.java))
        }

        //===========================================================================

        //Call this method if you want to add images from URL .
// AddImagesUrlOnline()
        //Call this method to add images from local drawable folder .
        AddImageUrlFormLocalRes()

        //Call this method to stop automatic sliding.
        //sliderLayout.stopAutoCycle();

        for (name in HashMapForLocalRes!!.keys) {

            val textSliderView = TextSliderView(this@FirstPage)

            textSliderView
                    .description(name)
                    .image(HashMapForLocalRes!![name]!!)
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this)

            textSliderView.bundle(Bundle())

            textSliderView.bundle
                    .putString("extra", name)

            slider.addSlider(textSliderView)
        }
        slider.setPresetTransformer(SliderLayout.Transformer.DepthPage)

        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)

        slider.setCustomAnimation(DescriptionAnimation())

        slider.setDuration(3000)

        slider.addOnPageChangeListener(this@FirstPage)

    }

    //======================================================================================================

    override fun onStop() {

        slider.stopAutoCycle()

        super.onStop()
    }

    override fun onSliderClick(slider: BaseSliderView) {

        Toast.makeText(this, slider.bundle.get("extra")!!.toString() + "", Toast.LENGTH_SHORT).show()
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {

        Log.d("Slider Demo", "Page Changed: $position")

    }

    override fun onPageScrollStateChanged(state: Int) {

    }

//    fun AddImagesUrlOnline() {
//
//        HashMapForURL = HashMap()
//
//        HashMapForURL!!["CupCake"] = "http://androidblog.esy.es/images/cupcake-1.png"
//        HashMapForURL!!["Donut"] = "http://androidblog.esy.es/images/donut-2.png"
//        HashMapForURL!!["Eclair"] = "http://androidblog.esy.es/images/eclair-3.png"
//        HashMapForURL!!["Froyo"] = "http://androidblog.esy.es/images/froyo-4.png"
//        HashMapForURL!!["GingerBread"] = "http://androidblog.esy.es/images/gingerbread-5.png"
//    }

    private fun AddImageUrlFormLocalRes() {

        HashMapForLocalRes = HashMap()

        HashMapForLocalRes!!["HAIR STYLE\nSearch for beauty & wellness salons in your area"] = R.drawable.img_hair_style
        HashMapForLocalRes!!["FACIAL\nSearch for beauty & wellness salons in your area"] = R.drawable.img_facial
        HashMapForLocalRes!!["NAILS\nSearch for beauty & wellness salons in your area"] = R.drawable.img_nail

    }

    //=========================================================================================================
}
