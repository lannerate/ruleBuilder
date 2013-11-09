package com.flagleader.repository.rom;

import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.d;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.tree.Envionment;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBusinessObject extends AbstractElement
  implements IBusinessObject
{
  private String valueType = "";
  private boolean visible = false;
  private transient d editor = null;

  public void disposeAndUpdate()
  {
    super.dispose();
  }

  public AbstractBusinessObject(AbstractBusinessObject paramAbstractBusinessObject)
  {
    super(paramAbstractBusinessObject);
    this.visible = paramAbstractBusinessObject.isVisible();
    this.valueType = paramAbstractBusinessObject.valueType;
  }

  public AbstractBusinessObject()
  {
  }

  public g getJavaType()
  {
    return getTypeManager().a(getValueType());
  }

  public String getValueType()
  {
    return this.valueType;
  }

  public void changeValueType(String paramString)
  {
    if (this.valueType.equals(paramString))
      return;
    this.valueType = paramString;
    d();
  }

  private void d()
  {
    for (int i = getChildrenCount() - 1; i >= 0; i--)
    {
      if ((!(getElement(i) instanceof ISubFunction)) && (!(getElement(i) instanceof IMemberObject)))
        continue;
      removeElement(i);
    }
  }

  public String getUniqueName()
  {
    return getValueType() + "_" + getVarValue();
  }

  public void setValueType(String paramString)
  {
    this.valueType = paramString;
  }

  public boolean isVisible()
  {
    return this.visible;
  }

  public boolean isEditVisible()
  {
    return this.visible;
  }

  public void setVisible(boolean paramBoolean)
  {
    if (this.visible != paramBoolean)
      this.visible = paramBoolean;
  }

  public void setObjectEditor(d paramd)
  {
    this.editor = paramd;
  }

  public String sortedDisplayName(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    int i = localStringBuffer.indexOf("{arg");
    int j = 0;
    int k = 1;
    if (i >= 0)
      do
      {
        j = localStringBuffer.indexOf("}", i);
        if (j <= i)
          break;
        String str = localStringBuffer.substring(i + 4, j).trim();
        try
        {
          if (Integer.parseInt(str) < k)
            localStringBuffer.replace(i + 4, j, String.valueOf(k));
        }
        catch (NumberFormatException localNumberFormatException)
        {
        }
        i = localStringBuffer.indexOf("{arg", j);
        k++;
      }
      while (i >= 0);
    return localStringBuffer.toString();
  }

  public IBusinessObjectContainer getContainer()
  {
    for (Object localObject = this; (localObject != null) && (!(localObject instanceof IBusinessObjectContainer)); localObject = ((IElement)localObject).getParent());
    if ((localObject != null) && ((localObject instanceof IBusinessObjectContainer)))
    {
      if ((localObject instanceof CustomSql))
        return ((CustomSql)localObject).getDBModel();
      return (IBusinessObjectContainer)localObject;
    }
    return (IBusinessObjectContainer)null;
  }

  public void update()
  {
    if (this.editor != null)
      this.editor.a();
    else if (getContainer() != null)
      getContainer().updateViewer();
  }

  public List getAllParams()
  {
    ArrayList localArrayList = new ArrayList(3);
    if ((getParent() != null) && ((getParent() instanceof IBusinessObject)))
      localArrayList.addAll(((IBusinessObject)getParent()).getAllParams());
    localArrayList.addAll(getParams());
    return localArrayList;
  }

  public void addChildElement(IElement paramIElement, int paramInt)
  {
    super.addChildElement(paramIElement, paramInt);
    if ((paramIElement instanceof IBusinessObject))
    {
      IBusinessObjectContainer localIBusinessObjectContainer = getContainer();
      if (localIBusinessObjectContainer != null)
      {
        Envionment localEnvionment = localIBusinessObjectContainer.getEnvionment();
        if (localEnvionment != null)
          localEnvionment.registBusinessObject((IBusinessObject)paramIElement);
      }
    }
  }

  public void clearAllChildren()
  {
    IBusinessObjectContainer localIBusinessObjectContainer = getContainer();
    if (localIBusinessObjectContainer != null)
    {
      Envionment localEnvionment = localIBusinessObjectContainer.getEnvionment();
      if (localEnvionment != null)
        for (int i = 0; i < getChildrenCount(); i++)
        {
          IElement localIElement = getElement(i);
          if (!(localIElement instanceof IBusinessObject))
            continue;
          localEnvionment.unregistBusinessObject((IBusinessObject)localIElement);
        }
    }
    super.clearAllChildren();
  }

  public void removeChildElement(IElement paramIElement)
  {
    if ((paramIElement instanceof IBusinessObject))
    {
      IBusinessObjectContainer localIBusinessObjectContainer = getContainer();
      if (localIBusinessObjectContainer != null)
      {
        Envionment localEnvionment = localIBusinessObjectContainer.getEnvionment();
        if (localEnvionment != null)
          localEnvionment.unregistBusinessObject((IBusinessObject)paramIElement);
      }
    }
    super.removeChildElement(paramIElement);
  }

  public void removeElement(int paramInt)
  {
    IElement localIElement = getElement(paramInt);
    if ((localIElement instanceof IBusinessObject))
    {
      IBusinessObjectContainer localIBusinessObjectContainer = getContainer();
      if (localIBusinessObjectContainer != null)
      {
        Envionment localEnvionment = localIBusinessObjectContainer.getEnvionment();
        if (localEnvionment != null)
          localEnvionment.unregistBusinessObject((IBusinessObject)localIElement);
      }
    }
    super.removeElement(paramInt);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.AbstractBusinessObject
 * JD-Core Version:    0.6.0
 */