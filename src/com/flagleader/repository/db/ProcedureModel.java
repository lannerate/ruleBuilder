package com.flagleader.repository.db;

import com.flagleader.database.SQLColumn;
import com.flagleader.database.SQLParameter;
import com.flagleader.database.SQLProcedure;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public class ProcedureModel extends AbstractTableModel
{
  private String sqlSelect = "";
  private String englishName = "";
  public static final String NAME = "ProcedureModel";

  public ProcedureModel(ProcedureModel paramProcedureModel)
  {
    super(paramProcedureModel);
    this.sqlSelect = paramProcedureModel.sqlSelect;
    this.englishName = paramProcedureModel.englishName;
  }

  public ProcedureModel()
  {
  }

  public ProcedureModel(String paramString1, String paramString2)
  {
    super(paramString1);
    this.englishName = paramString2;
  }

  public String toString()
  {
    return this.sqlSelect;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitProcedureModel(this);
  }

  public String getName()
  {
    return "ProcedureModel";
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
    for (int i = getChildrenCount() - 1; i >= 0; i--)
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
    this.sqlSelect = paramString.trim();
  }

  public IElement deepClone()
  {
    return new ProcedureModel(this);
  }

  public List getParas()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof ParameterModel))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public void update(SQLProcedure paramSQLProcedure)
  {
    this.englishName = paramSQLProcedure.getName();
    changeSqlText(paramSQLProcedure.getPrepareSql());
    Object localObject2;
    Object localObject3;
    if (paramSQLProcedure.getParameters().size() > 0)
    {
      localList1 = getParas();
      for (int i = 0; i < localList1.size(); i++)
      {
        ParameterModel localParameterModel = (ParameterModel)localList1.get(i);
        if (getParaGetFunc(localParameterModel) != null)
          getParaGetFunc(localParameterModel).dispose();
        if (getParaSetFunc(localParameterModel) != null)
          getParaSetFunc(localParameterModel).dispose();
        localParameterModel.dispose();
      }
      localObject1 = paramSQLProcedure.getParameters();
      for (j = 0; j < ((List)localObject1).size(); j++)
      {
        localObject2 = (SQLParameter)((List)localObject1).get(j);
        if (((SQLParameter)localObject2).getModetype() == 3)
          continue;
        localObject3 = new ParameterModel();
        addChildElement((IElement)localObject3, j);
        ((ParameterModel)localObject3).update((SQLParameter)localObject2);
        ((ParameterModel)localObject3).setPos(j + 1);
        a((ParameterModel)localObject3);
      }
    }
    updateFunction();
    List localList1 = paramSQLProcedure.getColumns();
    Object localObject1 = new ArrayList();
    for (int j = 0; j < localList1.size(); j++)
    {
      localObject2 = (SQLColumn)localList1.get(j);
      localObject3 = getField(((SQLColumn)localObject2).getName());
      if (localObject3 == null)
      {
        localObject3 = new FieldModel();
        ((FieldModel)localObject3).setParent(this);
      }
      ((List)localObject1).add(localObject3);
      ((FieldModel)localObject3).update((SQLColumn)localObject2);
    }
    List localList2 = getFields();
    for (int k = 0; k < localList2.size(); k++)
    {
      localObject3 = (FieldModel)localList2.get(k);
      if (!a((FieldModel)localObject3, localList1))
      {
        if (getFieldGetFunc((FieldModel)localObject3) != null)
          getFieldGetFunc((FieldModel)localObject3).dispose();
        if (getFieldSetFunc((FieldModel)localObject3) != null)
          getFieldSetFunc((FieldModel)localObject3).dispose();
      }
      removeChildElement((IElement)localObject3);
    }
    for (k = 0; k < ((List)localObject1).size(); k++)
      addChildElement((FieldModel)((List)localObject1).get(k));
    localList2 = getFields();
    for (k = 0; k < localList2.size(); k++)
      a((FieldModel)localList2.get(k));
    setModified(true);
  }

  private boolean a(FieldModel paramFieldModel, List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
      if (((SQLColumn)paramList.get(i)).getName().equalsIgnoreCase(paramFieldModel.getFieldName()))
        return true;
    return false;
  }

  public void addParaModel(ParameterModel paramParameterModel)
  {
    List localList = getParas();
    int i = localList.size();
    for (int j = 0; j < localList.size(); j++)
    {
      ParameterModel localParameterModel = (ParameterModel)localList.get(j);
      if (localParameterModel.getPos() <= paramParameterModel.getPos())
        continue;
      i = j;
      break;
    }
    addChildElement(paramParameterModel, i);
    a(paramParameterModel);
    getTableFunction("executeProc").setDisplayName(format("selectWhere.select", new Object[] { n(), getDisplayName() }));
    getTableFunction("executeProc").setVariableName("executeProc(\"" + k() + "\"," + h() + "," + j() + "," + m() + ")");
    getTableFunction("executeProc").setParams(o());
  }

  public void deleteParaModel(ParameterModel paramParameterModel)
  {
    if (getParaGetFunc(paramParameterModel) != null)
      getParaGetFunc(paramParameterModel).dispose();
    paramParameterModel.dispose();
    getTableFunction("executeProc").setDisplayName(format("selectWhere.select", new Object[] { n(), getDisplayName() }));
    getTableFunction("executeProc").setVariableName("executeProc(\"" + k() + "\"," + h() + "," + j() + "," + m() + ")");
    getTableFunction("executeProc").setParams(o());
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

  private void a(ParameterModel paramParameterModel)
  {
    if (paramParameterModel.isModeOut())
      if (getParaGetFunc(paramParameterModel) == null)
      {
        addChildElement(new TableFunction("get" + paramParameterModel.getPos(), paramParameterModel.getValueType(), "get" + getTypeManager().a(paramParameterModel.getJavaType()) + "(\"" + paramParameterModel.getPos() + "\")", format("getField.select", new Object[] { getDisplayName(), paramParameterModel.getDisplayName() }), null, getLocalString("getField.selectgroup")));
      }
      else
      {
        TableFunction localTableFunction = getParaGetFunc(paramParameterModel);
        localTableFunction.setValueType(paramParameterModel.getValueType());
        localTableFunction.setVariableName("get" + getTypeManager().a(paramParameterModel.getJavaType()) + "(\"" + paramParameterModel.getPos() + "\")");
        localTableFunction.setDisplayName(format("getField.select", new Object[] { getDisplayName(), paramParameterModel.getDisplayName() }));
      }
  }

  public TableFunction getParaGetFunc(ParameterModel paramParameterModel)
  {
    List localList = e();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof TableFunction)) && (((TableFunction)localList.get(i)).getValueName().equals("get" + paramParameterModel.getPos())))
        return (TableFunction)localList.get(i);
    return null;
  }

  public TableFunction getParaSetFunc(ParameterModel paramParameterModel)
  {
    List localList = e();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof TableFunction)) && (((TableFunction)localList.get(i)).getValueName().equals("set" + paramParameterModel.getPos())))
        return (TableFunction)localList.get(i);
    return null;
  }

  public void changeFieldDisplayName(FieldModel paramFieldModel)
  {
    TableFunction localTableFunction = getFieldGetFunc(paramFieldModel);
    if (localTableFunction != null)
      localTableFunction.setDisplayName(format("getField.select", new Object[] { getDisplayName(), paramFieldModel.getDisplayName() }));
  }

  public void changeParaDisplayName(ParameterModel paramParameterModel)
  {
    TableFunction localTableFunction = getParaGetFunc(paramParameterModel);
    if (localTableFunction != null)
      localTableFunction.setDisplayName(format("getField.select", new Object[] { getDisplayName(), paramParameterModel.getDisplayName() }));
  }

  public void changeParaType(ParameterModel paramParameterModel)
  {
    if (paramParameterModel.isModeOut())
    {
      TableFunction localTableFunction = getParaGetFunc(paramParameterModel);
      if (localTableFunction != null)
      {
        localTableFunction.setValueType(paramParameterModel.getValueType());
        localTableFunction.setVariableName("get" + getTypeManager().a(paramParameterModel.getJavaType()) + "(\"" + paramParameterModel.getPos() + "\")");
      }
    }
    else
    {
      getTableFunction("executeProc").setVariableName("executeProc(\"" + k() + "\"," + h() + "," + j() + "," + m() + ")");
      getTableFunction("executeProc").setParams(o());
    }
  }

  public void changeParaMode(ParameterModel paramParameterModel)
  {
    if (getParaGetFunc(paramParameterModel) != null)
      getParaGetFunc(paramParameterModel).dispose();
    ParameterModel localParameterModel = new ParameterModel(paramParameterModel);
    paramParameterModel.dispose();
    addParaModel(localParameterModel);
    getTableFunction("executeProc").setDisplayName(format("selectWhere.select", new Object[] { n(), getDisplayName() }));
    getTableFunction("executeProc").setVariableName("executeProc(\"" + k() + "\"," + h() + "," + j() + "," + m() + ")");
    getTableFunction("executeProc").setParams(o());
    if (getMainPackage() != null)
      getMainPackage().changeParamType(getTableFunction("executeProc"));
  }

  public void changeParaPos(ParameterModel paramParameterModel, int paramInt)
  {
    if (paramInt != paramParameterModel.getPos())
    {
      if (getParaGetFunc(paramParameterModel) != null)
        getParaGetFunc(paramParameterModel).dispose();
      ParameterModel localParameterModel = new ParameterModel(paramParameterModel);
      paramParameterModel.dispose();
      addParaModel(localParameterModel);
    }
  }

  public void changeDisplayName(String paramString)
  {
    setDisplayName(paramString);
    if (n().length() > 0)
      getTableFunction("executeProc").setDisplayName(format("selectWhere.select", new Object[] { n(), getDisplayName() }));
    else
      getTableFunction("executeProc").setDisplayName(format("selectSQL.select", new Object[] { getDisplayName() }));
    if (getFields().size() > 0)
    {
      getTableFunction("hasNext").setDisplayName(format("hasNext.select", new Object[] { getDisplayName() }));
      getTableFunction("next").setDisplayName(format("next.select", new Object[] { getDisplayName() }));
      getTableFunction("getRows").setDisplayName(format("getRows.select", new Object[] { getDisplayName() }));
      getTableFunction("first").setDisplayName(format("first.select", new Object[] { getDisplayName() }));
      getTableFunction("previous").setDisplayName(format("previous.select", new Object[] { getDisplayName() }));
      getTableFunction("last").setDisplayName(format("last.select", new Object[] { getDisplayName() }));
      getTableFunction("getListResult").setDisplayName(format("getAllBean.select", new Object[] { getDisplayName() }));
      getTableFunction("getCurrentRow").setDisplayName(format("getCurrentRow.select", new Object[] { getDisplayName() }));
      getTableFunction("gotoRow").setDisplayName(format("gotoRow.select", new Object[] { getDisplayName(), "{arg1}" }));
    }
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
      setSqlSelect(paramString);
      if (getTableFunction("executeProc") != null)
        getTableFunction("executeProc").setVariableName("executeProc(\"" + k() + "\"," + h() + "," + j() + "," + m() + ")");
    }
  }

  public boolean refresh()
  {
    if (getDBModel() != null)
    {
      update(getDBModel().getStatementUtil(this.englishName));
      setSqlSelect(this.sqlSelect);
      getTableFunction("executeProc").setVariableName("executeProc(\"" + k() + "\"," + h() + "," + j() + "," + m() + ")");
      return true;
    }
    return false;
  }

  private int[] f()
  {
    List localList = getParas();
    int[] arrayOfInt = new int[localList.size()];
    for (int i = 0; i < localList.size(); i++)
    {
      ParameterModel localParameterModel = (ParameterModel)localList.get(i);
      arrayOfInt[i] = localParameterModel.getModetype();
    }
    return arrayOfInt;
  }

  private String h()
  {
    StringBuffer localStringBuffer = new StringBuffer("new int[]{");
    List localList = getParas();
    if (localList.size() > 0)
      for (int i = 0; i < localList.size(); i++)
      {
        ParameterModel localParameterModel = (ParameterModel)localList.get(i);
        localStringBuffer.append(localParameterModel.getModetype() + ",");
      }
    if (localStringBuffer.charAt(localStringBuffer.length() - 1) == ',')
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }

  private int[] i()
  {
    List localList = getParas();
    int[] arrayOfInt = new int[localList.size()];
    for (int i = 0; i < localList.size(); i++)
    {
      ParameterModel localParameterModel = (ParameterModel)localList.get(i);
      arrayOfInt[i] = localParameterModel.getIType();
    }
    return arrayOfInt;
  }

  private String j()
  {
    StringBuffer localStringBuffer = new StringBuffer("new int[]{");
    List localList = getParas();
    if (getParas().size() > 0)
      for (int i = 0; i < localList.size(); i++)
      {
        ParameterModel localParameterModel = (ParameterModel)localList.get(i);
        localStringBuffer.append(localParameterModel.getIType() + ",");
      }
    if (localStringBuffer.charAt(localStringBuffer.length() - 1) == ',')
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }

  public void updateFunction()
  {
    if (getTableFunction("executeProc") == null)
      if (n().length() > 0)
        addChildElement(new TableFunction("executeProc", "void", "executeProc(\"" + k() + "\"," + h() + "," + j() + "," + m() + ")", format("selectWhere.select", new Object[] { n(), getDisplayName() }), o(), true, getLocalString("selectWhere.selectgroup")));
      else
        addChildElement(new TableFunction("executeProc", "void", "executeProc(\"" + k() + "\"," + h() + "," + j() + "," + m() + ")", format("selectSQL.select", new Object[] { getDisplayName() }), o(), true, getLocalString("selectSQL.selectgroup")));
    if ((getFields().size() > 0) && (getTableFunction("hasNext") == null))
    {
      addChildElement(new TableFunction("hasNext", "boolean", "hasNext()", format("hasNext.select", new Object[] { getDisplayName() }), null, getLocalString("hasNext.selectgroup")));
      addChildElement(new TableFunction("next", "boolean", "next()", format("next.select", new Object[] { getDisplayName() }), null, getLocalString("next.selectgroup")));
      addChildElement(new TableFunction("getRows", "int", "getRows()", format("getRows.select", new Object[] { getDisplayName() }), null, getLocalString("getRows.selectgroup")));
      addChildElement(new TableFunction("first", "boolean", "first()", format("first.select", new Object[] { getDisplayName() }), null, getLocalString("first.selectgroup")));
      addChildElement(new TableFunction("previous", "boolean", "previous()", format("previous.select", new Object[] { getDisplayName() }), null, getLocalString("previous.selectgroup")));
      addChildElement(new TableFunction("last", "boolean", "last()", format("last.select", new Object[] { getDisplayName() }), null, getLocalString("last.selectgroup")));
      addChildElement(new TableFunction("getListResult", "list<list>", "getListResult()", format("getAllBean.select", new Object[] { getDisplayName() }), null, true, getLocalString("getAllBean.selectgroup")));
      addChildElement(new TableFunction("getCurrentRow", "int", "getCurrentRow()", format("getCurrentRow.select", new Object[] { getDisplayName() }), null, getLocalString("getCurrentRow.selectgroup")));
      addChildElement(new TableFunction("gotoRow", "boolean", "gotoRow({arg1})", format("gotoRow.select", new Object[] { getDisplayName(), "{arg1}" }), a("int"), getLocalString("gotoRow.selectgroup")));
    }
  }

  public TableFunction addWhereFunction(String paramString1, String paramString2, String paramString3)
  {
    TableFunction localTableFunction = new TableFunction("setWhereObject(" + paramString1 + ")", "void", "setWhereObject(\"" + paramString1 + "\",{arg1})", paramString2, a(paramString3), true, getLocalString("setWhereObject.selectgroup"));
    addChildElement(localTableFunction);
    return localTableFunction;
  }

  private String k()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.sqlSelect.trim().replace('\n', ' ').replace('\r', ' '));
    int i = 0;
    int j = 1;
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

  private String l()
  {
    StringBuffer localStringBuffer = new StringBuffer("new Object[]{");
    Object localObject;
    int i;
    if (getParas().size() > 0)
    {
      localObject = getParas();
      for (i = 0; i < ((List)localObject).size(); i++)
      {
        ParameterModel localParameterModel = (ParameterModel)((List)localObject).get(i);
        if (!localParameterModel.isModeIn())
          continue;
        localStringBuffer.append(getTypeManager().c(localParameterModel.getValueType()) + ",");
      }
    }
    else
    {
      localObject = new StringBuffer(this.sqlSelect.trim().replace('\n', ' ').replace('\r', ' '));
      i = 0;
      int j = 1;
      int k = 0;
      while (true)
      {
        i = ((StringBuffer)localObject).indexOf("{", j);
        j = ((StringBuffer)localObject).indexOf("}", i);
        if ((i >= j) || (i < 0))
          break;
        localStringBuffer.append(getTypeManager().c(((StringBuffer)localObject).substring(i + 1, j)) + ",");
      }
    }
    if (localStringBuffer.charAt(localStringBuffer.length() - 1) == ',')
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    localStringBuffer.append("}");
    return (String)localStringBuffer.toString();
  }

  private String m()
  {
    StringBuffer localStringBuffer = new StringBuffer(l());
    int i = 0;
    int j = 0;
    int k = 1;
    while (true)
    {
      i = localStringBuffer.indexOf(" {", j);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      localStringBuffer.replace(i + 2, j, "arg" + k++);
    }
    return localStringBuffer.toString();
  }

  private String n()
  {
    String str1 = l();
    String str2 = "";
    int i = 0;
    int j = 0;
    int k = 1;
    while (true)
    {
      i = str1.indexOf(" {", j);
      j = str1.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      str2 = str2 + "{arg" + k++ + "}";
    }
    return str2;
  }

  private List o()
  {
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer(l());
    int i = 0;
    int j = 0;
    int k = 0;
    while (true)
    {
      i = localStringBuffer.indexOf(" {", j);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      localArrayList.add(new MethodParam(localStringBuffer.substring(i + 2, j).trim(), k++));
    }
    return localArrayList;
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    return false;
  }

  private boolean p()
  {
    if (getParas().size() > 0)
    {
      List localList = getParas();
      for (int i = 0; i < localList.size(); i++)
      {
        ParameterModel localParameterModel = (ParameterModel)localList.get(i);
        if (localParameterModel.isModeIn())
          return true;
      }
    }
    else
    {
      return this.sqlSelect.trim().indexOf("{") > 0;
    }
    return false;
  }

  public DBModel getDBModel()
  {
    if ((getParent() != null) && ((getParent() instanceof DBModel)))
      return (DBModel)getParent();
    return null;
  }

  public String getEnglishName()
  {
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
      return getDBModel().getVarName() + "_proc" + getParent().getElementPos(this);
    }
    return getEnglishName();
  }

  public String getValueName()
  {
    return getEnglishName();
  }

  public String getValueType()
  {
    return "com.flagleader.db.Procedure";
  }

  public String getSqlInfo()
  {
    return getSqlSelect().replace('\n', ' ').replace('\r', ' ');
  }

  public String getMainTableName()
  {
    return this.englishName;
  }

  public boolean check()
  {
    if (getDBModel() != null)
      return getDBModel().checkProcedure(getSqlSelect(), f(), i(), q());
    return false;
  }

  private Object[] q()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = getParas();
    for (int i = 0; i < localList.size(); i++)
    {
      ParameterModel localParameterModel = (ParameterModel)localList.get(i);
      localArrayList.add(getTypeManager().d(localParameterModel.getValueType()));
    }
    Object[] arrayOfObject = new Object[localArrayList.size()];
    for (int j = 0; j < localArrayList.size(); j++)
      arrayOfObject[j] = localArrayList.get(j);
    return arrayOfObject;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.ProcedureModel
 * JD-Core Version:    0.6.0
 */