package net.cherokeedictionary.dateTime

class CherokeeDateTimeProcessor {
    static def months = [];
    static def daysOfWeek = [];
    static def numberMap = [:];
    static def cardinalNumbers = [];

    static {
        months << new DateTimeElement(syllabary: 'ᎤᏃᎸᏔᎾ', english:'January');
        months << new DateTimeElement(syllabary: 'ᎧᎦᎵ', english:'February');
        months << new DateTimeElement(syllabary: 'ᎠᏅᏱ', english:'March');
        months << new DateTimeElement(syllabary: 'ᎧᏬᏂ', english:'April');
        months << new DateTimeElement(syllabary: 'ᎠᏂᏍᎬᏘ', english:'May');
        months << new DateTimeElement(syllabary: 'ᏕᎭᎷᏱ', english:'June');
        months << new DateTimeElement(syllabary: 'ᎫᏰᏉᎾ', english:'July');
        months << new DateTimeElement(syllabary: 'ᎦᎶᏂ', english:'August');
        months << new DateTimeElement(syllabary: 'ᏚᎵᏍᏗ', english:'September');
        months << new DateTimeElement(syllabary: 'ᏚᏂᏂᏗ', english:'October');
        months << new DateTimeElement(syllabary: 'ᏅᏓᏕᏆ', english:'November');
        months << new DateTimeElement(syllabary: 'ᎥᏍᎩᏱ', english:'December');

        daysOfWeek << new DateTimeElement(syllabary: 'ᏙᏓᏆᏍᎬᎢ', english: 'Sunday');
        daysOfWeek << new DateTimeElement(syllabary: 'ᏙᏓᏉᏅᎢ', english: 'Monday');
        daysOfWeek << new DateTimeElement(syllabary: 'ᏔᎵᏁ ᎢᎦ', english: 'Tuesday');
        daysOfWeek << new DateTimeElement(syllabary: 'ᏦᎢᏁ ᎢᎦ', english: 'Wednesday');
        daysOfWeek << new DateTimeElement(syllabary: 'ᏅᎩᏁ ᎢᎦ', english: 'Thursday');
        daysOfWeek << new DateTimeElement(syllabary: 'ᏧᏅᎩᎶᏍᏗ', english: 'Friday');
        daysOfWeek << new DateTimeElement(syllabary: 'ᏙᏓᏈᏕᎾ', english: 'Saturday');
        
        numberMap = ["one":"ᎢᎬᏱᎢ",
                     "two":"ᏔᎵᏁᎢ",
                     "three":"ᏦᎢᏁᎢ",
                     "four":"ᏅᎩᏁᎢ",
                     "five":"ᎯᏍᎩᏁᎢ",
                     "six":"ᏑᏓᎵᏁᎢ",
                     "seven":"ᎦᎵᏉᎩᏁᎢ",
                     "eight":"ᏧᏁᎵᏁᎢ",
                     "nine":"ᏐᏁᎵᏁᎢ",
                     "ten":"ᏍᎪᎯᏁᎢ",
                     "eleven":"ᏌᏚᏏᏁᎢ",
                     "twelve":"ᏔᎵᏚᏏᏁᎢ",
                     "thirteen":"ᏦᎦᏚᏏᏁᎢ",
                     "fourteen":"ᏂᎦᏚᏏᏁᎢ",
                     "fifteen":"ᏍᎩᎦᏚᏏᏁᎢ",
                     "sixteen":"ᏓᎳᏚᏏᏁᎢ",
                     "seventeen":"ᎦᎵᏆᏚᏏᏁᎢ",
                     "eighteen":"ᏁᎳᏚᏏᏁᎢ",
                     "nineteen":"ᏐᏁᎳᏚᏏᏁᎢ",
                     "twenty":"ᏔᎵᏍᎪᎯᏁᎢ",
                     "twenty one":"ᏔᎵᏍᎪ ᏌᏊᎯᏁᎢ",
                     "thirty":"ᏦᏍᎪᎯᏁᎢ",
                     "thirty one":"ᏦᏍᎪ ᏌᏊᎯᏁᎢ"];

        cardinalNumbers << "";//because zero isn't a valid number for dates
        cardinalNumbers << "ᏌᏊ";
        cardinalNumbers << "ᏔᎵ"
        cardinalNumbers << "ᏦᎢ"
        cardinalNumbers << "ᏅᎩ"
        cardinalNumbers << "ᎯᏍᎩ"
        cardinalNumbers << "ᏑᏓᎵ"
        cardinalNumbers << "ᎦᎵᏉᎩ"
        cardinalNumbers << "ᏧᏁᎳ"
        cardinalNumbers << "ᏐᏁᎳ"
    }

    static CherokeeDateTime getDateTime(timeZone="America/Chicago") {
        def cal = Calendar.getInstance()
        cal.setTimeZone(TimeZone.getTimeZone("America/Chicago"))
        def date = cal.get(Calendar.DATE)
        def month = cal.get(Calendar.MONTH)
        def year = cal.get(Calendar.YEAR)
        def dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)

        def weekdaySyll = getWeekday(dayOfWeek)
        def dateSyll = getDate(date)
        def monthSyll = getMonth(month)
        def yearSyll = getYear(year)

        def weekdayEng = getDayOfWeek(dayOfWeek)
        def monthEng = getMonthStr(month)

        return new CherokeeDateTime(date: date, year:year, weekdaySyll: weekdaySyll, dateSyll: dateSyll, monthSyll: monthSyll, yearSyll: yearSyll, weekdayEng: weekdayEng, monthEng:monthEng);
    }

    static String getMonthStr(mon) {
        return months.get(mon).english
    }

    static String getMonth(mon) {
        return months.get(mon).syllabary
    }

    static String getDayOfWeek(dayofweek) {
        return daysOfWeek.get(dayofweek).english
    }

    static String getWeekday(dayofweek) {
        return daysOfWeek.get(dayofweek).syllabary
    }

    static String getDate(datum) {
        def date = EnglishNumberToWords.convert(datum)
        def month = ""
        def monthSize = 0
        def	day = ""

        if (date != 'twenty' && date != 'twenty one' && date != 'thirty one' && date != 'thirty') {
            if (date.startsWith("twenty")) {
                month = "ᏔᎵᏍᎪ "
                monthSize = 7
            } else if (date.startsWith("thirty")) {
                month = "ᏦᎣᏍᎪ "
                monthSize = 7
            }
        }

        def dateTrim = date.substring(monthSize).trim()

        day = numberMap.get(dateTrim);

        return String.format("%s %s", month, day).trim()
    }

    static String getYear(yahr) {
        def sb = new StringBuilder()
        sb << "ᏔᎵ ᎢᏯᎦᏴᎵ "

        if (yahr == 2018) {
            sb << "ᏁᎳᏚᎯ"
        } else if (yahr == 2019) {
            sb << "ᏐᎣᏁᎳᏚᎯ"
        } else if (yahr >= 2020 && yahr < 2030) {
            sb << "ᏔᎵᏍᎪᎯ "
        }

        def yahrStr = String.valueOf(yahr);

        sb << cardinalNumbers.get(yahrStr.substring(yahrStr.size() - 1).toInteger());

        return sb.toString()
    }
}