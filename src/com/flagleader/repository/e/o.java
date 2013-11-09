package com.flagleader.repository.e;

import I;
import com.flagleader.engine.Property;
import com.flagleader.repository.IElement;
import com.flagleader.repository.d.u;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.rlm.RuleSetToken;
import com.flagleader.repository.rlm.action.MultiActionToken;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IJudgeToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IStatementContainerToken;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rom.FunctionMember;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.tree.DecisionElement;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.DecisionRelateAction;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.DecisionValue;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExpressionRule;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRule;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RuleMirror;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.repository.tree.RuleSetFlow;
import com.flagleader.repository.tree.RuleTreeFlow;
import com.flagleader.repository.tree.l;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class o extends m
{
  private static String d = "";
  private int e = 2;
  private int f = 2;
  private HashMap g = new HashMap();
  private int h = 0;
  StringBuffer a = new StringBuffer();
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private int[] l = null;
  private List m = new ArrayList();
  private String n = "";
  private int o = 16;
  public static final String b = "UTF-8";
  public static final int c = 16;

  static
  {
    try
    {
      d = FileUtil.readFromStream(o.class.getClassLoader().getResourceAsStream("vmlHeader.html"));
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public o()
  {
  }

  public o(PrintWriter paramPrintWriter)
  {
    super(paramPrintWriter);
  }

  public o(PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    super(paramPrintWriter, paramBoolean);
  }

  protected void a(int paramInt)
  {
    for (int i1 = 0; i1 < paramInt; i1++)
      d("&nbsp;");
  }

  protected void c()
  {
    d("<br>");
  }

  protected void a(String paramString)
  {
    d(StringUtil.replace("{print}", u.a("print.vml"), StringUtil.replace("{modify}", u.a("modify.vml"), StringUtil.replace("<TITLE></TITLE>", "<TITLE>" + paramString + "</TITLE>", d))));
  }

  protected void d()
  {
    d("</BODY></HTML>");
  }

  protected boolean a()
  {
    return true;
  }

  public String a(IRule paramIRule)
  {
    StringWriter localStringWriter = new StringWriter();
    this.p = new PrintWriter(localStringWriter);
    c(paramIRule);
    return localStringWriter.toString();
  }

  public void c(IElement paramIElement)
  {
    if ((paramIElement instanceof IRuleSet))
      if (((IRuleSet)paramIElement).getMainPackage() != null)
        this.o = ((IRuleSet)paramIElement).getMainPackage().getVmlFlowType();
      else
        this.o = 0;
    if (((paramIElement instanceof IRuleSet)) || ((paramIElement instanceof IRule)))
    {
      b();
      a(paramIElement.getDisplayName());
      if (paramIElement != null)
        paramIElement.acceptVisitor(this);
      if (((paramIElement instanceof IRule)) && (((IRule)paramIElement).getMainPackage() != null))
      {
        IPackageElement localIPackageElement = ((IRule)paramIElement).getMainPackage().findRuleHistory(paramIElement.getUuid(), paramIElement.toString());
        if (localIPackageElement != null)
          localIPackageElement.acceptVisitor(this);
      }
      d();
      j();
    }
  }

  private int c(String paramString)
  {
    paramString = paramString.trim();
    for (int i1 = paramString.indexOf("<a "); i1 >= 0; i1 = paramString.indexOf("<a ", i1))
    {
      i2 = paramString.indexOf(">", i1);
      if (i2 <= i1)
        break;
      paramString = paramString.substring(0, i1) + paramString.substring(i2 + 1, paramString.length());
    }
    paramString = StringUtil.replace("</a>", "", paramString);
    int i2 = paramString.getBytes().length;
    for (int i3 = 0; i3 < paramString.length(); i3++)
    {
      if (paramString.charAt(i3) != ' ')
        continue;
      i2++;
    }
    return i2;
  }

  private int f(String paramString)
  {
    return paramString.length();
  }

  private int g(String paramString)
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

  protected int a(IRuleTree paramIRuleTree)
  {
    if (this.o == 16)
      return 3;
    if (paramIRuleTree.getVmlFlowType() == 4)
      return 0;
    if ((this.o == 1) || (paramIRuleTree.getVmlFlowType() == 1))
      return 1;
    if ((this.o == 2) || (paramIRuleTree.getVmlFlowType() == 2))
      return 2;
    if ((this.o == 3) || (paramIRuleTree.getVmlFlowType() == 3))
      return 2;
    if ((this.o == 0) && (paramIRuleTree.getVmlFlowType() == 0))
      return 3;
    return 0;
  }

  protected String b(IRuleTree paramIRuleTree)
  {
    if (this.o == 16)
      return paramIRuleTree.getText();
    if (paramIRuleTree.getVmlFlowType() == 4)
      return null;
    if ((this.o == 1) || (paramIRuleTree.getVmlFlowType() == 1))
      return "";
    if ((this.o == 2) || (paramIRuleTree.getVmlFlowType() == 2))
      return paramIRuleTree.getDocument();
    if ((this.o == 3) || (paramIRuleTree.getVmlFlowType() == 3))
      return paramIRuleTree.getDocument();
    if ((this.o == 0) && (paramIRuleTree.getVmlFlowType() == 0))
      return paramIRuleTree.getText();
    return null;
  }

  protected String c(IRuleTree paramIRuleTree)
  {
    if (this.o == 16)
      return paramIRuleTree.getDisplayName();
    if (paramIRuleTree.getVmlFlowType() == 4)
      return null;
    if ((this.o == 1) || (paramIRuleTree.getVmlFlowType() == 1))
      return paramIRuleTree.getDisplayName();
    if ((this.o == 2) || (paramIRuleTree.getVmlFlowType() == 2))
      return "";
    if ((this.o == 3) || (paramIRuleTree.getVmlFlowType() == 3))
      return paramIRuleTree.getDisplayName();
    if ((this.o == 0) && (paramIRuleTree.getVmlFlowType() == 0))
      return paramIRuleTree.getDisplayName();
    return null;
  }

  protected void b(IRule paramIRule)
  {
    String str1 = b(paramIRule);
    int i1 = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    String str2 = c(paramIRule);
    int i2 = c(str2) + 2;
    if ((str2 == null) || (str2.length() == 0))
      i1 = 0;
    if (str1.length() > 0)
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new StringReader(str1));
        for (localObject = localBufferedReader.readLine(); localObject != null; localObject = localBufferedReader.readLine())
        {
          localObject = ((String)localObject).trim();
          if (((String)localObject).length() <= 0)
            continue;
          localStringBuffer.append(localObject + "<br>");
          int i4 = c((String)localObject);
          if (i4 > i2)
            i2 = i4;
          i1++;
        }
        localBufferedReader.close();
      }
      catch (IOException localIOException)
      {
      }
    i1 *= 17;
    i1 += 5;
    int i3 = i2 * 6 + 20;
    if (i3 < 120)
      i3 = 120;
    if (i3 > this.h)
      this.h = i3;
    this.f += (this.h - i3) / 2;
    d("<vml:roundrect id='" + paramIRule.getShortId() + "' ");
    if (a())
      if (paramIRule.getMainPackage() != null)
        d("ondblclick=viewRule('" + paramIRule.getUuid() + "','" + paramIRule.getMainPackage().getIdAndVersion() + "'); ");
      else
        d("ondblclick=viewRule('" + paramIRule.getUuid() + "',''); ");
    d("style='Z-INDEX: 1; LEFT: " + this.f + "px; VERTICAL-ALIGN: middle; WIDTH: " + i3 + "px; CURSOR: pointer; POSITION: absolute; TOP: " + this.e + "px; HEIGHT: " + i1 + "px; TEXT-ALIGN: left' coordsize='21600,21600' arcsize='4321f' fillcolor='#eeeeee' inset='2pt,2pt,2pt,2pt'>");
    d("<vml:shadow offset='3px,3px' color='#b3b3b3' type='single' on='T'></vml:shadow>");
    d("<vml:textbox ");
    if (!a())
      d("style='CURSOR: text;' ");
    d("title='" + paramIRule.getModifyUser() + "(" + Property.getInstance().formatDatetime(new Date(paramIRule.getModifyTime())) + ")" + "' inset='1pt,2pt,1pt,1pt'>");
    if ((str2 != null) && (str2.length() > 0))
      e("<font color=red><b>" + paramIRule.getDisplayName() + "</b></font>");
    if (localStringBuffer.length() > 0)
      e(localStringBuffer.toString());
    d("</vml:textbox>");
    if (paramIRule.isChangedshint())
      d("<vml:fill type=\"gradient\" color2=\"#FFFF00\"></vml:fill>");
    else
      d("<vml:fill type=\"gradient\" color2=\"#8E83F5\"></vml:fill>");
    d("</vml:roundrect>");
    Object localObject = new int[4];
    localObject[0] = this.f;
    localObject[1] = i3;
    localObject[2] = this.e;
    localObject[3] = i1;
    this.g.put(paramIRule.getUuid(), localObject);
    this.e += i1 + 10;
    this.f -= (this.h - i3) / 2;
  }

  public Object visitRule(Rule paramRule)
  {
    int i1 = a(paramRule);
    if (i1 == 0)
      return null;
    if (i1 < 3)
    {
      b(paramRule);
      return null;
    }
    String str1 = b(paramRule);
    if (str1 == null)
      return null;
    String str2 = "";
    if (paramRule.getMainPackage() != null)
    {
      IPackageElement localIPackageElement = paramRule.getMainPackage().findRuleHistory(paramRule.getUuid(), paramRule.toString());
      if (localIPackageElement != null)
        str2 = localIPackageElement.getText();
    }
    int i2 = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    String str3 = c(paramRule);
    int i3 = c(str3) + 2;
    if ((str3 == null) || (str3.length() == 0))
      i2 = 0;
    if (str1.length() > 0)
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new StringReader(str1));
        for (localObject = localBufferedReader.readLine(); localObject != null; localObject = localBufferedReader.readLine())
        {
          localObject = ((String)localObject).trim();
          if (((String)localObject).length() <= 0)
            continue;
          if (str2.indexOf((String)localObject) < 0)
            localStringBuffer.append("<font color=green>" + (String)localObject + "</font><br>");
          else
            localStringBuffer.append(localObject + "<br>");
          int i5 = c((String)localObject);
          if (i5 > i3)
            i3 = i5;
          i2++;
        }
        localBufferedReader.close();
      }
      catch (IOException localIOException)
      {
      }
    i2 *= 17;
    i2 += 5;
    int i4 = i3 * 6 + 20;
    if (i4 < 120)
      i4 = 120;
    if (i4 > this.h)
      this.h = i4;
    this.f += (this.h - i4) / 2;
    d("<vml:roundrect id='" + paramRule.getShortId() + "' ");
    if (a())
      if (paramRule.getMainPackage() != null)
        d("ondblclick=viewRule('" + paramRule.getUuid() + "','" + paramRule.getMainPackage().getIdAndVersion() + "'); ");
      else
        d("ondblclick=viewRule('" + paramRule.getUuid() + "',''); ");
    d("style='Z-INDEX: 1; LEFT: " + this.f + "px; VERTICAL-ALIGN: middle; WIDTH: " + i4 + "px; CURSOR: pointer; POSITION: absolute; TOP: " + this.e + "px; HEIGHT: " + i2 + "px; TEXT-ALIGN: left' coordsize='21600,21600' arcsize='4321f' fillcolor='#eeeeee' inset='2pt,2pt,2pt,2pt'>");
    d("<vml:shadow offset='3px,3px' color='#b3b3b3' type='single' on='T'></vml:shadow>");
    d("<vml:textbox ");
    if (!a())
      d("style='CURSOR: text;' ");
    d("title='" + paramRule.getModifyUser() + "(" + Property.getInstance().formatDatetime(new Date(paramRule.getModifyTime())) + ")" + "' inset='1pt,2pt,1pt,1pt'>");
    if ((str3 != null) && (str3.length() > 0))
      e("<font color=red><b>" + paramRule.getDisplayName() + "</b></font>");
    if (localStringBuffer.length() > 0)
      e(localStringBuffer.toString());
    d("</vml:textbox>");
    if (paramRule.isChangedshint())
      d("<vml:fill type=\"gradient\" color2=\"#FFFF00\"></vml:fill>");
    else
      d("<vml:fill type=\"gradient\" color2=\"#8E83F5\"></vml:fill>");
    d("</vml:roundrect>");
    Object localObject = new int[4];
    localObject[0] = this.f;
    localObject[1] = i4;
    localObject[2] = this.e;
    localObject[3] = i2;
    this.g.put(paramRule.getUuid(), localObject);
    this.e += i2 + 10;
    this.f -= (this.h - i4) / 2;
    return null;
  }

  public Object visitExpressionRule(ExpressionRule paramExpressionRule)
  {
    int i1 = a(paramExpressionRule);
    if (i1 == 0)
      return null;
    if (i1 < 3)
    {
      b(paramExpressionRule);
      return null;
    }
    String str1 = b(paramExpressionRule);
    if (str1 == null)
      return null;
    String str2 = "";
    if (paramExpressionRule.getMainPackage() != null)
    {
      IPackageElement localIPackageElement = paramExpressionRule.getMainPackage().findRuleHistory(paramExpressionRule.getUuid(), paramExpressionRule.toString());
      if (localIPackageElement != null)
        str2 = localIPackageElement.getText();
    }
    int i2 = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    String str3 = c(paramExpressionRule);
    int i3 = c(str3) + 2;
    if ((str3 == null) || (str3.length() == 0))
      i2 = 0;
    if (str1.length() > 0)
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new StringReader(str1));
        for (localObject = localBufferedReader.readLine(); localObject != null; localObject = localBufferedReader.readLine())
        {
          localObject = ((String)localObject).trim();
          if (((String)localObject).length() <= 0)
            continue;
          if (str2.indexOf((String)localObject) < 0)
            localStringBuffer.append("<font color=green>" + (String)localObject + "</font><br>");
          else
            localStringBuffer.append(localObject + "<br>");
          int i5 = c((String)localObject);
          if (i5 > i3)
            i3 = i5;
          i2++;
        }
        localBufferedReader.close();
      }
      catch (IOException localIOException)
      {
      }
    i2 *= 17;
    i2 += 5;
    int i4 = i3 * 6 + 20;
    if (i4 < 120)
      i4 = 120;
    if (i4 > this.h)
      this.h = i4;
    this.f += (this.h - i4) / 2;
    d("<vml:roundrect id='" + paramExpressionRule.getShortId() + "' ");
    if (a())
      if (paramExpressionRule.getMainPackage() != null)
        d("ondblclick=viewRule('" + paramExpressionRule.getUuid() + "','" + paramExpressionRule.getMainPackage().getIdAndVersion() + "'); ");
      else
        d("ondblclick=viewRule('" + paramExpressionRule.getUuid() + "',''); ");
    d("style='Z-INDEX: 1; LEFT: " + this.f + "px; VERTICAL-ALIGN: middle; WIDTH: " + i4 + "px; CURSOR: pointer; POSITION: absolute; TOP: " + this.e + "px; HEIGHT: " + i2 + "px; TEXT-ALIGN: left' coordsize='21600,21600' arcsize='4321f' fillcolor='#eeeeee' inset='2pt,2pt,2pt,2pt'>");
    d("<vml:shadow offset='3px,3px' color='#b3b3b3' type='single' on='T'></vml:shadow>");
    d("<vml:textbox ");
    if (!a())
      d("style='CURSOR: text;' ");
    d("title='" + paramExpressionRule.getModifyUser() + "(" + Property.getInstance().formatDatetime(new Date(paramExpressionRule.getModifyTime())) + ")" + "' inset='1pt,2pt,1pt,1pt'>");
    if ((str3 != null) && (str3.length() > 0))
      e("<font color=red><b>" + paramExpressionRule.getDisplayName() + "</b></font>");
    if (localStringBuffer.length() > 0)
      e(localStringBuffer.toString());
    d("</vml:textbox>");
    if (paramExpressionRule.isChangedshint())
      d("<vml:fill type=\"gradient\" color2=\"#FFFF00\"></vml:fill>");
    else
      d("<vml:fill type=\"gradient\" color2=\"#8E83F5\"></vml:fill>");
    d("</vml:roundrect>");
    Object localObject = new int[4];
    localObject[0] = this.f;
    localObject[1] = i4;
    localObject[2] = this.e;
    localObject[3] = i2;
    this.g.put(paramExpressionRule.getUuid(), localObject);
    this.e += i2 + 10;
    this.f -= (this.h - i4) / 2;
    return null;
  }

  public Object visitRuleMirror(RuleMirror paramRuleMirror)
  {
    String str = c(paramRuleMirror);
    if ((str == null) || (str.length() == 0))
      return null;
    int i1 = 1;
    int i2 = c(str);
    i1 *= 15;
    i1 += 5;
    int i3 = i2 * 6 + 20;
    if (i3 < 120)
      i3 = 120;
    if (i3 > this.h)
      this.h = i3;
    this.f += (this.h - i3) / 2;
    d("<vml:roundrect id='" + paramRuleMirror.getShortId() + "' ");
    if (a())
      if (paramRuleMirror.getMainPackage() != null)
        d("ondblclick=viewRuleMirror('" + paramRuleMirror.getUuid() + "','" + paramRuleMirror.getMainPackage().getIdAndVersion() + "'); ");
      else
        d("ondblclick=viewRuleMirror('" + paramRuleMirror.getUuid() + "',''); ");
    d("style='Z-INDEX: 1; LEFT: " + this.f + "px; VERTICAL-ALIGN: middle; WIDTH: " + i3 + "px; CURSOR: pointer; POSITION: absolute; TOP: " + this.e + "px; HEIGHT: " + i1 + "px; TEXT-ALIGN: left' coordsize='21600,21600' arcsize='4321f' fillcolor='#eeeeee' inset='2pt,2pt,2pt,2pt'>");
    d("<vml:shadow offset='3px,3px' color='#b3b3b3' type='single' on='T'></vml:shadow>");
    d("<vml:textbox ");
    if (!a())
      d("style='CURSOR: text;' ");
    d("title='" + paramRuleMirror.getModifyUser() + "(" + Property.getInstance().formatDatetime(new Date(paramRuleMirror.getModifyTime())) + ")" + "' inset='1pt,2pt,1pt,1pt'>");
    e("<font color=red><b>" + str + "</b></font>");
    d("</vml:textbox>");
    if (paramRuleMirror.isChangedshint())
      d("<vml:fill type=\"gradient\" color2=\"#FFFF00\"></vml:fill>");
    else
      d("<vml:fill type=\"gradient\" color2=\"#8E83F5\"></vml:fill>");
    d("</vml:roundrect>");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = this.f;
    arrayOfInt[1] = i3;
    arrayOfInt[2] = this.e;
    arrayOfInt[3] = i1;
    this.g.put(paramRuleMirror.getUuid(), arrayOfInt);
    this.e += i1 + 10;
    this.f -= (this.h - i3) / 2;
    return null;
  }

  private int[] a(DecisionRule paramDecisionRule)
  {
    this.k = 0;
    for (int i1 = 0; i1 < paramDecisionRule.getConditionNum(); i1++)
      this.l[i1] = f(paramDecisionRule.getFirstMember(i1 + 1));
    while (i1 < paramDecisionRule.getConditionNum() + paramDecisionRule.getMaxX())
    {
      if (paramDecisionRule.getFirstConditions().getCondition(i1 - paramDecisionRule.getConditionNum()) != null)
        this.l[i1] = f(paramDecisionRule.parseShortName(paramDecisionRule.getFirstConditions().getCondition(i1 - paramDecisionRule.getConditionNum()).toString(), paramDecisionRule.getSecondMember()));
      i1++;
    }
    List localList1 = paramDecisionRule.getFirstConditions().getConditionList();
    List localList2 = paramDecisionRule.getLineInfos();
    for (int i2 = 0; i2 < localList2.size(); i2++)
    {
      l locall = (l)localList2.get(i2);
      List localList3 = locall.a();
      i1 = 0;
      Object localObject;
      for (i1 = 0; i1 < localList3.size(); i1++)
      {
        localObject = paramDecisionRule.parseShortName(localList3.get(i1).toString(), paramDecisionRule.getFirstMember(i1 + 1));
        if (f((String)localObject) <= this.l[i1])
          continue;
        this.l[i1] = f((String)localObject);
      }
      for (i1 = paramDecisionRule.getConditionNum(); i1 < paramDecisionRule.getConditionNum() + paramDecisionRule.getMaxX(); i1++)
      {
        localObject = paramDecisionRule.getDecisionValue(localList3, paramDecisionRule.getFirstConditions().getCondition(i1 - paramDecisionRule.getConditionNum()));
        if (localObject == null)
          continue;
        int i3 = f(((DecisionValue)localObject).getValue().trim());
        if (this.l[i1] >= i3)
          continue;
        this.l[i1] = i3;
      }
    }
    return (I)this.l;
  }

  private void b(DecisionRule paramDecisionRule)
  {
    String str1 = paramDecisionRule.getText();
    String str2 = "";
    if (paramDecisionRule.getMainPackage() != null)
    {
      localObject1 = paramDecisionRule.getMainPackage().findRuleHistory(paramDecisionRule.getUuid(), paramDecisionRule.toString());
      if (localObject1 != null)
        str2 = ((IPackageElement)localObject1).getText();
    }
    Object localObject1 = paramDecisionRule.getFirstConditions().getConditionList();
    int i1 = paramDecisionRule.getConditionNum() + paramDecisionRule.getMaxX();
    this.a.setLength(0);
    this.k = 0;
    h("<tr>");
    if (paramDecisionRule.getMemberElement() != null)
      h("<td colspan='" + paramDecisionRule.getConditionNum() + "' nowrap align='center' >" + paramDecisionRule.getMemberElement().getDisplayName() + "</td>");
    else
      h("<td colspan='" + paramDecisionRule.getConditionNum() + "' nowrap align='center'></td>");
    h("<td colspan='" + paramDecisionRule.getMaxX() + "' nowrap align='center' >" + paramDecisionRule.getSecondMember() + "</td>");
    h("</tr>");
    h("<tr class='unchanged'>");
    for (int i2 = 0; i2 < paramDecisionRule.getConditionNum(); i2++)
      h("<td class='conditionTd' nowrap align='left'>" + paramDecisionRule.getFirstMember(i2 + 1) + "</td>");
    while (i2 < paramDecisionRule.getConditionNum() + paramDecisionRule.getMaxX())
    {
      if (paramDecisionRule.getFirstConditions().getCondition(i2 - paramDecisionRule.getConditionNum()) != null)
        h("<td class='conditionTd' nowrap align='left'>" + paramDecisionRule.parseShortName(paramDecisionRule.getFirstConditions().getCondition(i2 - paramDecisionRule.getConditionNum()).toString(), paramDecisionRule.getSecondMember()) + "</td>");
      else
        h("<td class='conditionTd' nowrap align='left'></td>");
      i2++;
    }
    h("</tr>");
    List localList1 = paramDecisionRule.getLineInfos();
    i2 = 0;
    BufferedReader localBufferedReader = new BufferedReader(new StringReader(str1));
    String str3 = "";
    try
    {
      str3 = localBufferedReader.readLine();
    }
    catch (Exception localException1)
    {
    }
    for (int i3 = 0; i3 < localList1.size(); i3++)
    {
      int i4 = 0;
      if ((str2 == null) || (str2.length() == 0))
        i4 = 0;
      else if ((str3 != null) && (str3.length() > 0) && (str2.indexOf(str3) < 0))
        i4 = 1;
      String str4 = "";
      if (i4 != 0)
        h("<tr class='changed'>");
      else
        h("<tr class='unchanged'>");
      l locall = (l)localList1.get(i3);
      List localList2 = locall.a();
      i2 = 0;
      Object localObject2;
      for (i2 = 0; i2 < localList2.size(); i2++)
      {
        if (locall.a(i2) <= 0)
          continue;
        localObject2 = paramDecisionRule.parseShortName(localList2.get(i2).toString(), paramDecisionRule.getFirstMember(i2 + 1));
        h("<td rowspan='" + locall.a(i2) + "' class='condition' nowrap align='center'>" + (String)localObject2 + "</td>");
      }
      for (i2 = paramDecisionRule.getConditionNum(); i2 < paramDecisionRule.getConditionNum() + paramDecisionRule.getMaxX(); i2++)
      {
        localObject2 = paramDecisionRule.getDecisionValue(localList2, paramDecisionRule.getFirstConditions().getCondition(i2 - paramDecisionRule.getConditionNum()));
        if (localObject2 != null)
          h("<td class='value1' nowrap align='center'>" + ((DecisionValue)localObject2).getValue().trim() + "</td>");
        else
          h("<td class='value1' nowrap align='center'></td>");
      }
      h("</tr>");
      try
      {
        str3 = localBufferedReader.readLine();
      }
      catch (Exception localException2)
      {
      }
    }
    this.i = (2 + localList1.size());
  }

  public Object visitDecisionRule(DecisionRule paramDecisionRule)
  {
    int i1 = a(paramDecisionRule);
    if (i1 == 0)
      return null;
    if (i1 < 3)
    {
      b(paramDecisionRule);
      return null;
    }
    this.l = new int[paramDecisionRule.getConditionNum() + paramDecisionRule.getMaxX()];
    this.l[0] = 2;
    a(paramDecisionRule);
    int i2 = 20;
    for (int i3 = 0; i3 < this.l.length; i3++)
      i2 += this.l[i3] * 10;
    if (i2 < 120)
      i2 = 120;
    if (i2 > this.h)
      this.h = i2;
    this.f += (this.h - i2) / 2;
    b(paramDecisionRule);
    i3 = 1;
    i3 = this.i * 20;
    i3 += 5;
    d("<vml:roundrect id='" + paramDecisionRule.getShortId() + "' ");
    if (a())
      if (paramDecisionRule.getMainPackage() != null)
        d("ondblclick=viewDecisionRule('" + paramDecisionRule.getUuid() + "','" + paramDecisionRule.getMainPackage().getIdAndVersion() + "'); ");
      else
        d("ondblclick=viewDecisionRule('" + paramDecisionRule.getUuid() + "',''); ");
    d("style='Z-INDEX: 1; LEFT: " + this.f + "px; VERTICAL-ALIGN: middle; WIDTH: " + i2 + "px; CURSOR: pointer; POSITION: absolute; TOP: " + this.e + "px; HEIGHT: " + i3 + "px; TEXT-ALIGN: left' coordsize='21600,21600' arcsize='4321f' fillcolor='#eeeeee' inset='2pt,2pt,2pt,2pt'>");
    d("<vml:shadow offset='3px,3px' color='#b3b3b3' type='single' on='T'></vml:shadow>");
    d("<vml:textbox ");
    if (!a())
      d("style='CURSOR: text;' ");
    d("title='" + paramDecisionRule.getModifyUser() + "(" + Property.getInstance().formatDatetime(new Date(paramDecisionRule.getModifyTime())) + ")" + "' inset='1pt,2pt,1pt,1pt'>");
    d("<table>");
    d(this.a.toString());
    d("</table>");
    d("</vml:textbox>");
    if (paramDecisionRule.isChangedshint())
      d("<vml:fill type=\"gradient\" color2=\"#FFFF00\"></vml:fill>");
    else
      d("<vml:fill type=\"gradient\" color2=\"#F4A8BD\"></vml:fill>");
    d("</vml:roundrect>");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = this.f;
    arrayOfInt[1] = i2;
    arrayOfInt[2] = this.e;
    arrayOfInt[3] = i3;
    this.g.put(paramDecisionRule.getUuid(), arrayOfInt);
    this.f -= (this.h - i2) / 2;
    this.e += i3 + 10;
    return null;
  }

  protected void a(List paramList, DecisionRelateRule paramDecisionRelateRule, int paramInt)
  {
    int i1 = 0;
    if ((this.m.size() > this.i) && (this.m.get(this.i - 1) != null))
      if ((this.n == null) || (this.n.length() == 0))
        i1 = 0;
      else if (this.n.indexOf(this.m.get(this.i - 1).toString()) < 0)
        i1 = 1;
    if (i1 != 0)
      h("<tr class='changed'>");
    else
      h("<tr class='unchanged'>");
    h("<td width='5%' nowrap class='pos' align='center'>" + this.i++ + "</td>");
    for (int i2 = 0; i2 < paramDecisionRelateRule.getConditionNum(); i2++)
      if (i2 < paramList.size())
      {
        localObject1 = paramDecisionRelateRule.parseShortName(paramList.get(i2).toString(), paramDecisionRelateRule.getFirstMember(i2 + 1));
        h("<td class='condition' nowrap align='left'>" + (String)localObject1 + "</td>");
      }
      else
      {
        h("<td class='condition' nowrap align='left'></td>");
      }
    Object localObject2;
    while (i2 < paramDecisionRelateRule.getConditionNum() + paramDecisionRelateRule.getValueNum())
    {
      if ((paramDecisionRelateRule.getDecisionElement(i2 - paramDecisionRelateRule.getConditionNum() + 1) != null) && (paramDecisionRelateRule.getDecisionElement(i2 - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement() != null))
      {
        localObject1 = "";
        localObject2 = paramDecisionRelateRule.getDecisionValue(paramList, paramDecisionRelateRule.getDecisionElement(i2 - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement());
        if (localObject2 != null)
        {
          localObject1 = ((DecisionElementValue)localObject2).getValue();
          h("<td class=value" + (((DecisionElementValue)localObject2).isTextValue() ? 1 : 0) + " nowrap align=center><span >" + (String)localObject1 + "</span></td>");
        }
        else
        {
          h("<td class='value1' nowrap align='center'></td>");
        }
      }
      else
      {
        h("<td class='value1' nowrap align='center'></td>");
      }
      i2++;
    }
    Object localObject1 = paramDecisionRelateRule.getDecisionAction(paramList);
    if (!((DecisionRelateAction)localObject1).isEmpty())
    {
      localObject2 = ((DecisionRelateAction)localObject1).getThenActions().getActions();
      int i3 = 0;
      h("<td class='value0' nowrap align='center'>");
      while (((Iterator)localObject2).hasNext())
      {
        h(((IStatementContainerToken)((Iterator)localObject2).next()).getText());
        h("<br>");
      }
      h("</td>");
    }
    else if (this.l[(i2 + 1)] > 0)
    {
      h("<td class='value0' nowrap align='center'></td>");
    }
    h("</tr>");
  }

  private int[] a(DecisionRelateRule paramDecisionRelateRule)
  {
    List localList = paramDecisionRelateRule.getConditions().getConditionList();
    for (int i1 = 0; i1 < localList.size(); i1++)
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localList.get(i1));
      a(localArrayList, paramDecisionRelateRule);
    }
    return this.l;
  }

  private void a(List paramList, DecisionRelateRule paramDecisionRelateRule)
  {
    if (paramList.size() < paramDecisionRelateRule.getConditionNum())
    {
      List localList = paramDecisionRelateRule.getNextConditions((IConditionToken)paramList.get(paramList.size() - 1), paramList.size());
      if (localList.size() == 0)
      {
        b(paramList, paramDecisionRelateRule);
      }
      else
      {
        if ((paramDecisionRelateRule.getValueNum() == 0) && (!paramDecisionRelateRule.getDecisionAction(paramList).isEmpty()))
          b(paramList, paramDecisionRelateRule);
        for (int i1 = 0; i1 < localList.size(); i1++)
        {
          ArrayList localArrayList = new ArrayList(paramList.size() + 1);
          localArrayList.addAll(paramList);
          localArrayList.add(localList.get(i1));
          a(localArrayList, paramDecisionRelateRule);
        }
      }
    }
    else
    {
      b(paramList, paramDecisionRelateRule);
    }
  }

  private void b(List paramList, DecisionRelateRule paramDecisionRelateRule)
  {
    for (int i1 = 0; i1 < paramDecisionRelateRule.getConditionNum(); i1++)
    {
      if (i1 >= paramList.size())
        continue;
      localObject1 = paramDecisionRelateRule.parseShortName(paramList.get(i1).toString(), paramDecisionRelateRule.getFirstMember(i1 + 1));
      int i2 = f((String)localObject1);
      if (this.l[(i1 + 1)] >= i2)
        continue;
      this.l[(i1 + 1)] = i2;
    }
    Object localObject2;
    int i3;
    while (i1 < paramDecisionRelateRule.getConditionNum() + paramDecisionRelateRule.getValueNum())
    {
      if ((paramDecisionRelateRule.getDecisionElement(i1 - paramDecisionRelateRule.getConditionNum() + 1) != null) && (paramDecisionRelateRule.getDecisionElement(i1 - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement() != null))
      {
        localObject1 = "";
        localObject2 = paramDecisionRelateRule.getDecisionValue(paramList, paramDecisionRelateRule.getDecisionElement(i1 - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement());
        if (localObject2 != null)
        {
          localObject1 = ((DecisionElementValue)localObject2).getValue();
          i3 = f((String)localObject1);
          if (this.l[(i1 + 1)] < i3)
            this.l[(i1 + 1)] = i3;
        }
      }
      i1++;
    }
    Object localObject1 = paramDecisionRelateRule.getDecisionAction(paramList);
    if (!((DecisionRelateAction)localObject1).isEmpty())
    {
      localObject2 = ((DecisionRelateAction)localObject1).getThenActions().getActions();
      i3 = 0;
      while (((Iterator)localObject2).hasNext())
      {
        i3++;
        int i4 = f(((IStatementContainerToken)((Iterator)localObject2).next()).getText());
        if (this.l[(i1 + 1)] >= i4)
          continue;
        this.l[(i1 + 1)] = i4;
      }
      if (i3 > 1)
        this.j += i3 - 1;
    }
  }

  public Object visitDecisionRelateRule(DecisionRelateRule paramDecisionRelateRule)
  {
    int i1 = a(paramDecisionRelateRule);
    if (i1 == 0)
      return null;
    if (i1 < 3)
    {
      b(paramDecisionRelateRule);
      return null;
    }
    this.a.setLength(0);
    this.k = 0;
    this.j = 0;
    this.i = 1;
    this.n = "";
    this.m.clear();
    this.l = new int[paramDecisionRelateRule.getConditionNum() + paramDecisionRelateRule.getValueNum() + 2];
    this.l[0] = 2;
    for (int i2 = 0; i2 < paramDecisionRelateRule.getConditionNum(); i2++)
    {
      if (paramDecisionRelateRule.getFirstMember(i2 + 1) == null)
        continue;
      i3 = f(paramDecisionRelateRule.getFirstMember(i2 + 1));
      if (this.l[(i2 + 1)] >= i3)
        continue;
      this.l[(i2 + 1)] = i3;
    }
    while (i2 < paramDecisionRelateRule.getConditionNum() + paramDecisionRelateRule.getValueNum())
    {
      if ((paramDecisionRelateRule.getDecisionElement(i2 - paramDecisionRelateRule.getConditionNum() + 1) != null) && (paramDecisionRelateRule.getDecisionElement(i2 - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement() != null))
      {
        i3 = f(paramDecisionRelateRule.getDecisionElement(i2 - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement().getDisplayName());
        if (this.l[(i2 + 1)] < i3)
          this.l[(i2 + 1)] = i3;
      }
      i2++;
    }
    a(paramDecisionRelateRule);
    this.i = 1;
    int i3 = 20;
    for (int i4 = 0; i4 < this.l.length; i4++)
      i3 += this.l[i4] * 10;
    if (i3 < 120)
      i3 = 120;
    if (i3 > this.h)
      this.h = i3;
    this.f += (this.h - i3) / 2;
    String str = paramDecisionRelateRule.getText();
    Object localObject1;
    if (paramDecisionRelateRule.getMainPackage() != null)
    {
      localObject1 = paramDecisionRelateRule.getMainPackage().findRuleHistory(paramDecisionRelateRule.getUuid(), paramDecisionRelateRule.toString());
      if (localObject1 != null)
        this.n = ((IPackageElement)localObject1).getText();
    }
    try
    {
      localObject1 = new BufferedReader(new StringReader(str));
      for (localObject2 = ((BufferedReader)localObject1).readLine(); localObject2 != null; localObject2 = ((BufferedReader)localObject1).readLine())
        this.m.add(localObject2);
      ((BufferedReader)localObject1).close();
    }
    catch (IOException localIOException)
    {
    }
    h("<tr class='unchanged'>");
    h("<td width='5%' nowrap align='center'></td>");
    for (i2 = 0; i2 < paramDecisionRelateRule.getConditionNum(); i2++)
      if (paramDecisionRelateRule.getFirstMember(i2 + 1) != null)
        h("<td class='conditionTd' nowrap align='left'>" + paramDecisionRelateRule.getFirstMember(i2 + 1) + "</td>");
      else
        h("<td class='conditionTd' nowrap align='left'></td>");
    while (i2 < paramDecisionRelateRule.getConditionNum() + paramDecisionRelateRule.getValueNum())
    {
      if ((paramDecisionRelateRule.getDecisionElement(i2 - paramDecisionRelateRule.getConditionNum() + 1) != null) && (paramDecisionRelateRule.getDecisionElement(i2 - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement() != null))
        h("<td class='conditionTd' nowrap align='left'>" + paramDecisionRelateRule.getDecisionElement(i2 - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement().getDisplayName() + "</td>");
      else
        h("<td class='conditionTd' nowrap align='left'></td>");
      i2++;
    }
    if (this.l[(i2 + 1)] > 0)
      h("<td class='conditionTd' nowrap align='left'></td>");
    h("</tr>");
    super.visitDecisionRelateRule(paramDecisionRelateRule);
    int i5 = 1;
    i5 = this.i * 20 + this.j * 16;
    i5 += 5;
    d("<vml:roundrect id='" + paramDecisionRelateRule.getShortId() + "' ");
    if (a())
      if (paramDecisionRelateRule.getMainPackage() != null)
        d("ondblclick=viewDecisionRelateRule('" + paramDecisionRelateRule.getUuid() + "','" + paramDecisionRelateRule.getMainPackage().getIdAndVersion() + "'); ");
      else
        d("ondblclick=viewDecisionRelateRule('" + paramDecisionRelateRule.getUuid() + "',''); ");
    d("style='Z-INDEX: 1; LEFT: " + this.f + "px; VERTICAL-ALIGN: middle; WIDTH: " + i3 + "px; CURSOR: pointer; POSITION: absolute; TOP: " + this.e + "px; HEIGHT: " + i5 + "px; TEXT-ALIGN: left' coordsize='21600,21600' arcsize='4321f' fillcolor='#eeeeee' inset='2pt,2pt,2pt,2pt'>");
    d("<vml:shadow offset='3px,3px' color='#b3b3b3' type='single' on='T'></vml:shadow>");
    d("<vml:textbox ");
    if (!a())
      d("style='CURSOR: text;' ");
    d("title='" + paramDecisionRelateRule.getModifyUser() + "(" + Property.getInstance().formatDatetime(new Date(paramDecisionRelateRule.getModifyTime())) + ")" + "' inset='1pt,2pt,1pt,1pt'>");
    d("<table>");
    d(this.a.toString());
    d("</table>");
    d("</vml:textbox>");
    if (paramDecisionRelateRule.isChangedshint())
      d("<vml:fill type=\"gradient\" color2=\"#FFFF00\"></vml:fill>");
    else
      d("<vml:fill type=\"gradient\" color2=\"#F4A8BD\"></vml:fill>");
    d("</vml:roundrect>");
    Object localObject2 = new int[4];
    localObject2[0] = this.f;
    localObject2[1] = i3;
    localObject2[2] = this.e;
    localObject2[3] = i5;
    this.g.put(paramDecisionRelateRule.getUuid(), localObject2);
    this.f -= (this.h - i3) / 2;
    this.e += i5 + 10;
    return null;
  }

  public Object visitDecisionMultiRule(DecisionMultiRule paramDecisionMultiRule)
  {
    int i1 = a(paramDecisionMultiRule);
    if (i1 == 0)
      return null;
    if (i1 < 3)
    {
      b(paramDecisionMultiRule);
      return null;
    }
    this.l = new int[1 + paramDecisionMultiRule.getConditionNum() + paramDecisionMultiRule.getValueNum()];
    this.l[0] = 2;
    a(paramDecisionMultiRule);
    int i2 = 20;
    for (int i3 = 0; i3 < this.l.length; i3++)
      i2 += this.l[i3] * 10 + 10;
    if (i2 < 120)
      i2 = 120;
    if (i2 > this.h)
      this.h = i2;
    this.f += (this.h - i2) / 2;
    b(paramDecisionMultiRule);
    i3 = 1;
    i3 = this.i * 20;
    i3 += 5;
    d("<vml:roundrect id='" + paramDecisionMultiRule.getShortId() + "' ");
    if (a())
      if (paramDecisionMultiRule.getMainPackage() != null)
        d("ondblclick=viewDecisionMultiRule('" + paramDecisionMultiRule.getUuid() + "','" + paramDecisionMultiRule.getMainPackage().getIdAndVersion() + "'); ");
      else
        d("ondblclick=viewDecisionMultiRule('" + paramDecisionMultiRule.getUuid() + "',''); ");
    d("style='Z-INDEX: 1; LEFT: " + this.f + "px; VERTICAL-ALIGN: middle; WIDTH: " + i2 + "px; CURSOR: pointer; POSITION: absolute; TOP: " + this.e + "px; HEIGHT: " + i3 + "px; TEXT-ALIGN: left' coordsize='21600,21600' arcsize='4321f' fillcolor='#eeeeee' inset='2pt,2pt,2pt,2pt'>");
    d("<vml:shadow offset='3px,3px' color='#b3b3b3' type='single' on='T'></vml:shadow>");
    d("<vml:textbox ");
    if (!a())
      d("style='CURSOR: text;' ");
    d("title='" + paramDecisionMultiRule.getModifyUser() + "(" + Property.getInstance().formatDatetime(new Date(paramDecisionMultiRule.getModifyTime())) + ")" + "' inset='1pt,2pt,1pt,1pt'>");
    d("<table>");
    d(this.a.toString());
    d("</table>");
    d("</vml:textbox>");
    if (paramDecisionMultiRule.isChangedshint())
      d("<vml:fill type=\"gradient\" color2=\"#FFFF00\"></vml:fill>");
    else
      d("<vml:fill type=\"gradient\" color2=\"#F4A8BD\"></vml:fill>");
    d("</vml:roundrect>");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = this.f;
    arrayOfInt[1] = i2;
    arrayOfInt[2] = this.e;
    arrayOfInt[3] = i3;
    this.g.put(paramDecisionMultiRule.getUuid(), arrayOfInt);
    this.f -= (this.h - i2) / 2;
    this.e += i3 + 10;
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
      int i3 = f(localIMultiConditionToken.getSameFirstValue().getDisplayName());
      if (this.l[(i1 + 1)] >= i3)
        continue;
      this.l[(i1 + 1)] = i3;
    }
    while (i1 < paramDecisionMultiRule.getConditionNum() + paramDecisionMultiRule.getValueNum())
    {
      if ((paramDecisionMultiRule.getDecisionElement(i1 - paramDecisionMultiRule.getConditionNum() + 1) != null) && (paramDecisionMultiRule.getDecisionElement(i1 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement() != null))
      {
        i2 = f(paramDecisionMultiRule.getDecisionElement(i1 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement().getDisplayName());
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
            i6 = f(((IMultiConditionToken)localObject).getCondition(arrayOfInt[i1]).toString());
            if (this.l[(i1 + 1)] < i6)
              this.l[(i1 + 1)] = i6;
          }
          else if (((IMultiConditionToken)localObject).getCondition(arrayOfInt[i1]).getCompareOperator().getType() == 0)
          {
            i6 = f(((IMultiConditionToken)localObject).getCondition(arrayOfInt[i1]).getComparedValue().toString());
            if (this.l[(i1 + 1)] < i6)
              this.l[(i1 + 1)] = i6;
          }
          else
          {
            String str = paramDecisionMultiRule.parseShortName(((IMultiConditionToken)localObject).getCondition(arrayOfInt[i1]).toString(), ((IMultiConditionToken)localObject).getSameFirstValue().toString());
            int i8 = f(str);
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
            int i7 = f((String)localObject);
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
    h("<tr class='unchanged'>");
    h("<td width='5%' nowrap align='center'></td>");
    for (int i2 = 0; i2 < paramDecisionMultiRule.getConditionNum(); i2++)
    {
      IMultiConditionToken localIMultiConditionToken = paramDecisionMultiRule.getConditions(i2 + 1);
      if (localIMultiConditionToken.getSameFirstValue() != null)
        h("<td class='conditionTd' nowrap align='left'>" + localIMultiConditionToken.getSameFirstValue().getDisplayName() + "</td>");
      else
        h("<td class='conditionTd' nowrap align='left'></td>");
    }
    while (i2 < paramDecisionMultiRule.getConditionNum() + paramDecisionMultiRule.getValueNum())
    {
      if ((paramDecisionMultiRule.getDecisionElement(i2 - paramDecisionMultiRule.getConditionNum() + 1) != null) && (paramDecisionMultiRule.getDecisionElement(i2 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement() != null))
        h("<td class='conditionTd' nowrap align='left'>" + paramDecisionMultiRule.getDecisionElement(i2 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement().getDisplayName() + "</td>");
      else
        h("<td class='conditionTd' nowrap align='left'></td>");
      i2++;
    }
    h("</tr>");
    int i3 = 1;
    int[] arrayOfInt = new int[paramDecisionMultiRule.getConditionNum()];
    for (int i4 = 0; i4 < paramDecisionMultiRule.getConditionNum(); i4++)
      arrayOfInt[i4] = 0;
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
      int i5 = 0;
      if ((str2 == null) || (str2.length() == 0))
        i5 = 0;
      else if ((str3 != null) && (str3.length() > 0) && (str2.indexOf(str3) < 0))
        i5 = 1;
      String str4 = "";
      if (i5 != 0)
        h("<tr class='changed'>");
      else
        h("<tr class='unchanged'>");
      h("<td width='5%' class='pos' nowrap align='center'>" + i3++ + "</td>");
      i2 = 0;
      ArrayList localArrayList = new ArrayList(paramDecisionMultiRule.getConditionNum());
      Object localObject;
      while (i2 < paramDecisionMultiRule.getConditionNum())
      {
        localObject = paramDecisionMultiRule.getConditions(i2 + 1);
        localArrayList.add(((IMultiConditionToken)localObject).getCondition(arrayOfInt[i2]));
        if ((a(i2, arrayOfInt)) && (((IMultiConditionToken)localObject).getCondition(arrayOfInt[i2]) != null))
        {
          int i6 = a(i2, arrayOfInt, paramDecisionMultiRule);
          if (((IMultiConditionToken)localObject).getSameFirstValue() == null)
          {
            h("<td rowspan='" + i6 + "' class='condition' nowrap align='left'>" + ((IMultiConditionToken)localObject).getCondition(arrayOfInt[i2]).toString() + "</td>");
            str4 = str4 + ((IMultiConditionToken)localObject).getCondition(arrayOfInt[i2]).toString();
          }
          else if (((IMultiConditionToken)localObject).getCondition(arrayOfInt[i2]).getCompareOperator().getType() == 0)
          {
            h("<td rowspan='" + i6 + "' class='condition' nowrap align='left'>" + ((IMultiConditionToken)localObject).getCondition(arrayOfInt[i2]).getComparedValue().toString() + "</td>");
            str4 = str4 + ((IMultiConditionToken)localObject).getCondition(arrayOfInt[i2]).getComparedValue().toString();
          }
          else
          {
            String str5 = paramDecisionMultiRule.parseShortName(((IMultiConditionToken)localObject).getCondition(arrayOfInt[i2]).toString(), ((IMultiConditionToken)localObject).getSameFirstValue().toString());
            h("<td rowspan='" + i6 + "' class='condition' nowrap align='left'>" + str5 + "</td>");
            str4 = str4 + str5;
          }
        }
        i2++;
      }
      while (i2 < paramDecisionMultiRule.getConditionNum() + paramDecisionMultiRule.getValueNum())
      {
        if ((paramDecisionMultiRule.getDecisionElement(i2 - paramDecisionMultiRule.getConditionNum() + 1) != null) && (paramDecisionMultiRule.getDecisionElement(i2 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement() != null))
        {
          localObject = "";
          DecisionElementValue localDecisionElementValue = paramDecisionMultiRule.getDecisionValue(localArrayList, paramDecisionMultiRule.getDecisionElement(i2 - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement());
          if (localDecisionElementValue != null)
          {
            localObject = localDecisionElementValue.getValue();
            h("<td class=value" + (localDecisionElementValue.isTextValue() ? 1 : 0) + " nowrap align=center><span  >" + (String)localObject + "</span></td>");
          }
          else
          {
            h("<td class='value1' nowrap align='center'></td>");
          }
        }
        else
        {
          h("<td class='value1' nowrap align='center'></td>");
        }
        i2++;
      }
      h("</tr>");
      arrayOfInt = paramDecisionMultiRule.getNextDecision(arrayOfInt);
      try
      {
        str3 = localBufferedReader.readLine();
      }
      catch (Exception localException2)
      {
      }
    }
    while (arrayOfInt != null);
    this.i = i3;
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

  private void h(String paramString)
  {
    this.a.append(paramString);
  }

  protected void f()
  {
    d("</tr>");
  }

  protected void g()
  {
    d("<tr>");
  }

  protected void a(String paramString, int paramInt)
  {
    d("<td>" + paramString + "</td>");
  }

  private String a(String paramString1, String paramString2)
  {
    int[] arrayOfInt1 = (int[])this.g.get(paramString1);
    int[] arrayOfInt2 = (int[])this.g.get(paramString2);
    if ((arrayOfInt1 != null) && (arrayOfInt2 != null))
    {
      int i1 = arrayOfInt1[0] + arrayOfInt1[1] / 2;
      int i2 = arrayOfInt1[2] + arrayOfInt1[3] - 1;
      int i3 = arrayOfInt2[0] + arrayOfInt2[1] / 2;
      int i4 = arrayOfInt2[2] - 1;
      if (i1 < i3)
        return " filled=\"false\" style=' Z-INDEX: 2; POSITION: absolute;' Points=\"" + i1 + "," + i2 + " " + i1 + "," + i4 + "\" ";
      return "filled=\"false\" style=' Z-INDEX: 2; POSITION: absolute;' Points=\"" + i3 + "," + i2 + " " + i3 + "," + i4 + "\" ";
    }
    return "filled=\"false\" style='DISPLAY: none; Z-INDEX: 2; POSITION: absolute;' Points=\"0,0 0,0\"";
  }

  private String c(String paramString1, String paramString2)
  {
    int[] arrayOfInt1 = (int[])this.g.get(paramString1);
    int[] arrayOfInt2 = (int[])this.g.get(paramString2);
    if ((arrayOfInt1 != null) && (arrayOfInt2 != null))
    {
      int i1 = arrayOfInt1[0] + arrayOfInt1[1] - 1;
      int i2 = arrayOfInt1[2] + arrayOfInt1[3] / 2;
      int i3 = arrayOfInt2[0] + arrayOfInt2[1] / 2;
      int i4 = arrayOfInt2[2] - 1;
      if (i1 < i3)
        return " filled=\"false\" style=' Z-INDEX: 2; POSITION: absolute;' Points=\"" + i1 + "," + i2 + " " + i3 + "," + i2 + " " + i3 + "," + i4 + "\" ";
      return "filled=\"false\" style=' Z-INDEX: 2; POSITION: absolute;' Points=\"" + i1 + "," + i2 + " " + i1 + "," + i4 + "\" ";
    }
    return "filled=\"false\" style='DISPLAY: none; Z-INDEX: 2; POSITION: absolute;' Points=\"0,0 0,0\"";
  }

  public Object visitRulePackage(RulePackage paramRulePackage)
  {
    List localList = paramRulePackage.getRulesList();
    int i1 = 0;
    Object localObject;
    int i3;
    for (int i2 = 0; i2 < localList.size(); i2++)
    {
      localObject = (IRuleTree)localList.get(i2);
      if ((!((IRuleTree)localObject).canVmlShow()) || (a((IRuleTree)localObject) <= 0))
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
      localObject = (IRuleTree)localList.get(i2);
      if ((!((IRuleTree)localObject).canVmlShow()) || (a((IRuleTree)localObject) <= 0))
        continue;
      if (i1 == 0)
      {
        d("<vml:PolyLine ctype=1 title='' coordsize='21600,21600' arcsize='4321f' object='" + ((IElement)localList.get(i2)).getShortId() + "' source='" + paramRulePackage.getShortId() + "' " + c(paramRulePackage.getUuid(), ((IElement)localList.get(i2)).getUuid()) + ">");
        d("<vml:stroke endarrow='block'></vml:stroke><vml:shadow offset='1px,1px' color='#888888' type='single' on='T'></vml:shadow>");
        d("<vml:textbox ");
        if (!a())
          d("style='CURSOR: text;' ");
        d("title='then' inset='1pt,2pt,1pt,1pt'></vml:textbox>");
        d("</vml:PolyLine>");
      }
      i1 = 1;
      for (i3 = 1; i3 < localList.size() - i2; i3++)
        if (((IPackageElement)localList.get(i2 + i3)).getVml() == 0)
          break;
      if (i2 + i3 > localList.size() - 1)
        continue;
      d("<vml:PolyLine title='' coordsize='21600,21600' arcsize='4321f' object='" + ((IElement)localList.get(i2 + i3)).getShortId() + "' source='" + ((IElement)localList.get(i2)).getShortId() + "' " + a(((IElement)localList.get(i2)).getUuid(), ((IElement)localList.get(i2 + i3)).getUuid()) + ">");
      d("<vml:stroke endarrow='block'></vml:stroke><vml:shadow offset='1px,1px' color='#b3b3b3' type='single' on='T'></vml:shadow>");
      d("<vml:textbox ");
      if (!a())
        d(" style='CURSOR: text;' ");
      d("title='next' inset='1pt,2pt,1pt,1pt'></vml:textbox>");
      d("</vml:PolyLine>");
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

  protected void l()
  {
  }

  protected String a(RuleSet paramRuleSet)
  {
    if (paramRuleSet.getVmlFlowType() == 4)
      return null;
    if ((this.o == 1) || (paramRuleSet.getVmlFlowType() == 1))
      return "";
    if ((this.o == 2) || (paramRuleSet.getVmlFlowType() == 2))
      return paramRuleSet.getDocument();
    if ((this.o == 3) || (paramRuleSet.getVmlFlowType() == 3))
      return paramRuleSet.getDocument();
    if ((this.o == 0) && (paramRuleSet.getVmlFlowType() == 0))
      return paramRuleSet.getText();
    return null;
  }

  public Object visitRuleSet(RuleSet paramRuleSet)
  {
    int i1 = 1;
    int i2 = c(paramRuleSet.getDisplayName()) + 2;
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramRuleSet.getVml() == 0)
    {
      String str1 = a(paramRuleSet);
      if ((str1 != null) && (str1.length() > 0))
        try
        {
          BufferedReader localBufferedReader = new BufferedReader(new StringReader(str1));
          for (String str2 = localBufferedReader.readLine(); str2 != null; str2 = localBufferedReader.readLine())
          {
            if (str2.length() <= 0)
              continue;
            localStringBuffer.append(str2 + "<br>");
            int i5 = c(str2);
            for (i6 = 0; i6 < str2.length(); i6++)
            {
              if (str2.charAt(i6) != ' ')
                continue;
              i5++;
            }
            if (i5 > i2)
              i2 = i5;
            i1++;
          }
          localBufferedReader.close();
        }
        catch (IOException localIOException)
        {
        }
    }
    i1 *= 17;
    i1 += 5;
    int i3 = i2 * 6 + 20;
    if (i3 < 120)
      i3 = 120;
    if (i3 > this.h)
      this.h = i3;
    this.f += (this.h - i3) / 2;
    d("<vml:roundrect id='" + paramRuleSet.getShortId() + "' ");
    if (a())
      if (paramRuleSet.getMainPackage() != null)
        d("ondblclick=viewRuleSet('" + paramRuleSet.getUuid() + "','" + paramRuleSet.getMainPackage().getIdAndVersion() + "'); ");
      else
        d("ondblclick=viewRuleSet('" + paramRuleSet.getUuid() + "',''); ");
    d("style='Z-INDEX: 1; LEFT: " + this.f + "px; VERTICAL-ALIGN: middle; WIDTH: " + i3 + "px; CURSOR: pointer; POSITION: absolute; TOP: " + this.e + "px; HEIGHT: " + i1 + "px; TEXT-ALIGN: left' coordsize='21600,21600' arcsize='4321f' fillcolor='#eeeeee' inset='2pt,2pt,2pt,2pt'>");
    d("<vml:shadow offset='3px,3px' color='#b3b3b3' type='single' on='T'></vml:shadow>");
    d("<vml:textbox ");
    if (!a())
      d("style='CURSOR: text;' ");
    d("title='" + paramRuleSet.getModifyUser() + "(" + Property.getInstance().formatDatetime(new Date(paramRuleSet.getModifyTime())) + ")" + "' inset='1pt,2pt,1pt,1pt'>");
    e("<font color=red><b>" + paramRuleSet.getDisplayName() + "</b></font>");
    if (localStringBuffer.length() > 0)
      e(localStringBuffer.toString());
    d("</vml:textbox>");
    d("<vml:fill type=\"gradient\" color2=\"#00EE00\"></vml:fill>");
    d("</vml:roundrect>");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = this.f;
    arrayOfInt[1] = i3;
    arrayOfInt[2] = this.e;
    arrayOfInt[3] = i1;
    this.g.put(paramRuleSet.getUuid(), arrayOfInt);
    this.f += i3 / 2 + 5;
    int i4 = this.h;
    this.h = (i3 + 10);
    this.e += i1 + 10;
    List localList = paramRuleSet.getRulesList();
    int i6 = 0;
    IRuleTree localIRuleTree;
    for (int i7 = 0; i7 < localList.size(); i7++)
    {
      localIRuleTree = (IRuleTree)localList.get(i7);
      if ((!localIRuleTree.canVmlShow()) || (a(localIRuleTree) <= 0))
        continue;
      ((IElement)localList.get(i7)).acceptVisitor(this);
      i6 = 1;
      for (int i8 = 1; i8 < localList.size() - i7; i8++)
        if (((IPackageElement)localList.get(i7 + i8)).getVml() == 0)
          break;
    }
    i6 = 0;
    for (i7 = 0; i7 < localList.size(); i7++)
    {
      localIRuleTree = (IRuleTree)localList.get(i7);
      if ((!localIRuleTree.canVmlShow()) || (a(localIRuleTree) <= 0))
        continue;
      if (i6 == 0)
      {
        String str3 = paramRuleSet.getRuleSetToken().getTestConditions().getText().trim();
        if (str3.endsWith(m.q))
          str3 = str3.substring(0, str3.length() - m.q.length());
        int i10 = c(str3) * 6 + 140;
        d("<vml:PolyLine ctype=1 title='then' style='width:" + i10 + "pt;' coordsize='21600,21600' arcsize='4321f' object='" + ((IElement)localList.get(i7)).getShortId() + "' source='" + paramRuleSet.getShortId() + "' " + c(paramRuleSet.getUuid(), ((IElement)localList.get(i7)).getUuid()) + ">");
        d("<vml:stroke endarrow='block'></vml:stroke><vml:shadow offset='1px,1px' color='#888888' type='single' on='T'></vml:shadow>");
        d("<vml:textbox ");
        if (!a())
          d("style='CURSOR: text;' ");
        d("inset='10pt,-10pt,100pt,100pt'>");
        if ((paramRuleSet.getEditType() > 0) && (paramRuleSet.getRuleSetToken().getTestConditions().hasChildren()))
          d(str3);
        d("</vml:textbox>");
        d("</vml:PolyLine>");
      }
      i6 = 1;
      for (int i9 = 1; i9 < localList.size() - i7; i9++)
        if (((IPackageElement)localList.get(i7 + i9)).getVml() == 0)
          break;
      if (i7 + i9 > localList.size() - 1)
        continue;
      d("<vml:PolyLine title='' coordsize='21600,21600' arcsize='4321f' object='" + ((IElement)localList.get(i7 + i9)).getShortId() + "' source='" + ((IElement)localList.get(i7)).getShortId() + "' " + a(((IElement)localList.get(i7)).getUuid(), ((IElement)localList.get(i7 + i9)).getUuid()) + ">");
      d("<vml:stroke endarrow='block'></vml:stroke><vml:shadow offset='1px,1px' color='#b3b3b3' type='single' on='T'></vml:shadow>");
      d("<vml:textbox ");
      if (!a())
        d("style='CURSOR: text;' ");
      d(" title='next' inset='1pt,2pt,1pt,1pt'></vml:textbox>");
      d("</vml:PolyLine>");
    }
    this.h = i4;
    this.f -= i3 / 2 + 5;
    this.f -= (this.h - i3) / 2;
    return null;
  }

  public Object visitRuleSetFlow(RuleSetFlow paramRuleSetFlow)
  {
    int i1 = 1;
    int i2 = c(paramRuleSetFlow.getDisplayName());
    i1 *= 15;
    i1 += 5;
    int i3 = i2 * 6 + 20;
    if (i3 < 120)
      i3 = 120;
    if (i3 > this.h)
      this.h = i3;
    this.f += (this.h - i3) / 2;
    d("<vml:roundrect id='" + paramRuleSetFlow.getShortId() + "' ");
    if (a())
      if (paramRuleSetFlow.getMainPackage() != null)
        d("ondblclick=viewRuleFlow('" + paramRuleSetFlow.getUuid() + "','" + paramRuleSetFlow.getMainPackage().getIdAndVersion() + "');");
      else
        d("ondblclick=viewRuleFlow('" + paramRuleSetFlow.getUuid() + "','');");
    d(" style='Z-INDEX: 1; LEFT: " + this.f + "px; VERTICAL-ALIGN: middle; WIDTH: " + i3 + "px; CURSOR: pointer; POSITION: absolute; TOP: " + this.e + "px; HEIGHT: " + i1 + "px; TEXT-ALIGN: left' coordsize='21600,21600' arcsize='4321f' fillcolor='#eeeeee' inset='2pt,2pt,2pt,2pt'>");
    d("<vml:shadow offset='3px,3px' color='#b3b3b3' type='single' on='T'></vml:shadow>");
    d("<vml:textbox ");
    if (!a())
      d("style='CURSOR: text;' ");
    d("title='" + paramRuleSetFlow.getModifyUser() + "(" + Property.getInstance().formatDatetime(new Date(paramRuleSetFlow.getModifyTime())) + ")" + "' inset='1pt,2pt,1pt,1pt'>");
    e("<font color=red><b>" + paramRuleSetFlow.getDisplayName() + "</b></font>");
    d("</vml:textbox>");
    d("<vml:fill type=\"gradient\" color2=\"#00EE00\"></vml:fill>");
    d("</vml:roundrect>");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = this.f;
    arrayOfInt[1] = i3;
    arrayOfInt[2] = this.e;
    arrayOfInt[3] = i1;
    this.g.put(paramRuleSetFlow.getUuid(), arrayOfInt);
    this.f += i3 / 2 + 5;
    this.e += i1 + 10;
    this.f -= i3 / 2 + 5;
    this.f -= (this.h - i3) / 2;
    return null;
  }

  public Object visitRulePoolFlow(RulePoolFlow paramRulePoolFlow)
  {
    int i1 = 1;
    int i2 = c(paramRulePoolFlow.getDisplayName());
    i1 *= 15;
    i1 += 5;
    int i3 = i2 * 6 + 20;
    if (i3 < 120)
      i3 = 120;
    if (i3 > this.h)
      this.h = i3;
    this.f += (this.h - i3) / 2;
    d("<vml:roundrect id='" + paramRulePoolFlow.getShortId() + "' ");
    if (a())
      if (paramRulePoolFlow.getMainPackage() != null)
        d("ondblclick=viewRuleFlow('" + paramRulePoolFlow.getUuid() + "','" + paramRulePoolFlow.getMainPackage().getIdAndVersion() + "');");
      else
        d("ondblclick=viewRuleFlow('" + paramRulePoolFlow.getUuid() + "','');");
    d(" style='Z-INDEX: 1; LEFT: " + this.f + "px; VERTICAL-ALIGN: middle; WIDTH: " + i3 + "px; CURSOR: pointer; POSITION: absolute; TOP: " + this.e + "px; HEIGHT: " + i1 + "px; TEXT-ALIGN: left' coordsize='21600,21600' arcsize='4321f' fillcolor='#eeeeee' inset='2pt,2pt,2pt,2pt'>");
    d("<vml:shadow offset='3px,3px' color='#b3b3b3' type='single' on='T'></vml:shadow>");
    d("<vml:textbox ");
    if (!a())
      d("style='CURSOR: text;' ");
    d("title='" + paramRulePoolFlow.getModifyUser() + "(" + Property.getInstance().formatDatetime(new Date(paramRulePoolFlow.getModifyTime())) + ")" + "' inset='1pt,2pt,1pt,1pt'>");
    e("<font color=red><b>" + paramRulePoolFlow.getDisplayName() + "</b></font>");
    d("</vml:textbox>");
    d("<vml:fill type=\"gradient\" color2=\"#00EE00\"></vml:fill>");
    d("</vml:roundrect>");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = this.f;
    arrayOfInt[1] = i3;
    arrayOfInt[2] = this.e;
    arrayOfInt[3] = i1;
    this.g.put(paramRulePoolFlow.getUuid(), arrayOfInt);
    this.f += i3 / 2 + 5;
    this.e += i1 + 10;
    this.f -= i3 / 2 + 5;
    this.f -= (this.h - i3) / 2;
    return null;
  }

  public Object visitRuleTreeFlow(RuleTreeFlow paramRuleTreeFlow)
  {
    int i1 = 1;
    int i2 = c(paramRuleTreeFlow.getDisplayName());
    i1 *= 15;
    i1 += 5;
    int i3 = i2 * 6 + 20;
    if (i3 < 120)
      i3 = 120;
    if (i3 > this.h)
      this.h = i3;
    this.f += (this.h - i3) / 2;
    d("<vml:roundrect id='" + paramRuleTreeFlow.getShortId() + "' ");
    if (a())
      if (paramRuleTreeFlow.getMainPackage() != null)
        d("ondblclick=viewRuleFlow('" + paramRuleTreeFlow.getUuid() + "','" + paramRuleTreeFlow.getMainPackage().getIdAndVersion() + "');");
      else
        d("ondblclick=viewRuleFlow('" + paramRuleTreeFlow.getUuid() + "','');");
    d(" style='Z-INDEX: 1; LEFT: " + this.f + "px; VERTICAL-ALIGN: middle; WIDTH: " + i3 + "px; CURSOR: pointer; POSITION: absolute; TOP: " + this.e + "px; HEIGHT: " + i1 + "px; TEXT-ALIGN: left' coordsize='21600,21600' arcsize='4321f' fillcolor='#eeeeee' inset='2pt,2pt,2pt,2pt'>");
    d("<vml:shadow offset='3px,3px' color='#b3b3b3' type='single' on='T'></vml:shadow>");
    d("<vml:textbox ");
    if (!a())
      d("style='CURSOR: text;' ");
    d("title='" + paramRuleTreeFlow.getModifyUser() + "(" + Property.getInstance().formatDatetime(new Date(paramRuleTreeFlow.getModifyTime())) + ")" + "' inset='1pt,2pt,1pt,1pt'>");
    e("<font color=red><b>" + paramRuleTreeFlow.getDisplayName() + "</b></font>");
    d("</vml:textbox>");
    d("<vml:fill type=\"gradient\" color2=\"#00EE00\"></vml:fill>");
    d("</vml:roundrect>");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = this.f;
    arrayOfInt[1] = i3;
    arrayOfInt[2] = this.e;
    arrayOfInt[3] = i1;
    this.g.put(paramRuleTreeFlow.getUuid(), arrayOfInt);
    this.f += i3 / 2 + 5;
    this.e += i1 + 10;
    this.f -= i3 / 2 + 5;
    this.f -= (this.h - i3) / 2;
    return null;
  }

  protected void a(IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    d("<tr>" + q);
    d("  <td width=\"16%\">");
    d(paramIBusinessObjectEditen.isVisible() ? u.a("yes.hed") : u.a("no.hed"));
    d("</td>" + q);
    d("<td width=\"28%\">");
    d(paramIBusinessObjectEditen.getValueName());
    d("</td>" + q);
    d("<td width=\"28%\">");
    d(paramIBusinessObjectEditen.getValueType());
    d("</td>" + q);
    d("<td width=\"28%\">");
    d(paramIBusinessObjectEditen.getDisplayName());
    d("</td>" + q);
    d("</tr>" + q);
  }

  public Object visitFunctionMember(FunctionMember paramFunctionMember)
  {
    d("<tr>" + q);
    d("  <td width=\"16%\">");
    d(paramFunctionMember.isVisible() ? u.a("yes.hed") : u.a("no.hed"));
    d("</td>" + q);
    d("<td width=\"28%\">");
    d(paramFunctionMember.getFunctionName());
    d("</td>" + q);
    d("<td width=\"28%\">");
    d(paramFunctionMember.getValueType());
    d("</td>" + q);
    d("<td width=\"28%\">");
    d(paramFunctionMember.getDisplayName());
    d("</td>" + q);
    d("</tr>" + q);
    return null;
  }

  public static String b(String paramString)
  {
    String str1 = StringUtil.getFirstRegular(paramString.toLowerCase(), "charset=([^\"]+)[*\\s|\"]");
    if ((str1 != null) && (str1.length() > 9))
    {
      String str2 = str1.substring(8, str1.length() - 1).trim();
      if (Charset.isSupported(str2))
        return str2;
    }
    return "UTF-8";
  }

  protected void a(ITreeNode paramITreeNode)
  {
    c();
    if (!(paramITreeNode instanceof Envionment))
    {
      d("<p align=\"center\"><font size=\"5\">");
      d(paramITreeNode.getDisplayName());
      d("</font></p>" + q);
      d("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse: collapse\" bordercolor=\"#111111\" width=\"100%\" >" + q);
      d("  <tr>" + q);
      d("    <td width=\"16%\">" + q);
      d("<p align=\"center\">" + u.a("isvisible.hed") + "</td>" + q);
      d("    <td width=\"28%\">" + q);
      d("<p align=\"center\">" + u.a("name.hed") + "</td>" + q);
      d("<td width=\"28%\">" + q);
      d("<p align=\"center\">" + u.a("type.hed") + "</td>" + q);
      d("<td width=\"28%\">" + q);
      d("<p align=\"center\">" + u.a("displayname.hed") + "</td>" + q);
      d("</tr>" + q);
    }
    f(paramITreeNode);
    if (!(paramITreeNode instanceof Envionment))
      d("</table>" + q);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.o
 * JD-Core Version:    0.6.0
 */