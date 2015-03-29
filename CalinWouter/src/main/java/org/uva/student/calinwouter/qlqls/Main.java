package org.uva.student.calinwouter.qlqls;

import org.uva.student.calinwouter.qlqls.ql.gui.QLGUI;
import org.uva.student.calinwouter.qlqls.ql.helper.QLHelper;
import org.uva.student.calinwouter.qlqls.qls.gui.QLSGUI;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.qls.helper.QLSHelper;
import org.uva.student.calinwouter.qlqls.qls.model.components.StyleSheet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// TODO refactor!
public class Main {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private static String readFile(String filename) throws IOException {
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(filename));
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(LINE_SEPARATOR);
            }
            return stringBuilder.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    private static void executeQl(String ql) {
        try {
            TypeCheckResults typeCheckResults = QLHelper.typeCheckString(ql);
            System.out.println(typeCheckResults.toString());
            if(!typeCheckResults.hasErrors()) {
                StaticFields staticFields = QLHelper.analyzeQlString(ql);
                QLInterpreter qlIntepreter = QLHelper.interpretQlString(ql);
                QLGUI qui = new QLGUI(qlIntepreter, qlIntepreter.interpret(new VariableTable()), staticFields);
                qui.render();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void executeQlQls(String ql, String qls) {
        try {
            StaticFields staticFields = QLHelper.analyzeQlString(ql);
            QLInterpreter qlIntepreter = QLHelper.interpretQlString(ql);
            StyleSheet styleSheet = QLSHelper.interpetStylesheetString(qls);
            new QLSGUI(styleSheet, qlIntepreter, qlIntepreter.interpret(new VariableTable()), staticFields).render();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String currentLocation = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String ql = readFile(currentLocation + "../../src/main/resources/ql.txt");
        String qls = readFile(currentLocation + "../../src/main/resources/qls.txt");
        executeQlQls(ql, qls);
        executeQl(ql);
    }

}