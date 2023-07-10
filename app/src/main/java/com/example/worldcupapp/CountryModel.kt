package com.example.worldcupapp

class CountryModel {
    var countryName:String = ""
    var cupsWon:String = ""
    var flag_img:Int = 0

    constructor(countryName: String, cupsWon: String, flag_img: Int) {
        this.countryName = countryName
        this.cupsWon = cupsWon
        this.flag_img = flag_img
    }
}