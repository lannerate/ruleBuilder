package com.flagleader.repository.db;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.repository.tree.AbstractBOContainer;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CustomSql extends AbstractBOContainer
{
  private String sqlCustom = "";
  public static final String NAME = "CustomSql";
  public String valueType = "void";
  private HashMap paramMap = new HashMap();

  public CustomSql(CustomSql paramCustomSql)
  {
    super(paramCustomSql);
    this.sqlCustom = paramCustomSql.sqlCustom;
    this.valueType = paramCustomSql.valueType;
  }

  public CustomSql()
  {
  }

  public CustomSql(String paramString1, String paramString2, String paramString3)
  {
    super(paramString2);
    this.valueType = paramString3;
    this.sqlCustom = paramString1;
    e();
  }

  public String toString()
  {
    return this.sqlCustom;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitCustomSql(this);
  }

  public String getName()
  {
    return "CustomSql";
  }

  public IElement deepClone()
  {
    return new CustomSql(this);
  }

  public void changeDisplayName(String paramString)
  {
    setDisplayName(paramString);
    getExecuteFunction().setDisplayName(format("excute.table", new Object[] { l(), getDisplayName() }));
    setModified(true);
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      ((ITreeNode)getParent()).setModified(true);
  }

  protected TableFunction a(String paramString)
  {
    List localList = d();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof TableFunction)) && (((TableFunction)localList.get(i)).getValueName().equals(paramString)))
        return (TableFunction)localList.get(i);
    return null;
  }

  protected List d()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IBusinessObjectEditen))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  private void e()
  {
    if (d().size() == 0)
      addChildElement(new TableFunction("execute(\"" + i() + "\")", f(), h() + "(\"" + i() + "\"," + k() + ")", format("excute.table", new Object[] { l(), getDisplayName() }), m(), true, ""));
  }

  private String f()
  {
    String str = this.sqlCustom.toLowerCase().trim();
    if (str.startsWith("select"))
    {
      if (this.valueType.equals("string"))
        return "string";
      if (this.valueType.equals("int"))
        return "int";
      if (this.valueType.equals("short"))
        return "short";
      if (this.valueType.equals("long"))
        return "long";
      if (this.valueType.equals("float"))
        return "float";
      if (this.valueType.equals("double"))
        return "double";
      if (this.valueType.equals("byte[]"))
        return "byte[]";
      if (this.valueType.equals("boolean"))
        return "boolean";
      if (this.valueType.equals("date"))
        return "date";
      if (this.valueType.equals("time"))
        return "time";
      if (this.valueType.equals("datetime"))
        return "datetime";
      return "boolean";
    }
    if (str.startsWith("update"))
      return "int";
    if (str.startsWith("delete"))
      return "int";
    if (str.startsWith("insert"))
      return "int";
    return "boolean";
  }

  private String h()
  {
    String str = this.sqlCustom.toLowerCase().trim();
    if (str.startsWith("select"))
    {
      if (this.valueType.equals("string"))
        return "executeString";
      if (this.valueType.equals("int"))
        return "executeInteger";
      if (this.valueType.equals("short"))
        return "executeShort";
      if (this.valueType.equals("long"))
        return "executeLong";
      if (this.valueType.equals("float"))
        return "executeFloat";
      if (this.valueType.equals("double"))
        return "executeDouble";
      if (this.valueType.equals("byte[]"))
        return "executeBytes";
      if (this.valueType.equals("boolean"))
        return "executeBoolean";
      if (this.valueType.equals("date"))
        return "executeDate";
      if (this.valueType.equals("time"))
        return "executeDate";
      if (this.valueType.equals("datetime"))
        return "executeDate";
      return "execute";
    }
    if (str.startsWith("update"))
      return "executeUpdate";
    if (str.startsWith("delete"))
      return "executeUpdate";
    if (str.startsWith("insert"))
      return "executeInsert";
    return "execute";
  }

  public void changeSqlText(String paramString)
  {
    if (getDBModel() != null)
    {
      setSqlCustom(paramString);
      getExecuteFunction().setValueName("execute(\"" + i() + "\")");
      getExecuteFunction().setVariableName(h() + "(\"" + i() + "\"," + k() + ")");
      getExecuteFunction().setDisplayName(format("excute.table", new Object[] { l(), getDisplayName() }));
      getExecuteFunction().setParams(m());
      if (getMainPackage() != null)
        getMainPackage().changeParamType(getExecuteFunction());
    }
  }

  public void changeValueType(String paramString)
  {
    setValueType(paramString);
    getExecuteFunction().setValueType(f());
    getExecuteFunction().setVariableName(h() + "(\"" + i() + "\"," + k() + ")");
  }

  public TableFunction getExecuteFunction()
  {
    List localList = d();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof TableFunction))
        return (TableFunction)localList.get(i);
    e();
    return null;
  }

  public void changeVarName()
  {
    getExecuteFunction().setVariableName(h() + "(\"" + i() + "\"," + k() + ")");
  }

  private String i()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.sqlCustom.replace('\n', ' ').replace('\r', ' '));
    int i = 0;
    int j = 0;
    while (true)
    {
      i = localStringBuffer.indexOf("{", 0);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      localStringBuffer.replace(i, j + 1, " ? ");
    }
    return localStringBuffer.toString();
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
    StringBuffer localStringBuffer2 = new StringBuffer(this.sqlCustom.replace('\n', ' ').replace('\r', ' '));
    List localList = m();
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

  private String k()
  {
    StringBuffer localStringBuffer1 = new StringBuffer("new Object[]{");
    StringBuffer localStringBuffer2 = new StringBuffer(this.sqlCustom.replace('\n', ' ').replace('\r', ' '));
    List localList = m();
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

  private String l()
  {
    String str = "";
    StringBuffer localStringBuffer = new StringBuffer(this.sqlCustom.replace('\n', ' ').replace('\r', ' '));
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

  private List m()
  {
    ArrayList localArrayList = new ArrayList(3);
    this.paramMap.clear();
    StringBuffer localStringBuffer = new StringBuffer(this.sqlCustom.replace('\n', ' ').replace('\r', ' '));
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
      m();
    Object localObject = this.paramMap.get(paramString);
    if (localObject != null)
      return localObject.toString();
    return "";
  }

  private String b(String paramString)
  {
    paramString = StringUtil.replace("=", "", paramString);
    paramString = StringUtil.replace("like", "", paramString);
    paramString = StringUtil.replace("in", "", paramString);
    paramString = StringUtil.replace("<", "", paramString);
    paramString = StringUtil.replace(">", "", paramString);
    paramString = paramString.trim();
    if ((paramString.lastIndexOf(".") > paramString.lastIndexOf(" ")) && (paramString.lastIndexOf(".") > 0))
      return paramString.substring(paramString.lastIndexOf(".") + 1);
    if (paramString.lastIndexOf(" ") > 0)
      return paramString.substring(paramString.lastIndexOf(" ") + 1);
    return "";
  }

  public DBModel getDBModel()
  {
    if ((getParent() != null) && ((getParent() instanceof DBModel)))
      return (DBModel)getParent();
    return null;
  }

  public boolean check()
  {
    if (getDBModel() != null)
      return getDBModel().checkCustomSql(getSqlCustom());
    return false;
  }

  public String getEnglishName()
  {
    if (getDBModel() != null)
      return getDBModel().getVarName();
    return getUuid();
  }

  public String getSqlCustom()
  {
    return this.sqlCustom;
  }

  public String getMainTableName()
  {
    String str1 = this.sqlCustom.toLowerCase().trim();
    String str3;
    if (str1.startsWith("select"))
    {
      int i = str1.indexOf("from");
      if (i > 0)
      {
        str3 = str1.substring(i + 4).trim();
        if ((str3.indexOf(" ") > 0) && (str3.indexOf(",") > 0))
        {
          if (str3.indexOf(",") > str3.indexOf(" "))
            return str3.substring(0, str3.indexOf(" ")).trim();
          return str3.substring(0, str3.indexOf(",")).trim();
        }
        if (str3.indexOf(" ") > 0)
          return str3.substring(0, str3.indexOf(" ")).trim();
        if (str3.indexOf(",") > 0)
          return str3.substring(0, str3.indexOf(",")).trim();
        return str3;
      }
    }
    if (str1.startsWith("update"))
    {
      String str2 = str1.substring(6).trim();
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
    }
    int j;
    if (str1.startsWith("insert"))
    {
      j = str1.indexOf("into");
      if (j > 0)
      {
        str3 = str1.substring(j + 4).trim();
        if ((str3.indexOf(" ") > 0) && (str3.indexOf(",") > 0))
        {
          if (str3.indexOf(",") > str3.indexOf(" "))
            return str3.substring(0, str3.indexOf(" ")).trim();
          return str3.substring(0, str3.indexOf(",")).trim();
        }
        if (str3.indexOf(" ") > 0)
          return str3.substring(0, str3.indexOf(" ")).trim();
        if (str3.indexOf(",") > 0)
          return str3.substring(0, str3.indexOf(",")).trim();
      }
    }
    if (str1.startsWith("delete"))
    {
      j = str1.indexOf("from");
      if (j > 0)
      {
        str3 = str1.substring(j + 4).trim();
        if ((str3.indexOf(" ") > 0) && (str3.indexOf(",") > 0))
        {
          if (str3.indexOf(",") > str3.indexOf(" "))
            return str3.substring(0, str3.indexOf(" ")).trim();
          return str3.substring(0, str3.indexOf(",")).trim();
        }
        if (str3.indexOf(" ") > 0)
          return str3.substring(0, str3.indexOf(" ")).trim();
        if (str3.indexOf(",") > 0)
          return str3.substring(0, str3.indexOf(",")).trim();
      }
      else if (str1.indexOf("where") > 0)
      {
        return str1.substring(6, str1.indexOf("where")).trim();
      }
    }
    return "";
  }

  public void setSqlCustom(String paramString)
  {
    this.sqlCustom = paramString;
  }

  public boolean canCreateEditen()
  {
    return false;
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    return false;
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
    return null;
  }

  public Iterator getEditens()
  {
    return d().iterator();
  }

  public void dispose()
  {
    ITreeNode localITreeNode = null;
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      localITreeNode = (ITreeNode)getParent();
    super.dispose();
  }

  public void setParent(IElement paramIElement)
  {
    super.setParent(paramIElement);
  }

  public String getInfo()
  {
    return this.sqlCustom;
  }

  public String getValueType()
  {
    return this.valueType;
  }

  public void setValueType(String paramString)
  {
    this.valueType = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.CustomSql
 * JD-Core Version:    0.6.0
 */