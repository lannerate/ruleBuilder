package com.flagleader.repository.e;

import com.flagleader.db.Sheet;
import com.flagleader.repository.IElement;
import com.flagleader.repository.d.u;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.ProcedureModel;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.db.ViewModel;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.rlm.ElseIfRuleToken;
import com.flagleader.repository.rlm.RuleEnterToken;
import com.flagleader.repository.rlm.RuleSetToken;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.e;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IJudgeToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rom.FunctionMember;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.DecisionElement;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.DecisionRelateAction;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.DecisionValue;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExpressionRule;
import com.flagleader.repository.tree.IRule;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.repository.tree.RuleSetFlow;
import com.flagleader.repository.tree.RuleTreeFlow;
import com.flagleader.repository.tree.l;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class k extends m
{
  private String a = "";
  private IRuleSet b = null;
  private static String c;

  static
  {
    try
    {
      c = FileUtil.readFromStream(k.class.getClassLoader().getResourceAsStream("htmlHeader.html"));
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public k()
  {
  }

  public k(PrintWriter paramPrintWriter)
  {
    super(paramPrintWriter);
  }

  public k(PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    super(paramPrintWriter, paramBoolean);
  }

  protected void a(int paramInt)
  {
    for (int i = 0; i < paramInt; i++)
      d("&nbsp;");
  }

  protected void c()
  {
    d("<br>");
  }

  protected void a(String paramString)
  {
    d(StringUtil.replace("<TITLE></TITLE>", "<TITLE>" + paramString + "</TITLE>", c));
  }

  protected void a()
  {
    d("</BODY></HTML>");
  }

  public void c(IElement paramIElement)
  {
    if (((paramIElement instanceof IRuleSet)) || ((paramIElement instanceof Envionment)))
    {
      b();
      a(paramIElement.getDisplayName());
      if (paramIElement != null)
        paramIElement.acceptVisitor(this);
      a();
      j();
    }
  }

  public String a(Envionment paramEnvionment)
  {
    StringWriter localStringWriter = new StringWriter();
    this.p = new PrintWriter(localStringWriter);
    b();
    a(paramEnvionment.getDisplayName());
    if (paramEnvionment != null)
    {
      Iterator localIterator1 = paramEnvionment.getDBModels();
      while (localIterator1.hasNext())
      {
        DBModel localDBModel = (DBModel)localIterator1.next();
        d("<p><font size=\"5\">");
        d(localDBModel.getDisplayName());
        d("</font></p>" + q);
        Iterator localIterator2 = localDBModel.getChildrenIterator();
        while (localIterator2.hasNext())
        {
          Object localObject = localIterator2.next();
          if ((localObject instanceof CustomSql))
          {
            ((CustomSql)localObject).acceptVisitor(this);
          }
          else
          {
            if (!(localObject instanceof ISelectObject))
              continue;
            ((ISelectObject)localObject).acceptVisitor(this);
          }
        }
      }
    }
    a();
    j();
    return localStringWriter.toString();
  }

  protected void d()
  {
    d("<tr>" + q);
  }

  protected void e()
  {
    d("</tr>" + q);
  }

  protected void b(String paramString)
  {
    paramString = StringUtil.replace("\n", "<br>", paramString);
    d("<td wrap class=f>" + paramString + "</td>");
  }

  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = StringUtil.replace("\n", "<br>", paramString);
    d("<td wrap");
    if (paramInt1 > 1)
      d(" rows=" + paramInt1);
    if (paramInt2 > 1)
      d(" cols=" + paramInt2);
    d(" class=f>" + paramString + "</td>");
  }

  protected void a(String[] paramArrayOfString)
  {
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      String str = StringUtil.replace("\n", "<br>", paramArrayOfString[i]);
      d("<td wrap class=f>" + str + "</td>");
    }
  }

  protected void c(String paramString)
  {
    d("<td wrap class=h><b>" + paramString + "</b></td>");
  }

  protected void a(IRuleTree paramIRuleTree, String paramString)
  {
    d("<p/><th align=\"center\"><font size=\"4\">");
    d(this.a);
    d(" ");
    d(paramString);
    d(" : ");
    d(paramIRuleTree.getDisplayName());
    d("</font></th>" + q);
  }

  protected void a(IElement paramIElement)
  {
  }

  public Object visitRule(Rule paramRule)
  {
    a(paramRule, Rule.DISPLAYNAME);
    a(paramRule);
    d("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" class=tableBorder>" + q);
    d("<tr>" + q);
    d("<td wrap class=h><b>" + Rule.DISPLAYNAME + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("tv_condition") + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("tv_action") + "</b></td>" + q);
    d("</tr>" + q);
    List localList = paramRule.getRuleTableInfos();
    for (int i = 0; i < localList.size(); i++)
    {
      d();
      e locale = (e)localList.get(i);
      c(locale.a());
      if (locale.e() == 0)
      {
        b(paramRule.getText(((RuleToken)locale.f()).getWhenCondition()));
        b(paramRule.getText(((RuleToken)locale.f()).getThenActions()));
      }
      else if ((locale.e() == 4) || (locale.e() == 3) || (locale.e() == 5))
      {
        b("");
        b(paramRule.getText((IMultiActionToken)locale.f()));
      }
      else if (locale.e() == 2)
      {
        b(paramRule.getText(((RuleEnterToken)locale.f()).getWhenCondition()));
        b("");
      }
      else if (locale.e() == 1)
      {
        b(paramRule.getText(((ElseIfRuleToken)locale.f()).getWhenCondition()));
        b(paramRule.getText(((ElseIfRuleToken)locale.f()).getThenActions()));
      }
      e();
    }
    d("</table>" + q);
    return null;
  }

  public Object visitDecisionRule(DecisionRule paramDecisionRule)
  {
    a(paramDecisionRule, DecisionRule.DISPLAYNAME);
    a(paramDecisionRule);
    d("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" class=tableBorder>" + q);
    d();
    d("<td wrap cols=" + (paramDecisionRule.getConditionNum() - 1) + " class=h><b>" + paramDecisionRule.getMemberElement().getDisplayName() + "</b></td>");
    d("<td wrap cols=" + (paramDecisionRule.getConditionNum() + paramDecisionRule.getMaxX() - 1) + " class=h><b>" + paramDecisionRule.getSecondMember() + "</b></td>");
    e();
    int i = 0;
    d();
    while (i < paramDecisionRule.getConditionNum())
    {
      c(paramDecisionRule.getFirstMember(i + 1));
      i++;
    }
    while (i < paramDecisionRule.getConditionNum() + paramDecisionRule.getMaxX())
    {
      if (paramDecisionRule.getFirstConditions().getCondition(i - paramDecisionRule.getConditionNum()) != null)
        c(paramDecisionRule.parseShortName(paramDecisionRule.getFirstConditions().getCondition(i - paramDecisionRule.getConditionNum()).toString(), paramDecisionRule.getSecondMember()));
      else
        c("");
      i++;
    }
    e();
    List localList1 = paramDecisionRule.getFirstConditions().getConditionList();
    List localList2 = paramDecisionRule.getLineInfos();
    for (int j = 0; j < localList2.size(); j++)
    {
      d();
      l locall = (l)localList2.get(j);
      List localList3 = locall.a();
      i = 0;
      Object localObject;
      for (i = 0; i < localList3.size(); i++)
      {
        if (locall.a(i) <= 0)
          continue;
        localObject = paramDecisionRule.parseShortName(localList3.get(i).toString(), paramDecisionRule.getFirstMember(i + 1));
        a((String)localObject, locall.a(i), 1);
      }
      for (i = paramDecisionRule.getConditionNum(); i < paramDecisionRule.getConditionNum() + paramDecisionRule.getMaxX(); i++)
      {
        localObject = paramDecisionRule.getDecisionValue(localList3, paramDecisionRule.getFirstConditions().getCondition(i - paramDecisionRule.getConditionNum()));
        if (localObject != null)
          b(((DecisionValue)localObject).getValue().trim());
        else
          b("");
      }
      e();
    }
    d("</table>" + q);
    return null;
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

  public Object visitRuleToken(RuleToken paramRuleToken)
  {
    return null;
  }

  private void a(IRuleSet paramIRuleSet)
  {
    this.b = paramIRuleSet;
    this.a = "";
  }

  public Object visitRulePackage(RulePackage paramRulePackage)
  {
    a(paramRulePackage);
    d("<p align=\"center\"><font size=\"5\">");
    d(paramRulePackage.getDisplayName());
    d("</font></p>" + q);
    a(paramRulePackage);
    String str = this.a;
    int i = 1;
    Iterator localIterator = paramRulePackage.getChildrenIterator();
    while (localIterator.hasNext())
    {
      this.a = (str + String.valueOf(i++) + ".");
      ((IElement)localIterator.next()).acceptVisitor(this);
    }
    return null;
  }

  public Object visitRuleSet(RuleSet paramRuleSet)
  {
    a(paramRuleSet, RuleSet.DISPLAYNAME);
    a(paramRuleSet);
    d("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" class=tableBorder>" + q);
    if (paramRuleSet.isInitTestType())
    {
      d();
      c(u.a("init.text"));
      b(paramRuleSet.getRuleSetToken().getInitActions().getText());
      e();
      d();
      c(u.a("condition.text"));
      b(paramRuleSet.getRuleSetToken().getTestConditions().getText());
      e();
      if (paramRuleSet.isFirst())
      {
        d();
        c(u.a("first.text"));
        b(paramRuleSet.getRuleSetToken().getFirstActions().getText());
        e();
      }
    }
    else if (paramRuleSet.isTestType())
    {
      d();
      c(u.a("condition.text"));
      b(paramRuleSet.getRuleSetToken().getTestConditions().getText());
      e();
      if (paramRuleSet.isFirst())
      {
        d();
        c(u.a("first.text"));
        b(paramRuleSet.getRuleSetToken().getFirstActions().getText());
        e();
      }
    }
    else if (paramRuleSet.isForType())
    {
      d();
      c(u.a("init.text"));
      c(paramRuleSet.getRuleSetToken().getInitActions().getText());
      e();
      d();
      c(u.a("test.text"));
      c(paramRuleSet.getRuleSetToken().getTestConditions().getText());
      e();
      d();
      c(u.a("block.text"));
      c(paramRuleSet.getRuleSetToken().getBlockActions().getText());
      e();
      if (paramRuleSet.isFirst())
      {
        d();
        c(u.a("first.text"));
        b(paramRuleSet.getRuleSetToken().getFirstActions().getText());
        e();
      }
    }
    d("</table>" + q);
    String str = this.a;
    int i = 1;
    Iterator localIterator = paramRuleSet.getChildrenIterator();
    while (localIterator.hasNext())
    {
      IElement localIElement = (IElement)localIterator.next();
      if (!(localIElement instanceof IRuleTree))
        continue;
      this.a = (str + String.valueOf(i++) + ".");
      ((IRuleTree)localIElement).acceptVisitor(this);
    }
    return null;
  }

  protected void a(ITreeNode paramITreeNode)
  {
    if ((!(paramITreeNode instanceof Envionment)) && (!(paramITreeNode instanceof DBModel)) && (!(paramITreeNode instanceof BOContainerGroup)))
    {
      d("<th align=\"center\"><font size=\"4\">");
      d(paramITreeNode.getDisplayName());
      d("</font></th>" + q);
      d("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" class=tableBorder>" + q);
      d("<tr>" + q);
      d("<td width=\"6%\" wrap class=h><b>" + u.a("isvisible.hed") + "</b></td>" + q);
      d("<td wrap class=h><b>" + u.a("name.hed") + "</b></td>" + q);
      d("<td wrap class=h><b>" + u.a("type.hed") + "</b></td>" + q);
      d("<td wrap class=h><b>" + u.a("displayname.hed") + "</b></td>" + q);
      d("</tr>" + q);
    }
    f(paramITreeNode);
    if ((!(paramITreeNode instanceof Envionment)) && (!(paramITreeNode instanceof DBModel)) && (!(paramITreeNode instanceof BOContainerGroup)))
      d("</table>" + q);
  }

  protected void a(IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    d("<tr>" + q);
    d("<td width=\"6%\" wrap class=f>");
    d(paramIBusinessObjectEditen.isVisible() ? u.a("yes.hed") : u.a("no.hed"));
    d("</td>" + q);
    d("<td wrap class=f>");
    d(paramIBusinessObjectEditen.getValueName());
    d("</td>" + q);
    d("<td wrap class=f>");
    d(paramIBusinessObjectEditen.getValueType());
    d("</td>" + q);
    d("<td wrap class=f>");
    d(paramIBusinessObjectEditen.getDisplayName());
    d("</td>" + q);
    d("</tr>" + q);
  }

  public Object visitFunctionMember(FunctionMember paramFunctionMember)
  {
    d("<tr>" + q);
    d("  <td width=\"6%\" wrap class=f>");
    d(paramFunctionMember.isVisible() ? u.a("yes.hed") : u.a("no.hed"));
    d("</td>" + q);
    d("<td wrap class=f>");
    d(paramFunctionMember.getFunctionName());
    d("</td>" + q);
    d("<td wrap class=f>");
    d(paramFunctionMember.getValueType());
    d("</td>" + q);
    d("<td wrap class=f>");
    d(paramFunctionMember.getDisplayName());
    d("</td>" + q);
    d("</tr>" + q);
    return null;
  }

  public Object visitFieldModel(FieldModel paramFieldModel)
  {
    d("<tr>" + q);
    d("  <td wrap class=f>");
    d(paramFieldModel.getFieldName());
    d("</td>" + q);
    d("<td wrap class=f>");
    d(paramFieldModel.getFieldType());
    d("</td>" + q);
    d("<td wrap class=f>");
    d(paramFieldModel.getValueType());
    d("</td>" + q);
    d("<td wrap class=f>");
    d(paramFieldModel.getDisplayName());
    d("</td>" + q);
    d("</tr>" + q);
    return null;
  }

  public Object visitSheetFieldModel(SheetFieldModel paramSheetFieldModel)
  {
    d("<tr>" + q);
    b(paramSheetFieldModel.getFieldName());
    b(paramSheetFieldModel.getValueType());
    b(paramSheetFieldModel.getDisplayName());
    b(paramSheetFieldModel.getGroupName());
    d("</tr>" + q);
    return null;
  }

  public Object visitSelectTable(SelectTable paramSelectTable)
  {
    d("<th align=\"center\"><font size=\"4\">");
    d(paramSelectTable.getDisplayName());
    d("</font></th>" + q);
    d("<th>" + paramSelectTable.getSqlSelect() + "</th>");
    d("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" class=tableBorder>" + q);
    d("<tr>" + q);
    d("<td wrap class=h><b>" + u.a("fieldName.hed") + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("fieldType.hed") + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("valueType.hed") + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("displayName.hed") + "</b></td>" + q);
    d("</tr>" + q);
    List localList = paramSelectTable.getFields();
    for (int i = 0; i < localList.size(); i++)
      ((FieldModel)localList.get(i)).acceptVisitor(this);
    d("</table>" + q);
    return null;
  }

  public Object visitCustomSql(CustomSql paramCustomSql)
  {
    d("<th align=\"center\"><font size=\"4\">");
    d(paramCustomSql.getDisplayName());
    d("</font></th>" + q);
    d(paramCustomSql.getSqlCustom());
    return null;
  }

  public Object visitTableModel(TableModel paramTableModel)
  {
    d("<th align=\"center\"><font size=\"4\">");
    d(paramTableModel.getDisplayName() + "(" + paramTableModel.getTableName() + ")");
    d("</font></th>" + q);
    d("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" class=tableBorder>" + q);
    d("<tr>" + q);
    d("<td wrap class=h><b>" + u.a("fieldName.hed") + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("fieldType.hed") + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("valueType.hed") + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("displayName.hed") + "</b></td>" + q);
    d("</tr>" + q);
    List localList = paramTableModel.getFields();
    for (int i = 0; i < localList.size(); i++)
      ((FieldModel)localList.get(i)).acceptVisitor(this);
    d("</table>" + q);
    return null;
  }

  public Object visitSheetTable(SheetTable paramSheetTable)
  {
    d("<th align=\"center\"><font size=\"4\">");
    d(paramSheetTable.getDisplayName());
    d("</font></th>" + q);
    a(paramSheetTable);
    d("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" class=tableBorder>" + q);
    d("<tr>" + q);
    d("<td wrap class=h><b>" + u.a("fieldName.hed") + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("valueType.hed") + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("displayName.hed") + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("groupName.hed") + "</b></td>" + q);
    d("</tr>" + q);
    List localList = paramSheetTable.getFields();
    for (int i = 0; i < localList.size(); i++)
      ((SheetFieldModel)localList.get(i)).acceptVisitor(this);
    d("</table><p/>" + q);
    if (paramSheetTable.isSaveValue())
    {
      d("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" class=tableBorder>" + q);
      d("<tr><td class=h></td>" + q);
      localList = paramSheetTable.getFields();
      for (i = 0; i < localList.size(); i++)
        d("<td wrap class=h><b>" + ((SheetFieldModel)localList.get(i)).getDisplayName() + "</b></td>" + q);
      d("</tr>" + q);
      try
      {
        Sheet localSheet = paramSheetTable.getSheetData();
        localSheet.beforeFirst();
        int j = 0;
        while (localSheet.next())
        {
          d("<tr>" + q);
          j++;
          d("<td wrap class=f>" + j + "</td>" + q);
          Object[] arrayOfObject = localSheet.getCurrentValues();
          for (int k = 0; k < arrayOfObject.length; k++)
            d("<td wrap class=f>" + StringUtil.stringValue(arrayOfObject[k]) + "</td>" + q);
          d("</tr>" + q);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      d("</table>" + q);
    }
    return null;
  }

  public Object visitProcedureModel(ProcedureModel paramProcedureModel)
  {
    d("<p align=\"center\"><font size=\"4\">");
    d(paramProcedureModel.getDisplayName());
    d("</font></p>" + q);
    d(paramProcedureModel.getSqlSelect());
    if (paramProcedureModel.getFields().size() > 0)
    {
      d("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" class=tableBorder>" + q);
      d("<tr>" + q);
      d("<td wrap class=h><b>" + u.a("fieldName.hed") + "</b></td>" + q);
      d("<td wrap class=h><b>" + u.a("fieldType.hed") + "</b></td>" + q);
      d("<td wrap class=h><b>" + u.a("valueType.hed") + "</b></td>" + q);
      d("<td wrap class=h><b>" + u.a("displayName.hed") + "</b></td>" + q);
      d("</tr>" + q);
      List localList = paramProcedureModel.getFields();
      for (int i = 0; i < localList.size(); i++)
        ((FieldModel)localList.get(i)).acceptVisitor(this);
      d("</table>" + q);
    }
    return null;
  }

  public Object visitViewModel(ViewModel paramViewModel)
  {
    d("<p align=\"center\"><font size=\"4\">");
    d(paramViewModel.getDisplayName() + "(" + paramViewModel.getTableName() + ")");
    d("</font></p>" + q);
    d("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" class=tableBorder>" + q);
    d("<tr>" + q);
    d("<td wrap class=h><b>" + u.a("fieldName.hed") + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("fieldType.hed") + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("valueType.hed") + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("displayName.hed") + "</b></td>" + q);
    d("</tr>" + q);
    List localList = paramViewModel.getFields();
    for (int i = 0; i < localList.size(); i++)
      ((FieldModel)localList.get(i)).acceptVisitor(this);
    d("</table>" + q);
    return null;
  }

  public Object visitDecisionMultiRule(DecisionMultiRule paramDecisionMultiRule)
  {
    a(paramDecisionMultiRule, DecisionMultiRule.DISPLAYNAME);
    a(paramDecisionMultiRule);
    d("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" class=tableBorder>" + q);
    d();
    for (int i = 0; i < paramDecisionMultiRule.getConditionNum(); i++)
    {
      IMultiConditionToken localIMultiConditionToken = paramDecisionMultiRule.getConditions(i + 1);
      if (localIMultiConditionToken.getSameFirstValue() != null)
        c(localIMultiConditionToken.getSameFirstValue().getDisplayName());
      else
        c("");
    }
    while (i < paramDecisionMultiRule.getConditionNum() + paramDecisionMultiRule.getValueNum())
    {
      if ((paramDecisionMultiRule.getDecisionElement(i - paramDecisionMultiRule.getConditionNum() + 1) != null) && (paramDecisionMultiRule.getDecisionElement(i - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement() != null))
        c(paramDecisionMultiRule.getDecisionElement(i - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement().getDisplayName());
      else
        c("");
      i++;
    }
    e();
    int j = 1;
    int[] arrayOfInt = new int[paramDecisionMultiRule.getConditionNum()];
    for (int k = 0; k < paramDecisionMultiRule.getConditionNum(); k++)
      arrayOfInt[k] = 0;
    do
    {
      d();
      i = 0;
      ArrayList localArrayList = new ArrayList(paramDecisionMultiRule.getConditionNum());
      Object localObject;
      while (i < paramDecisionMultiRule.getConditionNum())
      {
        localObject = paramDecisionMultiRule.getConditions(i + 1);
        IConditionToken localIConditionToken = ((IMultiConditionToken)localObject).getCondition(arrayOfInt[i]);
        if (localIConditionToken != null)
          localArrayList.add(localIConditionToken);
        if (localIConditionToken != null)
        {
          if (((IMultiConditionToken)localObject).getSameFirstValue() == null)
            c(localIConditionToken.toString());
          else if ((localIConditionToken.getCompareOperator().getType() == 0) && (!localIConditionToken.getNextTests().hasNext()))
          {
            if (localIConditionToken.getComparedValue() != null)
              c(localIConditionToken.getComparedValue().toString());
            else
              c("");
          }
          else
            c(paramDecisionMultiRule.parseShortName(localIConditionToken.toString(), ((IMultiConditionToken)localObject).getSameFirstValue().toString()));
        }
        else
          c("");
        i++;
      }
      while (i < paramDecisionMultiRule.getConditionNum() + paramDecisionMultiRule.getValueNum())
      {
        if (paramDecisionMultiRule.getDecisionElement(i - paramDecisionMultiRule.getConditionNum() + 1) == null)
        {
          b("");
        }
        else
        {
          localObject = paramDecisionMultiRule.getDecisionValue(localArrayList, paramDecisionMultiRule.getDecisionElement(i - paramDecisionMultiRule.getConditionNum() + 1).getMemberElement());
          if ((paramDecisionMultiRule.getDecisionElement(i - paramDecisionMultiRule.getConditionNum() + 1) != null) && (localObject != null))
            b(((DecisionElementValue)localObject).getValue());
          else
            b("");
        }
        i++;
      }
      arrayOfInt = paramDecisionMultiRule.getNextDecision(arrayOfInt);
      e();
    }
    while (arrayOfInt != null);
    d("</table>" + q);
    return null;
  }

  public Object visitExpressionRule(ExpressionRule paramExpressionRule)
  {
    a(paramExpressionRule, ExpressionRule.DISPLAYNAME);
    a(paramExpressionRule);
    d("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" class=tableBorder>" + q);
    d();
    b(paramExpressionRule.getExpression());
    d("</table>" + q);
    return null;
  }

  public Object visitDecisionRelateRule(DecisionRelateRule paramDecisionRelateRule)
  {
    a(paramDecisionRelateRule, DecisionRelateRule.DISPLAYNAME);
    a(paramDecisionRelateRule);
    d("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" class=tableBorder>" + q);
    d();
    for (int i = 0; i < paramDecisionRelateRule.getConditionNum(); i++)
      b(paramDecisionRelateRule.getFirstMember(i + 1));
    while (i < paramDecisionRelateRule.getConditionNum() + paramDecisionRelateRule.getValueNum())
    {
      if ((paramDecisionRelateRule.getDecisionElement(i - paramDecisionRelateRule.getConditionNum() + 1) != null) && (paramDecisionRelateRule.getDecisionElement(i - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement() != null))
        b(paramDecisionRelateRule.getDecisionElement(i - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement().getDisplayName());
      else
        b("");
      i++;
    }
    e();
    List localList = paramDecisionRelateRule.getConditions().getConditionList();
    for (int j = 0; j < localList.size(); j++)
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localList.get(j));
      a(paramDecisionRelateRule, localArrayList);
    }
    d("</table>" + q);
    return null;
  }

  private void a(DecisionRelateRule paramDecisionRelateRule, List paramList)
  {
    if (paramList.size() < paramDecisionRelateRule.getConditionNum())
    {
      List localList = paramDecisionRelateRule.getNextConditions((IConditionToken)paramList.get(paramList.size() - 1), paramList.size());
      if (localList.size() == 0)
      {
        b(paramDecisionRelateRule, paramList);
      }
      else
      {
        if ((paramDecisionRelateRule.getValueNum() == 0) && (!paramDecisionRelateRule.getDecisionAction(paramList).isEmpty()))
          b(paramDecisionRelateRule, paramList);
        for (int i = 0; i < localList.size(); i++)
        {
          ArrayList localArrayList = new ArrayList(paramList.size() + 1);
          localArrayList.addAll(paramList);
          localArrayList.add(localList.get(i));
          a(paramDecisionRelateRule, localArrayList);
        }
      }
    }
    else
    {
      b(paramDecisionRelateRule, paramList);
    }
  }

  private void b(DecisionRelateRule paramDecisionRelateRule, List paramList)
  {
    d();
    for (int i = 0; i < paramDecisionRelateRule.getConditionNum(); i++)
    {
      if (paramList.size() <= i)
        continue;
      b(paramDecisionRelateRule.parseShortName(paramList.get(i).toString(), paramDecisionRelateRule.getFirstMember(i + 1)));
    }
    while (i < paramDecisionRelateRule.getConditionNum() + paramDecisionRelateRule.getValueNum())
    {
      if (paramDecisionRelateRule.getDecisionElement(i - paramDecisionRelateRule.getConditionNum() + 1) == null)
      {
        b("");
      }
      else
      {
        localObject = paramDecisionRelateRule.getDecisionValue(paramList, paramDecisionRelateRule.getDecisionElement(i - paramDecisionRelateRule.getConditionNum() + 1).getMemberElement());
        if ((paramDecisionRelateRule.getDecisionElement(i - paramDecisionRelateRule.getConditionNum() + 1) != null) && (localObject != null))
          b(((DecisionElementValue)localObject).getValue());
        else
          b("");
      }
      i++;
    }
    Object localObject = paramDecisionRelateRule.getDecisionAction(paramList);
    if (!((DecisionRelateAction)localObject).isEmpty())
      b(paramDecisionRelateRule.getText(((DecisionRelateAction)localObject).getThenActions()));
    else
      b("");
    e();
  }

  public Object visitRuleSetFlow(RuleSetFlow paramRuleSetFlow)
  {
    Iterator localIterator = paramRuleSetFlow.getAllRuleElement().iterator();
    while (localIterator.hasNext())
    {
      IElement localIElement = (IElement)localIterator.next();
      if ((localIElement instanceof IRule))
      {
        d(localIElement);
      }
      else
      {
        if (!(localIElement instanceof IRuleSet))
          continue;
        d(localIElement);
      }
    }
    return null;
  }

  public Object visitRuleTreeFlow(RuleTreeFlow paramRuleTreeFlow)
  {
    Iterator localIterator = paramRuleTreeFlow.getAllRuleElement().iterator();
    while (localIterator.hasNext())
    {
      IElement localIElement = (IElement)localIterator.next();
      if ((localIElement instanceof IRule))
      {
        d(localIElement);
      }
      else
      {
        if (!(localIElement instanceof IRuleSet))
          continue;
        d(localIElement);
      }
    }
    return null;
  }

  public Object visitRulePoolFlow(RulePoolFlow paramRulePoolFlow)
  {
    Iterator localIterator = paramRulePoolFlow.getAllRuleElement().iterator();
    while (localIterator.hasNext())
    {
      IElement localIElement = (IElement)localIterator.next();
      if ((localIElement instanceof IRule))
      {
        d(localIElement);
      }
      else
      {
        if (!(localIElement instanceof IRuleSet))
          continue;
        d(localIElement);
      }
    }
    return null;
  }

  public Object visitSheetMap(SheetMap paramSheetMap)
  {
    d("<th align=\"center\"><font size=\"4\">");
    d(paramSheetMap.getDisplayName());
    d("</font></th>" + q);
    d("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" class=tableBorder>" + q);
    d("<tr>" + q);
    d("<td wrap class=h><b>" + u.a("mapkey.hed") + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("mapvalue.hed") + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("fieldType.hed") + "</b></td>" + q);
    d("<td wrap class=h><b>" + u.a("displayName.hed") + "</b></td>" + q);
    d("</tr>" + q);
    List localList = paramSheetMap.getFields();
    for (int i = 0; i < localList.size(); i++)
    {
      d("<tr>" + q);
      d("  <td wrap class=f>");
      d(((MapValue)localList.get(i)).getKey());
      d("</td>" + q);
      d("<td wrap class=f>");
      d(((MapValue)localList.get(i)).getValue());
      d("</td>" + q);
      d("<td wrap class=f>");
      d(((MapValue)localList.get(i)).getValueType());
      d("</td>" + q);
      d("<td wrap class=f>");
      d(((MapValue)localList.get(i)).getDisplayName());
      d("</td>" + q);
      d("</tr>" + q);
    }
    d("</table>" + q);
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.k
 * JD-Core Version:    0.6.0
 */