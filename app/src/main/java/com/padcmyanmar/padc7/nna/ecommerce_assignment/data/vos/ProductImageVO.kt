package com.padcmyanmar.padc7.nna.ecommerce_assignment.data.vos

import com.google.gson.annotations.SerializedName

class ProductImageVO (  @SerializedName("id") val id: Int,
                        @SerializedName("image_url") val imageUrl: String)