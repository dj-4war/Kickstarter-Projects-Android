package com.dj.sample.kickstarter.projects.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Project model which will hold the data of individual projects which are returned from server .
 */
class Project : Serializable{

    @SerializedName("s.no")
    @Expose
    private var sNo: Int? = null
    @SerializedName("amt.pledged")
    @Expose
    private var amtPledged: Int? = null
    @SerializedName("blurb")
    @Expose
    private var blurb: String? = null
    @SerializedName("by")
    @Expose
    private var by: String? = null
    @SerializedName("country")
    @Expose
    private var country: String? = null
    @SerializedName("currency")
    @Expose
    private var currency: String? = null
    @SerializedName("end.time")
    @Expose
    private var endTime: String? = null
    @SerializedName("location")
    @Expose
    private var location: String? = null
    @SerializedName("percentage.funded")
    @Expose
    private var percentageFunded: Int? = null
    @SerializedName("num.backers")
    @Expose
    private var numBackers: String? = null
    @SerializedName("state")
    @Expose
    private var state: String? = null
    @SerializedName("title")
    @Expose
    private var title: String? = null
    @SerializedName("type")
    @Expose
    private var type: String? = null
    @SerializedName("url")
    @Expose
    private var url: String? = null

    fun getSNo(): Int? {
        return sNo
    }

    fun setSNo(sNo: Int?) {
        this.sNo = sNo
    }

    fun getAmtPledged(): Int? {
        return amtPledged
    }

    fun setAmtPledged(amtPledged: Int?) {
        this.amtPledged = amtPledged
    }

    fun getBlurb(): String? {
        return blurb
    }

    fun setBlurb(blurb: String) {
        this.blurb = blurb
    }

    fun getBy(): String? {
        return by
    }

    fun setBy(by: String) {
        this.by = by
    }

    fun getCountry(): String? {
        return country
    }

    fun setCountry(country: String) {
        this.country = country
    }

    fun getCurrency(): String? {
        return currency
    }

    fun setCurrency(currency: String) {
        this.currency = currency
    }

    fun getEndTime(): String? {
        return endTime
    }

    fun setEndTime(endTime: String) {
        this.endTime = endTime
    }

    fun getLocation(): String? {
        return location
    }

    fun setLocation(location: String) {
        this.location = location
    }

    fun getPercentageFunded(): Int? {
        return percentageFunded
    }

    fun setPercentageFunded(percentageFunded: Int?) {
        this.percentageFunded = percentageFunded
    }

    fun getNumBackers(): String? {
        return numBackers
    }

    fun setNumBackers(numBackers: String) {
        this.numBackers = numBackers
    }

    fun getState(): String? {
        return state
    }

    fun setState(state: String) {
        this.state = state
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String) {
        this.type = type
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String) {
        this.url = url
    }

}