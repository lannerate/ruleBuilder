package com.flagleader.repository.e;

import com.flagleader.repository.IElement;
import com.flagleader.repository.flow.RulePoolValue;
import com.flagleader.repository.rlm.ElementTextToken;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.action.AssignJudgeToken;
import com.flagleader.repository.rlm.action.ExcuteRuleToken;
import com.flagleader.repository.rlm.action.ExeDecisionToken;
import com.flagleader.repository.rlm.action.ExeExpressionToken;
import com.flagleader.repository.rlm.action.ExeRuleToken;
import com.flagleader.repository.rlm.action.JavaStatementToken;
import com.flagleader.repository.rlm.action.MethodToken;
import com.flagleader.repository.rlm.action.NumberAssignJudgeToken;
import com.flagleader.repository.rlm.action.ReturnToken;
import com.flagleader.repository.rlm.action.StringAssignJudgeToken;
import com.flagleader.repository.rlm.condition.LogicalJudgeToken;
import com.flagleader.repository.rlm.condition.NumberJudgeToken;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rlm.value.ConstantSelectToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.MemberToken.MemberSelector;
import com.flagleader.repository.rlm.value.NumberOperatorToken;
import com.flagleader.repository.rlm.value.SheetAndFieldsSelectToken;
import com.flagleader.repository.rlm.value.SheetAndWheresSelectToken;
import com.flagleader.repository.rlm.value.SheetDynamicSelectToken;
import com.flagleader.repository.rlm.value.SheetFentanMapping;
import com.flagleader.repository.rlm.value.SheetFentanSelectToken;
import com.flagleader.repository.rlm.value.SheetFieldSelectToken;
import com.flagleader.repository.rlm.value.SheetFieldsSelectToken;
import com.flagleader.repository.rlm.value.SheetFunctionsSelectToken;
import com.flagleader.repository.rlm.value.SheetWheresSelectToken;
import com.flagleader.repository.rlm.value.StringOperatorToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.util.StringUtil;
import java.io.PrintWriter;
import java.io.StringWriter;

public class j extends m
{
  public j()
  {
  }

  public j(PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    super(paramPrintWriter, paramBoolean);
  }

  public j(PrintWriter paramPrintWriter)
  {
    super(paramPrintWriter);
  }

  public String b(IElement paramIElement)
  {
    StringWriter localStringWriter = new StringWriter();
    this.p = new PrintWriter(localStringWriter);
    c(paramIElement);
    String str = localStringWriter.toString();
    if (str.endsWith(m.q))
      return str.substring(0, str.length() - m.q.length());
    return str;
  }

  public Object visitConstantToken(ConstantToken paramConstantToken)
  {
    d("\"");
    d(paramConstantToken.getValue());
    d("\"");
    return null;
  }

  public Object visitConstantSelectToken(ConstantSelectToken paramConstantSelectToken)
  {
    d(paramConstantSelectToken.getConstantMember().getValue());
    return null;
  }

  public Object visitElementTextToken(ElementTextToken paramElementTextToken)
  {
    return super.visitElementTextToken(paramElementTextToken);
  }

  public Object visitExcuteRuleToken(ExcuteRuleToken paramExcuteRuleToken)
  {
    return super.visitExcuteRuleToken(paramExcuteRuleToken);
  }

  public Object visitExeRuleToken(ExeRuleToken paramExeRuleToken)
  {
    return super.visitExeRuleToken(paramExeRuleToken);
  }

  public Object visitJudgeToken(JudgeToken paramJudgeToken)
  {
    if (paramJudgeToken == null)
      return null;
    if ((paramJudgeToken instanceof StringOperatorToken))
      switch (paramJudgeToken.getType())
      {
      case 1:
        d("+");
      }
    else if ((paramJudgeToken instanceof StringAssignJudgeToken))
      switch (paramJudgeToken.getType())
      {
      case 0:
        d("=");
        break;
      case 1:
        d("+=");
      default:
        break;
      }
    else if ((paramJudgeToken instanceof NumberOperatorToken))
      switch (paramJudgeToken.getType())
      {
      case 1:
        d("+");
        break;
      case 2:
        d("-");
        break;
      case 3:
        d("*");
        break;
      case 4:
        d("/");
        break;
      case 5:
        d("%");
      default:
        break;
      }
    else if ((paramJudgeToken instanceof NumberJudgeToken))
      switch (paramJudgeToken.getType())
      {
      case 0:
        d("==");
        break;
      case 1:
        d("!=");
        break;
      case 2:
        d(">");
        break;
      case 3:
        d(">=");
        break;
      case 4:
        d("<");
        break;
      case 5:
        d("<=");
      default:
        break;
      }
    else if ((paramJudgeToken instanceof NumberAssignJudgeToken))
      switch (paramJudgeToken.getType())
      {
      case 0:
        d("=");
        break;
      case 1:
        d("+=");
        break;
      case 2:
        d("-=");
        break;
      case 3:
        d("*=");
        break;
      case 4:
        d("/=");
        break;
      case 5:
        d("%=");
      default:
        break;
      }
    else if ((paramJudgeToken instanceof LogicalJudgeToken))
      switch (paramJudgeToken.getType())
      {
      case 0:
        d(" || ");
        break;
      case 1:
        d(" && ");
      default:
        break;
      }
    else if ((paramJudgeToken instanceof AssignJudgeToken))
      switch (paramJudgeToken.getType())
      {
      case 0:
        d("=");
      }
    else
      d(paramJudgeToken.getDisplayName());
    return null;
  }

