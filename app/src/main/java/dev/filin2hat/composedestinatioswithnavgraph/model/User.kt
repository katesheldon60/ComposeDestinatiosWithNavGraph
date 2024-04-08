package dev.filin2hat.composedestinatioswithnavgraph.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime

@Parcelize
data class User(
    val id: String,
    val name: String,
    val createdAt: LocalDateTime
) : Parcelable
