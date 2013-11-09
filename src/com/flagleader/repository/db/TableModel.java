package com.flagleader.repository.db;

import com.flagleader.database.ConnectionInfo;
import com.flagleader.database.SQLColumn;
import com.flagleader.database.SQLFriendKey;
import com.flagleader.database.SQLIndex;
import com.flagleader.database.SQLTable;
import com.flagleader.database.SchemaUtil;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.sql.DBException;
import com.flagleader.sql.RuleField;
import com.flagleader.sql.RuleKey;
import com.flagleader.sql.RuleTable;
import com.flagleader.util.EngineLogger;
import com.flagleader.util.StringUtil;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TableModel extends AbstractTableModel
{
  private String tableName = "";
  public static final String NAME = "TableModel";
  private String shortTableName = "";
  private String varName = "";
  private boolean accessMode = false;
  protected int b = 0;

  public TableModel(TableModel paramTableModel)
  {
    super(paramTableModel);
    this.tableName = paramTableModel.tableName;
    this.shortTableName = paramTableModel.shortTableName;
    this.varName = paramTableModel.getVarName();
    this.b = paramTableModel.b;
  }

  public TableModel()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitTableModel(this);
  }

  public String[] getPrimaryNames()
  {
    List localList = getPrimaryKeys();
    String[] arrayOfString = new String[localList.size()];
    for (int i = 0; i < localList.size(); i++)
      arrayOfString[i] = ((FieldModel)localList.get(i)).getFieldName();
    return arrayOfString;
  }

  public List getPrimaryKeys()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if ((!(a().get(i) instanceof FieldModel)) || (!((FieldModel)a().get(i)).isPrimaryKey()))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public List getForeignKeys()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if ((!(a().get(i) instanceof FieldModel)) || (!((FieldModel)a().get(i)).isFriendKey()))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public IndexModel getIndexModel(String paramString)
  {
    List localList = getIndexs();
    for (int i = 0; i < localList.size(); i++)
    {
      IndexModel localIndexModel = (IndexModel)localList.get(i);
      if (localIndexModel.getIndexName().equalsIgnoreCase(paramString))
        return localIndexModel;
    }
    return null;
  }

  public List getIndexs()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof IndexModel))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public FKModel getFKModel(String paramString)
  {
    List localList = getFKModels();
    for (int i = 0; i < localList.size(); i++)
    {
      FKModel localFKModel = (FKModel)localList.get(i);
      if (localFKModel.getFKName().equalsIgnoreCase(paramString))
        return localFKModel;
    }
    return null;
  }

  public List getFKModels()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof FKModel))
        continue;
      localArrayList.add(a().get(i));
    }
    if (getDBModel() != null)
      localArrayList.addAll(getDBModel().getFKModels(this.tableName));
    return localArrayList;
  }

  public String getShortTableName()
  {
    return this.shortTableName.toLowerCase();
  }

  public String getTableName()
  {
    return this.tableName;
  }

  public void setShortTableName(String paramString)
  {
    this.shortTableName = paramString;
  }

  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }

  public String toString()
  {
    return this.tableName;
  }

  public String getName()
  {
    return "TableModel";
  }

  public IElement deepClone()
  {
    return new TableModel(this);
  }

  public String getDisplayName()
  {
    if (super.getDisplayName().length() == 0)
      return getTableName();
    return super.getDisplayName();
  }

  private boolean a(FieldModel paramFieldModel, List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
      if (((SQLColumn)paramList.get(i)).getName().equalsIgnoreCase(paramFieldModel.getFieldName()))
        return true;
    return false;
  }

  public void disposeField(FieldModel paramFieldModel)
  {
    if (getFieldGetFunc(paramFieldModel) != null)
      getFieldGetFunc(paramFieldModel).dispose();
    if (getFieldSetFunc(paramFieldModel) != null)
      getFieldSetFunc(paramFieldModel).dispose();
    paramFieldModel.dispose();
    List localList = getFields();
    for (int i = 0; i < localList.size(); i++)
      a((FieldModel)localList.get(i));
  }

  public boolean refresh()
  {
    if (getDBModel() != null)
    {
      getDBModel().updateTableModel(this);
      return true;
    }
    return false;
  }

  public void update(SQLTable paramSQLTable)
  {
    String str1 = paramSQLTable.getName();
    String str2 = null;
    int i = str1.lastIndexOf(".");
    if (i == -1)
      str2 = str1;
    else
      str2 = str1.substring(i + 1);
    setTableName(str1);
    setShortTableName(str2);
    updateFunction();
    List localList1 = paramSQLTable.getColumns();
    ArrayList localArrayList = new ArrayList();
    FieldModel localFieldModel;
    for (int j = 0; j < localList1.size(); j++)
    {
      SQLColumn localSQLColumn = (SQLColumn)localList1.get(j);
      localFieldModel = getField(localSQLColumn.getName());
      if (localFieldModel == null)
      {
        localFieldModel = new FieldModel();
        localFieldModel.setParent(this);
      }
      localArrayList.add(localFieldModel);
      localFieldModel.update(localSQLColumn);
    }
    List localList2 = getFields();
    for (int k = 0; k < localList2.size(); k++)
    {
      localFieldModel = (FieldModel)localList2.get(k);
      if (!a(localFieldModel, localList1))
      {
        if (getFieldGetFunc(localFieldModel) != null)
          getFieldGetFunc(localFieldModel).dispose();
        if (getFieldSetFunc(localFieldModel) != null)
          getFieldSetFunc(localFieldModel).dispose();
      }
      removeChildElement(localFieldModel);
    }
    for (k = 0; k < localArrayList.size(); k++)
      addChildElement((FieldModel)localArrayList.get(k));
    localList2 = getFields();
    for (k = 0; k < localList2.size(); k++)
      a((FieldModel)localList2.get(k));
    List localList3 = paramSQLTable.getIndices();
    Object localObject1;
    Object localObject2;
    for (int m = 0; m < localList3.size(); m++)
    {
      SQLIndex localSQLIndex = (SQLIndex)localList3.get(m);
      localObject1 = localSQLIndex.getName();
      localObject2 = getIndexModel((String)localObject1);
      if (localObject2 == null)
      {
        localObject2 = new IndexModel();
        addChildElement((IElement)localObject2);
      }
      ((IndexModel)localObject2).update(localSQLIndex);
    }
    List localList4 = paramSQLTable.getForeignKeys();
    for (int n = 0; n < localList4.size(); n++)
    {
      localObject1 = (SQLFriendKey)localList4.get(n);
      localObject2 = getFKModel(((SQLFriendKey)localObject1).getFKName());
      if (localObject2 == null)
      {
        localObject2 = new FKModel(((SQLFriendKey)localObject1).getPKTableName(), ((SQLFriendKey)localObject1).getFKTableName());
        ((FKModel)localObject2).setFKName(((SQLFriendKey)localObject1).getFKName());
        ((FKModel)localObject2).setPKName(((SQLFriendKey)localObject1).getPKName());
        ((FKModel)localObject2).addKey(((SQLFriendKey)localObject1).getPKPrimaryKey(), ((SQLFriendKey)localObject1).getFKFriendKey());
        ((FKModel)localObject2).setUpdateRule(((SQLFriendKey)localObject1).getUpdateRule());
        ((FKModel)localObject2).setDeleteRule(((SQLFriendKey)localObject1).getDeleteRule());
        addChildElement((IElement)localObject2);
      }
      else
      {
        ((FKModel)localObject2).setPkTableName(((SQLFriendKey)localObject1).getPKTableName());
        ((FKModel)localObject2).setFKTableName(((SQLFriendKey)localObject1).getFKTableName());
        ((FKModel)localObject2).addKey(((SQLFriendKey)localObject1).getPKPrimaryKey(), ((SQLFriendKey)localObject1).getFKFriendKey());
        ((FKModel)localObject2).setFKName(((SQLFriendKey)localObject1).getFKName());
        ((FKModel)localObject2).setPKName(((SQLFriendKey)localObject1).getPKName());
        ((FKModel)localObject2).setUpdateRule(((SQLFriendKey)localObject1).getUpdateRule());
        ((FKModel)localObject2).setDeleteRule(((SQLFriendKey)localObject1).getDeleteRule());
      }
    }
  }

  public void changeFieldType(FieldModel paramFieldModel)
  {
    TableFunction localTableFunction = getFieldGetFunc(paramFieldModel);
    if (localTableFunction != null)
    {
      localTableFunction.setValueType(paramFieldModel.getValueType());
      localTableFunction.setVariableName("get" + getTypeManager().a(paramFieldModel.getJavaType()) + "(\"" + paramFieldModel.getFieldName().toLowerCase() + "\")");
    }
    localTableFunction = getFieldSetFunc(paramFieldModel);
    if (localTableFunction != null)
    {
      localTableFunction.setVariableName("set" + getTypeManager().a(paramFieldModel.getJavaType()) + "(\"" + paramFieldModel.getFieldName().toLowerCase() + "\",{arg1})");
      localTableFunction.setParams(a(paramFieldModel.getValueType()));
      if (getMainPackage() != null)
        getMainPackage().changeParamType(localTableFunction);
    }
  }

  public void changeFieldDisplayName(FieldModel paramFieldModel)
  {
    TableFunction localTableFunction = getFieldGetFunc(paramFieldModel);
    if (localTableFunction != null)
      localTableFunction.setDisplayName(format("getField.table", new Object[] { getDisplayName(), paramFieldModel.getDisplayName() }));
    localTableFunction = getFieldSetFunc(paramFieldModel);
    if (localTableFunction != null)
      localTableFunction.setDisplayName(format("setField.table", new Object[] { getDisplayName(), paramFieldModel.getDisplayName() }) + "{arg1}");
  }

  public void changeDisplayName(String paramString)
  {
    setDisplayName(paramString);
    getTableFunction("select").setDisplayName(format("select.table", new Object[] { getDisplayName() }));
    getTableFunction("delete").setDisplayName(format("delete.table", new Object[] { getDisplayName() }));
    getTableFunction("update").setDisplayName(format("update.table", new Object[] { getDisplayName() }));
    getTableFunction("insert").setDisplayName(format("insert.table", new Object[] { getDisplayName() }));
    getTableFunction("next").setDisplayName(format("next.table", new Object[] { getDisplayName() }));
    getTableFunction("resetValues").setDisplayName(format("resetValues.table", new Object[] { getDisplayName() }));
    getTableFunction("last").setDisplayName(format("last.table", new Object[] { getDisplayName() }));
    getTableFunction("getListResult").setDisplayName(format("getAllBean.table", new Object[] { getDisplayName() }));
    if (getTableFunction("hasExported") != null)
      getTableFunction("hasExported").setDisplayName(format("hasExported.table", new Object[] { getDisplayName() }));
    if (getTableFunction("deleteByForeignKey") != null)
      getTableFunction("deleteByForeignKey").setDisplayName(format("deleteByForeignKey.table", new Object[] { getDisplayName() }));
    if (getTableFunction("updateByForeignKey") != null)
      getTableFunction("updateByForeignKey").setDisplayName(format("updateByForeignKey.table", new Object[] { getDisplayName() }));
    if (getTableFunction("getRows") != null)
      getTableFunction("getRows").setDisplayName(format("getRows.table", new Object[] { getDisplayName() }));
    if (getTableFunction("close") != null)
      getTableFunction("close").setDisplayName(format("close.table", new Object[] { getDisplayName() }));
    if (getTableFunction("selectAll") != null)
      getTableFunction("selectAll").setDisplayName(format("selectAll.table", new Object[] { getDisplayName() }));
    if (getTableFunction("first") != null)
      getTableFunction("first").setDisplayName(format("first.table", new Object[] { getDisplayName() }));
    if (getTableFunction("previous") != null)
      getTableFunction("previous").setDisplayName(format("previous.table", new Object[] { getDisplayName() }));
    if (getTableFunction("getCurrentRow") != null)
      getTableFunction("getCurrentRow").setDisplayName(format("getCurrentRow.table", new Object[] { getDisplayName() }));
    if (getTableFunction("gotoRow") != null)
      getTableFunction("gotoRow").setDisplayName(format("gotoRow.table", new Object[] { getDisplayName(), "{arg1}" }));
    List localList = getFields();
    for (int i = 0; i < localList.size(); i++)
      changeFieldDisplayName((FieldModel)localList.get(i));
    setModified(true);
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      ((ITreeNode)getParent()).setModified(true);
  }

  protected void a(FieldModel paramFieldModel)
  {
    TableFunction localTableFunction;
    if (getFieldGetFunc(paramFieldModel) == null)
    {
      addChildElement(new TableFunction("get" + paramFieldModel.getGSName(), paramFieldModel.getValueType(), "get" + getTypeManager().a(paramFieldModel.getJavaType()) + "(" + getFields().indexOf(paramFieldModel) + ")", format("getField.table", new Object[] { getDisplayName(), paramFieldModel.getDisplayName() }), null, getLocalString("getField.tablegroup")));
    }
    else
    {
      localTableFunction = getFieldGetFunc(paramFieldModel);
      if (!localTableFunction.getValueType().equals(paramFieldModel.getValueType()))
        localTableFunction.setValueType(paramFieldModel.getValueType());
      localTableFunction.setVariableName("get" + getTypeManager().a(paramFieldModel.getJavaType()) + "(" + getFields().indexOf(paramFieldModel) + ")");
    }
    if (getFieldSetFunc(paramFieldModel) == null)
    {
      addChildElement(new TableFunction("set" + paramFieldModel.getGSName(), "void", "set" + getTypeManager().a(paramFieldModel.getJavaType()) + "(\"" + paramFieldModel.getFieldName().toLowerCase() + "\",{arg1})", format("setField.table", new Object[] { getDisplayName(), paramFieldModel.getDisplayName() }) + "{arg1}", a(paramFieldModel.getValueType()), getLocalString("setField.tablegroup")));
    }
    else
    {
      localTableFunction = getFieldSetFunc(paramFieldModel);
      if (!localTableFunction.getVariableName().equals("set" + getTypeManager().a(paramFieldModel.getJavaType()) + "(\"" + paramFieldModel.getFieldName().toLowerCase() + "\",{arg1})"))
      {
        localTableFunction.setVariableName("set" + getTypeManager().a(paramFieldModel.getJavaType()) + "(\"" + paramFieldModel.getFieldName().toLowerCase() + "\",{arg1})");
        localTableFunction.setParams(a(paramFieldModel.getValueType()));
      }
    }
  }

  public void addFKModels(List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
      addChildElement((FKModel)paramList.get(i));
  }

  public void changeVarName(String paramString)
  {
    setVarName(paramString);
  }

  public TableFunction addModifySheetFunction()
  {
    TableFunction localTableFunction = new TableFunction("modifyBySheet(sheet)", "void", "modifyBySheet({arg1})", getDisplayName() + ".modifyBySheet({arg1})", a("sheet"), getLocalString("update.tablegroup"));
    addChildElement(localTableFunction);
    return localTableFunction;
  }

  public void updateFunction()
  {
    if (getTableFunction("select") == null)
      addChildElement(new TableFunction("select", "void", "select()", format("select.table", new Object[] { getDisplayName() }), null, getLocalString("select.tablegroup")));
    if (getTableFunction("insert") == null)
      addChildElement(new TableFunction("insert", "int", "insertRows()", format("insert.table", new Object[] { getDisplayName() }), null, getLocalString("insert.tablegroup")));
    if (getTableFunction("delete") == null)
      addChildElement(new TableFunction("delete", "int", "deleteRows()", format("delete.table", new Object[] { getDisplayName() }), null, getLocalString("delete.tablegroup")));
    if (getTableFunction("update") == null)
      addChildElement(new TableFunction("update", "int", "updateRows()", format("update.table", new Object[] { getDisplayName() }), null, getLocalString("update.tablegroup")));
    if (getTableFunction("replace") == null)
      addChildElement(new TableFunction("replace", "int", "replace()", format("replace.table", new Object[] { getDisplayName() }), null, getLocalString("replace.tablegroup")));
    if (getTableFunction("next") == null)
      addChildElement(new TableFunction("next", "boolean", "next()", format("next.table", new Object[] { getDisplayName() }), null, getLocalString("next.tablegroup")));
    if (getTableFunction("resetValues") == null)
      addChildElement(new TableFunction("resetValues", "void", "resetValues()", format("resetValues.table", new Object[] { getDisplayName() }), null, getLocalString("resetValues.tablegroup")));
    if (getTableFunction("last") == null)
      addChildElement(new TableFunction("last", "boolean", "last()", format("last.table", new Object[] { getDisplayName() }), null, getLocalString("last.tablegroup")));
    if (getTableFunction("getListResult") == null)
      addChildElement(new TableFunction("getListResult", "list<list>", "getListResult()", format("getAllBean.table", new Object[] { getDisplayName() }), null, getLocalString("getAllBean.tablegroup")));
    if (getTableFunction("insertAndGeneratedKey") == null)
      addChildElement(new TableFunction("insertAndGeneratedKey", "int", "insertAndGeneratedKey()", format("insertAndGeneratedKey.table", new Object[] { getDisplayName() }), null, getLocalString("insertAndGeneratedKey.tablegroup")));
    if (getTableFunction("insertBySheet") == null)
    {
      addChildElement(new TableFunction("insertBySheet", "void", "insertBySheet({arg1})", format("insertBySheet.table", new Object[] { "{arg1}", getDisplayName() }), a("sheetandfields"), false, getLocalString("insertBySheet.tablegroup")));
    }
    else
    {
      getTableFunction("insertBySheet").setDisplayName(format("insertBySheet.table", new Object[] { "{arg1}", getDisplayName() }));
      getTableFunction("insertBySheet").setGroupName(getLocalString("insertBySheet.tablegroup"));
    }
    if (getTableFunction("updateBySheet") == null)
    {
      addChildElement(new TableFunction("updateBySheet", "void", "updateBySheet({arg1})", format("updateBySheet.table", new Object[] { "{arg1}", getDisplayName() }), a("sheetandfields"), false, getLocalString("updateBySheet.tablegroup")));
    }
    else
    {
      getTableFunction("updateBySheet").setDisplayName(format("updateBySheet.table", new Object[] { "{arg1}", getDisplayName() }));
      getTableFunction("updateBySheet").setGroupName(getLocalString("updateBySheet.tablegroup"));
    }
    if (getTableFunction("getRows") == null)
      addChildElement(new TableFunction("getRows", "int", "getRows()", format("getRows.table", new Object[] { getDisplayName() }), null, getLocalString("getRows.tablegroup")));
    if (getTableFunction("close") == null)
      addChildElement(new TableFunction("close", "void", "close()", format("close.table", new Object[] { getDisplayName() }), null, getLocalString("close.tablegroup")));
    if (getTableFunction("selectAll") == null)
      addChildElement(new TableFunction("selectAll", "void", "selectAll()", format("selectAll.table", new Object[] { getDisplayName() }), null, getLocalString("selectAll.tablegroup")));
    if (getTableFunction("first") == null)
      addChildElement(new TableFunction("first", "boolean", "first()", format("first.table", new Object[] { getDisplayName() }), null, getLocalString("first.tablegroup")));
    if (getTableFunction("previous") == null)
      addChildElement(new TableFunction("previous", "boolean", "previous()", format("previous.table", new Object[] { getDisplayName() }), null, getLocalString("previous.tablegroup")));
    if (getTableFunction("getCurrentRow") == null)
      addChildElement(new TableFunction("getCurrentRow", "int", "getCurrentRow()", format("getCurrentRow.table", new Object[] { getDisplayName() }), null, getLocalString("getCurrentRow.tablegroup")));
    if (getTableFunction("gotoRow") == null)
      addChildElement(new TableFunction("gotoRow", "boolean", "gotoRow({arg1})", format("gotoRow.table", new Object[] { getDisplayName(), "{arg1}" }), a("int"), getLocalString("gotoRow.tablegroup")));
  }

  public RuleTable getResultTable(Connection paramConnection)
  {
    try
    {
      RuleTable localRuleTable = new RuleTable(paramConnection, getTableName(), getRuleFields(), getRuleKeys());
      localRuleTable.setAccessMode(false);
      localRuleTable.setResultType(2);
      localRuleTable.selectAll();
      return localRuleTable;
    }
    catch (DBException localDBException)
    {
      EngineLogger.getEngineLogger().error(localDBException.getMessage(), localDBException);
    }
    return null;
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    return false;
  }

  public boolean isAccessMode()
  {
    return this.b == 1;
  }

  public void setAccessMode(boolean paramBoolean)
  {
    if (paramBoolean)
      this.b = 1;
    else
      this.b = 0;
  }

  public boolean isCloseMode()
  {
    return this.a == 0;
  }

  public void setCloseMode(boolean paramBoolean)
  {
    if (paramBoolean)
      setResultType(0);
    else
      setResultType(1);
  }

  public String getVarName()
  {
    if (this.varName.length() == 0)
      return getShortTableName();
    return this.varName;
  }

  public String getValueName()
  {
    return getVarName();
  }

  public void setVarName(String paramString)
  {
    this.varName = paramString;
  }

  public String getVarValue()
  {
    if (getDBModel() != null)
    {
      if (StringUtil.isJavaIdentifier(getVarName()))
        return getDBModel().getVarName() + getVarName().toLowerCase();
      return getDBModel().getVarName() + "_table" + getParent().getElementPos(this);
    }
    if (StringUtil.isJavaIdentifier(getVarName()))
      return getVarName().toLowerCase();
    return getShortTableName();
  }

  public String getValueType()
  {
    return "com.flagleader.db.Table";
  }

  public String getSqlInfo()
  {
    return getTableName();
  }

  public RuleField[] getRuleFields()
  {
    List localList = getFields();
    ArrayList localArrayList = new ArrayList(localList.size());
    for (int i = 0; i < localList.size(); i++)
      localArrayList.add(((FieldModel)localList.get(i)).getRuleField());
    RuleField[] arrayOfRuleField = new RuleField[localArrayList.size()];
    for (int j = 0; j < localArrayList.size(); j++)
      arrayOfRuleField[j] = ((RuleField)localArrayList.get(j));
    return arrayOfRuleField;
  }

  public RuleKey[] getRuleKeys()
  {
    List localList = getFKModels();
    ArrayList localArrayList = new ArrayList(localList.size());
    for (int i = 0; i < localList.size(); i++)
      localArrayList.add(((FKModel)localList.get(i)).getRuleKey());
    RuleKey[] arrayOfRuleKey = new RuleKey[localArrayList.size()];
    for (int j = 0; j < localArrayList.size(); j++)
      arrayOfRuleKey[j] = ((RuleKey)localArrayList.get(j));
    return arrayOfRuleKey;
  }

  public String getMainTableName()
  {
    return getTableName();
  }

  public boolean check()
  {
    if (getDBModel() != null)
    {
      ConnectionInfo localConnectionInfo = null;
      try
      {
        localConnectionInfo = getDBModel().getConnectionInfo();
        SchemaUtil localSchemaUtil = localConnectionInfo.getSchemaUtil();
        SQLTable localSQLTable = localSchemaUtil.getTable(getTableName());
        List localList1 = localSQLTable.getColumns();
        List localList2 = getFields();
        for (int i = 0; i < localList2.size(); i++)
        {
          FieldModel localFieldModel = (FieldModel)localList2.get(i);
          if (!a(localFieldModel, localList1))
            return false;
        }
        return true;
      }
      catch (Exception localException)
      {
      }
      finally
      {
        if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
        {
          if (localConnectionInfo.getConnection().getAutoCommit())
            localConnectionInfo.getConnection().rollback();
          localConnectionInfo.getConnection().close();
        }
      }
    }
    return false;
  }

  public void addSetFieldFunction(String paramString1, String paramString2)
  {
    addChildElement(new TableFunction("setFieldFunction(" + paramString1 + ")", "void", "setFieldFunction(\"" + paramString1 + "\",{arg1})", format("setFieldFunction.table", new Object[] { paramString1, "{arg1}" }), a("string"), true, getLocalString("setFieldFunction.tablegroup")));
  }

  public int getAccessType()
  {
    return this.b;
  }

  public void setAccessType(int paramInt)
  {
    this.b = paramInt;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.TableModel
 * JD-Core Version:    0.6.0
 */