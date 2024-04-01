package com.codepath.articlesearch.journal

enum class DaysOfTheWeek(val displayName: String) {
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday");

    companion object {
        fun fromDisplayName(name: String): DaysOfTheWeek? {
            return values().find { it.displayName == name }
        }
    }
}

enum class Mood(val displayName: String) {
    HAPPY("Happy"),
    DEPRESSED("Depressed"),
    FURIOUS("Furious"),
    CHILL("Chill"),
    MOODY("Moody"),
    HORNY("Horny af"),
    SLEEPY("Sleepy"),
    ANXIOUS("Anxious");

    companion object {
        fun fromDisplayName(name: String): Mood? {
            return values().find { it.displayName == name }
        }
    }
}

fun moodToString(mood: Mood): String {
    return mood.displayName
}

class JournalEntity {
}