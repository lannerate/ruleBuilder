package com.flagleader.repository.e;

import I;
import com.flagleader.repository.IElement;
import com.flagleader.repository.d.u;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IJudgeToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.DecisionElement;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExpressionRule;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRule;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RuleMirror;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.repository.tree.RuleSetFlow;
import com.flagleader.repository.tree.RuleTreeFlow;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class l extends m
{
  private IRuleSet b = null;
  private static String c = "";
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private HashMap h = new HashMap();
  private int i = 0;
  StringBuffer a = new StringBuffer();
  private int j = 0;
  private int k = 0;
  private int[] l = null;
  private List m = new ArrayList();
  private String n = "";

  static
  {
    try
    {
      c = FileUtil.readFromStream(l.class.getClassLoader().getResourceAsStream("svgHeader.html"));
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public l()
  {
  }

  public l(PrintWriter paramPrintWriter)
  {
    super(paramPrintWriter);
  }

  public l(PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    super(paramPrintWriter, paramBoolean);
  }

  protected void a(int paramInt)
  {
    for (int i1 = 0; i1 < paramInt; i1++)
      d(" ");
  }

  protected void c()
  {
    d("\n");
  }

  protected void a(String paramString)
  {
    d(StringUtil.replace("<TITLE></TITLE>", "<TITLE>" + paramString + "</TITLE>", c));
  }

  protected void a()
  {
    d("</svg>");
  }

  protected boolean d()
  {
    return false;
  }

  public String a(IRule paramIRule)
  {
    StringWriter localStringWriter = new StringWriter();
    this.p = new PrintWriter(localStringWriter);
    c(paramIRule);
    if (paramIRule.getMainPackage() != null)
    {
      IPackageElement localIPackageElement = paramIRule.getMainPackage().findRuleHistory(paramIRule.getUuid(), paramIRule.toString());
      if (localIPackageElement != null)
        c(localIPackageElement);
    }
    return localStringWriter.toString();
  }

  public void c(IElement paramIElement)
  {
    if (((paramIElement instanceof IRuleSet)) || ((paramIElement instanceof IRule)))
    {
      b();
      a(paramIElement.getDisplayName());
      if (paramIElement != null)
        paramIElement.acceptVisitor(this);
      a();
      j();
    }
  }

  private int b(String paramString)
  {
    for (int i1 = paramString.indexOf("<a "); i1 >= 0; i1 = paramString.indexOf("<a ", i1))
    {
      i2 = paramString.indexOf(">", i1);
      if (i2 <= i1)
        break;
      paramString = paramString.substring(0, i1) + paramString.substring(i2 + 1, paramString.length());
    }
    paramString = StringUtil.replace("</a>", "", paramString);
    int i2 = paramString.trim().getBytes().length;
    for (int i3 = 0; i3 < paramString.length(); i3++)
    {
      if (paramString.charAt(i3) != ' ')
        continue;
      i2++;
    }
    return i2;
  }

  private int c(String paramString)
  {
    int i1 = 0;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new StringReader(paramString));
      for (String str = localBufferedReader.readLine(); str != null; str = localBufferedReader.readLine())
      {
        if (str.getBytes().length <= 0)
          continue;
        i1 = str.getBytes().length;
      }
      localBufferedReader.close();
    }
    catch (IOException localIOException)
    {
    }
    return i1;
  }

  private int f(String paramString)
  {
    int i1 = 0;
    for (int i2 = 0; i2 < paramString.length(); i2++)
    {
      if (paramString.charAt(i2) != ' ')
        continue;
      i1++;
    }
    return i1;
  }

  public Object visitRule(Rule paramRule)
  {
    String str1 = paramRule.getText();
    String str2 = "";
    if (paramRule.getMainPackage() != null)
    {
      IPackageElement localIPackageElement = paramRule.getMainPackage().findRuleHistory(paramRule.getUuid(), paramRule.toString());
      if (localIPackageElement != null)
        str2 = localIPackageElement.getText();
    }
    int i1 = 16;
    int i2 = b(paramRule.getDisplayName());
    try
    {
      BufferedReader localBufferedReader1 = new BufferedReader(new StringReader(str1));
      for (localObject = localBufferedReader1.readLine(); localObject != null; localObject = localBufferedReader1.readLine())
      {
        int i4 = b((String)localObject);
        if (i4 <= i2)
          continue;
        i2 = i4;
      }
      localBufferedReader1.close();
    }
    catch (IOException localIOException1)
    {
    }
    int i3 = i2 * 6 + 20;
    if (i3 < 30)
      i3 = 30;
    if (i3 > this.i)
      this.i = i3;
    this.e += (this.i - i3) / 2;
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("<text x=\"" + (this.e + 6 + f(paramRule.getDisplayName()) * 6) + "\" y=\"" + (this.d + i1) + "\" font-size=\"12\">" + paramRule.getDisplayName() + "</text>");
    try
    {
      BufferedReader localBufferedReader2 = new BufferedReader(new StringReader(str1));
      for (String str3 = localBufferedReader2.readLine(); str3 != null; str3 = localBufferedReader2.readLine())
      {
        i1 += 16;
        if (str2.indexOf(str3) < 0)
          ((StringBuffer)localObject).append("<text x=\"" + (this.e + f(str3) * 2) + "\" y=\"" + (this.d + i1) + "\" font-size=\"12\"><tspan fill=\"green\">" + str3 + "</tspan></text>");
        else
          ((StringBuffer)localObject).append("<text x=\"" + (this.e + f(str3) * 2) + "\" y=\"" + (this.d + i1) + "\" font-size=\"12\">" + str3 + "</text>");
      }
      localBufferedReader2.close();
    }
    catch (IOException localIOException2)
    {
    }
    i1 += 10;
    c(this.e, this.d, i3, i1);
    d(((StringBuffer)localObject).toString());
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = this.e;
    arrayOfInt[1] = i3;
    arrayOfInt[2] = this.d;
    arrayOfInt[3] = i1;
    this.h.put(paramRule.getUuid(), arrayOfInt);
    this.d += i1 + 10;
    this.e -= (this.i - i3) / 2;
    return null;
  }

  public Object visitExpressionRule(ExpressionRule paramExpressionRule)
  {
    String str1 = paramExpressionRule.getText();
    String str2 = "";
    if (paramExpressionRule.getMainPackage() != null)
    {
      IPackageElement localIPackageElement = paramExpressionRule.getMainPackage().findRuleHistory(paramExpressionRule.getUuid(), paramExpressionRule.toString());
      if (localIPackageElement != null)
        str2 = localIPackageElement.getText();
    }
    int i1 = 16;
    int i2 = b(paramExpressionRule.getDisplayName());
    try
    {
      BufferedReader localBufferedReader1 = new BufferedReader(new StringReader(str1));
      for (localObject = localBufferedReader1.readLine(); localObject != null; localObject = localBufferedReader1.readLine())
      {
        int i4 = b((String)localObject);
        if (i4 <= i2)
          continue;
        i2 = i4;
      }
      localBufferedReader1.close();
    }
    catch (IOException localIOException1)
    {
    }
    int i3 = i2 * 6 + 20;
    if (i3 < 30)
      i3 = 30;
    if (i3 > this.i)
      this.i = i3;
    this.e += (this.i - i3) / 2;
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("<text x=\"" + (this.e + 6 + f(paramExpressionRule.getDisplayName()) * 6) + "\" y=\"" + (this.d + i1) + "\" font-size=\"12\">" + paramExpressionRule.getDisplayName() + "</text>");
    try
    {
      BufferedReader localBufferedReader2 = new BufferedReader(new StringReader(str1));
      for (String str3 = localBufferedReader2.readLine(); str3 != null; str3 = localBufferedReader2.readLine())
      {
        i1 += 16;
        if (str2.indexOf(str3) < 0)
          ((StringBuffer)localObject).append("<text x=\"" + (this.e + f(str3) * 2) + "\" y=\"" + (this.d + i1) + "\" font-size=\"12\"><tspan fill=\"green\">" + str3 + "</tspan></text>");
        else
          ((StringBuffer)localObject).append("<text x=\"" + (this.e + f(str3) * 2) + "\" y=\"" + (this.d + i1) + "\" font-size=\"12\">" + str3 + "</text>");
      }
      localBufferedReader2.close();
    }
    catch (IOException localIOException2)
    {
    }
    i1 += 10;
    c(this.e, this.d, i3, i1);
    d(((StringBuffer)localObject).toString());
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = this.e;
    arrayOfInt[1] = i3;
    arrayOfInt[2] = this.d;
    arrayOfInt[3] = i1;
    this.h.put(paramExpressionRule.getUuid(), arrayOfInt);
    this.d += i1 + 10;
    this.e -= (this.i - i3) / 2;
    return null;
  }

  public Object visitRuleMirror(RuleMirror paramRuleMirror)
  {
    int i1 = 1;
    int i2 = b(paramRuleMirror.getDisplayName());
    i1 *= 16;
    i1 += 10;
    int i3 = i2 * 6 + 20;
    if (i3 < 30)
      i3 = 30;
    if (i3 > this.i)
      this.i = i3;
    this.e += (this.i - i3) / 2;
    c(this.e, this.d, i3, i1);
    d("<text x=\"" + (this.e + 10 + f(paramRuleMirror.getDisplayName()) * 6) + "\" y=\"" + (this.d + i1) + "\" font-size=\"12\">" + paramRuleMirror.getDisplayName() + "</text>");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = this.e;
    arrayOfInt[1] = i3;
    arrayOfInt[2] = this.d;
    arrayOfInt[3] = i1;
    this.h.put(paramRuleMirror.getUuid(), arrayOfInt);
    this.d += i1 + 10;
    this.e -= (this.i - i3) / 2;
    return null;
  }

  public Object visitDecisionRule(DecisionRule paramDecisionRule)
  {
    String str1 = paramDecisionRule.getText();
    String str2 = "";
    if (paramDecisionRule.getMainPackage() != null)
    {
      localObject1 = paramDecisionRule.getMainPackage().findRuleHistory(paramDecisionRule.getUuid(), paramDecisionRule.toString());
      if (localObject1 != null)
        str2 = ((IPackageElement)localObject1).getText();
    }
    Object localObject1 = new StringBuffer();
    int i1 = 16;
    int i2 = 0;
    ((StringBuffer)localObject1).append("<text x=\"" + (this.e + 10 + f(paramDecisionRule.getDisplayName()) * 6) + "\" y=\"" + (this.d + i1) + "\" font-size=\"12\">" + paramDecisionRule.getDisplayName() + "</text>");
    Object localObject2;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new StringReader(str1));
      for (localObject2 = localBufferedReader.readLine(); localObject2 != null; localObject2 = localBufferedReader.readLine())
      {
        if (b((String)localObject2) <= i2)
          continue;
        i2 = b((String)localObject2);
      }
      localBufferedReader.close();
    }
    catch (IOException localIOException1)
    {
    }
    int i3 = i2 * 6 + 20;
    if (i3 < 30)
      i3 = 30;
    if (i3 > this.i)
      this.i = i3;
    this.e += (this.i - i3) / 2;
    ((StringBuffer)localObject1).append("<text x=\"" + (this.e + 10 + f(paramDecisionRule.getDisplayName()) * 6) + "\" y=\"" + (this.d + i1) + "\" font-size=\"12\">" + paramDecisionRule.getDisplayName() + "</text>");
    try
    {
      localObject2 = new BufferedReader(new StringReader(str1));
      for (String str3 = ((BufferedReader)localObject2).readLine(); str3 != null; str3 = ((BufferedReader)localObject2).readLine())
      {
        i1 += 16;
        if (str2.indexOf(str3) < 0)
          ((StringBuffer)localObject1).append("<text x=\"" + (this.e + 10 + f(str3) * 6) + "\" y=\"" + (this.d + i1) + "\" font-size=\"12\"><tspan fill=\"green\">" + str3 + "</tspan></text>");
        else
          ((StringBuffer)localObject1).append("<text x=\"" + (this.e + 10 + f(str3) * 6) + "\" y=\"" + (this.d + i1) + "\" font-size=\"12\">" + str3 + "</text>");
      }
      ((BufferedReader)localObject2).close();
    }
    catch (IOException localIOException2)
    {
    }
    i1 += 10;
    c(this.e, this.d, i3, i1);
    d(((StringBuffer)localObject1).toString());
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = this.e;
    arrayOfInt[1] = i3;
    arrayOfInt[2] = this.d;
    arrayOfInt[3] = i1;
    this.h.put(paramDecisionRule.getUuid(), arrayOfInt);
    this.e -= (this.i - i3) / 2;
    this.d += i1 + 10;
    return null;
  }

  protected void a(List paramList, DecisionRelateRule paramDecisionRelateRule)
  {
    int i1 = 0;
    int i2 = 0;
    if ((this.m.size() > this.j) && (this.m.get(this.j - 1) != null) && (this.n.indexOf(this.m.get(this.j - 1).toString()) >= 0))
      i2 = 1;
    int i3 = 0;
    int i4 = this.e;
    int i5 = this.d + 10 + this.j * 18;
    g("<text x=\"" + (i4 + 2) + "\" y=\"" + i5 + "\" font-size=\"12\">" + this.j + "</text>");
    String str;
    while (i3 < paramDecisionRelateRule.getConditionNum())
    {
      i4 += this.l[i3] * 6 + 10;
      if (i3 < paramList.size())
      {
        str = StringUtil.replace(paramDecisionRelateRule.getFirstMember(i3 + 1) + u.a("EqualsTo.edit", "equals to "), "", paramList.get(i3).toString());
        str = StringUtil.replace(paramDecisionRelateRule.getFirstMember(i3 + 1), "", str);
        g("<text x=\"" + i4 + "\" y=\"" + i5 + "\" font-size=\"12\">" + str + "</text>");
      }
      i3++;
    }
    while (i3 < paramDecisionRelateRule.getConditionNum() + paramDecisionRelateRule.getValueNum())
    {
      i4 += this.l[i3] * 6 + 10;
      if ((paramDecisionRelateRule.getDecisionElement(i3 - paramDecisionRelateRule.getConditionNum() + 1) != null) && (paramDecisionRelateRule.getDecisionElement(i3 - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement() != null))
      {
        str = "";
        DecisionElementValue localDecisionElementValue = paramDecisionRelateRule.getDecisionValue(paramList, paramDecisionRelateRule.getDecisionElement(i3 - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement());
        if (localDecisionElementValue != null)
        {
          str = localDecisionElementValue.getValue();
          g("<text x=\"" + i4 + "\" y=\"" + i5 + "\" font-size=\"12\">" + str + "</text>");
        }
      }
      i3++;
    }
    this.j += 1;
  }

  private int[] a(DecisionRelateRule paramDecisionRelateRule)
  {
    List localList = paramDecisionRelateRule.getConditions().getConditionList();
    for (int i1 = 0; i1 < localList.size(); i1++)
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localList.get(i1));
      b(localArrayList, paramDecisionRelateRule);
    }
    return this.l;
  }

  private void b(List paramList, DecisionRelateRule paramDecisionRelateRule)
  {
    if (paramList.size() < paramDecisionRelateRule.getConditionNum())
    {
      List localList = paramDecisionRelateRule.getNextConditions((IConditionToken)paramList.get(paramList.size() - 1), paramList.size());
      if (localList.size() == 0)
        c(paramList, paramDecisionRelateRule);
      else
        for (int i1 = 0; i1 < localList.size(); i1++)
        {
          ArrayList localArrayList = new ArrayList(paramList.size() + 1);
          localArrayList.addAll(paramList);
          localArrayList.add(localList.get(i1));
          b(localArrayList, paramDecisionRelateRule);
        }
    }
    else
    {
      c(paramList, paramDecisionRelateRule);
    }
  }

  private void c(List paramList, DecisionRelateRule paramDecisionRelateRule)
  {
    String str;
    for (int i1 = 0; i1 < paramDecisionRelateRule.getConditionNum(); i1++)
    {
      if (i1 >= paramList.size())
        continue;
      str = StringUtil.replace(paramDecisionRelateRule.getFirstMember(i1 + 1) + u.a("EqualsTo.edit", "equals to "), "", paramList.get(i1).toString());
      str = StringUtil.replace(paramDecisionRelateRule.getFirstMember(i1 + 1), "", str);
      int i2 = b(str);
      if (this.l[(i1 + 1)] >= i2)
        continue;
      this.l[(i1 + 1)] = i2;
    }
    while (i1 < paramDecisionRelateRule.getConditionNum() + paramDecisionRelateRule.getValueNum())
    {
      if ((paramDecisionRelateRule.getDecisionElement(i1 - paramDecisionRelateRule.getConditionNum() + 1) != null) && (paramDecisionRelateRule.getDecisionElement(i1 - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement() != null))
      {
        str = "";
        DecisionElementValue localDecisionElementValue = paramDecisionRelateRule.getDecisionValue(paramList, paramDecisionRelateRule.getDecisionElement(i1 - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement());
        if (localDecisionElementValue != null)
        {
          str = localDecisionElementValue.getValue();
          int i3 = b(str) + 2;
          if (this.l[(i1 + 1)] < i3)
            this.l[(i1 + 1)] = i3;
        }
      }
      i1++;
    }
  }

  public Object visitDecisionRelateRule(DecisionRelateRule paramDecisionRelateRule)
  {
    this.a.setLength(0);
    this.k = 0;
    this.n = "";
    this.m.clear();
    this.l = new int[paramDecisionRelateRule.getConditionNum() + paramDecisionRelateRule.getValueNum() + 1];
    this.l[0] = 2;
    for (int i1 = 0; i1 < paramDecisionRelateRule.getConditionNum(); i1++)
    {
      if (paramDecisionRelateRule.getFirstMember(i1 + 1) == null)
        continue;
      i2 = b(paramDecisionRelateRule.getFirstMember(i1 + 1));
      if (this.l[(i1 + 1)] >= i2)
        continue;
      this.l[(i1 + 1)] = i2;
    }
    while (i1 < paramDecisionRelateRule.getConditionNum() + paramDecisionRelateRule.getValueNum())
    {
      if ((paramDecisionRelateRule.getDecisionElement(i1 - paramDecisionRelateRule.getConditionNum() + 1) != null) && (paramDecisionRelateRule.getDecisionElement(i1 - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement() != null))
      {
        i2 = b(paramDecisionRelateRule.getDecisionElement(i1 - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement().getDisplayName());
        if (this.l[(i1 + 1)] < i2)
          this.l[(i1 + 1)] = i2;
      }
      i1++;
    }
    a(paramDecisionRelateRule);
    this.j = 1;
    int i2 = 0;
    for (int i3 = 0; i3 < this.l.length; i3++)
      i2 += this.l[i3] * 6 + 10;
    if (i2 < 30)
      i2 = 30;
    if (i2 > this.i)
      this.i = i2;
    this.e += (this.i - i2) / 2;
    String str1 = paramDecisionRelateRule.getText();
    Object localObject;
    if (paramDecisionRelateRule.getMainPackage() != null)
    {
      localObject = paramDecisionRelateRule.getMainPackage().findRuleHistory(paramDecisionRelateRule.getUuid(), paramDecisionRelateRule.toString());
      if (localObject != null)
        this.n = ((IPackageElement)localObject).getText();
    }
    try
    {
      localObject = new BufferedReader(new StringReader(str1));
      for (String str2 = ((BufferedReader)localObject).readLine(); str2 != null; str2 = ((BufferedReader)localObject).readLine())
        this.m.add(str2);
      ((BufferedReader)localObject).close();
    }
    catch (IOException localIOException)
    {
    }
    int i4 = 1 + paramDecisionRelateRule.getConditionNum() + paramDecisionRelateRule.getValueNum();
    int i5 = this.e;
    int i6 = this.d + 10;
    for (i1 = 0; i1 < paramDecisionRelateRule.getConditionNum(); i1++)
    {
      if (paramDecisionRelateRule.getFirstMember(i1 + 1) == null)
        continue;
      i5 += this.l[i1] * 6 + 10;
      g("<text x=\"" + i5 + "\" y=\"" + i6 + "\" font-size=\"12\">" + paramDecisionRelateRule.getFirstMember(i1 + 1) + "</text>");
    }
    while (i1 < paramDecisionRelateRule.getConditionNum() + paramDecisionRelateRule.getValueNum())
    {
      if ((paramDecisionRelateRule.getDecisionElement(i1 - paramDecisionRelateRule.getConditionNum() + 1) != null) && (paramDecisionRelateRule.getDecisionElement(i1 - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement() != null))
      {
        i5 += this.l[i1] * 6 + 10;
        g("<text x=\"" + i5 + "\" y=\"" + i6 + "\" font-size=\"12\">" + paramDecisionRelateRule.getDecisionElement(i1 - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement().getDisplayName() + "</text>");
      }
      i1++;
    }
    super.visitDecisionRelateRule(paramDecisionRelateRule);
    int i7 = this.j * 18;
    c(this.e, this.d, i2, i7);
    d(this.a.toString());
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = this.e;
    arrayOfInt[1] = i2;
    arrayOfInt[2] = this.d;
    arrayOfInt[3] = i7;
    this.h.put(paramDecisionRelateRule.getUuid(), arrayOfInt);
    this.e -= (this.i - i2) / 2;
    this.d += i7 + 10;
    return null;
  }

  public Object visitDecisionMultiRule(DecisionMultiRule paramDecisionMultiRule)
  {
    this.l = new int[1 + paramDecisionMultiRule.getConditionNum() + paramDecisionMultiRule.getValueNum()];
    this.l[0] = 2;
    a(paramDecisionMultiRule);
    int i1 = 0;
    for (int i2 = 0; i2 < this.l.length; i2++)
      i1 += this.l[i2] * 6 + 10;
    if (i1 < 30)
      i1 = 30;
    if (i1 > this.i)
      this.i = i1;
    this.e += (this.i - i1) / 2;
    b(paramDecisionMultiRule);
    i2 = this.j * 18;
    c(this.e, this.d, i1, i2);
    d(this.a.toString());
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = this.e;
    arrayOfInt[1] = i1;
    arrayOfInt[2] = this.d;
    arrayOfInt[3] = i2;
    this.h.put(paramDecisionMultiRule.getUuid(), arrayOfInt);
    this.e -= (this.i - i1) / 2;
    this.d += i2 + 10;
    return null;
  }

  private int[] a(DecisionMultiRule paramDecisionMultiRule)
  {
    this.k = 0;
    for (int i1 = 0; i1 < paramDecisionMultiRule.getConditionNum(); i1++)
    {
      IMultiConditionToken localIMultiConditionToken = paramDecisionMultiRule.getConditions(i1 + 1);
      if (localIMultiConditionToken.getSameFirstValue() == null)
        continue;
      int i3 = b(localIMultiConditionToken.getSameFirstValue().getDisplayName());
      if (this.l[(i1 + 1)] >= i3)
        continue;
      this.l[(i1 + 1)] = i3;
    }
    while (i1 < paramDecisionMultiRule.getConditionNum() + paramDecisionMultiRule.getValueNum())
    {
      if ((paramDecisionMultiRule.getDecisionElement(i1 - paramDecisionMultiRule.getConditionNum() + 1) != null) && (paramDecisionMultiRule.getDecisionElement(i1 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement() != null))
      {
        i2 = b(paramDecisionMultiRule.getDecisionElement(i1 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement().getDisplayName());
        if (this.l[(i1 + 1)] < i2)
          this.l[(i1 + 1)] = i2;
      }
      i1++;
    }
    int i2 = 1;
    int[] arrayOfInt = new int[paramDecisionMultiRule.getConditionNum()];
    for (int i4 = 0; i4 < paramDecisionMultiRule.getConditionNum(); i4++)
      arrayOfInt[i4] = 0;
    do
    {
      i4 = 0;
      i1 = 0;
      ArrayList localArrayList = new ArrayList(paramDecisionMultiRule.getConditionNum());
      Object localObject;
      while (i1 < paramDecisionMultiRule.getConditionNum())
      {
        localObject = paramDecisionMultiRule.getConditions(i1 + 1);
        localArrayList.add(((IMultiConditionToken)localObject).getCondition(arrayOfInt[i1]));
        if ((a(i1, arrayOfInt)) && (((IMultiConditionToken)localObject).getCondition(arrayOfInt[i1]) != null))
        {
          int i5 = a(i1, arrayOfInt, paramDecisionMultiRule);
          int i6;
          if (((IMultiConditionToken)localObject).getSameFirstValue() == null)
          {
            i6 = b(((IMultiConditionToken)localObject).getCondition(arrayOfInt[i1]).toString());
            if (this.l[(i1 + 1)] < i6)
              this.l[(i1 + 1)] = i6;
          }
          else if (((IMultiConditionToken)localObject).getCondition(arrayOfInt[i1]).getCompareOperator().getType() == 0)
          {
            i6 = b(((IMultiConditionToken)localObject).getCondition(arrayOfInt[i1]).getComparedValue().toString());
            if (this.l[(i1 + 1)] < i6)
              this.l[(i1 + 1)] = i6;
          }
          else
          {
            String str = StringUtil.replace(((IMultiConditionToken)localObject).getSameFirstValue().toString() + u.a("EqualsTo.edit", "equals to"), "", ((IMultiConditionToken)localObject).getCondition(arrayOfInt[i1]).toString());
            int i8 = b(str);
            if (this.l[(i1 + 1)] < i8)
              this.l[(i1 + 1)] = i8;
          }
        }
        i1++;
      }
      while (i1 < paramDecisionMultiRule.getConditionNum() + paramDecisionMultiRule.getValueNum())
      {
        if ((paramDecisionMultiRule.getDecisionElement(i1 - paramDecisionMultiRule.getConditionNum() + 1) != null) && (paramDecisionMultiRule.getDecisionElement(i1 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement() != null))
        {
          localObject = "";
          DecisionElementValue localDecisionElementValue = paramDecisionMultiRule.getDecisionValue(localArrayList, paramDecisionMultiRule.getDecisionElement(i1 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement());
          if (localDecisionElementValue != null)
          {
            localObject = localDecisionElementValue.getValue();
            int i7 = b((String)localObject) + 2;
            if (this.l[(i1 + 1)] < i7)
              this.l[(i1 + 1)] = i7;
          }
        }
        i1++;
      }
      arrayOfInt = paramDecisionMultiRule.getNextDecision(arrayOfInt);
      i2++;
    }
    while (arrayOfInt != null);
    return (I)this.l;
  }

  private void b(DecisionMultiRule paramDecisionMultiRule)
  {
    String str1 = paramDecisionMultiRule.getText();
    String str2 = "";
    if (paramDecisionMultiRule.getMainPackage() != null)
    {
      IPackageElement localIPackageElement = paramDecisionMultiRule.getMainPackage().findRuleHistory(paramDecisionMultiRule.getUuid(), paramDecisionMultiRule.toString());
      if (localIPackageElement != null)
        str2 = localIPackageElement.getText();
    }
    int i1 = 1 + paramDecisionMultiRule.getConditionNum() + paramDecisionMultiRule.getValueNum();
    this.a.setLength(0);
    this.k = 0;
    int i2 = 0;
    int i3 = this.e;
    int i4 = this.d + 10;
    while (i2 < paramDecisionMultiRule.getConditionNum())
    {
      IMultiConditionToken localIMultiConditionToken = paramDecisionMultiRule.getConditions(i2 + 1);
      if (localIMultiConditionToken.getSameFirstValue() != null)
      {
        i3 += this.l[i2] * 6 + 10;
        g("<text x=\"" + i3 + "\" y=\"" + i4 + "\" font-size=\"12\">" + localIMultiConditionToken.getSameFirstValue().getDisplayName() + "</text>");
      }
      i2++;
    }
    while (i2 < paramDecisionMultiRule.getConditionNum() + paramDecisionMultiRule.getValueNum())
    {
      if ((paramDecisionMultiRule.getDecisionElement(i2 - paramDecisionMultiRule.getConditionNum() + 1) != null) && (paramDecisionMultiRule.getDecisionElement(i2 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement() != null))
      {
        i3 += this.l[i2] * 6 + 10;
        g("<text x=\"" + i3 + "\" y=\"" + i4 + "\" font-size=\"12\">" + paramDecisionMultiRule.getDecisionElement(i2 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement().getDisplayName() + "</text>");
      }
      i2++;
    }
    int i5 = 1;
    int[] arrayOfInt = new int[paramDecisionMultiRule.getConditionNum()];
    for (int i6 = 0; i6 < paramDecisionMultiRule.getConditionNum(); i6++)
      arrayOfInt[i6] = 0;
    BufferedReader localBufferedReader = new BufferedReader(new StringReader(str1));
    String str3 = "";
    try
    {
      str3 = localBufferedReader.readLine();
    }
    catch (Exception localException1)
    {
    }
    do
    {
      int i7 = 0;
      if ((str3 != null) && (str3.length() > 0) && (str2.indexOf(str3) < 0))
        i7 = 1;
      Object localObject1 = "";
      i3 = this.e;
      i4 += 18;
      g("<text x=\"" + (i3 + 2) + "\" y=\"" + i4 + "\" font-size=\"12\">" + i5 + "</text>");
      i2 = 0;
      ArrayList localArrayList = new ArrayList(paramDecisionMultiRule.getConditionNum());
      Object localObject2;
      while (i2 < paramDecisionMultiRule.getConditionNum())
      {
        localObject2 = paramDecisionMultiRule.getConditions(i2 + 1);
        localArrayList.add(((IMultiConditionToken)localObject2).getCondition(arrayOfInt[i2]));
        i3 += this.l[i2] * 6 + 10;
        if ((a(i2, arrayOfInt)) && (((IMultiConditionToken)localObject2).getCondition(arrayOfInt[i2]) != null))
        {
          int i8 = a(i2, arrayOfInt, paramDecisionMultiRule);
          if (((IMultiConditionToken)localObject2).getSameFirstValue() == null)
          {
            localObject1 = ((IMultiConditionToken)localObject2).getCondition(arrayOfInt[i2]).toString();
            g("<text x=\"" + i3 + "\" y=\"" + i4 + "\" font-size=\"12\">" + (String)localObject1 + "</text>");
          }
          else if (((IMultiConditionToken)localObject2).getCondition(arrayOfInt[i2]).getCompareOperator().getType() == 0)
          {
            localObject1 = ((IMultiConditionToken)localObject2).getCondition(arrayOfInt[i2]).getComparedValue().toString();
            g("<text x=\"" + i3 + "\" y=\"" + i4 + "\" font-size=\"12\">" + (String)localObject1 + "</text>");
          }
          else
          {
            String str4 = StringUtil.replace(((IMultiConditionToken)localObject2).getSameFirstValue().toString() + u.a("EqualsTo.edit", "equals to"), "", ((IMultiConditionToken)localObject2).getCondition(arrayOfInt[i2]).toString());
            localObject1 = str4;
            g("<text x=\"" + i3 + "\" y=\"" + i4 + "\" font-size=\"12\">" + (String)localObject1 + "</text>");
          }
        }
        i2++;
      }
      while (i2 < paramDecisionMultiRule.getConditionNum() + paramDecisionMultiRule.getValueNum())
      {
        i3 += this.l[i2] * 6 + 10;
        if ((paramDecisionMultiRule.getDecisionElement(i2 - paramDecisionMultiRule.getConditionNum() + 1) != null) && (paramDecisionMultiRule.getDecisionElement(i2 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement() != null))
        {
          localObject2 = "";
          DecisionElementValue localDecisionElementValue = paramDecisionMultiRule.getDecisionValue(localArrayList, paramDecisionMultiRule.getDecisionElement(i2 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement());
          if (localDecisionElementValue != null)
          {
            localObject2 = localDecisionElementValue.getValue();
            g("<text x=\"" + i3 + "\" y=\"" + i4 + "\" font-size=\"12\">" + (String)localObject2 + "</text>");
          }
        }
        i2++;
      }
      arrayOfInt = paramDecisionMultiRule.getNextDecision(arrayOfInt);
      try
      {
        str3 = localBufferedReader.readLine();
      }
      catch (Exception localException2)
      {
      }
      i5++;
    }
    while (arrayOfInt != null);
    this.j = i5;
  }

  private boolean a(int paramInt, int[] paramArrayOfInt)
  {
    if (paramInt == paramArrayOfInt.length - 1)
      return true;
    for (int i1 = paramInt + 1; i1 < paramArrayOfInt.length; i1++)
      if (paramArrayOfInt[i1] > 0)
        return false;
    return true;
  }

  private int a(int paramInt, int[] paramArrayOfInt, DecisionMultiRule paramDecisionMultiRule)
  {
    if (paramInt == paramArrayOfInt.length - 1)
      return 1;
    int i1 = 1;
    for (int i2 = paramInt + 1; i2 < paramArrayOfInt.length; i2++)
      i1 *= paramDecisionMultiRule.getConditions(i2 + 1).getConditionList().size();
    return i1;
  }

  private void g(String paramString)
  {
    this.a.append(paramString);
  }

  private String a(String paramString1, String paramString2)
  {
    int[] arrayOfInt1 = (int[])this.h.get(paramString1);
    int[] arrayOfInt2 = (int[])this.h.get(paramString2);
    if ((arrayOfInt1 != null) && (arrayOfInt2 != null))
    {
      int i1 = arrayOfInt1[0] + arrayOfInt1[1] / 2;
      int i2 = arrayOfInt1[2] + arrayOfInt1[3];
      int i3 = arrayOfInt2[0] + arrayOfInt2[1] / 2;
      int i4 = arrayOfInt2[2];
      if (i1 < i3)
        return "M" + i1 + "," + i2 + " l" + 0 + "," + (i4 - i2 - 5);
      return "M" + i3 + "," + i2 + " l" + 0 + "," + (i4 - i2 - 5);
    }
    return "M0,0 l0,0";
  }

  private String c(String paramString1, String paramString2)
  {
    int[] arrayOfInt1 = (int[])this.h.get(paramString1);
    int[] arrayOfInt2 = (int[])this.h.get(paramString2);
    if ((arrayOfInt1 != null) && (arrayOfInt2 != null))
    {
      int i1 = arrayOfInt1[0] + arrayOfInt1[1];
      int i2 = arrayOfInt1[2] + arrayOfInt1[3] / 2;
      int i3 = arrayOfInt2[0] + arrayOfInt2[1] / 2;
      int i4 = arrayOfInt2[2];
      if (i1 < i3)
        return "M" + i1 + "," + i2 + " l" + (i3 - i1) + "," + 0 + " l" + 0 + "," + (i4 - i2 - 5);
      return "M" + i1 + "," + i2 + " l" + (i3 - i1) + "," + 0 + " l" + 0 + "," + (i4 - i2 - 5);
    }
    return "M0,0 l0,0";
  }

  public Object visitRulePackage(RulePackage paramRulePackage)
  {
    List localList = paramRulePackage.getRulesList();
    int i1 = 0;
    Object localObject;
    int i3;
    for (int i2 = 0; i2 < localList.size(); i2++)
    {
      localObject = (IPackageElement)localList.get(i2);
      if (!((IPackageElement)localObject).canVmlShow())
        continue;
      ((IElement)localList.get(i2)).acceptVisitor(this);
      i1 = 1;
      for (i3 = 1; i3 < localList.size() - i2; i3++)
        if (((IPackageElement)localList.get(i2 + i3)).getVml() == 0)
          break;
    }
    i1 = 0;
    for (i2 = 0; i2 < localList.size(); i2++)
    {
      localObject = (IPackageElement)localList.get(i2);
      if (!((IPackageElement)localObject).canVmlShow())
        continue;
      if (i1 == 0)
        d("<path d=\"" + c(paramRulePackage.getUuid(), ((IElement)localList.get(i2)).getUuid()) + "\" stroke=\"gray\" stroke-width=\"2\" fill=\"none\" marker-end=\"url(#arrow)\" />");
      i1 = 1;
      for (i3 = 1; i3 < localList.size() - i2; i3++)
        if (((IPackageElement)localList.get(i2 + i3)).getVml() == 0)
          break;
      if (i2 + i3 > localList.size() - 1)
        continue;
      d("<path d=\"" + a(((IElement)localList.get(i2)).getUuid(), ((IElement)localList.get(i2 + i3)).getUuid()) + "\" stroke=\"gray\" stroke-width=\"2\" fill=\"none\" marker-end=\"url(#arrow)\" />");
    }
    Iterator localIterator = paramRulePackage.getEnvionment().getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!(localObject instanceof IRuleTree))
        continue;
      ((IRuleTree)localObject).acceptVisitor(this);
    }
    return null;
  }

  public Object visitRuleSet(RuleSet paramRuleSet)
  {
    int i1 = 16;
    int i2 = b(paramRuleSet.getDisplayName());
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject2;
    if (paramRuleSet.getVml() == 0)
    {
      String str = paramRuleSet.getText();
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new StringReader(str));
        for (localObject2 = localBufferedReader.readLine(); localObject2 != null; localObject2 = localBufferedReader.readLine())
        {
          int i5 = b((String)localObject2);
          for (i6 = 0; i6 < ((String)localObject2).length(); i6++)
          {
            if (((String)localObject2).charAt(i6) != ' ')
              continue;
            i5 += 2;
          }
          if (i5 <= i2)
            continue;
          i2 = i5;
        }
        localBufferedReader.close();
      }
      catch (IOException localIOException1)
      {
      }
    }
    int i3 = i2 * 6 + 20;
    if (i3 < 80)
      i3 = 80;
    if (i3 > this.i)
      this.i = i3;
    this.e += (this.i - i3) / 2;
    if (paramRuleSet.getVml() == 0)
    {
      localObject1 = paramRuleSet.getText();
      try
      {
        localObject2 = new BufferedReader(new StringReader((String)localObject1));
        localStringBuffer.append("<text x=\"" + (this.e + 5 + f(paramRuleSet.getDisplayName()) * 2) + "\" y=\"" + (this.d + i1) + "\" font-size=\"12\">" + paramRuleSet.getDisplayName() + "</text>");
        for (localObject3 = ((BufferedReader)localObject2).readLine(); localObject3 != null; localObject3 = ((BufferedReader)localObject2).readLine())
        {
          i1 += 16;
          localStringBuffer.append("<text x=\"" + (this.e + 5 + f((String)localObject3) * 2) + "\" y=\"" + (this.d + i1) + "\" font-size=\"12\">" + (String)localObject3 + "</text>");
        }
        ((BufferedReader)localObject2).close();
      }
      catch (IOException localIOException2)
      {
      }
    }
    i1 += 10;
    c(this.e, this.d, i3, i1);
    d(localStringBuffer.toString());
    Object localObject1 = new int[4];
    localObject1[0] = this.e;
    localObject1[1] = i3;
    localObject1[2] = this.d;
    localObject1[3] = i1;
    this.h.put(paramRuleSet.getUuid(), localObject1);
    this.e += i3 / 2 + 5;
    int i4 = this.i;
    this.i = (i3 + 10);
    this.d += i1 + 10;
    Object localObject3 = paramRuleSet.getRulesList();
    int i6 = 0;
    IPackageElement localIPackageElement;
    int i8;
    for (int i7 = 0; i7 < ((List)localObject3).size(); i7++)
    {
      localIPackageElement = (IPackageElement)((List)localObject3).get(i7);
      if (!localIPackageElement.canVmlShow())
        continue;
      ((IElement)((List)localObject3).get(i7)).acceptVisitor(this);
      i6 = 1;
      for (i8 = 1; i8 < ((List)localObject3).size() - i7; i8++)
        if (((IPackageElement)((List)localObject3).get(i7 + i8)).getVml() == 0)
          break;
    }
    i6 = 0;
    for (i7 = 0; i7 < ((List)localObject3).size(); i7++)
    {
      localIPackageElement = (IPackageElement)((List)localObject3).get(i7);
      if (!localIPackageElement.canVmlShow())
        continue;
      if (i6 == 0)
        d("<path d=\"" + c(paramRuleSet.getUuid(), ((IElement)((List)localObject3).get(i7)).getUuid()) + "\" stroke=\"gray\" stroke-width=\"2\" fill=\"none\" marker-end=\"url(#arrow)\" />");
      i6 = 1;
      for (i8 = 1; i8 < ((List)localObject3).size() - i7; i8++)
        if (((IPackageElement)((List)localObject3).get(i7 + i8)).getVml() == 0)
          break;
      if (i7 + i8 > ((List)localObject3).size() - 1)
        continue;
      d("<path d=\"" + a(((IElement)((List)localObject3).get(i7)).getUuid(), ((IElement)((List)localObject3).get(i7 + i8)).getUuid()) + "\" stroke=\"gray\" stroke-width=\"2\" fill=\"none\" marker-end=\"url(#arrow)\" />");
    }
    this.i = i4;
    this.e -= i3 / 2 + 5;
    this.e -= (this.i - i3) / 2;
    this.d += 20;
    return null;
  }

  public Object visitRuleSetFlow(RuleSetFlow paramRuleSetFlow)
  {
    int i1 = 1;
    int i2 = b(paramRuleSetFlow.getDisplayName());
    i1 *= 16;
    i1 += 10;
    int i3 = i2 * 6 + 20;
    if (i3 < 80)
      i3 = 80;
    if (i3 > this.i)
      this.i = i3;
    this.e += (this.i - i3) / 2;
    c(this.e, this.d, i3, i1);
    if (paramRuleSetFlow.getVml() == 0)
      d("<text x=\"" + (this.e + 10 + f(paramRuleSetFlow.getDisplayName()) * 6) + "\" y=\"" + (this.d + i1) + "\" font-size=\"12\">" + paramRuleSetFlow.getDisplayName() + "</text>");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = this.e;
    arrayOfInt[1] = i3;
    arrayOfInt[2] = this.d;
    arrayOfInt[3] = i1;
    this.h.put(paramRuleSetFlow.getUuid(), arrayOfInt);
    this.e += i3 / 2 + 5;
    int i4 = this.i;
    this.i = (i3 + 10);
    this.d += i1 + 10;
    List localList = paramRuleSetFlow.getRulesList();
    int i5 = 0;
    IPackageElement localIPackageElement;
    int i7;
    for (int i6 = 0; i6 < localList.size(); i6++)
    {
      localIPackageElement = (IPackageElement)localList.get(i6);
      if (!localIPackageElement.canVmlShow())
        continue;
      ((IElement)localList.get(i6)).acceptVisitor(this);
      i5 = 1;
      for (i7 = 1; i7 < localList.size() - i6; i7++)
        if (((IPackageElement)localList.get(i6 + i7)).getVml() == 0)
          break;
    }
    i5 = 0;
    for (i6 = 0; i6 < localList.size(); i6++)
    {
      localIPackageElement = (IPackageElement)localList.get(i6);
      if (!localIPackageElement.canVmlShow())
        continue;
      if (i5 == 0)
        d("<path d=\"" + c(paramRuleSetFlow.getUuid(), ((IElement)localList.get(i6)).getUuid()) + "\" stroke=\"gray\" stroke-width=\"2\" fill=\"none\" marker-end=\"url(#arrow)\" />");
      i5 = 1;
      for (i7 = 1; i7 < localList.size() - i6; i7++)
        if (((IPackageElement)localList.get(i6 + i7)).getVml() == 0)
          break;
      if (i6 + i7 > localList.size() - 1)
        continue;
      d("<path d=\"" + a(((IElement)localList.get(i6)).getUuid(), ((IElement)localList.get(i6 + i7)).getUuid()) + "\" stroke=\"gray\" stroke-width=\"2\" fill=\"none\" marker-end=\"url(#arrow)\" />");
    }
    this.i = i4;
    this.e -= i3 / 2 + 5;
    this.e -= (this.i - i3) / 2;
    this.d += 20;
    return null;
  }

  public Object visitRulePoolFlow(RulePoolFlow paramRulePoolFlow)
  {
    int i1 = 1;
    int i2 = b(paramRulePoolFlow.getDisplayName());
    i1 *= 16;
    i1 += 10;
    int i3 = i2 * 6 + 20;
    if (i3 < 80)
      i3 = 80;
    if (i3 > this.i)
      this.i = i3;
    this.e += (this.i - i3) / 2;
    c(this.e, this.d, i3, i1);
    if (paramRulePoolFlow.getVml() == 0)
      d("<text x=\"" + (this.e + 10 + f(paramRulePoolFlow.getDisplayName()) * 6) + "\" y=\"" + (this.d + i1) + "\" font-size=\"12\">" + paramRulePoolFlow.getDisplayName() + "</text>");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = this.e;
    arrayOfInt[1] = i3;
    arrayOfInt[2] = this.d;
    arrayOfInt[3] = i1;
    this.h.put(paramRulePoolFlow.getUuid(), arrayOfInt);
    this.e += i3 / 2 + 5;
    int i4 = this.i;
    this.i = (i3 + 10);
    this.d += i1 + 10;
    List localList = paramRulePoolFlow.getRulesList();
    int i5 = 0;
    IPackageElement localIPackageElement;
    int i7;
    for (int i6 = 0; i6 < localList.size(); i6++)
    {
      localIPackageElement = (IPackageElement)localList.get(i6);
      if (!localIPackageElement.canVmlShow())
        continue;
      ((IElement)localList.get(i6)).acceptVisitor(this);
      i5 = 1;
      for (i7 = 1; i7 < localList.size() - i6; i7++)
        if (((IPackageElement)localList.get(i6 + i7)).getVml() == 0)
          break;
    }
    i5 = 0;
    for (i6 = 0; i6 < localList.size(); i6++)
    {
      localIPackageElement = (IPackageElement)localList.get(i6);
      if (!localIPackageElement.canVmlShow())
        continue;
      if (i5 == 0)
        d("<path d=\"" + c(paramRulePoolFlow.getUuid(), ((IElement)localList.get(i6)).getUuid()) + "\" stroke=\"gray\" stroke-width=\"2\" fill=\"none\" marker-end=\"url(#arrow)\" />");
      i5 = 1;
      for (i7 = 1; i7 < localList.size() - i6; i7++)
        if (((IPackageElement)localList.get(i6 + i7)).getVml() == 0)
          break;
      if (i6 + i7 > localList.size() - 1)
        continue;
      d("<path d=\"" + a(((IElement)localList.get(i6)).getUuid(), ((IElement)localList.get(i6 + i7)).getUuid()) + "\" stroke=\"gray\" stroke-width=\"2\" fill=\"none\" marker-end=\"url(#arrow)\" />");
    }
    this.i = i4;
    this.e -= i3 / 2 + 5;
    this.e -= (this.i - i3) / 2;
    this.d += 20;
    return null;
  }

  public Object visitRuleTreeFlow(RuleTreeFlow paramRuleTreeFlow)
  {
    int i1 = 1;
    int i2 = b(paramRuleTreeFlow.getDisplayName());
    i1 *= 16;
    i1 += 10;
    int i3 = i2 * 6 + 20;
    if (i3 < 80)
      i3 = 80;
    if (i3 > this.i)
      this.i = i3;
    this.e += (this.i - i3) / 2;
    c(this.e, this.d, i3, i1);
    if (paramRuleTreeFlow.getVml() == 0)
      d("<text x=\"" + (this.e + 10 + f(paramRuleTreeFlow.getDisplayName()) * 6) + "\" y=\"" + (this.d + i1) + "\" font-size=\"12\">" + paramRuleTreeFlow.getDisplayName() + "</text>");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = this.e;
    arrayOfInt[1] = i3;
    arrayOfInt[2] = this.d;
    arrayOfInt[3] = i1;
    this.h.put(paramRuleTreeFlow.getUuid(), arrayOfInt);
    this.e += i3 / 2 + 5;
    int i4 = this.i;
    this.i = (i3 + 10);
    this.d += i1 + 10;
    List localList = paramRuleTreeFlow.getRulesList();
    int i5 = 0;
    IPackageElement localIPackageElement;
    int i7;
    for (int i6 = 0; i6 < localList.size(); i6++)
    {
      localIPackageElement = (IPackageElement)localList.get(i6);
      if (!localIPackageElement.canVmlShow())
        continue;
      ((IElement)localList.get(i6)).acceptVisitor(this);
      i5 = 1;
      for (i7 = 1; i7 < localList.size() - i6; i7++)
        if (((IPackageElement)localList.get(i6 + i7)).getVml() == 0)
          break;
    }
    i5 = 0;
    for (i6 = 0; i6 < localList.size(); i6++)
    {
      localIPackageElement = (IPackageElement)localList.get(i6);
      if (!localIPackageElement.canVmlShow())
        continue;
      if (i5 == 0)
        d("<path d=\"" + c(paramRuleTreeFlow.getUuid(), ((IElement)localList.get(i6)).getUuid()) + "\" stroke=\"gray\" stroke-width=\"2\" fill=\"none\" marker-end=\"url(#arrow)\" />");
      i5 = 1;
      for (i7 = 1; i7 < localList.size() - i6; i7++)
        if (((IPackageElement)localList.get(i6 + i7)).getVml() == 0)
          break;
      if (i6 + i7 > localList.size() - 1)
        continue;
      d("<path d=\"" + a(((IElement)localList.get(i6)).getUuid(), ((IElement)localList.get(i6 + i7)).getUuid()) + "\" stroke=\"gray\" stroke-width=\"2\" fill=\"none\" marker-end=\"url(#arrow)\" />");
    }
    this.i = i4;
    this.e -= i3 / 2 + 5;
    this.e -= (this.i - i3) / 2;
    this.d += 20;
    return null;
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  private void a(int paramInt1, int paramInt2, String paramString)
  {
    d("<text x=\"" + paramInt1 + "\" y=\"" + paramInt2 + "\" font-size=\"12\">" + paramString + "</text>");
  }

  private void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 + paramInt3 > this.f)
      this.f = (paramInt1 + paramInt3);
    if (paramInt2 + paramInt4 > this.g)
      this.g = (paramInt2 + paramInt4);
    d("<rect x=\"" + paramInt1 + "\" y=\"" + paramInt2 + "\" width=\"" + paramInt3 + "\" height=\"" + paramInt4 + "\" rx=\"15\" ry=\"15\" style=\"fill:rgb(200,200,255);stroke-width:1;stroke:rgb(0,0,0)\" fill=\"none\" stroke=\"blue\" stroke-width=\"1\" />");
  }

  public int e()
  {
    return this.g;
  }

  public int h()
  {
    return this.f;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.l
 * JD-Core Version:    0.6.0
 */