package net.cherokeedictionary.dateTime

import spock.lang.Specification

class CherokeeDateTimeTest extends Specification {
    def "someLibraryMethod returns true"() {
        setup:
        def cherokeeDateTime = new CherokeeDateTimeProcessor()

        when:
          def result = CherokeeDateTimeProcessor.getMonth(0)
//        def result = lib.someLibraryMethod()

        then:
            result == 'ᎤᏃᎸᏔᎾ'
    }
}
