package com.wanted.preob.newsapp.domain.model.enums

import com.wanted.preob.newsapp.R

enum class Category(val title: String, val resId: Int) {
    BUSINESS(title = "business", resId = R.drawable.ic_business),
    ENTERTAINMENT(title = "entertainment", resId = R.drawable.ic_entertainment),
    GENERAL(title = "general", resId = R.drawable.ic_general),
    HEALTH(title = "health", resId = R.drawable.ic_health),
    SCIENCE(title = "science", resId = R.drawable.ic_science),
    SPORTS(title = "sports", resId = R.drawable.ic_sports),
    TECHNOLOGY(title = "technology", resId = R.drawable.ic_technology),
}