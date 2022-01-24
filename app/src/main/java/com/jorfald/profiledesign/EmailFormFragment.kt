package com.jorfald.profiledesign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.add
import androidx.fragment.app.commit

class EmailFormFragment : Fragment() {

    private lateinit var toInput: EditText
    private lateinit var fromInput: EditText
    private lateinit var subjectInput: EditText
    private lateinit var contentInput: EditText
    private lateinit var sendEmailButton: AppCompatButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_email_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toInput = view.findViewById(R.id.to_edit_text)
        fromInput = view.findViewById(R.id.from_edit_text)
        subjectInput = view.findViewById(R.id.subject_edit_text)
        contentInput = view.findViewById(R.id.content_edit_text)
        sendEmailButton = view.findViewById(R.id.send_button)

        val email = requireArguments().getString("PROFILE_EMAIL")
        toInput.setText(email)

        bindButtons()
    }

    private fun bindButtons() {
        sendEmailButton.setOnClickListener {
            var isValid = true

            if (fromInput.text.isEmpty()) {
                fromInput.error = "Must be filled out"
                isValid = false
            }

            if (subjectInput.text.isEmpty()) {
                subjectInput.error = "Must be filled out"
                isValid = false
            }

            if (contentInput.text.isEmpty()) {
                contentInput.error = "Must be filled out"
                isValid = false
            }

            if (isValid) {
                //TODO: Send email!

                parentFragmentManager.popBackStack()
            }
        }
    }
}