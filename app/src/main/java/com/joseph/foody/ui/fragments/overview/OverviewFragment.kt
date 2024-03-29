package com.joseph.foody.ui.fragments.overview

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import coil.load
import com.joseph.foody.R
import com.joseph.foody.base.BaseFragment
import com.joseph.foody.databinding.FragmentOverviewBinding
import com.joseph.foody.models.Result
import com.joseph.foody.util.Constants.Companion.RECIPE_RESULT
import org.jsoup.Jsoup

class OverviewFragment : BaseFragment<FragmentOverviewBinding>(R.layout.fragment_overview) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT)

        binding.apply {
            mainImageView.load(myBundle?.image)
            titleTextView.text = myBundle?.title
            likesTextView.text = myBundle?.aggregateLikes.toString()
            timeTextView.text = myBundle?.readyInMinutes.toString()
            myBundle?.summary?.let {
                val summary = Jsoup.parse(it).text()
                summaryTextView.text = summary
            }

            if (myBundle?.vegetarian == true) {
                vegetarianImageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                vegetarianTextView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }
            if (myBundle?.vegan == true) {
                veganImageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                veganTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            }
            if (myBundle?.glutenFree == true) {
                glutenFreeImageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                glutenFreeTextView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }
            if (myBundle?.dairyFree == true) {
                dairyFreeImageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                dairyFreeTextView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }
            if (myBundle?.veryHealthy == true) {
                healthyImageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                healthyTextView.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
            }
            if (myBundle?.cheap == true) {
                cheapImageView.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.green
                    )
                )
                cheapTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            }
        }
    }
}
