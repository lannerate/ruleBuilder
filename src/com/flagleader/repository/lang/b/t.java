package com.flagleader.repository.lang.b;

import com.flagleader.repository.lang.c;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.action.ExcuteRuleToken;
import com.flagleader.repository.rlm.action.ExeRuleToken;
import com.flagleader.repository.rlm.action.PackageFieldGet;
import com.flagleader.repository.rlm.action.PackageFieldSet;
import com.flagleader.repository.rlm.action.SelectRulePackageToken;
import com.flagleader.repository.rlm.condition.BooleanJudgeToken;
import com.flagleader.repository.rlm.condition.ClassJudgeToken;
import com.flagleader.repository.rlm.condition.DateJudgeToken;
import com.flagleader.repository.rlm.condition.DecimalJudgeToken;
import com.flagleader.repository.rlm.condition.StringJudgeToken;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IJudgeToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.value.MemberPropertyToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.RulePackage;
import java.io.PrintWriter;
import java.util.List;

public class t extends j
  implements c
{
  public t()
  {
  }

  public t(PrintWriter paramPrintWriter)
  {
    super(paramPrintWriter);
  }

  protected String a(String paramString)
  {
    return paramString;
  }

  protected String a(char paramChar)
  {
    return paramChar;
  }

  public Object visitExeRuleToken(ExeRuleToken paramExeRuleToken)
  {
    if ((paramExeRuleToken == null) || (paramExeRuleToken.getRuleNameToken() == null) || (paramExeRuleToken.getRuleNameToken().getExeRuleName().length() == 0))
      return null;
    d("RuleEngine engine = RuleEngineFactory.newInstance().getRuleEngine() ;");
    c();
    List localList = paramExeRuleToken.getRuleNameToken().getSelectedFields();
    for (int i = 0; i < localList.size(); i++)
    {
      localObject1 = (PackageFieldGet)localList.get(i);
      l();
      d("engine.put(\"" + ((PackageFieldGet)localObject1).getFuncName() + "\", ");
      ((PackageFieldGet)localObject1).getAssignValue().acceptVisitor(this);
      d(") ;");
      c();
    }
    String str = paramExeRuleToken.getRuleNameToken().getExeRuleName();
    Object localObject1 = "\"" + paramExeRuleToken.getRuleNameToken().getExeRuleName() + "\"";
    Object localObject2;
    if ((str.startsWith("{")) && (str.endsWith("}")))
    {
      localObject2 = paramExeRuleToken.getEnvionment().getBusinessDisName(str.substring(1, str.length() - 1));
      if (localObject2 != null)
        localObject1 = ((IBusinessObject)localObject2).getVarValue();
    }
    if (paramExeRuleToken.getReturnType() == 0)
    {
      if ((this.e != null) && (this.e.getMainVersion().length() > 0))
        e("engine.excute(" + (String)localObject1 + ",\"" + this.e.getMainVersion() + "\") ;");
      else
        e("engine.excute(" + (String)localObject1 + ") ;");
    }
    else if (paramExeRuleToken.getReturnType() == 2)
    {
      if ((this.e != null) && (this.e.getMainVersion().length() > 0))
        e("engine.excuteSynchronized(" + (String)localObject1 + ",\"" + this.e.getMainVersion() + "\") ;");
      else
        e("engine.excuteSynchronized(" + (String)localObject1 + ") ;");
    }
    else if (paramExeRuleToken.getReturnType() == 3)
    {
      if ((this.e != null) && (this.e.getMainVersion().length() > 0))
        e("engine.excuteExistSynchronized(" + (String)localObject1 + ",\"" + this.e.getMainVersion() + "\") ;");
      else
        e("engine.excuteExistSynchronized(" + (String)localObject1 + ") ;");
    }
    else if ((this.e != null) && (this.e.getMainVersion().length() > 0))
      e("engine.excuteExits(" + (String)localObject1 + ",\"" + this.e.getMainVersion() + "\") ;");
    else
      e("engine.excuteExits(" + (String)localObject1 + ") ;");
    if ((paramExeRuleToken.getReturnType() == 1) || (paramExeRuleToken.getReturnType() == 0))
    {
      localObject2 = paramExeRuleToken.getRuleNameToken().getSelectedWheres();
      for (int j = 0; j < ((List)localObject2).size(); j++)
      {
        PackageFieldSet localPackageFieldSet = (PackageFieldSet)((List)localObject2).get(j);
        IVariableObject localIVariableObject = localPackageFieldSet.getAssignValue().getVariableElement();
        if (localIVariableObject == null)
          continue;
        Object localObject3;
        if ((localIVariableObject instanceof IPropertyObject))
        {
          localObject3 = (IPropertyObject)localIVariableObject;
          l();
          d(((IPropertyObject)localObject3).getSetMethodPreName());
          g localg = localIVariableObject.getJavaType();
          if (localg.m())
            d("engine.getString(\"" + localPackageFieldSet.getFuncName() + "\") ");
          else if (localg.e())
            d("engine.getBoolean(\"" + localPackageFieldSet.getFuncName() + "\") ");
          else if (localg.d())
            d("engine.getChar(\"" + localPackageFieldSet.getFuncName() + "\") ");
          else if (localg.g())
            d("engine.getShort(\"" + localPackageFieldSet.getFuncName() + "\") ");
          else if (localg.k())
            d("engine.getInteger(\"" + localPackageFieldSet.getFuncName() + "\")");
          else if (localg.h())
            d("engine.getLong(\"" + localPackageFieldSet.getFuncName() + "\") ");
          else if (localg.c())
            d("engine.getFloat(\"" + localPackageFieldSet.getFuncName() + "\") ");
          else if (localg.i())
            d("engine.getDouble(\"" + localPackageFieldSet.getFuncName() + "\") ");
          else
            d("(" + o.b(localg) + ")engine.get(\"" + localPackageFieldSet.getFuncName() + "\") ");
          d(((IPropertyObject)localObject3).getSetMethodSufName() + ";");
          c();
        }
        else
        {
          localPackageFieldSet.getAssignValue().acceptVisitor(this);
          d(" = ");
          localObject3 = localIVariableObject.getJavaType();
          if (((g)localObject3).m())
            d("engine.getString(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          else if (((g)localObject3).e())
            d("engine.getBoolean(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          else if (((g)localObject3).d())
            d("engine.getChar(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          else if (((g)localObject3).g())
            d("engine.getShort(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          else if (((g)localObject3).k())
            d("engine.getInteger(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          else if (((g)localObject3).h())
            d("engine.getLong(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          else if (((g)localObject3).c())
            d("engine.getFloat(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          else if (((g)localObject3).i())
            d("engine.getDouble(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          else
            d("(" + o.b((g)localObject3) + ")engine.get(\"" + localPackageFieldSet.getFuncName() + "\") ;");
          c();
        }
      }
    }
    return null;
  }

  public Object visitExcuteRuleToken(ExcuteRuleToken paramExcuteRuleToken)
  {
    if ((paramExcuteRuleToken == null) || (paramExcuteRuleToken.getRuleNameToken().toString().length() == 0))
      return null;
    c();
    l();
    if (paramExcuteRuleToken.getReturnType() == 0)
      d("RuleEngineFactory.newInstance().getRuleEngine().excute(dtcObjects,class_objects,");
    else if (paramExcuteRuleToken.getReturnType() == 1)
      d("RuleEngineFactory.newInstance().getRuleEngine().excuteExits(dtcObjects,class_objects,");
    else if (paramExcuteRuleToken.getReturnType() == 2)
      d("new RuleServerPoolFactory().getRuleService().execute(dtcObjects,");
    else if (paramExcuteRuleToken.getReturnType() == 3)
      d("new RuleSoapFactory().getRuleService().execute(dtcObjects,");
    d(paramExcuteRuleToken.getRuleNameToken());
    d(",");
    d(paramExcuteRuleToken.getRuleVersionToken());
    d(") ;");
    c();
    return null;
  }

  protected void a(IConditionToken paramIConditionToken)
  {
    if ((paramIConditionToken.getCompareOperator() instanceof StringJudgeToken))
    {
      String str = "";
      switch (paramIConditionToken.getCompareOperator().getType())
      {
      case 0:
        b(paramIConditionToken);
        break;
      case 1:
        d(paramIConditionToken);
        break;
      case 2:
        c(paramIConditionToken);
        break;
      case 3:
        e(paramIConditionToken);
        break;
      case 4:
        f(paramIConditionToken);
        break;
      case 5:
        h(paramIConditionToken);
        break;
      case 6:
        d(paramIConditionToken.getFirstValue());
        d(" != null ");
        break;
      case 7:
        d(paramIConditionToken.getFirstValue());
        d(" == null ");
        break;
      case 9:
        d("(");
        d(paramIConditionToken.getFirstValue());
        d(" == null || ");
        d(paramIConditionToken.getFirstValue());
        d(".length() == 0 ");
        d(")");
        break;
      case 8:
        d("(");
        d(paramIConditionToken.getFirstValue());
        d(" != null && ");
        d(paramIConditionToken.getFirstValue());
        d(".length() > 0 ");
        d(")");
        break;
      case 10:
        p(paramIConditionToken);
        break;
      case 11:
        q(paramIConditionToken);
        break;
      case 13:
        g(paramIConditionToken);
        break;
      case 14:
        i(paramIConditionToken);
        break;
      case 15:
        j(paramIConditionToken);
        break;
      case 16:
        k(paramIConditionToken);
        break;
      case 17:
        l(paramIConditionToken);
        break;
      case 19:
        o(paramIConditionToken);
        break;
      case 18:
        m(paramIConditionToken);
        break;
      case 20:
        n(paramIConditionToken);
      case 12:
      default:
        break;
      }
    }
    else if ((paramIConditionToken.getCompareOperator() instanceof ClassJudgeToken))
    {
      d(paramIConditionToken.getFirstValue());
      if (paramIConditionToken.getCompareOperator().getType() == 0)
        d(" != null ");
      else if (paramIConditionToken.getCompareOperator().getType() == 1)
        d(" == null ");
    }
    else if ((paramIConditionToken.getCompareOperator() instanceof BooleanJudgeToken))
    {
      d(paramIConditionToken.getFirstValue());
      if (paramIConditionToken.getCompareOperator().getType() == 1)
        d(" == false ");
    }
    else if ((paramIConditionToken.getCompareOperator() instanceof DateJudgeToken))
    {
      if (paramIConditionToken.getCompareOperator().getType() == 6)
      {
        d(paramIConditionToken.getFirstValue());
        d(" != null ");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 7)
      {
        d(paramIConditionToken.getFirstValue());
        d(" == null ");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 0)
      {
        d(paramIConditionToken.getFirstValue());
        d(" == ");
        d(paramIConditionToken.getComparedValue());
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 1)
      {
        d(paramIConditionToken.getFirstValue());
        d(" != ");
        d(paramIConditionToken.getComparedValue());
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 5)
      {
        d(paramIConditionToken.getFirstValue());
        d(" <= ");
        d(paramIConditionToken.getComparedValue());
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 4)
      {
        d(paramIConditionToken.getFirstValue());
        d(" < ");
        d(paramIConditionToken.getComparedValue());
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 3)
      {
        d(paramIConditionToken.getFirstValue());
        d(" >= ");
        d(paramIConditionToken.getComparedValue());
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 2)
      {
        d(paramIConditionToken.getFirstValue());
        d(" > ");
        d(paramIConditionToken.getComparedValue());
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 8)
      {
        d(" DateUtil.equalsYear(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d("," + paramIConditionToken.getDatenulltype() + ")");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 9)
      {
        d(" DateUtil.equalsQuarter(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d("," + paramIConditionToken.getDatenulltype() + ")");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 10)
      {
        d(" DateUtil.equalsMonth(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d("," + paramIConditionToken.getDatenulltype() + ")");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 11)
      {
        d(" DateUtil.equalsDate(");
        d(paramIConditionToken.getFirstValue());
        d(", ");
        d(paramIConditionToken.getComparedValue());
        d("," + paramIConditionToken.getDatenulltype() + ")");
      }
    }
    else if ((paramIConditionToken.getCompareOperator() instanceof DecimalJudgeToken))
    {
      if (paramIConditionToken.getCompareOperator().getType() == 6)
      {
        d(paramIConditionToken.getFirstValue());
        d(" != null ");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 7)
      {
        d(paramIConditionToken.getFirstValue());
        d(" == null ");
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 0)
      {
        d(paramIConditionToken.getFirstValue());
        d(" == ");
        d(paramIConditionToken.getComparedValue());
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 1)
      {
        d(paramIConditionToken.getFirstValue());
        d(" != ");
        d(paramIConditionToken.getComparedValue());
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 5)
      {
        d(paramIConditionToken.getFirstValue());
        d(" <= ");
        d(paramIConditionToken.getComparedValue());
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 4)
      {
        d(paramIConditionToken.getFirstValue());
        d(" < ");
        d(paramIConditionToken.getComparedValue());
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 3)
      {
        d(paramIConditionToken.getFirstValue());
        d(" >= ");
        d(paramIConditionToken.getComparedValue());
      }
      else if (paramIConditionToken.getCompareOperator().getType() == 2)
      {
        d(paramIConditionToken.getFirstValue());
        d(" > ");
        d(paramIConditionToken.getComparedValue());
      }
    }
    else
    {
      d(paramIConditionToken.getFirstValue());
      d(paramIConditionToken.getCompareOperator());
      d(paramIConditionToken.getComparedValue());
    }
  }

  protected void a(IConditionToken paramIConditionToken, String paramString)
  {
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" StringUtil." + paramString + "NoCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") ");
    }
    else
    {
      d(" StringUtil." + paramString + "(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") ");
    }
  }

  protected void b(IConditionToken paramIConditionToken)
  {
    d("( ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(paramIConditionToken.getFirstValue());
      d(" == ");
      d(paramIConditionToken.getComparedValue());
      d(" )");
    }
    else
    {
      d(paramIConditionToken.getFirstValue());
      d(" == ");
      d(paramIConditionToken.getComparedValue());
      d(" )");
    }
  }

  protected void c(IConditionToken paramIConditionToken)
  {
    d("( ");
    a(paramIConditionToken, "indexOf");
    d(")");
  }

  protected void d(IConditionToken paramIConditionToken)
  {
    d("( ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(paramIConditionToken.getFirstValue());
      d(" != ");
      d(paramIConditionToken.getComparedValue());
      d(" )");
    }
    else
    {
      d(paramIConditionToken.getFirstValue());
      d(" != ");
      d(paramIConditionToken.getComparedValue());
      d(" )");
    }
  }

  protected void e(IConditionToken paramIConditionToken)
  {
    d("( ");
    d(" !");
    a(paramIConditionToken, "indexOf");
    d(")");
  }

  protected void f(IConditionToken paramIConditionToken)
  {
    d("( ");
    a(paramIConditionToken, "startsWith");
    d(")");
  }

  protected void g(IConditionToken paramIConditionToken)
  {
    d("( ");
    d(" !");
    a(paramIConditionToken, "startsWith");
    d(")");
  }

  protected void h(IConditionToken paramIConditionToken)
  {
    d("( ");
    a(paramIConditionToken, "endsWith");
    d(")");
  }

  protected void i(IConditionToken paramIConditionToken)
  {
    d("( ");
    d(" !");
    a(paramIConditionToken, "endsWith");
    d(")");
  }

  protected void j(IConditionToken paramIConditionToken)
  {
    d("( ");
    d(paramIConditionToken.getFirstValue());
    d(" != null && ");
    d(paramIConditionToken.getComparedValue());
    d(" != null && ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" StringUtil.equalsRegular(");
      d(paramIConditionToken.getFirstValue());
      d(".toLowerCase() , ");
      d(paramIConditionToken.getComparedValue());
      d(".toLowerCase()) )");
    }
    else
    {
      d(" StringUtil.equalsRegular(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
  }

  protected void k(IConditionToken paramIConditionToken)
  {
    d("( ");
    d(paramIConditionToken.getFirstValue());
    d(" == ");
    d(paramIConditionToken.getComparedValue());
    d(" )");
  }

  protected void l(IConditionToken paramIConditionToken)
  {
    d("( ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" StringUtil.equalsNoSpaceNoCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
    else
    {
      d(" StringUtil.equalsNoSpace(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
  }

  protected void m(IConditionToken paramIConditionToken)
  {
    d("( ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" StringUtil.equalsNoPunctNoCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
    else
    {
      d(" StringUtil.equalsNoPunct(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
  }

  protected void n(IConditionToken paramIConditionToken)
  {
    d("( ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" StringUtil.equalsLocalPunctNoCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
    else
    {
      d(" StringUtil.equalsLocalPunct(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
  }

  protected void o(IConditionToken paramIConditionToken)
  {
    d("( ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" StringUtil.equalsNoSpaceNoCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
    else
    {
      d(" StringUtil.equalsNoAscii(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
  }

  protected void p(IConditionToken paramIConditionToken)
  {
    d("( ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" ListUtil.checkExitsNoCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
    else
    {
      d(" ListUtil.checkExits(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
  }

  protected void q(IConditionToken paramIConditionToken)
  {
    d("( ");
    d(paramIConditionToken.getFirstValue());
    d(" == null || ");
    if ((paramIConditionToken.getRoot() != null) && (paramIConditionToken.isIgniorString()))
    {
      d(" !ListUtil.checkExitsNoCase(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
    else
    {
      d(" !ListUtil.checkExits(");
      d(paramIConditionToken.getFirstValue());
      d(" , ");
      d(paramIConditionToken.getComparedValue());
      d(") )");
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.b.t
 * JD-Core Version:    0.6.0
 */