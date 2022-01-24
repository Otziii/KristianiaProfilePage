package com.jorfald.profiledesign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit

class ProfileFragment : Fragment() {

    private lateinit var profileImage: ImageView
    private lateinit var nameText: TextView
    private lateinit var photosValue: TextView
    private lateinit var followersValue: TextView
    private lateinit var followingValue: TextView
    private lateinit var emailTextButton: TextView
    private lateinit var phoneTextButton: TextView
    private lateinit var groupTextButton: TextView
    private lateinit var commentsTextButton: TextView
    private lateinit var followMeButton: AppCompatButton
    private lateinit var showingUser: User

    private var isFollowing = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileImage = view.findViewById(R.id.profile_image)
        nameText = view.findViewById(R.id.name_text)
        photosValue = view.findViewById(R.id.photos_value)
        followersValue = view.findViewById(R.id.followers_value)
        followingValue = view.findViewById(R.id.following_value)
        emailTextButton = view.findViewById(R.id.email_text_button)
        phoneTextButton = view.findViewById(R.id.phone_text_button)
        groupTextButton = view.findViewById(R.id.group_text_button)
        commentsTextButton = view.findViewById(R.id.comments_text_button)
        followMeButton = view.findViewById(R.id.follow_button)

        showingUser = User(
            "Øivind Jorfald",
            53,
            1425,
            6,
            "oivind@gmail.com",
            "+47 951 95 951",
            ResourcesCompat.getDrawable(resources, R.drawable.profile_pic2, null),
            R.drawable.profile_pic2
        )

        setUser()
        bindButtons()
    }

    private fun setUser() {
        //profileImage.setImageDrawable(loggedInUser.picture)
        profileImage.setImageResource(showingUser.pictureResource)

        nameText.text = showingUser.name
        setProfileValues()
        emailTextButton.text = showingUser.email
        phoneTextButton.text = showingUser.phoneNumber
    }

    private fun setProfileValues() {
        photosValue.text = showingUser.photos.toString()
        followersValue.text = showingUser.followers.toString()
        followingValue.text = showingUser.following.toString()
    }

    private fun bindButtons() {
        emailTextButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("PROFILE_EMAIL", showingUser.email)

            parentFragmentManager.commit {
                setReorderingAllowed(true)
                add<EmailFormFragment>(R.id.fragment_container, args = bundle)
                addToBackStack(null)
            }
        }

        followMeButton.setOnClickListener {
            if (isFollowing) {
                followMeButton.text = "Follow me"
                isFollowing = false
                showingUser.followers--
                setProfileValues()
            } else {
                followMeButton.text = "Unfollow me"
                isFollowing = true
                showingUser.followers++
                setProfileValues()
            }
        }
    }
}