package com.flagleader.repository.db;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.tree.AbstractBOContainer;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.NodeInfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnumTable extends AbstractBOContainer
{
  public static final String NAME = "EnumTable";
  public static final String DISPLAYNAME = getLocalString("EnumTable.text");
  public static final String COMMONNAME = getLocalString("EnumTable.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("EnumTable", DISPLAYNAME, DISPLAYNAME);
  private String enumType = "string";
  private String sqlSelect = "";

  public EnumTable(EnumTable paramEnumTable)
  {
    super(paramEnumTable);
    this.sqlSelect = paramEnumTable.sqlSelect;
    this.enumType = paramEnumTable.enumType;
  }

  public EnumTable()
  {
  }

  public EnumTable(String paramString)
  {
    super(paramString);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitEnumTable(this);
  }

  public IElement deepClone()
  {
    return new EnumTable(this);
  }

  public String getName()
  {
    return "EnumTable";
  }

  protected boolean a(IElement paramIElement)
  {
    return (paramIElement instanceof ConstantEnum);
  }

  public List getEnums(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof ConstantEnum)) || (!((ConstantEnum)localObject).isEditVisible()) || ((paramString != null) && (paramString.length() != 0) && (!((ConstantEnum)localObject).getJavaType().b(paramString))))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public List getFields()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof ConstantEnum))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
    ConstantEnum localConstantEnum = new ConstantEnum(paramString);
    addChildElement(localConstantEnum);
    return localConstantEnum;
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    if ((paramIElement instanceof ConstantEnum))
    {
      initUndoable();
      if ((paramInt >= 0) && (paramInt < getChildrenCount()))
        addChildElement(paramIElement, paramInt);
      else
        addChildElement(paramIElement);
      takeSnapshot();
      setModified(true);
      return true;
    }
    if ((paramIElement instanceof ElementContainer))
    {
      if (paramInt < 0)
        paramInt = getChildrenCount();
      initUndoable();
      int i = 0;
      Iterator localIterator = ((ElementContainer)paramIElement).getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof ConstantEnum))
          continue;
        addChildElement((ConstantEnum)localObject, paramInt++);
        i = 1;
      }
      if (i != 0)
      {
        takeSnapshot();
        setModified(true);
      }
      return true;
    }
    return false;
  }

  public String getEnumType()
  {
    return this.enumType;
  }

  public void setEnumType(String paramString)
  {
    this.enumType = paramString;
  }

  public String getSqlSelect()
  {
    return this.sqlSelect;
  }

  public void setSqlSelect(String paramString)
  {
    this.sqlSelect = paramString;
  }

  private Connection d()
  {
    if ((getParent() != null) && ((getParent() instanceof DBModel)))
      return ((DBModel)getParent()).getConnection();
    return null;
  }

  private String a(Object paramObject)
  {
    if (this.enumType.equalsIgnoreCase("string"))
    {
      if (paramObject != null)
        return paramObject.toString();
      return "";
    }
    if ((this.enumType.equalsIgnoreCase("int")) || (this.enumType.equalsIgnoreCase("double")))
    {
      if (paramObject != null)
        return paramObject.toString();
      return "0";
    }
    if (this.enumType.equalsIgnoreCase("boolean"))
    {
      if (paramObject != null)
        return paramObject.toString();
      return "false";
    }
    return "";
  }

  public void changeSqlText(String paramString)
  {
    Statement localStatement = null;
    ResultSet localResultSet = null;
    Connection localConnection = null;
    localConnection = d();
    if (localConnection == null)
      return;
    try
    {
      localStatement = localConnection.createStatement();
      try
      {
        localStatement.setQueryTimeout(20);
      }
      catch (Exception localException1)
      {
      }
      if (paramString.toLowerCase().trim().startsWith("select"))
      {
        localResultSet = localStatement.executeQuery(paramString);
        if (localResultSet != null)
        {
          setTableMetaData(localResultSet.getMetaData());
          e();
          int i = localResultSet.getMetaData().getColumnCount();
          while (localResultSet.next())
            if (i == 1)
              addChildElement(new ConstantEnum(a(localResultSet.getObject(1)), a(localResultSet.getObject(1)), true));
            else
              addChildElement(new ConstantEnum(a(localResultSet.getObject(1)), a(localResultSet.getObject(2)), true));
        }
        if (localResultSet != null)
          localResultSet.close();
        localResultSet = null;
        setSqlSelect(paramString);
        updateEnumType();
      }
      if (localStatement != null)
        localStatement.close();
      localStatement = null;
    }
    catch (SQLException localSQLException1)
    {
      throw localSQLException1;
    }
    finally
    {
      try
      {
        if (localResultSet != null)
          localResultSet.close();
      }
      catch (Exception localException2)
      {
      }
      try
      {
        if (localStatement != null)
          localStatement.close();
      }
      catch (Exception localException3)
      {
      }
      try
      {
        localConnection.close();
      }
      catch (SQLException localSQLException2)
      {
      }
    }
  }

  private void e()
  {
    clearAllChildren();
  }

  public DBModel getDBModel()
  {
    if ((getParent() != null) && ((getParent() instanceof DBModel)))
      return (DBModel)getParent();
    return null;
  }

  public void updateEnumType()
  {
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if (!(getElement(i) instanceof ConstantEnum))
        continue;
      ((ConstantEnum)getElement(i)).changeValueType(getEnumType());
    }
  }

  public void changeDisplayName(String paramString)
  {
    setDisplayName(paramString);
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if (!(a().get(i) instanceof ConstantEnum))
        continue;
      ((ConstantEnum)a().get(i)).setGroupName(paramString);
    }
    setModified(true);
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      ((ITreeNode)getParent()).setModified(true);
  }

  public void setTableMetaData(ResultSetMetaData paramResultSetMetaData)
  {
    if (paramResultSetMetaData.getColumnCount() > 1)
    {
      int i = paramResultSetMetaData.getColumnType(1);
      String str = "string";
      if ((i == -5) || (i == 4) || (i == 2) || (i == 5))
        str = "int";
      else if ((i == 6) || (i == 8) || (i == 7))
        str = "double";
      else if ((i == 91) || (i == 92) || (i == 93))
        str = "string";
      else if (i == 16)
        str = "boolean";
      this.enumType = str;
    }
  }

  public ConstantEnum getFieldByDisplay(String paramString)
  {
    List localList = getFields();
    for (int i = 0; i < localList.size(); i++)
    {
      ConstantEnum localConstantEnum = (ConstantEnum)localList.get(i);
      if (localConstantEnum.getDisplayName().equalsIgnoreCase(paramString))
        return localConstantEnum;
    }
    return null;
  }

  public void replaceVariables(List paramList1, List paramList2, List paramList3, List paramList4)
  {
    List localList = getFields();
    for (int i = getChildrenCount() - 1; i >= 0; i--)
    {
      if (!(getElement(i) instanceof ConstantEnum))
        continue;
      removeElement(i);
    }
    ConstantEnum localConstantEnum1;
    for (i = 0; i < paramList1.size(); i++)
    {
      localConstantEnum1 = new ConstantEnum();
      localConstantEnum1.setValueName(String.valueOf(paramList1.get(i)));
      localConstantEnum1.setDisplayName(String.valueOf(paramList3.get(i)));
      localConstantEnum1.setValueType(getEnumType());
      if (String.valueOf(paramList4.get(i)).length() > 0)
        localConstantEnum1.setGroupName(String.valueOf(paramList4.get(i)));
      localConstantEnum1.setVisible(true);
      addChildElement(localConstantEnum1);
    }
    for (i = 0; i < localList.size(); i++)
    {
      localConstantEnum1 = (ConstantEnum)localList.get(i);
      ConstantEnum localConstantEnum2 = getFieldByDisplay(localConstantEnum1.getDisplayName());
      if (localConstantEnum2 == null)
        continue;
      localConstantEnum2.setUuid(localConstantEnum1.getUuid());
    }
    setModified(true);
    updateViewer();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.EnumTable
 * JD-Core Version:    0.6.0
 */