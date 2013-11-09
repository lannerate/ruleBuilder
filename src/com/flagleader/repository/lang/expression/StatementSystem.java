package com.flagleader.repository.lang.expression;

import com.flagleader.repository.d.u;
import com.flagleader.repository.lang.GlobalMethod;
import com.flagleader.repository.lang.d;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.condition.BooleanJudgeToken;
import com.flagleader.repository.rlm.condition.ClassJudgeToken;
import com.flagleader.repository.rlm.condition.DateJudgeToken;
import com.flagleader.repository.rlm.condition.DecisionStringJudgeToken;
import com.flagleader.repository.rlm.condition.NumberJudgeToken;
import com.flagleader.repository.rlm.condition.StringJudgeToken;
import com.flagleader.repository.rom.GlobalFunction;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExpressionRule;
import com.flagleader.repository.tree.FunctionLibrary;
import com.flagleader.repository.tree.IRule;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.util.StringUtil;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StatementSystem
{
  public static final String[] a = { "&&", "||", u.a("isNary.edit"), u.a("notNary.edit") };
  public static final String[] b = { "+=", "-=", "*=", "/=", "%=", "=", u.a("AddTo.edit"), u.a("MinusTo.edit"), u.a("MultiplyTo.edit"), u.a("DivideTo.edit"), u.a("DivTo.edit"), u.a("EqualsTo.edit") };
  public static final String[] c = { "==", "!=", ">", ">=", "<", "<=", u.a("NotEqualsTo.edit"), u.a("MoreAndEqual.edit"), u.a("notstartwith.edit"), u.a("LessAndEqual.edit"), u.a("notendwith.edit"), u.a("EqualsYear.edit"), u.a("EqualsQuarter.edit"), u.a("EqualsMonth.edit"), u.a("EqualsDay.edit"), u.a("startWith.edit"), u.a("endWith.edit"), u.a("notInclude.edit"), u.a("Include.edit"), u.a("notStringInclude.edit"), u.a("stringInclude.edit"), u.a("equalsreqular.edit"), u.a("equalsnocase.edit"), u.a("equalsnospace.edit"), u.a("equalsnopunct.edit"), u.a("equalsnoascii.edit"), u.a("equalslocalpunct.edit"), u.a("EqualsTo.edit"), u.a("MoreThan.edit"), u.a("LessThan.edit") };
  public static final String[] d = { u.a("yes.edit"), u.a("no.edit"), u.a("notExits.edit"), u.a("exits.edit"), u.a("isEmpty.edit"), u.a("notEmpty.edit"), u.a("others.edit") };
  public static final String[] e = BooleanJudgeToken.getLocalMessages();
  public static final String[] f = ClassJudgeToken.getLocalMessages();
  public static final String[] g = DateJudgeToken.getLocalMessages();
  public static final String[] h = NumberJudgeToken.getLocalMessages();
  public static final String[] i = StringJudgeToken.getLocalMessages();
  public static final String[] j = DecisionStringJudgeToken.getLocalMessages();
  public static final String[] k = { "+", "-", "*", "/", "%", u.a("AddOperator.edit"), u.a("MinusOperator.edit"), u.a("MultiplyOperator.edit"), u.a("DivideOperator.edit") };
  public static final String[] l = { u.a("thisRule.edit"), u.a("parentSet.edit"), u.a("mainSet.edit"), u.a("reStart.edit") };
  public static final String[] m = { u.a("logError.edit"), u.a("logWarning.edit"), u.a("logInfo.edit"), u.a("logDebug.edit") };
  public static final String[] n = { u.a("excuteAndExits.edit"), u.a("excuteNotExits.edit"), u.a("excuteAndExitsThread.edit"), u.a("excuteNotExitsThread.edit") };
  public static String[] o = { u.a("if.expression"), u.a("then.expression"), u.a("elseif.expression"), u.a("else.expression"), u.a("endif.expression") };
  private IRule p;
  private HashMap q;
  private h r = com.flagleader.repository.lang.b.i.d();

  public StatementSystem(IRule paramIRule)
  {
    this.p = paramIRule;
    a();
  }

  public void a(IBusinessObject paramIBusinessObject)
  {
    if (paramIBusinessObject != null)
      b().put(paramIBusinessObject.getDisplayName(), paramIBusinessObject);
  }

  public void b(IBusinessObject paramIBusinessObject)
  {
    if (paramIBusinessObject != null)
      b().remove(paramIBusinessObject.getDisplayName());
  }

  public IBusinessObject a(String paramString)
  {
    IBusinessObject localIBusinessObject1 = (IBusinessObject)b().get(paramString);
    if (localIBusinessObject1 != null)
      return localIBusinessObject1;
    IBusinessObject localIBusinessObject2 = this.p.getEnvionment().getBusinessDisName(paramString);
    if (localIBusinessObject2 == null)
    {
      d locald = this.p.getEnvionment().getMethodManager();
      Iterator localIterator = locald.a();
      while (localIterator.hasNext())
      {
        GlobalMethod localGlobalMethod = (GlobalMethod)localIterator.next();
        if (!localGlobalMethod.getDisName().equals(paramString))
          continue;
        GlobalFunction localGlobalFunction = new GlobalFunction(localGlobalMethod.getFuncName(), localGlobalMethod.getReturnType(), locald.b(localGlobalMethod), locald.c(localGlobalMethod), locald.a(localGlobalMethod), localGlobalMethod.getTypeName());
        localGlobalFunction.setVisible(true);
        this.p.getEnvionment().getFunctionLibrary().addChildElement(localGlobalFunction);
        return localGlobalFunction;
      }
    }
    return localIBusinessObject2;
  }

  public void a()
  {
    b().clear();
    Iterator localIterator1 = this.p.getEnvionment().getAcceptElements(new o(this));
    while (localIterator1.hasNext())
      a((IBusinessObject)localIterator1.next());
    if (!(this.p instanceof ExpressionRule))
    {
      Map localMap = this.p.getRelateObjectMap(null);
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        Object localObject = localIterator2.next();
        if (!(localObject instanceof IBusinessObject))
          continue;
        a((IBusinessObject)localObject);
      }
    }
  }

  public HashMap b()
  {
    if (this.q == null)
      this.q = new HashMap();
    return this.q;
  }

  public static boolean a(String paramString, String[] paramArrayOfString)
  {
    for (int i1 = 0; i1 < paramArrayOfString.length; i1++)
      if (paramString.indexOf(paramArrayOfString[i1]) >= 0)
        return true;
    return false;
  }

  public static boolean b(String paramString)
  {
    return a(paramString, k);
  }

  public boolean c(String paramString)
  {
    String[] arrayOfString = { "string", "int", "double", "boolean", "long", "short", "float", "Object", "byte", "char", "date", "time", "datetime", "decimal", "file", "string[]", "byte[]", "list", "list<list>", "map", "list<string>", "list<int>", "list<double>", "xml", "tree", "sheet", "excel", "void" };
    for (int i1 = 0; i1 < arrayOfString.length; i1++)
      if (paramString.startsWith(arrayOfString[i1]))
        return true;
    return false;
  }

  public j[] d(String paramString)
  {
    if (StringUtil.isEmpty(paramString))
      return new j[0];
    paramString = StringUtil.replace("\r", "", paramString);
    String[] arrayOfString = paramString.trim().split("[\r\n]");
    j[] arrayOfj = new j[arrayOfString.length];
    for (int i1 = 0; i1 < arrayOfj.length; i1++)
      arrayOfj[i1] = new j(this, arrayOfString[i1].trim());
    return arrayOfj;
  }

  public l e(String paramString)
  {
    paramString = StringUtil.replace("\r", "", paramString);
    for (paramString = StringUtil.replace("\t", " ", paramString); paramString.indexOf("\n ") >= 0; paramString = StringUtil.replace("\n ", "\n", paramString));
    while (paramString.indexOf(" \n") >= 0)
      paramString = StringUtil.replace(" \n", "\n", paramString);
    return new l(this, paramString);
  }

  public i[] f(String paramString)
  {
    if (StringUtil.isEmpty(paramString))
      return new i[0];
    paramString = StringUtil.replace("\r", "", paramString);
    String[] arrayOfString = paramString.trim().split("[\r\n]");
    i[] arrayOfi = new i[arrayOfString.length];
    for (int i1 = 0; i1 < arrayOfi.length; i1++)
      arrayOfi[i1] = new i(this, arrayOfString[i1].trim());
    return arrayOfi;
  }

  public j g(String paramString)
  {
    return new j(this, paramString.trim());
  }

  public k h(String paramString)
  {
    return new k(this, paramString.trim());
  }

  public static int i(String paramString)
  {
    int i1 = 0;
    for (int i2 = 0; d(paramString, i2) >= 0; i2 = d(paramString, i2) + o[0].length())
      i1++;
    return i1;
  }

  public static int a(String paramString1, String paramString2)
  {
    int i1 = 0;
    for (int i2 = 0; b(paramString1, paramString2, i2) >= 0; i2 = b(paramString1, paramString2, i2) + paramString2.length())
      i1++;
    return i1;
  }

  public static int a(String paramString, int paramInt)
  {
    return b(paramString, o[4], paramInt);
  }

  public static int b(String paramString, int paramInt)
  {
    return b(paramString, o[2], paramInt);
  }

  public static int c(String paramString, int paramInt)
  {
    return b(paramString, o[3], paramInt);
  }

  public static int d(String paramString, int paramInt)
  {
    return b(paramString, o[0], paramInt);
  }

  public static int e(String paramString, int paramInt)
  {
    return b(paramString, o[1], paramInt);
  }

  public static int a(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString1.trim();
    if ((str.startsWith(paramString2)) && (a(str.charAt(paramString2.length()))))
      return paramString1.indexOf(paramString2) + paramString2.length() + 1;
    return -1;
  }

  public static int b(String paramString1, String paramString2, int paramInt)
  {
    for (int i1 = paramString1.indexOf(paramString2, paramInt); i1 >= paramInt; i1 = paramString1.indexOf(paramString2, paramInt))
    {
      int i2 = i1 + paramString2.length();
      if (((i1 == paramInt) || (a(paramString1.charAt(i1 - 1)))) && ((i2 == paramString1.length()) || (a(paramString1.charAt(i2)))))
        break;
      paramInt = i2;
    }
    return i1;
  }

  public static boolean a(char paramChar)
  {
    return Character.isWhitespace(paramChar);
  }

  public static void main(String[] paramArrayOfString)
  {
    System.out.println(d("如果 sdf=sdf then sdfdsf=100 endif", 0));
    Envionment localEnvionment = Envionment.getEmptyEnvionment();
    localEnvionment.getValueLibrary().addChildElement(new MappingVariable("test", "测试", "double"));
    localEnvionment.getValueLibrary().addChildElement(new MappingVariable("test1", "测试1", "double"));
  }

  public IRule c()
  {
    return this.p;
  }

  public h d()
  {
    return this.r;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.StatementSystem
 * JD-Core Version:    0.6.0
 */