package com.location.detector.data.model

import com.google.gson.annotations.SerializedName
import java.util.*


data class Location(

    @SerializedName("ip") var ip: String? = null,
    @SerializedName("continentCode") var continentCode: String? = null,
    @SerializedName("continentName") var continentName: String? = null,
    @SerializedName("countryCode") var countryCode: String? = null,
    @SerializedName("countryName") var countryName: String? = null,
    @SerializedName("countryNameNative") var countryNameNative: String? = null,
    @SerializedName("officialCountryName") var officialCountryName: String? = null,
    @SerializedName("regionCode") var regionCode: String? = null,
    @SerializedName("regionName") var regionName: String? = null,
    @SerializedName("city") var city: String? = null,
    @SerializedName("postalCode") var postalCode: String? = null,
    @SerializedName("latitude") var latitude: Double,
    @SerializedName("longitude") var longitude: Double,
    @SerializedName("capital") var capital: String? = null,
    @SerializedName("phoneCode") var phoneCode: String? = null,
    @SerializedName("countryFlagEmoj") var countryFlagEmoj: String? = null,
    @SerializedName("countryFlagEmojUnicode") var countryFlagEmojUnicode: String? = null,
    @SerializedName("isEu") var isEu: Boolean? = null,
    @SerializedName("borders") var borders: ArrayList<String>,
    @SerializedName("topLevelDomains") var topLevelDomains: ArrayList<String>,
    @SerializedName("languages") var languages: Languages? = Languages(),
    @SerializedName("currency") var currency: Currency? = Currency(),
    @SerializedName("timeZone") var timeZone: TimeZone? = TimeZone(),
    @SerializedName("userAgent") var userAgent: UserAgent? = UserAgent(),
    @SerializedName("connection") var connection: Connection? = Connection(),
    @SerializedName("security") var security: Security? = Security()


) {
    override fun toString(): String {
        return "ContinentCode=$continentCode, " +
                "\nContinentName=$continentName," +
                "\nCountryCode=$countryCode, " +
                "\nCountryName=$countryName," +
                "\nCountryNameNative=$countryNameNative," +
                "\nOfficialCountryName=$officialCountryName, " +
                "\nRegionCode=$regionCode," +
                "\nRegionName=$regionName, " +
                "\nCity=$city," +
                "\nPostalCode=$postalCode, " +
                "\nCapital=$capital, " +
                "\nPhoneCode=$phoneCode, " +
                "\nCountryFlagEmoj=$countryFlagEmoj," +
                "\nCountryFlagEmojUnicode=$countryFlagEmojUnicode," +
                "\nIsEu=$isEu, " +
                "\nBorders=$borders," +
                "\nTopLevelDomains=$topLevelDomains," +
                "\nLanguages=$languages, " +
                "\nCurrency=$currency, " +
                "\nTimeZone=$timeZone, " +
                "\nUserAgent=$userAgent, " +
                "\nConnection=$connection," +
                "\nSecurity=$security"
    }
}