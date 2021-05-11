package net.cherokeedictionary.dateTime

class CherokeeDateTimeProcessTest extends GroovyTestCase {
    def getDay(calendar, date) {
        calendar.set(Calendar.DATE, date)
        def cherokeeDateTime = CherokeeDateTimeProcessor.getDateTime(calendar)

        return cherokeeDateTime
    }
    void testDateTime() {
        def calendar = Calendar.getInstance()

        println getDay(calendar, 2)
        println getDay(calendar, 3)
        println getDay(calendar, 4)
        println getDay(calendar, 5)
        println getDay(calendar, 6)
        println getDay(calendar, 7)
        println getDay(calendar, 8)


    }
}
