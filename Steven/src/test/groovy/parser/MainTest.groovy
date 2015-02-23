package parser

import parser.nodes.Form
import spock.lang.Specification

/**
 * Created by Steven Kok on 17/02/2015.
 */
class MainTest extends Specification {
    public static final String PATH_TO_INPUT_FILE = "src/main/antlr/input/QL_initial"
    Main parseTreeWalker

    def setup() {
        parseTreeWalker = new Main()
    }

    def "Walker should throw exception when providing wrong path"() {
        when:
        parseTreeWalker.walk(path, new ParseTreeWalker(), Form.class)

        then:
        thrown(thrownClass)

        where:
        path                    | thrownClass
        "src/main/antlr/input/" | IOException.class
        "QL_initial"            | IOException.class
        ""                      | IOException.class
        " "                     | IOException.class
    }

    def "Walker shouldn't throw exception when provided correct path"() {
        when:
        parseTreeWalker.walk(PATH_TO_INPUT_FILE, new ParseTreeWalker(), Form.class)

        then:
        noExceptionThrown()
    }

    def "Walker should return a populated list"() {
        when:
        Form form = parseTreeWalker.walk(PATH_TO_INPUT_FILE, new ParseTreeWalker(), Form.class)

        then:
        !form.getElements().empty

    }
}
