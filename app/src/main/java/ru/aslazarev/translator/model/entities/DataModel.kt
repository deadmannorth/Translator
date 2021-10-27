package ru.aslazarev.translator.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataModel(
    @field:SerializedName("text") val text: String?,
    @field:SerializedName("meanings") val meanings: List<Meanings>?
) : Parcelable

@Parcelize
data class Meanings(
    @field:SerializedName("translation") val translation: Translation?,
    @field:SerializedName("imageUrl") val imageUrl: String?
) : Parcelable

@Parcelize
data class Translation(
    @field:SerializedName("text") val translation: String?
    ) : Parcelable