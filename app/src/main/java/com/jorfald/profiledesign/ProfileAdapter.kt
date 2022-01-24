package com.jorfald.profiledesign

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(
    private val dataSet: List<User>
): RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    inner class ProfileViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val container: ConstraintLayout
        val image: ImageView
        val nameText: TextView
        val emailText: TextView

        init {
            container = view.findViewById(R.id.cell_container)
            image = view.findViewById(R.id.cell_image)
            nameText = view.findViewById(R.id.cell_name_text)
            emailText = view.findViewById(R.id.cell_email_text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val cellView = LayoutInflater.from(parent.context).inflate(R.layout.profile_cell_item, parent, false)

        val params: ViewGroup.LayoutParams = cellView.layoutParams
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        cellView.layoutParams = params

        return ProfileViewHolder(cellView)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val user = dataSet[position]

        holder.image.setImageResource(user.pictureResource)
        holder.nameText.text = user.name
        holder.emailText.text = "E-mail: ${user.email}"
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
