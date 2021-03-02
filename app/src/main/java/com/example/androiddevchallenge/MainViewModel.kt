package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.PuppyInfo

class MainViewModel : ViewModel() {

    private val testDesc = """
        Lovely dog, always keep quite.
        Papillons are very intelligent and self-assured dogs that have a very easy time learning new tricks. These dogs can be sociable with children and strangers, but are generally reserved around new people. They can also be socialized to get along well with other pets, but care should be taken with rambunctious pets or cats with claws, as they may injure them. If not properly socialized, Papillons can be distrustful and exhibit aggressive tendencies toward other dogs and people. Papillons may also be very playful and affectionate. Widely known as great companion dogs, they have the spirit and energy to keep up with active families, but can also be calm enough to be happy with sleeping in the arms of an equally affectionate owner. Due to their high energy level, they demand an augmented exercise routine, relative to the average companion breed. Papillons are known as excellent watchdogs, as they will alert their owner to changes in their environment. They may be considered garrulous like many other toy dogs. They can withstand heat, but are more sensitive to cold temperatures because of their single-coated fur, and should not be left outside unattended in cold weather.
        A Papillion jumping at a dog show.
        The most iconic aspect of Papillons are their ears, which are large and well fringed, giving them a butterfly wing-like appearance. Papillons are particolored or white with patches of any color. An all-white dog or a dog with no white is disqualified from the conformation show ring. A blaze (area of white extending down between the eyes) and noseband is preferred over a solid-colored head, but not required. Nose, eye rims, and lips should be black. Paw pads vary in color from black to pink, depending on the coloring of the dog. 
    """.trimIndent()

    val puppyList by mutableStateOf(
        listOf(
            PuppyInfo(
                "1", "Pudding", "6", "Hangzhou, Zhejiang Province",
                "girl", testDesc, R.drawable.img_pudding
            ),
            PuppyInfo(
                "2", "Jelly", "1", "Hangzhou, Zhejiang Province",
                "girl", "Good dog, need a lot of outdoor activities.", R.drawable.img_jelly
            ),
            PuppyInfo(
                "3", "Beans", "10", "Anqiu, Shandong Province",
                "girl", "Huge dog, eat too much.", R.drawable.img_beans
            ),
            PuppyInfo(
                "4", "LittleYellow", "8", "Anqiu, Shandong Province",
                "girl", "Good dog for watching your yard.", R.drawable.img_little_yellow
            ),
            PuppyInfo(
                "5", "Niuniu", "15", "Anqiu, Shandong Province",
                "girl", "Old but healthy", R.drawable.img_niuniu
            )
        )
    )

    var currentPuppy: PuppyInfo? by mutableStateOf(null)

    fun showPuppy(puppy: PuppyInfo) {
        currentPuppy = puppy
    }

    fun dismiss() {
        currentPuppy = null
    }

}