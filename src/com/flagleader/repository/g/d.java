package com.flagleader.repository.g;

import com.flagleader.export.PagesMessages;
import com.flagleader.repository.IElement;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.FKModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.db.a.a;
import com.flagleader.repository.db.a.e;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.export.PageFieldModel;
import com.flagleader.repository.rlm.RuleSetToken;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.action.AssignJudgeToken;
import com.flagleader.repository.rlm.action.AssignToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.action.TableFunctionToken;
import com.flagleader.repository.rlm.condition.BooleanJudgeToken;
import com.flagleader.repository.rlm.condition.ConditionToken;
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
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.rom.SubTypeMethod;
import com.flagleader.repository.rom.SubVariable;
import com.flagleader.repository.rom.TempVariable;
import com.flagleader.repository.tree.AdvancedProperty;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExportModel;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import com.flagleader.servlet.CustomMessages;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class d
{
  private TableModel a;
  private TableModel b;
  private DBModel c;
  private IRuleGroup d;
  private String e;
  private List f;
  private String g;
  private String h;
  private String i;
  private String j;

  public d(IRuleGroup paramIRuleGroup, DBModel paramDBModel, List paramList, String paramString1, String paramString2)
  {
    this.d = paramIRuleGroup;
    this.c = paramDBModel;
    this.e = paramString1;
    a(paramList);
    if (this.a != null)
    {
      this.g = this.a.getDisplayName();
      this.j = this.a.getTableName();
      if ((paramString2 != null) && (paramString2.length() > 0))
        this.h = paramString2;
      else
        this.h = this.j;
    }
    else
    {
      this.g = b(paramList);
      this.j = c(paramList);
      if ((paramString2 != null) && (paramString2.length() > 0))
        this.h = paramString2;
      else
        this.h = this.j;
    }
  }

  private void a(List paramList)
  {
    List localList1 = null;
    for (int k = 0; k < paramList.size(); k++)
    {
      TableModel localTableModel = (TableModel)paramList.get(k);
      localList1 = localTableModel.getPrimaryKeys();
      if (a(localList1, paramList))
        this.a = localTableModel;
      else
        this.b = localTableModel;
    }
    FKModel localFKModel;
    if ((this.a == null) && (paramList.size() > 1))
    {
      List localList2 = this.c.getFKModels(this.b.getTableName());
      for (int n = 0; n < localList2.size(); n++)
      {
        localFKModel = (FKModel)localList2.get(n);
        if ((localFKModel.getPkTableName().equalsIgnoreCase(((TableModel)paramList.get(0)).getTableName())) && (localFKModel.getFKTableName().equalsIgnoreCase(((TableModel)paramList.get(1)).getTableName())))
        {
          this.a = ((TableModel)paramList.get(0));
          this.b = ((TableModel)paramList.get(1));
          break;
        }
        if ((!localFKModel.getPkTableName().equalsIgnoreCase(((TableModel)paramList.get(1)).getTableName())) || (!localFKModel.getFKTableName().equalsIgnoreCase(((TableModel)paramList.get(0)).getTableName())))
          continue;
        this.a = ((TableModel)paramList.get(1));
        this.b = ((TableModel)paramList.get(0));
        break;
      }
    }
    if (this.a == null)
    {
      this.a = ((TableModel)paramList.get(0));
      if (paramList.size() > 1)
        this.b = ((TableModel)paramList.get(1));
    }
    if (this.a != null)
      for (int m = 0; m < this.a.getFields().size(); m++)
      {
        FieldModel localFieldModel = (FieldModel)this.a.getFields().get(m);
        if (!localFieldModel.isFriendKey())
          continue;
        localFKModel = this.c.getFKModel(this.a.getTableName(), localFieldModel.getFieldName());
        if (!localFKModel.getPkTableName().equalsIgnoreCase(this.a.getTableName()))
          continue;
        this.i = localFieldModel.getFieldName();
      }
    List localList3 = this.c.getFKModels(this.b.getTableName());
    for (int i1 = 0; i1 < localList3.size(); i1++)
    {
      localFKModel = (FKModel)localList3.get(i1);
      if (!localFKModel.getPkTableName().equalsIgnoreCase(this.a.getTableName()))
        continue;
      ArrayList localArrayList = localFKModel.getKeys();
      this.f = new ArrayList();
      for (int i2 = 0; i2 < localArrayList.size(); i2++)
      {
        AdvancedProperty localAdvancedProperty = (AdvancedProperty)localArrayList.get(i2);
        this.f.add(this.b.getField(localAdvancedProperty.getProperty()));
      }
    }
    if (this.f == null)
      this.f = this.a.getPrimaryKeys();
  }

  private String b(List paramList)
  {
    String str = "";
    for (int k = 0; k < paramList.size(); k++)
    {
      if (!(paramList.get(k) instanceof TableModel))
        continue;
      str = str + ((TableModel)paramList.get(k)).getDisplayName();
    }
    return str;
  }

  private String c(List paramList)
  {
    String str = "";
    for (int k = 0; k < paramList.size(); k++)
    {
      if (!(paramList.get(k) instanceof TableModel))
        continue;
      str = str + ((TableModel)paramList.get(k)).getTableName().toLowerCase();
    }
    return str;
  }

  protected DBModel a(RulePackage paramRulePackage)
  {
    DBModel localDBModel = new DBModel();
    localDBModel.setDriver(this.c.getDriver());
    localDBModel.setUrl(this.c.getUrl());
    localDBModel.setUserName(this.c.getUserName());
    localDBModel.setPasswd(this.c.getPasswd());
    localDBModel.setDatasourceName(this.c.getDisplayName());
    localDBModel.setDisplayName(this.c.getDisplayName());
    localDBModel.setSchemaName(this.c.getSchemaName());
    localDBModel.setCatalogName(this.c.getCatalogName());
    paramRulePackage.getEnvionment().addChildElement(localDBModel);
    return localDBModel;
  }

  private String h()
  {
    String[] arrayOfString = this.a.getPrimaryNames();
    String str = arrayOfString[(arrayOfString.length - 1)];
    for (int k = 0; k < arrayOfString.length; k++)
    {
      if ((!arrayOfString[k].equalsIgnoreCase(str)) || (k + 1 >= this.a.getFields().size()))
        continue;
      str = ((FieldModel)this.a.getFields().get(k + 1)).getFieldName();
      break;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("select ");
    for (int m = 0; m < arrayOfString.length; m++)
    {
      localStringBuffer.append(arrayOfString[m]);
      localStringBuffer.append(",");
    }
    localStringBuffer.append(str);
    if (this.i != null)
      localStringBuffer.append(",").append(this.i);
    else
      localStringBuffer.append(",0");
    localStringBuffer.append(" from ");
    localStringBuffer.append(this.a.getTableName());
    return localStringBuffer.toString();
  }

  public void a()
  {
    if (this.a != null)
    {
      b();
      c();
    }
    if (this.b != null)
    {
      d();
      g();
      f();
      e();
    }
  }

  public void b()
  {
    if (this.a == null)
      return;
    if (d.class.getClassLoader().getResource(this.e + "/tree.rpk") == null)
      return;
    RulePackage localRulePackage;
    try
    {
      localRulePackage = (RulePackage)((RulePackage)new com.flagleader.repository.e.d().load(d.class.getClassLoader().getResourceAsStream(this.e + "/tree.rpk"))).deepClone();
    }
    catch (Exception localException1)
    {
      return;
    }
    localRulePackage.setDisplayName(localRulePackage.getDisplayName() + this.g);
    localRulePackage.setExeRulePackageName(this.h + ".tree");
    this.d.addChildElement(localRulePackage);
    localRulePackage.setFilePathName("");
    DBModel localDBModel = a(localRulePackage);
    try
    {
      MappingVariable localMappingVariable1 = localRulePackage.getEnvionment().getValueLibrary().getVariable("hidAct");
      MappingVariable localMappingVariable2 = localRulePackage.getEnvionment().getValueLibrary().getVariable("nID");
      SubVariable localSubVariable = (SubVariable)((SubTypeMethod)localMappingVariable2.getSubEditens().next()).getSubEditens().next();
      MappingVariable localMappingVariable3 = new MappingVariable("list" + this.j, this.g, "list<list>", true);
      localRulePackage.getEnvionment().getValueLibrary().addChildElement(localMappingVariable3);
      SelectTable localSelectTable = localDBModel.createSelectTable(h(), "select" + this.g, "select" + this.j);
      TableModel localTableModel = (TableModel)this.a.deepClone();
      List localList = this.c.getFKModels(localTableModel.getTableName());
      for (int k = 0; k < localList.size(); k++)
      {
        localObject1 = (FKModel)localList.get(k);
        localTableModel.addChildElement((IElement)localObject1);
      }
      localDBModel.addChildElement(localTableModel);
      localDBModel.updateTableModel(localTableModel);
      Rule localRule = null;
      Object localObject3;
      Object localObject6;
      if ((localRulePackage.getRuleAndSetCount() > 0) && (((RuleSet)localRulePackage.getRulesList().get(0)).getRuleAndSets().hasNext()))
      {
        localRule = (Rule)((RuleSet)localRulePackage.getRulesList().get(0)).getRuleAndSets().next();
      }
      else
      {
        localObject1 = (RuleSet)localRulePackage.createChildNode("RuleSet");
        ConditionToken localConditionToken = new ConditionToken();
        localConditionToken.init();
        ((RuleSet)localObject1).getRuleSetToken().getTestConditions().addChildElement(localConditionToken);
        localObject3 = (MemberToken)localConditionToken.getFirstValue();
        ((MemberToken)localObject3).setMemberElement(localMappingVariable1);
        localObject6 = new ConstantToken("string");
        localConditionToken.getComparedValue().addChildElement((IElement)localObject6);
        ((ConstantToken)localObject6).setValue("add");
        localRule = (Rule)((RuleSet)localObject1).createChildNode("Rule");
      }
      Object localObject1 = null;
      Object localObject7;
      Object localObject10;
      Object localObject12;
      for (int m = 0; m < localTableModel.getFields().size(); m++)
      {
        localObject3 = (FieldModel)localTableModel.getFields().get(m);
        localObject6 = null;
        if ((this.i != null) && (((FieldModel)localObject3).getFieldName().equalsIgnoreCase(this.i)))
        {
          localObject6 = null;
        }
        else
        {
          localObject6 = localRulePackage.getEnvionment().getValueLibrary().getVariable(((FieldModel)localObject3).getFieldName());
          if (localObject6 == null)
          {
            localObject6 = new MappingVariable((FieldModel)localObject3);
            ((MappingVariable)localObject6).setVisible(true);
            if (((MappingVariable)localObject6).getValueType().equalsIgnoreCase("datetime"))
              ((MappingVariable)localObject6).setValueType("date");
            localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject6);
          }
        }
        if ((!((FieldModel)localObject3).isAutoIncrement()) && (!((FieldModel)localObject3).isReadOnly()))
        {
          localObject7 = localTableModel.getFieldSetFunc((FieldModel)localObject3);
          if (localObject7 == null)
            continue;
          localObject9 = new TableFunctionToken();
          localObject10 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject10, 0);
          ((StatementContainerToken)localObject10).addChildElement((IElement)localObject9);
          ((TableFunctionToken)localObject9).setMemberElement((IElement)localObject7);
          localObject11 = (ValueToken)((TableFunctionToken)localObject9).getValueTokens().get(0);
          localObject12 = new MemberToken(((ValueToken)localObject11).getValueType());
          ((ValueToken)localObject11).addChildElement((IElement)localObject12);
          if ((this.i != null) && (((FieldModel)localObject3).getFieldName().equalsIgnoreCase(this.i)))
          {
            ((MemberToken)localObject12).setMemberElement(localMappingVariable2);
          }
          else
          {
            if (localObject6 == null)
              continue;
            ((MemberToken)localObject12).setMemberElement((IElement)localObject6);
          }
        }
        else
        {
          if (!((FieldModel)localObject3).isAutoIncrement())
            continue;
          localObject1 = localObject3;
        }
      }
      if (localObject1 == null)
      {
        localObject2 = localTableModel.getTableFunction("insert");
        if (localObject2 != null)
        {
          localObject3 = new TableFunctionToken();
          localObject6 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
          ((StatementContainerToken)localObject6).addChildElement((IElement)localObject3);
          ((TableFunctionToken)localObject3).setMemberElement((IElement)localObject2);
        }
      }
      else
      {
        localObject2 = localTableModel.getTableFunction("insertAndGeneratedKey");
        if (localObject2 != null)
        {
          localObject3 = new TableFunctionToken();
          localObject6 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
          ((StatementContainerToken)localObject6).addChildElement((IElement)localObject3);
          ((TableFunctionToken)localObject3).setMemberElement((IElement)localObject2);
        }
        localObject3 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject3);
        localObject6 = new AssignToken();
        ((StatementContainerToken)localObject3).addChildElement((IElement)localObject6);
        localObject7 = new FieldToken();
        ((AssignToken)localObject6).addChildElement((IElement)localObject7);
        ((AssignToken)localObject6).addChildElement(new AssignJudgeToken());
        if (localRulePackage.getEnvionment().getValueLibrary().getVariable(((FieldModel)localObject1).getFieldName()) != null)
          ((FieldToken)localObject7).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable(((FieldModel)localObject1).getFieldName()));
        else
          ((AssignToken)localObject6).changeFieldType(((TableFunction)localObject2).getJavaType());
        localObject9 = new TableFunctionToken(((TableFunction)localObject2).getValueType());
        ((AssignToken)localObject6).getComparedValue().addChildElement((IElement)localObject9);
        ((TableFunctionToken)localObject9).setMemberElement(localTableModel.getFieldGetFunc((FieldModel)localObject1));
      }
      localRule.setModified(true);
      localRule = null;
      if ((localRulePackage.getRuleAndSetCount() > 1) && (((RuleSet)localRulePackage.getRulesList().get(1)).getRuleAndSets().hasNext()))
      {
        localRule = (Rule)((RuleSet)localRulePackage.getRulesList().get(1)).getRuleAndSets().next();
      }
      else
      {
        localObject2 = (RuleSet)localRulePackage.createChildNode("RuleSet");
        localObject3 = new ConditionToken();
        ((ConditionToken)localObject3).init();
        ((RuleSet)localObject2).getRuleSetToken().getTestConditions().addChildElement((IElement)localObject3);
        localObject6 = (MemberToken)((ConditionToken)localObject3).getFirstValue();
        ((MemberToken)localObject6).setMemberElement(localMappingVariable1);
        localObject7 = new ConstantToken("string");
        ((ConditionToken)localObject3).getComparedValue().addChildElement((IElement)localObject7);
        ((ConstantToken)localObject7).setValue("mod");
        localRule = (Rule)((RuleSet)localObject2).createChildNode("Rule");
      }
      localRule.setSupportInit(true);
      localRule.getRuleElementToken().getThenActions();
      Object localObject2 = localTableModel.getTableFunction("select");
      if (localObject2 != null)
      {
        localObject3 = new TableFunctionToken();
        localObject6 = new StatementContainerToken();
        localRule.getRuleElementToken().getInitActions().addChildElement((IElement)localObject6);
        ((StatementContainerToken)localObject6).addChildElement((IElement)localObject3);
        ((TableFunctionToken)localObject3).setMemberElement((IElement)localObject2);
      }
      localObject2 = localTableModel.getTableFunction("next");
      if (localObject2 != null)
      {
        localObject3 = new ConditionToken();
        ((ConditionToken)localObject3).init();
        localRule.getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject3);
        localObject6 = (MemberToken)((ConditionToken)localObject3).getFirstValue();
        ((MemberToken)localObject6).setMemberElement((IElement)localObject2);
        ((ConditionToken)localObject3).addChildElement(new BooleanJudgeToken());
      }
      for (int n = 0; n < localTableModel.getPrimaryKeys().size(); n++)
      {
        localObject6 = (FieldModel)localTableModel.getPrimaryKeys().get(n);
        localObject2 = localTableModel.getFieldSetFunc((FieldModel)localObject6);
        if (localObject2 == null)
          continue;
        localObject7 = new TableFunctionToken();
        localObject9 = new StatementContainerToken();
        localRule.getRuleElementToken().getInitActions().addChildElement((IElement)localObject9, 0);
        ((StatementContainerToken)localObject9).addChildElement((IElement)localObject7);
        ((TableFunctionToken)localObject7).setMemberElement((IElement)localObject2);
        localObject10 = (ValueToken)((TableFunctionToken)localObject7).getValueTokens().get(0);
        localObject11 = new MemberToken(((ValueToken)localObject10).getValueType());
        ((ValueToken)localObject10).addChildElement((IElement)localObject11);
        ((MemberToken)localObject11).setMemberElement(localSubVariable);
        localObject10 = (ValueToken)((MemberToken)localObject11).getValueTokens().get(0);
        localObject12 = new ConstantToken("string");
        ((ValueToken)localObject10).addChildElement((IElement)localObject12);
        ((ConstantToken)localObject12).setValue("_");
        localObject10 = (ValueToken)((MemberToken)localObject11).getValueTokens().get(1);
        localObject12 = new ConstantToken("int");
        ((ValueToken)localObject10).addChildElement((IElement)localObject12);
        ((ConstantToken)localObject12).setValue(String.valueOf(n));
      }
      for (n = 0; n < localTableModel.getFields().size(); n++)
      {
        localObject6 = (FieldModel)localTableModel.getFields().get(n);
        localObject7 = null;
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
        localObject2 = localTableModel.getFieldSetFunc((FieldModel)localObject6);
        if (localObject2 == null)
          continue;
        localObject9 = new TableFunctionToken();
        localObject10 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject10, 0);
        ((StatementContainerToken)localObject10).addChildElement((IElement)localObject9);
        ((TableFunctionToken)localObject9).setMemberElement((IElement)localObject2);
        localObject11 = (ValueToken)((TableFunctionToken)localObject9).getValueTokens().get(0);
        localObject12 = new MemberToken(((ValueToken)localObject11).getValueType());
        ((ValueToken)localObject11).addChildElement((IElement)localObject12);
        if (localObject7 == null)
          continue;
        ((MemberToken)localObject12).setMemberElement((IElement)localObject7);
      }
      localObject2 = localTableModel.getTableFunction("update");
      Object localObject4;
      if (localObject2 != null)
      {
        localObject4 = new TableFunctionToken();
        localObject6 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
        ((StatementContainerToken)localObject6).addChildElement((IElement)localObject4);
        ((TableFunctionToken)localObject4).setMemberElement((IElement)localObject2);
      }
      localRule = null;
      if ((localRulePackage.getRuleAndSetCount() > 2) && (((RuleSet)localRulePackage.getRulesList().get(2)).getRuleAndSets().hasNext()))
      {
        localRule = (Rule)((RuleSet)localRulePackage.getRulesList().get(2)).getRuleAndSets().next();
      }
      else
      {
        localObject4 = (RuleSet)localRulePackage.createChildNode("RuleSet");
        localObject6 = new ConditionToken();
        ((ConditionToken)localObject6).init();
        ((RuleSet)localObject4).getRuleSetToken().getTestConditions().addChildElement((IElement)localObject6);
        localObject7 = (MemberToken)((ConditionToken)localObject6).getFirstValue();
        ((MemberToken)localObject7).setMemberElement(localMappingVariable1);
        localObject9 = new ConstantToken("string");
        ((ConditionToken)localObject6).getComparedValue().addChildElement((IElement)localObject9);
        ((ConstantToken)localObject9).setValue("mod");
        localRule = (Rule)((RuleSet)localObject4).createChildNode("Rule");
      }
      for (int i1 = 0; i1 < localTableModel.getPrimaryKeys().size(); i1++)
      {
        localObject2 = localTableModel.getFieldSetFunc((FieldModel)localTableModel.getPrimaryKeys().get(i1));
        if (localObject2 == null)
          continue;
        localObject6 = new TableFunctionToken();
        localObject7 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject7);
        ((StatementContainerToken)localObject7).addChildElement((IElement)localObject6);
        ((TableFunctionToken)localObject6).setMemberElement((IElement)localObject2);
        localObject9 = (ValueToken)((TableFunctionToken)localObject6).getValueTokens().get(0);
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
      localObject2 = localTableModel.getTableFunction("delete");
      Object localObject5;
      if (localObject2 != null)
      {
        localObject5 = new TableFunctionToken();
        localObject6 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
        ((StatementContainerToken)localObject6).addChildElement((IElement)localObject5);
        ((TableFunctionToken)localObject5).setMemberElement((IElement)localObject2);
      }
      localRule.setModified(true);
      localRule = (Rule)localRulePackage.createChildNode("Rule");
      localObject2 = localSelectTable.getTableFunction("selectWhere");
      if (localObject2 != null)
      {
        localObject5 = new TableFunctionToken();
        localObject6 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
        ((StatementContainerToken)localObject6).addChildElement((IElement)localObject5);
        ((TableFunctionToken)localObject5).setMemberElement((IElement)localObject2);
      }
      Object localObject8;
      Object localObject13;
      Object localObject14;
      if (localTableModel.getPrimaryNames().length > 1)
      {
        localObject6 = new SheetTable();
        ((SheetTable)localObject6).setDisplayName("sheet" + this.g);
        ((SheetTable)localObject6).setEnglishName("sheet" + this.j);
        ((SheetTable)localObject6).updateFunction();
        localDBModel.addChildElement((IElement)localObject6);
        ((SheetTable)localObject6).addChildElement(new SheetFieldModel("nID", "nID", "string", true));
        for (int i2 = 0; i2 < localSelectTable.getFields().size(); i2++)
          ((SheetTable)localObject6).addChildElement(new SheetFieldModel((FieldModel)localSelectTable.getFields().get(i2)));
        localObject5 = new SheetTable();
        ((SheetTable)localObject5).setDisplayName("sheet2" + this.g);
        ((SheetTable)localObject5).setValueName("sheet2" + this.j);
        ((SheetTable)localObject5).updateFunction();
        localDBModel.addChildElement((IElement)localObject5);
        ((SheetTable)localObject5).addChildElement(new SheetFieldModel("nID", "nID", "string", true));
        ((SheetTable)localObject6).addChildElement(new SheetFieldModel((FieldModel)localSelectTable.getFields().get(localSelectTable.getFields().size() - 1)));
        localObject2 = ((SheetTable)localObject6).getTableFunction("loadFromView");
        if (localObject2 != null)
        {
          localObject8 = new TableFunctionToken();
          localObject9 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject9);
          ((StatementContainerToken)localObject9).addChildElement((IElement)localObject8);
          ((TableFunctionToken)localObject8).setMemberElement((IElement)localObject2);
          localObject10 = (ValueToken)((TableFunctionToken)localObject8).getValueTokens().get(0);
          localObject11 = new MemberToken(((ValueToken)localObject10).getValueType());
          ((ValueToken)localObject10).addChildElement((IElement)localObject11);
          ((MemberToken)localObject11).setMemberElement(localSelectTable);
        }
        localRule = (Rule)localRulePackage.createChildNode("Rule");
        localRule.setSheetWhile(true);
        localRule.setSheetTable((IWhileObject)localObject6);
        if (localRule != null)
        {
          localObject8 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject8);
          localObject9 = new AssignToken();
          ((StatementContainerToken)localObject8).addChildElement((IElement)localObject9);
          localObject10 = new FieldToken();
          ((AssignToken)localObject9).addChildElement((IElement)localObject10);
          ((AssignToken)localObject9).addChildElement(new AssignJudgeToken());
          ((FieldToken)localObject10).setMemberElement(((SheetTable)localObject6).getField("nID"));
          localObject11 = ((AssignToken)localObject9).getComparedValue();
          for (i4 = 0; i4 < localTableModel.getPrimaryNames().length; i4++)
          {
            localObject13 = new MemberSheetToken("string");
            ((IValueContainerToken)localObject11).addChildElement((IElement)localObject13);
            ((MemberSheetToken)localObject13).setMemberElement(((SheetTable)localObject6).getField(localTableModel.getPrimaryNames()[i4]));
            if (i4 >= localTableModel.getPrimaryNames().length - 1)
              continue;
            ((IValueContainerToken)localObject11).getOperator().setType(1);
            localObject14 = new ConstantToken("string");
            ((IValueContainerToken)localObject11).getNextValue().addChildElement((IElement)localObject14);
            ((ConstantToken)localObject14).setValue("_");
            ((IValueContainerToken)localObject11).getNextValue().getOperator().setType(1);
            localObject11 = ((IValueContainerToken)localObject11).getNextValue().getNextValue();
          }
        }
        localRule = (Rule)localRulePackage.createChildNode("Rule");
        localObject2 = ((SheetTable)localObject5).getTableFunction("loadFromSheet");
        if (localObject2 != null)
        {
          localObject8 = new TableFunctionToken();
          localObject9 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject9);
          ((StatementContainerToken)localObject9).addChildElement((IElement)localObject8);
          ((TableFunctionToken)localObject8).setMemberElement((IElement)localObject2);
          localObject10 = (ValueToken)((TableFunctionToken)localObject8).getValueTokens().get(0);
          localObject11 = new MemberToken(((ValueToken)localObject10).getValueType());
          ((ValueToken)localObject10).addChildElement((IElement)localObject11);
          ((MemberToken)localObject11).setMemberElement((IElement)localObject6);
        }
        localObject2 = ((SheetTable)localObject5).getTableFunction("getListResult");
        if (localObject2 != null)
        {
          localObject8 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject8);
          localObject9 = new AssignToken();
          ((StatementContainerToken)localObject8).addChildElement((IElement)localObject9);
          localObject10 = new FieldToken();
          ((AssignToken)localObject9).addChildElement((IElement)localObject10);
          ((AssignToken)localObject9).addChildElement(new AssignJudgeToken());
          if (localMappingVariable3 != null)
            ((FieldToken)localObject10).setMemberElement(localMappingVariable3);
          else
            ((AssignToken)localObject9).changeFieldType(((TableFunction)localObject2).getJavaType());
          localObject11 = new TableFunctionToken(((TableFunction)localObject2).getValueType());
          ((AssignToken)localObject9).getComparedValue().addChildElement((IElement)localObject11);
          ((TableFunctionToken)localObject11).setMemberElement((IElement)localObject2);
        }
      }
      else
      {
        localObject2 = localSelectTable.getTableFunction("getListResult");
        if (localObject2 != null)
        {
          localObject8 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject8);
          localObject9 = new AssignToken();
          ((StatementContainerToken)localObject8).addChildElement((IElement)localObject9);
          localObject10 = new FieldToken();
          ((AssignToken)localObject9).addChildElement((IElement)localObject10);
          ((AssignToken)localObject9).addChildElement(new AssignJudgeToken());
          if (localMappingVariable3 != null)
            ((FieldToken)localObject10).setMemberElement(localMappingVariable3);
          else
            ((AssignToken)localObject9).changeFieldType(((TableFunction)localObject2).getJavaType());
          localObject11 = new TableFunctionToken(((TableFunction)localObject2).getValueType());
          ((AssignToken)localObject9).getComparedValue().addChildElement((IElement)localObject11);
          ((TableFunctionToken)localObject11).setMemberElement((IElement)localObject2);
        }
      }
      Object localObject9 = localRulePackage.getExportModels();
      int i3 = 0;
      if (((Iterator)localObject9).hasNext())
      {
        localObject8 = (ExportModel)((Iterator)localObject9).next();
        if (((Iterator)localObject9).hasNext())
          ((ExportModel)localObject8).setDisplayName(localRulePackage.getExeRulePackageName().replace('.', '/') + ".jsp");
        else
          ((ExportModel)localObject8).setDisplayName(this.h.replace('.', '/') + "/" + "frames.jsp");
      }
      else
      {
        localObject8 = (ExportModel)localRulePackage.createChildNode("ExportModel");
        ((ExportModel)localObject8).setDisplayName(localRulePackage.getExeRulePackageName().replace('.', '/') + ".jsp");
        i3 = 1;
        ((ExportModel)localObject8).setImportFile("standard/custom_page_tree.rsp");
        localObject11 = new String[0];
        if (((ExportModel)localObject8).getImportFile().length() > 0)
          localObject11 = ((ExportModel)localObject8).getPreferences().getStringArray(((ExportModel)localObject8).getImportFile() + ".props");
        if (localObject11 == null)
          localObject11 = ((ExportModel)localObject8).getPreferences().getStringArray("export.props");
        for (i4 = 0; i4 < localObject11.length; i4++)
        {
          localObject13 = ((ExportModel)localObject8).getPreferences().getString(localObject11[i4] + ".default", "");
          if (((String)localObject13).length() <= 0)
            continue;
          ((ExportModel)localObject8).setPropertyValue(localObject11[i4], (String)localObject13);
        }
      }
      ((ExportModel)localObject8).setPropertyValue("showpopup", "show");
      ((ExportModel)localObject8).setPropertyValue("popup_" + new CustomMessages("pagemessages").getMessage("addButton") + localTableModel.getDisplayName(), "tree_new('append.jsp?','add','submit')");
      ((ExportModel)localObject8).setPropertyValue("error", "errorshow");
      Object localObject11 = ((ExportModel)localObject8).getEnvionment().getAllMappingVariable();
      int i4 = 0;
      int i5 = 0;
      while (((Iterator)localObject11).hasNext())
      {
        localObject14 = (MappingVariable)((Iterator)localObject11).next();
        if (((this.i != null) && (((MappingVariable)localObject14).getValueName().equalsIgnoreCase(this.i))) || (((ExportModel)localObject8).getPageField(((MappingVariable)localObject14).getVariableName()) != null) || (((MappingVariable)localObject14).getValueName().equalsIgnoreCase("nID")))
          continue;
        PageFieldModel localPageFieldModel = ((ExportModel)localObject8).addMappingVariable((MappingVariable)localObject14);
        if (((MappingVariable)localObject14).getValueName().equalsIgnoreCase("su"))
        {
          localPageFieldModel.setStatType("success");
          localPageFieldModel.setInputType("notdisplay");
          localPageFieldModel.setResultType("notdisplay");
        }
        else if (((MappingVariable)localObject14).getValueName().equalsIgnoreCase("hidAct"))
        {
          localPageFieldModel.setStatType("input");
          localPageFieldModel.setInputType("notdisplay");
          localPageFieldModel.setResultType("notdisplay");
        }
        else if (((MappingVariable)localObject14).getValueType().equalsIgnoreCase("list<list>"))
        {
          localPageFieldModel.setStatType("output");
          localPageFieldModel.setResultType("tree");
          localPageFieldModel.setPropertyValue("popup_" + new CustomMessages("pagemessages").getMessage("addButton") + localTableModel.getDisplayName(), "tree_click('append.jsp','add','submit')");
          localPageFieldModel.setPropertyValue("popup_" + new CustomMessages("pagemessages").getMessage("modifyButton") + localTableModel.getDisplayName(), "tree_click('modify.jsp','mod','submit')");
          localPageFieldModel.setPropertyValue("popup_" + new CustomMessages("pagemessages").getMessage("deleteButton") + localTableModel.getDisplayName(), "tree_del('del')");
          localPageFieldModel.setPropertyValue("popup_" + new CustomMessages("pagemessages").getMessage("queryButton") + localTableModel.getDisplayName(), "tree_click('view.jsp','browse','submit')");
          localPageFieldModel.setPropertyValue("treeurl", "list.jsp?superIDs=<%=((java.util.List)" + ((MappingVariable)localObject14).getValueName() + ".get(i)).get(0)%>");
        }
        else
        {
          localPageFieldModel.setInputType("hidden");
          localPageFieldModel.setPropertyValue("valuepos", String.valueOf(i5++));
        }
        a(localPageFieldModel, localPageFieldModel.getInputType());
        a(localPageFieldModel, localPageFieldModel.getResultType());
      }
      ((ExportModel)localObject8).setModified(true);
      if (((Iterator)localObject9).hasNext())
      {
        localObject8 = (ExportModel)((Iterator)localObject9).next();
        ((ExportModel)localObject8).setDisplayName(this.h.replace('.', '/') + "/" + "frames.jsp");
      }
      else if (i3 != 0)
      {
        localObject8 = (ExportModel)localRulePackage.createChildNode("ExportModel");
        ((ExportModel)localObject8).setDisplayName(this.h.replace('.', '/') + "/" + "frames.jsp");
        ((ExportModel)localObject8).setImportFile("standard/page_frames.rsp");
        localObject14 = new String[0];
        if (((ExportModel)localObject8).getImportFile().length() > 0)
          localObject14 = ((ExportModel)localObject8).getPreferences().getStringArray(((ExportModel)localObject8).getImportFile() + ".props");
        if (localObject14 == null)
          localObject14 = ((ExportModel)localObject8).getPreferences().getStringArray("export.props");
        for (int i6 = 0; i6 < localObject14.length; i6++)
        {
          String str = ((ExportModel)localObject8).getPreferences().getString(localObject14[i6] + ".default", "");
          if (str.length() <= 0)
            continue;
          ((ExportModel)localObject8).setPropertyValue(localObject14[i6], str);
        }
        ((ExportModel)localObject8).setPropertyValue("rule", "init");
        ((ExportModel)localObject8).setPropertyValue("leftpage", "tree.jsp");
        ((ExportModel)localObject8).setPropertyValue("rightpage", "list.jsp");
      }
      ((ExportModel)localObject8).setModified(true);
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }

  public void c()
  {
    if (this.a == null)
      return;
    if (d.class.getClassLoader().getResource(this.e + "/view.rpk") == null)
      return;
    RulePackage localRulePackage;
    try
    {
      localRulePackage = (RulePackage)((RulePackage)new com.flagleader.repository.e.d().load(d.class.getClassLoader().getResourceAsStream(this.e + "/view.rpk"))).deepClone();
    }
    catch (Exception localException1)
    {
      return;
    }
    localRulePackage.setDisplayName(localRulePackage.getDisplayName() + this.g);
    localRulePackage.setExeRulePackageName(this.h + ".view");
    this.d.addChildElement(localRulePackage);
    localRulePackage.setFilePathName("");
    DBModel localDBModel = a(localRulePackage);
    try
    {
      MappingVariable localMappingVariable = localRulePackage.getEnvionment().getValueLibrary().getVariable("nID");
      SubVariable localSubVariable = (SubVariable)((SubTypeMethod)localMappingVariable.getSubEditens().next()).getSubEditens().next();
      TableModel localTableModel = (TableModel)this.a.deepClone();
      HashMap localHashMap = new HashMap();
      Rule localRule = null;
      Object localObject2;
      if ((localRulePackage.getRuleAndSetCount() > 0) && (((RuleSet)localRulePackage.getRulesList().get(0)).getRuleAndSets().hasNext()))
      {
        localRule = (Rule)((RuleSet)localRulePackage.getRulesList().get(0)).getRuleAndSets().next();
      }
      else
      {
        localObject1 = (RuleSet)localRulePackage.createChildNode("RuleSet");
        localObject2 = new ConditionToken();
        ((ConditionToken)localObject2).init();
        ((RuleSet)localObject1).getRuleSetToken().getTestConditions().addChildElement((IElement)localObject2);
        localObject3 = (MemberToken)((ConditionToken)localObject2).getFirstValue();
        ((MemberToken)localObject3).setMemberElement(localMappingVariable);
        ((StringJudgeToken)((ConditionToken)localObject2).getCompareOperator()).setType(8);
        localRule = (Rule)((RuleSet)localObject1).createChildNode("Rule");
      }
      localRule.setSupportInit(true);
      localRule.getRuleElementToken().getThenActions();
      Object localObject1 = localTableModel.getTableFunction("select");
      if (localObject1 != null)
      {
        localObject2 = new TableFunctionToken();
        localObject3 = new StatementContainerToken();
        localRule.getRuleElementToken().getInitActions().addChildElement((IElement)localObject3);
        ((StatementContainerToken)localObject3).addChildElement((IElement)localObject2);
        ((TableFunctionToken)localObject2).setMemberElement((IElement)localObject1);
      }
      localObject1 = localTableModel.getTableFunction("next");
      if (localObject1 != null)
      {
        localObject2 = new ConditionToken();
        ((ConditionToken)localObject2).init();
        localRule.getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject2);
        localObject3 = (MemberToken)((ConditionToken)localObject2).getFirstValue();
        ((MemberToken)localObject3).setMemberElement((IElement)localObject1);
        ((ConditionToken)localObject2).addChildElement(new BooleanJudgeToken());
      }
      Object localObject4;
      Object localObject7;
      Object localObject8;
      for (int k = 0; k < localTableModel.getPrimaryKeys().size(); k++)
      {
        localObject3 = (FieldModel)localTableModel.getPrimaryKeys().get(k);
        localObject1 = localTableModel.getFieldSetFunc((FieldModel)localObject3);
        if (localObject1 == null)
          continue;
        localObject4 = new TableFunctionToken();
        localObject5 = new StatementContainerToken();
        localRule.getRuleElementToken().getInitActions().addChildElement((IElement)localObject5, 0);
        ((StatementContainerToken)localObject5).addChildElement((IElement)localObject4);
        ((TableFunctionToken)localObject4).setMemberElement((IElement)localObject1);
        localObject6 = (ValueToken)((TableFunctionToken)localObject4).getValueTokens().get(0);
        localObject7 = new MemberToken(((ValueToken)localObject6).getValueType());
        ((ValueToken)localObject6).addChildElement((IElement)localObject7);
        ((MemberToken)localObject7).setMemberElement(localSubVariable);
        localObject6 = (ValueToken)((MemberToken)localObject7).getValueTokens().get(0);
        localObject8 = new ConstantToken("string");
        ((ValueToken)localObject6).addChildElement((IElement)localObject8);
        ((ConstantToken)localObject8).setValue("_");
        localObject6 = (ValueToken)((MemberToken)localObject7).getValueTokens().get(1);
        localObject8 = new ConstantToken("int");
        ((ValueToken)localObject6).addChildElement((IElement)localObject8);
        ((ConstantToken)localObject8).setValue(String.valueOf(k));
      }
      for (k = 0; k < localTableModel.getFields().size(); k++)
      {
        localObject3 = (FieldModel)localTableModel.getFields().get(k);
        localObject4 = localRulePackage.getEnvionment().getValueLibrary().getVariable(((FieldModel)localObject3).getFieldName());
        if (localObject4 == null)
        {
          localObject4 = new MappingVariable((FieldModel)localObject3);
          ((MappingVariable)localObject4).setVisible(true);
          if (((MappingVariable)localObject4).getValueType().equalsIgnoreCase("datetime"))
            ((MappingVariable)localObject4).setValueType("date");
          localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject4);
        }
        localObject1 = localTableModel.getFieldGetFunc((FieldModel)localObject3);
        if (localObject1 == null)
          continue;
        localObject5 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject5, 0);
        localObject6 = new AssignToken();
        ((StatementContainerToken)localObject5).addChildElement((IElement)localObject6);
        localObject7 = new FieldToken();
        ((AssignToken)localObject6).addChildElement((IElement)localObject7);
        ((AssignToken)localObject6).addChildElement(new AssignJudgeToken());
        if (localObject4 != null)
          ((FieldToken)localObject7).setMemberElement((IElement)localObject4);
        else
          ((AssignToken)localObject6).changeFieldType(((TableFunction)localObject1).getJavaType());
        localObject8 = new TableFunctionToken(((TableFunction)localObject1).getValueType());
        ((AssignToken)localObject6).getComparedValue().addChildElement((IElement)localObject8);
        ((TableFunctionToken)localObject8).setMemberElement((IElement)localObject1);
      }
      List localList = this.c.getFKModels(localTableModel.getTableName());
      Object localObject3 = new ArrayList();
      Object localObject9;
      Object localObject10;
      Object localObject11;
      for (int m = 0; m < localList.size(); m++)
      {
        localObject5 = (FKModel)localList.get(m);
        localTableModel.addChildElement((IElement)localObject5);
        if ((((FKModel)localObject5).getKeys().size() != 1) || (!((FKModel)localObject5).getFKTableName().equalsIgnoreCase(localTableModel.getTableName())) || (a((List)localObject3, ((FKModel)localObject5).getPkTableName())))
          continue;
        localObject6 = this.c.getTableModel(((FKModel)localObject5).getPkTableName());
        if (localObject6 == null)
          continue;
        localObject7 = ((AdvancedProperty)((FKModel)localObject5).getKeys().get(0)).getKey();
        for (int i1 = 0; i1 < ((TableModel)localObject6).getFields().size(); i1++)
        {
          if ((!((FieldModel)((TableModel)localObject6).getFields().get(i1)).getFieldName().equalsIgnoreCase((String)localObject7)) || (i1 + 1 >= ((TableModel)localObject6).getFields().size()))
            continue;
          localObject7 = ((FieldModel)((TableModel)localObject6).getFields().get(i1 + 1)).getFieldName();
          break;
        }
        if (!((TableModel)localObject6).getField(((AdvancedProperty)((FKModel)localObject5).getKeys().get(0)).getKey()).getValueType().equalsIgnoreCase("string"))
        {
          localObject9 = localDBModel.createSelectTable("select " + ((AdvancedProperty)((FKModel)localObject5).getKeys().get(0)).getKey() + "," + (String)localObject7 + " from " + ((TableModel)localObject6).getTableName(), ((FKModel)localObject5).getFKName(), ((FKModel)localObject5).getFKName());
          localObject10 = new MappingVariable("list" + ((FKModel)localObject5).getFKName(), ((FKModel)localObject5).getFKName(), "list<list>", true);
          localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject10);
          localRule = (Rule)localRulePackage.createChildNode("Rule");
          localObject1 = ((SelectTable)localObject9).getTableFunction("selectWhere");
          Object localObject12;
          if (localObject1 != null)
          {
            localObject11 = new TableFunctionToken();
            localObject12 = new StatementContainerToken();
            localRule.getRuleElementToken().getInitActions().addChildElement((IElement)localObject12);
            ((StatementContainerToken)localObject12).addChildElement((IElement)localObject11);
            ((TableFunctionToken)localObject11).setMemberElement((IElement)localObject1);
          }
          localObject1 = ((SelectTable)localObject9).getTableFunction("getListResult");
          if (localObject1 != null)
          {
            localObject11 = new StatementContainerToken();
            localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject11);
            localObject12 = new AssignToken();
            ((StatementContainerToken)localObject11).addChildElement((IElement)localObject12);
            FieldToken localFieldToken = new FieldToken();
            ((AssignToken)localObject12).addChildElement(localFieldToken);
            ((AssignToken)localObject12).addChildElement(new AssignJudgeToken());
            if (localObject10 != null)
              localFieldToken.setMemberElement((IElement)localObject10);
            else
              ((AssignToken)localObject12).changeFieldType(((TableFunction)localObject1).getJavaType());
            TableFunctionToken localTableFunctionToken = new TableFunctionToken(((TableFunction)localObject1).getValueType());
            ((AssignToken)localObject12).getComparedValue().addChildElement(localTableFunctionToken);
            localTableFunctionToken.setMemberElement((IElement)localObject1);
          }
          localRule.setModified(true);
          localHashMap.put(((AdvancedProperty)((FKModel)localObject5).getKeys().get(0)).getKey(), localObject9);
        }
        else
        {
          localObject9 = "select " + ((AdvancedProperty)((FKModel)localObject5).getKeys().get(0)).getKey() + "," + (String)localObject7 + " from " + ((TableModel)localObject6).getTableName() + " where " + ((AdvancedProperty)((FKModel)localObject5).getKeys().get(0)).getKey() + " like '?%'";
          localHashMap.put(((AdvancedProperty)((FKModel)localObject5).getKeys().get(0)).getKey(), localObject9);
        }
        ((List)localObject3).add(localObject6);
      }
      localDBModel.addChildElement(localTableModel);
      localDBModel.updateTableModel(localTableModel);
      Object localObject5 = localRulePackage.getExportModels();
      ExportModel localExportModel;
      if (((Iterator)localObject5).hasNext())
      {
        localExportModel = (ExportModel)((Iterator)localObject5).next();
        localExportModel.setDisplayName(this.h.replace('.', '/') + "/" + "modify.jsp");
      }
      else
      {
        localExportModel = (ExportModel)localRulePackage.createChildNode("ExportModel");
        localExportModel.setDisplayName(this.h.replace('.', '/') + "/" + "modify.jsp");
        localExportModel.setImportFile("standard/page_popupinput.rsp");
        localObject6 = new String[0];
        if (localExportModel.getImportFile().length() > 0)
          localObject6 = localExportModel.getPreferences().getStringArray(localExportModel.getImportFile() + ".props");
        if (localObject6 == null)
          localObject6 = localExportModel.getPreferences().getStringArray("export.props");
        for (n = 0; n < localObject6.length; n++)
        {
          localObject9 = localExportModel.getPreferences().getString(localObject6[n] + ".default", "");
          if (((String)localObject9).length() <= 0)
            continue;
          localExportModel.setPropertyValue(localObject6[n], (String)localObject9);
        }
        localExportModel.setPropertyValue("submit", "submit");
      }
      Object localObject6 = localExportModel.getEnvionment().getAllMappingVariable();
      int n = 0;
      int i4;
      while (((Iterator)localObject6).hasNext())
      {
        localObject9 = (MappingVariable)((Iterator)localObject6).next();
        if (((this.i != null) && (((MappingVariable)localObject9).getValueName().equalsIgnoreCase(this.i))) || (localExportModel.getPageField(((MappingVariable)localObject9).getVariableName()) != null) || (((MappingVariable)localObject9).getValueName().equalsIgnoreCase("nID")))
          continue;
        localObject10 = localExportModel.addMappingVariable((MappingVariable)localObject9);
        if (localHashMap.get(((MappingVariable)localObject9).getValueName()) != null)
        {
          if ((localHashMap.get(((MappingVariable)localObject9).getValueName()) instanceof SelectTable))
          {
            ((PageFieldModel)localObject10).setInputType("select");
            ((PageFieldModel)localObject10).setPropertyValue("p_options", "list" + ((SelectTable)localHashMap.get(((MappingVariable)localObject9).getValueName())).getValueName());
          }
          else
          {
            ((PageFieldModel)localObject10).setInputType("textauto");
            ((PageFieldModel)localObject10).setPropertyValue("sql", (String)localHashMap.get(((MappingVariable)localObject9).getValueName()));
            ((PageFieldModel)localObject10).setPropertyValue("connection", this.c.getDatasourceName());
          }
        }
        else if (((MappingVariable)localObject9).getValueName().equalsIgnoreCase("su"))
        {
          ((PageFieldModel)localObject10).setStatType("success");
          ((PageFieldModel)localObject10).setInputType("notdisplay");
          ((PageFieldModel)localObject10).setResultType("notdisplay");
        }
        else if (((MappingVariable)localObject9).getValueName().equalsIgnoreCase("hidAct"))
        {
          ((PageFieldModel)localObject10).setStatType("input");
          ((PageFieldModel)localObject10).setInputType("notdisplay");
          ((PageFieldModel)localObject10).setResultType("notdisplay");
        }
        else if (((MappingVariable)localObject9).getValueType().equalsIgnoreCase("list<list>"))
        {
          ((PageFieldModel)localObject10).setStatType("output");
          ((PageFieldModel)localObject10).setResultType("notdisplay");
        }
        else
        {
          ((PageFieldModel)localObject10).setPropertyValue("valuepos", String.valueOf(n++));
        }
        localObject11 = localTableModel.getField(((MappingVariable)localObject9).getValueName());
        if (localObject11 != null)
        {
          if (((FieldModel)localObject11).isUnNull())
            ((PageFieldModel)localObject10).setNullType("notnull");
          if (!StringUtil.isEmpty(((FieldModel)localObject11).getDefaultValue()))
            ((PageFieldModel)localObject10).setPropertyValue("default", ((FieldModel)localObject11).getDefaultValue());
          if ((((FieldModel)localObject11).isReadOnly()) || (((FieldModel)localObject11).isAutoIncrement()))
            ((PageFieldModel)localObject10).setNullType("readonly");
          if (((FieldModel)localObject11).getAdvanceProperties().length > 0)
          {
            ((PageFieldModel)localObject10).setInputType("select");
            for (i4 = 0; i4 < ((FieldModel)localObject11).getAdvanceProperties().length; i4++)
              ((PageFieldModel)localObject10).setPropertyValue("o_" + localObject11.getAdvanceProperties()[i4].getKey(), localObject11.getAdvanceProperties()[i4].getProperty());
          }
        }
        a((PageFieldModel)localObject10, ((PageFieldModel)localObject10).getInputType());
        a((PageFieldModel)localObject10, ((PageFieldModel)localObject10).getResultType());
      }
      localExportModel.setModified(true);
      if (((Iterator)localObject5).hasNext())
      {
        localExportModel = (ExportModel)((Iterator)localObject5).next();
        localExportModel.setDisplayName(this.h.replace('.', '/') + "/" + "view.jsp");
      }
      else
      {
        localExportModel = (ExportModel)localRulePackage.createChildNode("ExportModel");
        localExportModel.setDisplayName(this.h.replace('.', '/') + "/" + "view.jsp");
        localExportModel.setImportFile("standard/page_popupinput.rsp");
        localObject9 = new String[0];
        if (localExportModel.getImportFile().length() > 0)
          localObject9 = localExportModel.getPreferences().getStringArray(localExportModel.getImportFile() + ".props");
        if (localObject9 == null)
          localObject9 = localExportModel.getPreferences().getStringArray("export.props");
        for (int i2 = 0; i2 < localObject9.length; i2++)
        {
          localObject11 = localExportModel.getPreferences().getString(localObject9[i2] + ".default", "");
          if (((String)localObject11).length() <= 0)
            continue;
          localExportModel.setPropertyValue(localObject9[i2], (String)localObject11);
        }
        localExportModel.setPropertyValue("submit", "nosubmit");
      }
      localObject6 = localExportModel.getEnvionment().getAllMappingVariable();
      n = 0;
      while (((Iterator)localObject6).hasNext())
      {
        localObject9 = (MappingVariable)((Iterator)localObject6).next();
        if (((this.i != null) && (((MappingVariable)localObject9).getValueName().equalsIgnoreCase(this.i))) || (localExportModel.getPageField(((MappingVariable)localObject9).getVariableName()) != null) || (((MappingVariable)localObject9).getValueName().equalsIgnoreCase("nID")))
          continue;
        PageFieldModel localPageFieldModel1 = localExportModel.addMappingVariable((MappingVariable)localObject9);
        if (localHashMap.get(((MappingVariable)localObject9).getValueName()) != null)
        {
          if ((localHashMap.get(((MappingVariable)localObject9).getValueName()) instanceof SelectTable))
          {
            localPageFieldModel1.setInputType("select");
            localPageFieldModel1.setPropertyValue("p_options", "list" + ((SelectTable)localHashMap.get(((MappingVariable)localObject9).getValueName())).getValueName());
          }
          else
          {
            localPageFieldModel1.setInputType("textauto");
            localPageFieldModel1.setPropertyValue("sql", (String)localHashMap.get(((MappingVariable)localObject9).getValueName()));
            localPageFieldModel1.setPropertyValue("connection", this.c.getDatasourceName());
          }
        }
        else if (((MappingVariable)localObject9).getValueName().equalsIgnoreCase("su"))
        {
          localPageFieldModel1.setStatType("success");
          localPageFieldModel1.setInputType("notdisplay");
          localPageFieldModel1.setResultType("notdisplay");
        }
        else if (((MappingVariable)localObject9).getValueName().equalsIgnoreCase("hidAct"))
        {
          localPageFieldModel1.setStatType("input");
          localPageFieldModel1.setInputType("notdisplay");
          localPageFieldModel1.setResultType("notdisplay");
        }
        else if (((MappingVariable)localObject9).getValueType().equalsIgnoreCase("list<list>"))
        {
          localPageFieldModel1.setStatType("output");
          localPageFieldModel1.setResultType("notdisplay");
        }
        else
        {
          localPageFieldModel1.setPropertyValue("valuepos", String.valueOf(n++));
        }
        localObject11 = localTableModel.getField(((MappingVariable)localObject9).getValueName());
        if (localObject11 != null)
        {
          if (((FieldModel)localObject11).isUnNull())
            localPageFieldModel1.setNullType("notnull");
          if (!StringUtil.isEmpty(((FieldModel)localObject11).getDefaultValue()))
            localPageFieldModel1.setPropertyValue("default", ((FieldModel)localObject11).getDefaultValue());
          if (((FieldModel)localObject11).getAdvanceProperties().length > 0)
          {
            localPageFieldModel1.setInputType("select");
            for (i4 = 0; i4 < ((FieldModel)localObject11).getAdvanceProperties().length; i4++)
              localPageFieldModel1.setPropertyValue("o_" + localObject11.getAdvanceProperties()[i4].getKey(), localObject11.getAdvanceProperties()[i4].getProperty());
          }
        }
        a(localPageFieldModel1, localPageFieldModel1.getInputType());
        a(localPageFieldModel1, localPageFieldModel1.getResultType());
      }
      localExportModel.setModified(true);
      if (((Iterator)localObject5).hasNext())
      {
        localExportModel = (ExportModel)((Iterator)localObject5).next();
        localExportModel.setDisplayName(this.h.replace('.', '/') + "/" + "append.jsp");
      }
      else
      {
        localExportModel = (ExportModel)localRulePackage.createChildNode("ExportModel");
        localExportModel.setDisplayName(this.h.replace('.', '/') + "/" + "append.jsp");
        localExportModel.setImportFile("standard/page_popupinput.rsp");
        localObject9 = new String[0];
        if (localExportModel.getImportFile().length() > 0)
          localObject9 = localExportModel.getPreferences().getStringArray(localExportModel.getImportFile() + ".props");
        if (localObject9 == null)
          localObject9 = localExportModel.getPreferences().getStringArray("export.props");
        for (int i3 = 0; i3 < localObject9.length; i3++)
        {
          localObject11 = localExportModel.getPreferences().getString(localObject9[i3] + ".default", "");
          if (((String)localObject11).length() <= 0)
            continue;
          localExportModel.setPropertyValue(localObject9[i3], (String)localObject11);
        }
        localExportModel.setPropertyValue("submit", "submit");
      }
      localObject6 = localExportModel.getEnvionment().getAllMappingVariable();
      n = 0;
      while (((Iterator)localObject6).hasNext())
      {
        localObject9 = (MappingVariable)((Iterator)localObject6).next();
        if (((this.i != null) && (((MappingVariable)localObject9).getValueName().equalsIgnoreCase(this.i))) || (localExportModel.getPageField(((MappingVariable)localObject9).getVariableName()) != null) || (((MappingVariable)localObject9).getValueName().equalsIgnoreCase("nID")))
          continue;
        PageFieldModel localPageFieldModel2 = localExportModel.addMappingVariable((MappingVariable)localObject9);
        if (localHashMap.get(((MappingVariable)localObject9).getValueName()) != null)
        {
          if ((localHashMap.get(((MappingVariable)localObject9).getValueName()) instanceof SelectTable))
          {
            localPageFieldModel2.setInputType("select");
            localPageFieldModel2.setPropertyValue("p_options", "list" + ((SelectTable)localHashMap.get(((MappingVariable)localObject9).getValueName())).getValueName());
          }
          else
          {
            localPageFieldModel2.setInputType("textauto");
            localPageFieldModel2.setPropertyValue("sql", (String)localHashMap.get(((MappingVariable)localObject9).getValueName()));
            localPageFieldModel2.setPropertyValue("connection", this.c.getDatasourceName());
          }
        }
        else if (((MappingVariable)localObject9).getValueName().equalsIgnoreCase("su"))
        {
          localPageFieldModel2.setStatType("success");
          localPageFieldModel2.setInputType("notdisplay");
          localPageFieldModel2.setResultType("notdisplay");
        }
        else if (((MappingVariable)localObject9).getValueName().equalsIgnoreCase("hidAct"))
        {
          localPageFieldModel2.setStatType("input");
          localPageFieldModel2.setInputType("notdisplay");
          localPageFieldModel2.setResultType("notdisplay");
        }
        else if (((MappingVariable)localObject9).getValueType().equalsIgnoreCase("list<list>"))
        {
          localPageFieldModel2.setStatType("output");
          localPageFieldModel2.setResultType("notdisplay");
        }
        else
        {
          localPageFieldModel2.setPropertyValue("valuepos", String.valueOf(n++));
        }
        localObject11 = localTableModel.getField(((MappingVariable)localObject9).getValueName());
        if (localObject11 != null)
        {
          if (((FieldModel)localObject11).isUnNull())
            localPageFieldModel2.setNullType("notnull");
          if (!StringUtil.isEmpty(((FieldModel)localObject11).getDefaultValue()))
            localPageFieldModel2.setPropertyValue("default", ((FieldModel)localObject11).getDefaultValue());
          if (((FieldModel)localObject11).getAdvanceProperties().length > 0)
          {
            localPageFieldModel2.setInputType("select");
            for (i4 = 0; i4 < ((FieldModel)localObject11).getAdvanceProperties().length; i4++)
              localPageFieldModel2.setPropertyValue("o_" + localObject11.getAdvanceProperties()[i4].getKey(), localObject11.getAdvanceProperties()[i4].getProperty());
          }
        }
        a(localPageFieldModel2, localPageFieldModel2.getInputType());
        a(localPageFieldModel2, localPageFieldModel2.getResultType());
      }
      localExportModel.setModified(true);
    }
    catch (Exception localException2)
    {
    }
  }

  private void a(SelectTable paramSelectTable, a parama)
  {
    for (int k = 0; k < paramSelectTable.getFields().size(); k++)
    {
      FieldModel localFieldModel = (FieldModel)paramSelectTable.getFields().get(k);
      List localList = parama.c();
      for (int m = 0; m < localList.size(); m++)
      {
        e locale = (e)localList.get(m);
        if (!locale.a().getFieldName().equalsIgnoreCase(localFieldModel.getFieldName()))
          continue;
        localFieldModel.setDisplayName(locale.a().getDisplayName());
      }
    }
  }

  public void d()
  {
    if (this.b == null)
      return;
    if (d.class.getClassLoader().getResource(this.e + "/list.rpk") == null)
      return;
    RulePackage localRulePackage;
    try
    {
      localRulePackage = (RulePackage)((RulePackage)new com.flagleader.repository.e.d().load(d.class.getClassLoader().getResourceAsStream(this.e + "/list.rpk"))).deepClone();
    }
    catch (Exception localException1)
    {
      return;
    }
    localRulePackage.setDisplayName(localRulePackage.getDisplayName() + this.b.getDisplayName());
    localRulePackage.setExeRulePackageName(this.h + ".list");
    this.d.addChildElement(localRulePackage);
    localRulePackage.setFilePathName("");
    DBModel localDBModel = a(localRulePackage);
    try
    {
      a locala = new a(this.c);
      SelectTable localSelectTable = localDBModel.createSelectTable(locala.a(this.b, this.f), this.b.getDisplayName(), "select" + this.j);
      a(localSelectTable, locala);
      SheetTable localSheetTable = new SheetTable();
      localSheetTable.setDisplayName("sheet" + this.b.getDisplayName());
      localSheetTable.setValueName("sheet" + this.j);
      localSheetTable.updateFunction();
      localDBModel.addChildElement(localSheetTable);
      localSheetTable.addChildElement(new SheetFieldModel("nID", "nID", "string", true));
      for (int k = 0; k < localSelectTable.getFields().size(); k++)
        localSheetTable.addChildElement(new SheetFieldModel((FieldModel)localSelectTable.getFields().get(k)));
      MappingVariable localMappingVariable1 = new MappingVariable("list" + this.j, this.b.getDisplayName(), "list<list>", true);
      localRulePackage.getEnvionment().getValueLibrary().addChildElement(localMappingVariable1);
      MappingVariable localMappingVariable2 = localRulePackage.getEnvionment().getValueLibrary().getVariable("superIDs");
      SubVariable localSubVariable = (SubVariable)((SubTypeMethod)localMappingVariable2.getSubEditens().next()).getSubEditens().next();
      Rule localRule = (Rule)localRulePackage.createChildNode("Rule");
      Object localObject1;
      Object localObject4;
      if (localRulePackage.getEnvionment().getValueLibrary().getVariable("page_num") != null)
      {
        localTableFunction = localSelectTable.getTableFunction("setOrderField");
        ValueToken localValueToken;
        if (localTableFunction != null)
        {
          localObject1 = new TableFunctionToken();
          localObject2 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject2);
          ((StatementContainerToken)localObject2).addChildElement((IElement)localObject1);
          ((TableFunctionToken)localObject1).setMemberElement(localTableFunction);
          localValueToken = (ValueToken)((TableFunctionToken)localObject1).getValueTokens().get(0);
          localObject4 = new MemberToken(localValueToken.getValueType());
          localValueToken.addChildElement((IElement)localObject4);
          ((MemberToken)localObject4).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("order_field"));
          localValueToken = (ValueToken)((TableFunctionToken)localObject1).getValueTokens().get(1);
          localObject4 = new MemberToken(localValueToken.getValueType());
          localValueToken.addChildElement((IElement)localObject4);
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
          localValueToken = (ValueToken)((TableFunctionToken)localObject1).getValueTokens().get(0);
          localObject4 = new MemberToken(localValueToken.getValueType());
          localValueToken.addChildElement((IElement)localObject4);
          ((MemberToken)localObject4).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("page_num"));
          localValueToken = (ValueToken)((TableFunctionToken)localObject1).getValueTokens().get(1);
          localObject4 = new MemberToken(localValueToken.getValueType());
          localValueToken.addChildElement((IElement)localObject4);
          ((MemberToken)localObject4).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable("per_page"));
        }
      }
      TableFunction localTableFunction = localSelectTable.getTableFunction("selectWhere");
      Object localObject5;
      if (localTableFunction != null)
      {
        localObject1 = new TableFunctionToken();
        localObject2 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject2);
        ((StatementContainerToken)localObject2).addChildElement((IElement)localObject1);
        ((TableFunctionToken)localObject1).setMemberElement(localTableFunction);
        for (int m = 0; m < this.f.size(); m++)
        {
          localObject4 = (ValueToken)((TableFunctionToken)localObject1).getValueTokens().get(m);
          MemberToken localMemberToken = new MemberToken(((ValueToken)localObject4).getValueType());
          ((ValueToken)localObject4).addChildElement(localMemberToken);
          localMemberToken.setMemberElement(localSubVariable);
          localObject4 = (ValueToken)localMemberToken.getValueTokens().get(0);
          localObject5 = new ConstantToken("string");
          ((ValueToken)localObject4).addChildElement((IElement)localObject5);
          ((ConstantToken)localObject5).setValue("_");
          localObject4 = (ValueToken)localMemberToken.getValueTokens().get(1);
          localObject5 = new ConstantToken("int");
          ((ValueToken)localObject4).addChildElement((IElement)localObject5);
          ((ConstantToken)localObject5).setValue(String.valueOf(m));
        }
      }
      localTableFunction = localSheetTable.getTableFunction("loadFromView");
      Object localObject3;
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
      int i1;
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
        for (i1 = 0; i1 < this.b.getPrimaryNames().length; i1++)
        {
          localObject5 = new MemberSheetToken("string");
          ((IValueContainerToken)localObject4).addChildElement((IElement)localObject5);
          ((MemberSheetToken)localObject5).setMemberElement(localSheetTable.getField(this.b.getPrimaryNames()[i1]));
          if (i1 >= this.b.getPrimaryNames().length - 1)
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
        if (localMappingVariable1 != null)
          ((FieldToken)localObject3).setMemberElement(localMappingVariable1);
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
        for (int n = 0; n < localObject2.length; n++)
        {
          localObject4 = ((ExportModel)localObject1).getPreferences().getString(localObject2[n] + ".default", "");
          if (((String)localObject4).length() <= 0)
            continue;
          ((ExportModel)localObject1).setPropertyValue(localObject2[n], (String)localObject4);
        }
        ((ExportModel)localObject1).setPropertyValue("addpage", "add.jsp");
        ((ExportModel)localObject1).setPropertyValue("editpage", "edit.jsp");
        ((ExportModel)localObject1).setPropertyValue("deletepage", "delete.jsp");
        ((ExportModel)localObject1).setPropertyValue("submitpage", "list.jsp");
      }
      Object localObject2 = localMappingVariable1;
      if (((ExportModel)localObject1).getPageField(((MappingVariable)localObject2).getVariableName()) == null)
      {
        PageFieldModel localPageFieldModel = ((ExportModel)localObject1).addMappingVariable((MappingVariable)localObject2);
        if (localRulePackage.getEnvionment().getValueLibrary().getVariable("record_count") == null)
          localPageFieldModel.setPropertyValue("exportExcel", "true");
        a(localPageFieldModel, localPageFieldModel.getInputType());
        a(localPageFieldModel, localPageFieldModel.getResultType());
        localObject4 = localSelectTable.getFields();
        for (i1 = 0; i1 < ((List)localObject4).size(); i1++)
        {
          localObject5 = new PageFieldModel();
          localObject6 = (FieldModel)((List)localObject4).get(i1);
          String[] arrayOfString = ((PageFieldModel)localObject5).getPageTypeNames();
          for (int i2 = 0; i2 < arrayOfString.length; i2++)
            if (((ExportModel)localObject1).getPreferences().getStringArray(localPageFieldModel.getInputType() + "." + arrayOfString[i2]) != null)
              ((PageFieldModel)localObject5).setPageTypeValue(arrayOfString[i2], localObject1.getPreferences().getStringArray(localPageFieldModel.getInputType() + "." + arrayOfString[i2])[0]);
            else if (((ExportModel)localObject1).getPreferences().getStringArray(localPageFieldModel.getResultType() + "." + arrayOfString[i2]) != null)
              ((PageFieldModel)localObject5).setPageTypeValue(arrayOfString[i2], localObject1.getPreferences().getStringArray(localPageFieldModel.getResultType() + "." + arrayOfString[i2])[0]);
            else
              ((PageFieldModel)localObject5).setPageTypeValue(arrayOfString[i2], localPageFieldModel.getPageTypeValue(arrayOfString[i2]));
          ((PageFieldModel)localObject5).setVariableName(localPageFieldModel.getVariableName() + "_" + (i1 + 1));
          ((PageFieldModel)localObject5).setValueType(((FieldModel)localObject6).getValueType());
          if (((FieldModel)localObject6).getValueType().equalsIgnoreCase("datetime"))
            ((PageFieldModel)localObject5).setValueType("date");
          ((PageFieldModel)localObject5).setDisplayName(((FieldModel)localObject6).getDisplayName());
          ((PageFieldModel)localObject5).setLen(((FieldModel)localObject6).getLen());
          ((PageFieldModel)localObject5).setPropertyValue("fieldName", ((FieldModel)localObject6).getFieldName());
          FieldModel localFieldModel = this.b.getField(((FieldModel)localObject6).getFieldName());
          if ((localFieldModel != null) && (localFieldModel.getAdvanceProperties().length > 0))
          {
            ((PageFieldModel)localObject5).setInputType("select");
            for (int i3 = 0; i3 < localFieldModel.getAdvanceProperties().length; i3++)
              ((PageFieldModel)localObject5).setPropertyValue("o_" + localFieldModel.getAdvanceProperties()[i3].getKey(), localFieldModel.getAdvanceProperties()[i3].getProperty());
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

  private List d(List paramList)
  {
    List localList = null;
    for (int k = 0; k < paramList.size(); k++)
    {
      TableModel localTableModel = (TableModel)paramList.get(k);
      localList = localTableModel.getPrimaryKeys();
      if (a(localList, paramList))
        return localList;
    }
    return localList;
  }

  private boolean a(List paramList1, List paramList2)
  {
    for (int k = 0; k < paramList2.size(); k++)
    {
      TableModel localTableModel = (TableModel)paramList2.get(k);
      int m = 1;
      for (int n = 0; n < paramList1.size(); n++)
      {
        if (localTableModel.getField(((FieldModel)paramList1.get(n)).getFieldName()) != null)
          continue;
        m = 0;
        break;
      }
      if (m == 0)
        return false;
    }
    return true;
  }

  public boolean a(List paramList, String paramString)
  {
    for (int k = 0; k < paramList.size(); k++)
    {
      TableModel localTableModel = (TableModel)paramList.get(k);
      if (localTableModel.getTableName().equalsIgnoreCase(paramString))
        return true;
    }
    return false;
  }

  public void e()
  {
    if (d.class.getClassLoader().getResource(this.e + "/delete.rpk") == null)
      return;
    RulePackage localRulePackage;
    try
    {
      localRulePackage = (RulePackage)((RulePackage)new com.flagleader.repository.e.d().load(d.class.getClassLoader().getResourceAsStream(this.e + "/delete.rpk"))).deepClone();
    }
    catch (Exception localException1)
    {
      return;
    }
    localRulePackage.setDisplayName(localRulePackage.getDisplayName() + this.b.getDisplayName());
    localRulePackage.setExeRulePackageName(this.h + ".delete");
    this.d.addChildElement(localRulePackage);
    localRulePackage.setFilePathName("");
    DBModel localDBModel = a(localRulePackage);
    try
    {
      HashMap localHashMap = new HashMap();
      TableModel localTableModel = (TableModel)this.b.deepClone();
      List localList = this.c.getFKModels(localTableModel.getTableName());
      for (int k = 0; k < localList.size(); k++)
      {
        FKModel localFKModel = (FKModel)localList.get(k);
        localTableModel.addChildElement(localFKModel);
      }
      localDBModel.addChildElement(localTableModel);
      localDBModel.updateTableModel(localTableModel);
      Rule localRule = (Rule)((RuleSet)((RuleSet)localRulePackage.getRuleAndSets().next()).getRuleAndSets().next()).getRuleAndSets().next();
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      for (int m = 0; m < localTableModel.getPrimaryKeys().size(); m++)
      {
        localObject1 = localTableModel.getFieldSetFunc((FieldModel)localTableModel.getPrimaryKeys().get(m));
        if (localObject1 == null)
          continue;
        localObject2 = new TableFunctionToken();
        StatementContainerToken localStatementContainerToken = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement(localStatementContainerToken);
        localStatementContainerToken.addChildElement((IElement)localObject2);
        ((TableFunctionToken)localObject2).setMemberElement((IElement)localObject1);
        localObject3 = (ValueToken)((TableFunctionToken)localObject2).getValueTokens().get(0);
        localObject4 = new MemberToken(((ValueToken)localObject3).getValueType());
        ((ValueToken)localObject3).addChildElement((IElement)localObject4);
        ((MemberToken)localObject4).setMemberElement((SubVariable)localRulePackage.getEnvionment().getTempVariableLibrary().getVariable("ids").getSubEditens().next());
        localObject3 = (ValueToken)((MemberToken)localObject4).getValueTokens().get(0);
        localObject5 = new ConstantToken("int");
        ((ValueToken)localObject3).addChildElement((IElement)localObject5);
        ((ConstantToken)localObject5).setValue(String.valueOf(m));
      }
      TableFunction localTableFunction = localTableModel.getTableFunction("delete");
      if (localTableFunction != null)
      {
        localObject1 = new TableFunctionToken();
        localObject2 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject2);
        ((StatementContainerToken)localObject2).addChildElement((IElement)localObject1);
        ((TableFunctionToken)localObject1).setMemberElement(localTableFunction);
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
        ((ExportModel)localObject1).setImportFile("standard/page_input.rsp");
        localObject2 = new String[0];
        if (((ExportModel)localObject1).getImportFile().length() > 0)
          localObject2 = ((ExportModel)localObject1).getPreferences().getStringArray(((ExportModel)localObject1).getImportFile() + ".props");
        if (localObject2 == null)
          localObject2 = ((ExportModel)localObject1).getPreferences().getStringArray("export.props");
        for (int n = 0; n < localObject2.length; n++)
        {
          localObject3 = ((ExportModel)localObject1).getPreferences().getString(localObject2[n] + ".default", "");
          if (((String)localObject3).length() <= 0)
            continue;
          ((ExportModel)localObject1).setPropertyValue(localObject2[n], (String)localObject3);
        }
        ((ExportModel)localObject1).setPropertyValue("submit", "reset");
        ((ExportModel)localObject1).setPropertyValue("success", "successtopage");
        ((ExportModel)localObject1).setPropertyValue("successpage", "list.jsp");
        Iterator localIterator = ((ExportModel)localObject1).getEnvionment().getAllMappingVariable();
        int i1 = 0;
        while (localIterator.hasNext())
        {
          localObject4 = (MappingVariable)localIterator.next();
          if (((ExportModel)localObject1).getPageField(((MappingVariable)localObject4).getVariableName()) != null)
            continue;
          localObject5 = ((ExportModel)localObject1).addMappingVariable((MappingVariable)localObject4);
          if (localHashMap.get(((MappingVariable)localObject4).getValueName()) != null)
          {
            if ((localHashMap.get(((MappingVariable)localObject4).getValueName()) instanceof SelectTable))
            {
              ((PageFieldModel)localObject5).setInputType("select");
              ((PageFieldModel)localObject5).setPropertyValue("p_options", "list" + ((SelectTable)localHashMap.get(((MappingVariable)localObject4).getValueName())).getValueName());
            }
            else
            {
              ((PageFieldModel)localObject5).setInputType("textauto");
              ((PageFieldModel)localObject5).setPropertyValue("sql", (String)localHashMap.get(((MappingVariable)localObject4).getValueName()));
              ((PageFieldModel)localObject5).setPropertyValue("connection", this.c.getDatasourceName());
            }
          }
          else if (((MappingVariable)localObject4).getValueName().equalsIgnoreCase("su"))
          {
            ((PageFieldModel)localObject5).setStatType("success");
            ((PageFieldModel)localObject5).setInputType("notdisplay");
            ((PageFieldModel)localObject5).setResultType("notdisplay");
          }
          else if (((MappingVariable)localObject4).getValueName().equalsIgnoreCase("buttontijiao"))
          {
            ((PageFieldModel)localObject5).setStatType("input");
            ((PageFieldModel)localObject5).setInputType("button");
          }
          else if (((MappingVariable)localObject4).getValueName().equalsIgnoreCase("nID"))
          {
            ((PageFieldModel)localObject5).setInputType("hidden");
          }
          else if (((MappingVariable)localObject4).getValueType().equalsIgnoreCase("list<list>"))
          {
            ((PageFieldModel)localObject5).setStatType("output");
            ((PageFieldModel)localObject5).setResultType("notdisplay");
          }
          a((PageFieldModel)localObject5, ((PageFieldModel)localObject5).getInputType());
          a((PageFieldModel)localObject5, ((PageFieldModel)localObject5).getResultType());
        }
      }
      ((ExportModel)localObject1).setModified(true);
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }

  public void f()
  {
    if (this.b == null)
      return;
    if (d.class.getClassLoader().getResource(this.e + "/edit.rpk") == null)
      return;
    RulePackage localRulePackage;
    try
    {
      localRulePackage = (RulePackage)((RulePackage)new com.flagleader.repository.e.d().load(d.class.getClassLoader().getResourceAsStream(this.e + "/edit.rpk"))).deepClone();
    }
    catch (Exception localException1)
    {
      return;
    }
    localRulePackage.setDisplayName(localRulePackage.getDisplayName() + this.b.getDisplayName());
    localRulePackage.setExeRulePackageName(this.h + ".edit");
    this.d.addChildElement(localRulePackage);
    localRulePackage.setFilePathName("");
    DBModel localDBModel = a(localRulePackage);
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
      TableModel localTableModel = (TableModel)this.b.deepClone();
      List localList = this.c.getFKModels(localTableModel.getTableName());
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      Object localObject7;
      Object localObject9;
      Object localObject10;
      Object localObject11;
      Object localObject12;
      for (int k = 0; k < localList.size(); k++)
      {
        localObject1 = (FKModel)localList.get(k);
        localTableModel.addChildElement((IElement)localObject1);
        if ((((FKModel)localObject1).getKeys().size() != 1) || (!((FKModel)localObject1).getFKTableName().equalsIgnoreCase(localTableModel.getTableName())) || (a(localArrayList, ((FKModel)localObject1).getPkTableName())))
          continue;
        localObject2 = this.c.getTableModel(((FKModel)localObject1).getPkTableName());
        if (localObject2 == null)
          continue;
        localObject4 = ((AdvancedProperty)((FKModel)localObject1).getKeys().get(0)).getKey();
        for (int n = 0; n < ((TableModel)localObject2).getFields().size(); n++)
        {
          if ((!((FieldModel)((TableModel)localObject2).getFields().get(n)).getFieldName().equalsIgnoreCase((String)localObject4)) || (n + 1 >= ((TableModel)localObject2).getFields().size()))
            continue;
          localObject4 = ((FieldModel)((TableModel)localObject2).getFields().get(n + 1)).getFieldName();
          break;
        }
        if (!((TableModel)localObject2).getField(((AdvancedProperty)((FKModel)localObject1).getKeys().get(0)).getKey()).getValueType().equalsIgnoreCase("string"))
        {
          localObject5 = localDBModel.createSelectTable("select " + ((AdvancedProperty)((FKModel)localObject1).getKeys().get(0)).getKey() + "," + (String)localObject4 + " from " + ((TableModel)localObject2).getTableName(), ((FKModel)localObject1).getFKName(), ((FKModel)localObject1).getFKName());
          localObject6 = new MappingVariable("list" + ((FKModel)localObject1).getFKName(), ((FKModel)localObject1).getFKName(), "list<list>", true);
          localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject6);
          localObject7 = (Rule)localRulePackage.createChildNode("Rule");
          localObject8 = ((SelectTable)localObject5).getTableFunction("selectWhere");
          if (localObject8 != null)
          {
            localObject9 = new TableFunctionToken();
            localObject10 = new StatementContainerToken();
            ((Rule)localObject7).getRuleElementToken().getInitActions().addChildElement((IElement)localObject10);
            ((StatementContainerToken)localObject10).addChildElement((IElement)localObject9);
            ((TableFunctionToken)localObject9).setMemberElement((IElement)localObject8);
          }
          localObject8 = ((SelectTable)localObject5).getTableFunction("getListResult");
          if (localObject8 != null)
          {
            localObject9 = new StatementContainerToken();
            ((Rule)localObject7).getRuleElementToken().getThenActions().addChildElement((IElement)localObject9);
            localObject10 = new AssignToken();
            ((StatementContainerToken)localObject9).addChildElement((IElement)localObject10);
            localObject11 = new FieldToken();
            ((AssignToken)localObject10).addChildElement((IElement)localObject11);
            ((AssignToken)localObject10).addChildElement(new AssignJudgeToken());
            if (localObject6 != null)
              ((FieldToken)localObject11).setMemberElement((IElement)localObject6);
            else
              ((AssignToken)localObject10).changeFieldType(((TableFunction)localObject8).getJavaType());
            localObject12 = new TableFunctionToken(((TableFunction)localObject8).getValueType());
            ((AssignToken)localObject10).getComparedValue().addChildElement((IElement)localObject12);
            ((TableFunctionToken)localObject12).setMemberElement((IElement)localObject8);
          }
          ((Rule)localObject7).setModified(true);
          localHashMap.put(((AdvancedProperty)((FKModel)localObject1).getKeys().get(0)).getKey(), localObject5);
        }
        else
        {
          localObject5 = "select " + ((AdvancedProperty)((FKModel)localObject1).getKeys().get(0)).getKey() + "," + (String)localObject4 + " from " + ((TableModel)localObject2).getTableName() + " where " + ((AdvancedProperty)((FKModel)localObject1).getKeys().get(0)).getKey() + " like '?%'";
          localHashMap.put(((AdvancedProperty)((FKModel)localObject1).getKeys().get(0)).getKey(), localObject5);
        }
        localArrayList.add(localObject2);
      }
      localDBModel.addChildElement(localTableModel);
      localDBModel.updateTableModel(localTableModel);
      Rule localRule = (Rule)localRuleSet1.createChildNode("Rule");
      localRule.setSupportInit(true);
      localRule.getRuleElementToken().getThenActions();
      Object localObject1 = localTableModel.getTableFunction("select");
      if (localObject1 != null)
      {
        localObject2 = new TableFunctionToken();
        localObject4 = new StatementContainerToken();
        localRule.getRuleElementToken().getInitActions().addChildElement((IElement)localObject4);
        ((StatementContainerToken)localObject4).addChildElement((IElement)localObject2);
        ((TableFunctionToken)localObject2).setMemberElement((IElement)localObject1);
      }
      localObject1 = localTableModel.getTableFunction("next");
      if (localObject1 != null)
      {
        localObject2 = new ConditionToken();
        ((ConditionToken)localObject2).init();
        localRule.getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject2);
        localObject4 = (MemberToken)((ConditionToken)localObject2).getFirstValue();
        ((MemberToken)localObject4).setMemberElement((IElement)localObject1);
        ((ConditionToken)localObject2).addChildElement(new BooleanJudgeToken());
      }
      for (int m = 0; m < localTableModel.getPrimaryKeys().size(); m++)
      {
        localObject4 = (FieldModel)localTableModel.getPrimaryKeys().get(m);
        localObject1 = localTableModel.getFieldSetFunc((FieldModel)localObject4);
        if (localObject1 == null)
          continue;
        localObject5 = new TableFunctionToken();
        localObject6 = new StatementContainerToken();
        localRule.getRuleElementToken().getInitActions().addChildElement((IElement)localObject6, 0);
        ((StatementContainerToken)localObject6).addChildElement((IElement)localObject5);
        ((TableFunctionToken)localObject5).setMemberElement((IElement)localObject1);
        localObject7 = (ValueToken)((TableFunctionToken)localObject5).getValueTokens().get(0);
        localObject8 = new MemberToken(((ValueToken)localObject7).getValueType());
        ((ValueToken)localObject7).addChildElement((IElement)localObject8);
        ((MemberToken)localObject8).setMemberElement(localSubVariable);
        localObject7 = (ValueToken)((MemberToken)localObject8).getValueTokens().get(0);
        localObject9 = new ConstantToken("string");
        ((ValueToken)localObject7).addChildElement((IElement)localObject9);
        ((ConstantToken)localObject9).setValue("_");
        localObject7 = (ValueToken)((MemberToken)localObject8).getValueTokens().get(1);
        localObject9 = new ConstantToken("int");
        ((ValueToken)localObject7).addChildElement((IElement)localObject9);
        ((ConstantToken)localObject9).setValue(String.valueOf(m));
      }
      for (m = 0; m < localTableModel.getFields().size(); m++)
      {
        localObject4 = (FieldModel)localTableModel.getFields().get(m);
        localObject5 = localRulePackage.getEnvionment().getValueLibrary().getVariable(((FieldModel)localObject4).getFieldName());
        if (localObject5 == null)
        {
          localObject5 = new MappingVariable((FieldModel)localObject4);
          ((MappingVariable)localObject5).setVisible(true);
          if (((MappingVariable)localObject5).getValueType().equalsIgnoreCase("datetime"))
            ((MappingVariable)localObject5).setValueType("date");
          localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject5);
        }
        if ((((FieldModel)localObject4).isAutoIncrement()) || (((FieldModel)localObject4).isReadOnly()))
          continue;
        localObject1 = localTableModel.getFieldSetFunc((FieldModel)localObject4);
        if (localObject1 == null)
          continue;
        localObject6 = new TableFunctionToken();
        localObject7 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject7, 0);
        ((StatementContainerToken)localObject7).addChildElement((IElement)localObject6);
        ((TableFunctionToken)localObject6).setMemberElement((IElement)localObject1);
        localObject8 = (ValueToken)((TableFunctionToken)localObject6).getValueTokens().get(0);
        localObject9 = new MemberToken(((ValueToken)localObject8).getValueType());
        ((ValueToken)localObject8).addChildElement((IElement)localObject9);
        if (localObject5 != null)
          ((MemberToken)localObject9).setMemberElement((IElement)localObject5);
        localRule.setModified(true);
      }
      localObject1 = localTableModel.getTableFunction("update");
      if (localObject1 != null)
      {
        localObject3 = new TableFunctionToken();
        localObject4 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject4);
        ((StatementContainerToken)localObject4).addChildElement((IElement)localObject3);
        ((TableFunctionToken)localObject3).setMemberElement((IElement)localObject1);
      }
      Object localObject3 = new StatementContainerToken();
      localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject3);
      Object localObject4 = new AssignToken();
      ((StatementContainerToken)localObject3).addChildElement((IElement)localObject4);
      Object localObject5 = new FieldToken();
      ((AssignToken)localObject4).addChildElement((IElement)localObject5);
      ((AssignToken)localObject4).addChildElement(new AssignJudgeToken());
      ((FieldToken)localObject5).setMemberElement(localMappingVariable2);
      Object localObject6 = new ConstantToken(localMappingVariable2.getValueType());
      ((AssignToken)localObject4).getComparedValue().addChildElement((IElement)localObject6);
      ((ConstantToken)localObject6).setValue("success!");
      localRule.setModified(true);
      localRule = (Rule)localRuleSet2.createChildNode("Rule");
      localRule.setSupportInit(true);
      localRule.getRuleElementToken().getThenActions();
      localObject1 = localTableModel.getTableFunction("select");
      if (localObject1 != null)
      {
        localObject7 = new TableFunctionToken();
        localObject3 = new StatementContainerToken();
        localRule.getRuleElementToken().getInitActions().addChildElement((IElement)localObject3);
        ((StatementContainerToken)localObject3).addChildElement((IElement)localObject7);
        ((TableFunctionToken)localObject7).setMemberElement((IElement)localObject1);
      }
      localObject1 = localTableModel.getTableFunction("next");
      if (localObject1 != null)
      {
        localObject7 = new ConditionToken();
        ((ConditionToken)localObject7).init();
        localRule.getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject7);
        localObject8 = (MemberToken)((ConditionToken)localObject7).getFirstValue();
        ((MemberToken)localObject8).setMemberElement((IElement)localObject1);
        ((ConditionToken)localObject7).addChildElement(new BooleanJudgeToken());
      }
      for (int i1 = 0; i1 < localTableModel.getPrimaryKeys().size(); i1++)
      {
        localObject8 = (FieldModel)localTableModel.getPrimaryKeys().get(i1);
        localObject1 = localTableModel.getFieldSetFunc((FieldModel)localObject8);
        if (localObject1 == null)
          continue;
        localObject9 = new TableFunctionToken();
        localObject3 = new StatementContainerToken();
        localRule.getRuleElementToken().getInitActions().addChildElement((IElement)localObject3, 0);
        ((StatementContainerToken)localObject3).addChildElement((IElement)localObject9);
        ((TableFunctionToken)localObject9).setMemberElement((IElement)localObject1);
        localObject10 = (ValueToken)((TableFunctionToken)localObject9).getValueTokens().get(0);
        localObject11 = new MemberToken(((ValueToken)localObject10).getValueType());
        ((ValueToken)localObject10).addChildElement((IElement)localObject11);
        ((MemberToken)localObject11).setMemberElement(localSubVariable);
        localObject10 = (ValueToken)((MemberToken)localObject11).getValueTokens().get(0);
        localObject12 = new ConstantToken("string");
        ((ValueToken)localObject10).addChildElement((IElement)localObject12);
        ((ConstantToken)localObject12).setValue("_");
        localObject10 = (ValueToken)((MemberToken)localObject11).getValueTokens().get(1);
        localObject12 = new ConstantToken("int");
        ((ValueToken)localObject10).addChildElement((IElement)localObject12);
        ((ConstantToken)localObject12).setValue(String.valueOf(i1));
      }
      for (i1 = 0; i1 < localTableModel.getFields().size(); i1++)
      {
        localObject8 = (FieldModel)localTableModel.getFields().get(i1);
        localObject9 = localRulePackage.getEnvionment().getValueLibrary().getVariable(((FieldModel)localObject8).getFieldName());
        if (localObject9 == null)
        {
          localObject9 = new MappingVariable((FieldModel)localObject8);
          ((MappingVariable)localObject9).setVisible(true);
          if (((MappingVariable)localObject9).getValueType().equalsIgnoreCase("datetime"))
            ((MappingVariable)localObject9).setValueType("date");
          localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject9);
        }
        localObject1 = localTableModel.getFieldGetFunc((FieldModel)localObject8);
        if (localObject1 == null)
          continue;
        localObject3 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject3, 0);
        localObject4 = new AssignToken();
        ((StatementContainerToken)localObject3).addChildElement((IElement)localObject4);
        localObject5 = new FieldToken();
        ((AssignToken)localObject4).addChildElement((IElement)localObject5);
        ((AssignToken)localObject4).addChildElement(new AssignJudgeToken());
        if (localObject9 != null)
          ((FieldToken)localObject5).setMemberElement((IElement)localObject9);
        else
          ((AssignToken)localObject4).changeFieldType(((TableFunction)localObject1).getJavaType());
        localObject10 = new TableFunctionToken(((TableFunction)localObject1).getValueType());
        ((AssignToken)localObject4).getComparedValue().addChildElement((IElement)localObject10);
        ((TableFunctionToken)localObject10).setMemberElement((IElement)localObject1);
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
        localObject8 = new String[0];
        if (localExportModel.getImportFile().length() > 0)
          localObject8 = localExportModel.getPreferences().getStringArray(localExportModel.getImportFile() + ".props");
        if (localObject8 == null)
          localObject8 = localExportModel.getPreferences().getStringArray("export.props");
        for (i2 = 0; i2 < localObject8.length; i2++)
        {
          localObject10 = localExportModel.getPreferences().getString(localObject8[i2] + ".default", "");
          if (((String)localObject10).length() <= 0)
            continue;
          localExportModel.setPropertyValue(localObject8[i2], (String)localObject10);
        }
        localExportModel.setPropertyValue("submit", "reset");
        localExportModel.setPropertyValue("success", "successtopage");
        localExportModel.setPropertyValue("successpage", "list.jsp");
      }
      Object localObject8 = localExportModel.getEnvionment().getAllMappingVariable();
      int i2 = 0;
      while (((Iterator)localObject8).hasNext())
      {
        localObject10 = (MappingVariable)((Iterator)localObject8).next();
        if (localExportModel.getPageField(((MappingVariable)localObject10).getVariableName()) != null)
          continue;
        localObject11 = localExportModel.addMappingVariable((MappingVariable)localObject10);
        if (localHashMap.get(((MappingVariable)localObject10).getValueName()) != null)
        {
          if ((localHashMap.get(((MappingVariable)localObject10).getValueName()) instanceof SelectTable))
          {
            ((PageFieldModel)localObject11).setInputType("select");
            ((PageFieldModel)localObject11).setPropertyValue("p_options", "list" + ((SelectTable)localHashMap.get(((MappingVariable)localObject10).getValueName())).getValueName());
          }
          else
          {
            ((PageFieldModel)localObject11).setInputType("textauto");
            ((PageFieldModel)localObject11).setPropertyValue("sql", (String)localHashMap.get(((MappingVariable)localObject10).getValueName()));
            ((PageFieldModel)localObject11).setPropertyValue("connection", this.c.getDatasourceName());
          }
        }
        else if (((MappingVariable)localObject10).getValueName().equalsIgnoreCase("su"))
        {
          ((PageFieldModel)localObject11).setStatType("success");
          ((PageFieldModel)localObject11).setInputType("notdisplay");
          ((PageFieldModel)localObject11).setResultType("notdisplay");
        }
        else if (((MappingVariable)localObject10).getValueName().equalsIgnoreCase("buttontijiao"))
        {
          ((PageFieldModel)localObject11).setStatType("input");
          ((PageFieldModel)localObject11).setInputType("button");
        }
        else if (((MappingVariable)localObject10).getValueName().equalsIgnoreCase("nID"))
        {
          ((PageFieldModel)localObject11).setInputType("hidden");
        }
        else if (((MappingVariable)localObject10).getValueType().equalsIgnoreCase("list<list>"))
        {
          ((PageFieldModel)localObject11).setStatType("output");
          ((PageFieldModel)localObject11).setResultType("notdisplay");
        }
        localObject12 = localTableModel.getField(((MappingVariable)localObject10).getValueName());
        if (localObject12 != null)
        {
          if (((FieldModel)localObject12).isUnNull())
            ((PageFieldModel)localObject11).setNullType("notnull");
          if (!StringUtil.isEmpty(((FieldModel)localObject12).getDefaultValue()))
            ((PageFieldModel)localObject11).setPropertyValue("default", ((FieldModel)localObject12).getDefaultValue());
          if ((((FieldModel)localObject12).isReadOnly()) || (((FieldModel)localObject12).isAutoIncrement()))
            ((PageFieldModel)localObject11).setNullType("readonly");
          if (((FieldModel)localObject12).getAdvanceProperties().length > 0)
          {
            ((PageFieldModel)localObject11).setInputType("select");
            for (int i3 = 0; i3 < ((FieldModel)localObject12).getAdvanceProperties().length; i3++)
              ((PageFieldModel)localObject11).setPropertyValue("o_" + localObject12.getAdvanceProperties()[i3].getKey(), localObject12.getAdvanceProperties()[i3].getProperty());
          }
        }
        a((PageFieldModel)localObject11, ((PageFieldModel)localObject11).getInputType());
        a((PageFieldModel)localObject11, ((PageFieldModel)localObject11).getResultType());
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
    if (this.b == null)
      return;
    if (d.class.getClassLoader().getResource(this.e + "/add.rpk") == null)
      return;
    RulePackage localRulePackage;
    try
    {
      localRulePackage = (RulePackage)((RulePackage)new com.flagleader.repository.e.d().load(d.class.getClassLoader().getResourceAsStream(this.e + "/add.rpk"))).deepClone();
    }
    catch (Exception localException1)
    {
      return;
    }
    localRulePackage.setDisplayName(localRulePackage.getDisplayName() + this.b.getDisplayName());
    localRulePackage.setExeRulePackageName(this.h + ".add");
    this.d.addChildElement(localRulePackage);
    localRulePackage.setFilePathName("");
    DBModel localDBModel = a(localRulePackage);
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
      TableModel localTableModel1 = (TableModel)this.b.deepClone();
      List localList = this.c.getFKModels(localTableModel1.getTableName());
      ArrayList localArrayList = new ArrayList();
      Object localObject6;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      Object localObject11;
      for (int k = 0; k < localList.size(); k++)
      {
        localObject1 = (FKModel)localList.get(k);
        localTableModel1.addChildElement((IElement)localObject1);
        if ((((FKModel)localObject1).getKeys().size() != 1) || (!((FKModel)localObject1).getFKTableName().equalsIgnoreCase(localTableModel1.getTableName())) || (a(localArrayList, ((FKModel)localObject1).getPkTableName())))
          continue;
        TableModel localTableModel2 = this.c.getTableModel(((FKModel)localObject1).getPkTableName());
        if (localTableModel2 == null)
          continue;
        localObject3 = ((AdvancedProperty)((FKModel)localObject1).getKeys().get(0)).getKey();
        for (int n = 0; n < localTableModel2.getFields().size(); n++)
        {
          if ((!((FieldModel)localTableModel2.getFields().get(n)).getFieldName().equalsIgnoreCase((String)localObject3)) || (n + 1 >= localTableModel2.getFields().size()))
            continue;
          localObject3 = ((FieldModel)localTableModel2.getFields().get(n + 1)).getFieldName();
          break;
        }
        if (!localTableModel2.getField(((AdvancedProperty)((FKModel)localObject1).getKeys().get(0)).getKey()).getValueType().equalsIgnoreCase("string"))
        {
          localObject4 = localDBModel.createSelectTable("select " + ((AdvancedProperty)((FKModel)localObject1).getKeys().get(0)).getKey() + "," + (String)localObject3 + " from " + localTableModel2.getTableName(), ((FKModel)localObject1).getFKName(), ((FKModel)localObject1).getFKName());
          localObject5 = new MappingVariable("list" + ((FKModel)localObject1).getFKName(), ((FKModel)localObject1).getFKName(), "list<list>", true);
          localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject5);
          localObject6 = (Rule)localRulePackage.createChildNode("Rule");
          localObject7 = ((SelectTable)localObject4).getTableFunction("selectWhere");
          if (localObject7 != null)
          {
            localObject8 = new TableFunctionToken();
            localObject9 = new StatementContainerToken();
            ((Rule)localObject6).getRuleElementToken().getInitActions().addChildElement((IElement)localObject9);
            ((StatementContainerToken)localObject9).addChildElement((IElement)localObject8);
            ((TableFunctionToken)localObject8).setMemberElement((IElement)localObject7);
          }
          localObject7 = ((SelectTable)localObject4).getTableFunction("getListResult");
          if (localObject7 != null)
          {
            localObject8 = new StatementContainerToken();
            ((Rule)localObject6).getRuleElementToken().getThenActions().addChildElement((IElement)localObject8);
            localObject9 = new AssignToken();
            ((StatementContainerToken)localObject8).addChildElement((IElement)localObject9);
            localObject10 = new FieldToken();
            ((AssignToken)localObject9).addChildElement((IElement)localObject10);
            ((AssignToken)localObject9).addChildElement(new AssignJudgeToken());
            if (localObject5 != null)
              ((FieldToken)localObject10).setMemberElement((IElement)localObject5);
            else
              ((AssignToken)localObject9).changeFieldType(((TableFunction)localObject7).getJavaType());
            localObject11 = new TableFunctionToken(((TableFunction)localObject7).getValueType());
            ((AssignToken)localObject9).getComparedValue().addChildElement((IElement)localObject11);
            ((TableFunctionToken)localObject11).setMemberElement((IElement)localObject7);
          }
          ((Rule)localObject6).setModified(true);
          localHashMap.put(((AdvancedProperty)((FKModel)localObject1).getKeys().get(0)).getKey(), localObject4);
        }
        else
        {
          localObject4 = "select " + ((AdvancedProperty)((FKModel)localObject1).getKeys().get(0)).getKey() + "," + (String)localObject3 + " from " + localTableModel2.getTableName() + " where " + ((AdvancedProperty)((FKModel)localObject1).getKeys().get(0)).getKey() + " like '?%'";
          localHashMap.put(((AdvancedProperty)((FKModel)localObject1).getKeys().get(0)).getKey(), localObject4);
        }
        localArrayList.add(localTableModel2);
      }
      localDBModel.addChildElement(localTableModel1);
      localDBModel.updateTableModel(localTableModel1);
      Rule localRule = (Rule)localRuleSet.createChildNode("Rule");
      Object localObject1 = null;
      for (int m = 0; m < localTableModel1.getFields().size(); m++)
      {
        localObject3 = (FieldModel)localTableModel1.getFields().get(m);
        localObject4 = localRulePackage.getEnvionment().getValueLibrary().getVariable(((FieldModel)localObject3).getFieldName());
        if (localObject4 == null)
        {
          localObject4 = new MappingVariable((FieldModel)localObject3);
          ((MappingVariable)localObject4).setVisible(false);
          if (((MappingVariable)localObject4).getValueType().equalsIgnoreCase("datetime"))
            ((MappingVariable)localObject4).setValueType("date");
          localRulePackage.getEnvionment().getValueLibrary().addChildElement((IElement)localObject4);
        }
        if ((!((FieldModel)localObject3).isAutoIncrement()) && (!((FieldModel)localObject3).isReadOnly()))
        {
          ((MappingVariable)localObject4).setVisible(true);
          localObject5 = localTableModel1.getFieldSetFunc((FieldModel)localObject3);
          if (localObject5 == null)
            continue;
          localObject6 = new TableFunctionToken();
          localObject7 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject7, 0);
          ((StatementContainerToken)localObject7).addChildElement((IElement)localObject6);
          ((TableFunctionToken)localObject6).setMemberElement((IElement)localObject5);
          localObject8 = (ValueToken)((TableFunctionToken)localObject6).getValueTokens().get(0);
          localObject9 = new MemberToken(((ValueToken)localObject8).getValueType());
          ((ValueToken)localObject8).addChildElement((IElement)localObject9);
          if (localObject4 != null)
            ((MemberToken)localObject9).setMemberElement((IElement)localObject4);
          localRule.setModified(true);
        }
        else
        {
          if (!((FieldModel)localObject3).isAutoIncrement())
            continue;
          localObject1 = localObject3;
        }
      }
      if (localObject1 == null)
      {
        localObject2 = localTableModel1.getTableFunction("insert");
        if (localObject2 != null)
        {
          localObject3 = new TableFunctionToken();
          localObject4 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject4);
          ((StatementContainerToken)localObject4).addChildElement((IElement)localObject3);
          ((TableFunctionToken)localObject3).setMemberElement((IElement)localObject2);
        }
      }
      else
      {
        localObject2 = localTableModel1.getTableFunction("insertAndGeneratedKey");
        if (localObject2 != null)
        {
          localObject3 = new TableFunctionToken();
          localObject4 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject4);
          ((StatementContainerToken)localObject4).addChildElement((IElement)localObject3);
          ((TableFunctionToken)localObject3).setMemberElement((IElement)localObject2);
        }
        localObject3 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject3);
        localObject4 = new AssignToken();
        ((StatementContainerToken)localObject3).addChildElement((IElement)localObject4);
        localObject5 = new FieldToken();
        ((AssignToken)localObject4).addChildElement((IElement)localObject5);
        ((AssignToken)localObject4).addChildElement(new AssignJudgeToken());
        if (localRulePackage.getEnvionment().getValueLibrary().getVariable(((FieldModel)localObject1).getFieldName()) != null)
          ((FieldToken)localObject5).setMemberElement(localRulePackage.getEnvionment().getValueLibrary().getVariable(((FieldModel)localObject1).getFieldName()));
        else
          ((AssignToken)localObject4).changeFieldType(((TableFunction)localObject2).getJavaType());
        localObject6 = new TableFunctionToken(((TableFunction)localObject2).getValueType());
        ((AssignToken)localObject4).getComparedValue().addChildElement((IElement)localObject6);
        ((TableFunctionToken)localObject6).setMemberElement(localTableModel1.getFieldGetFunc((FieldModel)localObject1));
      }
      Object localObject2 = new StatementContainerToken();
      localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject2);
      Object localObject3 = new AssignToken();
      ((StatementContainerToken)localObject2).addChildElement((IElement)localObject3);
      Object localObject4 = new FieldToken();
      ((AssignToken)localObject3).addChildElement((IElement)localObject4);
      ((AssignToken)localObject3).addChildElement(new AssignJudgeToken());
      ((FieldToken)localObject4).setMemberElement(localMappingVariable2);
      Object localObject5 = new ConstantToken(localMappingVariable2.getValueType());
      ((AssignToken)localObject3).getComparedValue().addChildElement((IElement)localObject5);
      ((ConstantToken)localObject5).setValue("success!");
      localRule.setModified(true);
      if (localRulePackage.getExportModels().hasNext())
      {
        localObject6 = (ExportModel)localRulePackage.getExportModels().next();
        ((ExportModel)localObject6).setDisplayName(localRulePackage.getExeRulePackageName().replace('.', '/') + ".jsp");
      }
      else
      {
        localObject6 = (ExportModel)localRulePackage.createChildNode("ExportModel");
        ((ExportModel)localObject6).setDisplayName(localRulePackage.getExeRulePackageName().replace('.', '/') + ".jsp");
        ((ExportModel)localObject6).setImportFile("standard/page_input.rsp");
        localObject7 = new String[0];
        if (((ExportModel)localObject6).getImportFile().length() > 0)
          localObject7 = ((ExportModel)localObject6).getPreferences().getStringArray(((ExportModel)localObject6).getImportFile() + ".props");
        if (localObject7 == null)
          localObject7 = ((ExportModel)localObject6).getPreferences().getStringArray("export.props");
        for (i1 = 0; i1 < localObject7.length; i1++)
        {
          localObject9 = ((ExportModel)localObject6).getPreferences().getString(localObject7[i1] + ".default", "");
          if (((String)localObject9).length() <= 0)
            continue;
          ((ExportModel)localObject6).setPropertyValue(localObject7[i1], (String)localObject9);
        }
        ((ExportModel)localObject6).setPropertyValue("submit", "reset");
        ((ExportModel)localObject6).setPropertyValue("success", "successtopage");
        ((ExportModel)localObject6).setPropertyValue("successpage", "list.jsp");
      }
      Object localObject7 = ((ExportModel)localObject6).getEnvionment().getAllMappingVariable();
      int i1 = 0;
      while (((Iterator)localObject7).hasNext())
      {
        localObject9 = (MappingVariable)((Iterator)localObject7).next();
        if (((ExportModel)localObject6).getPageField(((MappingVariable)localObject9).getVariableName()) != null)
          continue;
        localObject10 = ((ExportModel)localObject6).addMappingVariable((MappingVariable)localObject9);
        if (localHashMap.get(((MappingVariable)localObject9).getValueName()) != null)
        {
          if ((localHashMap.get(((MappingVariable)localObject9).getValueName()) instanceof SelectTable))
          {
            ((PageFieldModel)localObject10).setInputType("select");
            ((PageFieldModel)localObject10).setPropertyValue("p_options", "list" + ((SelectTable)localHashMap.get(((MappingVariable)localObject9).getValueName())).getValueName());
          }
          else
          {
            ((PageFieldModel)localObject10).setInputType("textauto");
            ((PageFieldModel)localObject10).setPropertyValue("sql", (String)localHashMap.get(((MappingVariable)localObject9).getValueName()));
            ((PageFieldModel)localObject10).setPropertyValue("connection", this.c.getDatasourceName());
          }
        }
        else if (((MappingVariable)localObject9).getValueName().equalsIgnoreCase("su"))
        {
          ((PageFieldModel)localObject10).setStatType("success");
          ((PageFieldModel)localObject10).setInputType("notdisplay");
          ((PageFieldModel)localObject10).setResultType("notdisplay");
        }
        else if (((MappingVariable)localObject9).getValueName().equalsIgnoreCase("buttontijiao"))
        {
          ((PageFieldModel)localObject10).setStatType("input");
          ((PageFieldModel)localObject10).setInputType("button");
        }
        else if (((MappingVariable)localObject9).getValueType().equalsIgnoreCase("list<list>"))
        {
          ((PageFieldModel)localObject10).setStatType("output");
          ((PageFieldModel)localObject10).setResultType("notdisplay");
        }
        localObject11 = localTableModel1.getField(((MappingVariable)localObject9).getValueName());
        if (localObject11 != null)
        {
          if (((FieldModel)localObject11).isUnNull())
            ((PageFieldModel)localObject10).setNullType("notnull");
          if (!StringUtil.isEmpty(((FieldModel)localObject11).getDefaultValue()))
            ((PageFieldModel)localObject10).setPropertyValue("default", ((FieldModel)localObject11).getDefaultValue());
          if (((FieldModel)localObject11).getAdvanceProperties().length > 0)
          {
            ((PageFieldModel)localObject10).setInputType("select");
            for (int i2 = 0; i2 < ((FieldModel)localObject11).getAdvanceProperties().length; i2++)
              ((PageFieldModel)localObject10).setPropertyValue("o_" + localObject11.getAdvanceProperties()[i2].getKey(), localObject11.getAdvanceProperties()[i2].getProperty());
          }
        }
        a((PageFieldModel)localObject10, ((PageFieldModel)localObject10).getInputType());
        a((PageFieldModel)localObject10, ((PageFieldModel)localObject10).getResultType());
      }
      ((ExportModel)localObject6).setModified(true);
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }

  public static void a(ExportModel paramExportModel, PageFieldModel paramPageFieldModel)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    String[] arrayOfString1 = paramPageFieldModel.getPageTypes();
    for (int k = 0; k < arrayOfString1.length; k++)
    {
      String[] arrayOfString3 = paramExportModel.getPreferences().getStringArray(arrayOfString1[k] + ".prop");
      if ((arrayOfString3 == null) || (arrayOfString3.length <= 0))
        continue;
      for (int i1 = 0; i1 < arrayOfString3.length; i1++)
      {
        if (localHashMap.get(arrayOfString3[i1]) != null)
          continue;
        localHashMap.put(arrayOfString3[i1], arrayOfString3[i1]);
        localArrayList.add(arrayOfString3[i1]);
      }
    }
    String[] arrayOfString2;
    if ((paramPageFieldModel.getParent() instanceof IPage))
    {
      if (paramExportModel.getPreferences().getStringArray(((IPage)paramPageFieldModel.getParent()).getImportFile() + ".fprops") != null)
      {
        arrayOfString2 = paramExportModel.getPreferences().getStringArray(((IPage)paramPageFieldModel.getParent()).getImportFile() + ".fprops");
        for (int n = 0; n < arrayOfString2.length; n++)
        {
          if ((localHashMap.get(arrayOfString2[n]) != null) || (arrayOfString2[n].endsWith("_")))
            continue;
          localHashMap.put(arrayOfString2[n], arrayOfString2[n]);
          localArrayList.add(arrayOfString2[n]);
        }
      }
    }
    else if ((paramPageFieldModel.getParent() instanceof PageFieldModel))
    {
      arrayOfString2 = (String[])null;
      PageFieldModel localPageFieldModel = (PageFieldModel)paramPageFieldModel.getParent();
      if (paramExportModel.getPreferences().getStringArray(localPageFieldModel.getInputType() + ".fprops") != null)
        arrayOfString2 = paramExportModel.getPreferences().getStringArray(localPageFieldModel.getInputType() + ".fprops");
      else if (paramExportModel.getPreferences().getStringArray(localPageFieldModel.getResultType() + ".fprops") != null)
        arrayOfString2 = paramExportModel.getPreferences().getStringArray(localPageFieldModel.getResultType() + ".fprops");
      a(arrayOfString2, localHashMap, localArrayList);
    }
    a(paramExportModel.getPreferences().getStringArray("field.fprops"), localHashMap, localArrayList);
    if (localArrayList.size() > 0)
      for (int m = 0; m < localArrayList.size(); m++)
      {
        if ((paramPageFieldModel.getProperty(localArrayList.get(m).toString()) != null) || (paramExportModel.getPreferences().getString(localArrayList.get(m).toString() + ".defaultvalue", "").length() <= 0))
          continue;
        paramPageFieldModel.setPropertyValue(localArrayList.get(m).toString(), paramExportModel.getPreferences().getString(localArrayList.get(m).toString() + ".defaultvalue", ""));
      }
  }

  private static void a(String[] paramArrayOfString, HashMap paramHashMap, ArrayList paramArrayList)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
      for (int k = 0; k < paramArrayOfString.length; k++)
      {
        if ((paramHashMap.get(paramArrayOfString[k]) != null) || (paramArrayOfString[k].endsWith("_")))
          continue;
        paramHashMap.put(paramArrayOfString[k], paramArrayOfString[k]);
        paramArrayList.add(paramArrayOfString[k]);
      }
  }

  public static void a(PageFieldModel paramPageFieldModel, String paramString)
  {
    String[] arrayOfString = paramPageFieldModel.getPage().getPreferences().getStringArray(paramString + ".prop");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
      for (int k = 0; k < arrayOfString.length; k++)
      {
        if (!paramPageFieldModel.isEmptyProp(arrayOfString[k]))
          continue;
        paramPageFieldModel.setPropertyValue(arrayOfString[k], paramPageFieldModel.getPage().getPreferences().getString(arrayOfString[k] + ".defaultvalue", ""));
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.g.d
 * JD-Core Version:    0.6.0
 */