package com.flagleader.repository.export;

import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.tree.AdvancedProperty;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPropertyModel extends AbstractElement
{
  private ArrayList advanceProperties = new ArrayList();

  public AbstractPropertyModel()
  {
  }

  public AbstractPropertyModel(String paramString)
  {
    super(paramString);
  }

  public AbstractPropertyModel(AbstractPropertyModel paramAbstractPropertyModel)
  {
    super(paramAbstractPropertyModel);
    for (int i = 0; i < paramAbstractPropertyModel.getAdvanceProperties().length; i++)
      this.advanceProperties.add(new AdvancedProperty(paramAbstractPropertyModel.getAdvanceProperties()[i]));
  }

  public AdvancedProperty[] getAdvanceProperties()
  {
    AdvancedProperty[] arrayOfAdvancedProperty = new AdvancedProperty[this.advanceProperties.size()];
    for (int i = 0; i < this.advanceProperties.size(); i++)
      arrayOfAdvancedProperty[i] = ((AdvancedProperty)this.advanceProperties.get(i));
    return arrayOfAdvancedProperty;
  }

  public void addAdvanceProperty(AdvancedProperty paramAdvancedProperty)
  {
    this.advanceProperties.add(paramAdvancedProperty);
  }

  public List getPropertiesList()
  {
    return this.advanceProperties;
  }

  public String getPropertyValue(String paramString)
  {
    for (int i = 0; i < this.advanceProperties.size(); i++)
      if (((AdvancedProperty)this.advanceProperties.get(i)).getKey().equals(paramString))
        return ((AdvancedProperty)this.advanceProperties.get(i)).getProperty();
    return "";
  }

  public AdvancedProperty getProperty(String paramString)
  {
    for (int i = 0; i < this.advanceProperties.size(); i++)
      if (((AdvancedProperty)this.advanceProperties.get(i)).getKey().equals(paramString))
        return (AdvancedProperty)this.advanceProperties.get(i);
    return null;
  }

  public void setPropertyValue(String paramString1, String paramString2)
  {
    removeProperty(paramString1);
    this.advanceProperties.add(new AdvancedProperty(paramString1, paramString2));
  }

  public void removeProperty(String paramString)
  {
    for (int i = 0; i < this.advanceProperties.size(); i++)
    {
      if (!((AdvancedProperty)this.advanceProperties.get(i)).getKey().equals(paramString))
        continue;
      this.advanceProperties.remove(i);
    }
  }

  public String[] getKeysPre(String paramString)
  {
    ArrayList localArrayList = new ArrayList(this.advanceProperties.size());
    for (int i = 0; i < this.advanceProperties.size(); i++)
    {
      if ((paramString.length() != 0) && (!((AdvancedProperty)this.advanceProperties.get(i)).getKey().toLowerCase().startsWith(paramString.toLowerCase())))
        continue;
      localArrayList.add(((AdvancedProperty)this.advanceProperties.get(i)).getKey());
    }
    String[] arrayOfString = new String[localArrayList.size()];
    for (int j = 0; j < localArrayList.size(); j++)
      arrayOfString[j] = ((String)localArrayList.get(j));
    return arrayOfString;
  }

  public boolean isEmptyProp(String paramString)
  {
    try
    {
      if (getPropertyValue(paramString).length() == 0)
        return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public boolean isPropValue(String paramString1, String paramString2)
  {
    return getPropertyValue(paramString1).equals(paramString2);
  }

  public boolean isPropValueNoCase(String paramString1, String paramString2)
  {
    return getPropertyValue(paramString1).equalsIgnoreCase(paramString2);
  }

  public abstract String[] getPageTypes();

  public IPage getPage()
  {
    if ((getParent() instanceof IPage))
      return (IPage)getParent();
    if ((getParent() instanceof AbstractPropertyModel))
      return ((AbstractPropertyModel)getParent()).getPage();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.AbstractPropertyModel
 * JD-Core Version:    0.6.0
 */