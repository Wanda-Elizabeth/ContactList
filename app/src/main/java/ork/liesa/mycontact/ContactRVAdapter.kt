package ork.liesa.mycontact

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ork.liesa.mycontact.databinding.ContactListItemBinding

class ContactRVAdapter(var contactList: List<Contact>):
    RecyclerView.Adapter<ContactViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding= ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false )
        return ContactViewHolder(binding)
    }
//accessing the current contact
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
    var context=holder.itemView.context
    var currentContact = contactList.get(position)
    with(holder.binding) {
        tvName.text = currentContact.name
        tvContact.text = currentContact.phone
        tvEmail.text = currentContact.email
        tvAddress.text = currentContact.address
        Picasso.get()
            .load(currentContact.image)
            .resize(350,350)
            .centerCrop()
            .into(imgContact)

        cvContact.setOnClickListener{
            var context=holder.itemView.context
            val  intent=Intent(context,ViewContactActivity::class.java)
            intent.putExtra("NAME",currentContact.name)
            intent.putExtra("PHONE_NUMBER",currentContact.phone)
            intent.putExtra("LOCATION",currentContact.address)
            intent.putExtra("Email",currentContact.email)
            intent.putExtra("IMAGE",currentContact.image)
            context.startActivity(intent)
        }
        holder.binding.imgContact.setOnClickListener {
            Toast.makeText(context,"beautiful lady",Toast.LENGTH_LONG)
                .show()
        }
    }
}


    override fun getItemCount(): Int {
        return contactList.size
    }
}
class ContactViewHolder(var binding:ContactListItemBinding):RecyclerView.ViewHolder(binding.root){
}