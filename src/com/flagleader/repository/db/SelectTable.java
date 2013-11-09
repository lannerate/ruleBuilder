package com.flagleader.repository.db;

import com.flagleader.database.SQLColumn;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.sql.DBException;
import com.flagleader.sql.RuleSelect;
import com.flagleader.util.EngineLogger;
import com.flagleader.util.ListUtil;
import com.flagleader.util.StringUtil;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectTable extends AbstractTableModel
{
  private String sqlSelect = "";
  private boolean afterCommit = true;
  private String englishName = "";
  public static final String NAME = "selectTable";
  private transient HashMap paramMap = new HashMap();
  private transient HashMap oldInputs = null;

  public SelectTable(SelectTable paramSelectTable)
  {
    super(paramSelectTable);
    this.sqlSelect = paramSelectTable.sqlSelect;
    this.englishName = paramSelectTable.englishName;
    this.afterCommit = paramSelectTable.afterCommit;
  }

  public SelectTable()
  {
  }

  public SelectTable(String paramString1, String paramString2, String paramString3)
  {
    super(paramString2);
    this.sqlSelect = paramString1;
    this.englishName = paramString3;
  }

  public String toString()
  {
    return this.sqlSelect;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSelectTable(this);
  }

  public String getName()
  {
    return "selectTable";
  }

  public List getResultFields()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof FieldModel))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public void clearResultFields()
  {
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if (!(getElement(i) instanceof FieldModel))
        continue;
      removeElement(i);
    }
  }

  public String getSqlSelect()
  {
    return this.sqlSelect;
  }

  public void setSqlSelect(String paramString)
  {
    this.sqlSelect = paramString;
  }

  public IElement deepClone()
  {
    return new SelectTable(this);
  }

  public void update(List paramList)
  {
    updateFunction();
    ArrayList localArrayList = new ArrayList(paramList.size());
    FieldModel localFieldModel;
    for (int i = 0; i < paramList.size(); i++)
    {
      SQLColumn localSQLColumn = (SQLColumn)paramList.get(i);
      localFieldModel = getField(localSQLColumn.getName());
      if (localFieldModel == null)
      {
        localFieldModel = new FieldModel();
        localFieldModel.setParent(this);
      }
      localArrayList.add(localFieldModel);
      localFieldModel.update(localSQLColumn);
    }
    List localList = getFields();
    for (int j = 0; j < localList.size(); j++)
    {
      localFieldModel = (FieldModel)localList.get(j);
      if (!a(localFieldModel, paramList))
      {
        if (getFieldGetFunc(localFieldModel) != null)
          getFieldGetFunc(localFieldModel).dispose();
        if (getFieldSetFunc(localFieldModel) != null)
          getFieldSetFunc(localFieldModel).dispose();
      }
      removeChildElement(localFieldModel);
    }
    for (j = 0; j < localArrayList.size(); j++)
      addChildElement((FieldModel)localArrayList.get(j));
    localList = getFields();
    for (j = 0; j < localList.size(); j++)
      a((FieldModel)localList.get(j));
  }

  private boolean a(FieldModel paramFieldModel, List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
      if (((SQLColumn)paramList.get(i)).getName().equalsIgnoreCase(paramFieldModel.getFieldName()))
        return true;
    return false;
  }

  private void a(FieldModel paramFieldModel)
  {
    if (getFieldGetFunc(paramFieldModel) == null)
    {
      addChildElement(new TableFunction("get" + paramFieldModel.getGSName(), paramFieldModel.getValueType(), "get" + getTypeManager().a(paramFieldModel.getJavaType()) + "(" + getFields().indexOf(paramFieldModel) + ")", format("getField.select", new Object[] { getDisplayName(), paramFieldModel.getDisplayName() }), null, getLocalString("getField.selectgroup")));
    }
    else
    {
      TableFunction localTableFunction = getFieldGetFunc(paramFieldModel);
      localTableFunction.setValueType(paramFieldModel.getValueType());
      localTableFunction.setVariableName("get" + getTypeManager().a(paramFieldModel.getJavaType()) + "(" + getFields().indexOf(paramFieldModel) + ")");
      localTableFunction.setDisplayName(format("getField.select", new Object[] { getDisplayName(), paramFieldModel.getDisplayName() }));
    }
  }

  public void changeFieldDisplayName(FieldModel paramFieldModel)
  {
    TableFunction localTableFunction = getFieldGetFunc(paramFieldModel);
    if (localTableFunction != null)
      localTableFunction.setDisplayName(format("getField.select", new Object[] { getDisplayName(), paramFieldModel.getDisplayName() }));
  }

  public void changeDisplayName(String paramString)
  {
    setDisplayName(paramString);
    if (k().length() > 0)
      getTableFunction("selectWhere").setDisplayName(format("selectWhere.select", new Object[] { k(), getDisplayName() }));
    else
      getTableFunction("selectWhere").setDisplayName(format("selectSQL.select", new Object[] { getDisplayName() }));
    if (getTableFunction("next") != null)
      getTableFunction("next").setDisplayName(format("next.select", new Object[] { getDisplayName() }));
    if (getTableFunction("getListResult") != null)
      getTableFunction("getListResult").setDisplayName(format("getAllBean.select", new Object[] { getDisplayName() }));
    if (getTableFunction("setOrderField") != null)
      getTableFunction("setOrderField").setDisplayName(format("setOrderField.select", new Object[] { getDisplayName(), "{arg1}", "{arg2}" }));
    if (getTableFunction("setPage") != null)
      getTableFunction("setPage").setDisplayName(format("setPage.select", new Object[] { getDisplayName(), "{arg1}", "{arg2}" }));
    if (getTableFunction("getCount") != null)
      getTableFunction("getCount").setDisplayName(format("getCount.select", new Object[] { getDisplayName() }));
    if (getTableFunction("hasNext") != null)
      getTableFunction("hasNext").setDisplayName(format("hasNext.select", new Object[] { getDisplayName() }));
    if (getTableFunction("getRows") != null)
      getTableFunction("getRows").setDisplayName(format("getRows.select", new Object[] { getDisplayName() }));
    if (getTableFunction("first") != null)
      getTableFunction("first").setDisplayName(format("first.select", new Object[] { getDisplayName() }));
    if (getTableFunction("previous") != null)
      getTableFunction("previous").setDisplayName(format("previous.select", new Object[] { getDisplayName() }));
    if (getTableFunction("last") != null)
      getTableFunction("last").setDisplayName(format("last.select", new Object[] { getDisplayName() }));
    if (getTableFunction("getCurrentRow") != null)
      getTableFunction("getCurrentRow").setDisplayName(format("getCurrentRow.select", new Object[] { getDisplayName() }));
    if (getTableFunction("gotoRow") != null)
      getTableFunction("gotoRow").setDisplayName(format("gotoRow.select", new Object[] { getDisplayName(), "{arg1}" }));
    List localList = getFields();
    for (int i = 0; i < localList.size(); i++)
      changeFieldDisplayName((FieldModel)localList.get(i));
    setModified(true);
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      ((ITreeNode)getParent()).setModified(true);
  }

  public void changeVarName(String paramString)
  {
    setEnglishName(paramString);
  }

  public void changeSqlText(String paramString)
  {
    if (getDBModel() != null)
    {
      update(getDBModel().getQueryUtil(paramString));
      setSqlSelect(paramString);
      getTableFunction("selectWhere").setVariableName("selectWhere(\"" + h() + "\"," + j() + ")");
      if (k().length() > 0)
        getTableFunction("selectWhere").setDisplayName(format("selectWhere.select", new Object[] { k(), getDisplayName() }));
      else
        getTableFunction("selectWhere").setDisplayName(format("selectSQL.select", new Object[] { getDisplayName() }));
      getTableFunction("selectWhere").setParams(l());
      if (getMainPackage() != null)
        getMainPackage().changeParamType(getTableFunction("selectWhere"));
    }
  }

  public boolean refresh()
  {
    if (getDBModel() != null)
    {
      update(getDBModel().getQueryUtil(this.sqlSelect));
      getTableFunction("selectWhere").setVariableName("selectWhere(\"" + h() + "\"," + j() + ")");
      if (k().length() > 0)
        getTableFunction("selectWhere").setDisplayName(format("selectWhere.select", new Object[] { k(), getDisplayName() }));
      else
        getTableFunction("selectWhere").setDisplayName(format("selectSQL.select", new Object[] { getDisplayName() }));
      getTableFunction("selectWhere").setParams(l());
      if (getMainPackage() != null)
        getMainPackage().changeParamType(getTableFunction("selectWhere"));
      return true;
    }
    return false;
  }

  public void updateFunction()
  {
    if (e().size() == 0)
    {
      if (k().length() > 0)
        addChildElement(new TableFunction("selectWhere", "void", "selectWhere(\"" + h() + "\"," + j() + ")", format("selectWhere.select", new Object[] { k(), getDisplayName() }), l(), true, getLocalString("selectWhere.selectgroup")));
      else
        addChildElement(new TableFunction("selectWhere", "void", "selectWhere(\"" + h() + "\"," + j() + ")", format("selectSQL.select", new Object[] { getDisplayName() }), l(), true, getLocalString("selectSQL.selectgroup")));
      addChildElement(new TableFunction("next", "boolean", "next()", format("next.select", new Object[] { getDisplayName() }), null, getLocalString("next.selectgroup")));
      addChildElement(new TableFunction("getListResult", "list<list>", "getListResult()", format("getAllBean.select", new Object[] { getDisplayName() }), null, true, getLocalString("getAllBean.selectgroup")));
      addChildElement(new TableFunction("setOrderField", "void", "setOrderField({arg1},{arg2})", format("setOrderField.select", new Object[] { getDisplayName(), "{arg1}", "{arg2}" }), a("string", "boolean"), getLocalString("setOrderField.selectgroup")));
      addChildElement(new TableFunction("setPage", "void", "setPage({arg1},{arg2})", format("setPage.select", new Object[] { getDisplayName(), "{arg1}", "{arg2}" }), a("int", "int"), getLocalString("setPage.selectgroup")));
      addChildElement(new TableFunction("getCount", "int", "getCount()", format("getCount.select", new Object[] { getDisplayName() }), null, getLocalString("getCount.selectgroup")));
      addChildElement(new TableFunction("getRows", "int", "getRows()", format("getRows.select", new Object[] { getDisplayName() }), null, getLocalString("getRows.selectgroup")));
      addChildElement(new TableFunction("beforeFirst", "void", "beforeFirst()", format("beforeFirst.select", new Object[] { getDisplayName() }), null, getLocalString("beforeFirst.selectgroup")));
      addChildElement(new TableFunction("first", "boolean", "first()", format("first.select", new Object[] { getDisplayName() }), null, getLocalString("first.selectgroup")));
      addChildElement(new TableFunction("previous", "boolean", "previous()", format("previous.select", new Object[] { getDisplayName() }), null, getLocalString("previous.selectgroup")));
      addChildElement(new TableFunction("last", "boolean", "last()", format("last.select", new Object[] { getDisplayName() }), null, getLocalString("last.selectgroup")));
      addChildElement(new TableFunction("getCurrentRow", "int", "getCurrentRow()", format("getCurrentRow.select", new Object[] { getDisplayName() }), null, getLocalString("getCurrentRow.selectgroup")));
      addChildElement(new TableFunction("gotoRow", "boolean", "gotoRow({arg1})", format("gotoRow.select", new Object[] { getDisplayName(), "{arg1}" }), a("int"), getLocalString("gotoRow.selectgroup")));
    }
  }

  private String f()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.sqlSelect.replace('\n', ' ').replace('\r', ' '));
    int i = 0;
    int j = 0;
    int k = 0;
    while (true)
    {
      i = localStringBuffer.indexOf("{", j);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      localStringBuffer.replace(i, j + 1, " ? ");
    }
    return localStringBuffer.toString();
  }

  private String h()
  {
    return StringUtil.replace("\"", "\\\"", f());
  }

  private String i()
  {
    StringBuffer localStringBuffer1 = new StringBuffer("new Object[]{");
    StringBuffer localStringBuffer2 = new StringBuffer(this.sqlSelect.replace('\n', ' ').replace('\r', ' '));
    List localList = l();
    int i = 0;
    int j = 0;
    int k = 0;
    while (true)
    {
      i = localStringBuffer2.indexOf("{", j);
      j = localStringBuffer2.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      if (localStringBuffer2.substring(i + 1, j).indexOf("arg") < 0)
      {
        localStringBuffer1.append(getTypeManager().c(localStringBuffer2.substring(i + 1, j)) + ",");
        continue;
      }
      localStringBuffer1.append(getTypeManager().c(a(localStringBuffer2.substring(i + 1, j), localList)) + ",");
    }
    if (localStringBuffer1.charAt(localStringBuffer1.length() - 1) == ',')
      localStringBuffer1.deleteCharAt(localStringBuffer1.length() - 1);
    localStringBuffer1.append("}");
    return localStringBuffer1.toString();
  }

  private String a(String paramString, List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
      if (((MethodParam)paramList.get(i)).getParamName().equals(paramString))
        return ((MethodParam)paramList.get(i)).getTypeName();
    return "string";
  }

  private String j()
  {
    StringBuffer localStringBuffer1 = new StringBuffer("new Object[]{");
    StringBuffer localStringBuffer2 = new StringBuffer(this.sqlSelect.replace('\n', ' ').replace('\r', ' '));
    List localList = l();
    int i = 0;
    int j = 0;
    int k = 0;
    while (true)
    {
      i = localStringBuffer2.indexOf("{", j);
      j = localStringBuffer2.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      if (localStringBuffer2.substring(i + 1, j).indexOf("arg") < 0)
      {
        k++;
        localStringBuffer1.append(getTypeManager().a(localStringBuffer2.substring(i + 1, j), new StringBuilder("arg").append(k).toString()) + ",");
        continue;
      }
      localStringBuffer1.append(getTypeManager().a(a(localStringBuffer2.substring(i + 1, j), localList), localStringBuffer2.substring(i + 1, j)) + ",");
    }
    if (localStringBuffer1.charAt(localStringBuffer1.length() - 1) == ',')
      localStringBuffer1.deleteCharAt(localStringBuffer1.length() - 1);
    localStringBuffer1.append("}");
    return localStringBuffer1.toString();
  }

  private String k()
  {
    String str = "";
    StringBuffer localStringBuffer = new StringBuffer(this.sqlSelect.replace('\n', ' ').replace('\r', ' '));
    int i = 0;
    int j = 0;
    int k = 0;
    while (true)
    {
      i = localStringBuffer.indexOf("{", j);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      if (localStringBuffer.substring(i + 1, j).indexOf("arg") >= 0)
        continue;
      k++;
      str = str + "{arg" + k + "}";
    }
    return str;
  }

  private List l()
  {
    ArrayList localArrayList = new ArrayList(3);
    this.paramMap.clear();
    StringBuffer localStringBuffer = new StringBuffer(this.sqlSelect.replace('\n', ' ').replace('\r', ' '));
    int i = 0;
    int j = 0;
    int k = 0;
    while (true)
    {
      i = localStringBuffer.indexOf("{", j);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      if (localStringBuffer.substring(i + 1, j).indexOf("arg") >= 0)
        continue;
      localArrayList.add(new MethodParam(localStringBuffer.substring(i + 1, j).trim(), k++));
      this.paramMap.put("arg" + k, b(localStringBuffer.substring(0, i).toLowerCase().trim()));
    }
    return localArrayList;
  }

  public String getParamDisplay(String paramString)
  {
    if (this.paramMap.size() == 0)
      l();
    Object localObject = this.paramMap.get(paramString);
    if (localObject != null)
    {
      FieldModel localFieldModel = getField(localObject.toString());
      if (localFieldModel != null)
        return localFieldModel.getDisplayName();
      return localObject.toString();
    }
    return "";
  }

  private String b(String paramString)
  {
    paramString = StringUtil.replace("=", "", paramString);
    paramString = StringUtil.replace("like", "", paramString);
    paramString = StringUtil.replace("in (", "", paramString);
    paramString = StringUtil.replace("<", "", paramString);
    paramString = StringUtil.replace(">", "", paramString);
    paramString = paramString.trim();
    if ((paramString.lastIndexOf(".") > paramString.lastIndexOf(" ")) && (paramString.lastIndexOf(".") > 0))
      return paramString.substring(paramString.lastIndexOf(".") + 1);
    if (paramString.lastIndexOf(" ") > 0)
      return paramString.substring(paramString.lastIndexOf(" ") + 1);
    return "";
  }

  public Object[] getSelectParams(Object[] paramArrayOfObject)
  {
    ArrayList localArrayList = new ArrayList(3);
    StringBuffer localStringBuffer = new StringBuffer(this.sqlSelect.replace('\n', ' ').replace('\r', ' '));
    int i = 0;
    int j = 0;
    int k = 0;
    while (true)
    {
      i = localStringBuffer.indexOf("{", j);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      int m = -1;
      if (localStringBuffer.substring(i + 1, j).indexOf("arg") < 0)
        m = k++;
      else
        m = c(localStringBuffer.substring(i + 1, j)) - 1;
      if ((m >= 0) && (paramArrayOfObject.length > m))
      {
        localArrayList.add(paramArrayOfObject[m]);
        continue;
      }
      localArrayList.add(null);
    }
    return ListUtil.toArray(localArrayList);
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    return false;
  }

  private boolean m()
  {
    return this.sqlSelect.trim().indexOf("{") > 0;
  }

  private int c(String paramString)
  {
    String str = "";
    for (int i = 0; i < paramString.length(); i++)
      switch (paramString.charAt(i))
      {
      case '0':
        str = str + '0';
        break;
      case '1':
        str = str + '1';
        break;
      case '2':
        str = str + '2';
        break;
      case '3':
        str = str + '3';
        break;
      case '4':
        str = str + '4';
        break;
      case '5':
        str = str + '5';
        break;
      case '6':
        str = str + '6';
        break;
      case '7':
        str = str + '7';
        break;
      case '8':
        str = str + '8';
        break;
      case '9':
        str = str + '9';
      }
    try
    {
      return Integer.parseInt(str);
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 0;
  }

  public DBModel getDBModel()
  {
    if ((getParent() != null) && ((getParent() instanceof DBModel)))
      return (DBModel)getParent();
    return null;
  }

  public String getEnglishName()
  {
    if ((this.englishName == null) || (this.englishName.length() == 0))
      return getDisplayName();
    return this.englishName;
  }

  public void setEnglishName(String paramString)
  {
    this.englishName = paramString;
  }

  public String getVarValue()
  {
    if (getDBModel() != null)
    {
      if (StringUtil.isJavaIdentifier(getEnglishName()))
        return getDBModel().getVarName() + getEnglishName();
      return getDBModel().getVarName() + "_select" + getParent().getElementPos(this);
    }
    return getEnglishName();
  }

  public String getValueName()
  {
    return getEnglishName();
  }

  public String getValueType()
  {
    return "com.flagleader.db.Select";
  }

  public String getSqlInfo()
  {
    return getSqlSelect().replace('\n', ' ').replace('\r', ' ');
  }

  public String getMainTableName()
  {
    String str1 = this.sqlSelect.toLowerCase().trim();
    if (str1.startsWith("select"))
    {
      int i = str1.indexOf("from");
      if (i > 0)
      {
        String str2 = str1.substring(i + 4).trim();
        if ((str2.indexOf(" ") > 0) && (str2.indexOf(",") > 0))
        {
          if (str2.indexOf(",") > str2.indexOf(" "))
            return str2.substring(0, str2.indexOf(" ")).trim();
          return str2.substring(0, str2.indexOf(",")).trim();
        }
        if (str2.indexOf(" ") > 0)
          return str2.substring(0, str2.indexOf(" ")).trim();
        if (str2.indexOf(",") > 0)
          return str2.substring(0, str2.indexOf(",")).trim();
        return str2;
      }
    }
    return "";
  }

  public RuleSelect getResultTable(Connection paramConnection, Object[] paramArrayOfObject, String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    try
    {
      RuleSelect localRuleSelect = new RuleSelect(paramConnection, getFieldNames(), getFieldDisNames());
      if ((paramString != null) && (paramString.length() > 0))
        localRuleSelect.setOrderField(paramString, paramBoolean);
      localRuleSelect.setPage(paramInt1, paramInt2);
      localRuleSelect.selectWhere(f(), paramArrayOfObject);
      return localRuleSelect;
    }
    catch (DBException localDBException)
    {
      EngineLogger.getEngineLogger().error(localDBException.getMessage(), localDBException);
    }
    return null;
  }

  public RuleSelect getResultTable(Connection paramConnection, Object[] paramArrayOfObject)
  {
    try
    {
      RuleSelect localRuleSelect = new RuleSelect(paramConnection, getFieldNames(), getFieldDisNames());
      localRuleSelect.setResultType(2);
      localRuleSelect.selectWhere(f(), paramArrayOfObject);
      return localRuleSelect;
    }
    catch (DBException localDBException)
    {
      EngineLogger.getEngineLogger().error(localDBException.getMessage(), localDBException);
    }
    return null;
  }

  public boolean check()
  {
    if (getDBModel() != null)
      return getDBModel().checkSql(getSqlSelect());
    return false;
  }

  public boolean isEditVisible()
  {
    return true;
  }

  public boolean isAfterCommit()
  {
    return this.afterCommit;
  }

  public void setAfterCommit(boolean paramBoolean)
  {
    this.afterCommit = paramBoolean;
  }

  public HashMap getOldInputs()
  {
    if (this.oldInputs == null)
      this.oldInputs = new HashMap();
    return this.oldInputs;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.SelectTable
 * JD-Core Version:    0.6.0
 */