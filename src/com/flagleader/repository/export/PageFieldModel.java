package com.flagleader.repository.export;

import com.flagleader.export.IExportField;
import com.flagleader.export.JavaTypeManager;
import com.flagleader.export.PagesMessages;
import com.flagleader.export.Type;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PageFieldModel extends AbstractPropertyModel
  implements IPageField
{
  private String variableName = "";
  private String valueType = "";
  private String len = "0";
  private String nullType = "null";
  private String inputType = "notdisplay";
  private String resultType = "notdisplay";
  private String inputValueType = "nottest";
  private String statType = "inout";
  private String defaultValue = "";
  private String showValue = "resultvalue";
  private String valueFrom = "request";

  public PageFieldModel(PageFieldModel paramPageFieldModel)
  {
    super(paramPageFieldModel);
    this.variableName = paramPageFieldModel.variableName;
    this.valueType = paramPageFieldModel.valueType;
    this.len = paramPageFieldModel.len;
    this.nullType = paramPageFieldModel.nullType;
    this.inputType = paramPageFieldModel.inputType;
    this.resultType = paramPageFieldModel.resultType;
    this.statType = paramPageFieldModel.statType;
    this.inputValueType = paramPageFieldModel.inputValueType;
    this.showValue = paramPageFieldModel.showValue;
    this.defaultValue = paramPageFieldModel.defaultValue;
    this.valueFrom = paramPageFieldModel.valueFrom;
  }

  public PageFieldModel()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitPageFieldModel(this);
  }

  public String toString()
  {
    return this.variableName;
  }

  public String getName()
  {
    return "PageFieldModel";
  }

  public void update(MappingVariable paramMappingVariable, IPage paramIPage)
  {
    setVariableName(paramMappingVariable.getVariableName());
    setValueType(paramMappingVariable.getValueType());
    setDisplayName(paramMappingVariable.getDisplayName());
    if (paramMappingVariable.getInout() == 1)
      setStatType("input");
    else if (paramMappingVariable.getInout() == 2)
      setStatType("output");
    else if (paramMappingVariable.getInout() == 3)
      setStatType("inout");
    else if (paramMappingVariable.getInout() == 0)
      setStatType("noput");
    if ((paramMappingVariable.getVariableName().equalsIgnoreCase("su")) || (paramMappingVariable.getVariableName().equalsIgnoreCase("success")))
      setStatType("success");
    else if ((paramMappingVariable.getVariableName().equalsIgnoreCase("err")) || (paramMappingVariable.getVariableName().equalsIgnoreCase("error")))
      setStatType("error");
    String[] arrayOfString = getPageTypeNames();
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if (paramIPage.getPreferences().getStringArray(paramIPage.getImportFile() + "." + arrayOfString[i]) == null)
        continue;
      setPageTypeValue(arrayOfString[i], paramIPage.getPreferences().getStringArray(paramIPage.getImportFile() + "." + arrayOfString[i])[0]);
    }
    if ((getJavaType().isFloat()) || (getJavaType().isDouble()))
    {
      setInputValueType("float");
      setInputType("numbertext");
      setLen("20");
      setPropertyValue("precision", "2");
    }
    else if ((getJavaType().isLong()) || (getJavaType().isInteger()) || (getJavaType().isShort()))
    {
      setInputValueType("number");
      setInputType("numbertext");
      setLen("10");
    }
    else if ((getJavaType().isDate()) || (getJavaType().isDateTime()))
    {
      setInputValueType("date");
      setInputType("datetext");
    }
    else if (getJavaType().isTime())
    {
      setInputValueType("time");
    }
    else if (getJavaType().isDateTime())
    {
      setInputType("monthtext");
      setInputValueType("datetime");
    }
    else if (getJavaType().isBoolean())
    {
      setInputType("checkbox");
    }
    else if (getJavaType().isList())
    {
      if (getJavaType().isListList())
      {
        setInputType("notdisplay");
        setResultType("table");
      }
      else
      {
        setInputType("multiselect");
      }
    }
    else if ((getJavaType().isFile()) || (getJavaType().isBinary()))
    {
      setInputType("fileinput");
    }
  }

  public IExportField getPageField(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof PageFieldModel))
        continue;
      if (((PageFieldModel)localObject).getVariableName().equals(paramString))
        return (PageFieldModel)localObject;
      if (((PageFieldModel)localObject).getPageField(paramString) != null)
        return ((PageFieldModel)localObject).getPageField(paramString);
    }
    return null;
  }

  public Type getJavaType()
  {
    return JavaTypeManager.getInstance().getType(this.valueType);
  }

  public String getJavaTypeName()
  {
    JavaTypeManager.getInstance();
    return JavaTypeManager.getJavaObjectTypeName(getJavaType());
  }

  public String getVariableName()
  {
    return this.variableName;
  }

  public String getValueType()
  {
    return this.valueType;
  }

  public String getLen()
  {
    return this.len;
  }

  public boolean isUnNull()
  {
    return this.nullType.equalsIgnoreCase("unnull");
  }

  public void setVariableName(String paramString)
  {
    this.variableName = paramString;
  }

  public void setValueType(String paramString)
  {
    this.valueType = paramString;
  }

  public void setLen(String paramString)
  {
    this.len = paramString;
  }

  public IElement deepClone()
  {
    return new PageFieldModel(this);
  }

  public String getVarName()
  {
    if (StringUtil.isJavaIdentifier(this.variableName))
      return this.variableName;
    if (getParent() != null)
      return "var" + getParent().getElementPos(this);
    return this.variableName.toLowerCase();
  }

  public String getGSName()
  {
    return getVarName().substring(0, 1).toUpperCase() + getVarName().substring(1);
  }

  public String getCheckType()
  {
    String str = "";
    if (isUnNull())
      str = str + "R";
    else
      str = str + "N";
    return str;
  }

  public String getInputType()
  {
    return this.inputType;
  }

  public String getResultType()
  {
    return this.resultType;
  }

  public void setInputType(String paramString)
  {
    this.inputType = paramString;
  }

  public void setResultType(String paramString)
  {
    this.resultType = paramString;
  }

  public IExportField[] getChildFields()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof PageFieldModel))
        continue;
      localArrayList.add(localList.get(i));
    }
    PageFieldModel[] arrayOfPageFieldModel = new PageFieldModel[localArrayList.size()];
    for (int j = 0; j < localArrayList.size(); j++)
      arrayOfPageFieldModel[j] = ((PageFieldModel)localArrayList.get(j));
    return arrayOfPageFieldModel;
  }

  public int[] getListPos()
  {
    IExportField[] arrayOfIExportField = getChildFields();
    int[] arrayOfInt = new int[arrayOfIExportField.length];
    for (int i = 0; i < arrayOfIExportField.length; i++)
    {
      String str1 = arrayOfIExportField[i].getVarName();
      if (str1.lastIndexOf("_") > 0)
      {
        String str2 = str1.substring(str1.lastIndexOf("_") + 1);
        try
        {
          arrayOfInt[i] = Integer.parseInt(str2);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          arrayOfInt[i] = 0;
        }
      }
      else
      {
        arrayOfInt[i] = 0;
      }
    }
    return arrayOfInt;
  }

  public String getDefaultValue()
  {
    return this.defaultValue;
  }

  public void setDefaultValue(String paramString)
  {
    this.defaultValue = paramString;
  }

  public int getRows()
  {
    return getRows(50);
  }

  public int getRows(int paramInt)
  {
    int i = Integer.valueOf(this.len).intValue();
    if (i <= paramInt * 5)
      return 5;
    return 1 + i / paramInt;
  }

  public String getStatType()
  {
    return this.statType;
  }

  public void setStatType(String paramString)
  {
    this.statType = paramString;
  }

  public String getInputValueType()
  {
    return this.inputValueType;
  }

  public void setInputValueType(String paramString)
  {
    this.inputValueType = paramString;
  }

  public String getShowValue()
  {
    return this.showValue;
  }

  public void setShowValue(String paramString)
  {
    this.showValue = paramString;
  }

  public String getNullType()
  {
    return this.nullType;
  }

  public void setNullType(String paramString)
  {
    this.nullType = paramString;
  }

  public String getValueFrom()
  {
    return this.valueFrom;
  }

  public void setValueFrom(String paramString)
  {
    this.valueFrom = paramString;
  }

  public String[] getPageTypes()
  {
    return new String[] { this.valueType, this.nullType, this.inputType, this.resultType, this.statType, this.inputValueType, this.showValue, this.valueFrom };
  }

  public String[] getPageTypeNames()
  {
    return new String[] { "PageInOut", "PageInput", "PageOut", "varType", "InputType", "PageNull", "showValue", "valueFrom" };
  }

  public String getPageTypeValue(String paramString)
  {
    if (paramString.equalsIgnoreCase("PageInOut"))
      return this.statType;
    if (paramString.equalsIgnoreCase("PageInput"))
      return this.inputType;
    if (paramString.equalsIgnoreCase("PageOut"))
      return this.resultType;
    if (paramString.equalsIgnoreCase("varType"))
      return this.valueType;
    if (paramString.equalsIgnoreCase("InputType"))
      return this.inputValueType;
    if (paramString.equalsIgnoreCase("PageNull"))
      return this.nullType;
    if (paramString.equalsIgnoreCase("showValue"))
      return this.showValue;
    if (paramString.equalsIgnoreCase("valueFrom"))
      return this.valueFrom;
    return "";
  }

  public String getEnglishName()
  {
    if (isEmptyProp("englishName"))
      return getDisplayName();
    return getPropertyValue("englishName");
  }

  public void setPageTypeValue(String paramString1, String paramString2)
  {
    if (paramString1.equalsIgnoreCase("PageInOut"))
      this.statType = paramString2;
    else if (paramString1.equalsIgnoreCase("PageInput"))
      this.inputType = paramString2;
    else if (paramString1.equalsIgnoreCase("PageOut"))
      this.resultType = paramString2;
    else if (paramString1.equalsIgnoreCase("varType"))
      this.valueType = paramString2;
    else if (paramString1.equalsIgnoreCase("InputType"))
      this.inputValueType = paramString2;
    else if (paramString1.equalsIgnoreCase("PageNull"))
      this.nullType = paramString2;
    else if (paramString1.equalsIgnoreCase("showValue"))
      this.showValue = paramString2;
    else if (paramString1.equalsIgnoreCase("valueFrom"))
      this.valueFrom = paramString2;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.PageFieldModel
 * JD-Core Version:    0.6.0
 */