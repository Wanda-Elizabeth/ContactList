package ork.liesa.mycontact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ork.liesa.mycontact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContacts()
    }
    fun displayContacts(){
        var contact=Contact("Khloe","0792723653","wanda@gmail.com","dagoe","https://images.pexels.com/photos/1125328/pexels-photo-1125328.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact1=Contact("Robert","0792773653","robert@gmail.com","dagi","https://images.pexels.com/photos/428333/pexels-photo-428333.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact2=Contact("Mwangi","0790723653","mwangi@gmail.com","dag","https://images.pexels.com/photos/3656518/pexels-photo-3656518.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact3=Contact("Shee","0792623653","shee@gmail.com","dao","https://images.pexels.com/photos/993868/pexels-photo-993868.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact4=Contact("Lisa","0793723653","lisa@gmail.com","dgo","https://images.pexels.com/photos/1210547/pexels-photo-1210547.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact5=Contact("liz","0793723653","liz@gmail.com","ago","https://images.pexels.com/photos/944761/pexels-photo-944761.jpeg?auto=compress&cs=tinysrgb&w=400")

        var  contactList=listOf(contact, contact1, contact2, contact3, contact4, contact5)
        var contactAdapter=ContactRVAdapter(contactList)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=contactAdapter

    }
}