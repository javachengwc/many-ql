// Generated from QLS.g4 by ANTLR 4.4
package org.uva.qls.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLSLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STYLE=1, PAGE=2, SECTION=3, QUESTION=4, WIDGET=5, SLIDER=6, SPINBOX=7, 
		TEXT=8, RADIO=9, DROPDOWN=10, CHECKBOX=11, WIDTH=12, HEIGHT=13, FONTSIZE=14, 
		FONT=15, COLOR=16, ARIAL=17, COLON=18, COMMA=19, LEFT_PAREN=20, RIGHT_PAREN=21, 
		LEFT_BRACE=22, RIGHT_BRACE=23, LEFT_BRACKET=24, RIGHT_BRACKET=25, NewLine=26, 
		IntegerLiteral=27, BooleanLiteral=28, StringLiteral=29, WhiteSpace=30, 
		MultiComment=31, SingleComment=32, Identifier=33, RgbValue=34;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'"
	};
	public static final String[] ruleNames = {
		"STYLE", "PAGE", "SECTION", "QUESTION", "WIDGET", "SLIDER", "SPINBOX", 
		"TEXT", "RADIO", "DROPDOWN", "CHECKBOX", "WIDTH", "HEIGHT", "FONTSIZE", 
		"FONT", "COLOR", "ARIAL", "COLON", "COMMA", "LEFT_PAREN", "RIGHT_PAREN", 
		"LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", "RIGHT_BRACKET", "NewLine", 
		"IntegerLiteral", "BooleanLiteral", "StringLiteral", "WhiteSpace", "MultiComment", 
		"SingleComment", "Identifier", "RgbValue"
	};


	public QLSLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QLS.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2$\u0120\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3"+
		"\32\3\32\3\33\3\33\3\33\3\34\3\34\7\34\u00d9\n\34\f\34\16\34\u00dc\13"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00e7\n\35\3\36"+
		"\3\36\3\36\3\36\7\36\u00ed\n\36\f\36\16\36\u00f0\13\36\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \7 \u00fc\n \f \16 \u00ff\13 \3 \3 \3 \3 \3"+
		" \3!\3!\3!\3!\7!\u010a\n!\f!\16!\u010d\13!\3!\3!\3!\3!\3\"\3\"\7\"\u0115"+
		"\n\"\f\"\16\"\u0118\13\"\3#\3#\7#\u011c\n#\f#\16#\u011f\13#\4\u00fd\u010b"+
		"\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$\3\2\b\3\2\63;\3\2\62;\5\2\f\f\17\17$$\5\2\13\f\17\17\""+
		"\"\4\2C\\c|\6\2\62;C\\aac|\u0127\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5M\3\2\2\2\7R\3\2\2\2\tZ\3\2\2\2\13"+
		"c\3\2\2\2\rj\3\2\2\2\17q\3\2\2\2\21y\3\2\2\2\23~\3\2\2\2\25\u008a\3\2"+
		"\2\2\27\u0093\3\2\2\2\31\u009c\3\2\2\2\33\u00a2\3\2\2\2\35\u00a9\3\2\2"+
		"\2\37\u00b2\3\2\2\2!\u00b7\3\2\2\2#\u00bd\3\2\2\2%\u00c3\3\2\2\2\'\u00c5"+
		"\3\2\2\2)\u00c7\3\2\2\2+\u00c9\3\2\2\2-\u00cb\3\2\2\2/\u00cd\3\2\2\2\61"+
		"\u00cf\3\2\2\2\63\u00d1\3\2\2\2\65\u00d3\3\2\2\2\67\u00d6\3\2\2\29\u00e6"+
		"\3\2\2\2;\u00e8\3\2\2\2=\u00f3\3\2\2\2?\u00f7\3\2\2\2A\u0105\3\2\2\2C"+
		"\u0112\3\2\2\2E\u0119\3\2\2\2GH\7u\2\2HI\7v\2\2IJ\7{\2\2JK\7n\2\2KL\7"+
		"g\2\2L\4\3\2\2\2MN\7r\2\2NO\7c\2\2OP\7i\2\2PQ\7g\2\2Q\6\3\2\2\2RS\7u\2"+
		"\2ST\7g\2\2TU\7e\2\2UV\7v\2\2VW\7k\2\2WX\7q\2\2XY\7p\2\2Y\b\3\2\2\2Z["+
		"\7s\2\2[\\\7w\2\2\\]\7g\2\2]^\7u\2\2^_\7v\2\2_`\7k\2\2`a\7q\2\2ab\7p\2"+
		"\2b\n\3\2\2\2cd\7y\2\2de\7k\2\2ef\7f\2\2fg\7i\2\2gh\7g\2\2hi\7v\2\2i\f"+
		"\3\2\2\2jk\7u\2\2kl\7n\2\2lm\7k\2\2mn\7f\2\2no\7g\2\2op\7t\2\2p\16\3\2"+
		"\2\2qr\7u\2\2rs\7r\2\2st\7k\2\2tu\7p\2\2uv\7d\2\2vw\7q\2\2wx\7z\2\2x\20"+
		"\3\2\2\2yz\7v\2\2z{\7g\2\2{|\7z\2\2|}\7v\2\2}\22\3\2\2\2~\177\7t\2\2\177"+
		"\u0080\7c\2\2\u0080\u0081\7f\2\2\u0081\u0082\7k\2\2\u0082\u0083\7q\2\2"+
		"\u0083\u0084\7d\2\2\u0084\u0085\7w\2\2\u0085\u0086\7v\2\2\u0086\u0087"+
		"\7v\2\2\u0087\u0088\7q\2\2\u0088\u0089\7p\2\2\u0089\24\3\2\2\2\u008a\u008b"+
		"\7f\2\2\u008b\u008c\7t\2\2\u008c\u008d\7q\2\2\u008d\u008e\7r\2\2\u008e"+
		"\u008f\7f\2\2\u008f\u0090\7q\2\2\u0090\u0091\7y\2\2\u0091\u0092\7p\2\2"+
		"\u0092\26\3\2\2\2\u0093\u0094\7e\2\2\u0094\u0095\7j\2\2\u0095\u0096\7"+
		"g\2\2\u0096\u0097\7e\2\2\u0097\u0098\7m\2\2\u0098\u0099\7d\2\2\u0099\u009a"+
		"\7q\2\2\u009a\u009b\7z\2\2\u009b\30\3\2\2\2\u009c\u009d\7y\2\2\u009d\u009e"+
		"\7k\2\2\u009e\u009f\7f\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1\7j\2\2\u00a1"+
		"\32\3\2\2\2\u00a2\u00a3\7j\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7k\2\2\u00a5"+
		"\u00a6\7i\2\2\u00a6\u00a7\7j\2\2\u00a7\u00a8\7v\2\2\u00a8\34\3\2\2\2\u00a9"+
		"\u00aa\7h\2\2\u00aa\u00ab\7q\2\2\u00ab\u00ac\7p\2\2\u00ac\u00ad\7v\2\2"+
		"\u00ad\u00ae\7U\2\2\u00ae\u00af\7k\2\2\u00af\u00b0\7|\2\2\u00b0\u00b1"+
		"\7g\2\2\u00b1\36\3\2\2\2\u00b2\u00b3\7h\2\2\u00b3\u00b4\7q\2\2\u00b4\u00b5"+
		"\7p\2\2\u00b5\u00b6\7v\2\2\u00b6 \3\2\2\2\u00b7\u00b8\7e\2\2\u00b8\u00b9"+
		"\7q\2\2\u00b9\u00ba\7n\2\2\u00ba\u00bb\7q\2\2\u00bb\u00bc\7t\2\2\u00bc"+
		"\"\3\2\2\2\u00bd\u00be\7c\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7k\2\2\u00c0"+
		"\u00c1\7c\2\2\u00c1\u00c2\7n\2\2\u00c2$\3\2\2\2\u00c3\u00c4\7<\2\2\u00c4"+
		"&\3\2\2\2\u00c5\u00c6\7.\2\2\u00c6(\3\2\2\2\u00c7\u00c8\7*\2\2\u00c8*"+
		"\3\2\2\2\u00c9\u00ca\7+\2\2\u00ca,\3\2\2\2\u00cb\u00cc\7}\2\2\u00cc.\3"+
		"\2\2\2\u00cd\u00ce\7\177\2\2\u00ce\60\3\2\2\2\u00cf\u00d0\7]\2\2\u00d0"+
		"\62\3\2\2\2\u00d1\u00d2\7_\2\2\u00d2\64\3\2\2\2\u00d3\u00d4\7\f\2\2\u00d4"+
		"\u00d5\7\13\2\2\u00d5\66\3\2\2\2\u00d6\u00da\t\2\2\2\u00d7\u00d9\t\3\2"+
		"\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db"+
		"\3\2\2\2\u00db8\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\7v\2\2\u00de\u00df"+
		"\7t\2\2\u00df\u00e0\7w\2\2\u00e0\u00e7\7g\2\2\u00e1\u00e2\7h\2\2\u00e2"+
		"\u00e3\7c\2\2\u00e3\u00e4\7n\2\2\u00e4\u00e5\7u\2\2\u00e5\u00e7\7g\2\2"+
		"\u00e6\u00dd\3\2\2\2\u00e6\u00e1\3\2\2\2\u00e7:\3\2\2\2\u00e8\u00ee\7"+
		"$\2\2\u00e9\u00ed\n\4\2\2\u00ea\u00eb\7$\2\2\u00eb\u00ed\7$\2\2\u00ec"+
		"\u00e9\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2"+
		"\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1"+
		"\u00f2\7$\2\2\u00f2<\3\2\2\2\u00f3\u00f4\t\5\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f6\b\37\2\2\u00f6>\3\2\2\2\u00f7\u00f8\7\61\2\2\u00f8\u00f9\7,\2\2"+
		"\u00f9\u00fd\3\2\2\2\u00fa\u00fc\13\2\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00ff"+
		"\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u0100\u0101\7,\2\2\u0101\u0102\7\61\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u0104\b \2\2\u0104@\3\2\2\2\u0105\u0106\7\61\2\2\u0106\u0107"+
		"\7\61\2\2\u0107\u010b\3\2\2\2\u0108\u010a\13\2\2\2\u0109\u0108\3\2\2\2"+
		"\u010a\u010d\3\2\2\2\u010b\u010c\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010e"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u010f\7\f\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\u0111\b!\2\2\u0111B\3\2\2\2\u0112\u0116\t\6\2\2\u0113\u0115\t\7\2\2\u0114"+
		"\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2"+
		"\2\2\u0117D\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011d\7%\2\2\u011a\u011c"+
		"\t\3\2\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011eF\3\2\2\2\u011f\u011d\3\2\2\2\13\2\u00da\u00e6\u00ec"+
		"\u00ee\u00fd\u010b\u0116\u011d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}