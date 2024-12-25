package com.example.openaccess

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        val contactsRecyclerView = findViewById<RecyclerView>(R.id.recycler_view_contacts)

        val contacts = listOf(
            Contact("Иван Иванов", "+7 123 456 7890"),
            Contact("Мария Смирнова", "+7 987 654 3210"),
            Contact("Анна Петрова", "+7 555 666 7777")
        )

        contactsRecyclerView.layoutManager = LinearLayoutManager(this)
        contactsRecyclerView.adapter = ContactsAdapter(contacts)
    }
}