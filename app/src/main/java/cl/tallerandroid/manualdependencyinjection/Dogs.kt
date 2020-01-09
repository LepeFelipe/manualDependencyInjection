package cl.tallerandroid.manualdependencyinjection

import com.google.gson.annotations.SerializedName

class Dogs(@SerializedName("message") var listRazas: List<String>)