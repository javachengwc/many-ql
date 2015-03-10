package org.uva.qls.ast.builder;

import java.util.ArrayList;

import org.uva.ql.ast.QLNode;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.qls.antlr.QLSBaseVisitor;
import org.uva.qls.antlr.QLSParser.CheckboxContext;
import org.uva.qls.antlr.QLSParser.DropdownContext;
import org.uva.qls.antlr.QLSParser.FontContext;
import org.uva.qls.antlr.QLSParser.PageBlockContext;
import org.uva.qls.antlr.QLSParser.PageContext;
import org.uva.qls.antlr.QLSParser.QuestionContext;
import org.uva.qls.antlr.QLSParser.RadioContext;
import org.uva.qls.antlr.QLSParser.RgbContext;
import org.uva.qls.antlr.QLSParser.SectionContext;
import org.uva.qls.antlr.QLSParser.SheetContext;
import org.uva.qls.antlr.QLSParser.SliderContext;
import org.uva.qls.antlr.QLSParser.SpinboxContext;
import org.uva.qls.antlr.QLSParser.StyleContext;
import org.uva.qls.antlr.QLSParser.StylingContext;
import org.uva.qls.antlr.QLSParser.TextboxContext;
import org.uva.qls.antlr.QLSParser.TypeContext;
import org.uva.qls.ast.Page;
import org.uva.qls.ast.Question;
import org.uva.qls.ast.Sheet;
import org.uva.qls.ast.style.Style;
import org.uva.utility.CodePosition;

public class QLSImplVisitor extends QLSBaseVisitor<QLNode> {

	@Override
	public QLNode visitSlider(SliderContext ctx) {

		return super.visitSlider(ctx);
	}

	@Override
	public QLNode visitFont(FontContext ctx) {
		return super.visitFont(ctx);
	}

	@Override
	public QLNode visitRgb(RgbContext ctx) {
		return super.visitRgb(ctx);
	}

	@Override
	public QLNode visitType(TypeContext ctx) {
		return super.visitType(ctx);
	}

	@Override
	public QLNode visitDropdown(DropdownContext ctx) {
		return super.visitDropdown(ctx);
	}

	@Override
	public QLNode visitSpinbox(SpinboxContext ctx) {
		return super.visitSpinbox(ctx);
	}

	@Override
	public QLNode visitSection(SectionContext ctx) {
		return super.visitSection(ctx);
	}

	@Override
	public QLNode visitTextbox(TextboxContext ctx) {
		return super.visitTextbox(ctx);
	}

	@Override
	public QLNode visitPageBlock(PageBlockContext ctx) {
		return super.visitPageBlock(ctx);
	}

	@Override
	public QLNode visitStyle(StyleContext ctx) {
		return super.visitStyle(ctx);
	}

	@Override
	public QLNode visitPage(PageContext ctx) {
		return super.visitPage(ctx);
	}

	@Override
	public QLNode visitCheckbox(CheckboxContext ctx) {

		return super.visitCheckbox(ctx);
	}

	@Override
	public QLNode visitRadio(RadioContext ctx) {
		return super.visitRadio(ctx);
	}

	@Override
	public QLNode visitQuestion(QuestionContext ctx) {
		Identifier identifier = new Identifier(ctx.Identifier().getText(), CodePosition.getCodePosition(ctx));
		Question question = new Question(identifier);
		return super.visitQuestion(ctx);
	}

	@Override
	public QLNode visitStyling(StylingContext ctx) {
		Style style = new Style();
		return style;
	}

	@Override
	public QLNode visitSheet(SheetContext ctx) {
		Identifier identifier = new Identifier(ctx.Identifier().getText(), CodePosition.getCodePosition(ctx));
		Sheet sheet = new Sheet(identifier);
		ArrayList<Page> pages = (ArrayList<Page>) ctx.accept(this);
		return sheet;
	}

}
