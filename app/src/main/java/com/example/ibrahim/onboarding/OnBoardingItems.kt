package com.example.ibrahim.onboarding


class OnBoardingItems(

    val title: String, val image: Int,

    ) {
    companion object {
        fun getData(): List<OnBoardingItems> {
            return listOf(
                OnBoardingItems(
                    "Browse & Order All Products \n" + "at Any Time",
                    image = R.drawable.img1,
                ), OnBoardingItems(
                    "You Package in\n" + "Our Safe Hands",
                    image = R.drawable.img2,


                    ), OnBoardingItems(
                    "Committed Delivery on Time",
                    image = R.drawable.img3,
                ), OnBoardingItems(
                    "7/24\n" + "Fastest & Safest Delivery",
                    image = R.drawable.img4,
                )
            )

        }
    }

}