package com.flagleader.repository.export;

import com.flagleader.export.IExportElement;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public class PageElementModel extends AbstractPropertyModel
  implements IPageElement
{
  private String elementName = "";
  private String elementType = "";

  public PageElementModel(PageElementModel paramPageElementModel)
  {
    super(paramPageElementModel);
    this.elementName = paramPageElementModel.elementName;
    this.elementType = paramPageElementModel.elementType;
  }

  public PageElementModel()
  {
  }

  public PageElementModel(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.elementType = paramString2;
    this.elementName = paramString3;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitPageElementModel(this);
  }

  public String toString()
  {
    return this.elementName;
  }

  public String getName()
  {
    return "PageElementModel";
  }

  public String getElementName()
  {
    return this.elementName;
  }

  public String getElementType()
  {
    return this.elementType;
  }

  public void setElementName(String paramString)
  {
    this.elementName = paramString;
  }

  public void setElementType(String paramString)
  {
    this.elementType = paramString;
  }

  public IElement deepClone()
  {
    return new PageElementModel(this);
  }

  public String getVarName()
  {
    if (StringUtil.isJavaIdentifier(this.elementName))
      return this.elementName;
    if (getParent() != null)
      return "ele" + getParent().getElementPos(this);
    return this.elementName.toLowerCase();
  }

  public String getGSName()
  {
    return getVarName().substring(0, 1).toUpperCase() + getVarName().substring(1);
  }

  public IExportElement[] getChildFields()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof PageElementModel))
        continue;
      localArrayList.add(localList.get(i));
    }
    PageElementModel[] arrayOfPageElementModel = new PageElementModel[localArrayList.size()];
    for (int j = 0; j < localArrayList.size(); j++)
      arrayOfPageElementModel[j] = ((PageElementModel)localArrayList.get(j));
    return arrayOfPageElementModel;
  }

  public int[] getListPos()
  {
    IExportElement[] arrayOfIExportElement = getChildFields();
    int[] arrayOfInt = new int[arrayOfIExportElement.length];
    for (int i = 0; i < arrayOfIExportElement.length; i++)
    {
      String str1 = arrayOfIExportElement[i].getVarName();
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

  public String[] getPageTypes()
  {
    return new String[] { this.elementType };
  }

  public String getEnglishName()
  {
    if (isEmptyProp("englishName"))
      return getDisplayName();
    return getPropertyValue("englishName");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.PageElementModel
 * JD-Core Version:    0.6.0
 */