package com.flagleader.repository.tree;

import com.flagleader.engine.Property;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractBOContainer extends AbstractPackageElement
  implements IBusinessObjectContainer
{
  public AbstractBOContainer(AbstractBOContainer paramAbstractBOContainer)
  {
    super(paramAbstractBOContainer);
  }

  public AbstractBOContainer()
  {
  }

  public AbstractBOContainer(String paramString)
  {
    super(paramString);
  }

  public List getAllEditens()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    Iterator localIterator = getEditens();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IBusinessObjectEditen))
        continue;
      localArrayList.add(localObject);
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)localObject;
      localArrayList.addAll(localIBusinessObjectEditen.getAllSubEditens());
    }
    return localArrayList;
  }

  public IBusinessObjectEditen exitsEditens(String paramString)
  {
    List localList = getAllEditens();
    for (int i = 0; i < localList.size(); i++)
      if (((IBusinessObjectEditen)localList.get(i)).getValueName().equalsIgnoreCase(paramString))
        return (IBusinessObjectEditen)localList.get(i);
    return null;
  }

  public IBusinessObject exitsChildBusinessObject(IBusinessObject paramIBusinessObject)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      IElement localIElement = (IElement)localList.get(i);
      if (((localIElement instanceof IBusinessObject)) && (localIElement.getName().equals(paramIBusinessObject.getName())) && (((IBusinessObject)localIElement).getValueName().equals(paramIBusinessObject.getValueName())))
        return (IBusinessObject)localIElement;
    }
    return null;
  }

  public IBusinessObjectEditen getEditen(String paramString)
  {
    List localList = getAllEditens();
    for (int i = 0; i < localList.size(); i++)
      if (((IBusinessObjectEditen)localList.get(i)).getValueName().equals(paramString))
        return (IBusinessObjectEditen)localList.get(i);
    return null;
  }

  public IBusinessObjectEditen getNoCaseEditen(String paramString1, String paramString2)
  {
    List localList = getAllEditens();
    for (int i = 0; i < localList.size(); i++)
      if ((((IBusinessObjectEditen)localList.get(i)).getValueName().equalsIgnoreCase(paramString1)) || (((IBusinessObjectEditen)localList.get(i)).getDisplayName().equalsIgnoreCase(paramString2)))
        return (IBusinessObjectEditen)localList.get(i);
    return null;
  }

  public Iterator getEditens()
  {
    return getChildrenIterator();
  }

  public void sortBy(int paramInt, String paramString, boolean paramBoolean)
  {
    initUndoable();
    for (int i = 1; i < getChildrenCount(); i++)
      a(a(), i, paramInt, paramString, paramBoolean);
    takeSnapshot();
    setModified(true);
  }

  private void a(List paramList, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (!(paramList.get(paramInt1) instanceof IBusinessObjectEditen))
      return;
    IBusinessObjectEditen localIBusinessObjectEditen1 = (IBusinessObjectEditen)paramList.get(paramInt1);
    paramList.remove(paramInt1);
    for (int i = 0; (i < paramInt1) && ((paramList.get(i) instanceof IBusinessObjectEditen)); i++)
    {
      IBusinessObjectEditen localIBusinessObjectEditen2 = (IBusinessObjectEditen)paramList.get(i);
      if (!a(localIBusinessObjectEditen2.getStringPos(paramInt2), localIBusinessObjectEditen1.getStringPos(paramInt2), paramString, paramBoolean))
        continue;
      paramList.add(i, localIBusinessObjectEditen1);
      return;
    }
    paramList.add(paramInt1, localIBusinessObjectEditen1);
  }

  private boolean a(Object paramObject1, Object paramObject2, String paramString, boolean paramBoolean)
  {
    if (paramString == null)
      paramString = "string";
    String str1 = "";
    if (paramObject1 != null)
      str1 = paramObject1.toString();
    String str2 = "";
    if (paramObject2 != null)
      str2 = paramObject2.toString();
    if ((paramString.equalsIgnoreCase("int")) || (paramString.equalsIgnoreCase("double")) || (paramString.equalsIgnoreCase("float")) || (paramString.equalsIgnoreCase("long")))
    {
      if ((paramBoolean) && (Double.parseDouble(str1) > Double.parseDouble(str2)))
        return true;
      return (!paramBoolean) && (Double.parseDouble(str1) < Double.parseDouble(str2));
    }
    if ((paramString.equalsIgnoreCase("date")) || (paramString.equalsIgnoreCase("datetime")) || (paramString.equalsIgnoreCase("time")))
      try
      {
        if ((paramBoolean) && (Property.getInstance().parseDate(str1).after(Property.getInstance().parseDate(str2))))
          return true;
        return (!paramBoolean) && (Property.getInstance().parseDate(str1).before(Property.getInstance().parseDate(str2)));
      }
      catch (ParseException localParseException)
      {
      }
    if ((paramBoolean) && (a_(str1, str2)))
      return true;
    return (!paramBoolean) && (!a_(str1, str2));
  }

  protected boolean a_(String paramString1, String paramString2)
  {
    return paramString1.compareTo(paramString2) > 0;
  }

  public boolean canCreateEditen()
  {
    return true;
  }

  public Iterator getBusinessObjects(String paramString)
  {
    return getAcceptChildren(new a(this, paramString));
  }

  public void replaceVariables(List paramList1, List paramList2, List paramList3, List paramList4)
  {
  }

  public Envionment getEnvionment()
  {
    for (Object localObject = this; (localObject != null) && (!(localObject instanceof Envionment)); localObject = ((IElement)localObject).getParent());
    if ((localObject != null) && ((localObject instanceof Envionment)))
      return (Envionment)localObject;
    return (Envionment)null;
  }

  public void setModified(boolean paramBoolean)
  {
    super.setModified(paramBoolean);
    if ((paramBoolean) && (getEnvionment() != null))
      getEnvionment().setModified(true);
  }

  public void addChildElement(IElement paramIElement, int paramInt)
  {
    super.addChildElement(paramIElement, paramInt);
    if (((paramIElement instanceof IBusinessObject)) || ((paramIElement instanceof IBusinessObjectContainer)))
    {
      Envionment localEnvionment = getEnvionment();
      if (localEnvionment != null)
      {
        Iterator localIterator = paramIElement.getAcceptElements(new b(this));
        while (localIterator.hasNext())
          localEnvionment.registBusinessObject((IBusinessObject)localIterator.next());
        if ((paramIElement instanceof IBusinessObject))
          localEnvionment.registBusinessObject((IBusinessObject)paramIElement);
      }
    }
  }

  public void clearAllChildren()
  {
    Envionment localEnvionment = getEnvionment();
    if (localEnvionment != null)
    {
      Iterator localIterator = getAcceptElements(new c(this));
      while (localIterator.hasNext())
        localEnvionment.unregistBusinessObject((IBusinessObject)localIterator.next());
    }
    super.clearAllChildren();
  }

  public void removeChildElement(IElement paramIElement)
  {
    if (((paramIElement instanceof IBusinessObject)) || ((paramIElement instanceof IBusinessObjectContainer)))
    {
      Envionment localEnvionment = getEnvionment();
      if (localEnvionment != null)
      {
        Iterator localIterator = paramIElement.getAcceptElements(new d(this));
        while (localIterator.hasNext())
          localEnvionment.unregistBusinessObject((IBusinessObject)localIterator.next());
        if ((paramIElement instanceof IBusinessObject))
          localEnvionment.unregistBusinessObject((IBusinessObject)paramIElement);
      }
    }
    super.removeChildElement(paramIElement);
  }

  public void removeElement(int paramInt)
  {
    IElement localIElement = getElement(paramInt);
    if (((localIElement instanceof IBusinessObject)) || ((localIElement instanceof IBusinessObjectContainer)))
    {
      Envionment localEnvionment = getEnvionment();
      if (localEnvionment != null)
      {
        Iterator localIterator = localIElement.getAcceptElements(new e(this));
        while (localIterator.hasNext())
          localEnvionment.unregistBusinessObject((IBusinessObject)localIterator.next());
        if ((localIElement instanceof IBusinessObject))
          localEnvionment.unregistBusinessObject((IBusinessObject)localIElement);
      }
    }
    super.removeElement(paramInt);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.AbstractBOContainer
 * JD-Core Version:    0.6.0
 */