  public Object visitMemberSelect(MemberToken.MemberSelector paramMemberSelector)
  {
    return super.visitMemberSelect(paramMemberSelector);
  }

  public Object visitMemberToken(MemberToken paramMemberToken)
  {
    return super.visitMemberToken(paramMemberToken);
  }

  public Object visitMethodToken(MethodToken paramMethodToken)
  {
    return super.visitMethodToken(paramMethodToken);
  }

  public Object visitReturnToken(ReturnToken paramReturnToken)
  {
    return super.visitReturnToken(paramReturnToken);
  }

  public Object visitSheetAndFieldsSelectToken(SheetAndFieldsSelectToken paramSheetAndFieldsSelectToken)
  {
    return super.visitSheetAndFieldsSelectToken(paramSheetAndFieldsSelectToken);
  }

  public Object visitSheetAndWheresSelectToken(SheetAndWheresSelectToken paramSheetAndWheresSelectToken)
  {
    return super.visitSheetAndWheresSelectToken(paramSheetAndWheresSelectToken);
  }

  public Object visitSheetDynamicSelectToken(SheetDynamicSelectToken paramSheetDynamicSelectToken)
  {
    return super.visitSheetDynamicSelectToken(paramSheetDynamicSelectToken);
  }

  public Object visitSheetFentanMapping(SheetFentanMapping paramSheetFentanMapping)
  {
    return super.visitSheetFentanMapping(paramSheetFentanMapping);
  }

  public Object visitSheetFentanSelectToken(SheetFentanSelectToken paramSheetFentanSelectToken)
  {
    return super.visitSheetFentanSelectToken(paramSheetFentanSelectToken);
  }

  public Object visitSheetFieldSelectToken(SheetFieldSelectToken paramSheetFieldSelectToken)
  {
    return super.visitSheetFieldSelectToken(paramSheetFieldSelectToken);
  }

  public Object visitSheetFieldsSelectToken(SheetFieldsSelectToken paramSheetFieldsSelectToken)
  {
    return super.visitSheetFieldsSelectToken(paramSheetFieldsSelectToken);
  }

  public Object visitSheetFunctionsSelectToken(SheetFunctionsSelectToken paramSheetFunctionsSelectToken)
  {
    return super.visitSheetFunctionsSelectToken(paramSheetFunctionsSelectToken);
  }

  public Object visitSheetWheresSelectToken(SheetWheresSelectToken paramSheetWheresSelectToken)
  {
    return super.visitSheetWheresSelectToken(paramSheetWheresSelectToken);
  }

  public Object visitJavaStatementToken(JavaStatementToken paramJavaStatementToken)
  {
    String str = StringUtil.replace(m.q, "\\n", paramJavaStatementToken.getValue());
    return "java:" + str;
  }

  public Object visitValueToken(ValueToken paramValueToken)
  {
    return super.visitValueToken(paramValueToken);
  }

  public Object visitExeExpressionToken(ExeExpressionToken paramExeExpressionToken)
  {
    return super.visitExeExpressionToken(paramExeExpressionToken);
  }

  public Object visitExeDecisionToken(ExeDecisionToken paramExeDecisionToken)
  {
    return super.visitExeDecisionToken(paramExeDecisionToken);
  }

  public Object visitRulePoolValue(RulePoolValue paramRulePoolValue)
  {
    return super.visitRulePoolValue(paramRulePoolValue);
  }

  public Object visitContainer(IRuleContainer paramIRuleContainer)
  {
    return null;
  }

  public Object visitSelector(ISelectorEditen paramISelectorEditen)
  {
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.j
 * JD-Core Version:    0.6.0
 */