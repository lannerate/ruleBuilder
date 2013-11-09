package com.flagleader.repository.g;

import com.flagleader.export.PagesMessages;
import com.flagleader.export.Type;
import com.flagleader.repository.IElement;
import com.flagleader.repository.d.u;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.FKModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.db.a.e;
import com.flagleader.repository.e.d;
import com.flagleader.repository.export.PageFieldModel;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.RuleSetToken;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.action.AssignJudgeToken;
import com.flagleader.repository.rlm.action.AssignToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.action.TableFunctionToken;
import com.flagleader.repository.rlm.condition.BooleanJudgeToken;
import com.flagleader.repository.rlm.condition.ConditionToken;
import com.flagleader.repository.rlm.condition.DateJudgeToken;
import com.flagleader.repository.rlm.condition.NumberJudgeToken;
import com.flagleader.repository.rlm.condition.StringJudgeToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IOperatorToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rlm.value.MemberSheetToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.rom.SubTypeMethod;
import com.flagleader.repository.rom.SubVariable;
import com.flagleader.repository.rom.TempVariable;
import com.flagleader.repository.tree.AdvancedProperty;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExportModel;
import com.flagleader.repository.tree.FunctionLibrary;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class c extends a
{
  private IRuleGroup b;
  private String c;
  private String d;
  private String e;
  private String f;
  private TableModel g;
  private List h;
  private List i;
  private String j;

  public c(IRuleGroup paramIRuleGroup, DBModel paramDBModel, List paramList, String paramString1, String paramString2)
  {
    this.b = paramIRuleGroup;
    this.a = paramDBModel;
    this.c = paramString1;
    this.h = d(paramList);
    this.d = a(paramList);
    this.j = b(paramList);
    if ((paramString2 != null) && (paramString2.length() > 0))
      this.e = paramString2;
    else
      this.e = this.j;
  }

  private List d(List paramList)
  {
    List localList = null;
    this.h = new ArrayList();
    TableModel localTableModel;
    for (int k = 0; k < paramList.size(); k++)
    {
      localTableModel = (TableModel)paramList.get(k);
      localList = localTableModel.getPrimaryKeys();
      if ((localList.size() > 0) && (a(localList, paramList)))
      {
        if ((!((FieldModel)localList.get(0)).isAutoIncrement()) && (!((FieldModel)localList.get(0)).isReadOnly()))
          continue;
        this.h.add(localTableModel);
        this.g = localTableModel;
      }
      else
      {
        paramList.remove(k);
        k--;
      }
    }
    for (k = 0; k < paramList.size(); k++)
    {
      localTableModel = (TableModel)paramList.get(k);
      if (localTableModel == this.g)
        continue;
      this.h.add(localTableModel);
    }
    if (this.g != null)
    {
      this.i = this.g.getPrimaryKeys();
    }
    else
    {
      this.g = ((TableModel)this.h.get(0));
      this.i = c(this.h);
    }
    return this.h;
  }

  protected FieldModel a(String paramString)
  {
    for (int k = 0; k < this.h.size(); k++)
    {
      TableModel localTableModel = (TableModel)this.h.get(k);
      if (localTableModel.getField(paramString) != null)
        return localTableModel.getField(paramString);
    }
    return null;
  }

  public void a()
  {
    c();
    d();
    g();
    f();
    e();
    b();
  }

  public void b()
  {
    if (c.class.getClassLoader().getResource(this.c + "/xytable.rpk") == null)
      return;
    RulePackage localRulePackage;
    try
    {
      localRulePackage = (RulePackage)((RulePackage)new d().load(c.class.getClassLoader().getResourceAsStream(this.c + "/xytable.rpk"))).deepClone();
    }
    catch (Exception localException1)
    {
      return;
    }
    localRulePackage.setDisplayName(localRulePackage.getDisplayName() + this.d);
    localRulePackage.setExeRulePackageName(this.e + ".xytable");
    this.b.addChildElement(localRulePackage);
    localRulePackage.setFilePathName("");
    DBModel localDBModel = a(localRulePackage);
    try
    {
      com.flagleader.repository.db.a.a locala = new com.flagleader.repository.db.a.a(this.a);
      SelectTable localSelectTable1 = localDBModel.createSelectTable(locala.b(this.h), "select" + this.d, "select" + this.j);
      a(localSelectTable1, locala);
      List localList1 = locala.c();
      SheetTable localSheetTable = new SheetTable();
      localSheetTable.setDisplayName("sheet" + this.d);
      localSheetTable.setEnglishName("sheet" + this.j);
      localSheetTable.setInout(3);
      localSheetTable.updateFunction();
      localDBModel.addChildElement(localSheetTable);
      localSheetTable.addChildElement(new SheetFieldModel("nID", "nID", "string", true));
      for (int k = 0; k < localSelectTable1.getFields().size(); k++)
      {
        localObject1 = new SheetFieldModel((FieldModel)localSelectTable1.getFields().get(k));
        if (((SheetFieldModel)localObject1).getValueType().equalsIgnoreCase("datetime"))
          ((SheetFieldModel)localObject1).setValueType("date");
        localSheetTable.addChildElement((IElement)localObject1);
      }
      IFunctionObject localIFunctionObject = localRulePackage.getEnvionment().getFunctionLibrary().getVariable("indexOfString(string,string)");
      Object localObject1 = (SubVariable)localRulePackage.getEnvionment().getFunctionLibrary().getVariable("split(string,string)").getChildrenIterator().next();
      TableModel localTableModel = (TableModel)this.g.deepClone();
      List localList2 = this.a.getFKModels(localTableModel.getTableName());
      for (int m = 0; m < localList2.size(); m++)
      {
        localObject2 = (FKModel)localList2.get(m);
        localTableModel.addChildElement((IElement)localObject2);
      }
      localDBModel.addChildElement(localTableModel);
      localDBModel.updateTableModel(localTableModel);
      TableFunction localTableFunction = localTableModel.addModifySheetFunction();
      Object localObject2 = (Rule)((RuleSet)localRulePackage.getRuleAndSets().next()).getRuleAndSets().next();
      if (localTableFunction != null)
      {
        localObject3 = new TableFunctionToken();
        StatementContainerToken localStatementContainerToken1 = new StatementContainerToken();
        ((Rule)localObject2).getRuleElementToken().getThenActions().addChildElement(localStatementContainerToken1);
        localStatementContainerToken1.addChildElement((IElement)localObject3);
        ((TableFunctionToken)localObject3).setMemberElement(localTableFunction);
        localObject4 = (ValueToken)((TableFunctionToken)localObject3).getValueTokens().get(0);
        localObject5 = new MemberToken(((ValueToken)localObject4).getValueType());
        ((ValueToken)localObject4).addChildElement((IElement)localObject5);
        ((MemberToken)localObject5).setMemberElement(localSheetTable);
      }
      ((Rule)localObject2).setModified(true);
      Object localObject3 = null;
      if (localRulePackage.getRuleAndSetCount() > 0)
        localObject3 = (RuleSet)localRulePackage.getRulesList().get(1);
      else
        localObject3 = (RuleSet)localRulePackage.createChildNode("RuleSet");
      Object localObject6;
      Object localObject8;
      Object localObject11;
      Object localObject12;
      Object localObject13;
      Object localObject14;
      Object localObject15;
      Object localObject16;
      for (int n = 0; n < localList1.size(); n++)
      {
        localObject4 = (e)localList1.get(n);
        localObject5 = ((e)localObject4).a();
        Object localObject9;
        if (((FieldModel)localObject5).getJavaType().G())
        {
          localObject6 = localRulePackage.getEnvionment().getValueLibrary().getVariable("query" + ((FieldModel)localObject5).getFieldName() + "1");
          if (localObject6 == null)
          {
            localObject6 = new MappingVariable("query" + ((FieldModel)localObject5).getFieldName() + "1", u.a("startdate.text") + ((FieldModel)localObject5).getDisplayName(), "date", true);
            localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject6);
          }
          localObject7 = localSelectTable1.addWhereFunction(((e)localObject4).g() + " >= ?", u.a("startdate.text") + ((FieldModel)localObject5).getDisplayName() + " = {arg1}", "date");
          localObject8 = (Rule)((RuleSet)localObject3).createChildNode("Rule");
          localObject9 = new ConditionToken();
          ((ConditionToken)localObject9).init();
          ((Rule)localObject8).getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject9);
          localObject11 = (MemberToken)((ConditionToken)localObject9).getFirstValue();
          ((MemberToken)localObject11).setMemberElement((IElement)localObject6);
          ((DateJudgeToken)((ConditionToken)localObject9).getCompareOperator()).setType(6);
          localObject12 = new TableFunctionToken();
          localObject13 = new StatementContainerToken();
          ((Rule)localObject8).getRuleElementToken().getThenActions().addChildElement((IElement)localObject13);
          ((StatementContainerToken)localObject13).addChildElement((IElement)localObject12);
          ((TableFunctionToken)localObject12).setMemberElement((IElement)localObject7);
          localObject14 = (ValueToken)((TableFunctionToken)localObject12).getValueTokens().get(0);
          localObject15 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement((IElement)localObject15);
          ((MemberToken)localObject15).setMemberElement((IElement)localObject6);
          localObject16 = localRulePackage.getEnvionment().getValueLibrary().getVariable("query" + ((FieldModel)localObject5).getFieldName() + "2");
          if (localObject16 == null)
          {
            localObject16 = new MappingVariable("query" + ((FieldModel)localObject5).getFieldName() + "2", u.a("enddate.text") + ((FieldModel)localObject5).getDisplayName(), "date", true);
            localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject16);
          }
          localObject7 = localSelectTable1.addWhereFunction(((e)localObject4).g() + " <= ?", u.a("enddate.text") + ((FieldModel)localObject5).getDisplayName() + " = {arg1}", "date");
          localObject8 = (Rule)((RuleSet)localObject3).createChildNode("Rule");
          localObject9 = new ConditionToken();
          ((ConditionToken)localObject9).init();
          ((Rule)localObject8).getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject9);
          localObject11 = (MemberToken)((ConditionToken)localObject9).getFirstValue();
          ((MemberToken)localObject11).setMemberElement((IElement)localObject16);
          ((DateJudgeToken)((ConditionToken)localObject9).getCompareOperator()).setType(6);
          localObject12 = new TableFunctionToken();
          localObject13 = new StatementContainerToken();
          ((Rule)localObject8).getRuleElementToken().getThenActions().addChildElement((IElement)localObject13);
          ((StatementContainerToken)localObject13).addChildElement((IElement)localObject12);
          ((TableFunctionToken)localObject12).setMemberElement((IElement)localObject7);
          localObject14 = (ValueToken)((TableFunctionToken)localObject12).getValueTokens().get(0);
          localObject15 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement((IElement)localObject15);
          ((MemberToken)localObject15).setMemberElement((IElement)localObject16);
        }
        else if (((FieldModel)localObject5).getJavaType().b())
        {
          localObject6 = localRulePackage.getEnvionment().getValueLibrary().getVariable("query" + ((FieldModel)localObject5).getFieldName());
          if (localObject6 == null)
          {
            localObject6 = new MappingVariable("query" + ((FieldModel)localObject5).getFieldName(), ((FieldModel)localObject5).getDisplayName(), "string", true);
            localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject6);
          }
          localObject7 = localSelectTable1.addWhereFunction(((e)localObject4).g() + " >= ?", u.a("startdate.text") + ((FieldModel)localObject5).getDisplayName() + " = {arg1}", ((FieldModel)localObject5).getValueType());
          localObject8 = localSelectTable1.addWhereFunction(((e)localObject4).g() + " <= ?", u.a("enddate.text") + ((FieldModel)localObject5).getDisplayName() + " = {arg1}", ((FieldModel)localObject5).getValueType());
          localObject9 = (RuleSet)((RuleSet)localObject3).createChildNode("RuleSet");
          localObject11 = new ConditionToken();
          ((ConditionToken)localObject11).init();
          ((RuleSet)localObject9).getRuleSetToken().getTestConditions().addChildElement((IElement)localObject11);
          localObject12 = (MemberToken)((ConditionToken)localObject11).getFirstValue();
          ((MemberToken)localObject12).setMemberElement((IElement)localObject6);
          ((StringJudgeToken)((ConditionToken)localObject11).getCompareOperator()).setType(8);
          localObject13 = (Rule)((RuleSet)localObject9).createChildNode("Rule");
          ((Rule)localObject13).setSupportElse(true);
          localObject11 = new ConditionToken();
          ((ConditionToken)localObject11).init();
          ((Rule)localObject13).getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject11);
          localObject12 = (MemberToken)((ConditionToken)localObject11).getFirstValue();
          ((MemberToken)localObject12).setMemberElement(localIFunctionObject);
          localObject14 = (ValueToken)((MemberToken)localObject12).getValueTokens().get(0);
          localObject15 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement((IElement)localObject15);
          ((MemberToken)localObject15).setMemberElement((IElement)localObject6);
          localObject14 = (ValueToken)((MemberToken)localObject12).getValueTokens().get(1);
          localObject16 = new ConstantToken("string");
          ((ValueToken)localObject14).addChildElement((IElement)localObject16);
          ((ConstantToken)localObject16).setValue("-");
          ((NumberJudgeToken)((ConditionToken)localObject11).getCompareOperator()).setType(3);
          ConstantToken localConstantToken = new ConstantToken(((FieldModel)localObject5).getValueType());
          ((ConditionToken)localObject11).getComparedValue().addChildElement(localConstantToken);
          localConstantToken.setValue("0");
          TableFunctionToken localTableFunctionToken = new TableFunctionToken();
          StatementContainerToken localStatementContainerToken2 = new StatementContainerToken();
          ((Rule)localObject13).getRuleElementToken().getThenActions().addChildElement(localStatementContainerToken2);
          localStatementContainerToken2.addChildElement(localTableFunctionToken);
          localTableFunctionToken.setMemberElement((IElement)localObject7);
          localObject14 = (ValueToken)localTableFunctionToken.getValueTokens().get(0);
          MemberToken localMemberToken1 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement(localMemberToken1);
          localMemberToken1.setMemberElement((IElement)localObject1);
          localObject14 = (ValueToken)localMemberToken1.getValueTokens().get(0);
          MemberToken localMemberToken2 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement(localMemberToken2);
          localMemberToken2.setMemberElement((IElement)localObject6);
          localObject14 = (ValueToken)localMemberToken1.getValueTokens().get(1);
          localObject16 = new ConstantToken("string");
          ((ValueToken)localObject14).addChildElement((IElement)localObject16);
          ((ConstantToken)localObject16).setValue("-");
          localObject14 = (ValueToken)localMemberToken1.getValueTokens().get(2);
          localObject16 = new ConstantToken("int");
          ((ValueToken)localObject14).addChildElement((IElement)localObject16);
          ((ConstantToken)localObject16).setValue(String.valueOf(0));
          localTableFunctionToken = new TableFunctionToken();
          localStatementContainerToken2 = new StatementContainerToken();
          ((Rule)localObject13).getRuleElementToken().getThenActions().addChildElement(localStatementContainerToken2);
          localStatementContainerToken2.addChildElement(localTableFunctionToken);
          localTableFunctionToken.setMemberElement((IElement)localObject8);
          localObject14 = (ValueToken)localTableFunctionToken.getValueTokens().get(0);
          localMemberToken1 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement(localMemberToken1);
          localMemberToken1.setMemberElement((IElement)localObject1);
          localObject14 = (ValueToken)localMemberToken1.getValueTokens().get(0);
          localMemberToken2 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement(localMemberToken2);
          localMemberToken2.setMemberElement((IElement)localObject6);
          localObject14 = (ValueToken)localMemberToken1.getValueTokens().get(1);
          localObject16 = new ConstantToken("string");
          ((ValueToken)localObject14).addChildElement((IElement)localObject16);
          ((ConstantToken)localObject16).setValue("-");
          localObject14 = (ValueToken)localMemberToken1.getValueTokens().get(2);
          localObject16 = new ConstantToken("int");
          ((ValueToken)localObject14).addChildElement((IElement)localObject16);
          ((ConstantToken)localObject16).setValue(String.valueOf(1));
          localObject8 = localSelectTable1.addWhereFunction(((e)localObject4).g() + " = ?", ((FieldModel)localObject5).getDisplayName() + " = {arg1}", ((FieldModel)localObject5).getValueType());
          localTableFunctionToken = new TableFunctionToken();
          localStatementContainerToken2 = new StatementContainerToken();
          ((Rule)localObject13).getRuleElementToken().getElseActions().addChildElement(localStatementContainerToken2);
          localStatementContainerToken2.addChildElement(localTableFunctionToken);
          localTableFunctionToken.setMemberElement((IElement)localObject8);
          localObject14 = (ValueToken)localTableFunctionToken.getValueTokens().get(0);
          localObject15 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement((IElement)localObject15);
          ((MemberToken)localObject15).setMemberElement((IElement)localObject6);
        }
        else if (((FieldModel)localObject5).getJavaType().m())
        {
          localObject6 = localRulePackage.getEnvionment().getValueLibrary().getVariable("query" + ((FieldModel)localObject5).getFieldName());
          if (localObject6 == null)
          {
            localObject6 = new MappingVariable("query" + ((FieldModel)localObject5).getFieldName(), ((FieldModel)localObject5).getDisplayName(), "string", true);
            localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject6);
          }
          localObject7 = localSelectTable1.addWhereFunction(((e)localObject4).g() + " like ?", ((FieldModel)localObject5).getDisplayName() + " like {arg1}", "string");
          localObject8 = (Rule)((RuleSet)localObject3).createChildNode("Rule");
          localObject9 = new ConditionToken();
          ((ConditionToken)localObject9).init();
          ((Rule)localObject8).getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject9);
          localObject11 = (MemberToken)((ConditionToken)localObject9).getFirstValue();
          ((MemberToken)localObject11).setMemberElement((IElement)localObject6);
          ((StringJudgeToken)((ConditionToken)localObject9).getCompareOperator()).setType(8);
          localObject12 = new TableFunctionToken();
          localObject13 = new StatementContainerToken();
          ((Rule)localObject8).getRuleElementToken().getThenActions().addChildElement((IElement)localObject13);
          ((StatementContainerToken)localObject13).addChildElement((IElement)localObject12);
          ((TableFunctionToken)localObject12).setMemberElement((IElement)localObject7);
          localObject14 = (ValueToken)((TableFunctionToken)localObject12).getValueTokens().get(0);
          localObject15 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement((IElement)localObject15);
          ((MemberToken)localObject15).setMemberElement((IElement)localObject6);
          ((ValueToken)localObject14).getOperator().setType(1);
          localObject16 = new ConstantToken("string");
          ((ValueToken)localObject14).getNextValue().addChildElement((IElement)localObject16);
          ((ConstantToken)localObject16).setValue("%");
        }
        else
        {
          localObject6 = localRulePackage.getEnvionment().getValueLibrary().getVariable("query" + ((FieldModel)localObject5).getFieldName());
          if (localObject6 == null)
          {
            localObject6 = new MappingVariable("query" + ((FieldModel)localObject5).getFieldName(), ((FieldModel)localObject5).getDisplayName(), "string", true);
            localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject6);
          }
          localObject7 = localSelectTable1.addWhereFunction(((e)localObject4).g() + " = ?", ((FieldModel)localObject5).getDisplayName() + " = {arg1}", "string");
          localObject8 = (Rule)((RuleSet)localObject3).createChildNode("Rule");
          localObject9 = new ConditionToken();
          ((ConditionToken)localObject9).init();
          ((Rule)localObject8).getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject9);
          localObject11 = (MemberToken)((ConditionToken)localObject9).getFirstValue();
          ((MemberToken)localObject11).setMemberElement((IElement)localObject6);
          ((StringJudgeToken)((ConditionToken)localObject9).getCompareOperator()).setType(8);
          localObject12 = new TableFunctionToken();
          localObject13 = new StatementContainerToken();
          ((Rule)localObject8).getRuleElementToken().getThenActions().addChildElement((IElement)localObject13);
          ((StatementContainerToken)localObject13).addChildElement((IElement)localObject12);
          ((TableFunctionToken)localObject12).setMemberElement((IElement)localObject7);
          localObject14 = (ValueToken)((TableFunctionToken)localObject12).getValueTokens().get(0);
          localObject15 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement((IElement)localObject15);
          ((MemberToken)localObject15).setMemberElement((IElement)localObject6);
        }
      }
      Rule localRule = (Rule)localRulePackage.createChildNode("Rule");
      if (localRulePackage.getEnvionment().getValueLibrary().getVariable("page_num") != null)
      {
        localObject4 = localSelectTable1.getTableFunction("setOrderField");
        if (localObject4 != null)
        {
          localObject5 = new TableFunctionToken();
          localObject6 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
          ((StatementContainerToken)localObject6).addChildElement((IElement)localObject5);
          ((TableFunctionToken)localObject5).setMemberElement((IElement)localObject4);
          localObject7 = (ValueToken)((TableFunctionToken)localObject5).getValueTokens().get(0);
          localObject8 = new MemberToken(((ValueToken)localObject7).getValueType());
          ((ValueToken)localObject7).addChildElement((IElement)localObject8);
          ((MemberToken)localObject8).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("order_field"));
          localObject7 = (ValueToken)((TableFunctionToken)localObject5).getValueTokens().get(1);
          localObject8 = new MemberToken(((ValueToken)localObject7).getValueType());
          ((ValueToken)localObject7).addChildElement((IElement)localObject8);
          ((MemberToken)localObject8).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("order_desc"));
        }
        localObject4 = localSelectTable1.getTableFunction("setPage");
        if (localObject4 != null)
        {
          localObject5 = new TableFunctionToken();
          localObject6 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
          ((StatementContainerToken)localObject6).addChildElement((IElement)localObject5);
          ((TableFunctionToken)localObject5).setMemberElement((IElement)localObject4);
          localObject7 = (ValueToken)((TableFunctionToken)localObject5).getValueTokens().get(0);
          localObject8 = new MemberToken(((ValueToken)localObject7).getValueType());
          ((ValueToken)localObject7).addChildElement((IElement)localObject8);
          ((MemberToken)localObject8).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("page_num"));
          localObject7 = (ValueToken)((TableFunctionToken)localObject5).getValueTokens().get(1);
          localObject8 = new MemberToken(((ValueToken)localObject7).getValueType());
          ((ValueToken)localObject7).addChildElement((IElement)localObject8);
          ((MemberToken)localObject8).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("per_page"));
        }
      }
      Object localObject4 = localSelectTable1.getTableFunction("selectWhere");
      if (localObject4 != null)
      {
        localObject5 = new TableFunctionToken();
        localObject6 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
        ((StatementContainerToken)localObject6).addChildElement((IElement)localObject5);
        ((TableFunctionToken)localObject5).setMemberElement((IElement)localObject4);
      }
      localObject4 = localSheetTable.getTableFunction("loadFromView");
      if (localObject4 != null)
      {
        localObject5 = new TableFunctionToken();
        localObject6 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
        ((StatementContainerToken)localObject6).addChildElement((IElement)localObject5);
        ((TableFunctionToken)localObject5).setMemberElement((IElement)localObject4);
        localObject7 = (ValueToken)((TableFunctionToken)localObject5).getValueTokens().get(0);
        localObject8 = new MemberToken(((ValueToken)localObject7).getValueType());
        ((ValueToken)localObject7).addChildElement((IElement)localObject8);
        ((MemberToken)localObject8).setMemberElement(localSelectTable1);
      }
      if (localRulePackage.getEnvionment().getValueLibrary().getVariable("record_count") != null)
      {
        localObject4 = localSelectTable1.getTableFunction("getCount");
        if (localObject4 != null)
        {
          localObject5 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject5);
          localObject6 = new AssignToken();
          ((StatementContainerToken)localObject5).addChildElement((IElement)localObject6);
          localObject7 = new FieldToken();
          ((AssignToken)localObject6).addChildElement((IElement)localObject7);
          ((AssignToken)localObject6).addChildElement(new AssignJudgeToken());
          ((FieldToken)localObject7).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("record_count"));
          localObject8 = new TableFunctionToken(((TableFunction)localObject4).getValueType());
          ((AssignToken)localObject6).getComparedValue().addChildElement((IElement)localObject8);
          ((TableFunctionToken)localObject8).setMemberElement((IElement)localObject4);
        }
      }
      localRule = (Rule)localRulePackage.createChildNode("Rule");
      localRule.setSheetWhile(true);
      localRule.setSheetTable(localSheetTable);
      if (localRule != null)
      {
        localObject5 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject5);
        localObject6 = new AssignToken();
        ((StatementContainerToken)localObject5).addChildElement((IElement)localObject6);
        localObject7 = new FieldToken();
        ((AssignToken)localObject6).addChildElement((IElement)localObject7);
        ((AssignToken)localObject6).addChildElement(new AssignJudgeToken());
        ((FieldToken)localObject7).setMemberElement(localSheetTable.getField("nID"));
        localObject8 = ((AssignToken)localObject6).getComparedValue();
        for (int i2 = 0; i2 < this.i.size(); i2++)
        {
          localObject11 = new MemberSheetToken("string");
          ((IValueContainerToken)localObject8).addChildElement((IElement)localObject11);
          ((MemberSheetToken)localObject11).setMemberElement(localSheetTable.getField(((FieldModel)this.i.get(i2)).getFieldName()));
          if (i2 >= this.i.size() - 1)
            continue;
          ((IValueContainerToken)localObject8).getOperator().setType(1);
          localObject12 = new ConstantToken("string");
          ((IValueContainerToken)localObject8).getNextValue().addChildElement((IElement)localObject12);
          ((ConstantToken)localObject12).setValue("_");
          ((IValueContainerToken)localObject8).getNextValue().getOperator().setType(1);
          localObject8 = ((IValueContainerToken)localObject8).getNextValue().getNextValue();
        }
      }
      Object localObject5 = new HashMap();
      Object localObject10;
      for (int i1 = 0; i1 < localList2.size(); i1++)
      {
        localObject7 = (FKModel)localList2.get(i1);
        localTableModel.addChildElement((IElement)localObject7);
        if ((((FKModel)localObject7).getKeys().size() != 1) || (!((FKModel)localObject7).getFKTableName().equalsIgnoreCase(localTableModel.getTableName())) || (a(this.h, ((FKModel)localObject7).getPkTableName())))
          continue;
        localObject8 = this.a.getTableModel(((FKModel)localObject7).getPkTableName());
        if (localObject8 == null)
          continue;
        localObject10 = ((AdvancedProperty)((FKModel)localObject7).getKeys().get(0)).getKey();
        for (int i3 = 0; i3 < ((TableModel)localObject8).getFields().size(); i3++)
        {
          if ((!((FieldModel)((TableModel)localObject8).getFields().get(i3)).getFieldName().equalsIgnoreCase((String)localObject10)) || (i3 + 1 >= ((TableModel)localObject8).getFields().size()))
            continue;
          localObject10 = ((FieldModel)((TableModel)localObject8).getFields().get(i3 + 1)).getFieldName();
          break;
        }
        SelectTable localSelectTable2 = localDBModel.createSelectTable("select " + ((AdvancedProperty)((FKModel)localObject7).getKeys().get(0)).getKey() + "," + (String)localObject10 + " from " + ((TableModel)localObject8).getTableName(), ((FKModel)localObject7).getFKName(), ((FKModel)localObject7).getFKName());
        localObject12 = new MappingVariable("list" + ((FKModel)localObject7).getFKName(), ((FKModel)localObject7).getFKName(), "list<list>", true);
        localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject12);
        localRule = (Rule)localRulePackage.createChildNode("Rule");
        localObject4 = localSelectTable2.getTableFunction("selectWhere");
        if (localObject4 != null)
        {
          localObject13 = new TableFunctionToken();
          localObject14 = new StatementContainerToken();
          localRule.getRuleElementToken().getInitActions().addChildElement((IElement)localObject14);
          ((StatementContainerToken)localObject14).addChildElement((IElement)localObject13);
          ((TableFunctionToken)localObject13).setMemberElement((IElement)localObject4);
        }
        localObject4 = localSelectTable2.getTableFunction("getListResult");
        if (localObject4 != null)
        {
          localObject13 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject13);
          localObject14 = new AssignToken();
          ((StatementContainerToken)localObject13).addChildElement((IElement)localObject14);
          localObject15 = new FieldToken();
          ((AssignToken)localObject14).addChildElement((IElement)localObject15);
          ((AssignToken)localObject14).addChildElement(new AssignJudgeToken());
          if (localObject12 != null)
            ((FieldToken)localObject15).setMemberElement((IElement)localObject12);
          else
            ((AssignToken)localObject14).changeFieldType(((TableFunction)localObject4).getJavaType());
          localObject16 = new TableFunctionToken(((TableFunction)localObject4).getValueType());
          ((AssignToken)localObject14).getComparedValue().addChildElement((IElement)localObject16);
          ((TableFunctionToken)localObject16).setMemberElement((IElement)localObject4);
        }
        localRule.setModified(true);
        ((HashMap)localObject5).put(((AdvancedProperty)((FKModel)localObject7).getKeys().get(0)).getKey(), localSelectTable2);
      }
      Object localObject7 = localRulePackage.getExportModels();
      if (((Iterator)localObject7).hasNext())
      {
        ExportModel localExportModel = (ExportModel)((Iterator)localObject7).next();
        localExportModel.setDisplayName(localRulePackage.getExeRulePackageName().replace('.', '/') + ".jsp");
        if (localExportModel.getPageField(localSheetTable.getValueName()) == null)
        {
          localObject8 = new PageFieldModel();
          ((PageFieldModel)localObject8).setDisplayName(this.d);
          ((PageFieldModel)localObject8).setVariableName(localSheetTable.getValueName());
          ((PageFieldModel)localObject8).setValueType("com.flagleader.db.Sheet");
          ((PageFieldModel)localObject8).setPropertyValue("showempty", "true");
          ((PageFieldModel)localObject8).setPropertyValue("valuetop", "true");
          ((PageFieldModel)localObject8).setInputType("notdisplay");
          ((PageFieldModel)localObject8).setResultType("xytable");
          localExportModel.addChildElement((IElement)localObject8);
          a((PageFieldModel)localObject8, ((PageFieldModel)localObject8).getInputType());
          a((PageFieldModel)localObject8, ((PageFieldModel)localObject8).getResultType());
          localObject10 = localSelectTable1.getFields();
          for (int i4 = 0; i4 < ((List)localObject10).size(); i4++)
          {
            localObject12 = (FieldModel)((List)localObject10).get(i4);
            localObject13 = new PageFieldModel();
            ((PageFieldModel)localObject13).setInputType("text");
            localObject14 = ((PageFieldModel)localObject13).getPageTypeNames();
            for (int i6 = 0; i6 < localObject14.length; i6++)
              if (localExportModel.getPreferences().getStringArray(((PageFieldModel)localObject8).getInputType() + "." + localObject14[i6]) != null)
                ((PageFieldModel)localObject13).setPageTypeValue(localObject14[i6], localExportModel.getPreferences().getStringArray(((PageFieldModel)localObject8).getInputType() + "." + localObject14[i6])[0]);
              else if (localExportModel.getPreferences().getStringArray(((PageFieldModel)localObject8).getResultType() + "." + localObject14[i6]) != null)
                ((PageFieldModel)localObject13).setPageTypeValue(localObject14[i6], localExportModel.getPreferences().getStringArray(((PageFieldModel)localObject8).getResultType() + "." + localObject14[i6])[0]);
              else
                ((PageFieldModel)localObject13).setPageTypeValue(localObject14[i6], ((PageFieldModel)localObject8).getPageTypeValue(localObject14[i6]));
            ((PageFieldModel)localObject13).setVariableName(((PageFieldModel)localObject8).getVariableName() + "_" + (i4 + 1));
            ((PageFieldModel)localObject13).setValueType(((FieldModel)localObject12).getValueType());
            if (((FieldModel)localObject12).getValueType().equalsIgnoreCase("datetime"))
              ((PageFieldModel)localObject13).setValueType("date");
            if (((PageFieldModel)localObject13).getJavaType().isDate())
              ((PageFieldModel)localObject13).setInputType("datetext");
            else if (((PageFieldModel)localObject13).getJavaType().isNumber())
              ((PageFieldModel)localObject13).setInputType("numbertext");
            else
              ((PageFieldModel)localObject13).setInputType("text");
            ((PageFieldModel)localObject13).setDisplayName(((FieldModel)localObject12).getDisplayName());
            ((PageFieldModel)localObject13).setLen(((FieldModel)localObject12).getLen());
            ((PageFieldModel)localObject13).setPropertyValue("fieldName", ((FieldModel)localObject12).getFieldName());
            if ((((HashMap)localObject5).get(((FieldModel)localObject12).getValueName()) != null) && ((((HashMap)localObject5).get(((FieldModel)localObject12).getValueName()) instanceof SelectTable)))
            {
              ((PageFieldModel)localObject13).setInputType("select");
              ((PageFieldModel)localObject13).setPropertyValue("p_options", "list" + ((SelectTable)((HashMap)localObject5).get(((FieldModel)localObject12).getValueName())).getValueName());
            }
            FieldModel localFieldModel = a(((FieldModel)localObject12).getFieldName());
            if ((localFieldModel != null) && (localFieldModel.getAdvanceProperties().length > 0))
            {
              ((PageFieldModel)localObject13).setInputType("select");
              for (int i7 = 0; i7 < localFieldModel.getAdvanceProperties().length; i7++)
                ((PageFieldModel)localObject13).setPropertyValue("o_" + localFieldModel.getAdvanceProperties()[i7].getKey(), localFieldModel.getAdvanceProperties()[i7].getProperty());
            }
            ((PageFieldModel)localObject13).setShowValue("nostat");
            if (i4 == 0)
            {
              ((PageFieldModel)localObject13).setStatType("xycol");
            }
            else if ((i4 == 1) || ((localFieldModel != null) && (localFieldModel.isFriendKey())))
            {
              ((PageFieldModel)localObject13).setStatType("xyrow");
            }
            else
            {
              ((PageFieldModel)localObject13).setStatType("xyvalue");
              if (((PageFieldModel)localObject13).getJavaType().isNumber())
                ((PageFieldModel)localObject13).setShowValue("amountstat");
            }
            ((PageFieldModel)localObject8).addChildElement((IElement)localObject13);
            ((PageFieldModel)localObject13).setResultType("label");
            a((PageFieldModel)localObject13, ((PageFieldModel)localObject13).getInputType());
            a((PageFieldModel)localObject13, ((PageFieldModel)localObject13).getResultType());
          }
        }
        localObject8 = localExportModel.getEnvionment().getAllMappingVariable();
        while (((Iterator)localObject8).hasNext())
        {
          localObject10 = (MappingVariable)((Iterator)localObject8).next();
          if ((localExportModel.getPageField(((MappingVariable)localObject10).getVariableName()) != null) || (((MappingVariable)localObject10).getJavaType().D()))
            continue;
          PageFieldModel localPageFieldModel = localExportModel.addMappingVariable((MappingVariable)localObject10);
          if (((MappingVariable)localObject10).getValueType().equalsIgnoreCase("list<list>"))
          {
            localPageFieldModel.setInputType("hidden");
            localPageFieldModel.setResultType("notdisplay");
          }
          else
          {
            localPageFieldModel.setInputType("text");
          }
          if (localPageFieldModel.getValueType().equalsIgnoreCase("datetime"))
            localPageFieldModel.setValueType("date");
          if (localPageFieldModel.getJavaType().isDate())
            localPageFieldModel.setInputType("datetext");
          else if (localPageFieldModel.getJavaType().isNumber())
            localPageFieldModel.setInputType("numbertext");
          if (((MappingVariable)localObject10).getValueName().startsWith("query"))
          {
            localObject12 = a(((MappingVariable)localObject10).getValueName().substring(5));
            if (localObject12 != null)
            {
              if ((((HashMap)localObject5).get(((MappingVariable)localObject10).getValueName().substring(5)) != null) && ((((HashMap)localObject5).get(((MappingVariable)localObject10).getValueName().substring(5)) instanceof SelectTable)))
              {
                localPageFieldModel.setPropertyValue("o_", "");
                localPageFieldModel.setInputType("select");
                localPageFieldModel.setPropertyValue("p_options", "list" + ((SelectTable)((HashMap)localObject5).get(((MappingVariable)localObject10).getValueName().substring(5))).getValueName());
              }
              if (((FieldModel)localObject12).getAdvanceProperties().length > 0)
              {
                localPageFieldModel.setInputType("select");
                localPageFieldModel.setPropertyValue("o_", "");
                for (int i5 = 0; i5 < ((FieldModel)localObject12).getAdvanceProperties().length; i5++)
                  localPageFieldModel.setPropertyValue("o_" + localObject12.getAdvanceProperties()[i5].getKey(), localObject12.getAdvanceProperties()[i5].getProperty());
              }
            }
          }
          a(localPageFieldModel, localPageFieldModel.getInputType());
          a(localPageFieldModel, localPageFieldModel.getResultType());
        }
        localExportModel.setModified(true);
      }
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }

  public void c()
  {
    if (c.class.getClassLoader().getResource(this.c + "/sheet.rpk") == null)
      return;
    RulePackage localRulePackage;
    try
    {
      localRulePackage = (RulePackage)((RulePackage)new d().load(c.class.getClassLoader().getResourceAsStream(this.c + "/sheet.rpk"))).deepClone();
    }
    catch (Exception localException1)
    {
      return;
    }
    localRulePackage.setDisplayName(localRulePackage.getDisplayName() + this.d);
    localRulePackage.setExeRulePackageName(this.e + ".sheet");
    this.b.addChildElement(localRulePackage);
    localRulePackage.setFilePathName("");
    DBModel localDBModel = a(localRulePackage);
    try
    {
      com.flagleader.repository.db.a.a locala = new com.flagleader.repository.db.a.a(this.a);
      SelectTable localSelectTable1 = localDBModel.createSelectTable(locala.b(this.h), "select" + this.d, "select" + this.j);
      a(localSelectTable1, locala);
      List localList1 = locala.c();
      SheetTable localSheetTable = new SheetTable();
      localSheetTable.setDisplayName("sheet" + this.d);
      localSheetTable.setEnglishName("sheet" + this.j);
      localSheetTable.setInout(3);
      localSheetTable.updateFunction();
      localDBModel.addChildElement(localSheetTable);
      localSheetTable.addChildElement(new SheetFieldModel("nID", "nID", "string", true));
      for (int k = 0; k < localSelectTable1.getFields().size(); k++)
      {
        localObject1 = new SheetFieldModel((FieldModel)localSelectTable1.getFields().get(k));
        if (((SheetFieldModel)localObject1).getValueType().equalsIgnoreCase("datetime"))
          ((SheetFieldModel)localObject1).setValueType("date");
        localSheetTable.addChildElement((IElement)localObject1);
      }
      IFunctionObject localIFunctionObject = localRulePackage.getEnvionment().getFunctionLibrary().getVariable("indexOfString(string,string)");
      Object localObject1 = (SubVariable)localRulePackage.getEnvionment().getFunctionLibrary().getVariable("split(string,string)").getChildrenIterator().next();
      TableModel localTableModel = (TableModel)this.g.deepClone();
      List localList2 = this.a.getFKModels(localTableModel.getTableName());
      for (int m = 0; m < localList2.size(); m++)
      {
        localObject2 = (FKModel)localList2.get(m);
        localTableModel.addChildElement((IElement)localObject2);
      }
      localDBModel.addChildElement(localTableModel);
      localDBModel.updateTableModel(localTableModel);
      TableFunction localTableFunction = localTableModel.addModifySheetFunction();
      Object localObject2 = (Rule)((RuleSet)localRulePackage.getRuleAndSets().next()).getRuleAndSets().next();
      if (localTableFunction != null)
      {
        localObject3 = new TableFunctionToken();
        StatementContainerToken localStatementContainerToken1 = new StatementContainerToken();
        ((Rule)localObject2).getRuleElementToken().getThenActions().addChildElement(localStatementContainerToken1);
        localStatementContainerToken1.addChildElement((IElement)localObject3);
        ((TableFunctionToken)localObject3).setMemberElement(localTableFunction);
        localObject4 = (ValueToken)((TableFunctionToken)localObject3).getValueTokens().get(0);
        localObject5 = new MemberToken(((ValueToken)localObject4).getValueType());
        ((ValueToken)localObject4).addChildElement((IElement)localObject5);
        ((MemberToken)localObject5).setMemberElement(localSheetTable);
      }
      ((Rule)localObject2).setModified(true);
      Object localObject3 = null;
      if (localRulePackage.getRuleAndSetCount() > 0)
        localObject3 = (RuleSet)localRulePackage.getRulesList().get(1);
      else
        localObject3 = (RuleSet)localRulePackage.createChildNode("RuleSet");
      Object localObject6;
      Object localObject8;
      Object localObject11;
      Object localObject12;
      Object localObject13;
      Object localObject14;
      Object localObject15;
      Object localObject16;
      for (int n = 0; n < localList1.size(); n++)
      {
        localObject4 = (e)localList1.get(n);
        localObject5 = ((e)localObject4).a();
        Object localObject9;
        if (((FieldModel)localObject5).getJavaType().G())
        {
          localObject6 = localRulePackage.getEnvionment().getValueLibrary().getVariable("query" + ((FieldModel)localObject5).getFieldName() + "1");
          if (localObject6 == null)
          {
            localObject6 = new MappingVariable("query" + ((FieldModel)localObject5).getFieldName() + "1", u.a("startdate.text") + ((FieldModel)localObject5).getDisplayName(), "date", true);
            localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject6);
          }
          localObject7 = localSelectTable1.addWhereFunction(((e)localObject4).g() + " >= ?", u.a("startdate.text") + ((FieldModel)localObject5).getDisplayName() + " = {arg1}", "date");
          localObject8 = (Rule)((RuleSet)localObject3).createChildNode("Rule");
          localObject9 = new ConditionToken();
          ((ConditionToken)localObject9).init();
          ((Rule)localObject8).getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject9);
          localObject11 = (MemberToken)((ConditionToken)localObject9).getFirstValue();
          ((MemberToken)localObject11).setMemberElement((IElement)localObject6);
          ((DateJudgeToken)((ConditionToken)localObject9).getCompareOperator()).setType(6);
          localObject12 = new TableFunctionToken();
          localObject13 = new StatementContainerToken();
          ((Rule)localObject8).getRuleElementToken().getThenActions().addChildElement((IElement)localObject13);
          ((StatementContainerToken)localObject13).addChildElement((IElement)localObject12);
          ((TableFunctionToken)localObject12).setMemberElement((IElement)localObject7);
          localObject14 = (ValueToken)((TableFunctionToken)localObject12).getValueTokens().get(0);
          localObject15 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement((IElement)localObject15);
          ((MemberToken)localObject15).setMemberElement((IElement)localObject6);
          localObject16 = localRulePackage.getEnvionment().getValueLibrary().getVariable("query" + ((FieldModel)localObject5).getFieldName() + "2");
          if (localObject16 == null)
          {
            localObject16 = new MappingVariable("query" + ((FieldModel)localObject5).getFieldName() + "2", u.a("enddate.text") + ((FieldModel)localObject5).getDisplayName(), "date", true);
            localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject16);
          }
          localObject7 = localSelectTable1.addWhereFunction(((e)localObject4).g() + " <= ?", u.a("enddate.text") + ((FieldModel)localObject5).getDisplayName() + " = {arg1}", "date");
          localObject8 = (Rule)((RuleSet)localObject3).createChildNode("Rule");
          localObject9 = new ConditionToken();
          ((ConditionToken)localObject9).init();
          ((Rule)localObject8).getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject9);
          localObject11 = (MemberToken)((ConditionToken)localObject9).getFirstValue();
          ((MemberToken)localObject11).setMemberElement((IElement)localObject16);
          ((DateJudgeToken)((ConditionToken)localObject9).getCompareOperator()).setType(6);
          localObject12 = new TableFunctionToken();
          localObject13 = new StatementContainerToken();
          ((Rule)localObject8).getRuleElementToken().getThenActions().addChildElement((IElement)localObject13);
          ((StatementContainerToken)localObject13).addChildElement((IElement)localObject12);
          ((TableFunctionToken)localObject12).setMemberElement((IElement)localObject7);
          localObject14 = (ValueToken)((TableFunctionToken)localObject12).getValueTokens().get(0);
          localObject15 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement((IElement)localObject15);
          ((MemberToken)localObject15).setMemberElement((IElement)localObject16);
        }
        else if (((FieldModel)localObject5).getJavaType().b())
        {
          localObject6 = localRulePackage.getEnvionment().getValueLibrary().getVariable("query" + ((FieldModel)localObject5).getFieldName());
          if (localObject6 == null)
          {
            localObject6 = new MappingVariable("query" + ((FieldModel)localObject5).getFieldName(), ((FieldModel)localObject5).getDisplayName(), "string", true);
            localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject6);
          }
          localObject7 = localSelectTable1.addWhereFunction(((e)localObject4).g() + " >= ?", u.a("startdate.text") + ((FieldModel)localObject5).getDisplayName() + " = {arg1}", ((FieldModel)localObject5).getValueType());
          localObject8 = localSelectTable1.addWhereFunction(((e)localObject4).g() + " <= ?", u.a("enddate.text") + ((FieldModel)localObject5).getDisplayName() + " = {arg1}", ((FieldModel)localObject5).getValueType());
          localObject9 = (RuleSet)((RuleSet)localObject3).createChildNode("RuleSet");
          localObject11 = new ConditionToken();
          ((ConditionToken)localObject11).init();
          ((RuleSet)localObject9).getRuleSetToken().getTestConditions().addChildElement((IElement)localObject11);
          localObject12 = (MemberToken)((ConditionToken)localObject11).getFirstValue();
          ((MemberToken)localObject12).setMemberElement((IElement)localObject6);
          ((StringJudgeToken)((ConditionToken)localObject11).getCompareOperator()).setType(8);
          localObject13 = (Rule)((RuleSet)localObject9).createChildNode("Rule");
          ((Rule)localObject13).setSupportElse(true);
          localObject11 = new ConditionToken();
          ((ConditionToken)localObject11).init();
          ((Rule)localObject13).getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject11);
          localObject12 = (MemberToken)((ConditionToken)localObject11).getFirstValue();
          ((MemberToken)localObject12).setMemberElement(localIFunctionObject);
          localObject14 = (ValueToken)((MemberToken)localObject12).getValueTokens().get(0);
          localObject15 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement((IElement)localObject15);
          ((MemberToken)localObject15).setMemberElement((IElement)localObject6);
          localObject14 = (ValueToken)((MemberToken)localObject12).getValueTokens().get(1);
          localObject16 = new ConstantToken("string");
          ((ValueToken)localObject14).addChildElement((IElement)localObject16);
          ((ConstantToken)localObject16).setValue("-");
          ((NumberJudgeToken)((ConditionToken)localObject11).getCompareOperator()).setType(3);
          ConstantToken localConstantToken = new ConstantToken(((FieldModel)localObject5).getValueType());
          ((ConditionToken)localObject11).getComparedValue().addChildElement(localConstantToken);
          localConstantToken.setValue("0");
          TableFunctionToken localTableFunctionToken = new TableFunctionToken();
          StatementContainerToken localStatementContainerToken2 = new StatementContainerToken();
          ((Rule)localObject13).getRuleElementToken().getThenActions().addChildElement(localStatementContainerToken2);
          localStatementContainerToken2.addChildElement(localTableFunctionToken);
          localTableFunctionToken.setMemberElement((IElement)localObject7);
          localObject14 = (ValueToken)localTableFunctionToken.getValueTokens().get(0);
          MemberToken localMemberToken1 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement(localMemberToken1);
          localMemberToken1.setMemberElement((IElement)localObject1);
          localObject14 = (ValueToken)localMemberToken1.getValueTokens().get(0);
          MemberToken localMemberToken2 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement(localMemberToken2);
          localMemberToken2.setMemberElement((IElement)localObject6);
          localObject14 = (ValueToken)localMemberToken1.getValueTokens().get(1);
          localObject16 = new ConstantToken("string");
          ((ValueToken)localObject14).addChildElement((IElement)localObject16);
          ((ConstantToken)localObject16).setValue("-");
          localObject14 = (ValueToken)localMemberToken1.getValueTokens().get(2);
          localObject16 = new ConstantToken("int");
          ((ValueToken)localObject14).addChildElement((IElement)localObject16);
          ((ConstantToken)localObject16).setValue(String.valueOf(0));
          localTableFunctionToken = new TableFunctionToken();
          localStatementContainerToken2 = new StatementContainerToken();
          ((Rule)localObject13).getRuleElementToken().getThenActions().addChildElement(localStatementContainerToken2);
          localStatementContainerToken2.addChildElement(localTableFunctionToken);
          localTableFunctionToken.setMemberElement((IElement)localObject8);
          localObject14 = (ValueToken)localTableFunctionToken.getValueTokens().get(0);
          localMemberToken1 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement(localMemberToken1);
          localMemberToken1.setMemberElement((IElement)localObject1);
          localObject14 = (ValueToken)localMemberToken1.getValueTokens().get(0);
          localMemberToken2 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement(localMemberToken2);
          localMemberToken2.setMemberElement((IElement)localObject6);
          localObject14 = (ValueToken)localMemberToken1.getValueTokens().get(1);
          localObject16 = new ConstantToken("string");
          ((ValueToken)localObject14).addChildElement((IElement)localObject16);
          ((ConstantToken)localObject16).setValue("-");
          localObject14 = (ValueToken)localMemberToken1.getValueTokens().get(2);
          localObject16 = new ConstantToken("int");
          ((ValueToken)localObject14).addChildElement((IElement)localObject16);
          ((ConstantToken)localObject16).setValue(String.valueOf(1));
          localObject8 = localSelectTable1.addWhereFunction(((e)localObject4).g() + " = ?", ((FieldModel)localObject5).getDisplayName() + " = {arg1}", ((FieldModel)localObject5).getValueType());
          localTableFunctionToken = new TableFunctionToken();
          localStatementContainerToken2 = new StatementContainerToken();
          ((Rule)localObject13).getRuleElementToken().getElseActions().addChildElement(localStatementContainerToken2);
          localStatementContainerToken2.addChildElement(localTableFunctionToken);
          localTableFunctionToken.setMemberElement((IElement)localObject8);
          localObject14 = (ValueToken)localTableFunctionToken.getValueTokens().get(0);
          localObject15 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement((IElement)localObject15);
          ((MemberToken)localObject15).setMemberElement((IElement)localObject6);
        }
        else if (((FieldModel)localObject5).getJavaType().m())
        {
          localObject6 = localRulePackage.getEnvionment().getValueLibrary().getVariable("query" + ((FieldModel)localObject5).getFieldName());
          if (localObject6 == null)
          {
            localObject6 = new MappingVariable("query" + ((FieldModel)localObject5).getFieldName(), ((FieldModel)localObject5).getDisplayName(), "string", true);
            localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject6);
          }
          localObject7 = localSelectTable1.addWhereFunction(((e)localObject4).g() + " like ?", ((FieldModel)localObject5).getDisplayName() + " like {arg1}", "string");
          localObject8 = (Rule)((RuleSet)localObject3).createChildNode("Rule");
          localObject9 = new ConditionToken();
          ((ConditionToken)localObject9).init();
          ((Rule)localObject8).getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject9);
          localObject11 = (MemberToken)((ConditionToken)localObject9).getFirstValue();
          ((MemberToken)localObject11).setMemberElement((IElement)localObject6);
          ((StringJudgeToken)((ConditionToken)localObject9).getCompareOperator()).setType(8);
          localObject12 = new TableFunctionToken();
          localObject13 = new StatementContainerToken();
          ((Rule)localObject8).getRuleElementToken().getThenActions().addChildElement((IElement)localObject13);
          ((StatementContainerToken)localObject13).addChildElement((IElement)localObject12);
          ((TableFunctionToken)localObject12).setMemberElement((IElement)localObject7);
          localObject14 = (ValueToken)((TableFunctionToken)localObject12).getValueTokens().get(0);
          localObject15 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement((IElement)localObject15);
          ((MemberToken)localObject15).setMemberElement((IElement)localObject6);
          ((ValueToken)localObject14).getOperator().setType(1);
          localObject16 = new ConstantToken("string");
          ((ValueToken)localObject14).getNextValue().addChildElement((IElement)localObject16);
          ((ConstantToken)localObject16).setValue("%");
        }
        else
        {
          localObject6 = localRulePackage.getEnvionment().getValueLibrary().getVariable("query" + ((FieldModel)localObject5).getFieldName());
          if (localObject6 == null)
          {
            localObject6 = new MappingVariable("query" + ((FieldModel)localObject5).getFieldName(), ((FieldModel)localObject5).getDisplayName(), "string", true);
            localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject6);
          }
          localObject7 = localSelectTable1.addWhereFunction(((e)localObject4).g() + " = ?", ((FieldModel)localObject5).getDisplayName() + " = {arg1}", "string");
          localObject8 = (Rule)((RuleSet)localObject3).createChildNode("Rule");
          localObject9 = new ConditionToken();
          ((ConditionToken)localObject9).init();
          ((Rule)localObject8).getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject9);
          localObject11 = (MemberToken)((ConditionToken)localObject9).getFirstValue();
          ((MemberToken)localObject11).setMemberElement((IElement)localObject6);
          ((StringJudgeToken)((ConditionToken)localObject9).getCompareOperator()).setType(8);
          localObject12 = new TableFunctionToken();
          localObject13 = new StatementContainerToken();
          ((Rule)localObject8).getRuleElementToken().getThenActions().addChildElement((IElement)localObject13);
          ((StatementContainerToken)localObject13).addChildElement((IElement)localObject12);
          ((TableFunctionToken)localObject12).setMemberElement((IElement)localObject7);
          localObject14 = (ValueToken)((TableFunctionToken)localObject12).getValueTokens().get(0);
          localObject15 = new MemberToken(((ValueToken)localObject14).getValueType());
          ((ValueToken)localObject14).addChildElement((IElement)localObject15);
          ((MemberToken)localObject15).setMemberElement((IElement)localObject6);
        }
      }
      Rule localRule = (Rule)localRulePackage.createChildNode("Rule");
      if (localRulePackage.getEnvionment().getValueLibrary().getVariable("page_num") != null)
      {
        localObject4 = localSelectTable1.getTableFunction("setOrderField");
        if (localObject4 != null)
        {
          localObject5 = new TableFunctionToken();
          localObject6 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
          ((StatementContainerToken)localObject6).addChildElement((IElement)localObject5);
          ((TableFunctionToken)localObject5).setMemberElement((IElement)localObject4);
          localObject7 = (ValueToken)((TableFunctionToken)localObject5).getValueTokens().get(0);
          localObject8 = new MemberToken(((ValueToken)localObject7).getValueType());
          ((ValueToken)localObject7).addChildElement((IElement)localObject8);
          ((MemberToken)localObject8).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("order_field"));
          localObject7 = (ValueToken)((TableFunctionToken)localObject5).getValueTokens().get(1);
          localObject8 = new MemberToken(((ValueToken)localObject7).getValueType());
          ((ValueToken)localObject7).addChildElement((IElement)localObject8);
          ((MemberToken)localObject8).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("order_desc"));
        }
        localObject4 = localSelectTable1.getTableFunction("setPage");
        if (localObject4 != null)
        {
          localObject5 = new TableFunctionToken();
          localObject6 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
          ((StatementContainerToken)localObject6).addChildElement((IElement)localObject5);
          ((TableFunctionToken)localObject5).setMemberElement((IElement)localObject4);
          localObject7 = (ValueToken)((TableFunctionToken)localObject5).getValueTokens().get(0);
          localObject8 = new MemberToken(((ValueToken)localObject7).getValueType());
          ((ValueToken)localObject7).addChildElement((IElement)localObject8);
          ((MemberToken)localObject8).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("page_num"));
          localObject7 = (ValueToken)((TableFunctionToken)localObject5).getValueTokens().get(1);
          localObject8 = new MemberToken(((ValueToken)localObject7).getValueType());
          ((ValueToken)localObject7).addChildElement((IElement)localObject8);
          ((MemberToken)localObject8).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("per_page"));
        }
      }
      Object localObject4 = localSelectTable1.getTableFunction("selectWhere");
      if (localObject4 != null)
      {
        localObject5 = new TableFunctionToken();
        localObject6 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
        ((StatementContainerToken)localObject6).addChildElement((IElement)localObject5);
        ((TableFunctionToken)localObject5).setMemberElement((IElement)localObject4);
      }
      localObject4 = localSheetTable.getTableFunction("loadFromView");
      if (localObject4 != null)
      {
        localObject5 = new TableFunctionToken();
        localObject6 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
        ((StatementContainerToken)localObject6).addChildElement((IElement)localObject5);
        ((TableFunctionToken)localObject5).setMemberElement((IElement)localObject4);
        localObject7 = (ValueToken)((TableFunctionToken)localObject5).getValueTokens().get(0);
        localObject8 = new MemberToken(((ValueToken)localObject7).getValueType());
        ((ValueToken)localObject7).addChildElement((IElement)localObject8);
        ((MemberToken)localObject8).setMemberElement(localSelectTable1);
      }
      if (localRulePackage.getEnvionment().getValueLibrary().getVariable("record_count") != null)
      {
        localObject4 = localSelectTable1.getTableFunction("getCount");
        if (localObject4 != null)
        {
          localObject5 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject5);
          localObject6 = new AssignToken();
          ((StatementContainerToken)localObject5).addChildElement((IElement)localObject6);
          localObject7 = new FieldToken();
          ((AssignToken)localObject6).addChildElement((IElement)localObject7);
          ((AssignToken)localObject6).addChildElement(new AssignJudgeToken());
          ((FieldToken)localObject7).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("record_count"));
          localObject8 = new TableFunctionToken(((TableFunction)localObject4).getValueType());
          ((AssignToken)localObject6).getComparedValue().addChildElement((IElement)localObject8);
          ((TableFunctionToken)localObject8).setMemberElement((IElement)localObject4);
        }
      }
      localRule = (Rule)localRulePackage.createChildNode("Rule");
      localRule.setSheetWhile(true);
      localRule.setSheetTable(localSheetTable);
      if (localRule != null)
      {
        localObject5 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject5);
        localObject6 = new AssignToken();
        ((StatementContainerToken)localObject5).addChildElement((IElement)localObject6);
        localObject7 = new FieldToken();
        ((AssignToken)localObject6).addChildElement((IElement)localObject7);
        ((AssignToken)localObject6).addChildElement(new AssignJudgeToken());
        ((FieldToken)localObject7).setMemberElement(localSheetTable.getField("nID"));
        localObject8 = ((AssignToken)localObject6).getComparedValue();
        for (int i2 = 0; i2 < this.i.size(); i2++)
        {
          localObject11 = new MemberSheetToken("string");
          ((IValueContainerToken)localObject8).addChildElement((IElement)localObject11);
          ((MemberSheetToken)localObject11).setMemberElement(localSheetTable.getField(((FieldModel)this.i.get(i2)).getFieldName()));
          if (i2 >= this.i.size() - 1)
            continue;
          ((IValueContainerToken)localObject8).getOperator().setType(1);
          localObject12 = new ConstantToken("string");
          ((IValueContainerToken)localObject8).getNextValue().addChildElement((IElement)localObject12);
          ((ConstantToken)localObject12).setValue("_");
          ((IValueContainerToken)localObject8).getNextValue().getOperator().setType(1);
          localObject8 = ((IValueContainerToken)localObject8).getNextValue().getNextValue();
        }
      }
      Object localObject5 = new HashMap();
      Object localObject10;
      for (int i1 = 0; i1 < localList2.size(); i1++)
      {
        localObject7 = (FKModel)localList2.get(i1);
        localTableModel.addChildElement((IElement)localObject7);
        if ((((FKModel)localObject7).getKeys().size() != 1) || (!((FKModel)localObject7).getFKTableName().equalsIgnoreCase(localTableModel.getTableName())) || (a(this.h, ((FKModel)localObject7).getPkTableName())))
          continue;
        localObject8 = this.a.getTableModel(((FKModel)localObject7).getPkTableName());
        if (localObject8 == null)
          continue;
        localObject10 = ((AdvancedProperty)((FKModel)localObject7).getKeys().get(0)).getKey();
        for (int i3 = 0; i3 < ((TableModel)localObject8).getFields().size(); i3++)
        {
          if ((!((FieldModel)((TableModel)localObject8).getFields().get(i3)).getFieldName().equalsIgnoreCase((String)localObject10)) || (i3 + 1 >= ((TableModel)localObject8).getFields().size()))
            continue;
          localObject10 = ((FieldModel)((TableModel)localObject8).getFields().get(i3 + 1)).getFieldName();
          break;
        }
        SelectTable localSelectTable2 = localDBModel.createSelectTable("select " + ((AdvancedProperty)((FKModel)localObject7).getKeys().get(0)).getKey() + "," + (String)localObject10 + " from " + ((TableModel)localObject8).getTableName(), ((FKModel)localObject7).getFKName(), ((FKModel)localObject7).getFKName());
        localObject12 = new MappingVariable("list" + ((FKModel)localObject7).getFKName(), ((FKModel)localObject7).getFKName(), "list<list>", true);
        localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject12);
        localRule = (Rule)localRulePackage.createChildNode("Rule");
        localObject4 = localSelectTable2.getTableFunction("selectWhere");
        if (localObject4 != null)
        {
          localObject13 = new TableFunctionToken();
          localObject14 = new StatementContainerToken();
          localRule.getRuleElementToken().getInitActions().addChildElement((IElement)localObject14);
          ((StatementContainerToken)localObject14).addChildElement((IElement)localObject13);
          ((TableFunctionToken)localObject13).setMemberElement((IElement)localObject4);
        }
        localObject4 = localSelectTable2.getTableFunction("getListResult");
        if (localObject4 != null)
        {
          localObject13 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject13);
          localObject14 = new AssignToken();
          ((StatementContainerToken)localObject13).addChildElement((IElement)localObject14);
          localObject15 = new FieldToken();
          ((AssignToken)localObject14).addChildElement((IElement)localObject15);
          ((AssignToken)localObject14).addChildElement(new AssignJudgeToken());
          if (localObject12 != null)
            ((FieldToken)localObject15).setMemberElement((IElement)localObject12);
          else
            ((AssignToken)localObject14).changeFieldType(((TableFunction)localObject4).getJavaType());
          localObject16 = new TableFunctionToken(((TableFunction)localObject4).getValueType());
          ((AssignToken)localObject14).getComparedValue().addChildElement((IElement)localObject16);
          ((TableFunctionToken)localObject16).setMemberElement((IElement)localObject4);
        }
        localRule.setModified(true);
        ((HashMap)localObject5).put(((AdvancedProperty)((FKModel)localObject7).getKeys().get(0)).getKey(), localSelectTable2);
      }
      Object localObject7 = localRulePackage.getExportModels();
      if (((Iterator)localObject7).hasNext())
      {
        ExportModel localExportModel = (ExportModel)((Iterator)localObject7).next();
        localExportModel.setDisplayName(localRulePackage.getExeRulePackageName().replace('.', '/') + ".jsp");
        if (localExportModel.getPageField(localSheetTable.getValueName()) == null)
        {
          localObject8 = new PageFieldModel();
          ((PageFieldModel)localObject8).setDisplayName(this.d);
          ((PageFieldModel)localObject8).setVariableName(localSheetTable.getValueName());
          ((PageFieldModel)localObject8).setValueType("com.flagleader.db.Sheet");
          ((PageFieldModel)localObject8).setPropertyValue("editonlie", "true");
          ((PageFieldModel)localObject8).setPropertyValue("editwindow", "panel");
          if (this.c.endsWith("sheet"))
          {
            ((PageFieldModel)localObject8).setInputType("notdisplay");
            ((PageFieldModel)localObject8).setResultType("table");
          }
          else
          {
            ((PageFieldModel)localObject8).setInputType("sheetinput");
            ((PageFieldModel)localObject8).setResultType("notdisplay");
          }
          localExportModel.addChildElement((IElement)localObject8);
          a((PageFieldModel)localObject8, ((PageFieldModel)localObject8).getInputType());
          a((PageFieldModel)localObject8, ((PageFieldModel)localObject8).getResultType());
          localObject10 = localSelectTable1.getFields();
          for (int i4 = 0; i4 < ((List)localObject10).size(); i4++)
          {
            localObject12 = (FieldModel)((List)localObject10).get(i4);
            localObject13 = new PageFieldModel();
            ((PageFieldModel)localObject13).setInputType("text");
            localObject14 = ((PageFieldModel)localObject13).getPageTypeNames();
            for (int i6 = 0; i6 < localObject14.length; i6++)
              if (localExportModel.getPreferences().getStringArray(((PageFieldModel)localObject8).getInputType() + "." + localObject14[i6]) != null)
                ((PageFieldModel)localObject13).setPageTypeValue(localObject14[i6], localExportModel.getPreferences().getStringArray(((PageFieldModel)localObject8).getInputType() + "." + localObject14[i6])[0]);
              else if (localExportModel.getPreferences().getStringArray(((PageFieldModel)localObject8).getResultType() + "." + localObject14[i6]) != null)
                ((PageFieldModel)localObject13).setPageTypeValue(localObject14[i6], localExportModel.getPreferences().getStringArray(((PageFieldModel)localObject8).getResultType() + "." + localObject14[i6])[0]);
              else
                ((PageFieldModel)localObject13).setPageTypeValue(localObject14[i6], ((PageFieldModel)localObject8).getPageTypeValue(localObject14[i6]));
            ((PageFieldModel)localObject13).setVariableName(((PageFieldModel)localObject8).getVariableName() + "_" + (i4 + 1));
            ((PageFieldModel)localObject13).setValueType(((FieldModel)localObject12).getValueType());
            if (((FieldModel)localObject12).getValueType().equalsIgnoreCase("datetime"))
              ((PageFieldModel)localObject13).setValueType("date");
            if (((PageFieldModel)localObject13).getJavaType().isDate())
              ((PageFieldModel)localObject13).setInputType("datetext");
            else if (((PageFieldModel)localObject13).getJavaType().isNumber())
              ((PageFieldModel)localObject13).setInputType("numbertext");
            else
              ((PageFieldModel)localObject13).setInputType("text");
            ((PageFieldModel)localObject13).setDisplayName(((FieldModel)localObject12).getDisplayName());
            ((PageFieldModel)localObject13).setLen(((FieldModel)localObject12).getLen());
            ((PageFieldModel)localObject13).setPropertyValue("fieldName", ((FieldModel)localObject12).getFieldName());
            if ((((HashMap)localObject5).get(((FieldModel)localObject12).getValueName()) != null) && ((((HashMap)localObject5).get(((FieldModel)localObject12).getValueName()) instanceof SelectTable)))
            {
              ((PageFieldModel)localObject13).setInputType("select");
              ((PageFieldModel)localObject13).setPropertyValue("p_options", "list" + ((SelectTable)((HashMap)localObject5).get(((FieldModel)localObject12).getValueName())).getValueName());
            }
            FieldModel localFieldModel = a(((FieldModel)localObject12).getFieldName());
            if ((localFieldModel != null) && (localFieldModel.getAdvanceProperties().length > 0))
            {
              ((PageFieldModel)localObject13).setInputType("select");
              for (int i7 = 0; i7 < localFieldModel.getAdvanceProperties().length; i7++)
                ((PageFieldModel)localObject13).setPropertyValue("o_" + localFieldModel.getAdvanceProperties()[i7].getKey(), localFieldModel.getAdvanceProperties()[i7].getProperty());
            }
            ((PageFieldModel)localObject8).addChildElement((IElement)localObject13);
            ((PageFieldModel)localObject13).setResultType("label");
            a((PageFieldModel)localObject13, ((PageFieldModel)localObject13).getInputType());
            a((PageFieldModel)localObject13, ((PageFieldModel)localObject13).getResultType());
          }
        }
        localObject8 = localExportModel.getEnvionment().getAllMappingVariable();
        while (((Iterator)localObject8).hasNext())
        {
          localObject10 = (MappingVariable)((Iterator)localObject8).next();
          if ((localExportModel.getPageField(((MappingVariable)localObject10).getVariableName()) != null) || (((MappingVariable)localObject10).getJavaType().D()))
            continue;
          PageFieldModel localPageFieldModel = localExportModel.addMappingVariable((MappingVariable)localObject10);
          if (((MappingVariable)localObject10).getValueType().equalsIgnoreCase("list<list>"))
          {
            localPageFieldModel.setInputType("hidden");
            localPageFieldModel.setResultType("notdisplay");
          }
          else
          {
            localPageFieldModel.setInputType("text");
          }
          if (localPageFieldModel.getValueType().equalsIgnoreCase("datetime"))
            localPageFieldModel.setValueType("date");
          if (localPageFieldModel.getJavaType().isDate())
            localPageFieldModel.setInputType("datetext");
          else if (localPageFieldModel.getJavaType().isNumber())
            localPageFieldModel.setInputType("numbertext");
          if (((MappingVariable)localObject10).getValueName().startsWith("query"))
          {
            localObject12 = a(((MappingVariable)localObject10).getValueName().substring(5));
            if (localObject12 != null)
            {
              if ((((HashMap)localObject5).get(((MappingVariable)localObject10).getValueName().substring(5)) != null) && ((((HashMap)localObject5).get(((MappingVariable)localObject10).getValueName().substring(5)) instanceof SelectTable)))
              {
                localPageFieldModel.setPropertyValue("o_", "");
                localPageFieldModel.setInputType("select");
                localPageFieldModel.setPropertyValue("p_options", "list" + ((SelectTable)((HashMap)localObject5).get(((MappingVariable)localObject10).getValueName().substring(5))).getValueName());
              }
              if (((FieldModel)localObject12).getAdvanceProperties().length > 0)
              {
                localPageFieldModel.setInputType("select");
                localPageFieldModel.setPropertyValue("o_", "");
                for (int i5 = 0; i5 < ((FieldModel)localObject12).getAdvanceProperties().length; i5++)
                  localPageFieldModel.setPropertyValue("o_" + localObject12.getAdvanceProperties()[i5].getKey(), localObject12.getAdvanceProperties()[i5].getProperty());
              }
            }
          }
          a(localPageFieldModel, localPageFieldModel.getInputType());
          a(localPageFieldModel, localPageFieldModel.getResultType());
        }
        localExportModel.setModified(true);
      }
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }

  public void d()
  {
    if (c.class.getClassLoader().getResource(this.c + "/list.rpk") == null)
      return;
    RulePackage localRulePackage;
    try
    {
      localRulePackage = (RulePackage)((RulePackage)new d().load(c.class.getClassLoader().getResourceAsStream(this.c + "/list.rpk"))).deepClone();
    }
    catch (Exception localException1)
    {
      return;
    }
    localRulePackage.setDisplayName(localRulePackage.getDisplayName() + this.d);
    localRulePackage.setExeRulePackageName(this.e + ".list");
    this.b.addChildElement(localRulePackage);
    localRulePackage.setFilePathName("");
    DBModel localDBModel = a(localRulePackage);
    try
    {
      com.flagleader.repository.db.a.a locala = new com.flagleader.repository.db.a.a(this.a);
      SelectTable localSelectTable = localDBModel.createSelectTable(locala.a(this.h), this.d, this.j);
      a(localSelectTable, locala);
      SheetTable localSheetTable = new SheetTable();
      localSheetTable.setDisplayName("sheet" + this.d);
      localSheetTable.setEnglishName("sheet" + this.j);
      localSheetTable.updateFunction();
      localDBModel.addChildElement(localSheetTable);
      localSheetTable.addChildElement(new SheetFieldModel("nID", "nID", "string", true));
      for (int k = 0; k < localSelectTable.getFields().size(); k++)
        localSheetTable.addChildElement(new SheetFieldModel((FieldModel)localSelectTable.getFields().get(k)));
      MappingVariable localMappingVariable = new MappingVariable("list" + this.j, this.d, "list<list>", true);
      localRulePackage.getEnvionment().getValueLibrary().addChildElement(localMappingVariable);
      Rule localRule = (Rule)localRulePackage.createChildNode("Rule");
      Object localObject1;
      Object localObject3;
      Object localObject4;
      if (localRulePackage.getEnvionment().getValueLibrary().getVariable("page_num") != null)
      {
        localTableFunction = localSelectTable.getTableFunction("setOrderField");
        if (localTableFunction != null)
        {
          localObject1 = new TableFunctionToken();
          localObject2 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject2);
          ((StatementContainerToken)localObject2).addChildElement((IElement)localObject1);
          ((TableFunctionToken)localObject1).setMemberElement(localTableFunction);
          localObject3 = (ValueToken)((TableFunctionToken)localObject1).getValueTokens().get(0);
          localObject4 = new MemberToken(((ValueToken)localObject3).getValueType());
          ((ValueToken)localObject3).addChildElement((IElement)localObject4);
          ((MemberToken)localObject4).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("order_field"));
          localObject3 = (ValueToken)((TableFunctionToken)localObject1).getValueTokens().get(1);
          localObject4 = new MemberToken(((ValueToken)localObject3).getValueType());
          ((ValueToken)localObject3).addChildElement((IElement)localObject4);
          ((MemberToken)localObject4).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("order_desc"));
        }
        localTableFunction = localSelectTable.getTableFunction("setPage");
        if (localTableFunction != null)
        {
          localObject1 = new TableFunctionToken();
          localObject2 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject2);
          ((StatementContainerToken)localObject2).addChildElement((IElement)localObject1);
          ((TableFunctionToken)localObject1).setMemberElement(localTableFunction);
          localObject3 = (ValueToken)((TableFunctionToken)localObject1).getValueTokens().get(0);
          localObject4 = new MemberToken(((ValueToken)localObject3).getValueType());
          ((ValueToken)localObject3).addChildElement((IElement)localObject4);
          ((MemberToken)localObject4).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("page_num"));
          localObject3 = (ValueToken)((TableFunctionToken)localObject1).getValueTokens().get(1);
          localObject4 = new MemberToken(((ValueToken)localObject3).getValueType());
          ((ValueToken)localObject3).addChildElement((IElement)localObject4);
          ((MemberToken)localObject4).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("per_page"));
        }
      }
      TableFunction localTableFunction = localSelectTable.getTableFunction("selectWhere");
      if (localTableFunction != null)
      {
        localObject1 = new TableFunctionToken();
        localObject2 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject2);
        ((StatementContainerToken)localObject2).addChildElement((IElement)localObject1);
        ((TableFunctionToken)localObject1).setMemberElement(localTableFunction);
      }
      localTableFunction = localSheetTable.getTableFunction("loadFromView");
      if (localTableFunction != null)
      {
        localObject1 = new TableFunctionToken();
        localObject2 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject2);
        ((StatementContainerToken)localObject2).addChildElement((IElement)localObject1);
        ((TableFunctionToken)localObject1).setMemberElement(localTableFunction);
        localObject3 = (ValueToken)((TableFunctionToken)localObject1).getValueTokens().get(0);
        localObject4 = new MemberToken(((ValueToken)localObject3).getValueType());
        ((ValueToken)localObject3).addChildElement((IElement)localObject4);
        ((MemberToken)localObject4).setMemberElement(localSelectTable);
      }
      if (localRulePackage.getEnvionment().getValueLibrary().getVariable("record_count") != null)
      {
        localTableFunction = localSelectTable.getTableFunction("getCount");
        if (localTableFunction != null)
        {
          localObject1 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject1);
          localObject2 = new AssignToken();
          ((StatementContainerToken)localObject1).addChildElement((IElement)localObject2);
          localObject3 = new FieldToken();
          ((AssignToken)localObject2).addChildElement((IElement)localObject3);
          ((AssignToken)localObject2).addChildElement(new AssignJudgeToken());
          ((FieldToken)localObject3).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("record_count"));
          localObject4 = new TableFunctionToken(localTableFunction.getValueType());
          ((AssignToken)localObject2).getComparedValue().addChildElement((IElement)localObject4);
          ((TableFunctionToken)localObject4).setMemberElement(localTableFunction);
        }
      }
      localRule = (Rule)localRulePackage.createChildNode("Rule");
      localRule.setSheetWhile(true);
      localRule.setSheetTable(localSheetTable);
      int n;
      Object localObject5;
      Object localObject6;
      if (localRule != null)
      {
        localObject1 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject1);
        localObject2 = new AssignToken();
        ((StatementContainerToken)localObject1).addChildElement((IElement)localObject2);
        localObject3 = new FieldToken();
        ((AssignToken)localObject2).addChildElement((IElement)localObject3);
        ((AssignToken)localObject2).addChildElement(new AssignJudgeToken());
        ((FieldToken)localObject3).setMemberElement(localSheetTable.getField("nID"));
        localObject4 = ((AssignToken)localObject2).getComparedValue();
        for (n = 0; n < this.i.size(); n++)
        {
          localObject5 = new MemberSheetToken("string");
          ((IValueContainerToken)localObject4).addChildElement((IElement)localObject5);
          ((MemberSheetToken)localObject5).setMemberElement(localSheetTable.getField(((FieldModel)this.i.get(n)).getFieldName()));
          if (n >= this.i.size() - 1)
            continue;
          ((IValueContainerToken)localObject4).getOperator().setType(1);
          localObject6 = new ConstantToken("string");
          ((IValueContainerToken)localObject4).getNextValue().addChildElement((IElement)localObject6);
          ((ConstantToken)localObject6).setValue("_");
          ((IValueContainerToken)localObject4).getNextValue().getOperator().setType(1);
          localObject4 = ((IValueContainerToken)localObject4).getNextValue().getNextValue();
        }
      }
      localRule = (Rule)localRulePackage.createChildNode("Rule");
      localTableFunction = localSheetTable.getTableFunction("getListResult");
      if (localTableFunction != null)
      {
        localObject1 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject1);
        localObject2 = new AssignToken();
        ((StatementContainerToken)localObject1).addChildElement((IElement)localObject2);
        localObject3 = new FieldToken();
        ((AssignToken)localObject2).addChildElement((IElement)localObject3);
        ((AssignToken)localObject2).addChildElement(new AssignJudgeToken());
        if (localMappingVariable != null)
          ((FieldToken)localObject3).setMemberElement(localMappingVariable);
        else
          ((AssignToken)localObject2).changeFieldType(localTableFunction.getJavaType());
        localObject4 = new TableFunctionToken(localTableFunction.getValueType());
        ((AssignToken)localObject2).getComparedValue().addChildElement((IElement)localObject4);
        ((TableFunctionToken)localObject4).setMemberElement(localTableFunction);
      }
      localRule.setModified(true);
      if (localRulePackage.getExportModels().hasNext())
      {
        localObject1 = (ExportModel)localRulePackage.getExportModels().next();
        ((ExportModel)localObject1).setDisplayName(localRulePackage.getExeRulePackageName().replace('.', '/') + ".jsp");
      }
      else
      {
        localObject1 = (ExportModel)localRulePackage.createChildNode("ExportModel");
        ((ExportModel)localObject1).setDisplayName(localRulePackage.getExeRulePackageName().replace('.', '/') + ".jsp");
        ((ExportModel)localObject1).setImportFile("standard/page_output.rsp");
        localObject2 = new String[0];
        if (((ExportModel)localObject1).getImportFile().length() > 0)
          localObject2 = ((ExportModel)localObject1).getPreferences().getStringArray(((ExportModel)localObject1).getImportFile() + ".props");
        if (localObject2 == null)
          localObject2 = ((ExportModel)localObject1).getPreferences().getStringArray("export.props");
        for (int m = 0; m < localObject2.length; m++)
        {
          localObject4 = ((ExportModel)localObject1).getPreferences().getString(localObject2[m] + ".default", "");
          if (((String)localObject4).length() <= 0)
            continue;
          ((ExportModel)localObject1).setPropertyValue(localObject2[m], (String)localObject4);
        }
        ((ExportModel)localObject1).setPropertyValue("addpage", "add.jsp");
        ((ExportModel)localObject1).setPropertyValue("editpage", "edit.jsp");
        ((ExportModel)localObject1).setPropertyValue("deletepage", "delete.jsp");
        ((ExportModel)localObject1).setPropertyValue("submitpage", "list.jsp");
      }
      Object localObject2 = localMappingVariable;
      if (((ExportModel)localObject1).getPageField(((MappingVariable)localObject2).getVariableName()) == null)
      {
        PageFieldModel localPageFieldModel = ((ExportModel)localObject1).addMappingVariable((MappingVariable)localObject2);
        a(localPageFieldModel, localPageFieldModel.getInputType());
        a(localPageFieldModel, localPageFieldModel.getResultType());
        localObject4 = localSelectTable.getFields();
        for (n = 0; n < ((List)localObject4).size(); n++)
        {
          localObject5 = new PageFieldModel();
          localObject6 = (FieldModel)((List)localObject4).get(n);
          String[] arrayOfString = ((PageFieldModel)localObject5).getPageTypeNames();
          for (int i1 = 0; i1 < arrayOfString.length; i1++)
            if (((ExportModel)localObject1).getPreferences().getStringArray(localPageFieldModel.getInputType() + "." + arrayOfString[i1]) != null)
              ((PageFieldModel)localObject5).setPageTypeValue(arrayOfString[i1], localObject1.getPreferences().getStringArray(localPageFieldModel.getInputType() + "." + arrayOfString[i1])[0]);
            else if (((ExportModel)localObject1).getPreferences().getStringArray(localPageFieldModel.getResultType() + "." + arrayOfString[i1]) != null)
              ((PageFieldModel)localObject5).setPageTypeValue(arrayOfString[i1], localObject1.getPreferences().getStringArray(localPageFieldModel.getResultType() + "." + arrayOfString[i1])[0]);
            else
              ((PageFieldModel)localObject5).setPageTypeValue(arrayOfString[i1], localPageFieldModel.getPageTypeValue(arrayOfString[i1]));
          ((PageFieldModel)localObject5).setVariableName(localPageFieldModel.getVariableName() + "_" + (n + 1));
          ((PageFieldModel)localObject5).setValueType(((FieldModel)localObject6).getValueType());
          if (((FieldModel)localObject6).getValueType().equalsIgnoreCase("datetime"))
            ((PageFieldModel)localObject5).setValueType("date");
          ((PageFieldModel)localObject5).setDisplayName(((FieldModel)localObject6).getDisplayName());
          ((PageFieldModel)localObject5).setLen(((FieldModel)localObject6).getLen());
          ((PageFieldModel)localObject5).setPropertyValue("fieldName", ((FieldModel)localObject6).getFieldName());
          FieldModel localFieldModel = a(((FieldModel)localObject6).getFieldName());
          if ((localFieldModel != null) && (localFieldModel.getAdvanceProperties().length > 0))
          {
            ((PageFieldModel)localObject5).setInputType("select");
            for (int i2 = 0; i2 < localFieldModel.getAdvanceProperties().length; i2++)
              ((PageFieldModel)localObject5).setPropertyValue("o_" + localFieldModel.getAdvanceProperties()[i2].getKey(), localFieldModel.getAdvanceProperties()[i2].getProperty());
          }
          localPageFieldModel.addChildElement((IElement)localObject5);
          a((ExportModel)localObject1, (PageFieldModel)localObject5);
        }
      }
      ((ExportModel)localObject1).setModified(true);
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }

  public void e()
  {
    if (c.class.getClassLoader().getResource(this.c + "/delete.rpk") == null)
      return;
    RulePackage localRulePackage;
    try
    {
      localRulePackage = (RulePackage)((RulePackage)new d().load(c.class.getClassLoader().getResourceAsStream(this.c + "/delete.rpk"))).deepClone();
    }
    catch (Exception localException1)
    {
      return;
    }
    localRulePackage.setDisplayName(localRulePackage.getDisplayName() + this.d);
    localRulePackage.setExeRulePackageName(this.e + ".delete");
    this.b.addChildElement(localRulePackage);
    localRulePackage.setFilePathName("");
    DBModel localDBModel = new DBModel();
    localDBModel.setDriver(this.a.getDriver());
    localDBModel.setUrl(this.a.getUrl());
    localDBModel.setUserName(this.a.getUserName());
    localDBModel.setPasswd(this.a.getPasswd());
    localDBModel.setDatasourceName(this.a.getDisplayName());
    localDBModel.setDisplayName(this.a.getDisplayName());
    localDBModel.setSchemaName(this.a.getSchemaName());
    localDBModel.setCatalogName(this.a.getCatalogName());
    localRulePackage.getEnvionment().addChildElement(localDBModel);
    try
    {
      HashMap localHashMap = new HashMap();
      Object localObject1;
      Object localObject2;
      Object localObject4;
      Object localObject3;
      for (int k = 0; k < this.h.size(); k++)
      {
        localObject1 = (TableModel)this.h.get(k);
        List localList = this.a.getFKModels(((TableModel)localObject1).getTableName());
        for (int n = 0; n < localList.size(); n++)
        {
          FKModel localFKModel = (FKModel)localList.get(n);
          ((TableModel)localObject1).addChildElement(localFKModel);
        }
        localDBModel.addChildElement((IElement)localObject1);
        localDBModel.updateTableModel((TableModel)localObject1);
        localObject2 = (Rule)((RuleSet)((RuleSet)localRulePackage.getRuleAndSets().next()).getRuleAndSets().next()).getRuleAndSets().next();
        Object localObject5;
        for (int i2 = 0; i2 < this.i.size(); i2++)
        {
          localObject4 = ((TableModel)localObject1).getFieldSetFunc((FieldModel)this.i.get(i2));
          if (localObject4 == null)
            continue;
          localObject5 = new TableFunctionToken();
          StatementContainerToken localStatementContainerToken = new StatementContainerToken();
          ((Rule)localObject2).getRuleElementToken().getThenActions().addChildElement(localStatementContainerToken);
          localStatementContainerToken.addChildElement((IElement)localObject5);
          ((TableFunctionToken)localObject5).setMemberElement((IElement)localObject4);
          ValueToken localValueToken = (ValueToken)((TableFunctionToken)localObject5).getValueTokens().get(0);
          MemberToken localMemberToken = new MemberToken(localValueToken.getValueType());
          localValueToken.addChildElement(localMemberToken);
          localMemberToken.setMemberElement((SubVariable)localRulePackage.getEnvionment().getTempVariableLibrary().getVariable("ids").getSubEditens().next());
          localValueToken = (ValueToken)localMemberToken.getValueTokens().get(0);
          ConstantToken localConstantToken = new ConstantToken("int");
          localValueToken.addChildElement(localConstantToken);
          localConstantToken.setValue(String.valueOf(i2));
        }
        localObject3 = ((TableModel)localObject1).getTableFunction("delete");
        if (localObject3 != null)
        {
          localObject4 = new TableFunctionToken();
          localObject5 = new StatementContainerToken();
          ((Rule)localObject2).getRuleElementToken().getThenActions().addChildElement((IElement)localObject5);
          ((StatementContainerToken)localObject5).addChildElement((IElement)localObject4);
          ((TableFunctionToken)localObject4).setMemberElement((IElement)localObject3);
        }
        ((Rule)localObject2).setModified(true);
      }
      ExportModel localExportModel;
      if (localRulePackage.getExportModels().hasNext())
      {
        localExportModel = (ExportModel)localRulePackage.getExportModels().next();
        localExportModel.setDisplayName(localRulePackage.getExeRulePackageName().replace('.', '/') + ".jsp");
      }
      else
      {
        localExportModel = (ExportModel)localRulePackage.createChildNode("ExportModel");
        localExportModel.setDisplayName(localRulePackage.getExeRulePackageName().replace('.', '/') + ".jsp");
        localExportModel.setImportFile("standard/page_input.rsp");
        localObject1 = new String[0];
        if (localExportModel.getImportFile().length() > 0)
          localObject1 = localExportModel.getPreferences().getStringArray(localExportModel.getImportFile() + ".props");
        if (localObject1 == null)
          localObject1 = localExportModel.getPreferences().getStringArray("export.props");
        for (int m = 0; m < localObject1.length; m++)
        {
          localObject2 = localExportModel.getPreferences().getString(localObject1[m] + ".default", "");
          if (((String)localObject2).length() <= 0)
            continue;
          localExportModel.setPropertyValue(localObject1[m], (String)localObject2);
        }
        localExportModel.setPropertyValue("submit", "reset");
        localExportModel.setPropertyValue("success", "successtopage");
        localExportModel.setPropertyValue("successpage", "list.jsp");
        Iterator localIterator = localExportModel.getEnvionment().getAllMappingVariable();
        int i1 = 0;
        while (localIterator.hasNext())
        {
          localObject3 = (MappingVariable)localIterator.next();
          if (localExportModel.getPageField(((MappingVariable)localObject3).getVariableName()) != null)
            continue;
          localObject4 = localExportModel.addMappingVariable((MappingVariable)localObject3);
          if (localHashMap.get(((MappingVariable)localObject3).getValueName()) != null)
          {
            if ((localHashMap.get(((MappingVariable)localObject3).getValueName()) instanceof SelectTable))
            {
              ((PageFieldModel)localObject4).setInputType("select");
              ((PageFieldModel)localObject4).setPropertyValue("p_options", "list" + ((SelectTable)localHashMap.get(((MappingVariable)localObject3).getValueName())).getValueName());
            }
            else
            {
              ((PageFieldModel)localObject4).setInputType("textauto");
              ((PageFieldModel)localObject4).setPropertyValue("sql", (String)localHashMap.get(((MappingVariable)localObject3).getValueName()));
              ((PageFieldModel)localObject4).setPropertyValue("connection", this.a.getDatasourceName());
            }
          }
          else if (((MappingVariable)localObject3).getValueName().equalsIgnoreCase("su"))
          {
            ((PageFieldModel)localObject4).setStatType("success");
            ((PageFieldModel)localObject4).setInputType("notdisplay");
            ((PageFieldModel)localObject4).setResultType("notdisplay");
          }
          else if (((MappingVariable)localObject3).getValueName().equalsIgnoreCase("buttontijiao"))
          {
            ((PageFieldModel)localObject4).setStatType("input");
            ((PageFieldModel)localObject4).setInputType("button");
          }
          else if (((MappingVariable)localObject3).getValueName().equalsIgnoreCase("nID"))
          {
            ((PageFieldModel)localObject4).setInputType("hidden");
          }
          else if (((MappingVariable)localObject3).getValueType().equalsIgnoreCase("list<list>"))
          {
            ((PageFieldModel)localObject4).setStatType("output");
            ((PageFieldModel)localObject4).setResultType("notdisplay");
          }
          a((PageFieldModel)localObject4, ((PageFieldModel)localObject4).getInputType());
          a((PageFieldModel)localObject4, ((PageFieldModel)localObject4).getResultType());
        }
      }
      localExportModel.setModified(true);
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }

  public void f()
  {
    if (c.class.getClassLoader().getResource(this.c + "/edit.rpk") == null)
      return;
    RulePackage localRulePackage;
    try
    {
      localRulePackage = (RulePackage)((RulePackage)new d().load(c.class.getClassLoader().getResourceAsStream(this.c + "/edit.rpk"))).deepClone();
    }
    catch (Exception localException1)
    {
      return;
    }
    localRulePackage.setDisplayName(localRulePackage.getDisplayName() + this.d);
    localRulePackage.setExeRulePackageName(this.e + ".edit");
    this.b.addChildElement(localRulePackage);
    localRulePackage.setFilePathName("");
    DBModel localDBModel = new DBModel();
    localDBModel.setDriver(this.a.getDriver());
    localDBModel.setUrl(this.a.getUrl());
    localDBModel.setUserName(this.a.getUserName());
    localDBModel.setPasswd(this.a.getPasswd());
    localDBModel.setDatasourceName(this.a.getDisplayName());
    localDBModel.setDisplayName(this.a.getDisplayName());
    localDBModel.setSchemaName(this.a.getSchemaName());
    localDBModel.setCatalogName(this.a.getCatalogName());
    localRulePackage.getEnvionment().addChildElement(localDBModel);
    MappingVariable localMappingVariable1 = localRulePackage.getEnvionment().getValueLibrary().getVariable("buttontijiao");
    MappingVariable localMappingVariable2 = localRulePackage.getEnvionment().getValueLibrary().getVariable("su");
    MappingVariable localMappingVariable3 = localRulePackage.getEnvionment().getValueLibrary().getVariable("nID");
    SubVariable localSubVariable = (SubVariable)((SubTypeMethod)localMappingVariable3.getSubEditens().next()).getSubEditens().next();
    RuleSet localRuleSet1 = (RuleSet)localRulePackage.createChildNode("RuleSet");
    ConditionToken localConditionToken1 = new ConditionToken();
    localConditionToken1.init();
    localRuleSet1.getRuleSetToken().getTestConditions().addChildElement(localConditionToken1);
    MemberToken localMemberToken1 = (MemberToken)localConditionToken1.getFirstValue();
    localMemberToken1.setMemberElement(localMappingVariable1);
    ((StringJudgeToken)localConditionToken1.getCompareOperator()).setType(8);
    RuleSet localRuleSet2 = (RuleSet)localRulePackage.createChildNode("RuleSet");
    ConditionToken localConditionToken2 = new ConditionToken();
    localConditionToken2.init();
    localRuleSet2.getRuleSetToken().getTestConditions().addChildElement(localConditionToken2);
    MemberToken localMemberToken2 = (MemberToken)localConditionToken2.getFirstValue();
    localMemberToken2.setMemberElement(localMappingVariable1);
    ((StringJudgeToken)localConditionToken2.getCompareOperator()).setType(9);
    try
    {
      HashMap localHashMap = new HashMap();
      Object localObject3;
      Object localObject2;
      Object localObject5;
      for (int k = 0; k < this.h.size(); k++)
      {
        localObject1 = (TableModel)this.h.get(k);
        List localList = this.a.getFKModels(((TableModel)localObject1).getTableName());
        Object localObject4;
        Object localObject9;
        Object localObject10;
        Object localObject11;
        Object localObject12;
        Object localObject13;
        Object localObject14;
        for (int n = 0; n < localList.size(); n++)
        {
          localObject3 = (FKModel)localList.get(n);
          ((TableModel)localObject1).addChildElement((IElement)localObject3);
          if ((((FKModel)localObject3).getKeys().size() != 1) || (!((FKModel)localObject3).getFKTableName().equalsIgnoreCase(((TableModel)localObject1).getTableName())) || (a(this.h, ((FKModel)localObject3).getPkTableName())))
            continue;
          localObject4 = this.a.getTableModel(((FKModel)localObject3).getPkTableName());
          if (localObject4 == null)
            continue;
          localObject6 = ((AdvancedProperty)((FKModel)localObject3).getKeys().get(0)).getKey();
          for (int i3 = 0; i3 < ((TableModel)localObject4).getFields().size(); i3++)
          {
            if ((!((FieldModel)((TableModel)localObject4).getFields().get(i3)).getFieldName().equalsIgnoreCase((String)localObject6)) || (i3 + 1 >= ((TableModel)localObject4).getFields().size()))
              continue;
            localObject6 = ((FieldModel)((TableModel)localObject4).getFields().get(i3 + 1)).getFieldName();
            break;
          }
          if ((((TableModel)localObject4).getField(((AdvancedProperty)((FKModel)localObject3).getKeys().get(0)).getKey()) != null) && (!((TableModel)localObject4).getField(((AdvancedProperty)((FKModel)localObject3).getKeys().get(0)).getKey()).getValueType().equalsIgnoreCase("string")))
          {
            localObject7 = localDBModel.createSelectTable("select " + ((AdvancedProperty)((FKModel)localObject3).getKeys().get(0)).getKey() + "," + (String)localObject6 + " from " + ((TableModel)localObject4).getTableName(), ((FKModel)localObject3).getFKName(), ((FKModel)localObject3).getFKName());
            localObject8 = new MappingVariable("list" + ((FKModel)localObject3).getFKName(), ((FKModel)localObject3).getFKName(), "list<list>", true);
            localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject8);
            localObject9 = (Rule)localRulePackage.createChildNode("Rule");
            localObject10 = ((SelectTable)localObject7).getTableFunction("selectWhere");
            if (localObject10 != null)
            {
              localObject11 = new TableFunctionToken();
              localObject12 = new StatementContainerToken();
              ((Rule)localObject9).getRuleElementToken().getInitActions().addChildElement((IElement)localObject12);
              ((StatementContainerToken)localObject12).addChildElement((IElement)localObject11);
              ((TableFunctionToken)localObject11).setMemberElement((IElement)localObject10);
            }
            localObject10 = ((SelectTable)localObject7).getTableFunction("getListResult");
            if (localObject10 != null)
            {
              localObject11 = new StatementContainerToken();
              ((Rule)localObject9).getRuleElementToken().getThenActions().addChildElement((IElement)localObject11);
              localObject12 = new AssignToken();
              ((StatementContainerToken)localObject11).addChildElement((IElement)localObject12);
              localObject13 = new FieldToken();
              ((AssignToken)localObject12).addChildElement((IElement)localObject13);
              ((AssignToken)localObject12).addChildElement(new AssignJudgeToken());
              if (localObject8 != null)
                ((FieldToken)localObject13).setMemberElement((IElement)localObject8);
              else
                ((AssignToken)localObject12).changeFieldType(((TableFunction)localObject10).getJavaType());
              localObject14 = new TableFunctionToken(((TableFunction)localObject10).getValueType());
              ((AssignToken)localObject12).getComparedValue().addChildElement((IElement)localObject14);
              ((TableFunctionToken)localObject14).setMemberElement((IElement)localObject10);
            }
            ((Rule)localObject9).setModified(true);
            localHashMap.put(((AdvancedProperty)((FKModel)localObject3).getKeys().get(0)).getKey(), localObject7);
          }
          else
          {
            localObject7 = "select " + ((AdvancedProperty)((FKModel)localObject3).getKeys().get(0)).getKey() + "," + (String)localObject6 + " from " + ((TableModel)localObject4).getTableName() + " where " + ((AdvancedProperty)((FKModel)localObject3).getKeys().get(0)).getKey() + " like '?%'";
            localHashMap.put(((AdvancedProperty)((FKModel)localObject3).getKeys().get(0)).getKey(), localObject7);
          }
        }
        localDBModel.addChildElement((IElement)localObject1);
        localDBModel.updateTableModel((TableModel)localObject1);
        localObject2 = (Rule)localRuleSet1.createChildNode("Rule");
        ((Rule)localObject2).setSupportInit(true);
        ((Rule)localObject2).getRuleElementToken().getThenActions();
        localObject3 = ((TableModel)localObject1).getTableFunction("select");
        if (localObject3 != null)
        {
          localObject4 = new TableFunctionToken();
          localObject6 = new StatementContainerToken();
          ((Rule)localObject2).getRuleElementToken().getInitActions().addChildElement((IElement)localObject6);
          ((StatementContainerToken)localObject6).addChildElement((IElement)localObject4);
          ((TableFunctionToken)localObject4).setMemberElement((IElement)localObject3);
        }
        localObject3 = ((TableModel)localObject1).getTableFunction("next");
        if (localObject3 != null)
        {
          localObject4 = new ConditionToken();
          ((ConditionToken)localObject4).init();
          ((Rule)localObject2).getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject4);
          localObject6 = (MemberToken)((ConditionToken)localObject4).getFirstValue();
          ((MemberToken)localObject6).setMemberElement((IElement)localObject3);
          ((ConditionToken)localObject4).addChildElement(new BooleanJudgeToken());
        }
        for (int i1 = 0; i1 < this.i.size(); i1++)
        {
          localObject6 = (FieldModel)this.i.get(i1);
          localObject3 = ((TableModel)localObject1).getFieldSetFunc((FieldModel)localObject6);
          if (localObject3 == null)
            continue;
          localObject7 = new TableFunctionToken();
          localObject8 = new StatementContainerToken();
          ((Rule)localObject2).getRuleElementToken().getInitActions().addChildElement((IElement)localObject8, 0);
          ((StatementContainerToken)localObject8).addChildElement((IElement)localObject7);
          ((TableFunctionToken)localObject7).setMemberElement((IElement)localObject3);
          localObject9 = (ValueToken)((TableFunctionToken)localObject7).getValueTokens().get(0);
          localObject10 = new MemberToken(((ValueToken)localObject9).getValueType());
          ((ValueToken)localObject9).addChildElement((IElement)localObject10);
          ((MemberToken)localObject10).setMemberElement(localSubVariable);
          localObject9 = (ValueToken)((MemberToken)localObject10).getValueTokens().get(0);
          localObject11 = new ConstantToken("string");
          ((ValueToken)localObject9).addChildElement((IElement)localObject11);
          ((ConstantToken)localObject11).setValue("_");
          localObject9 = (ValueToken)((MemberToken)localObject10).getValueTokens().get(1);
          localObject11 = new ConstantToken("int");
          ((ValueToken)localObject9).addChildElement((IElement)localObject11);
          ((ConstantToken)localObject11).setValue(String.valueOf(i1));
        }
        for (i1 = 0; i1 < ((TableModel)localObject1).getFields().size(); i1++)
        {
          localObject6 = (FieldModel)((TableModel)localObject1).getFields().get(i1);
          localObject7 = localRulePackage.getEnvionment().getValueLibrary().getVariable(((FieldModel)localObject6).getFieldName());
          if (localObject7 == null)
          {
            localObject7 = new MappingVariable((FieldModel)localObject6);
            ((MappingVariable)localObject7).setVisible(true);
            if (((MappingVariable)localObject7).getValueType().equalsIgnoreCase("datetime"))
              ((MappingVariable)localObject7).setValueType("date");
            localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject7);
          }
          if ((((FieldModel)localObject6).isAutoIncrement()) || (((FieldModel)localObject6).isReadOnly()))
            continue;
          localObject3 = ((TableModel)localObject1).getFieldSetFunc((FieldModel)localObject6);
          if (localObject3 == null)
            continue;
          localObject8 = new TableFunctionToken();
          localObject9 = new StatementContainerToken();
          ((Rule)localObject2).getRuleElementToken().getThenActions().addChildElement((IElement)localObject9, 0);
          ((StatementContainerToken)localObject9).addChildElement((IElement)localObject8);
          ((TableFunctionToken)localObject8).setMemberElement((IElement)localObject3);
          localObject10 = (ValueToken)((TableFunctionToken)localObject8).getValueTokens().get(0);
          localObject11 = new MemberToken(((ValueToken)localObject10).getValueType());
          ((ValueToken)localObject10).addChildElement((IElement)localObject11);
          if (localObject7 != null)
            ((MemberToken)localObject11).setMemberElement((IElement)localObject7);
          ((Rule)localObject2).setModified(true);
        }
        localObject3 = ((TableModel)localObject1).getTableFunction("update");
        if (localObject3 != null)
        {
          localObject5 = new TableFunctionToken();
          localObject6 = new StatementContainerToken();
          ((Rule)localObject2).getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
          ((StatementContainerToken)localObject6).addChildElement((IElement)localObject5);
          ((TableFunctionToken)localObject5).setMemberElement((IElement)localObject3);
        }
        localObject5 = new StatementContainerToken();
        ((Rule)localObject2).getRuleElementToken().getThenActions().addChildElement((IElement)localObject5);
        Object localObject6 = new AssignToken();
        ((StatementContainerToken)localObject5).addChildElement((IElement)localObject6);
        Object localObject7 = new FieldToken();
        ((AssignToken)localObject6).addChildElement((IElement)localObject7);
        ((AssignToken)localObject6).addChildElement(new AssignJudgeToken());
        ((FieldToken)localObject7).setMemberElement(localMappingVariable2);
        Object localObject8 = new ConstantToken(localMappingVariable2.getValueType());
        ((AssignToken)localObject6).getComparedValue().addChildElement((IElement)localObject8);
        ((ConstantToken)localObject8).setValue("success!");
        ((Rule)localObject2).setModified(true);
        localObject2 = (Rule)localRuleSet2.createChildNode("Rule");
        ((Rule)localObject2).setSupportInit(true);
        ((Rule)localObject2).getRuleElementToken().getThenActions();
        localObject3 = ((TableModel)localObject1).getTableFunction("select");
        if (localObject3 != null)
        {
          localObject9 = new TableFunctionToken();
          localObject5 = new StatementContainerToken();
          ((Rule)localObject2).getRuleElementToken().getInitActions().addChildElement((IElement)localObject5);
          ((StatementContainerToken)localObject5).addChildElement((IElement)localObject9);
          ((TableFunctionToken)localObject9).setMemberElement((IElement)localObject3);
        }
        localObject3 = ((TableModel)localObject1).getTableFunction("next");
        if (localObject3 != null)
        {
          localObject9 = new ConditionToken();
          ((ConditionToken)localObject9).init();
          ((Rule)localObject2).getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject9);
          localObject10 = (MemberToken)((ConditionToken)localObject9).getFirstValue();
          ((MemberToken)localObject10).setMemberElement((IElement)localObject3);
          ((ConditionToken)localObject9).addChildElement(new BooleanJudgeToken());
        }
        for (int i4 = 0; i4 < this.i.size(); i4++)
        {
          localObject10 = (FieldModel)this.i.get(i4);
          localObject3 = ((TableModel)localObject1).getFieldSetFunc((FieldModel)localObject10);
          if (localObject3 == null)
            continue;
          localObject11 = new TableFunctionToken();
          localObject5 = new StatementContainerToken();
          ((Rule)localObject2).getRuleElementToken().getInitActions().addChildElement((IElement)localObject5, 0);
          ((StatementContainerToken)localObject5).addChildElement((IElement)localObject11);
          ((TableFunctionToken)localObject11).setMemberElement((IElement)localObject3);
          localObject12 = (ValueToken)((TableFunctionToken)localObject11).getValueTokens().get(0);
          localObject13 = new MemberToken(((ValueToken)localObject12).getValueType());
          ((ValueToken)localObject12).addChildElement((IElement)localObject13);
          ((MemberToken)localObject13).setMemberElement(localSubVariable);
          localObject12 = (ValueToken)((MemberToken)localObject13).getValueTokens().get(0);
          localObject14 = new ConstantToken("string");
          ((ValueToken)localObject12).addChildElement((IElement)localObject14);
          ((ConstantToken)localObject14).setValue("_");
          localObject12 = (ValueToken)((MemberToken)localObject13).getValueTokens().get(1);
          localObject14 = new ConstantToken("int");
          ((ValueToken)localObject12).addChildElement((IElement)localObject14);
          ((ConstantToken)localObject14).setValue(String.valueOf(i4));
        }
        for (i4 = 0; i4 < ((TableModel)localObject1).getFields().size(); i4++)
        {
          localObject10 = (FieldModel)((TableModel)localObject1).getFields().get(i4);
          localObject11 = localRulePackage.getEnvionment().getValueLibrary().getVariable(((FieldModel)localObject10).getFieldName());
          if (localObject11 == null)
          {
            localObject11 = new MappingVariable((FieldModel)localObject10);
            ((MappingVariable)localObject11).setVisible(true);
            if (((MappingVariable)localObject11).getValueType().equalsIgnoreCase("datetime"))
              ((MappingVariable)localObject11).setValueType("date");
            localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject11);
          }
          localObject3 = ((TableModel)localObject1).getFieldGetFunc((FieldModel)localObject10);
          if (localObject3 == null)
            continue;
          localObject5 = new StatementContainerToken();
          ((Rule)localObject2).getRuleElementToken().getThenActions().addChildElement((IElement)localObject5, 0);
          localObject6 = new AssignToken();
          ((StatementContainerToken)localObject5).addChildElement((IElement)localObject6);
          localObject7 = new FieldToken();
          ((AssignToken)localObject6).addChildElement((IElement)localObject7);
          ((AssignToken)localObject6).addChildElement(new AssignJudgeToken());
          if (localObject11 != null)
            ((FieldToken)localObject7).setMemberElement((IElement)localObject11);
          else
            ((AssignToken)localObject6).changeFieldType(((TableFunction)localObject3).getJavaType());
          localObject12 = new TableFunctionToken(((TableFunction)localObject3).getValueType());
          ((AssignToken)localObject6).getComparedValue().addChildElement((IElement)localObject12);
          ((TableFunctionToken)localObject12).setMemberElement((IElement)localObject3);
        }
      }
      ExportModel localExportModel;
      if (localRulePackage.getExportModels().hasNext())
      {
        localExportModel = (ExportModel)localRulePackage.getExportModels().next();
        localExportModel.setDisplayName(localRulePackage.getExeRulePackageName().replace('.', '/') + ".jsp");
      }
      else
      {
        localExportModel = (ExportModel)localRulePackage.createChildNode("ExportModel");
        localExportModel.setDisplayName(localRulePackage.getExeRulePackageName().replace('.', '/') + ".jsp");
        localExportModel.setImportFile("standard/page_input.rsp");
        localObject1 = new String[0];
        if (localExportModel.getImportFile().length() > 0)
          localObject1 = localExportModel.getPreferences().getStringArray(localExportModel.getImportFile() + ".props");
        if (localObject1 == null)
          localObject1 = localExportModel.getPreferences().getStringArray("export.props");
        for (m = 0; m < localObject1.length; m++)
        {
          localObject2 = localExportModel.getPreferences().getString(localObject1[m] + ".default", "");
          if (((String)localObject2).length() <= 0)
            continue;
          localExportModel.setPropertyValue(localObject1[m], (String)localObject2);
        }
        localExportModel.setPropertyValue("submit", "reset");
        localExportModel.setPropertyValue("success", "successtopage");
        localExportModel.setPropertyValue("successpage", "list.jsp");
      }
      Object localObject1 = localExportModel.getEnvionment().getAllMappingVariable();
      int m = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MappingVariable)((Iterator)localObject1).next();
        if (localExportModel.getPageField(((MappingVariable)localObject2).getVariableName()) != null)
          continue;
        localObject3 = localExportModel.addMappingVariable((MappingVariable)localObject2);
        if (localHashMap.get(((MappingVariable)localObject2).getValueName()) != null)
        {
          if ((localHashMap.get(((MappingVariable)localObject2).getValueName()) instanceof SelectTable))
          {
            ((PageFieldModel)localObject3).setInputType("select");
            ((PageFieldModel)localObject3).setPropertyValue("p_options", "list" + ((SelectTable)localHashMap.get(((MappingVariable)localObject2).getValueName())).getValueName());
          }
          else
          {
            ((PageFieldModel)localObject3).setInputType("textauto");
            ((PageFieldModel)localObject3).setPropertyValue("sql", (String)localHashMap.get(((MappingVariable)localObject2).getValueName()));
            ((PageFieldModel)localObject3).setPropertyValue("connection", this.a.getDatasourceName());
          }
        }
        else if (((MappingVariable)localObject2).getValueName().equalsIgnoreCase("su"))
        {
          ((PageFieldModel)localObject3).setStatType("success");
          ((PageFieldModel)localObject3).setInputType("notdisplay");
          ((PageFieldModel)localObject3).setResultType("notdisplay");
        }
        else if (((MappingVariable)localObject2).getValueName().equalsIgnoreCase("buttontijiao"))
        {
          ((PageFieldModel)localObject3).setStatType("input");
          ((PageFieldModel)localObject3).setInputType("button");
        }
        else if (((MappingVariable)localObject2).getValueName().equalsIgnoreCase("nID"))
        {
          ((PageFieldModel)localObject3).setInputType("hidden");
        }
        else if (((MappingVariable)localObject2).getValueType().equalsIgnoreCase("list<list>"))
        {
          ((PageFieldModel)localObject3).setStatType("output");
          ((PageFieldModel)localObject3).setResultType("notdisplay");
        }
        localObject5 = a(((MappingVariable)localObject2).getValueName());
        if (localObject5 != null)
        {
          if (((FieldModel)localObject5).isUnNull())
            ((PageFieldModel)localObject3).setNullType("notnull");
          if (!StringUtil.isEmpty(((FieldModel)localObject5).getDefaultValue()))
            ((PageFieldModel)localObject3).setPropertyValue("default", ((FieldModel)localObject5).getDefaultValue());
          if ((((FieldModel)localObject5).isReadOnly()) || (((FieldModel)localObject5).isAutoIncrement()))
            ((PageFieldModel)localObject3).setNullType("readonly");
          if (((FieldModel)localObject5).getAdvanceProperties().length > 0)
          {
            ((PageFieldModel)localObject3).setInputType("select");
            for (int i2 = 0; i2 < ((FieldModel)localObject5).getAdvanceProperties().length; i2++)
              ((PageFieldModel)localObject3).setPropertyValue("o_" + localObject5.getAdvanceProperties()[i2].getKey(), localObject5.getAdvanceProperties()[i2].getProperty());
          }
        }
        a((PageFieldModel)localObject3, ((PageFieldModel)localObject3).getInputType());
        a((PageFieldModel)localObject3, ((PageFieldModel)localObject3).getResultType());
      }
      localExportModel.setModified(true);
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }

  public void g()
  {
    if (c.class.getClassLoader().getResource(this.c + "/add.rpk") == null)
      return;
    RulePackage localRulePackage;
    try
    {
      localRulePackage = (RulePackage)((RulePackage)new d().load(c.class.getClassLoader().getResourceAsStream(this.c + "/add.rpk"))).deepClone();
    }
    catch (Exception localException1)
    {
      return;
    }
    localRulePackage.setDisplayName(localRulePackage.getDisplayName() + this.d);
    localRulePackage.setExeRulePackageName(this.e + ".add");
    this.b.addChildElement(localRulePackage);
    localRulePackage.setFilePathName("");
    DBModel localDBModel = new DBModel();
    localDBModel.setDriver(this.a.getDriver());
    localDBModel.setUrl(this.a.getUrl());
    localDBModel.setUserName(this.a.getUserName());
    localDBModel.setPasswd(this.a.getPasswd());
    localDBModel.setDatasourceName(this.a.getDisplayName());
    localDBModel.setDisplayName(this.a.getDisplayName());
    localDBModel.setSchemaName(this.a.getSchemaName());
    localDBModel.setCatalogName(this.a.getCatalogName());
    localRulePackage.getEnvionment().addChildElement(localDBModel);
    MappingVariable localMappingVariable1 = localRulePackage.getEnvionment().getValueLibrary().getVariable("buttontijiao");
    MappingVariable localMappingVariable2 = localRulePackage.getEnvionment().getValueLibrary().getVariable("su");
    RuleSet localRuleSet = (RuleSet)localRulePackage.createChildNode("RuleSet");
    ConditionToken localConditionToken = new ConditionToken();
    localConditionToken.init();
    localRuleSet.getRuleSetToken().getTestConditions().addChildElement(localConditionToken);
    MemberToken localMemberToken = (MemberToken)localConditionToken.getFirstValue();
    localMemberToken.setMemberElement(localMappingVariable1);
    ((StringJudgeToken)localConditionToken.getCompareOperator()).setType(8);
    try
    {
      HashMap localHashMap = new HashMap();
      Object localObject3;
      Object localObject2;
      Object localObject4;
      for (int k = 0; k < this.h.size(); k++)
      {
        localObject1 = (TableModel)this.h.get(k);
        List localList = this.a.getFKModels(((TableModel)localObject1).getTableName());
        Object localObject8;
        Object localObject9;
        Object localObject10;
        Object localObject11;
        for (int n = 0; n < localList.size(); n++)
        {
          localObject3 = (FKModel)localList.get(n);
          ((TableModel)localObject1).addChildElement((IElement)localObject3);
          if ((((FKModel)localObject3).getKeys().size() != 1) || (!((FKModel)localObject3).getFKTableName().equalsIgnoreCase(((TableModel)localObject1).getTableName())) || (a(this.h, ((FKModel)localObject3).getPkTableName())))
            continue;
          TableModel localTableModel = this.a.getTableModel(((FKModel)localObject3).getPkTableName());
          if (localTableModel == null)
            continue;
          localObject5 = ((AdvancedProperty)((FKModel)localObject3).getKeys().get(0)).getKey();
          for (int i3 = 0; i3 < localTableModel.getFields().size(); i3++)
          {
            if ((!((FieldModel)localTableModel.getFields().get(i3)).getFieldName().equalsIgnoreCase((String)localObject5)) || (i3 + 1 >= localTableModel.getFields().size()))
              continue;
            localObject5 = ((FieldModel)localTableModel.getFields().get(i3 + 1)).getFieldName();
            break;
          }
          if ((localTableModel.getField(((AdvancedProperty)((FKModel)localObject3).getKeys().get(0)).getKey()) != null) && (!localTableModel.getField(((AdvancedProperty)((FKModel)localObject3).getKeys().get(0)).getKey()).getValueType().equalsIgnoreCase("string")))
          {
            localObject6 = localDBModel.createSelectTable("select " + ((AdvancedProperty)((FKModel)localObject3).getKeys().get(0)).getKey() + "," + (String)localObject5 + " from " + localTableModel.getTableName(), ((FKModel)localObject3).getFKName(), ((FKModel)localObject3).getFKName());
            localObject7 = new MappingVariable("list" + ((FKModel)localObject3).getFKName(), ((FKModel)localObject3).getFKName(), "list<list>", true);
            localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject7);
            localObject8 = (Rule)localRulePackage.createChildNode("Rule");
            localObject9 = ((SelectTable)localObject6).getTableFunction("selectWhere");
            if (localObject9 != null)
            {
              localObject10 = new TableFunctionToken();
              localObject11 = new StatementContainerToken();
              ((Rule)localObject8).getRuleElementToken().getInitActions().addChildElement((IElement)localObject11);
              ((StatementContainerToken)localObject11).addChildElement((IElement)localObject10);
              ((TableFunctionToken)localObject10).setMemberElement((IElement)localObject9);
            }
            localObject9 = ((SelectTable)localObject6).getTableFunction("getListResult");
            if (localObject9 != null)
            {
              localObject10 = new StatementContainerToken();
              ((Rule)localObject8).getRuleElementToken().getThenActions().addChildElement((IElement)localObject10);
              localObject11 = new AssignToken();
              ((StatementContainerToken)localObject10).addChildElement((IElement)localObject11);
              FieldToken localFieldToken = new FieldToken();
              ((AssignToken)localObject11).addChildElement(localFieldToken);
              ((AssignToken)localObject11).addChildElement(new AssignJudgeToken());
              if (localObject7 != null)
                localFieldToken.setMemberElement((IElement)localObject7);
              else
                ((AssignToken)localObject11).changeFieldType(((TableFunction)localObject9).getJavaType());
              TableFunctionToken localTableFunctionToken = new TableFunctionToken(((TableFunction)localObject9).getValueType());
              ((AssignToken)localObject11).getComparedValue().addChildElement(localTableFunctionToken);
              localTableFunctionToken.setMemberElement((IElement)localObject9);
            }
            ((Rule)localObject8).setModified(true);
            localHashMap.put(((AdvancedProperty)((FKModel)localObject3).getKeys().get(0)).getKey(), localObject6);
          }
          else
          {
            localObject6 = "select " + ((AdvancedProperty)((FKModel)localObject3).getKeys().get(0)).getKey() + "," + (String)localObject5 + " from " + localTableModel.getTableName() + " where " + ((AdvancedProperty)((FKModel)localObject3).getKeys().get(0)).getKey() + " like '?%'";
            localHashMap.put(((AdvancedProperty)((FKModel)localObject3).getKeys().get(0)).getKey(), localObject6);
          }
        }
        localDBModel.addChildElement((IElement)localObject1);
        localDBModel.updateTableModel((TableModel)localObject1);
        localObject2 = (Rule)localRuleSet.createChildNode("Rule");
        localObject3 = null;
        for (int i1 = 0; i1 < ((TableModel)localObject1).getFields().size(); i1++)
        {
          localObject5 = (FieldModel)((TableModel)localObject1).getFields().get(i1);
          localObject6 = localRulePackage.getEnvionment().getValueLibrary().getVariable(((FieldModel)localObject5).getFieldName());
          if (localObject6 == null)
          {
            localObject6 = new MappingVariable((FieldModel)localObject5);
            ((MappingVariable)localObject6).setVisible(false);
            if (((MappingVariable)localObject6).getValueType().equalsIgnoreCase("datetime"))
              ((MappingVariable)localObject6).setValueType("date");
            localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject6);
          }
          if ((!((FieldModel)localObject5).isAutoIncrement()) && (!((FieldModel)localObject5).isReadOnly()))
          {
            ((MappingVariable)localObject6).setVisible(true);
            localObject7 = ((TableModel)localObject1).getFieldSetFunc((FieldModel)localObject5);
            if (localObject7 == null)
              continue;
            localObject8 = new TableFunctionToken();
            localObject9 = new StatementContainerToken();
            ((Rule)localObject2).getRuleElementToken().getThenActions().addChildElement((IElement)localObject9, 0);
            ((StatementContainerToken)localObject9).addChildElement((IElement)localObject8);
            ((TableFunctionToken)localObject8).setMemberElement((IElement)localObject7);
            localObject10 = (ValueToken)((TableFunctionToken)localObject8).getValueTokens().get(0);
            localObject11 = new MemberToken(((ValueToken)localObject10).getValueType());
            ((ValueToken)localObject10).addChildElement((IElement)localObject11);
            if (localObject6 != null)
              ((MemberToken)localObject11).setMemberElement((IElement)localObject6);
            ((Rule)localObject2).setModified(true);
          }
          else
          {
            if (!((FieldModel)localObject5).isAutoIncrement())
              continue;
            localObject3 = localObject5;
          }
        }
        if (localObject3 == null)
        {
          localObject4 = ((TableModel)localObject1).getTableFunction("insert");
          if (localObject4 != null)
          {
            localObject5 = new TableFunctionToken();
            localObject6 = new StatementContainerToken();
            ((Rule)localObject2).getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
            ((StatementContainerToken)localObject6).addChildElement((IElement)localObject5);
            ((TableFunctionToken)localObject5).setMemberElement((IElement)localObject4);
          }
        }
        else
        {
          localObject4 = ((TableModel)localObject1).getTableFunction("insertAndGeneratedKey");
          if (localObject4 != null)
          {
            localObject5 = new TableFunctionToken();
            localObject6 = new StatementContainerToken();
            ((Rule)localObject2).getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
            ((StatementContainerToken)localObject6).addChildElement((IElement)localObject5);
            ((TableFunctionToken)localObject5).setMemberElement((IElement)localObject4);
          }
          localObject5 = new StatementContainerToken();
          ((Rule)localObject2).getRuleElementToken().getThenActions().addChildElement((IElement)localObject5);
          localObject6 = new AssignToken();
          ((StatementContainerToken)localObject5).addChildElement((IElement)localObject6);
          localObject7 = new FieldToken();
          ((AssignToken)localObject6).addChildElement((IElement)localObject7);
          ((AssignToken)localObject6).addChildElement(new AssignJudgeToken());
          if (localRulePackage.getEnvionment().getValueLibrary().getVariable(((FieldModel)localObject3).getFieldName()) != null)
            ((FieldToken)localObject7).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable(((FieldModel)localObject3).getFieldName()));
          else
            ((AssignToken)localObject6).changeFieldType(((TableFunction)localObject4).getJavaType());
          localObject8 = new TableFunctionToken(((TableFunction)localObject4).getValueType());
          ((AssignToken)localObject6).getComparedValue().addChildElement((IElement)localObject8);
          ((TableFunctionToken)localObject8).setMemberElement(((TableModel)localObject1).getFieldGetFunc((FieldModel)localObject3));
        }
        localObject4 = new StatementContainerToken();
        ((Rule)localObject2).getRuleElementToken().getThenActions().addChildElement((IElement)localObject4);
        Object localObject5 = new AssignToken();
        ((StatementContainerToken)localObject4).addChildElement((IElement)localObject5);
        Object localObject6 = new FieldToken();
        ((AssignToken)localObject5).addChildElement((IElement)localObject6);
        ((AssignToken)localObject5).addChildElement(new AssignJudgeToken());
        ((FieldToken)localObject6).setMemberElement(localMappingVariable2);
        Object localObject7 = new ConstantToken(localMappingVariable2.getValueType());
        ((AssignToken)localObject5).getComparedValue().addChildElement((IElement)localObject7);
        ((ConstantToken)localObject7).setValue("success!");
        ((Rule)localObject2).setModified(true);
      }
      ExportModel localExportModel;
      if (localRulePackage.getExportModels().hasNext())
      {
        localExportModel = (ExportModel)localRulePackage.getExportModels().next();
        localExportModel.setDisplayName(localRulePackage.getExeRulePackageName().replace('.', '/') + ".jsp");
      }
      else
      {
        localExportModel = (ExportModel)localRulePackage.createChildNode("ExportModel");
        localExportModel.setDisplayName(localRulePackage.getExeRulePackageName().replace('.', '/') + ".jsp");
        localExportModel.setImportFile("standard/page_input.rsp");
        localObject1 = new String[0];
        if (localExportModel.getImportFile().length() > 0)
          localObject1 = localExportModel.getPreferences().getStringArray(localExportModel.getImportFile() + ".props");
        if (localObject1 == null)
          localObject1 = localExportModel.getPreferences().getStringArray("export.props");
        for (m = 0; m < localObject1.length; m++)
        {
          localObject2 = localExportModel.getPreferences().getString(localObject1[m] + ".default", "");
          if (((String)localObject2).length() <= 0)
            continue;
          localExportModel.setPropertyValue(localObject1[m], (String)localObject2);
        }
        localExportModel.setPropertyValue("submit", "reset");
        localExportModel.setPropertyValue("success", "successtopage");
        localExportModel.setPropertyValue("successpage", "list.jsp");
      }
      Object localObject1 = localExportModel.getEnvionment().getAllMappingVariable();
      int m = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MappingVariable)((Iterator)localObject1).next();
        if (localExportModel.getPageField(((MappingVariable)localObject2).getVariableName()) != null)
          continue;
        localObject3 = localExportModel.addMappingVariable((MappingVariable)localObject2);
        if (localHashMap.get(((MappingVariable)localObject2).getValueName()) != null)
        {
          if ((localHashMap.get(((MappingVariable)localObject2).getValueName()) instanceof SelectTable))
          {
            ((PageFieldModel)localObject3).setInputType("select");
            ((PageFieldModel)localObject3).setPropertyValue("p_options", "list" + ((SelectTable)localHashMap.get(((MappingVariable)localObject2).getValueName())).getValueName());
          }
          else
          {
            ((PageFieldModel)localObject3).setInputType("textauto");
            ((PageFieldModel)localObject3).setPropertyValue("sql", (String)localHashMap.get(((MappingVariable)localObject2).getValueName()));
            ((PageFieldModel)localObject3).setPropertyValue("connection", this.a.getDatasourceName());
          }
        }
        else if (((MappingVariable)localObject2).getValueName().equalsIgnoreCase("su"))
        {
          ((PageFieldModel)localObject3).setStatType("success");
          ((PageFieldModel)localObject3).setInputType("notdisplay");
          ((PageFieldModel)localObject3).setResultType("notdisplay");
        }
        else if (((MappingVariable)localObject2).getValueName().equalsIgnoreCase("buttontijiao"))
        {
          ((PageFieldModel)localObject3).setStatType("input");
          ((PageFieldModel)localObject3).setInputType("button");
        }
        else if (((MappingVariable)localObject2).getValueType().equalsIgnoreCase("list<list>"))
        {
          ((PageFieldModel)localObject3).setStatType("output");
          ((PageFieldModel)localObject3).setResultType("notdisplay");
        }
        localObject4 = a(((MappingVariable)localObject2).getValueName());
        if (localObject4 != null)
        {
          if (((FieldModel)localObject4).isUnNull())
            ((PageFieldModel)localObject3).setNullType("notnull");
          if (!StringUtil.isEmpty(((FieldModel)localObject4).getDefaultValue()))
            ((PageFieldModel)localObject3).setPropertyValue("default", ((FieldModel)localObject4).getDefaultValue());
          if (((FieldModel)localObject4).getAdvanceProperties().length > 0)
          {
            ((PageFieldModel)localObject3).setInputType("select");
            for (int i2 = 0; i2 < ((FieldModel)localObject4).getAdvanceProperties().length; i2++)
              ((PageFieldModel)localObject3).setPropertyValue("o_" + localObject4.getAdvanceProperties()[i2].getKey(), localObject4.getAdvanceProperties()[i2].getProperty());
          }
        }
        a((PageFieldModel)localObject3, ((PageFieldModel)localObject3).getInputType());
        a((PageFieldModel)localObject3, ((PageFieldModel)localObject3).getResultType());
      }
      localExportModel.setModified(true);
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.g.c
 * JD-Core Version:    0.6.0
 */