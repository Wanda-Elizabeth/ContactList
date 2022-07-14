package ork.liesa.mycontact

import android.location.Address
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import ork.liesa.mycontact.databinding.ActivityMainBinding
import ork.liesa.mycontact.databinding.ActivityViewContact2Binding

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding:ActivityViewContact2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewContact2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
    }

    fun getExtras() {
        val extras = intent.extras
        var name = extras?.getString("NAME", "")
        var phone = extras?.getString("PHONE_NUMBER", "")
        var email = extras?.getString("EMAIL", "")
        var address = extras?.getString("ADDRESS", "")
        var image = binding.imgDisplay

        Toast.makeText(this,name,Toast.LENGTH_LONG).show()
        Toast.makeText(this,phone,Toast.LENGTH_LONG).show()
        binding.tvname1.text=name
        binding.tvPhonenum.text=phone
        binding.tvEmaill.text=email
        binding.tvLocation.text=address
        Picasso.get().load(intent.getStringExtra("IMAGE"))
            .resize(500,500)
            .centerCrop()
            .into(image)
    }
}