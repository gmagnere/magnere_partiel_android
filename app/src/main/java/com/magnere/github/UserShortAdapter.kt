package com.magnere.github

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.magnere.github.domain.model.UserShort
import com.squareup.picasso.Picasso

class UserShortAdapter(
    context: Context,
    private val listener: OnUserClickListener
) : RecyclerView.Adapter<UserShortAdapter.ViewHolder>() {


    interface OnUserClickListener {
        fun onUserClicked(id: String)
    }

    private val users: ArrayList<UserShort> = ArrayList()
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size

    @SuppressLint("NotifyDataSetChanged")
    fun setUsers(data: List<UserShort>?) {
        users.clear()

        data?.let {
            users.addAll(data)
        }

        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val name: TextView = view.findViewById(R.id.item_user_name)
        private val image: ImageView = view.findViewById(R.id.item_user_image)

        init {
            view.setOnClickListener {
                listener.onUserClicked(users[adapterPosition].id)
            }
        }

        fun bind(userShort: UserShort) {
            name.text = userShort.login

            Picasso.get().load(userShort.avatar_url).into(image)
        }
    }
}